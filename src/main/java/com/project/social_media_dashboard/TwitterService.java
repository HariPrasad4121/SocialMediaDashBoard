package com.project.social_media_dashboard;


import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterService {

    private Twitter twitter;

    public TwitterService() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("LZTiaDi46Auo9qJYpSAwmpBEC")
          .setOAuthConsumerSecret("EKRQBzQnaJMC5x4kRNq8AErFx9ER5akcJLtdxx8FwaeQFPmozy")
          .setOAuthAccessToken("1819317357120262144-jQh149uqg4XwGD2SQhqijh1s3g5Jwr")
          .setOAuthAccessTokenSecret("f0w9QsasKugrcvr5NQTSBSsKW0w6eDdBrOdFuW0UiLu4U");

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public List<Status> fetchTweets(String hashtag) throws TwitterException {
        Query query = new Query(hashtag);
        QueryResult result = twitter.search(query);
        return result.getTweets();
    }
}
