package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component  //marks a class as a Spring Bean(a Java regular class) so that Spring can find the class
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }

    @Override
    public String getDailyDiet() {
        return "";
    }
}
