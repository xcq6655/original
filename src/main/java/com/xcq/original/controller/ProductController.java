package com.xcq.original.controller;

import com.xcq.original.VO.ResultVO;
import com.xcq.original.entity.Production;
import com.xcq.original.service.ProductService;
import com.xcq.original.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/productInfo")
    @ResponseBody
    public ResultVO queryProductInfo(){
        List<Production> productionList = productService.queryProductInfo();
        return ResultVOUtil.success(productionList);
    }
}
