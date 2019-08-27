package com.sp.service.Impl;

import com.sp.mapper.MenuMapper;
import com.sp.pojo.Menu;
import com.sp.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;


    @Override
    public List<Menu> show() {
        return menuMapper.selByPid(0);
    }
}
