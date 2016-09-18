/*
 *   Copyright (C)  2016 android@19code.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.chzz.library;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Create by h4de5ing 2016/5/7 007
 */
public class DateUtils {
    private static final SimpleDateFormat DATE_FORMAT_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_FORMAT_TIME = new SimpleDateFormat("HH:mm:ss");

    public static String formatDataTime(long date) {
        return DATE_FORMAT_DATETIME.format(new Date(date));
    }

    public static String formatDate(long date) {
        return DATE_FORMAT_DATE.format(new Date(date));
    }

    public static String formatTime(long date) {
        return DATE_FORMAT_TIME.format(new Date(date));
    }

    public static String formatDateCustom(String beginDate, String format) {
        return new SimpleDateFormat(format).format(new Date(Long.parseLong(beginDate)));
    }

    public static String formatDateCustom(Date beginDate, String format) {
        return new SimpleDateFormat(format).format(beginDate);
    }

    public static Date string2Date(String s, String style) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(style);
        Date date = null;
        if (s == null || s.length() < 6) {
            return null;
        }
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        return cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    }

    public static long subtractDate(Date dateStart, Date dateEnd) {
        return dateEnd.getTime() - dateStart.getTime();
    }

    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    public static int getWeekOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week - 1;
    }

    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            day = 7;
        } else {
            day = day - 1;
        }
        return day;
    }


    /**
     * yyyy-MM-dd HH:mm:ss 将日期转换为字符串
     *
     * @param date
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDetail(Date date) throws Exception {
        String dateStr = "";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        dateStr = sf.format(date);
        return dateStr;
    }

    /**
     * 将日期转换为字符串
     *
     * @param date
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatYMD(Date date) {
        String dateStr = "";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        dateStr = sf.format(date);
        return dateStr;
    }

    /**
     * 将字符串转换为日期
     *
     * @param strDate 格式 yyyy-MM-dd HH:mm:ss
     * @return
     * @throws Exception
     */
    public static Date stringToDate(String strDate) throws Exception {

        Date date = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sf.parse(strDate);
        return date;
    }

    /**
     * 将字符串转换为日期
     *
     * @param strDate 格式 yyyy-MM-dd HH:mm:ss
     * @return
     * @throws Exception
     */
    public static Date stringToDates(String strDate) {

        Date date = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将日期转换为字符串
     *
     * @param strDate 格式 yyyy-MM-dd HH:mm:ss
     * @return
     * @throws Exception
     */
    public static String dateToString(Date date) throws Exception {

        String s = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        s = sf.format(date);
        return s;
    }

    /**
     * 将日期转换为字符串
     *
     * @param strDate 格式HH:mm:ss
     * @return
     * @throws Exception
     */
    public static String formatTohmins(int s) throws Exception {

        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        String r = sf.format(s);
        return r;
    }

    /**
     * 将日期转换为字符串
     *
     * @param strDate 格式HH:mm
     * @return
     * @throws Exception
     */
    public static String formatTohourmin(Date date) throws Exception {

        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
        String r = sf.format(date);
        return r;
    }

    /**
     * 将日期格式化为年月日的字符串
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        String dateStr = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
        dateStr = sf.format(date);
        return dateStr;
    }

    /**
     * 将日期格式化为MM月dd日的字符串
     *
     * @param date
     * @return
     */
    public static String formatToMMdd(Date date) {
        String dateStr = null;
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
        dateStr = sf.format(date);
        return dateStr;
    }

    /**
     * 将yyyy年MM月dd日格式化为date
     *
     * @param date
     * @return
     */
    public static Date formaToDate(String s) {
        Date date = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            date = sf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * MMDD
     *
     * @param date
     * @return
     */
    public static String format2(Date date) {
        String dateStr = null;
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
        dateStr = sf.format(date);
        return dateStr;
    }

    public static Date format3(String date) {
        Date dateStr = null;
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
        try {
            dateStr = sf.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * 得到星期几
     *
     * @param date
     * @return
     */
    public static String formatToWeek(Date date) {
        String weekStr = null;
        SimpleDateFormat sf = new SimpleDateFormat("EEEE");
        weekStr = sf.format(date);
        return weekStr;
    }

    /**
     * 处理时间格式
     *
     * @param date 日期
     * @param time 时间
     * @return 返回秒
     */
    public static long getMillisFromStringDate(String date, String time) {
        String splitter = null;
        System.out.println(date + time + "***************************");
        Calendar cal = Calendar.getInstance();
        if (date.contains("-")) {
            splitter = "-";
        } else if (date.contains("/")) {
            splitter = "/";
        }
        String[] dateArray = date.split(splitter);// YYYY/MM/DD
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]) - 1;// zero based
        int day = Integer.parseInt(dateArray[2]);
        String[] timeArray = time.split(":"); // HH:MM
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);
        int seconds = 0;
        cal.set(year, month, day, hour, minute, seconds);
        return cal.getTimeInMillis();
    }

    /**
     * 处理时间格式
     *
     * @param time 时间
     * @return
     */
    public static long getMillisFromStringTime(String time) {
        System.out.println(time + "=====================");
        Calendar cal = Calendar.getInstance();
        String[] timeArray = time.split(":"); // HH:MM
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH), hour, minute);
        return cal.getTimeInMillis();
    }
}
