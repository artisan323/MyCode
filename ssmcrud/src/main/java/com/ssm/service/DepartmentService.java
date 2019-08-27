package com.ssm.service;

import com.ssm.mapper.DepartmentMapper;
import com.ssm.pojo.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {

    @Resource
    DepartmentMapper departmentMapper;

    public List<Department> getDepts(){
        return departmentMapper.selectByExample(null);
    }

}
