package com.xcq.original.mapper;

import com.xcq.original.entity.User;
import com.xcq.original.mapper.provider.UserProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface UserMapper {

    @SelectProvider(type = UserProvider.class,method = "selectAllUser")
    List<User> selectAllUser(User user);

    @SelectProvider(type = UserProvider.class,method = "selectUserByUsername")
    List<User> selectUserByUsername(String name);
}
