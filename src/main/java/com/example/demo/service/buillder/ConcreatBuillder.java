package com.example.demo.service.buillder;

public class ConcreatBuillder extends Buillder {
    private Product product = new Product();

    @Override
    public void builldPartA() {
        System.out.println("构建产品上半部分");
    }

    @Override
    public void builldPartB() {
        System.out.println("构建产品下半部分");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
