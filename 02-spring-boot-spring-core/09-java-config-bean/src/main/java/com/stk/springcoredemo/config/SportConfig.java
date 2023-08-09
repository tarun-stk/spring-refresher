package com.stk.springcoredemo.config;

import com.stk.springcoredemo.common.Coach;
import com.stk.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {


//    Method name must be of bean id swimCoach in this case
//    U can also give your custom bean id inside @Bean anno

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
