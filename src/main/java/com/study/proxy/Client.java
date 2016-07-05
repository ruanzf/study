package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * Created by ruan on 2016/7/5.
 */
public class Client {

    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
    }

    private static void test1() {
        //被代理的对象
        RealSubject realSubject = new RealSubject();
        Class<?> classType = Subject.class;
        System.out.println(classType); //interface com.main.DynamicProxy.Subject

        InvocationHandler handler = new DynamicSubject(realSubject);
        Subject subject = (Subject)Proxy.newProxyInstance(classType.getClassLoader(), new Class[]{Subject.class}, handler);

        //方法的真正的执行是在代理类的invoke方法,并将参数分别传送过去
        subject.request();

        System.out.println(classType.getClassLoader());
        System.out.println(subject.getClass());
    }

    private static void test2() {
        //测试part2
        //RealSubject2实现的是callSubject方法,和上个Subject里面的方法不一样,被代理的类的方法以及方法的参数可以动态生成;如果是静态代理,必须要知道被代理类里面有那些具体的方法.
        RealSubject2 realSubject2 = new RealSubject2();
        InvocationHandler handler = new DynamicSubject(realSubject2);
        Class<?> classType2 =handler.getClass();
        System.out.println(handler.getClass()); //class com.main.DynamicProxy.DynamicSubject

        //转换为接口类型
        DemoInterface demoInterface = (DemoInterface) Proxy.newProxyInstance(classType2.getClassLoader(), realSubject2.getClass().getInterfaces(), handler);
        demoInterface.callSubject();

        System.out.println("\n\n\n");
        Subject subject = (Subject) Proxy.newProxyInstance(classType2.getClassLoader(), realSubject2.getClass().getInterfaces(), handler);
        subject.request();
        System.out.println("\n\n\n");
        System.out.println(demoInterface.getClass()); //class com.sun.proxy.$Proxy1
        System.out.println(subject.getClass()); //class com.sun.proxy.$Proxy1
    }

    private static void test3() {
        //测试factory方法
        RealSubject2 realSubject = new RealSubject2();
        Subject subject = (Subject)DynamicSubject.factory(realSubject);
        subject.request();
        System.out.println(subject.getClass());
    }
}