package com.richardxu.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 处理异常的消失
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月27日
 */
public class ProcessMisssingException {
	public void read(String filename) throws IOException {
		FileInputStream input = null;
		IOException readException = null;
		try {
			input = new FileInputStream(filename);
		} catch (IOException ex) {
			readException = ex;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException ex) {
					if (readException == null) {
						readException = ex;
					}
				}
			}
			if (readException != null) {
				throw readException;
			}
		}
	}
	
	public void read2(String filename) throws IOException {
		FileInputStream input = null;
		IOException readException = null;
		try {
			input = new FileInputStream(filename);
		} catch (IOException ex) {
			readException = ex;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException ex) {
					if (readException != null) {
						readException.addSuppressed(ex);
					} else {
						readException = ex;
					}
				}
			}
			if (readException != null) {
				throw readException;
			}
		}
	}
}
