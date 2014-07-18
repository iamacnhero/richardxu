package com.richardxu.common.lang;

import java.io.UnsupportedEncodingException;

/**
 * Various character and character sequence utilities, including
 * <code>char[]</code> - <code>byte[]</code> conversions.
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-9-17 下午5:42:16
 */
public class CharUtil {

	private static final String CHAR_STRING = "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007"
			+ "\b\t\n\u000b\f\r\u000e\u000f"
			+ "\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017"
			+ "\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f"
			+ "\u0020\u0021\"\u0023\u0024\u0025\u0026\u0027"
			+ "\u0028\u0029\u002a\u002b\u002c\u002d\u002e\u002f"
			+ "\u0030\u0031\u0032\u0033\u0034\u0035\u0036\u0037"
			+ "\u0038\u0039\u003a\u003b\u003c\u003d\u003e\u003f"
			+ "\u0040\u0041\u0042\u0043\u0044\u0045\u0046\u0047"
			+ "\u0048\u0049\u004a\u004b\u004c\u004d\u004e\u004f"
			+ "\u0050\u0051\u0052\u0053\u0054\u0055\u0056\u0057"
			+ "\u0058\u0059\u005a\u005b\\\u005d\u005e\u005f"
			+ "\u0060\u0061\u0062\u0063\u0064\u0065\u0066\u0067"
			+ "\u0068\u0069\u006a\u006b\u006c\u006d\u006e\u006f"
			+ "\u0070\u0071\u0072\u0073\u0074\u0075\u0076\u0077"
			+ "\u0078\u0079\u007a\u007b\u007c\u007d\u007e\u007f";

	private static final String[] CHAR_STRING_ARRAY = new String[128];
	private static final Character[] CHAR_ARRAY = new Character[128];

	/**
	 * <code>\u000a</code> linefeed LF ('\n').
	 * 
	 * @see <a
	 *      href="http://java.sun.com/docs/books/jls/third_edition/html/lexical.html#101089">JLF:
	 *      Escape Sequences for Character and String Literals</a>
	 * @since 2.2
	 */
	public static final char LF = '\n';

	/**
	 * <code>\u000d</code> carriage return CR ('\r').
	 * 
	 * @see <a
	 *      href="http://java.sun.com/docs/books/jls/third_edition/html/lexical.html#101089">JLF:
	 *      Escape Sequences for Character and String Literals</a>
	 * @since 2.2
	 */
	public static final char CR = '\r';

	static {
		for (int i = 127; i >= 0; i--) {
			CHAR_STRING_ARRAY[i] = CHAR_STRING.substring(i, i + 1);
			CHAR_ARRAY[i] = new Character((char) i);
		}
	}

	// ---------------------------------------------------------------- simple

	/**
	 * <p>
	 * Converts the character to a Character.
	 * </p>
	 * 
	 * <p>
	 * For ASCII 7 bit characters, this uses a cache that will return the same
	 * Character object each time.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toCharacterObject(' ')  = ' '
	 *   CharUtil.toCharacterObject('A')  = 'A'
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @return a Character of the specified character
	 */
	public static Character toCharacterObject(char ch) {
		if (ch < CHAR_ARRAY.length) {
			return CHAR_ARRAY[ch];
		}
		return new Character(ch);
	}

	/**
	 * <p>
	 * Converts the String to a Character using the first character, returning
	 * null for empty Strings.
	 * </p>
	 * 
	 * <p>
	 * For ASCII 7 bit characters, this uses a cache that will return the same
	 * Character object each time.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toCharacterObject(null) = null
	 *   CharUtil.toCharacterObject("")   = null
	 *   CharUtil.toCharacterObject("A")  = 'A'
	 *   CharUtil.toCharacterObject("BA") = 'B'
	 * </pre>
	 * 
	 * @param str
	 *            the character to convert
	 * @return the Character value of the first letter of the String
	 */
	public static Character toCharacterObject(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		return toCharacterObject(str.charAt(0));
	}

	/**
	 * Converts (signed) byte to (unsigned) char.
	 */
	public static char toChar(byte b) {
		return (char) (b & 0xFF);
	}

	/**
	 * <p>
	 * Converts the Character to a char throwing an exception for
	 * <code>null</code>.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toChar(null) = IllegalArgumentException
	 *   CharUtil.toChar(' ')  = ' '
	 *   CharUtil.toChar('A')  = 'A'
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @return the char value of the Character
	 * @throws IllegalArgumentException
	 *             if the Character is null
	 */
	public static char toChar(Character ch) {
		if (ch == null) {
			throw new IllegalArgumentException("The Character must not be null");
		}
		return ch.charValue();
	}

