package com.ym.lab2;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LabController {

	@GetMapping("/")
    public ModelAndView home() 
	{
	    ModelAndView mview = new ModelAndView("index"); 
		mview.addObject("greeting", getGreeting());
	    return mview;
    }

	private String getGreeting() {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isBefore(LocalTime.NOON)) {
            return "Good morning, Yin-Siang";
        } else {
            return "Good evening, Yin-Siang";
        }
    }
}
