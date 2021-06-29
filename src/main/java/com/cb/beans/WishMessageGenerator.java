package com.cb.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Setter
@Getter
@Component("wmg")
public class WishMessageGenerator {
    @Autowired
    @Qualifier("ltd1")
    private LocalDateTime date;
public String generateWishMessage(String User){
    int hour= date.getHour();
    if (hour<12)
        return "Good Morning !"+User+".";
    else if (hour<16)
        return "Good AfterNoon !"+User+".";
    else if (hour<20)
        return "Good Evening !"+User+".";
    else
        return "Good Night !"+User+".";
}
}
