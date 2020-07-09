package com.petProjects.ThymeleafSample.dao;

import com.petProjects.ThymeleafSample.entity.User;

public interface UserDao {

    public User findByUserName(String userName);

    public void save(User user);

}