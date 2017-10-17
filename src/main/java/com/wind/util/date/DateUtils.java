package com.wind.util.date;

import com.google.common.base.Joiner;
import org.joda.time.*;
import org.joda.time.format.PeriodFormatterBuilder;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 基于Joda Time实现的日期工具类
 *
 * @author wind
 * @since 10/10/2016
 */
public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_FORMAT_OTHER = "yyyy/MM/dd";
    private static final String DATE_FORMAT_CHINESE = "yyyy年MM月dd日";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String DATE_TIME_FORMAT_DONOT_HAVE_T = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_FORMAT_MMDDHHMM = "MM-dd HH:mm";
    private static final String DATE_TIME_FORMAT_MMDD = "MM月dd日";
    private static final String DATE_TIME_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    private static final String MATCH_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    private static final String DATE_STRING_FORMAT = "yyyyMMdd";
    private static final String DATE_FORMAT_CHINESE_HHMM = "yyyy年MM月dd日 HH:mm";
    private static final String DATE_FORMAT_CHINESE_HHMMSS = "yyyy年MM月dd日 HH:mm:ss";
    private final static String LESS_THAN_ONE_MINUTE = "1分钟";

    public static String formatTime(int remainTime) {
        int millisToHour = 1000 * 60 * 60;
        int millisToMinutes = 1000 * 60;
        int remainHour = remainTime / millisToHour;
        int remainMinutes = (remainTime % millisToHour) / millisToMinutes;
        String leftHoursAndMinutes = aJoiner().join(format(remainHour, "时"), format(remainMinutes, "分"));
        return isLessThanOneMinute(remainHour, remainMinutes) ? LESS_THAN_ONE_MINUTE : leftHoursAndMinutes;
    }

    private static boolean isLessThanOneMinute(int remainHour, int remainMinutes) {
        return remainHour == 0 && remainMinutes == 0;
    }

    private static String format(int remainTime, String unit) {
        return String.format("%02d%s", remainTime, unit);
    }

    private static Joiner aJoiner() {
        return Joiner.on("");
    }

    public static Date endOfToday() {
        DateTime startDateTime = new DateTime().dayOfYear().roundFloorCopy();
        return startDateTime.plusDays(1).minusMillis(1).toDate();
    }

    public static Date startOfToday() {
        return startOfDay(DateTime.now().toDate());
    }

    public static DateTime startOfTodayWithTime() {
        return startOfDay(DateTime.now());
    }

    public static Date tomorrowMorning() {
        return new DateTime(startOfToday()).plusDays(1).plusHours(9).toDate();
    }

    public static Date afterSecondsOf(Integer seconds) {
        return DateTime.now().plusSeconds(seconds).toDate();
    }

    public static Date afterSecondsOf(DateTime dateTime, Integer seconds) {
        return dateTime.plusSeconds(seconds).toDate();
    }

    public static Date morning() {
        return new DateTime(startOfToday()).plusHours(9).toDate();
    }

    public static Date afternoon() {
        return new DateTime(startOfToday()).plusHours(13).toDate();
    }

    public static Date endOfDay(Date date) {
        DateTime startDateTime = new DateTime(date).dayOfYear().roundFloorCopy();
        return startDateTime.plusDays(1).minusMillis(1).toDate();
    }

    public static Date getDateBeforeToday(int days) {
        return startOfDay(new DateTime(now())).minusDays(days).toDate();
    }

    public static Date startOfWeek() {
        return startOfDay(DateTime.now().dayOfWeek().withMinimumValue().toDate());
    }

    public static Date endOfWeek() {
        return endOfDay(DateTime.now().dayOfWeek().withMaximumValue().toDate());
    }

    public static Date startOfDay(Date date) {
        return startOfDay(new DateTime(date)).toDate();
    }

    public static Date startOfLastMonth(Date date) {
        return startOfMonth(new DateTime(date).minusMonths(1)).toDate();
    }

    public static Date startOfMonth(Date date) {
        return startOfMonth(new DateTime(date)).toDate();
    }

    public static DateTime startOfMonth(DateTime dateTime) {
        return dateTime.monthOfYear().roundFloorCopy();
    }

    public static Date endOfMonth(Date date) {
        return startOfMonth(new DateTime(date)).plusMonths(1).minusMillis(1).toDate();
    }

    public static Date endOfLastMonth(Date date) {
        return startOfMonth(new DateTime(date)).minusMillis(1).toDate();
    }

    public static DateTime startOfDay(DateTime dateTime) {
        return dateTime.dayOfYear().roundFloorCopy();
    }

    public static boolean isOnSameDayOfMonth(DateTime datetime, DateTime other) {
        return datetime.getDayOfMonth() == other.getDayOfMonth();
    }

    public static String formatDate(Date date) {
        return formatDate(date, DATE_FORMAT);
    }

    public static String formatDateWithDefault(Date date, String defaultValue) {
        return date == null ? defaultValue : formatDate(date, DATE_FORMAT);
    }

    public static String formatDateOther(Date date) {
        return formatDate(date, DATE_FORMAT_OTHER);
    }

    public static String formatDateToChinese(Date date) {
        return formatDate(date, DATE_FORMAT_CHINESE);
    }

    public static String formatDateToChineseNoYear(Date date) {
        return formatDate(date, DATE_TIME_FORMAT_MMDD);
    }

    public static String formatDateTime(Date date) {
        return formatDate(date, DATE_TIME_FORMAT);
    }

    public static String formatDateTimeNotHaveT(Date date) {
        return formatDate(date, DATE_TIME_FORMAT_DONOT_HAVE_T);
    }

    public static Date parseDate(String date) {
        return parseDate(date, DATE_FORMAT);
    }

    public static Date parseDateYyyyMMDd(String date) {
        return parseDate(date, DATE_STRING_FORMAT);
    }

    public static Date parseDateTime(String date) {
        return parseDate(date, DATE_TIME_FORMAT_DONOT_HAVE_T);
    }

    public static Date parseDateTimeAsCmsDrawSequence(String date) {
        return parseDate(date, DATE_TIME_FORMAT_YYYYMMDDHHMMSS);
    }

    public static DateTime parseAsDateTime(String date) {
        return new DateTime(parseDate(date));
    }

    public static String formatDateAsCmsDrawSequence(Date date) {
        return formatDate(date, DATE_TIME_FORMAT_YYYYMMDDHHMMSS);
    }

    public static String formatDateAsMmDdHhMm(Date date) {
        return formatDate(date, DATE_TIME_FORMAT_MMDDHHMM);
    }

    public static String formatDateAsMatchTime(Date date) {
        return formatDate(date, MATCH_TIME_FORMAT);
    }

    public static String formatDateAsString(Date date) {
        return formatDate(date, DATE_STRING_FORMAT);
    }

    public static Date parseNormalStringToDate(String date) {
        return parseDate(date, DATE_STRING_FORMAT);
    }

    public static Date parseDateTime(String date, String format) {
        return parseDate(date, format);
    }

    public static String formatDateAsString(Date date, String format) {
        return formatDate(date, format);
    }

    public static String formatDate(Date date, String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).format(date);
        } catch (Exception e) {
            return "";
        }
    }

    public static Date parseDate(String dateString, String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).parse(dateString, new ParsePosition(0));
        } catch (Exception e) {
            return null;
        }
    }

    public static String getYearOfFourBits(Date date) {
        return new DateTime(date).getYear() + "";
    }

    public static String getMonthOfTwoBits(Date date) {
        String month = new DateTime(date).getMonthOfYear() + "";
        if (month.length() == 1) {
            month = "0" + month;
        }
        return month;
    }

    public static String getDayOfTwoBits(Date date) {
        String day = new DateTime(date).getDayOfMonth() + "";
        if (day.length() == 1) {
            day = "0" + day;
        }
        return day;
    }

    public static boolean isBetween(Date start, Date end, Date date) {
        return new DateTime(date).isBefore(new DateTime(end)) && new DateTime(date).isAfter(new DateTime(start));
    }

    public static int getDaysBetween(DateTime startDate, DateTime endDate) {
        return Days.daysBetween(startDate, endDate).getDays();
    }

    public static int getDaysBetween(Date startDate, Date endDate) {
        return Days.daysBetween(new DateTime(startOfDay(startDate)), new DateTime(startOfDay(endDate))).getDays();
    }

    public static int getSecondsBetween(Date startDate, Date endDate) {
        int diffSeconds = Seconds.secondsBetween(new DateTime(startDate), new DateTime(endDate)).getSeconds();
        return diffSeconds >= 0 ? diffSeconds : 0;
    }

    public static Date getStartDateAfterDays(int days) {
        return new DateTime().plusDays(days).withTimeAtStartOfDay().toDate();
    }

    public static Date getSomeDayInNearestMonth(Date startedAt) {
        return new DateTime(startedAt).plusMonths(DateUtils.monthsUntilNow(startedAt) + 1).toDate();
    }

    public static int monthsUntilNow(Date startedAt) {
        Period period = new Period(new LocalDate(startedAt), new LocalDate());

        return period.getMonths() + period.getYears() * 12;
    }

    public static boolean isAfterTodayInThisMonth(Date endAt) {
        return new LocalDate(endAt).getDayOfMonth() > new LocalDate().getDayOfMonth();
    }

    public static String getFormatedNextCollectionDay(Date startedAt, Date endedAt) {
        return DateUtils.isBeforeToday(endedAt) ? "" :
                DateUtils.formatDateTime(DateUtils.getSomeDayInNearestMonth(startedAt));
    }

    public static String getSimpleFormatedNextCollectionDay(Date startedAt, Date endedAt) {
        return DateUtils.isBeforeToday(endedAt) ? "" :
                DateUtils.formatDate(DateUtils.getSomeDayInNearestMonth(startedAt));
    }

    public static boolean isBeforeToday(Date date) {
        return new DateTime(date).withTimeAtStartOfDay().isBefore(endOfToday().getTime());
    }

    public static boolean isToday(Date date) {
        return new DateTime(date).withTimeAtStartOfDay().isEqual(startOfToday().getTime());
    }

    public static Period getElapsedPeriod(Date past) {
        Period period = new Period(new LocalDate(past), new LocalDate());
        if (period.getMonths() == 0 && period.getYears() == 0)
            return oneMonth();
        return period;
    }

    private static Period oneMonth() {
        return new Period(0, 1, 0, 0, 0, 0, 0, 0);
    }

    public static String getElapsedFormatedPeriod(Date past) {
        return new PeriodFormatterBuilder()
                .appendYears().appendSuffix("年")
                .appendMonths().appendSuffix("个月")
                .printZeroNever().toFormatter()
                .print(getElapsedPeriod(past));
    }

    public static Date getEndDateAfterDays(int days) {
        return endOfDay(new DateTime().plusDays(days).toDate());
    }

    public static String getDayAsString(Date date) {
        return new DateTime(date).getDayOfMonth() + "";
    }

    public static int getDay(Date date) {
        return new DateTime(date).getDayOfMonth();
    }

    public static int getYear(Date date) {
        return new DateTime(date).getYear();
    }

    public static int getMonthOfYear(Date date) {
        return new DateTime(date).getMonthOfYear();
    }

    public static Date today() {
        return parseDate(formatDate(new Date()));
    }

    public static Date now() {
        return new Date();
    }

    public static Date tomorrow() {
        return parseDate(formatDate(new DateTime(new Date()).plusDays(1).toDate()));
    }

    public static Date tomorrow(Date date) {
        return parseDate(formatDate(new DateTime(date).plusDays(1).toDate()));
    }

    public static Date yesterday(Date date) {
        return parseDate(formatDate(new DateTime(date).minusDays(1).toDate()));
    }

    public static Date yesterday() {
        return parseDate(formatDate(new DateTime(new Date()).minusDays(1).toDate()));
    }

    public static int getDaysExcludedMonthsBetween(Date startDate, Date endDate) {
        int months = Months.monthsBetween(new DateTime(startDate), new DateTime(endDate)).getMonths();
        return Days.daysBetween(startOfTodayWithTime(), new DateTime(endDate).minusMonths(months)).getDays();
    }

    public static int getMonthsBetween(Date startDate, Date endDate) {
        return Months.monthsBetween(new DateTime(startDate), new DateTime(endDate)).getMonths();
    }

    public static int getYearsBetween(Date startDate, Date endDate) {
        return Years.yearsBetween(new DateTime(startDate), new DateTime(endDate)).getYears();
    }

    public static Date minuteBefore(int minutes) {
        return DateTime.now().minuteOfHour().addToCopy(-minutes).toDate();
    }

    public static Date asDefaultZone(String date) {
        return DateTime.parse(date).toDateTime(DateTimeZone.getDefault()).toDate();
    }

    public static Date getExpiredDateAfterMinutes(int minutes) {
        return new DateTime().plusMinutes(minutes).toDate();
    }

    public static boolean isTimeout(Date expiredDate) {
        return new DateTime(expiredDate).isBeforeNow();
    }

    public static boolean isBeforeDay(Date createDate, Date date) {
        return new DateTime(createDate).isBefore(new DateTime(date));
    }

    public static Date getOneYearLaterAfterToady() {
        return endOfDay(DateTime.now().plusYears(1).minusDays(1).toDate());
    }

    public static Date getBeforeDaysByCurrentTime(int days) {
        return DateTime.now().dayOfYear().addToCopy(-days).toDate();
    }

    public static Date getAfterDaysByCurrentTime(int days) {
        return DateTime.now().dayOfYear().addToCopy(days).toDate();
    }

    public static String formatDateToChineseHhmm(Date date) {
        return formatDate(date, DATE_FORMAT_CHINESE_HHMM);
    }

    public static String formatDateToChineseHhmmss(Date date) {
        return formatDate(date, DATE_FORMAT_CHINESE_HHMMSS);
    }

    public static Date getPlusDay(Date startDate, int day) {
        return new DateTime(startDate).plusDays(day).toDate();
    }

    public static Date getPlusMonthsDay(Date startDate, int months) {
        return new DateTime(startDate).plusMonths(months).toDate();
    }

    public static Date getMinusMonthsDay(Date startDate, int months) {
        return parseDate(formatDate(new DateTime(startDate).minusMonths(months).toDate()));
    }

    public static Date getMorningAtSeven() {
        return new DateTime(startOfToday()).plusHours(7).toDate();
    }


    public static Date getFirstDayByCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getEndDayByCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 系统每周的第一天是从星期天开始的
     *
     * @return
     */
    public static Date getLastWeekLastDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static Date getDateBeforeChooseDay(Date chooseDay, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(chooseDay);
        cal.add(Calendar.DATE, -day);
        return cal.getTime();
    }
}
