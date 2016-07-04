package com.study.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ruan on 2016/6/29.
 */
public class ClassReflect {

    private static Class clazz;

    public static void main(String[] args) throws ClassNotFoundException {
        clazz = Class.forName("com.study.reflect.ObjectOne");
//        methods();
//        invoke();
//        fields();
        others();
    }

    private static void methods() {
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }

    private static void invoke(){
        try {
            Method method = clazz.getMethod("pri");
            method.invoke(clazz.getConstructors()[0].newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void fields() {
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields) {
            try {
                f.setAccessible(true);
                System.out.println(String.format("%s - %s", f.getName(), f.get(new ObjectOne()).toString()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void others() {
        System.out.println(clazz.getPackage().getName());

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println(anno.toString());
        }

        Class<?>[] cs = clazz.getInterfaces();
        for (Class<?> c : cs) {
            System.out.println(c.getName());
        }

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c.getName());
        }
    }
}
