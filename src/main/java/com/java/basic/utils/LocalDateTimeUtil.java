package com.java.basic.utils;


import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LocalDateTimeUtil {

    /**
     * LocalDateTime时区转换
     */
    private static LocalDateTime getZoneDateTime() {
        ZoneId zoneIdAS = ZoneId.of("Asia/Shanghai");
        ZoneId zoneIdAC = ZoneId.of("America/Chicago");
        return LocalDateTime.now().atZone(zoneIdAS)
                .withZoneSameInstant(zoneIdAC)
                .toLocalDateTime();
    }

    /**
     * LocalDateTime UTC格式转换
     */
    public static String localDateTimeToUTC() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime now = LocalDateTime.now();
        String startLdt = now.minus(30, ChronoUnit.DAYS).format(dateTimeFormatter);
        String endLdt = now.format(dateTimeFormatter);
        return endLdt;
    }

    /**
     * LocalDateTime当前时间减10分钟
     */
    public static LocalDateTime localDateTimeSubtractTenMinutes() {
        return LocalDateTime.now().minus(10, ChronoUnit.MINUTES);
    }

    /**
     * LocalDateTime转Date
     */
    public static Date localDateTimeToDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDateTime转时间戳
     */
    public static long localDateTimeToLong() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000;
    }

    /**
     * 时间戳转LocalDateTime（时区是东8区，也就是北京时间）
     */
    public static LocalDateTime longToLocalDateTime() {
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return LocalDateTime.ofEpochSecond(timestamp / 1000, 0, ZoneOffset.ofHours(8));
    }


    /**
     * LocalDateTime转Timestamp
     */
    public static Timestamp localDateTimeToTimestamp() {
        return Timestamp.valueOf(LocalDateTime.now());
    }

    /**
     * Timestamp转LocalDateTime
     */
    public static LocalDateTime timestampToLocalDateTime() {
        Timestamp time = Timestamp.from(Instant.now());
        return time.toLocalDateTime();
    }

    /**
     * LocalDate转时间戳
     */
    public static long localDateToLong() {
        return LocalDate.now().atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli() / 1000;
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTimeUtil.getZoneDateTime());
        System.out.println(LocalDateTimeUtil.localDateTimeToUTC());
        System.out.println(LocalDateTimeUtil.localDateTimeSubtractTenMinutes());
        System.out.println(LocalDateTimeUtil.localDateTimeToDate());
        System.out.println(LocalDateTimeUtil.localDateTimeToLong());
        System.out.println(LocalDateTimeUtil.longToLocalDateTime());
        System.out.println(LocalDateTimeUtil.localDateTimeToTimestamp());
        System.out.println(LocalDateTimeUtil.timestampToLocalDateTime());
        System.out.println(LocalDateTimeUtil.localDateToLong());
    }

}
