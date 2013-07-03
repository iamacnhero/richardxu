package com.xufeng.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	static final String NUMERIC = "^[0-9]*$";

	//匹配url(较完整的匹配所有)
	static final String URL = "\\b((ftp|https?)://[-\\w]+(\\.\\w[-\\w]*)+|(?i:[a-z0-9](?:[-a-z0-9]*[a-z0-9])?\\.)+(?-i:com\\b|edu\\b|biz\\b|gov\\b|in(?:t|fo)\\b|mil\\b|net\\b|org\\b|[a-z][a-z]\\b))(:\\d+)?(/[^.!,?;\"'<>()\\[\\]{}\\s\\x7F-\\xFF]*(?:[.!,?]+[^.!,?;\"'<>()\\[\\]{}\\s\\x7F-\\xFF]+)*)?";
	static final String PHONE = "(\\(\\d{3}\\)|\\d{3,4}-)?\\d{7,8}$";
	static final String MOBILE = "0?1[3584]\\d{9}";
	static final String POSTCODE = "^[0-9]\\d{5}$";
	static final String EMAIL = "^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,4})$";     // 正则表达式，定义邮箱格式
	
	/**
	 * 判断content中存在regex表达(默认Pattern.CASE_INSENSITIVE)的结果
	 * 
	 * @param content
	 * @param regex
	 * @return
	 */
	public static List<String> listExsits(String content, String regex) {
		Pattern p = Pattern.compile(regex, 0);
		Matcher matcher = p.matcher(content);
		List<String> results = new ArrayList<String>();
		String result = null;
		while (matcher.find()) {
			result = matcher.group();
			results.add(result);
		}
		return results;
	}

	/**
	 * 判断content中存在regex表达的结果
	 * 
	 * @param content
	 * @param regex
	 * @param pattern
	 * @return
	 */
	public static List<String> listExsits(String content, String regex, int pattern) {
		Pattern p = Pattern.compile(regex, pattern);
		Matcher matcher = p.matcher(content);
		List<String> results = new ArrayList<String>();
		String result = null;
		while (matcher.find()) {
			result = matcher.group();
			results.add(result);
		}
		return results;
	}

	/**
	 * 判断content中是否存在regex表达(默认Pattern.CASE_INSENSITIVE)
	 * 
	 * @param content
	 * @param regex
	 * @param pattern
	 * @return
	 */
	public static boolean exist(String content, String regex) {
		return exist(content, regex, 0);
	}

	/**
	 * 检查content中是否存在regex表达
	 * 
	 * @param content
	 * @param regex
	 * @param pattern
	 * @return
	 */
	public static boolean exist(String content, String regex, int pattern) {
		if (pattern == 0)
			pattern = Pattern.CASE_INSENSITIVE;
		Pattern p = Pattern.compile(regex, pattern);
		Matcher matcher = p.matcher(content);
		return matcher.find();
	}
	
	/**
	 * 返回content中存在regex表达(默认Pattern.CASE_INSENSITIVE)的数量
	 * 
	 * @param content
	 * @param regex
	 * @return
	 */
	public static int countExsits(String content, String regex) {
		Pattern p = Pattern.compile(regex, 0);
		Matcher matcher = p.matcher(content);
		int result= 0;
		while (matcher.find()) {
			matcher.group();
			result++;
		}
		return result;
	}
	
	/**
	 * 返回content中存在regex表达(默认Pattern.CASE_INSENSITIVE)的数量
	 * 
	 * @param content
	 * @param regex
	 * @return
	 */
	public static int countExsits(List<String> contents, String regex) {
		Pattern p = Pattern.compile(regex, 0);
		Matcher matcher= null;
		int result= 0;
		for (String content : contents) {
			matcher = p.matcher(content);
			if (matcher.find()) 
				result++;
		}
		return result;
	}
	
	/**
	 * 判断列表contents中都存在regex表达
	 * 
	 * @param content
	 * @param regex
	 * @return
	 */
	public static boolean exsitsAll(List<String> contents, String regex) {
		return contents.size() == countExsits(contents, regex);
	}

	/**
	 * 判断注册邮箱是否正确
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkIfValidEmail(String email) {      
		if (email.matches(EMAIL)) {	// 正则表达式，定义邮箱格式
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 根据正则表达式拆分字符串
	 * @param content
	 * @param regex
	 * @return
	 */
	public static String[] regexSplit(String content, String regex) {
		Pattern p = Pattern.compile(regex);
		return p.split(content);
	}
	
	/**
	 * 根据正则表达式拆分字符串
	 * @param content
	 * @return
	 */
	public static String[] regexSplit(String content) {
		String regex = "\\s+";
		Pattern p = Pattern.compile(regex);
		return p.split(content);
	}
	
	/**
	 * 推广网址是否来自淘宝网
	 * @param url
	 * @return
	 */
	public static boolean isTaobaoUrl(String url) {
		String pattern1 = "^(http://)?([a-zA-Z0-9\\.]+?).(taobao.com/|tmall.com/)(.*)";
		String pattern2 = "^(http://)?(www.)?(taobao.com|tmall.com)$";
		
		if (url.matches(pattern1) || url.matches(pattern2)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(RegexUtils.checkIfValidEmail("iamacnhero@gmail.com"));
		ArrayList<String> s = new ArrayList<String>();
		s.add("xuf@iphonele.com");
		s.add("iamacnhero@gmail.com");
		System.out.println(RegexUtils.countExsits(s, RegexUtils.EMAIL));	
		System.out.println(RegexUtils.exist("iamcnhero@gmail.com,xuf@iphonele.com", RegexUtils.EMAIL));
		
		String a = "http://www.taobao.com.ttt.com/item.htm?spm=5133.117242.a2107.18.Hvf0eN&id=22036640734";
		String b = "http://www.taobao.com/item.htm?spm=5133.117242.a2107.18.Hvf0eN&id=22036640734";
		String c = "http://www.taobao.com";
		System.out.println(isTaobaoUrl(a));
		System.out.println(isTaobaoUrl(b));
		System.out.println(isTaobaoUrl(c));
	}
}