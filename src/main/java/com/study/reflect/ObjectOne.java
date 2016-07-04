package com.study.reflect;

/**
 * Created by ruan on 2016/6/29.
 */
@Deprecated
public class ObjectOne extends ObjectTwo implements ObjectThree{


    public String pubStr = "public String";
    protected String protectedbStr = "protected String";
    private String priStr = "private String";

    public ObjectOne() {

    }

    public ObjectOne(String priStr) {
        this.priStr = priStr;
    }

    public void pub() {
        System.out.println(pubStr);
    }

    public void pro() {
        System.out.println(protectedbStr);
    }

    public void pri() {
        System.out.println(priStr);
    }

    public void sayHi() {
        System.out.println("HI");
    }
}
