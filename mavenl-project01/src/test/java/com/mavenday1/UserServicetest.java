package com.mavenday1;

import org.junit.Test;
import org.junit.Assert; 

public class UserServicetest {

    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("100000200010011011");
        System.out.println(age);
    }

    @Test
    public void testGetGender(){
        UserService userService = new UserService();
        String gender = userService.getGender("100000200010011011");
        System.out.println(gender);
    }


    @Test
    public void testGetGenderassert(){
        UserService userService = new UserService();
        String gender = userService.getGender("100000200010011011");
        Assert.assertEquals("男",gender);
    }
}