package com.ven.controller;

import com.ven.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    private void fildUpload(@RequestParam(value = "file", required = false) MultipartFile file, String author, String content, String fileName) throws Exception
    {
        service.upload(file,author,content,fileName);
    }
}
