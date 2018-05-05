package com.github.nyc.util;

import com.github.nyc.model.ColumnClass;
import com.github.nyc.util.AppUtil;
import com.github.nyc.util.DbUtil;
import com.github.nyc.util.FreeMakerUtil;
import com.github.nyc.util.genUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:51 2018/5/4
 * @Description :代码生成器
 **/
public class CodeGenerateUtils {

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Map<String,Object> dataMap = new HashMap<>();

    private final String AUTHOR = AppUtil.configMap.get("author");
    private final String CURRENT_DATE = sdf.format(new Date());
    private final String tableName = AppUtil.configMap.get("tableName");
    private final String packageName = AppUtil.configMap.get("packageName");
    private final String tableAnnotation =AppUtil.configMap.get("tableAnnotation");
    private final String diskPath = AppUtil.configMap.get("diskPath");
    private final String changeTableName = genUtil.replaceUnderLineAndUpperCase(tableName);




    public void generate() throws Exception{
        try {
            Connection connection = DbUtil.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getColumns(null,"%", tableName,"%");
            setData(resultSet);
            //生成Model文件
            generateModelFile(resultSet);
            generateMapperFile(resultSet);
            generateDaoFile(resultSet);
            generatSeiFile(resultSet);
            generatSeiviceImplFile(resultSet);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{

        }
    }

    private  void setData(ResultSet resultSet)throws Exception{
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        while(resultSet.next()){
            //id字段略过
            //if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(genUtil.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }
        // Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column",columnClassList);
    }
    private void generateModelFile(ResultSet resultSet) throws Exception{

        final String suffix = ".java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Model.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }


    private void generateMapperFile(ResultSet resultSet) throws Exception{
        final String suffix = ".sqlMap.xml";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "sqlMap.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateDaoFile(ResultSet resultSet) throws Exception{
        final String suffix = ".java";
        final String path = diskPath + changeTableName +"Dao"+suffix;
        final String templateName = "Dao.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generatSeiFile(ResultSet resultSet) throws Exception{
        final String suffix = ".java";
        final String path = diskPath + "I"+changeTableName +"Sevice"+suffix;
        final String templateName = "Service.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generatSeiviceImplFile(ResultSet resultSet) throws Exception{
        final String suffix = ".java";
        final String path = diskPath +changeTableName +"SeviceImpl"+suffix;
        final String templateName = "ServiceImpl.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    private void generateFileByTemplate(final String templateName,File file,Map<String,Object> dataMap) throws Exception{
        Configuration cfg= FreeMakerUtil.getInstance("C:\\workspace\\genCode\\src\\main\\templates");
        Template template=  cfg.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small",tableName);
        dataMap.put("table_name",changeTableName);
        dataMap.put("table_name_obj",genUtil.toLowerCaseFirstOne(changeTableName));
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        dataMap.put("package_name",packageName);
        dataMap.put("table_annotation", new String(tableAnnotation.getBytes("ISO8859-1"),"GBK"));
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }






}
