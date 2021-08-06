package com.exampleProject.spring;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class indexController {
	
	@RequestMapping("/")
    public ModelAndView template(ModelMap model) {
        //return new ModelAndView("index");
        return new ModelAndView("redirect:/genticket");
    }

}
