package com.nestdigital.twitterclonebackend.dao;

import com.nestdigital.twitterclonebackend.model.TweetModel;
import com.nestdigital.twitterclonebackend.model.TwitterModel;
import com.nestdigital.twitterclonebackend.controller.ViewTweets;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetDao extends CrudRepository<TweetModel,Integer> {


    @Modifying
    @Query(value = "INSERT INTO `tweets`(id,`datetime`, `tweet`, `user_id`) VALUES (:id,:datetime,:tweet,:user_id)",nativeQuery = true)
    void addTweet(Integer id,String datetime,String tweet, TwitterModel user_id);

    @Query(value = "SELECT t.id, t.datetime, t.tweet, t.user_id,u.name FROM Tweets AS t JOIN Users AS u ON t.user_id = u.id ORDER BY datetime DESC",nativeQuery = true)
    List<ViewTweets> viewTweets();
}
