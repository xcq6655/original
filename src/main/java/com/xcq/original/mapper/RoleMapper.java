package com.xcq.original.mapper;

import com.xcq.original.mapper.provider.RoleProvider;
import com.xcq.original.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface RoleMapper {

    @SelectProvider(type = RoleProvider.class,method = "selectRolesByUserId")
    List<Role> selectRolesByUserId(Integer id);
}
