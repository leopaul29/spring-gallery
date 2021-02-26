package com.example.gallery.service;

import com.example.gallery.data.Photo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotoConsumerServiceImpl implements PhotoConsumerService {
    private final RestTemplate restTemplate;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/photos";

    public PhotoConsumerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Photo> processPhotoDataFromPhotoArray() {
        ResponseEntity<Photo[]> responseEntity =
                restTemplate.getForEntity(BASE_URL, Photo[].class);

        Photo[] photoArray = responseEntity.getBody();
        return Arrays.stream(photoArray)
                .collect(Collectors.toList());
    }

    public List<Photo> processPhotoDataFromAlbum(Long id){
        ResponseEntity<Photo[]> responseEntity =
                restTemplate.getForEntity(BASE_URL, Photo[].class);

        Photo[] photoArray = responseEntity.getBody();
        return Arrays.stream(photoArray)
                .filter(photo -> photo.getAlbumId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public Photo processPhotoDataFromPhoto(Long id) {
        ResponseEntity<Photo> responseEntity =
                restTemplate.getForEntity(BASE_URL + "/"+ id, Photo.class);
        return responseEntity.getBody();
    }
}
