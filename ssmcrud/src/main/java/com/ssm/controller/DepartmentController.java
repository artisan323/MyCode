package com.ssm.controller;


import com.ssm.pojo.Department;
import com.ssm.pojo.Employee;
import com.ssm.pojo.Msg;
import com.ssm.service.DepartmentService;
import com.ssm.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DepartmentController {

    @Resource
    DepartmentService departmentService;



    @RequestMapping("depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts", list);
    }
}
