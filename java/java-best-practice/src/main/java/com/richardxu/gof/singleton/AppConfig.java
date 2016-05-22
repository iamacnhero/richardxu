package com.richardxu.gof.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	private static AppConfig instance = new AppConfig();

	private String parameterA;
	private String parameterB;
	
	/**
	 * 私有化构造方法
	 */
	private AppConfig() {
		readConfig();
	}
	
	public static AppConfig getInstance() {
		return instance;
	}
	
	public String getParameterA() {
		return parameterA;
	}

	public String getParameterB() {
		return parameterB;
	}
	
	private void readConfig() {
		Properties p = new Properties();
		InputStream input = null;
		try {
			input = AppConfig.class.getResourceAsStream("/org/appConfig.properties");
			p.load(input);
			this.parameterA = p.getProperty("paramA");
			this.parameterB = p.getProperty("paramB");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
