package com.study.json;

import java.util.Random;

/**
 * Created by ruan on 2016/6/30.
 */
public class JsonBean2 {

    private static Random random = new Random();

    private int one;
    private double two;
    private boolean three;

    public JsonBean2() {
        this.one = random.nextInt();
        this.two = random.nextDouble();
        this.three = random.nextBoolean();
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public double getTwo() {
        return two;
    }

    public void setTwo(double two) {
        this.two = two;
    }

    public boolean isThree() {
        return three;
    }

    public void setThree(boolean three) {
        this.three = three;
    }
}
