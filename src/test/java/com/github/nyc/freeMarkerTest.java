package com.github.nyc;

import com.github.nyc.util.FreeMakerUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:05 2018/5/4
 * @Description
 **/

public class freeMarkerTest {

    String filePath="C:\\workspace\\genCode\\src\\test\\java\\templates";

    @Test
    public  void createHtml() throws TemplateException {
        Configuration cfg= FreeMakerUtil.getInstance(filePath);
        Template template = null;
        try {
            template = cfg.getTemplate("static.html");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("description", "我正在学习使用Freemarker生成静态文件！");
            List<String> nameList = new ArrayList<String>();
            nameList.add("陈靖仇");
            nameList.add("玉儿");
            nameList.add("宇文拓");
            paramMap.put("nameList", nameList);
            Map<String, Object> weaponMap = new HashMap<String, Object>();
            weaponMap.put("first", "轩辕剑");
            weaponMap.put("second", "崆峒印");
            weaponMap.put("third", "女娲石");
            weaponMap.put("fourth", "神农鼎");
            weaponMap.put("fifth", "伏羲琴");
            weaponMap.put("sixth", "昆仑镜");
            weaponMap.put("seventh", null);
            paramMap.put("weaponMap", weaponMap);
            Writer writer  = new OutputStreamWriter(new FileOutputStream("success.html"),"UTF-8");
            template.process(paramMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("恭喜，生成成功~~");
    }

}
