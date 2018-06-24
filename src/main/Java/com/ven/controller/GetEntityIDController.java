package com.ven.controller;

import com.hibernate.model.ImageEntity;
import com.ven.service.ImageDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/get")
public class GetEntityIDController {
    final private ImageDownloadService imageDownloadService;

    @Autowired
    public GetEntityIDController(ImageDownloadService imageDownloadService) {
        this.imageDownloadService = imageDownloadService;
    }

    @RequestMapping("/ids")
    @ResponseBody
    public List<Integer> getIDs()
    {
        List<ImageEntity> imageEntities = imageDownloadService.selectAll();
        List<Integer> res = new ArrayList<>();
        for(ImageEntity entity: imageEntities)
        {
            res.add(entity.getId());
        }
        Collections.reverse(res);
        return res;
    }
}
