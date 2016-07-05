package com.study.proxy;

/**
 * Created by ruan on 2016/7/5.
 */
public class RealSubject2 implements DemoInterface, Subject{

    public void request() {
        System.out.println("this is request of RealSubject2");
    }

    public void callSubject() {
        System.out.println("this is callSubject of RealSubject2");
    }
}
