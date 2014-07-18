/**
 * 
 */
package com.richardxu.common.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import com.richardxu.common.lang.exception.ChainedRuntimeException;
import com.richardxu.common.lang.io.StreamUtil;

/**
 * 有关虚拟机的工具类。
 * 
 * @author saga67
 * 
 * @version 1.0.0 create on 2011-10-17 上午03:55:26
 */
public abstract class JVMUtil {

	private static final String[] MANIFESTS = { "Manifest.mf", "manifest.mf",
			"MANIFEST.MF" };

	/**
	 * 适用于 JDK 1.6 from JDK DOC "java.lang.instrument Interface Instrumentation"
	 * ... The system class loader supports adding a JAR file to be searched if
	 * it implements a method named appendToClassPathForInstrumentation which
	 * takes a single parameter of type java.lang.String. The method is not
	 * required to have public access. The name of the JAR file is obtained by
	 * invoking the getName() method on the jarfile and this is provided as the
	 * parameter to the appendtoClassPathForInstrumentation method.
	 * 
	 * 将指定文件加载到<code>classpath</code>中
	 * 
	 * @param name
	 *            指定路径
	 * @return 如果加载成功返回<code>true</code>
	 */
	public static boolean appendToClassPath(String name) {
		try {
			ClassLoader clsLoader = ClassLoader.getSystemClassLoader();
			Method appendToClassPathMethod = clsLoader.getClass()
					.getDeclaredMethod("appendToClassPathForInstrumentation",
							String.class);
			if (null != appendToClassPathMethod) {
				appendToClassPathMethod.setAccessible(true);
				appendToClassPathMethod.invoke(clsLoader, name);
			}
			return true;
		} catch (Exception e) {
			throw new ChainedRuntimeException(
					"JVMUtil.appendToClassPath Error", e);
		}
	}

	/**
	 * 将指定路径下的<code>jar</code>文件加载到<code>classpath</code>中
	 * 
	 * @param dirName
	 *            指定路径
	 * @return jar文件路径数组
	 */
	public static String[] addAllJarsToClassPath(String dirName) {
		List<String> ret = new ArrayList<String>();
		File dir = new File(dirName);
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory())
					ret.addAll(Arrays.asList(addAllJarsToClassPath(file
							.getAbsolutePath())));
				else {
					String filename = file.getName().toLowerCase();
					if (filename.endsWith(".jar")) {
						if (appendToClassPath(file.getAbsolutePath()))
							ret.add(file.getAbsolutePath());
					}
				}
			}
		}
		return ret.toArray(new String[0]);
	}

	/**
	 * Finds <b>tools.jar</b>. Returns <code>null</code> if does not exist.
	 */
	public static File findToolsJar() {
		String tools = new File(SystemUtil.getJavaRuntimeInfo().getHomeDir())
				.getAbsolutePath()
				+ File.separatorChar
				+ "lib"
				+ File.separatorChar + "tools.jar";
		File toolsFile = new File(tools);
		if (toolsFile.exists()) {
			return toolsFile;
		}
		return null;
	}

	private static Manifest getManifestFromFile(File classpathItem) {

		File metaDir = new File(classpathItem, "META-INF");
		File manifestFile = null;
		if (metaDir.isDirectory()) {
			for (String m : MANIFESTS) {
				File mFile = new File(metaDir, m);
				if (mFile.isFile()) {
					manifestFile = mFile;
					break;
				}
			}
		}
		if (manifestFile != null) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(manifestFile);
				return new Manifest(fis);
			} catch (IOException e) {
				throw new ChainedRuntimeException(
						"JVMUtil.getManifestFromFile Error", e);
			} finally {
				StreamUtil.close(fis);
			}
		}
		return null;
	}

	private static Manifest getManifestFromJar(File classpathItem) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(classpathItem);
			return new JarFile(classpathItem).getManifest();
		} catch (IOException e) {
			throw new ChainedRuntimeException(
					"JVMUtil.getManifestFromJar Error", e);
		} finally {
			StreamUtil.close(fis);
		}

	}

	/**
	 * Returns classpath item manifest or <code>null</code> if not found.
	 */
	public static Manifest getManifest(File classpathItem) {
		if (classpathItem.isFile()) {
			return getManifestFromJar(classpathItem);
		}

		return getManifestFromFile(classpathItem);
	}

	/**
	 * Returns base folder for classpath item. If item is a (jar) file, its
	 * parent is returned. If item is a directory, its name is returned.
	 */
	public static String getClasspathItemBaseDir(File classpathItem) {

		if (classpathItem.isFile()) {
			return classpathItem.getParent();
		}

		return classpathItem.toString();
	}

	/**
	 * Returns default classpath using {@link #getDefaultClassLoader() default
	 * classloader}.
	 */
	public static File[] getDefaultClasspath() {
		return getDefaultClasspath(ClassLoaderUtil.getDefaultClassLoader());
	}

	/**
	 * Returns default class path from all available <code>URLClassLoader</code>
	 * in classloader hierarchy. The following is added to the classpath list:
	 * <li>file URLs from <code>URLClassLoader</code> (other URL protocols are
	 * ignored) <li>inner entries from containing <b>manifest</b> files (if
	 * exist) <li>bootstrap classpath
	 */
	public static File[] getDefaultClasspath(ClassLoader classLoader) {
		Set<File> classpaths = CollectionUtil.getHashSet();

		while (classLoader != null) {
			if (classLoader instanceof URLClassLoader) {
				URL[] urls = ((URLClassLoader) classLoader).getURLs();
				for (URL u : urls) {
					File f = FileUtil.toFile(u);
					if (f != null) {
						try {
							f = f.getCanonicalFile();
							classpaths.add(f);
							addInnerClasspathItems(classpaths, f);
						} catch (IOException e) {
							throw new ChainedRuntimeException(
									"JVMUtil.getDefaultClasspath Error", e);
						}
					}
				}
			}
			classLoader = classLoader.getParent();
		}

		String bootstrap = SystemUtil.getJavaRuntimeInfo()
				.getSunBoothClassPath();
		if (bootstrap != null) {
			classpaths.add(new File(bootstrap));
		}

		File[] result = new File[classpaths.size()];
		return classpaths.toArray(result);
	}

	private static void addInnerClasspathItems(Set<File> classpaths, File item)
			throws IOException {

		Manifest manifest = getManifest(item);
		if (manifest == null) {
			return;
		}

		Attributes attributes = manifest.getMainAttributes();
		if (attributes == null) {
			return;
		}

		String s = attributes.getValue(Attributes.Name.CLASS_PATH);
		if (s == null) {
			return;
		}

		String base = getClasspathItemBaseDir(item);

		String[] tokens = StringUtil.split(s, ' ');
		for (String t : tokens) {
			File file = new File(base, t);
			file = file.getCanonicalFile();

			if (file.exists()) {
				classpaths.add(file);
			}
		}
	}
}
