package com.exampleforsb.demo.mapper;

import com.exampleforsb.demo.pojo.Emp;
import com.exampleforsb.demo.pojo.LoginInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
    LoginInfo getByUsernameAndPassword(Emp emp);

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

    Emp getById(Integer id);

    void deleteByIds(@Param("ids") List<Integer> ids);

    void update(Emp emp);

    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();
}
