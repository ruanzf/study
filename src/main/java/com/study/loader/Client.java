package com.study.loader;

/**
 * Created by ruan on 2016/7/5.
 */
public class Client {

    public static void main(String[] args) {
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);

        try {
            Class myObjectClass = classLoader.loadClass("com.study.loader.DemoObject");
            DemoInterface demoObject = (DemoInterface) myObjectClass.newInstance();
            demoObject.saySth();

            //不重新new 一个ClassLoader会报错 attempted  duplicate class definition for name: "com/study/loader/DemoObject"
            MyClassLoader classLoader1 = new MyClassLoader(parentClassLoader);
            Class myObjectClass1 = classLoader1.loadClass("com.study.loader.DemoObject");
            DemoInterface demoObject1 = (DemoInterface) myObjectClass1.newInstance();
            demoObject1.saySth();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
