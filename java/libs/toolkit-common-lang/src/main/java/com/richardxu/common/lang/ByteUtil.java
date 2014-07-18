/**
 * 
 */
package com.richardxu.common.lang;

import java.util.List;

/**
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-3-16 下午1:28:26
 */
public class ByteUtil {

	private ByteUtil() {

	}

	public static String bytesAsHexString(byte[] bytes, int maxShowBytes) {
		if (bytes == null || maxShowBytes <= 0) {
			return null;
		}
		int idx = 0;
		StringBuilder body = new StringBuilder();
		body.append("bytes size is:[");
		body.append(bytes.length);
		body.append("]\r\n");
		for (byte b : bytes) {
			int hex = ((int) b) & 0xff;
			String shex = Integer.toHexString(hex).toUpperCase();
			if (1 == shex.length()) {
				body.append("0");
			}
			body.append(shex);
			body.append(" ");
			idx++;
			if (16 == idx) {
				body.append("\r\n");
				idx = 0;
			}
			maxShowBytes--;
			if (maxShowBytes <= 0) {
				break;
			}
		}
		if (idx != 0) {
			body.append("\r\n");
		}
		return body.toString();
	}

	public static byte[] union(List<byte[]> byteList) {
		if (CollectionUtil.isEmpty(byteList)) {
			return null;
		}

		int size = 0;
		for (byte[] bs : byteList) {
			size += bs.length;
		}
		byte[] ret = new byte[size];
		int pos = 0;
		for (byte[] bs : byteList) {
			System.arraycopy(bs, 0, ret, pos, bs.length);
			pos += bs.length;
		}
		return ret;
	}

	public static int totalByteSizeOf(List<byte[]> byteList) {
		if (CollectionUtil.isEmpty(byteList)) {
			return 0;
		}

		int len = 0;
		for (byte[] bs : byteList) {
			len += bs.length;
		}
		return len;
	}
}
