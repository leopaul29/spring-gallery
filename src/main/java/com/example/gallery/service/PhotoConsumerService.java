package com.example.gallery.service;

import com.example.gallery.data.Photo;

import java.util.List;

public interface PhotoConsumerService {
    List<Photo> processPhotoDataFromPhotoArray();
    List<Photo> processPhotoDataFromAlbum(Long id);
    Photo processPhotoDataFromPhoto(Long id);
}
