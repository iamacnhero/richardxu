package com.richardxu.threadgof.immutable_object;

/**
 * 处理彩信中心、路由表的变更: 与运维中心对接的类 模式角色：ImmutableObject.Manipulator
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月7日
 */
public class OMCAgent extends Thread {
	public void run() {
		boolean isTableModificationMsg = false;
		String updatedTableName = null;
		while (true) {
			// 省略其他代码
			
			/**
			 * 从与OMC连接的Socket中读取信息并进行解析，
			 * 解析到数据表更新消息后，重置MMSCRouter实例
			 */
			if (isTableModificationMsg) {
				if ("MMSCInfo".equals(updatedTableName)) {
					MMSCRouter.setInstance(new MMSCRouter());
				}
			}
			
			// 省略其他代码
		}
	}
}
