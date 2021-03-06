/**
 * 
 */
package com.richardxu.common.lang;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

/**
 * @author saga67
 * 
 * @version 2011-11-30 下午5:31:52
 */
public class PackageUtil {

	/**
	 * 空的列表
	 */
	private static final List<String> EMPTY_LIST = Collections.emptyList();
	
	private PackageUtil() {
		
	}

	/**
	 * 获取包中所有资源
	 * 
	 * @param packageName
	 *            包名
	 * @return 包中所有资源文件
	 * @throws IOException
	 */
	public static List<String> getResourceInPackage(String packageName)
			throws IOException {
		if (StringUtil.isBlank(packageName))
			return null;
		boolean recursive = packageName.endsWith(".*");
		String packagePath = getPackagePath(packageName);
		List<String> resources = CollectionUtil.getArrayList();
		String packageDirName = packagePath.replace('.', '/');
		URL[] dirs = ClassLoaderUtil.getResources(packageDirName);
		for (URL url : dirs) {
			String protocol = url.getProtocol();
			if ("file".equals(protocol))
				findResourceInDirPackage(packagePath,
						URLDecoder.decode(url.getFile(), "UTF-8"), resources);
			else if ("jar".equals(protocol))
				findResourceInJarPackage(url, packageName, packageDirName,
						recursive, resources);
		}
		return resources;
	}

	/**
	 * 获取包中的所有类
	 * 
	 * @param packageName
	 * @return 包中所有类
	 * @throws IOException
	 */
	public static List<String> getClassesInPackage(String packageName)
			throws IOException {
		return getClassesInPackage(packageName, null, null);
	}

	/**
	 * 过滤后，获取包中的类
	 * 
	 * @param packageName
	 * @param included
	 *            包含的类列表
	 * @param excluded
	 *            排除的类列表
	 * @return 包中满足条件的类
	 * @throws IOException
	 */
	public static List<String> getClassesInPackage(String packageName,
			List<String> included, List<String> excluded) throws IOException {
		if (StringUtil.isBlank(packageName))
			return null;
		boolean recursive = packageName.endsWith(".*");
		String packagePath = getPackagePath(packageName);
		List<String> classes = CollectionUtil.getArrayList();
		String packageDirName = packagePath.replace('.', '/');
		URL[] dirs = ClassLoaderUtil.getResources(packageDirName);
		for (URL url : dirs) {
			String protocol = url.getProtocol();
			if ("file".equals(protocol)) {
				findClassesInDirPackage(packagePath, included, excluded,
						URLDecoder.decode(url.getFile(), "UTF-8"), recursive,
						classes);
			} else if ("jar".equals(protocol)) {
				findClassesInJarPackage(url, packageName, included, excluded,
						packageDirName, recursive, classes);
			}
		}
		return classes;
	}

