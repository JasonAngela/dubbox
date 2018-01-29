package cn.bjd.platform.elastic.provider.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/6/3.
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    /**
     * 默认时间格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * ISO8601 formatter for date-time without time zone.
     * The format used is <tt>yyyy-MM-dd'T'HH:mm:ss</tt>.
     */
    public static final FastDateFormat DEFAULT_DATETIME_FORMAT
            = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    /**
     * The UTC time zone (often referred to as GMT).
     * This is private as it is mutable.
     */
    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
    /**
     * ISO8601 formatter for date-time without time zone.
     * The format used is <tt>yyyy-MM-dd'T'HH:mm:ss</tt>.
     */
    public static final FastDateFormat ISO_DATETIME_FORMAT
            = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * ISO8601 formatter for date-time with time zone.
     * The format used is <tt>yyyy-MM-dd'T'HH:mm:ssZZ</tt>.
     */
    public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT
            = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");

    /**
     * ISO8601 formatter for date without time zone.
     * The format used is <tt>yyyy-MM-dd</tt>.
     */
    public static final FastDateFormat DATE_FORMAT_DAY
            = FastDateFormat.getInstance("yyyy-MM-dd");

    /**
     * ISO8601-like formatter for date with time zone.
     * The format used is <tt>yyyy-MM-ddZZ</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard does not allow a time zone  without a time.
     */
    public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT
            = FastDateFormat.getInstance("yyyy-MM-ddZZ");

    /**
     * ISO8601 formatter for time without time zone.
     * The format used is <tt>'T'HH:mm:ss</tt>.
     */
    public static final FastDateFormat ISO_TIME_FORMAT
            = FastDateFormat.getInstance("'T'HH:mm:ss");

    /**
     * ISO8601 formatter for time with time zone.
     * The format used is <tt>'T'HH:mm:ssZZ</tt>.
     */
    public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT
            = FastDateFormat.getInstance("'T'HH:mm:ssZZ");

    /**
     * ISO8601-like formatter for time without time zone.
     * The format used is <tt>HH:mm:ss</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard requires the 'T' prefix for times.
     */
    public static final FastDateFormat ISO_TIME_NO_T_FORMAT
            = FastDateFormat.getInstance("HH:mm:ss");

    /**
     * ISO8601-like formatter for time with time zone.
     * The format used is <tt>HH:mm:ssZZ</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard requires the 'T' prefix for times.
     */
    public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT
            = FastDateFormat.getInstance("HH:mm:ssZZ");

    /**
     * SMTP (and probably other) date headers.
     * The format used is <tt>EEE, dd MMM yyyy HH:mm:ss Z</tt> in US locale.
     */
    public static final FastDateFormat SMTP_DATETIME_FORMAT
            = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);


    /**
     * 默认支持时间字符串格式类型
     */
    private static final String[] PATTERN_ARRAY = {
            DEFAULT_DATETIME_FORMAT.getPattern(),
            DATE_FORMAT_DAY.getPattern()
    };

    /**
     * 默认时间解析
     *
     * @param str 时间字符串
     * @return Date
     * @throws ParseException
     */
    public static Date parseDate(final String str) throws ParseException {
        return DateUtils.parseDate(str, DEFAULT_DATETIME_FORMAT.getPattern());
    }

    /**
     * 默认Format
     *
     * @param date
     * @return String
     */
    public static String format(final Date date) {
        return DEFAULT_DATETIME_FORMAT.format(date);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date, not null
     * @return the formatted date
     */
    public static String formatUTC(final long millis, final String pattern) {
        return format(new Date(millis), pattern, UTC_TIME_ZONE, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param date    the date to format, not null
     * @param pattern the pattern to use to format the date, not null
     * @return the formatted date
     */
    public static String formatUTC(final Date date, final String pattern) {
        return format(date, pattern, UTC_TIME_ZONE, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date, not null
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String formatUTC(final long millis, final String pattern, final Locale locale) {
        return format(new Date(millis), pattern, UTC_TIME_ZONE, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param date    the date to format, not null
     * @param pattern the pattern to use to format the date, not null
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String formatUTC(final Date date, final String pattern, final Locale locale) {
        return format(date, pattern, UTC_TIME_ZONE, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date, not null
     * @return the formatted date
     */
    public static String format(final long millis, final String pattern) {
        return format(new Date(millis), pattern, null, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern.</p>
     *
     * @param date    the date to format, not null
     * @param pattern the pattern to use to format the date, not null
     * @return the formatted date
     */
    public static String format(final Date date, final String pattern) {
        return format(date, pattern, null, null);
    }

    /**
     * <p>Formats a calendar into a specific pattern.</p>
     *
     * @param calendar the calendar to format, not null
     * @param pattern  the pattern to use to format the calendar, not null
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(final Calendar calendar, final String pattern) {
        return format(calendar, pattern, null, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone.</p>
     *
     * @param millis   the time expressed in milliseconds
     * @param pattern  the pattern to use to format the date, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final long millis, final String pattern, final TimeZone timeZone) {
        return format(new Date(millis), pattern, timeZone, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone.</p>
     *
     * @param date     the date to format, not null
     * @param pattern  the pattern to use to format the date, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final Date date, final String pattern, final TimeZone timeZone) {
        return format(date, pattern, timeZone, null);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a time zone.</p>
     *
     * @param calendar the calendar to format, not null
     * @param pattern  the pattern to use to format the calendar, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone) {
        return format(calendar, pattern, timeZone, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a locale.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date, not null
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final long millis, final String pattern, final Locale locale) {
        return format(new Date(millis), pattern, null, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a locale.</p>
     *
     * @param date    the date to format, not null
     * @param pattern the pattern to use to format the date, not null
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final Date date, final String pattern, final Locale locale) {
        return format(date, pattern, null, locale);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a locale.</p>
     *
     * @param calendar the calendar to format, not null
     * @param pattern  the pattern to use to format the calendar, not null
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(final Calendar calendar, final String pattern, final Locale locale) {
        return format(calendar, pattern, null, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone  and locale.</p>
     *
     * @param millis   the date to format expressed in milliseconds
     * @param pattern  the pattern to use to format the date, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final long millis, final String pattern, final TimeZone timeZone, final Locale locale) {
        return format(new Date(millis), pattern, timeZone, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone  and locale.</p>
     *
     * @param date     the date to format, not null
     * @param pattern  the pattern to use to format the date, not null, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final Date date, final String pattern, final TimeZone timeZone, final Locale locale) {
        final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
        return df.format(date);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a time zone  and locale.</p>
     *
     * @param calendar the calendar to format, not null
     * @param pattern  the pattern to use to format the calendar, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone, final Locale locale) {
        final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
        return df.format(calendar);
    }

    /**
     * @param paramString
     * @return s
     */
    public static String getSystemDateByformart(String paramString) {
        Date now = new Date();
        FastDateFormat format = FastDateFormat.getInstance(paramString);
        return format.format(now);
    }

    /**
     * 按照pattern 格式解析 date字符串
     *
     * @param date    日期
     * @param pattern 格式
     * @return s
     * @throws ParseException
     */
    public static Date parseDateByPattern(String date, String pattern) {
        try {
            return DateUtils.parseDate(date,pattern);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按照pattern 格式解析 date字符串
     *
     * @param date    日期
     * @param parsePatterns 格式
     * @return s
     * @throws ParseException
     */
    public static Date parseDateByPattern(String date, final String... parsePatterns) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(date,parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Date parseDateByPatternAndLocale(String date, final Locale locale,final String... parsePatterns) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(date,locale,parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将日期转化成需求的格式字符串
     *
     * @param date    日期
     * @param pattern 格式
     * @return s
     */
    public static String getStringByDate(Date date, String pattern) {
        return DateUtils.format(date,pattern);
    }


    /**
     * @return s
     */
    public static String getSystemYYYYMMDD() {
        return DATE_FORMAT_DAY.format(new Date());
    }

    /**
     * @param time
     * @return s
     */
    public static Date parseTimeToDate(String time) {
        try {
            return DateUtils.parseDate(time,PATTERN_ARRAY);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
