package com.achrafrejouan.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("First Bean");
    }
}
