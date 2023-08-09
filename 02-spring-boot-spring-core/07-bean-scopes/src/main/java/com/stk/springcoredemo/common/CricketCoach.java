package com.stk.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){

        System.out.println("In constructor: " + getClass().getSimpleName());

        return "Practice 15 mins fast bowling";
    }

}
