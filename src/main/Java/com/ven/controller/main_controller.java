package com.ven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class main_controller extends ExceptionController{
    @RequestMapping("/main")
    public String main()
    {
        return "index.html";
    }
    @RequestMapping("/new")
    public String newPage()
    {
        return "new.html";
    }


}
