package com.exampleforsb.demo.mapper;

import com.exampleforsb.demo.pojo.Dept;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
@Mapper
public interface DeptMapper{


    /*@Results({
        @Result(column = "create_time" , property = "createTime"),
        @Result(column = "update_time" , property = "updateTime")

    })*/
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();
}