package com.ven.service;

import com.hibernate.model.ImageEntity;
import com.hibernate.session.UploadSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageUploadService {
    final UploadSession uploadSession;

    @Autowired
    public ImageUploadService(UploadSession uploadSession) {
        this.uploadSession = uploadSession;
    }

    public void upload(MultipartFile file, String author, String content,String fileName) throws IOException {
        ImageEntity imageEntity=new ImageEntity();
        byte[] data=file.getBytes();
        imageEntity.setFileName(fileName);
        imageEntity.setImages(data);
        imageEntity.setAuthor(author);
        imageEntity.setDes(content);
        uploadSession.Upload(imageEntity);
    }
}
