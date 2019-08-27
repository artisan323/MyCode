package com.sb.sbcache.controller;


import com.sb.sbcache.bean.Employee;
import com.sb.sbcache.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController //返回json字符串的注解
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }
    @GetMapping("emp")
    public Employee update(Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("delemp")
    public String delEmp(Integer id){
        employeeService.delEmp(id);
        return "删除成功";
    }
}
