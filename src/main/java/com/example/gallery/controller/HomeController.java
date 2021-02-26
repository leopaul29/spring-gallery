package com.example.gallery.controller;

import com.example.gallery.data.Album;
import com.example.gallery.data.Photo;
import com.example.gallery.service.AlbumConsumerService;
import com.example.gallery.service.AlbumConsumerServiceImpl;
import com.example.gallery.service.PhotoConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private AlbumConsumerService albumConsumerService;
    @Autowired
    private PhotoConsumerService photoConsumerService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @RequestMapping(path = {"/", "/albums"})
    public String home(Model model) {
        List<Album> albumList = albumConsumerService.processAlbumDataFromAlbumArray();
        model.addAttribute("albumList", albumList);
        return "home";
    }

    @RequestMapping("/albums/{id}")
    public String album(Model model, @PathVariable Long id) {
        Album album = albumConsumerService.processAlbumDataFromAlbum(id);
        model.addAttribute("album", album);

        List<Photo> photos = photoConsumerService.processPhotoDataFromAlbum(id);
        model.addAttribute("photos", photos);

        return "album";
    }
}
