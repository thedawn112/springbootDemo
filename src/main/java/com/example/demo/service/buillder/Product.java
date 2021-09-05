package com.example.demo.service.buillder;

import java.util.ArrayList;

public class Product {
    ArrayList<String> parts = new ArrayList<String>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println(parts);
    }
}
