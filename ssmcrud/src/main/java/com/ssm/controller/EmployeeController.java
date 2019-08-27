package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Employee;
import com.ssm.pojo.Msg;
import com.ssm.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EmployeeController {

    @Resource
    EmployeeService employeeService;


    //校验用户名是否重复
    @RequestMapping("check")
    @ResponseBody
    public boolean checkName(String empName){
        int cont = employeeService.chaeckName(empName);
        if (cont == 0){
            return true;
        }else {
            return false;
        }
    }

    //返回json方式
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        //分页之前传入需要分页大小，从第几页开始
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();

        //pegeInfo封装了分页是所有信息， 5代表连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().add("pageInfo", page);
    }

    //保存新增数据
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return Msg.success();
    }


    //@RequestMapping("emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){

        //分页之前传入需要分页大小，从第几页开始
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();

        //pegeInfo封装了分页是所有信息， 5代表连续显示的页数
        PageInfo page = new PageInfo(emps, 5);

        model.addAttribute("pageInfo", page);

//        测试显示数据
//        System.out.println("当前页面 : " + page.getPageNum());
//        System.out.println("总页码 : " + page.getPages());
//        System.out.println("总记录数 : " + page.getTotal());
//        System.out.println("在页面需要连续显示的页码数");
//        int[] nums = page.getNavigatepageNums();
//        for (int e : nums){
//            System.out.println(" " + e);
//        }
        return "list";
    }
}
