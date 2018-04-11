package com.shen.learn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
    @Value("${com.shen.chapter1.name}")
    private String name;
    @Value("${com.shen.chapter1.title}")
    private String title;
    @Value("${com.shen.chapter1.desc}")
    private String desc;
    @Value("${com.shen.chapter1.value}")
    private String value;
    @Value("${com.shen.chapter1.int}")
    private int num;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getValue() {
        return value;
    }

    public int getNum() {
        return num;
    }
}
