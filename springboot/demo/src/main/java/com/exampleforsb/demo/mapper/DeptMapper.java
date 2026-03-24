package com.exampleforsb.demo.mapper;

import com.exampleforsb.demo.pojo.Dept;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface DeptMapper{

    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();
}