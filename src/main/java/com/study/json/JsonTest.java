package com.study.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.NameFilter;

/**
 * Created by ruan on 2016/6/30.
 *
 * https://github.com/alibaba/fastjson/wiki/%E5%AE%9A%E5%88%B6%E5%BA%8F%E5%88%97%E5%8C%96
 *
 * 就不明白  文档对代码有写说明  为啥源码点开就没说明！
 * 比如JSONField
 * https://github.com/alibaba/fastjson/wiki/JSONField
 *
 * https://github.com/alibaba/fastjson/wiki/SerializeFilter
 */
public class JsonTest {

    public static void main(String[] args) {
        JsonBean jsonBean = JsonBean.generate();
        String jsonStr = JSON.toJSONString(jsonBean);
        System.out.println(jsonStr);
        JsonBean jsonBean1 = JSON.parseObject(jsonStr, JsonBean.class);
        System.out.println(jsonBean1.getAge() + " " + jsonBean1.getBeanList().get(0).getOne());

        jsonStr = JSON.toJSONString(jsonBean, new NameFilter() {
            public String process(Object object, String name, Object value) {
                if ("money".equals(name)) {
                    return name + "update";
                }
                return name;
            }
        });
        System.out.println(jsonStr);
    }

}
