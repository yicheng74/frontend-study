package com.exampleforsb.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.exampleforsb.demo.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.exampleforsb.demo.service.DeptService;
import com.exampleforsb.demo.pojo.Dept;


@RestController
public class DeptController{

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
        System.out.println("查询");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
}