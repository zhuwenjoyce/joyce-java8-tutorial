package com.joyce.java8.线程并发测试;

import java.io.Serializable;
import java.util.List;

public class ResultUtil<T> implements Serializable {

    private static final long serialVersionUID = 3436477890959388400L;

    private ResultUtil(){}

    private ResultUtil(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    String code;
    String msg;
    List<T> list;
    T obj;

    public static final ResultUtil SUCCESS = new ResultUtil("0000", "");
    public static final ResultUtil FAIL_COMMON = new ResultUtil("9999", "");
    public static final ResultUtil FAIL_LOCK_COUPON = new ResultUtil("1010","coupon被锁定");
    public static final ResultUtil FAIL_PARAM = new ResultUtil("1101","缺少业务参数");
    public static final ResultUtil FAIL_LOCK_TIMEOUT = new ResultUtil("1102","锁定时间超时");

    // getter and setter

    public ResultUtil setCode(String code) {
        this.code = code;
        return this;
    }

    public ResultUtil setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List<T> getList() {
        return list;
    }

    public ResultUtil setList(List<T> list) {
        this.list = list;
        return this;
    }

    public T getObj() {
        return obj;
    }

    public ResultUtil setObj(T obj) {
        this.obj = obj;
        return this;
    }
}

