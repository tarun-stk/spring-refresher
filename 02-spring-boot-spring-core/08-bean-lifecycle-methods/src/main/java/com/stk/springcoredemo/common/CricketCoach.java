package com.stk.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

//    define our init method
//    Creates bean on startup of app
    @PostConstruct
    public void doStartupStuff(){
        System.out.println("In doStartupStuff(): " + getClass().getSimpleName());
    }


//    define our destroy method
//    destroys bean on stoppping of app
    @PreDestroy
    public void doCleanupStuff(){
        System.out.println("In doCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice 15 mins fast bowling";
    }

}
