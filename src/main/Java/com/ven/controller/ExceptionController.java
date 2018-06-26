package com.ven.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView ExceptionHandler(Exception exceededException) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/views/html/new.html");
        return modelAndView;
    }
}
