package com.study.proxy;

/**
 * Created by ruan on 2016/7/5.
 */
public class RealSubject implements Subject{

    public void request() {
        System.out.println("this is request of RealSubject");
    }
}
