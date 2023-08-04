package com.stk.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fun")
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Practice 100 throwballs";
    }

}
