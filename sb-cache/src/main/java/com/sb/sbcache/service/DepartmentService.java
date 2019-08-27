package com.sb.sbcache.service;

import com.sb.sbcache.bean.Department;
import com.sb.sbcache.mapper.DepartmentMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentService {

    @Resource
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "department")
    public Department getDepartment(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDepartmentById(id);
        return department;
    }
}
