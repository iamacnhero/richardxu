package com.xufeng.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HttpUtil {
	
	/**
     * 通过IP得到省市信息 - 分析后台接口
     * @param ip
     * @return Map<String, String>
     */
    public static Map<String, String> getRealAddressByIp2(String ip) {
    	Map<String, String> s = new ConcurrentHashMap<String, String>();
		try {
    		URL url = new URL("http://analyze.guang.com/getIP?ip=" + ip);
        	HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        	if (httpConn.getContentLength() != 0) {
        		String result = new BufferedReader(new InputStreamReader(httpConn.getInputStream())).readLine().trim();
        		if (!result.startsWith("-1")) {
        			/*result = new String(result.getBytes(), "UTF-8");*/
            		s.put("province", result.split(",")[0]);
            		s.put("city", result.split(",")[1]);
        		}
        	}	
		} catch (Exception e) {
			
		}
    	return s;
    }
}
