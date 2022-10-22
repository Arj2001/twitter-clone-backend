package com.nestdigital.twitterclonebackend.controller;

import com.nestdigital.twitterclonebackend.dao.TwitterDao;
import com.nestdigital.twitterclonebackend.model.TwitterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TwitterController {

    @Autowired
    private TwitterDao dao;

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

}
