package com.study.json;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.*;

/**
 * Created by ruan on 2016/6/30.
 */
public class JsonBean {

    private static Random random = new Random();

    @JSONField(name = "aaaage")
    private int age;
    @JSONField(serialize=false)
    private String name;
    private double money;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private List<JsonBean2> beanList;
    private Map<String, JsonBean2> beanMap;

    public JsonBean() {
    }

    private JsonBean(int age, String name, double money, List<JsonBean2> beanList, Map<String, JsonBean2> beanMap) {
        this.age = age;
        this.name = name;
        this.money = money;
        this.beanList = beanList;
        this.beanMap = beanMap;
        this.date = new Date();
    }

    public static JsonBean generate() {
        int size = random.nextInt(4);
        size = size > 0 ? size : 1;
        List<JsonBean2> bean2s = new ArrayList<JsonBean2>(size);
        Map<String, JsonBean2> beanMap = new HashMap<String, JsonBean2>(4);
        for (int i=0; i< size; i++) {
            bean2s.add(new JsonBean2());
            beanMap.put(String.valueOf(i), new JsonBean2());
        }

        return new JsonBean(random.nextInt(), "JsonBean", random.nextDouble(), bean2s, beanMap);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<JsonBean2> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<JsonBean2> beanList) {
        this.beanList = beanList;
    }

    public Map<String, JsonBean2> getBeanMap() {
        return beanMap;
    }

    public void setBeanMap(Map<String, JsonBean2> beanMap) {
        this.beanMap = beanMap;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
