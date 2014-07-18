/**
 * 
 */
package com.richardxu.common.lang;

import static java.lang.String.format;

/**
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2013-5-4 下午2:30:15
 */
public class Sizing {

	private static final int KILOBYTE_UNIT = 1024;

	public static int Gb(double giga) {
		return (int) giga * KILOBYTE_UNIT * KILOBYTE_UNIT * KILOBYTE_UNIT;
	}

	public static int Mb(double mega) {
		return (int) mega * KILOBYTE_UNIT * KILOBYTE_UNIT;
	}

	public static int Kb(double kilo) {
		return (int) kilo * KILOBYTE_UNIT;
	}

	public static int unlimited() {
		return -1;
	}

	public static String inKb(long bytes) {
		return format("%(,.1fKb", (double) bytes / KILOBYTE_UNIT);
	}

	public static String inMb(long bytes) {
		return format("%(,.1fMb", (double) bytes / KILOBYTE_UNIT
				/ KILOBYTE_UNIT);
	}

	public static String inGb(long bytes) {
		return format("%(,.1fGb", (double) bytes / KILOBYTE_UNIT
				/ KILOBYTE_UNIT / KILOBYTE_UNIT);
	}

}
