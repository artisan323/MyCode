package com.sb.sbcache.service;

import com.sb.sbcache.bean.Employee;
import com.sb.sbcache.mapper.EmployeeMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class EmployeeService {

    @Resource
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emp"}, keyGenerator = "myKeyGenerator")
    public Employee getEmp(Integer id){
        System.out.println("查询 " + id + " 号员工");
        return employeeMapper.getEmployeeById(id);
    }


    @CachePut(value = "emp", key = "#employee.id")
    public Employee update(Employee employee){
        System.out.println("更新 " + employee.getId() + " 号员工");
        employeeMapper.updateEmp(employee);
        return employee;
    }


    @CacheEvict(value = "emp")
    public void delEmp(Integer id){
        System.out.println("删除 " + id);
        employeeMapper.deleteEmp(id);
    }
}
