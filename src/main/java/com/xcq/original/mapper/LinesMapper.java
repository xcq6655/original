package com.xcq.original.mapper;

import com.xcq.original.entity.Lines;
import com.xcq.original.mapper.provider.LinesProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface LinesMapper {

    @SelectProvider(type = LinesProvider.class ,method = "getInfoByToken")
    Lines getInfoByToken(String token);


    @UpdateProvider(type = LinesProvider.class ,method = "updateInfoByToken")
    int updateInfoByToken(String token);
}
