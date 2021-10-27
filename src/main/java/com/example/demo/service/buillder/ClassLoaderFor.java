package com.example.demo.service.buillder;

import java.io.File;

/**
 * @author ranran.mao
 * @date 2021/9/27 19:11
 */
public class ClassLoaderFor {
    public static void main(String[] args) {
        UserForTest userForTest = new UserForTest();
        File file = new File(userForTest.getClass().getResource("/").getPath());
        System.out.println(file);
        ClassLoader classLoader;

    }
}
class UserForTest{
    private int age;
    private String name;

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

    @Override
    public String toString() {
        return "UserForTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}