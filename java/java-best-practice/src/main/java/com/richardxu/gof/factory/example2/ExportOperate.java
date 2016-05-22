package com.richardxu.gof.factory.example2;

import com.richardxu.gof.factory.example.ExportDB;
import com.richardxu.gof.factory.example.ExportFileApi;
import com.richardxu.gof.factory.example.ExportTxtFile;
import com.richardxu.gof.factory.example.ExportXml;

/**
 * 实现导出数据的业务功能对象
 *  
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月17日 下午11:20:15
 */
public class ExportOperate {		// 不再是抽象类了
	
	/**
	 * 导出文件
	 * @param type
	 * @param data
	 * @return
	 */
	public boolean export(int type, String data) {		// 传入参数 
		// 使用工厂方法
		ExportFileApi api = factoryMethod(type); 
		return api.export(data);
	}

	/**
	 * 工厂方法，创建导出的文件对象的接口对象
	 * 不再抽象了，要提供默认的实现，根据传入的导出类型来选择已有的实现
	 * @param type
	 * @return
	 */
	private ExportFileApi factoryMethod(int type) {
		ExportFileApi api = null;
		// 根据类型来选择究竟要创建哪一种导出文件对象
		if (type == 1) {
			api = new ExportTxtFile();
		} else if (type == 2) {
			api = new ExportDB();
		} else if (type == 3) {
			api = new ExportXml();
		}
		return api;
	}
	
}
