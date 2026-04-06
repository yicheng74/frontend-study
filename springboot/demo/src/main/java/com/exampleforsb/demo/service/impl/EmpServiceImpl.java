package com.exampleforsb.demo.service.impl;

import com.exampleforsb.demo.mapper.EmpMapper;
import com.exampleforsb.demo.pojo.Emp;
import com.exampleforsb.demo.pojo.PageResult;
import com.exampleforsb.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        Long total = empMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        PageResult<Emp> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setRows(rows);
        return pageResult;
    }
}