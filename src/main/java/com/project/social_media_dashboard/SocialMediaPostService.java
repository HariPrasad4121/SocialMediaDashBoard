package com.project.social_media_dashboard;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaPostService {
    @Autowired
    private SocialMediaPostRepository repository;

    public List<SocialMediaPost> getAllPosts() {
        return repository.findAll();
    }

    public SocialMediaPost savePost(SocialMediaPost post) {
        return repository.save(post);
    }
}

