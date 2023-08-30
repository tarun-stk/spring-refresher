package com.stk.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneService implements FortuneService{
    @Override
    public String getFortune() {
//        Creating delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        return fortune
        return "Expect heavy traffic today morning";

    }

    @Override
    public String getFortune(boolean tripWire) {
//        throw exception based on trupWire
        if(tripWire){
            throw new RuntimeException("Bad News, Major Accident: Highway closed!!");
        }
        return getFortune();
    }
}
