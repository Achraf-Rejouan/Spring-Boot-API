package com.achrafrejouan.example;

public class MyFirstClass {
    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello world ! ==> myVar = " + myVar;
    }
}
