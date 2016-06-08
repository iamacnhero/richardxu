package com.richardxu.threadgof.immutable_object;

/**
 * 不可变对象：彩信中心信息
 * 模式角色：ImmutableObject.ImmutableObject
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月7日
 */
public final class MMSCInfo {
	// 设备编号
	private final String deviceID;

	// 彩信中心URL
	private final String url;

	// 彩信中心允许的最大附件大小
	private final int maxAttachmentSizeInBytes;

	public MMSCInfo(String deviceID, String url, int maxAttachmentSizeInBytes) {
		this.deviceID = deviceID;
		this.url = url;
		this.maxAttachmentSizeInBytes = maxAttachmentSizeInBytes;
	}

	public MMSCInfo(MMSCInfo prototype) {
		this.deviceID = prototype.deviceID;
		this.url = prototype.url;
		this.maxAttachmentSizeInBytes = prototype.maxAttachmentSizeInBytes;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public String getUrl() {
		return url;
	}

	public int getMaxAttachmentSizeInBytes() {
		return maxAttachmentSizeInBytes;
	}

}
