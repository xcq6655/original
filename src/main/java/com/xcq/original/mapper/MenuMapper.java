package com.xcq.original.mapper;

import com.xcq.original.mapper.provider.MenuProvider;
import com.xcq.original.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface MenuMapper {

    @SelectProvider(type = MenuProvider.class,method = "selectMenusByRoleId")
    List<Menu> selectMenusByRoleId(Integer id);
}
