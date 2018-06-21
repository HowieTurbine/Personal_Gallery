package com.ven.controller;

import com.ven.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ImageUploadController {
    private final ImageUploadService service;

    @Autowired
    public ImageUploadController(ImageUploadService service) {
        this.service = service;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String fildUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                            @RequestParam(value = "author", required = false)String author,
                            @RequestParam(value = "content", required = false)String content) throws Exception
    {
        System.out.println(file.getName());
        service.upload(file,author,content);
        return file.getName();
    }
}
