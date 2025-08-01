package com.achrafrejouan.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping("/hello2")
    public String hello2() {
        return "Hello form my first controller!";
    }
}
