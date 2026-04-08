package com.exampleforsb.demo.mapper;

import com.exampleforsb.demo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     */
    Long count(@Param("name") String name,
               @Param("gender") Integer gender,
               @Param("begin") LocalDate begin,
               @Param("end") LocalDate end);

    /**
     * 分页查询
     */
    List<Emp> list(@Param("start") Integer start,
                   @Param("pageSize") Integer pageSize,
                   @Param("name") String name,
                   @Param("gender") Integer gender,
                   @Param("begin") LocalDate begin,
                   @Param("end") LocalDate end);

    void insert(Emp emp);
}
