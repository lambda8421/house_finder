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

    /**
     * 后台管理中心
     * @return
     */
    @GetMapping("/admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }

    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/admin/welcome")
    public String welcomePage() {
        return "admin/welcome";
    }

    /**
     * 管理员登录页
     * @return
     */
    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    /**
     * 新增房源功能页
     * @return
     */
    @GetMapping("admin/add/house")
    public String addHousePage() {
        return "admin/house-add";
    }

    /**
     * 房源列表页
     * @return
     */
    @GetMapping("admin/house/list")
    public String houseListPage() {
        return "admin/house-list";
    }

    @RequestMapping(value = "admin/upload/photo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public APIResponse uploadPhoto(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return APIResponse.ofStatus(APIResponse.Status.NOT_VALID_PARAM);
        }

        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        File target = new File("/Users/mofei/IdeaProjects/house_finder/tmp/"+fileName);
        try {
            file.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return APIResponse.ofSuccess(null);
    }
}
