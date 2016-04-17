package com.richardxu.gof.factory.example;

/**
 * 导出文件对象的接口
 *  
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月17日 下午10:23:45
 */
public interface ExportFileApi {
	/**
	 * 导出内容成为文件
	 * @param data 需要保存的数据
	 * @return 是否导出成功
	 */
	boolean export(String data);
}
