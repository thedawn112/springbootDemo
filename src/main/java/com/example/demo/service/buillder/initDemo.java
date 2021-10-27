package com.example.demo.service.buillder;

import java.io.*;
import java.util.ArrayList;

/**
 * @author ranran.mao
 * @date 2021/9/2 1:13
 */
public class initDemo {
    @initMethod
    public void init() {
        System.out.println("inti........");
    }

    public void test() {
    }

    public static void main(String[] args) {
        Person person = new Person();
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("F:\\学习资料\\haha.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
             objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
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
}