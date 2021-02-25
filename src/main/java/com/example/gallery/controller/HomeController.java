package com.example.gallery.controller;

import com.example.gallery.data.Album;
import com.example.gallery.service.AlbumConsumerService;
import com.example.gallery.service.AlbumConsumerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private AlbumConsumerService albumConsumerService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @RequestMapping("/")
    public String home(Model model) {
        /*final String uri = "https://jsonplaceholder.typicode.com/albums";
        RestTemplate restTemplate = new RestTemplate();



        String albumList = restTemplate.getForObject(uri, String.class);

*/
        List<Album> albumList = albumConsumerService.processAlbumDataFromAlbumArray();


        log.info(albumList.toString());
        model.addAttribute("albumList", albumList);
        return "home";
    }
}
