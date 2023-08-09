package com.stk.springcoredemo.common;

//Not using @Component anno on purpose

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 metres as a warm up";
    }
}
