package com.nestdigital.twitterclonebackend.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class TwitterModel {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "user")
    private List<TweetModel> tweets;

    private String name,dob,place,email,password,phone;


    public TwitterModel() {
    }

    public TwitterModel(int id, List<TweetModel> tweets, String name, String dob, String place, String email, String password, String phone) {
        this.id = id;
        this.tweets = tweets;
        this.name = name;
        this.dob = dob;
        this.place = place;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TweetModel> getTweets() {
        return tweets;
    }

    public void setTweets(List<TweetModel> tweets) {
        this.tweets = tweets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
