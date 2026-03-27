package com.exampleforsb.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.exampleforsb.demo.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("根据ID删除部门: " + id);
        deptService.deleteById(id);
        return Result.success();
    }
}