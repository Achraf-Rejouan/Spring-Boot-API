package com.achrafrejouan.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {
    private final MyFirstClass myFirstClass;


    @Value("The Nemesis Of Life")
    private String customProperty;

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;

    @Value("123")
    private String customPropertyInt;


    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }
    public String getCustomProperty() {
        return customProperty;
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyInt() {
        return customPropertyInt;
    }

}
