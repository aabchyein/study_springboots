package com.example.study_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
@GetMapping({"/", "/home", "/main"})
    public ModelAndView main(ModelAndView modelAndView){
        modelAndView.addObject("name", "HyeIn!");  // 자료를 jsp로 넘김
        modelAndView.setViewName("/webapp/WEB-INF/views/main.jsp");
        return modelAndView;
    }
}