package com.github.nyc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:40 2018/5/5
 * @Description
 **/
public class DbUtil {

    private static String className = AppUtil.configMap.get("className");
    private static String url = AppUtil.configMap.get("jdbc_url");
    private static String user = AppUtil.configMap.get("user");
    private static String password =AppUtil.configMap.get("password");

    private DbUtil() {
    };

    static {// 调用该类时既注册驱动
        try {
            Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    // 获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
