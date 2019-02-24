package com.bl.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

    /**
     * 管理员标识
     */
    static private String USER_ID = null;
    /**
     * 管理员帐号
     */
    static private String USER_ACCOUNT = null;
    /**
     * 管理员密码
     */
    static private String USER_PASSWORD = null;
    /**
     * 管理员名字
     */
    static private String USERNAME = null;
    /**
     * 微信小程序的AppId
     */
    static private String APP_ID = null;
    /**
     * 微信小程序的app corpSecret
     */
    static private String SECRET = null;

    static {
        loads();
    }

    synchronized static public void loads() {
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStreamReader in = null;
        try {
        in = new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"), "utf-8");
            // 使用properties对象加载输入流
            properties.load(in);
            //获取key对应的value值
            USER_ID = properties.getProperty("userId");
            USER_ACCOUNT = properties.getProperty("userAccount");
            USER_PASSWORD = properties.getProperty("userPassword");
            USERNAME = properties.getProperty("userName");
            APP_ID = properties.getProperty("AppId");
            SECRET = properties.getProperty("SECRET");
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
    }

    public static String getUserId() {
        if (USER_ID == null)
            loads();
        return USER_ID;
    }

    public static String getUserAccount() {
        if (USER_ACCOUNT == null)
            loads();
        return USER_ACCOUNT;
    }

    public static String getUserPassword() {
        if (USER_PASSWORD == null)
            loads();
        return USER_PASSWORD;
    }

    public static String getUserName() {
        if (USERNAME == null)
            loads();
        return USERNAME;
    }

    public static String getAppId() {
        if (APP_ID == null)
            loads();
        return APP_ID;
    }

    public static String getSecret() {
        if (SECRET == null)
            loads();
        return SECRET;
    }
}
