package com.stk.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Practice 100 throwballs";
    }

}