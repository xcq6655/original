package com.xcq.original.mapper.provider;

public class MenuProvider {
    public String selectMenusByRoleId(Integer id){
        StringBuilder stringBuilder = new StringBuilder("SELECT tm.* from t_menu tm ,t_role_menu trm WHERE tm.id = trm.menu_id and trm.role_id = #{id}");
        return stringBuilder.toString();
    }

    public String selectMenusByUserId(Integer id){
        StringBuilder stringBuilder = new StringBuilder("SELECT tm.* from t_menu tm ,t_role_menu trm,t_user_role tur WHERE tm.id = trm.menu_id and trm.role_id = tur.role_id and tur.user_id = #{id}");
        return stringBuilder.toString();
    }
}
