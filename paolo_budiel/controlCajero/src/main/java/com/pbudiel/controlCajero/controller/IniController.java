package com.pbudiel.controlCajero.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IniController {    
    @RequestMapping("/home")
    public String loginMessage(){
        return "Home";
    }
}
