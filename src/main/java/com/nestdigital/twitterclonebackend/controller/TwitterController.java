package com.nestdigital.twitterclonebackend.controller;

import com.nestdigital.twitterclonebackend.dao.TweetsDao;
import com.nestdigital.twitterclonebackend.dao.TwitterDao;
import com.nestdigital.twitterclonebackend.model.TweetsModel;
import com.nestdigital.twitterclonebackend.model.TwitterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class TwitterController {

    @Autowired
    private TwitterDao dao;

    @Autowired
    private TweetsDao tweetsDao;

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
    public String addTweet(@RequestBody TweetsModel tweet){
        tweetsDao.save(tweet);
        return "success";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewTweets")
    public List<TweetsModel> viewTweets(){
        return (List<TweetsModel>) tweetsDao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewUserTweet",consumes = "application/json",produces = "application/json")
    public List<TweetsModel> findByUserId(@RequestBody TweetsModel tweets){
        return (List<TweetsModel>) tweetsDao.findByUserId(tweets.getUser_id());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteTweet",consumes = "application/json",produces = "application/json")
    public void deleteById(@RequestBody TweetsModel tweets){
        tweetsDao.deleteById(tweets.getId());
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editTweet",consumes = "application/json",produces = "application/json")
    public void editById(@RequestBody TweetsModel tweets){
        tweetsDao.updateById(tweets.getId());
    }

}
