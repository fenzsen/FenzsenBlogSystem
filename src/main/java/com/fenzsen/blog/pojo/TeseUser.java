package com.fenzsen.blog.pojo;

import java.io.Serializable;

public class TeseUser implements Serializable {
    private String name;
    private int age;
    private String gender;
    private String password;

    public TeseUser(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private TestHouse house;

    public TestHouse getHouse() {
        return house;
    }

    public void setHouse(TestHouse house) {
        this.house = house;
    }
}
