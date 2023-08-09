package com.stk.springcoredemo.rest;

import com.stk.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fun")
public class FunRestController {


    private Coach myCoach;

//    Even after having multiple Coach implmentaiton classes
//    It will consider cricketCoach as it has primary anno on top of class
//    You can also use primary and qualifier together
//    But qualifier has higher priority so whatever is tagged to qualifier will override primary
//    Also you cannot have multiple implementation classes as primary
//    Spring will confuse on which it should use because there are two primary beans
    @Autowired
    public FunRestController(Coach theCoach){
        myCoach = theCoach;
    }



    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
