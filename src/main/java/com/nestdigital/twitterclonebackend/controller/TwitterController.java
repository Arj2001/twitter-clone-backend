package com.nestdigital.twitterclonebackend.controller;

import com.nestdigital.twitterclonebackend.dao.TweetDao;
import com.nestdigital.twitterclonebackend.dao.TwitterDao;
import com.nestdigital.twitterclonebackend.dao.ViewTweetsDao;
import com.nestdigital.twitterclonebackend.model.TweetModel;
import com.nestdigital.twitterclonebackend.model.TwitterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TwitterController {

    @Autowired
    private TwitterDao dao;

    @Autowired
    private TweetDao tweetDao;

    @Autowired
    private ViewTweetsDao viewTweetsDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addUser",consumes = "application/json",produces = "application/json")
    public String addUser(@RequestBody TwitterModel twitter){
        dao.save(twitter);
        return "success";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/auth",consumes = "application/json",produces = "application/json")
    public List<TwitterModel> authenticate(@RequestBody TwitterModel twitter){
        return (List<TwitterModel>) dao.authenticate(twitter.getEmail(), twitter.getPassword());
    }



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addTweet",consumes = "application/json",produces = "application/json")
    public String addTweet(@RequestBody TweetModel tweet){
        System.out.println(tweet.getUser());
        tweetDao.save(tweet);
        return "success";
    }

//    @CrossOrigin(origins = "*")
//    @GetMapping(path = "/viewTweets")
//    public List<TweetModel> viewTweets(){
//        return (List<TweetModel>) tweetDao.viewTweets();
//    }


//    @CrossOrigin(origins = "*")
//    @GetMapping(path = "/viewTweets")
//    public ResponseEntity<List<ViewTweets>> viewTweets(){
//        return new ResponseEntity<>(tweetDao.viewTweets()) ;
//    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewTweets")
    public List<ViewTweets> viewTweets(){
        return (List<ViewTweets>) viewTweetsDao.viewTweets();
    }
}
