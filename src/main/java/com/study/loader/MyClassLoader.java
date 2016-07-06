package com.study.loader;

import java.io.*;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ruan on 2016/7/5.
 */
public class MyClassLoader extends ClassLoader {

    private final static String path = MyClassLoader.class.getResource("").getPath();

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        if(!"com.study.loader.DemoObject".equals(name))
            return super.loadClass(name);

        try {
            String filePath = path + "DemoObject.class";
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("file not found");
                return null;
            }
            InputStream input = new FileInputStream(file);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while(data != -1){
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();

            return defineClass("com.study.loader.DemoObject",
                    classData, 0, classData.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
