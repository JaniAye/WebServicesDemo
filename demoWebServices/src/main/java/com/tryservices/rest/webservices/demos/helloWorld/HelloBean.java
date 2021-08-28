package com.tryservices.rest.webservices.demos.helloWorld;

public class HelloBean {
    private  String msg;

    public HelloBean(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "HelloBean{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
