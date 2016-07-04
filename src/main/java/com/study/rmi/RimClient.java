package com.study.rmi;

import java.rmi.Naming;

/**
 * Created by ruan on 2016/7/4.
 */
public class RimClient {

    public static void main(String[] args) throws Exception {
        String url = "rmi://localhost:1099/com.study.rmi.HelloServiceImpl";
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.sayHello("Jack");
        System.out.println(result);
    }
}
