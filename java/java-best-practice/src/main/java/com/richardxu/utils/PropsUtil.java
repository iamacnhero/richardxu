package com.richardxu.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 属性工具类
 */
public class PropsUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);
    
    /**
     * 加载属性文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream input = null;
        try {
            // input = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        	input = PropsUtil.class.getResourceAsStream(fileName);
            if (input == null) {
                throw new FileNotFoundException(fileName + " file is not found.");
            }
            props = new Properties();
            props.load(input);
        } catch (Exception e) {
            logger.error("load properties file failure: ", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error("close input stream failure: ", e);
                }
            }
        }
        return props;
    }
    
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }
    
    /**
     * 获取字符型属性(可指定默认值)
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue; 
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }
    
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

    /**
     * 获取数值型属性
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castInt(props.get(key));
        }
        return value;
    }

    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * 获取数值型属性
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.get(key));
        }
        return value;
    }
    
}
