package com.xu.test;

import com.xu.util.DateUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: canjin
 * @Date: 2021/2/7
 * 说明:
 */
public class DateTest {
    public static void main(String[] args) {

        System.out.println(DateUtil.getDateToString());
        System.out.println(DateUtil.dateTime());
        if(DateUtil.timeCompare("15:10:11")){
            System.out.println(11);
        }else{
            System.out.println(22);
        }

        //System.out.println(DateUtil.dateCompare("2021-02-07 15:10:10"));
        System.out.println(DateUtil.getDateBydays(-1));
        System.out.println(DateUtil.getDateBydays(1));
        System.out.println(DateUtil.getTimeByMinutes2(-30));
    }

}
