package com.achrafrejouan.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    @PostMapping("/post")
    public String post(@RequestBody String body) {
        return "Post request received : " + body;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order) {
        return "Post orders : " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(@RequestBody OrderRecord order) {
        return "Post orders : " + order.toString();
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable("name") String UserName) {
        return "Hello, " + UserName + "!";
    }
}

