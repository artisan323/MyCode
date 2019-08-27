package com.ssm.service;

import com.ssm.mapper.EmployeeMapper;
import com.ssm.pojo.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeService {

    @Resource
    EmployeeMapper employeeMapper;

    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDept(null);
    }



    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public int chaeckName(String empName) {
        return employeeMapper.selByName(empName);
    }
}
