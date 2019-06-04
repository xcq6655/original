package com.xcq.original.service.imp;

import com.xcq.original.entity.Production;
import com.xcq.original.mapper.ProductMapper;
import com.xcq.original.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper mapper;


    @Override
    public List<Production> queryProductInfo() {
        return mapper.queryProductInfo();
    }
}
