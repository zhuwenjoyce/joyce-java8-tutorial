package com.joyce.java8;

import java.util.function.Supplier;

class MyStringThrowable extends Throwable implements Supplier<String> {
    String code;
    String msg;

    public MyStringThrowable(){

    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String get() {
        return "MyStringThrowable-error!!!";
    }
}
