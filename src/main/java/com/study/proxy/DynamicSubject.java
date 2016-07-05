package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ruan on 2016/7/5.
 */
public class DynamicSubject implements InvocationHandler {
    private Object subject;

    public DynamicSubject(Object subject) {
        this.subject=subject;
    }
    //被代理的类的方法以及方法的参数可以动态生成;
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call "+method);
        method.invoke(subject, args);
        System.out.println("after call "+method);
        return null;
    }

    public static Object factory(Object object){
        Class<?> classType = object.getClass();
        return Proxy.newProxyInstance(classType.getClassLoader(), classType.getInterfaces(), new DynamicSubject(object));
    }


}
