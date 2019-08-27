package com.sp.mapper;

import com.sp.pojo.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

    //@Select("select * from menu where pid = #{0}")
    List<Menu> selByPid(int i);
}
