package com.nestdigital.twitterclonebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class TweetsModel {

    @Id
    @GeneratedValue
    private int id;

    private int user_id;
    private String name,datetime,tweets;

    public TweetsModel(int id, int user_id, String name, String datetime, String tweets) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.datetime = datetime;
        this.tweets = tweets;
    }

    public TweetsModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTweets() {
        return tweets;
    }

    public void setTweets(String tweets) {
        this.tweets = tweets;
    }
}
