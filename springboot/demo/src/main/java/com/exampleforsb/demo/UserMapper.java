package com.exampleforsb.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper{

    //@Select("select * from `user`")
    public List<User> findAll();

    @Delete("delete from user where id = #{id}")
    public void deleteById(Integer id);

    @Insert("insert into user(username, password, name, age) values(#{username}, #{password}, #{name}, #{age})")
    public void insert(User user);

    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public void update(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByuandp(@Param("username") String username, @Param("password")String password);
}