package com.ztev.springlayout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping(value = "signin")
    public String signIn()
    {
        return "signin/sign-in";
    }

}
