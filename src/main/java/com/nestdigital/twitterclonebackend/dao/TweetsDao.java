package com.nestdigital.twitterclonebackend.dao;

import com.nestdigital.twitterclonebackend.model.TweetsModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TweetsDao extends CrudRepository<TweetsModel,Integer> {



    @Query(value = "select t.tweets, t.datetime, u.name from tweets t join users u on u.id = t.user_id ORDER BY datetime DESC",nativeQuery = true)
    List<Map<String,String >> findAllTw();

    @Query(value = "select t.tweets, t.datetime, u.name from tweets t join users u on u.id = t.user_id where t.user_id = :id ORDER BY datetime DESC",nativeQuery = true)
    List<Map<String,String >> findByUserId(Integer id);

    @Modifying
    @Query(value = "UPDATE `tweets` SET `tweets`=:tweet WHERE `id` = :id",nativeQuery = true)
    void updateById(Integer id);

}
