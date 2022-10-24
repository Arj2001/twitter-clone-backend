package com.nestdigital.twitterclonebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tweets")
public class TweetModel {

    @Id
    @GeneratedValue
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private TwitterModel user;



    private String tweet,datetime;

    public TweetModel() {
    }

    public TweetModel(int id, TwitterModel user, String tweet, String datetime) {
        this.id = id;
        this.user = user;
        this.tweet = tweet;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TwitterModel getUser() {
        return user;
    }

    public void setUser(TwitterModel user) {
        this.user = user;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
