package com.nestdigital.twitterclonebackend.dao;

import com.nestdigital.twitterclonebackend.model.TwitterModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TwitterDao extends CrudRepository<TwitterModel,Integer> {

    @Query(value = "SELECT * FROM `users` WHERE email = :email AND password =:password",nativeQuery = true)
    List<TwitterModel> authenticate(String email,String password);
}
