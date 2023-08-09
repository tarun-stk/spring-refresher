package com.stk.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
//When you use lazy anno spring will not create bean by default
//It will create only when ask for it, it will first create and then inject
public class FootBallCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        System.out.println("In constructor: " + getClass().getSimpleName());
        return "Practice 100 bicycle shots";
    }

}