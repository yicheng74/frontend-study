package com.exampleforsb.demo.controller;

import com.exampleforsb.demo.pojo.Emp;
import com.exampleforsb.demo.pojo.PageResult;
import com.exampleforsb.demo.pojo.Result;
import com.exampleforsb.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@Slf4j
@RestController
public class EmpController{

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Integer gender,
                       LocalDate begin,
                       LocalDate end) {
        log.info("分页查询, 参数: page={}, pageSize={}, name={}, gender={}, begin={}, end={}",
                page, pageSize, name, gender, begin, end);
        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageResult);
    }
}