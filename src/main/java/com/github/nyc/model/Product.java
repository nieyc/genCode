package com.github.nyc.model;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:58 2018/5/4
 * @Description
 **/
public class Product {
    private String url;
    private String name;

    // As per the JavaBeans spec., this defines the "url" bean property
    // It must be public!
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // As per the JavaBean spec., this defines the "name" bean property
    // It must be public!
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
