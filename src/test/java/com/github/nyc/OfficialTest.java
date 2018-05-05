package com.github.nyc;

import com.github.nyc.util.FreeMakerUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Product;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:51 2018/5/4
 * @Description:官网例子
 **/
public class OfficialTest {
    String filePath="C:\\workspace\\genCode\\src\\test\\java\\templates";
    @Test
    public void create(){
        Configuration cfg= FreeMakerUtil.getInstance(filePath);
        Template template = null;
        try {
            template = cfg.getTemplate("test.ftlh");
            // Create the root hash. We use a Map here, but it could be a JavaBean too.
            Map<String, Object> root = new HashMap<>();
            // Put string "user" into the root
            root.put("user", "Big Joe");
            // Create the "latestProduct" hash. We use a JavaBean here, but it could be a Map too.
            Product latest = new Product();
            latest.setUrl("products/greenmouse.html");
            latest.setName("green mouse");
            // and put it into the root
            root.put("latestProduct", latest);
            Writer writer  = new OutputStreamWriter(new FileOutputStream("test.html"),"UTF-8");
            template.process(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }
}
