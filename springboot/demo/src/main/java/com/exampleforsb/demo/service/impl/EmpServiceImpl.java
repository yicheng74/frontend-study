package com.exampleforsb.demo.service.impl;

import com.exampleforsb.demo.mapper.EmpExperienceMapper;
import com.exampleforsb.demo.mapper.EmpMapper;
import com.exampleforsb.demo.pojo.Emp;
import com.exampleforsb.demo.pojo.EmpExperience;
import com.exampleforsb.demo.pojo.PageResult;
import com.exampleforsb.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExperienceMapper empExperienceMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        Long total = empMapper.count(name, gender, begin, end);
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize, name, gender, begin, end);

        PageResult<Emp> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setRows(rows);
        return pageResult;
    }

    @Transactional
    @Override
    public void add(Emp emp) {
        LocalDateTime now = LocalDateTime.now();
        emp.setCreateTime(now);
        emp.setUpdateTime(now);
        if (emp.getPassword() == null || emp.getPassword().trim().isEmpty()) {
            emp.setPassword("123456");
        }
        empMapper.insert(emp);
        if (emp.getExperienceList() != null && !emp.getExperienceList().isEmpty()) {
            empExperienceMapper.insertBatch(emp.getId(), emp.getExperienceList());
        }
    }

    @Transactional
    @Override
    public void addExperiences(Integer empId, List<EmpExperience> experienceList) {
        if (experienceList == null || experienceList.isEmpty()) {
            return;
        }
        empExperienceMapper.insertBatch(empId, experienceList);
    }

    @Override
    public Emp getInfo(Integer id) {
        Emp emp = empMapper.getById(id);
        if (emp == null) {
            return null;
        }
        emp.setExperienceList(empExperienceMapper.listByEmpId(id));
        return emp;
    }

    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }
        empExperienceMapper.deleteByEmpIds(ids);
        empMapper.deleteByIds(ids);
    }
}