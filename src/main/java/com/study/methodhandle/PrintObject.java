package com.study.methodhandle;

/**
 * Created by ruan on 2016/7/6.
 */
public class PrintObject {

    public void println(String s) {
        int r = sth();
        boolean b = sth(r);
        b = false;
        if(b) {
            System.out.println(s);
        }
    }

    private int sth() {
        int a = 0;
        int b = 1;
        int c = a;
        a = b;
        b = c;
        return a + b;
    }

    private boolean sth(int a) {
        if (a > 0) {
            return true;
        }
        return false;
    }
}
