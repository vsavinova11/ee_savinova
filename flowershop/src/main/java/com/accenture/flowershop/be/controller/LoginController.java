package com.accenture.flowershop.be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam (required = false, value = "error") String error, ModelAndView model){
        if (error != null)
        {
            model.addObject("error", "Failed authentication");
        }
        return model;
    }
}
