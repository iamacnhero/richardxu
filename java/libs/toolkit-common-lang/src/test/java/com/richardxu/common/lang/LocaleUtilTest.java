

package com.richardxu.common.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.text.DateFormatSymbols;
import java.util.Locale;

import org.junit.Test;

import com.richardxu.common.lang.i18n.LocaleUtil;

public class LocaleUtilTest {

	@Test
	public void testLocaleUtil() {
		Locale locale1 = LocaleUtil.getLocale("fr", "FR");
		Locale locale2 = LocaleUtil.getLocale("fr_FR");
		assertSame(locale1, locale2);

		locale1 = LocaleUtil.getLocale("en");
		locale2 = LocaleUtil.getLocale("en_EN");
		assertNotSame(locale1, locale2);

		DateFormatSymbols dfs = LocaleUtil.getDateFormatSymbols(locale2);
		assertEquals("January", dfs.getMonths()[0]);


	}
}