	/**
	 * 查找<code>jar</code>中的资源
	 * 
	 * @param url
	 *            资源<code>URL</code>
	 * @param packageName
	 *            包名
	 * @param included
	 *            包含的类列表
	 * @param excluded
	 *            排除的类列表
	 * @param packageDirName
	 *            包的目录名
	 * @param recursive
	 *            是否递归
	 * @param classes
	 *            存储类的资源列表
	 * @throws IOException
	 */
	private static void findClassesInJarPackage(URL url, String packageName,
			List<String> included, List<String> excluded,
			String packageDirName, final boolean recursive, List<String> classes)
			throws IOException {
		JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
		Enumeration<JarEntry> entries = jar.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			String name = entry.getName();
			if (name.charAt(0) == '/')
				name = name.substring(1);
			if (name.startsWith(packageDirName)) {
				int idx = name.lastIndexOf('/');
				if (idx != -1)
					packageName = name.substring(0, idx).replace('/', '.');
				if ((idx != -1) || recursive) {
					// it's not inside a deeper dir
					if (name.endsWith(".class") && !entry.isDirectory()) {
						String className = name.substring(
								packageName.length() + 1, name.length() - 6);
						filterClass(packageName, className, included, excluded,
								classes);
					}
				}
			}
		}
	}

	/**
	 * 查找包中的类
	 * 
	 * @param packageName
	 *            包名
	 * @param included
	 *            包含的类列表
	 * @param excluded
	 *            排除的类列表
	 * @param packagePath
	 *            包路径
	 * @param recursive
	 *            是否递归
	 * @param classes
	 *            存储类的资源列表
	 */
	private static void findClassesInDirPackage(String packageName,
			List<String> included, List<String> excluded, String packagePath,
			final boolean recursive, List<String> classes) {
		File dir = new File(packagePath);
		if (!dir.exists() || !dir.isDirectory())
			return;
		File[] dirfiles = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return (recursive && file.isDirectory())
						|| (file.getName().endsWith(".class"));
			}
		});
		for (File file : dirfiles) {
			if (file.isDirectory())
				findClassesInDirPackage(packageName + "." + file.getName(),
						included, excluded, file.getAbsolutePath(), recursive,
						classes);
			else
				filterClass(packageName,
						file.getName()
								.substring(0, file.getName().length() - 6),
						included, excluded, classes);
		}
	}

	/**
	 * 过滤包中的类
	 * 
	 * @param packageName
	 *            包名
	 * @param className
	 *            类名
	 * @param included
	 *            包含的类列表
	 * @param excluded
	 *            排除的类列表
	 * @param classes
	 *            存储类的列表
	 */
	private static void filterClass(String packageName, String className,
			List<String> included, List<String> excluded, List<String> classes) {
		if (isIncluded(className, included, excluded)) {
			classes.add(packageName + '.' + className);
		}
	}

	/**
	 * 查找<code>jar</code>中的资源
	 * 
	 * @param url
	 *            资源<code>URL</code>
	 * @param packageName
	 *            包名
	 * @param packageDirName
	 *            包目录名
	 * @param recursive
	 *            是否递归
	 * @param resources
	 *            存储资源的列表
	 * @throws IOException
	 */
	private static void findResourceInJarPackage(URL url, String packageName,
			String packageDirName, boolean recursive, List<String> resources)
			throws IOException {
		JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
		Enumeration<JarEntry> entries = jar.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			String name = entry.getName();
			if (name.charAt(0) == '/')
				name = name.substring(1);
			if (name.startsWith(packageDirName)) {
				int idx = name.lastIndexOf('/');
				if (idx != -1)
					packageName = name.substring(0, idx).replace('/', '.');
				if ((idx != -1) || recursive) {
					// it's not inside a deeper dir
					if (!entry.isDirectory())
						resources.add(packageName + "."
								+ name.substring(packageName.length() + 1));
				}
			}
		}
	}

	/**
	 * 查找包中的资源
	 * 
	 * @param packageName
	 *            包名
	 * @param packagePath
	 *            包的路径
	 * @param resources
	 *            存储资源的列表
	 */
	private static void findResourceInDirPackage(String packageName,
			String packagePath, List<String> resources) {
		File dir = new File(packagePath);
		if (!dir.exists() || !dir.isDirectory())
			return;
		File[] dirfiles = dir.listFiles();
		for (File file : dirfiles) {
			if (file.isDirectory())
				findResourceInDirPackage(packageName + "." + file.getName(),
						file.getAbsolutePath(), resources);
			else
				resources.add(packageName + "." + file.getName());
		}
	}

	/**
	 * 获取包路径
	 * 
	 * @param packageName
	 *            包名
	 * @return 包路径
	 */
	private static String getPackagePath(String packageName) {
		if (packageName.endsWith(".*")) {
			packageName = packageName.substring(0,
					packageName.lastIndexOf(".*"));
		}
		if (packageName.endsWith("/")) {
			packageName = packageName.substring(0, packageName.length() - 1);
		}
		return packageName;
	}

	/**
	 * 是否包含名称，如果<code>included</code>和<code>excluded</code>列表均为“空”，返回
	 * <code>true</code>
	 * 
	 * @param name
	 *            需要包含的名称
	 * @param included
	 *            需要验证的包含列表
	 * @param excluded
	 *            不需要验证的排除列表
	 * @return 如果包含则返回<code>true</code>，否则返回<code>false</code>
	 */
	private static boolean isIncluded(String name, List<String> included,
			List<String> excluded) {
		if (CollectionUtil.isEmpty(included)
				&& CollectionUtil.isEmpty(excluded))
			return true;
		included = (null == included) ? EMPTY_LIST : included;
		excluded = (null == excluded) ? EMPTY_LIST : excluded;
		boolean isIncluded = PackageUtil.isMatched(name, included);
		boolean isExcluded = PackageUtil.isMatched(name, excluded);
		if (isIncluded && !isExcluded)
			return true;
		if (isExcluded)
			return false;
		return included.size() == 0;
	}

	/**
	 * 列表中是否匹配存在匹配的名称
	 * 
	 * @param name
	 *            需要匹配的名称
	 * @param list
	 *            名称列表
	 * @return 如果匹配则返回<code>true</code>，否则返回<code>false</code>
	 */
	private static boolean isMatched(String name, List<String> list) {
		for (String regexpStr : list) {
			if (Pattern.matches(regexpStr, name))
				return true;
		}
		return false;
	}

}
