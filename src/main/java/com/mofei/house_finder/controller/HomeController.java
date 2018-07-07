package com.mofei.house_finder.controller;

import com.mofei.house_finder.base.APIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/x")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/xxx",method = RequestMethod.GET)
    @ResponseBody
    public APIResponse get(){
        return APIResponse.ofMessage(200,"SUCCESS");
    }

    @GetMapping(value = "/403")
    public String accessError(){
        return "403";
    }

    @GetMapping(value = "/404")
    public String pageNotFound(){
        return "404";
    }

    @GetMapping(value = "/500")
    public String internalError(){
        return "500";
    }
}
