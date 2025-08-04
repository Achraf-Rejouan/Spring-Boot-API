package com.achrafrejouan.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    //@GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/post")
    public String post(@RequestBody String body) {
        return "Post request received : " + body;
    }
    //3:28:57
}

