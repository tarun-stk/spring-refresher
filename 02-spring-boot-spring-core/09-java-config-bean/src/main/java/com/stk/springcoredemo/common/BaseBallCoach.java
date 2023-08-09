package com.stk.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    @Override
    public String getDailyWorkout(){

        System.out.println("In constructor: " + getClass().getSimpleName());
        return "Practice 100 throwballs";
    }

}