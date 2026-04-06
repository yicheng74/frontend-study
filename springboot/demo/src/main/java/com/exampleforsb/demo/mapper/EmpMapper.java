package com.exampleforsb.demo.mapper;

import com.exampleforsb.demo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    Long count();

    /**
     * 分页查询
     */
    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id limit #{start},#{pageSize}")
    List<Emp> list(Integer start, Integer pageSize);
}
