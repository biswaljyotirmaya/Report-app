package com.jb.reportapp.controller;

import com.jb.reportapp.service.IRepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportController {
    @Autowired
    private IRepostService repostService;

    @GetMapping("/")
    public String indexPage(){
        System.out.println("HOME HIT");
        return "index";
    }

    @GetMapping("/demo")
    public String getDemo(){
        System.out.println("HOME HIT");
        return "demo";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "working";
    }


}
