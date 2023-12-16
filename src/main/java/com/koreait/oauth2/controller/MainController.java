package com.koreait.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
    @ResponseBody

    @GetMapping("/")
    public String main(){
        return "HELLO";
    }

    @GetMapping("/login")
    public void login(){

    }
}
