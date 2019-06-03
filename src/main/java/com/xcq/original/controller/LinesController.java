package com.xcq.original.controller;

import com.alibaba.fastjson.JSON;
import com.xcq.original.entity.Lines;
import com.xcq.original.service.ILinesService;
import com.xcq.original.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/line")
public class LinesController {

    @Autowired
    private ILinesService linesServiceImp;

    @GetMapping(value = "/getInfoByToken")
    public Object getInfoByToken(String token){
        //String str = linesServiceImp.getInfoByToken(token).toString();
        Lines lines = linesServiceImp.getInfoByToken(token);
        String str = JSON.toJSONString(lines);
        return ResultUtil.createSuccess("查询成功",str);
    }


    @RequestMapping(value = "/scanListen")
    public Object scanListen(String token){
        Lines lines = linesServiceImp.getInfoByToken(token);
        String str = JSON.toJSONString(lines);
        //return ResultUtil.createSuccess("查询成功",str);
        return "商品名称： xcq商品     该商品访问次数："+lines.getCount();
    }
}
