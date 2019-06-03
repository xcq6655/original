package com.xcq.original.mapper.provider;

public class RoleProvider {
    public String selectRolesByUserId(Integer id){
        StringBuilder stringBuilder = new StringBuilder("SELECT tr.* from t_role tr,t_user_role tur WHERE tr.id = tur.role_id and tur.user_id = #{id}");
        return stringBuilder.toString();
    }
}
