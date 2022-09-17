package com.java.basic.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * Date格式化
     */
    public static String dateformat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date da = new Date();
        String ss = sdf.format(da);
        return ss;
    }

    /**
     * String转Date
     */
    public static Date stringToDate(String s) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        return date;
    }

    /**
     * Date转Timestamp
     */
    public static Timestamp dataToTimestamp() {
        Timestamp createTime = new Timestamp(new Date().getTime());
        return createTime;
    }

    /**
     * Timestamp转Date
     */
    public static Date timestampToData() {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        Date d = new Date(t.getTime());
        return d;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtil.dateformat());
        System.out.println(DateUtil.stringToDate("2019-09-02"));
        System.out.println(DateUtil.dataToTimestamp());
        System.out.println(DateUtil.timestampToData());
    }

}
