package com.achrafrejouan.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    public MyFirstService(@Qualifier("bean2") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }
}
