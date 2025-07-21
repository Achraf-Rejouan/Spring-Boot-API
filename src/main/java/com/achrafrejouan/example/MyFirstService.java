package com.achrafrejouan.example;

import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private MyFirstClass myFirstClass;

    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }
}
