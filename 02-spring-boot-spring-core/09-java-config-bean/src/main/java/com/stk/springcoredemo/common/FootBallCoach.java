package com.stk.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        System.out.println("In constructor: " + getClass().getSimpleName());
        return "Practice 100 bicycle shots";
    }

}