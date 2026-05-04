package com.exampleforsb.demo.service.impl;

import com.exampleforsb.demo.mapper.EmpExperienceMapper;
import com.exampleforsb.demo.mapper.EmpMapper;
import com.exampleforsb.demo.pojo.Emp;
import com.exampleforsb.demo.pojo.EmpExperience;
import com.exampleforsb.demo.pojo.LoginInfo;
import com.exampleforsb.demo.pojo.PageResult;
import com.exampleforsb.demo.service.EmpService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExperienceMapper empExperienceMapper;

    @Override
    public LoginInfo login(Emp emp) {
        LoginInfo info = empMapper.getByUsernameAndPassword(emp);
        if (info == null) {
            return null;
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", info.getId());
        claims.put("username", info.getUsername());
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "eW91YXJlY2hvdXBp")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        info.setToken(jwt);
        return info;
    }

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

    @Transactional
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);

        // 先根据员工ID删除原有工作经历
        empExperienceMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        // 再添加这个员工新的工作经历
        List<EmpExperience> experienceList = emp.getExperienceList();
        if (experienceList != null && !experienceList.isEmpty()) {
            experienceList.forEach(experience -> experience.setEmpId(emp.getId()));
            empExperienceMapper.insertBatch(emp.getId(), experienceList);
        }
    }
}