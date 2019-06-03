package com.xcq.original.mapper.provider;

public class LinesProvider {

    public String getInfoByToken(String token){
        StringBuilder sb = new StringBuilder("SELECT * FROM `t_lines` t WHERE t.token = #{token}");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String updateInfoByToken(String token){
        StringBuilder sb = new StringBuilder("UPDATE t_lines set last_time = this_time,this_time = now(),count = count+1 WHERE token = #{token}");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
