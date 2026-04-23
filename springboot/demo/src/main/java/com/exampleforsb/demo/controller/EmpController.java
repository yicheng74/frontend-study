package com.exampleforsb.demo.controller;

import com.exampleforsb.demo.pojo.Emp;
import com.exampleforsb.demo.pojo.EmpExperience;
import com.exampleforsb.demo.pojo.PageResult;
import com.exampleforsb.demo.pojo.Result;
import com.exampleforsb.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
public class EmpController{

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    //可以封装到实体类
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

    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp) {
        log.info("新增员工: {}", emp);
        empService.add(emp);
        return Result.success();
    }

    @PostMapping("/emps/{empId}/experiences")
    public Result addExperiences(@PathVariable Integer empId, @RequestBody List<EmpExperience> experienceList) {
        log.info("批量新增员工工作经历, empId={}, 条数={}", empId, experienceList == null ? 0 : experienceList.size());
         empService.addExperiences(empId, experienceList);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询员工信息: {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    
    @DeleteMapping("/emps")
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("根据id批量删除员工:{}", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工: {}", emp);
        empService.update(emp);
        return Result.success();
    }

    
}