package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //Basically, we are trying to tell Spring that TrackCoach is the primary coach, so when deciding getDailyWorkou() method from the coaches coach, choose this TrackCoach's method. So no need to use @Qualifier, but @Qualifier still has higher priority. There's only one @Primary class, multiple is not allowed
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyDiet() {
        return "";
    }
}
