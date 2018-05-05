package com.github.nyc;

import com.github.nyc.util.AppUtil;
import com.github.nyc.util.CodeGenerateUtils;

/**
 @Author:nieyc
 @Description: 代码生成器入口
 @Date:17:30 2018/5/5
 **/
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "代码生成器版本1.0开始执行" );
        AppUtil.init_value();
        CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
        try {
            codeGenerateUtils.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println( "代码生成器版本1.0执行结束" );
    }
}
