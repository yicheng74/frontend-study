package com.exampleforsb.demo.mapper;

import com.exampleforsb.demo.pojo.EmpExperience;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工工作经历
 */
@Mapper
public interface EmpExperienceMapper {

    void insertBatch(@Param("empId") Integer empId, @Param("experienceList") List<EmpExperience> experienceList);
}