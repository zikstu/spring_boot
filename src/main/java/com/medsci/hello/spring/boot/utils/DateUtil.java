package com.medsci.hello.spring.boot.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @description: 时间工具
 * @author: 学长
 * @date: 2021/2/1 15:39
 */
public class DateUtil {
    /**
     * 将unix元年至某个日期的毫秒转为指定的格式
     * @param Millisecond 毫秒
     * @param format 格式
     * @return
     */
    public static String generateTimeFormatter(long Millisecond ,String format){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(format);
        Instant instant = Instant.ofEpochMilli(Millisecond);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(pattern);
    }
}
