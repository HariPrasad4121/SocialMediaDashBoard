package com.project.social_media_dashboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class SocialMediaPostController {
    @Autowired
    private SocialMediaPostService service;

    @Autowired
    private TwitterService twitterService;

    
    @GetMapping
    public List<SocialMediaPost> getAllPosts() {
    	System.out.println("Server is up and running at port");
        return service.getAllPosts();
    }

    @GetMapping("/twitter/{hashtag}")
    public List<Status> getTweets(@PathVariable String hashtag) throws TwitterException {
        return twitterService.fetchTweets(hashtag);
    }
}
