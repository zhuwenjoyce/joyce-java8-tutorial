package com.joyce.java8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

public class Demo10_DateTime {
    private static Logger logger = LoggerFactory.getLogger(Demo10_DateTime.class);

    /***********************************************
     *      错误示例与正例
     ***********************************************
     */

    @Test
    public void LocalDate_to_String_错误示例_LocalDate不包含时分秒不能使用HHmmss(){
        try{
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String text = date.format(formatter);
        }catch (UnsupportedTemporalTypeException e){
            logger.error("错误示例: LocalDate不包含时分秒不能使用HH:mm:ss, 应该用LocalDateTime, "+e.getMessage(), e);
        }
    }
    @Test
    public void String_to_LocalDateTime_错误示例_LocalDateTime格式化必须包含时分秒HHmmss(){
        try {
            String 日期string = "2020-04-13";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime parsedDate = LocalDateTime.parse(日期string, formatter);
        }catch (DateTimeException e){
            logger.error("LocalDateTime格式化必须包含时分秒HH:mm:ss, " + e.getMessage(), e);
        }
    }

    @Test
    public void LocalDateTime_to_String_正例_但是LocalDateTime可以使用格式yyyy_MM_dd(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String 日期string = date.format(formatter);
        logger.info("LocalDateTime转String，日期string===" + 日期string);
    }

    /***********************************************
     *      各种日期转String
     ***********************************************
     */

    @Test
    public void LocalDate_to_String(){ //得到不包含时分秒的字符串
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String 日期string = date.format(formatter);
        logger.info("LocalDate转String，日期string===" + 日期string);
    }
    @Test
    public void LocalDateTime_to_String(){ // 得到包含时分秒的字符串
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String 日期string = date.format(formatter);
        logger.info("LocalDateTime转String，日期string===" + 日期string);
    }
    @Test
    public void java_util_Date_to_String(){ // java.util.Date 转 String
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String 日期string = localDateTime.format(formatter);
        logger.info("java.util.Date转String，日期string===" + 日期string);
    }
    @Test
    public void java_sql_Date_to_String(){ // java.sql.Date 转 String
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        LocalDate localDate = sqlDate.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String 日期string = localDate.format(formatter);
        logger.info("java.sql.Date转String，日期string===" + 日期string);
    }
    @Test
    public void java_sql_Timestamp_to_String(){ // Timestamp 转 String
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String 日期string = localDateTime.format(formatter);
        logger.info("java.sql.Timestamp转String，日期string===" + 日期string);
    }


    /***********************************************
     *      String转各种日期
     ***********************************************
     */

    @Test
    public void String_to_LocalDate(){  // String 转 LocalDate
        String 日期string = "2020-04-13";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(日期string, formatter);
        logger.info("String转LocalDate，LocalDate===" + parsedDate.toString());
    }
    @Test
    public void String_to_LocalDateTime(){  // String 转 LocalDateTime
        String 日期string = "2020-04-13 18:49:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parsedDate = LocalDateTime.parse(日期string, formatter);
        logger.info("String转LocalDateTime，LocalDateTime===" + parsedDate.toString());
    }
    @Test
    public void String_to_java_util_Date(){  // String 转 java.util.Date
        String 日期string = "2020-04-13";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(日期string, formatter);
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        java.util.Date utilDate = java.util.Date.from(instant);
        logger.info("String转java.util.Date，date===" + utilDate.toString());
    }
    @Test
    public void String_to_java_sql_Date(){  // String 转 java.sql.Date
        String 日期string = "2020-04-20";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(日期string, formatter);
        java.sql.Date date = java.sql.Date.valueOf(localDate);
        logger.info("String转java.sql.Date，date===" + date.toString());
    }
    @Test
    public void String_to_java_sql_Timestamp(){  // String 转 java.sql.Date
        String 日期string = "2020-04-20 19:20:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(日期string, formatter);
        java.sql.Timestamp timestamp = Timestamp.valueOf(localDateTime);
        logger.info("String转java.sql.Timestamp，timestamp===" + timestamp.toString());
    }

}
