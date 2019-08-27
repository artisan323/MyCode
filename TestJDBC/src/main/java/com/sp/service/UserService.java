package com.sp.service;
import com.sp.mapper.UserMapper;
import com.sp.pojo.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User show(String i){
        return userMapper.selByUid(i);
    }

    public void insertUser(User u){
        userMapper.insUser(u);
    }
}
