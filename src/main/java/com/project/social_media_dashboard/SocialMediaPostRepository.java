package com.project.social_media_dashboard;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaPostRepository extends JpaRepository<SocialMediaPost, Integer> {
}
