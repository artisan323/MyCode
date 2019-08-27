package com.mybatis.mapper;

import com.mybatis.po.MyUser;

import java.util.List;

public interface UserMapper {
    public List<MyUser> selectAllUser();
    public MyUser selectUserById(int uid);
    public void addUser(MyUser user);
}
