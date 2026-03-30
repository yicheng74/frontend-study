package com.exampleforsb.demo.service;

import com.exampleforsb.demo.pojo.Dept;
import java.util.List;

public interface DeptService{
    Dept getInfo(Integer id);
    List<Dept> findAll();
    void add(Dept dept);
    void update(Dept dept);
    void deleteById(Integer id);
}