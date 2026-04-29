package com.exampleforsb.demo.service.impl;

import com.exampleforsb.demo.mapper.EmpMapper;
import com.exampleforsb.demo.pojo.JobOption;
import com.exampleforsb.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> mapList = empMapper.countEmpJobData();

        List<Object> jobList = new ArrayList<>();
        List<Object> dataList = new ArrayList<>();
        if (mapList != null) {
            for (Map<String, Object> map : mapList) {
                jobList.add(map.get("pos"));
                dataList.add(map.get("num"));
            }
        }
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
