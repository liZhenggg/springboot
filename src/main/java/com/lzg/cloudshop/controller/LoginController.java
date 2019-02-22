package com.lzg.cloudshop.controller;

import com.lzg.cloudshop.bean.InitInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class LoginController {

    @Autowired
    private InitInfo initInfo;

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/login/{name}/{pwd}")
    public String login(@PathVariable(value = "name") String userName,
                        @PathVariable String pwd) {
        return "login:" + "userName:" + userName + ",password:" + pwd + "initInfo:"
                + initInfo.getParamInfo1() + "," + initInfo.getParamInfo2();
    }

    @GetMapping(value = "/login2")
    public String login2(@RequestParam(value = "name",
            defaultValue = "defaultName") String userName,
                         @RequestParam String pwd) {
        return "welcome";
//        return "login2:" + "userName:" + userName + ",password:" + pwd;
    }

    @PostMapping(value = "/login3/{name}/{pwd}")
    public String login3(@PathVariable(value = "name") String userName,
                         @PathVariable String pwd) {
        return "login3:" + "userName:" + userName + ",password:" + pwd;
    }

    @PostMapping(value = "/login4")
    public String login4(@RequestParam(value = "name",
            defaultValue = "defaultName") String userName,
                         @RequestParam String pwd) {
        return "login4:" + "userName:" + userName + ",password:" + pwd;
    }
}
