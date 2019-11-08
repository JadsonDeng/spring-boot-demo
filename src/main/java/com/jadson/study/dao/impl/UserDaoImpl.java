package com.jadson.study.dao.impl;

import com.jadson.study.config.dynamicds.EnableMasterSlave;
import com.jadson.study.dao.UserDao;
import com.jadson.study.mapper.UserMapper;
import com.jadson.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMasterSlave
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectListReadOnly() {
        return userMapper.selectList();
    }
}
