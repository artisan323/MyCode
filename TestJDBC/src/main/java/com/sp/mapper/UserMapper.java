package com.sp.mapper;

import com.sp.pojo.User;

public interface UserMapper {
    User selByUid(String i);
    void insUser(User u);
}
