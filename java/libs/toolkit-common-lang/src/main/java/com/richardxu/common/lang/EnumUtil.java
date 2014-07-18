/**
 * 
 */
package com.richardxu.common.lang;

/**
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on Nov 12, 2013 5:13:44 PM
 */
public final class EnumUtil {

	private EnumUtil() {

	}

	public static <T extends Enum<T>, F extends Enum<F>> Enum<T> mapping(
			Class<T> type, Enum<F> from) {
		String name = from.name();

		return Enum.valueOf(type, name);

	}

}
