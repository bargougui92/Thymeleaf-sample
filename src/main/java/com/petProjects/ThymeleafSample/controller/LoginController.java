package com.petProjects.ThymeleafSample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/landing")
    public String showLanding(){
        //landing page
        return "landing";
    }

    @GetMapping("/showMyLoginPage")
    public String showLoginPage() {
        return "fancy-login";
    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }
}
