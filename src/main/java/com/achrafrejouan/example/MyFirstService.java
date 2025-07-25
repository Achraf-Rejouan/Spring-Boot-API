package com.achrafrejouan.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    private MyFirstClass myFirstClass;
    private Environment environment;

    @Autowired
    public void setMyFirstClass(@Qualifier("bean1")MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }

    public String getOsName(){
        return environment.getProperty("os.name");
    }

    public String readProp  (){
        return environment.getProperty("my.custom.property");
    }

    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
