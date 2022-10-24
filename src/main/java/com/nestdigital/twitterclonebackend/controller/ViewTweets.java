package com.nestdigital.twitterclonebackend.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewTweets {

    private int id;
    private String datetime;
    private String tweet;
    private int user_id;
    private String name;
}
