/**
 * 
 */
package com.richardxu.common.lang;

/**
 * @author root
 * 
 */
public final class SecurityUtil {

	private SecurityUtil() {

	}

	/**
	 * 特殊字符替换
	 * 
	 * @param str
	 * @return
	 */
	public static String cleanXSS(String s) {
		if (StringUtil.isBlank(s)) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0,size=s.length(); i < size; i++) {
			char c = s.charAt(i);
			switch (c) {
			case '>':
				sb.append('＞');// 全角大于号
				break;
			case '<':
				sb.append('＜');// 全角小于号
				break;
			case '\'':
				sb.append('‘');// 全角单引号
				break;
			case '\"':
				sb.append('“');// 全角双引号
				break;
			case '/':
				sb.append('／');// 全角
				break;
			case '\\':
				sb.append('＼');// 全角斜线
				break;
			case '&':
				sb.append('＆');// 全角斜线
				break;
			case '?':
				sb.append('？');// 全角斜线
				break;
			case '#':
				sb.append('＃');// 全角井号
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}
}
