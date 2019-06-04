package com.xcq.original.mapper;

import com.xcq.original.entity.Production;
import com.xcq.original.mapper.provider.ProductProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface ProductMapper {

    @SelectProvider(type = ProductProvider.class ,method = "queryProductInfo")
    List<Production> queryProductInfo();
}
