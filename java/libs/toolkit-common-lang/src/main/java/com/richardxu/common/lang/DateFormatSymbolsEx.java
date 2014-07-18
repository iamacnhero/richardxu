package com.richardxu.common.lang;

import java.lang.reflect.Field;
import java.text.DateFormatSymbols;
import java.util.Locale;

import com.richardxu.common.lang.exception.ChainedRuntimeException;
import com.richardxu.common.lang.i18n.LocaleUtil;

/**
 * Enhanced <code>DateFormatSymbols</code> with improved performance by avoiding
 * duplication of returned arrays. Note: this class should be cached as by
 * {@link LocaleUtil}, since reflection is used upon creation.
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-10-15 下午4:48:59
 */
public class DateFormatSymbolsEx extends DateFormatSymbols {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7625665599176246267L;

	public DateFormatSymbolsEx() {
		super();
		afterInit();
	}

	public DateFormatSymbolsEx(Locale locale) {
		super(locale);
		afterInit();
	}

	String[] _months;
	String[] _shortMonths;
	String[] _weekdays;
	String[] _shortWeekdays;
	String[] _eras;
	String[] _ampms;

	protected void afterInit() {
		Class<DateFormatSymbols> type = DateFormatSymbols.class;
		try {
			Field f = type.getDeclaredField("months");
			f.setAccessible(true);
			_months = (String[]) f.get(this);

			f = type.getDeclaredField("shortMonths");
			f.setAccessible(true);
			_shortMonths = (String[]) f.get(this);

			f = type.getDeclaredField("weekdays");
			f.setAccessible(true);
			_weekdays = (String[]) f.get(this);

			f = type.getDeclaredField("shortWeekdays");
			f.setAccessible(true);
			_shortWeekdays = (String[]) f.get(this);

			f = type.getDeclaredField("eras");
			f.setAccessible(true);
			_eras = (String[]) f.get(this);

			f = type.getDeclaredField("ampms");
			f.setAccessible(true);
			_ampms = (String[]) f.get(this);

		} catch (Exception ex) {
			throw new ChainedRuntimeException("Unable to initialize", ex);
		}
	}

	// ---------------------------------------------------------------- fast

	/**
	 * Returns month string.
	 */
	public String getMonth(int i) {
		return this._months[i];
	}

	/**
	 * Returns short months.
	 */
	public String getShortMonth(int i) {
		return this._shortMonths[i];
	}

	/**
	 * Returns weekday.
	 */
	public String getWeekday(int i) {
		return this._weekdays[i];
	}

	/**
	 * Returns short weekday.
	 */
	public String getShortWeekday(int i) {
		return this._shortWeekdays[i];
	}

	/**
	 * Returns BC era.
	 */
	public String getBcEra() {
		return this._eras[0];
	}

	/**
	 * Returns AD era.
	 */
	public String getAdEra() {
		return this._eras[1];
	}

	/**
	 * Returns AM.
	 */
	public String getAM() {
		return this._ampms[0];
	}

	/**
	 * Returns PM.
	 */
	public String getPM() {
		return this._ampms[1];
	}

	// ---------------------------------------------------------------- clone

	@Override
	public Object clone() {
		return super.clone();
	}
}
