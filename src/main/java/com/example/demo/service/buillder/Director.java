package com.example.demo.service.buillder;

public class Director {
    public Buillder buillder;

    public Director(Buillder buillder) {
        this.buillder = buillder;
    }

    public void construct() {
        buillder.builldPartA();
        buillder.builldPartB();
    }
}
