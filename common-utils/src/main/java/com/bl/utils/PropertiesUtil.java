package com.bl.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties readProperties(String path){
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStreamReader in = null;
        try {
        in = new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(path), "utf-8");
            // 使用properties对象加载输入流
            properties.load(in);
            //获取key对应的value值
//            properties.getProperty("");
        }catch (IOException ex) {
            System.out.println("装载文件--->失败!");
            ex.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