	/**
	 * <p>
	 * Converts the Character to a char handling <code>null</code>.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toChar(null, 'X') = 'X'
	 *   CharUtil.toChar(' ', 'X')  = ' '
	 *   CharUtil.toChar('A', 'X')  = 'A'
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @param defaultValue
	 *            the value to use if the Character is null
	 * @return the char value of the Character or the default if null
	 */
	public static char toChar(Character ch, char defaultValue) {
		if (ch == null) {
			return defaultValue;
		}
		return ch.charValue();
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts the String to a char using the first character, throwing an
	 * exception on empty Strings.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toChar(null) = IllegalArgumentException
	 *   CharUtil.toChar("")   = IllegalArgumentException
	 *   CharUtil.toChar("A")  = 'A'
	 *   CharUtil.toChar("BA") = 'B'
	 * </pre>
	 * 
	 * @param str
	 *            the character to convert
	 * @return the char value of the first letter of the String
	 * @throws IllegalArgumentException
	 *             if the String is empty
	 */
	public static char toChar(String str) {
		if (StringUtil.isEmpty(str)) {
			throw new IllegalArgumentException("The String must not be empty");
		}
		return str.charAt(0);
	}

	/**
	 * <p>
	 * Converts the String to a char using the first character, defaulting the
	 * value on empty Strings.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toChar(null, 'X') = 'X'
	 *   CharUtil.toChar("", 'X')   = 'X'
	 *   CharUtil.toChar("A", 'X')  = 'A'
	 *   CharUtil.toChar("BA", 'X') = 'B'
	 * </pre>
	 * 
	 * @param str
	 *            the character to convert
	 * @param defaultValue
	 *            the value to use if the Character is null
	 * @return the char value of the first letter of the String or the default
	 *         if null
	 */
	public static char toChar(String str, char defaultValue) {
		if (StringUtil.isEmpty(str)) {
			return defaultValue;
		}
		return str.charAt(0);
	}

	/**
	 * <p>
	 * Converts the character to the Integer it represents, throwing an
	 * exception if the character is not numeric.
	 * </p>
	 * 
	 * <p>
	 * This method coverts the char '1' to the int 1 and so on.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toIntValue('3')  = 3
	 *   CharUtil.toIntValue('A')  = IllegalArgumentException
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @return the int value of the character
	 * @throws IllegalArgumentException
	 *             if the character is not ASCII numeric
	 */
	public static int toIntValue(char ch) {
		if (!isDigit(ch)) {
			throw new IllegalArgumentException("The character " + ch
					+ " is not in the range '0' - '9'");
		}
		return ch - 48;
	}

	/**
	 * <p>
	 * Converts the character to the Integer it represents, throwing an
	 * exception if the character is not numeric.
	 * </p>
	 * 
	 * <p>
	 * This method coverts the char '1' to the int 1 and so on.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toIntValue('3', -1)  = 3
	 *   CharUtil.toIntValue('A', -1)  = -1
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @param defaultValue
	 *            the default value to use if the character is not numeric
	 * @return the int value of the character
	 */
	public static int toIntValue(char ch, int defaultValue) {
		if (!isDigit(ch)) {
			return defaultValue;
		}
		return ch - 48;
	}

	/**
	 * <p>
	 * Converts the character to the Integer it represents, throwing an
	 * exception if the character is not numeric.
	 * </p>
	 * 
	 * <p>
	 * This method coverts the char '1' to the int 1 and so on.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toIntValue(null) = IllegalArgumentException
	 *   CharUtil.toIntValue('3')  = 3
	 *   CharUtil.toIntValue('A')  = IllegalArgumentException
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert, not null
	 * @return the int value of the character
	 * @throws IllegalArgumentException
	 *             if the Character is not ASCII numeric or is null
	 */
	public static int toIntValue(Character ch) {
		if (ch == null) {
			throw new IllegalArgumentException("The character must not be null");
		}
		return toIntValue(ch.charValue());
	}

	/**
	 * <p>
	 * Converts the character to the Integer it represents, throwing an
	 * exception if the character is not numeric.
	 * </p>
	 * 
	 * <p>
	 * This method coverts the char '1' to the int 1 and so on.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toIntValue(null, -1) = -1
	 *   CharUtil.toIntValue('3', -1)  = 3
	 *   CharUtil.toIntValue('A', -1)  = -1
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @param defaultValue
	 *            the default value to use if the character is not numeric
	 * @return the int value of the character
	 */
	public static int toIntValue(Character ch, int defaultValue) {
		if (ch == null) {
			return defaultValue;
		}
		return toIntValue(ch.charValue(), defaultValue);
	}

	/**
	 * <p>
	 * Converts the character to a String that contains the one character.
	 * </p>
	 * 
	 * <p>
	 * For ASCII 7 bit characters, this uses a cache that will return the same
	 * String object each time.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toString(' ')  = " "
	 *   CharUtil.toString('A')  = "A"
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @return a String containing the one specified character
	 */
	public static String toString(char ch) {
		if (ch < 128) {
			return CHAR_STRING_ARRAY[ch];
		}
		return new String(new char[] { ch });
	}

	/**
	 * <p>
	 * Converts the character to a String that contains the one character.
	 * </p>
	 * 
	 * <p>
	 * For ASCII 7 bit characters, this uses a cache that will return the same
	 * String object each time.
	 * </p>
	 * 
	 * <p>
	 * If <code>null</code> is passed in, <code>null</code> will be returned.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.toString(null) = null
	 *   CharUtil.toString(' ')  = " "
	 *   CharUtil.toString('A')  = "A"
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @return a String containing the one specified character
	 */
	public static String toString(Character ch) {
		if (ch == null) {
			return null;
		}
		return toString(ch.charValue());
	}

	/**
	 * <p>
	 * Converts the string to the unicode format '\u0020'.
	 * </p>
	 * 
	 * <p>
	 * This format is the Java source code format.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.unicodeEscaped(' ') = "\u0020"
	 *   CharUtil.unicodeEscaped('A') = "\u0041"
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert
	 * @return the escaped unicode string
	 */
	public static String unicodeEscaped(char ch) {
		if (ch < 0x10) {
			return "\\u000" + Integer.toHexString(ch);
		} else if (ch < 0x100) {
			return "\\u00" + Integer.toHexString(ch);
		} else if (ch < 0x1000) {
			return "\\u0" + Integer.toHexString(ch);
		}
		return "\\u" + Integer.toHexString(ch);
	}

	/**
	 * <p>
	 * Converts the string to the unicode format '\u0020'.
	 * </p>
	 * 
	 * <p>
	 * This format is the Java source code format.
	 * </p>
	 * 
	 * <p>
	 * If <code>null</code> is passed in, <code>null</code> will be returned.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.unicodeEscaped(null) = null
	 *   CharUtil.unicodeEscaped(' ')  = "\u0020"
	 *   CharUtil.unicodeEscaped('A')  = "\u0041"
	 * </pre>
	 * 
	 * @param ch
	 *            the character to convert, may be null
	 * @return the escaped unicode string, null if null input
	 */
	public static String unicodeEscaped(Character ch) {
		if (ch == null) {
			return null;
		}
		return unicodeEscaped(ch.charValue());
	}

	/**
	 * Converts char array into byte array by stripping the high byte of each
	 * character.
	 */
	public static byte[] toSimpleByteArray(char[] carr) {
		if (carr == null) {
			return null;
		}
		byte[] barr = new byte[carr.length];
		for (int i = 0; i < carr.length; i++) {
			barr[i] = (byte) carr[i];
		}
		return barr;
	}

	/**
	 * Converts char sequence into byte array.
	 * 
	 * @see #toSimpleByteArray(char[])
	 */
	public static byte[] toSimpleByteArray(CharSequence charSequence) {
		if (charSequence == null) {
			return null;
		}
		byte[] barr = new byte[charSequence.length()];
		for (int i = 0; i < barr.length; i++) {
			barr[i] = (byte) charSequence.charAt(i);
		}
		return barr;
	}

	/**
	 * Converts byte array to char array by simply extending bytes to chars.
	 */
	public static char[] toSimpleCharArray(byte[] barr) {
		if (barr == null) {
			return null;
		}
		char[] carr = new char[barr.length];
		for (int i = 0; i < barr.length; i++) {
			carr[i] = (char) (barr[i] & 0xFF);
		}
		return carr;
	}

	// ---------------------------------------------------------------- ascii

	/**
	 * Returns ASCII value of a char. In case of overload, 0x3F is returned.
	 */
	public static int toAscii(char c) {
		if (c <= 0xFF) {
			return c;
		} else {
			return 0x3F;
		}
	}

	/**
	 * Converts char array into {@link #toAscii(char) ASCII} array.
	 */
	public static byte[] toAsciiByteArray(char[] carr) {
		if (carr == null) {
			return null;
		}
		byte[] barr = new byte[carr.length];
		for (int i = 0; i < carr.length; i++) {
			barr[i] = (byte) ((int) (carr[i] <= 0xFF ? carr[i] : 0x3F));
		}
		return barr;
	}

	/**
	 * Converts char sequence into ASCII byte array.
	 */
	public static byte[] toAsciiByteArray(CharSequence charSequence) {
		if (charSequence == null) {
			return null;
		}
		byte[] barr = new byte[charSequence.length()];
		for (int i = 0; i < barr.length; i++) {
			char c = charSequence.charAt(i);
			barr[i] = (byte) ((int) (c <= 0xFF ? c : 0x3F));
		}
		return barr;
	}

	// ---------------------------------------------------------------- raw
	// arrays

	/**
	 * Converts char array into byte array by replacing each character with two
	 * bytes.
	 */
	public static byte[] toRawByteArray(char[] carr) {
		if (carr == null) {
			return null;
		}
		byte[] barr = new byte[carr.length << 1];
		for (int i = 0, bpos = 0; i < carr.length; i++) {
			char c = carr[i];
			barr[bpos++] = (byte) ((c & 0xFF00) >> 8);
			barr[bpos++] = (byte) (c & 0x00FF);
		}
		return barr;
	}

	public static char[] toRawCharArray(byte[] barr) {
		if (barr == null) {
			return null;
		}
		int carrLen = barr.length >> 1;
		if (carrLen << 1 < barr.length) {
			carrLen++;
		}
		char[] carr = new char[carrLen];
		int i = 0, j = 0;
		while (i < barr.length) {
			char c = (char) (barr[i] << 8);
			i++;

			if (i != barr.length) {
				c += barr[i] & 0xFF;
				i++;
			}
			carr[j++] = c;
		}
		return carr;
	}

	// ---------------------------------------------------------------- encoding

	/**
	 * Converts char array to byte array using default encoding.
	 */
	public static byte[] toByteArray(char[] carr)
			throws UnsupportedEncodingException {
		if (carr == null) {
			return null;
		}
		return new String(carr).getBytes("UTF-8");
	}

	/**
	 * Converts char array to byte array using provided encoding.
	 */
	public static byte[] toByteArray(char[] carr, String charset)
			throws UnsupportedEncodingException {
		if (carr == null) {
			return null;
		}
		return new String(carr).getBytes(charset);
	}

	/**
	 * Converts byte array of default encoding to char array.
	 */
	public static char[] toCharArray(byte[] barr)
			throws UnsupportedEncodingException {
		if (barr == null) {
			return null;
		}
		return new String(barr, "UTF-8").toCharArray();
	}

	/**
	 * Converts byte array of specific encoding to char array.
	 */
	public static char[] toCharArray(byte[] barr, String charset)
			throws UnsupportedEncodingException {
		if (barr == null) {
			return null;
		}
		return new String(barr, charset).toCharArray();
	}

	// ---------------------------------------------------------------- find

	/**
	 * Match if one character equals to any of the given character.
	 * 
	 * @return <code>true</code> if characters match any character from given
	 *         array, otherwise <code>false</code>
	 */
	public static boolean equalsOne(char c, char[] match) {
		if (match == null) {
			return false;
		}
		for (char aMatch : match) {
			if (c == aMatch) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds index of the first character in given array the matches any from
	 * the given set of characters.
	 * 
	 * @return index of matched character or -1
	 */
	public static int findFirstEqual(char[] source, int index, char[] match) {
		if (source == null || match == null) {
			return -1;
		}

		for (int i = index, length = source.length; i < length; i++) {
			if (equalsOne(source[i], match)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Finds index of the first character in given array the matches any from
	 * the given set of characters.
	 * 
	 * @return index of matched character or -1
	 */
	public static int findFirstEqual(char[] source, int index, char match) {
		if (source == null) {
			return -1;
		}
		for (int i = index; i < source.length; i++) {
			if (source[i] == match) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Finds index of the first character in given array the differs from the
	 * given set of characters.
	 * 
	 * @return index of matched character or -1
	 */
	public static int findFirstDiff(char[] source, int index, char[] match) {
		if (source == null || match == null) {
			return -1;
		}
		for (int i = index; i < source.length; i++) {
			if (!equalsOne(source[i], match)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Finds index of the first character in given array the differs from the
	 * given set of characters.
	 * 
	 * @return index of matched character or -1
	 */
	public static int findFirstDiff(char[] source, int index, char match) {
		if (source == null) {
			return -1;
		}
		for (int i = index; i < source.length; i++) {
			if (source[i] != match) {
				return i;
			}
		}
		return -1;
	}

	// ---------------------------------------------------------------- is

	/**
	 * Returns <code>true</code> if character is a white space (<= ' '). White
	 * space definition is taken from String class (see: <code>trim()</code>).
	 */
	public static boolean isWhitespace(char c) {
		return c <= ' ';
	}

	/**
	 * Returns <code>true</code> if specified character is lowercase ASCII. If
	 * user uses only ASCIIs, it is much much faster.
	 */
	public static boolean isLowercaseLetter(char c) {
		return (c >= 'a') && (c <= 'z');
	}

	/**
	 * Returns <code>true</code> if specified character is uppercase ASCII. If
	 * user uses only ASCIIs, it is much much faster.
	 */
	public static boolean isUppercaseLetter(char c) {
		return (c >= 'A') && (c <= 'Z');
	}

	public static boolean isLetter(char c) {
		return ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'));
	}

	public static boolean isDigit(char c) {
		return (c >= '0') && (c <= '9');
	}

	public static boolean isLetterOrDigit(char c) {
		return isDigit(c) || isLetter(c);
	}

	public static boolean isWordChar(char c) {
		return isDigit(c) || isLetter(c) || (c == '_');
	}

	public static boolean isPropertyNameChar(char c) {
		return isDigit(c) || isLetter(c) || (c == '_') || (c == '.')
				|| (c == '[') || (c == ']');
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.isAscii('a')  = true
	 *   CharUtil.isAscii('A')  = true
	 *   CharUtil.isAscii('3')  = true
	 *   CharUtil.isAscii('-')  = true
	 *   CharUtil.isAscii('\n') = true
	 *   CharUtil.isAscii('&copy;') = false
	 * </pre>
	 * 
	 * @param ch
	 *            the character to check
	 * @return true if less than 128
	 */
	public static boolean isAscii(char ch) {
		return ch < 128;
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit printable.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.isAsciiPrintable('a')  = true
	 *   CharUtil.isAsciiPrintable('A')  = true
	 *   CharUtil.isAsciiPrintable('3')  = true
	 *   CharUtil.isAsciiPrintable('-')  = true
	 *   CharUtil.isAsciiPrintable('\n') = false
	 *   CharUtil.isAsciiPrintable('&copy;') = false
	 * </pre>
	 * 
	 * @param ch
	 *            the character to check
	 * @return true if between 32 and 126 inclusive
	 */
	public static boolean isAsciiPrintable(char ch) {
		return ch >= 32 && ch < 127;
	}

	/**
	 * <p>
	 * Checks whether the character is ASCII 7 bit control.
	 * </p>
	 * 
	 * <pre>
	 *   CharUtil.isAsciiControl('a')  = false
	 *   CharUtil.isAsciiControl('A')  = false
	 *   CharUtil.isAsciiControl('3')  = false
	 *   CharUtil.isAsciiControl('-')  = false
	 *   CharUtil.isAsciiControl('\n') = true
	 *   CharUtil.isAsciiControl('&copy;') = false
	 * </pre>
	 * 
	 * @param ch
	 *            the character to check
	 * @return true if less than 32 or equals 127
	 */
	public static boolean isAsciiControl(char ch) {
		return ch < 32 || ch == 127;
	}

	public static boolean isChinese(char c) {
		return (c >= 0x4e00 && c <= 0x9fa5);
	}

	// ----------------------------------------------------------------
	// conversions

	/**
	 * Uppers lowercase ASCII char.
	 */
	public static char toUpperAscii(char c) {
		if (isLowercaseLetter(c)) {
			c -= (char) 0x20;
		}
		return c;
	}

	/**
	 * Lowers uppercase ASCII char.
	 */
	public static char toLowerAscii(char c) {
		if (isUppercaseLetter(c)) {
			c += (char) 0x20;
		}
		return c;
	}

}
