package com.achrafrejouan.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {
    private final MyFirstClass myFirstClass;
    @Value("${my.custom.property}")
    private String customProperty;


    @Value("${my.custom.property.int}")
    private Integer customProperty2;


    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }

    public String getCustomProperty() {
        return customProperty;
    }
    public Integer getCustomProperty2() {
        return customProperty2;
    }
}
