package com.mofei.house_finder.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin/center",method = RequestMethod.GET)
    public String centerPage(){
        return "/admin/center";
    }

    @RequestMapping(value = "/admin/welcome",method = RequestMethod.GET)
    public String welcomePage(){
        return "/admin/welcome";
    }

    @RequestMapping(value = "/admin/login",method = RequestMethod.GET)
    public String loginPage(){
        return "/admin/login";
    }
}
