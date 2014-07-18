/**
 * 
 */
package com.richardxu.common.lang;

import org.junit.Test;

import com.richardxu.common.lang.FileUtil;

/**
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2013-5-27 上午11:45:38
 */
public class FileUtilTest {

	@Test
	public void testCreateFile() {
		System.out.println(FileUtil.createFile("/tmp/kkk/test.test"));
	}

}
