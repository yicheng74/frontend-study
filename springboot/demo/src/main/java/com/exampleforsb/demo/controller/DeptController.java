package com.exampleforsb.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.exampleforsb.demo.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.exampleforsb.demo.service.DeptService;
import com.exampleforsb.demo.pojo.Dept;


@RestController
public class DeptController{

    @Autowired
    private DeptService deptService;

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("添加部门: " + dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/depts")
    public Result list(){
        System.out.println("查询");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId) {
        System.out.println("根据ID查询部门数据:" + deptId);
        Dept dept = deptService.getInfo(deptId);
        return Result.success(dept);
    }

    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("根据ID删除部门: " + id);
        deptService.deleteById(id);
        return Result.success();
    }
}