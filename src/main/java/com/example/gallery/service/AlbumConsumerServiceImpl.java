package com.example.gallery.service;

import com.example.gallery.data.Album;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumConsumerServiceImpl implements AlbumConsumerService {

    private final RestTemplate restTemplate;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/albums";

    public AlbumConsumerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Album> processAlbumDataFromAlbumArray() {

        ResponseEntity<Album[]> responseEntity =
                restTemplate.getForEntity(BASE_URL, Album[].class);
        Album[] albumArray = responseEntity.getBody();
        return Arrays.stream(albumArray)
                //.map(Album::getTitle)
                .collect(Collectors.toList());
    }
}
