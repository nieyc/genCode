package com.github.nyc.util;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:52 2018/5/4
 * @Description
 **/
public class FreeMakerUtil {


    private static Configuration configuration =null;

    private FreeMakerUtil(){

    }

    /**
     @Author:nieyc
     @Description: 返回一个单例对象
     @Date:17:33 2018/5/5
     **/
    public static synchronized Configuration getInstance(String filePath) {
        if(configuration==null) {
            configuration=new Configuration(Configuration.VERSION_2_3_28);
            try {
                configuration.setDirectoryForTemplateLoading(new File(filePath));
                configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                configuration.setDefaultEncoding("UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configuration;
    }


}
