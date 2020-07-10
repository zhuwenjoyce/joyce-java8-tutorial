package com.joyce.java8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

public class Jdk8日期转换类 {
    private static Logger logger = LoggerFactory.getLogger(Jdk8日期转换类.class);

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
     *      各种日期之间互转
     ***********************************************
     */

    @Test
    public void util_date_互转_LocalDate() {  // java.util.Date 转 LocalDate
        // java.util.Date 转 LocalDate
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();

        // LocalDate 转 java.util.Date
        LocalDate localDate2 = LocalDate.now();
        Instant instant2 = localDate2.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date2 = java.util.Date.from(instant2);
    }
    @Test
    public void util_date_互转_LocalDateTime() {  // java.util.Date 转 LocalDateTime
        // util Date 转 LocalDateTime
        java.util.Date date = new java.util.Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        // LocalDateTime 转 util Date
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        date = java.util.Date.from(instant);
    }
    @Test
    public void util_date_互转_sql_Timestamp(){  // java.util.Date 转 java.sql.Timestamp
        //  LocalDateTime
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        logger.info("java.util.Date转java.sql.Timestamp，timestamp===" + timestamp.toString());

        // LocalDateTime 转 util Date
        LocalDateTime localDateTime2 = timestamp.toLocalDateTime();
    }

    @Test
    public void util_date_互转_LocalTime() {  // java.util.Date 转 LocalTime
        // LocalTime 转 java.util.Date
        java.util.Date date = new java.util.Date();
        Instant instant =date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
        LocalDate localDate = localDateTime.toLocalDate();

        // java.util.Date 转 LocalTime
        LocalTime localTime2 = LocalTime.now();
        LocalDate localDate2 = LocalDate.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate2, localTime2);
        Instant instant2 = localDateTime2.atZone(zone).toInstant();
        java.util.Date date2 = java.util.Date.from(instant2);
    }

    @Test
    public void LocalDate_互转_Timestamp() {
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
        logger.info("LocalDate_转_Timestamp，localDate===" + localDate);

        localDate = localDate.minusDays(7);
        LocalDateTime localDateTime = localDate.atTime(0,0);
        Timestamp timestamp2 = Timestamp.valueOf(localDateTime);
        logger.info("Timestamp_转_LocalDate，timestamp2===" + timestamp2);
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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
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
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        logger.info("String转java.sql.Timestamp，timestamp===" + timestamp.toString());
    }


    /***********************************************
     *      日期增减与间隔
     ***********************************************
     */

    @Test
    public void LocalDate日期间隔(){
        LocalDate start = LocalDate.of(2018, 3,5);
        LocalDate end = LocalDate.of(2018, 4,11);
        Period period = Period.between(start, end);
        logger.info("LocalDate日期间隔 "+ period.getYears() +" 年"); // 0
        logger.info("LocalDate日期间隔 "+ period.getMonths() +" 月"); // 1
        logger.info("LocalDate日期间隔 "+ period.getDays() +" 天"); // 6
    }

    @Test
    public void LocalDate日期间隔_第二种方法(){
        LocalDate startDate = LocalDate.of(2018, 3,5);
        LocalDate endDate = LocalDate.of(2018, 4,11);
        int start_month = startDate.getMonthValue();	//开始日期月份
        int start_day = startDate.getDayOfMonth();		//开始日期天数
        int end_year = endDate.getYear();				//结束日期年份
        int end_month = endDate.getMonthValue();		//结束日期月份
        int end_day = endDate.getDayOfMonth();			//结束日期天数

        long y = ChronoUnit.YEARS.between(startDate, endDate);		//计算两个日期间的年
        long m = ChronoUnit.MONTHS.between(startDate, endDate);		//计算两个日期间的月
        long d = ChronoUnit.DAYS.between(startDate, endDate);		//计算两个日期间的天
        logger.info("LocalDate日期间隔 "+ y +" 年"); // 0
        logger.info("LocalDate日期间隔 "+ m +" 月"); // 1
        logger.info("LocalDate日期间隔 "+ d +" 天"); // 37
    }

    @Test
    public void Timestamp日期间隔(){
        Timestamp startTimestamp = Timestamp.valueOf(LocalDate.of(2018, 3,1).atTime(0,0));
        Timestamp endTimestamp =  Timestamp.valueOf(LocalDate.of(2018, 4,1).atTime(0,0));
        LocalDateTime startTime = startTimestamp.toLocalDateTime();
        LocalDateTime endTime = endTimestamp.toLocalDateTime();

        long y = ChronoUnit.YEARS.between(startTime, endTime);		//计算两个日期间的年
        long m = ChronoUnit.MONTHS.between(startTime, endTime);		//计算两个日期间的月
        long d = ChronoUnit.DAYS.between(startTime, endTime);		//计算两个日期间的天
        logger.info("LocalDate日期间隔 "+ y +" 年"); // 0
        logger.info("LocalDate日期间隔 "+ m +" 月"); // 1
        logger.info("LocalDate日期间隔 "+ d +" 天"); // 31
    }
}
