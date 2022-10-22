package com.nestdigital.twitterclonebackend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class TwitterModel {

    @Id
    @GeneratedValue
    private int id;

    private String name,dob,place,email,password,phone;

    public TwitterModel(int id, String name, String dob, String place, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.place = place;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public TwitterModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
