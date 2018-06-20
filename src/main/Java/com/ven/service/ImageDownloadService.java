package com.ven.service;

import com.hibernate.model.ImageEntity;
import com.hibernate.session.DownloadSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageDownloadService {
    final
    DownloadSession downloadSession;

    @Autowired
    public ImageDownloadService(DownloadSession downloadSession) {
        this.downloadSession = downloadSession;
    }

    public List<ImageEntity> selectAll()
    {
        return downloadSession.downloadAll();
    }

    public ImageEntity select_by_id(int id)
    {
        return downloadSession.download_by_id(id);
    }

}
