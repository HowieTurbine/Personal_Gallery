package com.ven.controller;

import com.hibernate.model.ImageEntity;
import com.ven.service.ImageDownloadService;
import com.ven.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/get")
public class GetImageController {
    final private ImageDownloadService imageDownloadService;

    @Autowired
    public GetImageController(ImageDownloadService imageDownloadService) {
        this.imageDownloadService = imageDownloadService;
    }

    @RequestMapping("/image")
    @ResponseBody
    public String getImage(@RequestParam(value = "id", required = true) int id,
                         HttpServletResponse httpServletResponse) throws IOException {
        ImageEntity imageEntity = imageDownloadService.select_by_id(id);
        byte[] img = imageEntity.getImages();
        httpServletResponse.setContentType("image/png");
        OutputStream os = httpServletResponse.getOutputStream();
        os.write(img);
        os.flush();
        os.close();
        return "success";
    }
}
