package com.ven.controller;

import com.hibernate.model.ImageEntity;
import com.ven.service.ImageDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/get")
public class GetContentController {
    final private ImageDownloadService imageDownloadService;

    @Autowired
    public GetContentController(ImageDownloadService imageDownloadService) {
        this.imageDownloadService = imageDownloadService;
    }
    @RequestMapping("/content")
    @ResponseBody
    public Map<String,String> getContent(@RequestParam(value = "id", required = true) int id)
    {
        ImageEntity imageEntity = imageDownloadService.select_by_id(id);
        String author = imageEntity.getAuthor();
        Map<String,String> res=new HashMap<>();
        res.put("author",imageEntity.getAuthor());
        res.put("content",imageEntity.getDes());
        return res;
    }
}
