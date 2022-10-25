package com.nestdigital.twitterclonebackend.dao;

import com.nestdigital.twitterclonebackend.model.TweetsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetsDao extends CrudRepository<TweetsModel,Integer> {


    @Override
    @Query(value = "select * from tweets ORDER BY datetime DESC",nativeQuery = true)
    List<TweetsModel> findAll();

    @Query(value = "select * from tweets where user_id = :id ORDER BY datetime DESC",nativeQuery = true)
    List<TweetsModel> findByUserId(Integer id);

}
