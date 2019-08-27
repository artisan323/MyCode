package com.sb.sbcache.controller;

import com.sb.sbcache.bean.Department;
import com.sb.sbcache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("depart/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        Department department = departmentService.getDepartment(id);
        System.out.println(department);
        return department;
    }

}
