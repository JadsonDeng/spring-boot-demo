package com.jadson.study.mybatisplus.springbootmybatisplus;

import com.jadson.study.mybatisplus.springbootmybatisplus.mapper.UserMapper;
import com.jadson.study.mybatisplus.springbootmybatisplus.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengjunzhen
 * @date 2023-03-22 16:29
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testDelete(){
        int count = this.userMapper.deleteById(3);
        List<User> users = this.userMapper.selectList(null);
        Assert.assertEquals(1, count);
    }
}
