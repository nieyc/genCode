package com.github.nyc.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:21 2018/5/5
 * @Description
 **/
public class genUtil {

    /**
     @Author:nieyc
     @Description:去掉下划线，驼峰命名
     @Date:17:32 2018/5/5
     **/
    public static String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }


    /**
     @Author:nieyc
     @Description: 首字母小写
     @Date:17:32 2018/5/5
     **/
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
