package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component //Marks the class as a Spring bean(a regular Java class which is managed by Spring)
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }

    @Override
    public String getDailyDiet(){
        return "Eat 5000 kcal a day!!!!";
    }
}
