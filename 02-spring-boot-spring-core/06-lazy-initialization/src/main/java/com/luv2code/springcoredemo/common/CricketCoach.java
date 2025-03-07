package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component //Marks the class as a Spring bean(a regular Java class which is managed by Spring)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("I'm in constructor of: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }

    @Override
    public String getDailyDiet(){
        return "Eat 5000 kcal a day!!!!";
    }
}
