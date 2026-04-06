package com.exampleforsb.demo.service;

import com.exampleforsb.demo.pojo.Emp;
import com.exampleforsb.demo.pojo.PageResult;

public interface EmpService{
    PageResult<Emp> page(Integer page, Integer pageSize);
}