package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hp on 2017/3/4.
 */
@Controller
public class BaseController {
    @RequestMapping(value = {"/","index"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/regist")
    public String regist(){
        return "regist";
    }

    @RequestMapping("/mine")
    public String mine(){
        return "mime";
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
