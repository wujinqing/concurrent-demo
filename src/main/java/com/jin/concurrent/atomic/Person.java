package com.jin.concurrent.atomic;

/**
 * @author wu.jinqing
 * @date 2017年03月30日
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
