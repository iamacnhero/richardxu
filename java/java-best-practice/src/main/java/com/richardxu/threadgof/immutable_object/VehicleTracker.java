package com.richardxu.threadgof.immutable_object;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 更新车辆信息
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月7日
 */
public class VehicleTracker {
	private Map<String, ImmutableLocation> locMap = new ConcurrentHashMap<String, ImmutableLocation>();

	public void updateLocation(String vehicleId, ImmutableLocation newLocation) {
		locMap.put(vehicleId, newLocation);
	}
}
