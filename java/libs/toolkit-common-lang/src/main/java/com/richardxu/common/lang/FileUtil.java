/**
 * 
 */
package com.richardxu.common.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.StringTokenizer;

import com.richardxu.common.lang.exception.ChainedRuntimeException;

/**
 * 有关<code>File</code>处理的工具类。 FIXME
 * 
 * <p>
 * 这个类中的每个方法都可以“安全”地处理 <code>null</code> ，而不会抛出
 * <code>NullPointerException</code>。
 * </p>
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * @version create on 2011-5-18 下午02:46:47
 */
public class FileUtil {

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 常量和singleton。 */
	/*
	 * ==========================================================================
	 * ==
	 */
	private static final char COLON_CHAR = ':';
	private static final String UNC_PREFIX = "//";
	private static final String SLASH = "/";
	private static final char SLASH_CHAR = '/';
	private static final char BACKSLASH_CHAR = '\\';
	private static final String ALL_SLASH = "/\\";

	/** 后缀分隔符。 */
	public static final String EXTENSION_SEPARATOR = ".";

	/** 当前目录记号："." */
	public static final String CURRENT_DIR = ".";

	/** 上级目录记号：".." */
	public static final String UP_LEVEL_DIR = "..";

	private FileUtil() {

	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 规格化路径。 */
	/*                                                                              */
	/* 去除'.'和'..'，支持windows路径和UNC路径。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 规格化路径。
	 * 
	 * <p>
	 * 该方法忽略操作系统的类型，并是返回以“<code>/</code>”开始的绝对路径。转换规则如下：
	 * 
	 * <ol>
	 * <li>
	 * 路径为<code>null</code>，则返回<code>null</code>。</li>
	 * <li>
	 * 将所有backslash("\\")转化成slash("/")。</li>
	 * <li>
	 * 去除重复的"/"或"\\"。</li>
	 * <li>
	 * 去除"."，如果发现".."，则向上朔一级目录。</li>
	 * <li>
	 * 空路径返回"/"。</li>
	 * <li>
	 * 保留路径末尾的"/"（如果有的话）。</li>
	 * <li>
	 * 对于绝对路径，如果".."上朔的路径超过了根目录，则看作非法路径，返回<code>null</code>。</li>
	 * </ol>
	 * </p>
	 * 
	 * @param path
	 *            要规格化的路径
	 * 
	 * @return 规格化后的路径，如果路径非法，则返回<code>null</code>
	 */
	public static String normalizeAbsolutePath(String path) {
		String normalizedPath = normalizePath(path, false);

		if ((normalizedPath != null) && !normalizedPath.startsWith(SLASH)) {
			if (normalizedPath.equals(CURRENT_DIR)
					|| normalizedPath.equals(CURRENT_DIR + SLASH_CHAR)) {
				normalizedPath = SLASH;
			} else if (normalizedPath.startsWith(UP_LEVEL_DIR)) {
				normalizedPath = null;
			} else {
				normalizedPath = SLASH_CHAR + normalizedPath;
			}
		}

		return normalizedPath;
	}

	/**
	 * 规格化路径。
	 * 
	 * <p>
	 * 该方法自动判别操作系统的类型。转换规则如下：
	 * 
	 * <ol>
	 * <li>
	 * 路径为<code>null</code>，则返回<code>null</code>。</li>
	 * <li>
	 * 将所有backslash("\\")转化成slash("/")。</li>
	 * <li>
	 * 去除重复的"/"或"\\"。</li>
	 * <li>
	 * 去除"."，如果发现".."，则向上朔一级目录。</li>
	 * <li>
	 * 空绝对路径返回"/"，空相对路径返回"./"。</li>
	 * <li>
	 * 保留路径末尾的"/"（如果有的话）。</li>
	 * <li>
	 * 对于绝对路径，如果".."上朔的路径超过了根目录，则看作非法路径，返回<code>null</code>。</li>
	 * <li>
	 * 对于Windows系统，有些路径有特殊的前缀，如驱动器名"c:"和UNC名"//hostname"，对于这些路径，保留其前缀，
	 * 并对其后的路径部分适用上述所有规则。</li>
	 * <li>
	 * Windows驱动器名被转换成大写，如"c:"转换成"C:"。</li>
	 * </ol>
	 * </p>
	 * 
	 * @param path
	 *            要规格化的路径
	 * 
	 * @return 规格化后的路径，如果路径非法，则返回<code>null</code>
	 */
	public static String normalizePath(String path) {
		return normalizePath(path, SystemUtil.getOsInfo().isWindows());
	}

	/**
	 * 规格化路径。规则如下：
	 * 
	 * <ol>
	 * <li>
	 * 路径为<code>null</code>，则返回<code>null</code>。</li>
	 * <li>
	 * 将所有backslash("\\")转化成slash("/")。</li>
	 * <li>
	 * 去除重复的"/"或"\\"。</li>
	 * <li>
	 * 去除"."，如果发现".."，则向上朔一级目录。</li>
	 * <li>
	 * 空绝对路径返回"/"，空相对路径返回"./"。</li>
	 * <li>
	 * 保留路径末尾的"/"（如果有的话）。</li>
	 * <li>
	 * 对于绝对路径，如果".."上朔的路径超过了根目录，则看作非法路径，返回<code>null</code>。</li>
	 * <li>
	 * 对于Windows系统，有些路径有特殊的前缀，如驱动器名"c:"和UNC名"//hostname"，对于这些路径，保留其前缀，
	 * 并对其后的路径部分适用上述所有规则。</li>
	 * <li>
	 * Windows驱动器名被转换成大写，如"c:"转换成"C:"。</li>
	 * </ol>
	 * 
	 * 
	 * @param path
	 *            要规格化的路径
	 * 
	 * @return 规格化后的路径，如果路径非法，则返回<code>null</code>
	 */
	public static String normalizeWindowsPath(String path) {
		return normalizePath(path, true);
	}

	/**
	 * 规格化Unix风格的路径，不支持Windows驱动器名和UNC路径。
	 * 
	 * <p>
	 * 转换规则如下：
	 * 
	 * <ol>
	 * <li>
	 * 路径为<code>null</code>，则返回<code>null</code>。</li>
	 * <li>
	 * 将所有backslash("\\")转化成slash("/")。</li>
	 * <li>
	 * 去除重复的"/"或"\\"。</li>
	 * <li>
	 * 去除"."，如果发现".."，则向上朔一级目录。</li>
	 * <li>
	 * 空绝对路径返回"/"，空相对路径返回"./"。</li>
	 * <li>
	 * 保留路径末尾的"/"（如果有的话）。</li>
	 * <li>
	 * 对于绝对路径，如果".."上朔的路径超过了根目录，则看作非法路径，返回<code>null</code>。</li>
	 * </ol>
	 * </p>
	 * 
	 * @param path
	 *            要规格化的路径
	 * 
	 * @return 规格化后的路径，如果路径非法，则返回<code>null</code>
	 */
	public static String normalizeUnixPath(String path) {
		return normalizePath(path, false);
	}

	/**
	 * 规格化路径。规则如下：
	 * 
	 * <ol>
	 * <li>
	 * 路径为<code>null</code>，则返回<code>null</code>。</li>
	 * <li>
	 * 将所有backslash("\\")转化成slash("/")。</li>
	 * <li>
	 * 去除重复的"/"或"\\"。</li>
	 * <li>
	 * 去除"."，如果发现".."，则向上朔一级目录。</li>
	 * <li>
	 * 空绝对路径返回"/"，空相对路径返回"./"。</li>
	 * <li>
	 * 保留路径末尾的"/"（如果有的话）。</li>
	 * <li>
	 * 对于绝对路径，如果".."上朔的路径超过了根目录，则看作非法路径，返回<code>null</code>。</li>
	 * <li>
	 * 对于Windows系统，有些路径有特殊的前缀，如驱动器名"c:"和UNC名"//hostname"，对于这些路径，保留其前缀，
	 * 并对其后的路径部分适用上述所有规则。</li>
	 * <li>
	 * Windows驱动器名被转换成大写，如"c:"转换成"C:"。</li>
	 * </ol>
	 * 
	 * 
	 * @param path
	 *            要规格化的路径
	 * @param isWindows
	 *            是否是windows路径，如果为<code>true</code>，则支持驱动器名和UNC路径
	 * 
	 * @return 规格化后的路径，如果路径非法，则返回<code>null</code>
	 */
	private static String normalizePath(String path, boolean isWindows) {
		if (path == null) {
			return null;
		}

		path = path.trim();

		// 将"\\"转换成"/"，以便统一处理
		path = path.replace(BACKSLASH_CHAR, SLASH_CHAR);

		// 取得系统特定的路径前缀，对于windows系统，可能是："C:"或是"//hostname"
		String prefix = getSystemDependentPrefix(path, isWindows);

		if (prefix == null) {
			return null;
		}

		path = path.substring(prefix.length());

		// 对于绝对路径，prefix必须以"/"结尾，反之，绝对路径的prefix.length > 0
		if ((prefix.length() > 0) || path.startsWith(SLASH)) {
			prefix += SLASH_CHAR;
		}

		// 保留path尾部的"/"
		boolean endsWithSlash = path.endsWith(SLASH);

		// 压缩路径中的"."和".."
		StringTokenizer tokenizer = new StringTokenizer(path, "/");
		StringBuilder builder = new StringBuilder(prefix.length()
				+ path.length());
		int level = 0;

		builder.append(prefix);

		while (tokenizer.hasMoreTokens()) {
			String element = tokenizer.nextToken();

			// 忽略"."
			if (CURRENT_DIR.equals(element)) {
				continue;
			}

			// 回朔".."
			if (UP_LEVEL_DIR.equals(element)) {
				if (level == 0) {
					// 如果prefix存在，并且试图越过最上层目录，这是不可能的，
					// 返回null，表示路径非法。
					if (prefix.length() > 0) {
						return null;
					}

					builder.append(UP_LEVEL_DIR).append(SLASH_CHAR);
				} else {
					level--;

					boolean found = false;

					for (int i = builder.length() - 2; i >= prefix.length(); i--) {
						if (builder.charAt(i) == SLASH_CHAR) {
							builder.setLength(i + 1);
							found = true;
							break;
						}
					}

					if (!found) {
						builder.setLength(prefix.length());
					}
				}

				continue;
			}

			// 添加到path
			builder.append(element).append(SLASH_CHAR);
			level++;
		}

		// 如果是空的路径，则设置为"./"
		if (builder.length() == 0) {
			builder.append(CURRENT_DIR).append(SLASH_CHAR);
		}

		// 保留最后的"/"
		if (!endsWithSlash && (builder.length() > prefix.length())
				&& (builder.charAt(builder.length() - 1) == SLASH_CHAR)) {
			builder.setLength(builder.length() - 1);
		}

		return builder.toString();
	}

	/**
	 * 取得和系统相关的文件名前缀。对于Windows系统，可能是驱动器名或UNC路径前缀"//hostname"。如果不存在前缀，则返回空字符串。
	 * 
	 * @param path
	 *            绝对路径
	 * @param isWindows
	 *            是否为windows系统
	 * 
	 * @return 和系统相关的文件名前缀，如果路径非法，例如："//"，则返回<code>null</code>
	 */
	private static String getSystemDependentPrefix(String path,
			boolean isWindows) {
		if (isWindows) {
			// 判断UNC路径
			if (path.startsWith(UNC_PREFIX)) {
				// 非法UNC路径："//"
				if (path.length() == UNC_PREFIX.length()) {
					return null;
				}

				// 假设路径为//hostname/subpath，返回//hostname
				int index = path.indexOf(SLASH, UNC_PREFIX.length());

				if (index != -1) {
					return path.substring(0, index);
				} else {
					return path;
				}
			}

			// 判断Windows绝对路径："c:/..."
			if ((path.length() > 1) && (path.charAt(1) == COLON_CHAR)) {
				return path.substring(0, 2).toUpperCase();
			}
		}

		return "";
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 取得基于指定basedir规格化路径。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 如果指定路径已经是绝对路径，则规格化后直接返回之，否则取得基于指定basedir的规格化路径。
	 * 
	 * <p>
	 * 该方法自动判定操作系统的类型，如果是windows系统，则支持UNC路径和驱动器名。
	 * </p>
	 * 
	 * @param basedir
	 *            根目录，如果<code>path</code>为相对路径，表示基于此目录
	 * @param path
	 *            要检查的路径
	 * 
	 * @return 规格化的路径，如果<code>path</code>非法，或<code>basedir</code>为
	 *         <code>null</code>，则返回<code>null</code>
	 */
	public static String getPathBasedOn(String basedir, String path) {
		return getPathBasedOn(basedir, path, SystemUtil.getOsInfo().isWindows());
	}

	/**
	 * 如果指定路径已经是绝对路径，则规格化后直接返回之，否则取得基于指定basedir的规格化路径。
	 * 
	 * @param basedir
	 *            根目录，如果<code>path</code>为相对路径，表示基于此目录
	 * @param path
	 *            要检查的路径
	 * 
	 * @return 规格化的路径，如果<code>path</code>非法，或<code>basedir</code>为
	 *         <code>null</code>，则返回<code>null</code>
	 */
	public static String getWindowsPathBasedOn(String basedir, String path) {
		return getPathBasedOn(basedir, path, true);
	}

	/**
	 * 如果指定路径已经是绝对路径，则规格化后直接返回之，否则取得基于指定basedir的规格化路径。
	 * 
	 * @param basedir
	 *            根目录，如果<code>path</code>为相对路径，表示基于此目录
	 * @param path
	 *            要检查的路径
	 * 
	 * @return 规格化的路径，如果<code>path</code>非法，或<code>basedir</code>为
	 *         <code>null</code>，则返回<code>null</code>
	 */
	public static String getUnixPathBasedOn(String basedir, String path) {
		return getPathBasedOn(basedir, path, false);
	}

	/**
	 * 如果指定路径已经是绝对路径，则规格化后直接返回之，否则取得基于指定basedir的规格化路径。
	 * 
	 * @param basedir
	 *            根目录，如果<code>path</code>为相对路径，表示基于此目录
	 * @param path
	 *            要检查的路径
	 * @param isWindows
	 *            是否是windows路径，如果为<code>true</code>，则支持驱动器名和UNC路径
	 * 
	 * @return 规格化的路径，如果<code>path</code>非法，或<code>basedir</code>为
	 *         <code>null</code>，则返回<code>null</code>
	 */
	private static String getPathBasedOn(String basedir, String path,
			boolean isWindows) {
		/*
		 * ------------------------------------------- * 首先取得path的前缀，判断是否为绝对路径。
		 * * 如果已经是绝对路径，则调用normalize后返回。 *
		 * -------------------------------------------
		 */
		if (path == null) {
			return null;
		}

		path = path.trim();

		// 将"\\"转换成"/"，以便统一处理
		path = path.replace(BACKSLASH_CHAR, SLASH_CHAR);

		// 取得系统特定的路径前缀，对于windows系统，可能是："C:"或是"//hostname"
		String prefix = getSystemDependentPrefix(path, isWindows);

		if (prefix == null) {
			return null;
		}

		// 如果是绝对路径，则直接返回
		if ((prefix.length() > 0)
				|| ((path.length() > prefix.length()) && (path.charAt(prefix
						.length()) == SLASH_CHAR))) {
			return normalizePath(path, isWindows);
		}

		/*
		 * ------------------------------------------- * 现在已经确定path是相对路径了，因此我们要
		 * * 将它和basedir合并。 * -------------------------------------------
		 */
		if (basedir == null) {
			return null;
		}

		StringBuilder builder = new StringBuilder();

		builder.append(basedir.trim());

		// 防止重复的"/"，否则容易和UNC prefix混淆
		if ((basedir.length() > 0) && (path.length() > 0)
				&& (basedir.charAt(basedir.length() - 1) != SLASH_CHAR)) {
			builder.append(SLASH_CHAR);
		}

		builder.append(path);

		return normalizePath(builder.toString(), isWindows);
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 取得相对于指定basedir相对路径。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 取得相对于指定根目录的相对路径。
	 * 
	 * <p>
	 * 该方法自动判定操作系统的类型，如果是windows系统，则支持UNC路径和驱动器名。
	 * </p>
	 * 
	 * @param basedir
	 *            根目录
	 * @param path
	 *            要计算的路径
	 * 
	 * @return 如果<code>path</code>和<code>basedir</code>是兼容的，则返回相对于
	 *         <code>basedir</code>的相对路径，否则返回<code>path</code>本身。如果
	 *         <code>basedir</code>不是绝对路径，或者路径非法，则返回<code>null</code>
	 */
	public static String getRelativePath(String basedir, String path) {
		return getRelativePath(basedir, path, SystemUtil.getOsInfo()
				.isWindows());
	}

	/**
	 * 取得相对于指定根目录的相对路径。
	 * 
	 * @param basedir
	 *            根目录
	 * @param path
	 *            要计算的路径
	 * 
	 * @return 如果<code>path</code>和<code>basedir</code>是兼容的，则返回相对于
	 *         <code>basedir</code>的相对路径，否则返回<code>path</code>本身。如果
	 *         <code>basedir</code>不是绝对路径，或者路径非法，则返回<code>null</code>
	 */
	public static String getWindowsRelativePath(String basedir, String path) {
		return getRelativePath(basedir, path, true);
	}

	/**
	 * 取得相对于指定根目录的相对路径。
	 * 
	 * @param basedir
	 *            根目录
	 * @param path
	 *            要计算的路径
	 * 
	 * @return 如果<code>path</code>和<code>basedir</code>是兼容的，则返回相对于
	 *         <code>basedir</code>的相对路径，否则返回<code>path</code>本身。如果
	 *         <code>basedir</code>不是绝对路径，或者路径非法，则返回<code>null</code>
	 */
	public static String getUnixRelativePath(String basedir, String path) {
		return getRelativePath(basedir, path, false);
	}

	/**
	 * 取得相对于指定根目录的相对路径。
	 * 
	 * @param basedir
	 *            根目录
	 * @param path
	 *            要计算的路径
	 * @param isWindows
	 *            是否是windows路径，如果为<code>true</code>，则支持驱动器名和UNC路径
	 * 
	 * @return 如果<code>path</code>和<code>basedir</code>是兼容的，则返回相对于
	 *         <code>basedir</code>的相对路径，否则返回<code>path</code>本身。如果
	 *         <code>basedir</code>不是绝对路径，或者路径非法，则返回<code>null</code>
	 */
	private static String getRelativePath(String basedir, String path,
			boolean isWindows) {
		// 取得规格化的basedir，确保其为绝对路径
		basedir = normalizePath(basedir, isWindows);

		if (basedir == null) {
			return null;
		}

		String basePrefix = getSystemDependentPrefix(basedir, isWindows);

		if ((basePrefix == null)
				|| ((basePrefix.length() == 0) && !basedir.startsWith(SLASH))) {
			return null; // basedir必须是绝对路径
		}

		// 取得规格化的path
		path = getPathBasedOn(basedir, path, isWindows);

		if (path == null) {
			return null;
		}

		String prefix = getSystemDependentPrefix(path, isWindows);

		// 如果path和basedir的前缀不同，则不能转换成相对于basedir的相对路径。
		// 直接返回规格化的path即可。
		if (!basePrefix.equals(prefix)) {
			return path;
		}

		// 保留path尾部的"/"
		boolean endsWithSlash = path.endsWith(SLASH);

		// 按"/"分隔basedir和path
		String[] baseParts = StringUtil.split(
				basedir.substring(basePrefix.length()), SLASH_CHAR);
		String[] parts = StringUtil.split(path.substring(prefix.length()),
				SLASH_CHAR);
		StringBuilder builder = new StringBuilder();
		int i = 0;

		if (isWindows) {
			while ((i < baseParts.length) && (i < parts.length)
					&& baseParts[i].equalsIgnoreCase(parts[i])) {
				i++;
			}
		} else {
			while ((i < baseParts.length) && (i < parts.length)
					&& baseParts[i].equals(parts[i])) {
				i++;
			}
		}

		if ((i < baseParts.length) && (i < parts.length)) {
			for (int j = i; j < baseParts.length; j++) {
				builder.append(UP_LEVEL_DIR).append(SLASH_CHAR);
			}
		}

		for (; i < parts.length; i++) {
			builder.append(parts[i]);

			if (i < (parts.length - 1)) {
				builder.append(SLASH_CHAR);
			}
		}

		if (builder.length() == 0) {
			builder.append(CURRENT_DIR);
		}

		String relpath = builder.toString();

		if (endsWithSlash && !relpath.endsWith(SLASH)) {
			relpath += SLASH;
		}

		return relpath;
	}

	/**
	 * 从URL中取得文件。
	 * 
	 * @param url
	 *            URL
	 * 
	 * @return 文件, 如果URL为空，或不代表一个文件, 则返回<code>null</code>
	 */
	public static File toFile(URL url) {
		if (url == null) {
			return null;
		}

		if (url.getProtocol().equals("file")) {
			String path = url.getPath();

			if (path != null) {
				return new File(StringEscapeUtil.unescapeURL(path));
			}
		}

		return null;
	}

	/**
	 * 取得指定路径的名称和后缀。 返回值为长度为2的数组：
	 * 
	 * <ol>
	 * <li>
	 * 第一个元素为不包含后缀的路径，总不为<code>null</code>。</li>
	 * <li>
	 * 第二个元素为后缀，如果后缀不存在，则为<code>null</code>。</li>
	 * </ol>
	 * 
	 * 
	 * @param path
	 *            路径
	 * 
	 * @return 路径和后缀的数组
	 */
	public static String[] parseExtension(String path) {
		path = StringUtil.trimToEmpty(path);

		String[] parts = { path, null };

		if (StringUtil.isEmpty(path)) {
			return parts;
		}

		// 如果找到后缀，则index >= 0，且extension != null（除非name以.结尾）
		int index = StringUtil.lastIndexOf(path, EXTENSION_SEPARATOR);
		String extension = null;

		if (index >= 0) {
			extension = StringUtil.trimToNull(StringUtil.substring(path,
					index + 1));

			if (!StringUtil.containsNone(extension, ALL_SLASH)) {
				extension = null;
				index = -1;
			}
		}

		if (index >= 0) {
			parts[0] = StringUtil.substring(path, 0, index);
		}

		parts[1] = extension;

		return parts;
	}

	/**
	 * 文件是否存在
	 * 
	 * @param path
	 *            文件路径
	 * @return 如果存在返回<code>true</code>
	 */
	public static boolean exist(String path) {
		File file = new File(path);
		return file.exists();
	}

	/**
	 * 是否存在匹配文件
	 * 
	 * @param directory
	 *            文件夹路径
	 * @param regexp
	 *            文件夹中所包含文件名的正则表达式
	 * @return 如果存在匹配文件返回<code>true</code>
	 */
	public static boolean exist(String directory, String regexp) {
		File file = new File(directory);
		if (!file.exists())
			return false;
		String[] fileList = file.list();
		if (fileList == null)
			return false;
		for (String fileName : fileList) {
			if (fileName.matches(regexp))
				return true;
		}
		return false;
	}

	/**
	 * 刪除文件
	 * 
	 * @param file
	 *            文件
	 * @return 删除成功返回<code>true</code>，否则返回<code>false</code>
	 */
	public static boolean delete(File file) {
		if (file == null)
			return false;
		return file.delete();
	}

	/**
	 * 刪除文件
	 * 
	 * @param path
	 *            文件路径
	 * @return 删除成功返回<code>true</code>，否则返回<code>false</code>
	 */
	public static boolean delete(String path) {
		if (path == null)
			return false;
		File file = new File(path);
		return file.delete();
	}

	/**
	 * 删除文件及子文件
	 * 
	 * @param dir
	 *            文件夹
	 * @return 删除成功返回<code>true</code>，否则返回<code>false</code>
	 */
	public static boolean deleteDir(File dir) {
		if (dir == null)
			return false;
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// The directory is now empty so delete it
		return dir.delete();
	}

	/**
	 * 删除文件及子文件
	 * 
	 * @param path
	 *            文件路径
	 * @return 删除成功返回<code>true</code>，否则返回<code>false</code>
	 */
	public static boolean deleteDir(String path) {
		if (path == null)
			return false;
		File file = new File(path);
		return deleteDir(file);
	}

	/**
	 * 获取资源名对应的文件对象
	 * 
	 * @param resourceName
	 *            要查找的资源名，就是以&quot;/&quot;分隔的标识符字符串
	 * @return 文件, 如果资源找不到, 则返回<code>null</code>
	 */
	public static File getResourcesFile(String resourceName) {
		URL url = ClassLoaderUtil.getResource(resourceName);
		if (url == null)
			return null;
		String filePath = url.getFile();
		return new File(filePath);
	}

	/**
	 * 获取url对应的文件对象
	 * 
	 * @param url
	 * @see URL
	 * @return 文件，如果<code>url<code>为<code>null</code>,则返回<code>null</code>
	 */
	public static File getResourcesFile(URL url) {
		if (url == null)
			return null;
		String filePath = url.getFile();
		return new File(filePath);
	}

	/**
	 * 创建文件，不管文件层级，均可创建
	 * 
	 * @param path
	 *            文件路径
	 * @return 是否创建成功，如果<code>path</code>为空或者<code>path</code>为<code>null</code>
	 *         ,则返回<code>false</code>
	 */
	public static boolean createFile(String path) {
		return createFile(path, false);
	}

	/**
	 * 创建文件，不管文件层级，均可创建
	 * 
	 * @param path
	 *            文件路径
	 * @param override
	 *            是否覆盖
	 * @return 是否创建成功，如果<code>path</code>为空或者<code>path</code>为<code>null</code>
	 *         ,则返回<code>false</code>
	 */
	public static boolean createFile(String path, boolean override) {
		if (StringUtil.isBlank(path))
			return false;
		File file = new File(path);
		if (file.exists() && !override)
			return false;
		if (file.isDirectory())
			return file.mkdirs();
		if (file.getParentFile() != null) {
			file.getParentFile().mkdirs();
		}

		try {
			return file.createNewFile();
		} catch (IOException e) {
			throw new ChainedRuntimeException(e);
		}
	}

	/**
	 * 创建文件夹，不管文件层级，均可创建
	 * 
	 * @param path
	 *            文件路径
	 * @param override
	 *            是否覆盖
	 * @return 是否创建成功，如果<code>path</code>为空或者<code>path</code>为<code>null</code>
	 *         ,则返回<code>false</code>
	 */
	public static boolean createDir(String path, boolean override) {
		if (StringUtil.isBlank(path))
			return false;
		File file = new File(path);
		if (file.exists() && !override)
			return false;
		return file.mkdirs();
	}

	/**
	 * 创建文件夹，不管文件层级，均可创建
	 * 
	 * @param path
	 *            文件路径
	 * @return 是否创建成功，如果<code>path</code>为空或者<code>path</code>为<code>null</code>
	 *         ,则返回<code>false</code>
	 */
	public static boolean createDir(String path) {
		return createDir(path, false);
	}

	/**
	 * 创建文件路径的父文件夹，不管文件层级，均可创建
	 * 
	 * @param path
	 *            文件路径
	 * @return 是否创建成功，如果<code>path</code>为空或者<code>path</code>为<code>null</code>
	 *         ,则返回<code>false</code>
	 */
	public static boolean createParentDir(String path) {
		File file = new File(path);
		return createDir(file.getParent(), false);
	}

	/**
	 * 创建文件路径的父文件夹，不管文件层级，均可创建
	 * 
	 * @param path
	 *            文件路径
	 * @param override
	 *            是否覆盖
	 * @return 是否创建成功，如果<code>path</code>为空或者<code>path</code>为<code>null</code>
	 *         ,则返回<code>false</code>
	 */
	public static boolean createParentDir(String path, boolean override) {
		File file = new File(path);
		return createDir(file.getParent(), override);
	}

	/**
	 * 获取文件大小（字节数）
	 * 
	 * @param fileName
	 *            文件路径
	 * @return 文件大小（字节数），如果文件路径为空或者文件路径不存在 ,
	 *         <p>
	 *         则返回<code>0</code>
	 */
	public static int getFileSize(String fileName) {
		if (StringUtil.isBlank(fileName))
			return 0;
		File file = new File(fileName);
		FileInputStream fis = null;
		try {
			if (file.exists()) {
				fis = new FileInputStream(file);
				return fis.available();
			}
		} catch (FileNotFoundException e) {
			throw new ChainedRuntimeException(e);
		} catch (IOException e) {
			throw new ChainedRuntimeException(e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					throw new ChainedRuntimeException(e);
				}
			}
		}
		return 0;
	}

	public static File createAndReturnFile(String filename) {
		File file = newFile(filename);
		if (file != null && !file.canWrite()) {
			String dirName = file.getPath();
			int i = dirName.lastIndexOf(File.separator);
			if (i > -1) {
				dirName = dirName.substring(0, i);
				File dir = newFile(dirName);
				dir.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new ChainedRuntimeException(e);
			}
		}
		return file;
	}

	public static File newFile(String pathName) {
		if (StringUtil.isBlank(pathName))
			return null;
		try {
			return new File(pathName).getCanonicalFile();
		} catch (IOException e) {
			throw new ChainedRuntimeException(e);
		}

	}

	public static String getClassFilePath(Class<?> clazz) {
		if (clazz == null)
			return null;
		URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
		String filePath = null;
		try {
			filePath = URLDecoder.decode(url.getPath(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new ChainedRuntimeException(e);
		}
		File file = new File(filePath);
		return file.getAbsolutePath();
	}

}
