package com.stk.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Practice 100 bicycle shots";
    }

}