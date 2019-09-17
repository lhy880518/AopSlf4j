package com.basic.my.controller;

import com.basic.my.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

    @Autowired
    testService testService;

    @RequestMapping("/")
    public String mainPage(ModelMap modelMap){
        modelMap.addAttribute("ko","한글");
        testService.testDo();
        return "/main";
    }
}
