/**
 * 
 */
package com.richardxu.common.lang;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * 处理异常的工具类。
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * @version create on 2011-5-17 下午03:39:39
 */
public class ExceptionUtil {

	private ExceptionUtil() {

	}

	/**
	 * 取得异常的stacktrace字符串。
	 * 
	 * @param throwable
	 *            异常
	 * 
	 * @return stacktrace字符串
	 */
	public static String getStackTrace(Throwable throwable) {
		if (throwable == null) {
			return null;
		}

		StringWriter buffer = new StringWriter();
		PrintWriter out = new PrintWriter(buffer);

		throwable.printStackTrace(out);
		out.flush();

		return buffer.toString();
	}

	/**
	 * Returns current stack trace in form of array of stack trace elements.
	 * First stack trace element is removed. Since an exception is thrown
	 * internally, this method is slow.
	 */
	public static StackTraceElement[] getCurrentStackTrace() {
		StackTraceElement[] ste = new Exception().getStackTrace();
		if (ste.length > 1) {
			StackTraceElement[] result = new StackTraceElement[ste.length - 1];
			System.arraycopy(ste, 1, result, 0, ste.length - 1);
			return result;
		}
		return ste;
	}

	// ----------------------------------------------------------------
	// exception stack trace

	/**
	 * Returns stack trace filtered by class names.
	 */
	public static StackTraceElement[] getStackTrace(Throwable t,
			String[] allow, String[] deny) {
		if (t == null || allow == null || deny == null) {
			return null;
		}
		StackTraceElement[] st = t.getStackTrace();
		List<StackTraceElement> result = CollectionUtil.getArrayList(st.length);

		elementLoop: for (StackTraceElement element : st) {
			String className = element.getClassName();
			if (allow != null) {
				boolean validElemenet = false;
				for (String filter : allow) {
					if (className.indexOf(filter) != -1) {
						validElemenet = true;
						break;
					}
				}
				if (!validElemenet) {
					continue;
				}
			}
			if (deny != null) {
				for (String filter : deny) {
					if (className.indexOf(filter) != -1) {
						continue elementLoop;
					}
				}
			}
			result.add(element);
		}
		st = new StackTraceElement[result.size()];
		return result.toArray(st);
	}

	/**
	 * Returns stack trace chain filtered by class names.
	 */
	public static StackTraceElement[][] getStackTraceChain(Throwable t,
			String[] allow, String[] deny) {
		if (t == null || allow == null || deny == null) {
			return null;
		}

		List<StackTraceElement[]> result = CollectionUtil.getArrayList();
		while (t != null) {
			StackTraceElement[] stack = getStackTrace(t, allow, deny);
			result.add(stack);
			t = t.getCause();
		}
		StackTraceElement[][] allStacks = new StackTraceElement[result.size()][];
		for (int i = 0; i < allStacks.length; i++) {
			allStacks[i] = result.get(i);
		}
		return allStacks;
	}

	/**
	 * Returns exception chain starting from top up to root cause.
	 */
	public static Throwable[] getExceptionChain(Throwable throwable) {
		if (throwable == null) {
			return null;
		}

		List<Throwable> list = CollectionUtil.getArrayList();
		list.add(throwable);
		while ((throwable = throwable.getCause()) != null) {
			list.add(throwable);
		}
		Throwable[] result = new Throwable[list.size()];
		return list.toArray(result);
	}

	// ----------------------------------------------------------------
	// exception to string

	/**
	 * Prints stack trace into a String.
	 */
	public static String exceptionToString(Throwable t) {
		if (t == null) {
			return null;
		}
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		t.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}

	/**
	 * Prints full exception stack trace, from top to root cause, into a String.
	 */
	public static String exceptionChainToString(Throwable t) {
		if (t == null) {
			return null;
		}
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		while (t != null) {
			t.printStackTrace(pw);
			t = t.getCause();
		}
		pw.flush();
		sw.flush();
		return sw.toString();
	}

	/**
	 * Build a message for the given base message and its cause.
	 */
	public static String buildMessage(String message, Throwable cause) {
		if (cause != null) {
			cause = getRootCause(cause);
			StringBuilder buf = new StringBuilder();
			if (message != null) {
				buf.append(message).append("; ");
			}
			buf.append("<--- ").append(cause);
			return buf.toString();
		}
		return message;
	}

	// ---------------------------------------------------------------- root
	// cause

	/**
	 * Introspects the <code>Throwable</code> to obtain the root cause.
	 * <p>
	 * This method walks through the exception chain to the last element, "root"
	 * of the tree, and returns that exception. If no root cause found returns
	 * provided throwable.
	 */
	public static Throwable getRootCause(Throwable throwable) {
		if (throwable == null) {
			return null;
		}

		Throwable cause = throwable.getCause();
		if (cause == null) {
			return throwable;
		}
		throwable = cause;
		while ((throwable = throwable.getCause()) != null) {
			cause = throwable;
		}
		return cause;
	}

	/**
	 * Finds throwing cause in exception stack. Returns throwable object if
	 * cause class is matched. Otherwise, returns <code>null</code>.
	 */
	@SuppressWarnings({ "unchecked" })
	public static <T extends Throwable> T findCause(Throwable throwable,
			Class<T> cause) {
		while (throwable != null) {
			if (throwable.getClass().equals(cause)) {
				return (T) throwable;
			}
			throwable = throwable.getCause();
		}
		return null;
	}

	// ---------------------------------------------------------------- sql

	/**
	 * Rolls up SQL exceptions by taking each proceeding exception and making it
	 * a child of the previous using the <code>setNextException</code> method of
	 * SQLException.
	 */
	public static SQLException rollupSqlExceptions(List<SQLException> exceptions) {
		if (CollectionUtil.isEmpty(exceptions)) {
			return null;
		}
		SQLException parent = null;
		for (SQLException exception : exceptions) {
			if (parent != null) {
				exception.setNextException(parent);
			}
			parent = exception;
		}
		return parent;
	}

	// ---------------------------------------------------------------- misc

	/**
	 * Throws target of <code>InvocationTargetException</code> if it is
	 * exception.
	 */
	public static void throwTargetException(InvocationTargetException itex)
			throws Exception {
		throw extractTargetException(itex);
	}

	public static Exception extractTargetException(
			InvocationTargetException itex) {
		if (itex == null) {
			return null;
		}
		Throwable target = itex.getTargetException();
		return target instanceof Exception ? (Exception) target : itex;
	}

}
