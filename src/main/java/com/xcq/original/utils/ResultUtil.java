package com.xcq.original.utils;

import com.xcq.original.dto.ResultInfo;

public class ResultUtil {
    /**
     * 创建错误结果
     * @param messageCode
     * @param message
     * @param details
     * @return
     */
    public static ResultInfo createFail(int messageCode, String message, Object details){
        return new ResultInfo(messageCode,message,details);
    }


    /**
     * 创建成功提示信息
     * @param message
     * @param details
     * @return
     */
    public static ResultInfo createSuccess(String message,Object details){
        return new ResultInfo(ResultInfo.RESULT_SUCCESS,message,details);
    }

    /**
     * 创建普通提示信息
     * @param messageCode
     * @param message
     * @param details
     * @return
     */
    public static ResultInfo createInfo(int messageCode,String message,Object details){
        return new ResultInfo(messageCode,message,details);
    }
}

