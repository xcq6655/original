package com.xcq.original.service;

import com.xcq.original.entity.User;

import java.util.List;

public interface IUserService {
    // 用户登录
    Object login(User uUser);

    User getUserByName(String name);
}
