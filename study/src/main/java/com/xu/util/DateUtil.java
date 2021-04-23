package com.xu.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: canjin
 * @Date: 2021/2/7
 * 说明:
 */
public class DateUtil {

    private static final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter formatter3=DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 得到当前日期
     * @return
     */
    public static LocalDate getDate(){
        return LocalDate.now();
    }

    /**
     * 得到当前日期
     * @return
     */
    public static String getDateToString(){
        return LocalDate.now().toString();
    }

    /**
     * 得到当前时间 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateTime(){
        LocalDateTime time=LocalDateTime.now();
        return time.format(formatter);
    }

    /**
     * 得到当前时间 yyyy/MM/dd HH:mm:ss
     * @return
     */
    public static String dateTime2(){
        LocalDateTime time=LocalDateTime.now();
        return time.format(formatter2);
    }

    /**
     * 判断当前时间是否大于某个时点
     * @param time HH:mm:ss 要使用LocalTime比较
     * @return
     */
    public static boolean timeCompare(String time){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime=LocalTime.parse(time,dtf);
        return LocalTime.now().isAfter(localTime);
    }

    /**
     * 判断当前时间是否大于某个时间
     * @param time yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static boolean dateCompare(String time){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localTime=LocalDateTime.parse(time,dtf);
        return LocalDateTime.now().isAfter(localTime);
    }

    /**
     * 判断当前日期是否大于某个日期
     * @param date yyyy-MM-dd
     * @return
     */
    public static boolean afterDate(String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localTime=LocalDate.parse(date,dtf);
        return LocalDate.now().isAfter(localTime);
    }

    /**
     * 得到加减某个值的日期
     * @return
     */
    public static String getDateBydays(long days){
        //days为-1就是昨天日期，为1就是明天日期

        LocalDate localDate=LocalDate.now().plusDays(days);
        return localDate.toString();
    }

    /**
     * 得到加减天数的时间
     * @return
     */
    public static LocalDateTime getTimeBydays(long days){
        //days为-1就是昨天日期，为1就是明天日期
        LocalDateTime localDate=LocalDateTime.now().plusDays(days);
        return localDate;
    }

    /**
     * 得到加减分钟数的时间 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getTimeByMinutes(long minutes){
        LocalDateTime localDate=LocalDateTime.now().plusMinutes(minutes);
        return localDate.format(formatter);
    }

    /**
     * 得到加减分钟数的时间 HH:mm:ss
     * @return
     */
    public static String getTimeByMinutes2(long minutes){
        LocalTime localTime=LocalTime.now().plusMinutes(minutes);
        return localTime.format(formatter3);
    }
}
