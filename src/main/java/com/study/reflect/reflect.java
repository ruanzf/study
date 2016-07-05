package com.study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruan on 2016/6/29.
 */
public class Reflect {

    private List<Integer> list = new ArrayList<Integer>();

    private static List<ObjectTwo> getList(List<String> list) {
        return null;
    }

    public static void main(String[] args) {
        returnType();
        parameterType();
        fieldType();
    }

    private static void returnType() {
        try {
            Method method = Reflect.class.getDeclaredMethod("getList", List.class);
            Type returnType = method.getGenericReturnType();
            showActualType(returnType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void parameterType() {
        try {
            Method method = Reflect.class.getDeclaredMethod("getList", List.class);
            Type[] returnTypes = method.getGenericParameterTypes();
            showActualType(returnTypes[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void fieldType() {
        try {
            Field field = Reflect.class.getDeclaredField("list");
            Type fieldType = field.getGenericType();
            showActualType(fieldType);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void showActualType(Type type) {
        if(type instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            for(Type typeArgument : typeArguments){
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }
}

