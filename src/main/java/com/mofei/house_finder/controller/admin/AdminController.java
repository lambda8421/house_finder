package com.mofei.house_finder.controller.admin;

import com.mofei.house_finder.base.APIResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    @RequestMapping(value = "admin/upload/photo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public APIResponse uploadPhoto(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return APIResponse.ofStatus(APIResponse.Status.NOT_VALID_PARAM);
        }

        String fileName = file.getOriginalFilename();
        File target = new File("/Users/mofei/IdeaProjects/house_finder/tmp"+fileName);
        try {
            file.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return APIResponse.ofSuccess(null);
    }
}
