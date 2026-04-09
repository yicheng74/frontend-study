package com.exampleforsb.demo.service;

import com.exampleforsb.demo.pojo.Emp;
import com.exampleforsb.demo.pojo.EmpExperience;
import com.exampleforsb.demo.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService{
    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    void add(Emp emp);

    void addExperiences(Integer empId, List<EmpExperience> experienceList);
}