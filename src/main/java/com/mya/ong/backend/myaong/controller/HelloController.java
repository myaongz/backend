package com.mya.ong.backend.myaong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController

public class HelloController {
    @GetMapping("/")
    public String hello () {
        return "Hello World!";
    }
}
