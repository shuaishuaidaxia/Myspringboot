package com.example.demo4.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @RequestMapping("/testaop")
    public String saytest(){
        System.out.println("hello");
        return "text";
    }
}
