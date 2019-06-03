package com.xcq.original.service.imp;

import com.xcq.original.entity.Lines;
import com.xcq.original.mapper.LinesMapper;
import com.xcq.original.service.ILinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class LinesServiceImp implements ILinesService {

    @Resource
    LinesMapper linesMapper;

    @Override
    public Lines getInfoByToken(String token) {
        int i = linesMapper.updateInfoByToken(token);
        if(i>0){
            return linesMapper.getInfoByToken(token);
        }
        return null;
    }
}
