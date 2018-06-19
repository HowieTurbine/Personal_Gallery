package com.ven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class main_controller{
    @RequestMapping("/main")
    public String main()
    {
        return "index.html";
    }
}
