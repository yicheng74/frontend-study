package com.exampleforsb.demo.service.impl;

import com.exampleforsb.demo.pojo.Dept;
import com.exampleforsb.demo.service.DeptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exampleforsb.demo.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }
}