package com.jadson.study.dao;

import com.jadson.study.model.User;

import java.util.List;

public interface UserDao {
    List<User> selectListReadOnly();
}
