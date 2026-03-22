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

    /*@Test
    public void deleteById(){
        userMapper.deleteById(5);
    }

    @Test
    public void testInsert(){
        User user = new User(null, "choupi", "543877", "臭屁", 22);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate(){
        User user = new User(1, "pichou", "543877", "屁臭", 22);
        userMapper.update(user);
    }*/

   /*@Test
   public void testFindByUAndP(){
        User user = userMapper.findByuandp("choupi", "543877");
        System.out.println(user);
   }*/

}