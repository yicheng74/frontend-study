package com.exampleforsb.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@SpringBootTest
class UserMapperTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(user -> System.out.println(user));
    }
}