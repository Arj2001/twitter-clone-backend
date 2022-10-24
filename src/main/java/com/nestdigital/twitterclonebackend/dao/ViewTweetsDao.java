package com.nestdigital.twitterclonebackend.dao;

import com.nestdigital.twitterclonebackend.controller.ViewTweets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ViewTweetsDao extends CrudRepository<ViewTweets,Integer> {

    @Query(value = "SELECT t.id, t.datetime, t.tweet, t.user_id,u.name FROM Tweets AS t JOIN Users AS u ON t.user_id = u.id ORDER BY datetime DESC",nativeQuery = true)
    List<ViewTweets> viewTweets();
}
