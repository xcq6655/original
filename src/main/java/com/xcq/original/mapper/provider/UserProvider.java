package com.xcq.original.mapper.provider;

import com.xcq.original.entity.User;

public class UserProvider {

    public String selectUserByUsername(String name){
        StringBuilder stringBuilder = new StringBuilder("SELECT * from t_user u WHERE u.username = #{name}");
        return stringBuilder.toString();
    }

    public String selectAllUser(User user){
        StringBuilder sb = new StringBuilder("SELECT * FROM `t_user`");
        return sb.toString();
    }
}
