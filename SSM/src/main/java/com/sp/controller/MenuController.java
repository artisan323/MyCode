package com.sp.controller;

import com.sp.pojo.Menu;
import com.sp.service.MenuService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MenuController{
    @Resource
    private MenuService menuServiceImpl;

    //文件下载实现
    @RequestMapping("demo")
    public void demo(String filename, HttpServletResponse res, HttpServletRequest req) throws IOException {
        res.setHeader("Content-Disposition", "attachment;filename=" + filename);
        ServletOutputStream so = res.getOutputStream();
        String path = "/Users/wannengqingnian/MyCode/SSM/src/main/webapp/file";
        File file = new File(path, filename);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        so.write(bytes);
        so.flush();
        so.close();
    }

    @RequestMapping("show")
    @ResponseBody
    public List<Menu> show(){
        return menuServiceImpl.show();
    }
}
