package com.study.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.lookup;


/**
 * Created by ruan on 2016/7/6.
 */
public class MethodHandleTest {

    private static int SIZE = 10000000;

    private static MethodHandle methodHandle(Object receiver) {
        MethodType mt = MethodType.methodType(void.class, String.class);
        try {
            return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if(null == args || args.length <= 0) {
            System.out.println("SIZE is " + SIZE);
        }else {
            SIZE = Integer.parseInt(args[0]);
        }

        testMethodHandle();
        testReflect();
        testNative();
    }

    private static void testMethodHandle() {
        PrintObject printObject = new PrintObject();
        MethodHandle mh = methodHandle(printObject);
        try {
            long start = System.currentTimeMillis();
            System.out.println("testMethodHandle start at:" + start);
            for (int i=0;i<SIZE;i++) {
                mh.invokeExact(Integer.toString(i));
            }
            System.out.println("");
            long end = System.currentTimeMillis();
            System.out.println("testMethodHandle end at:" + end + ", use time:" + (end - start));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static void testReflect() {
        PrintObject printObject = new PrintObject();
        Method method = null;
        try {
            method = PrintObject.class.getDeclaredMethod("println", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            long start = System.currentTimeMillis();
            System.out.println("testReflect start at:" + start);
            for (int i=0;i<SIZE;i++) {
                method.invoke(printObject, Integer.toString(i));
            }
            System.out.println("");
            long end = System.currentTimeMillis();
            System.out.println("testReflect end at:" + end + ", use time:" + (end - start));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void testNative() {
        PrintObject printObject = new PrintObject();
        long start = System.currentTimeMillis();
        System.out.println("testNative start at:" + start);
        for (int i=0;i<SIZE;i++) {
            printObject.println(Integer.toString(i));
        }
        System.out.println("");
        long end = System.currentTimeMillis();
        System.out.println("testNative end at:" + end + ", use time:" + (end - start));
    }
}
