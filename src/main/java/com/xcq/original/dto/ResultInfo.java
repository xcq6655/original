package com.xcq.original.dto;

public class ResultInfo {
    public static final int RESULT_SUCCESS = 1;// 成功
    //public static final int TYPE_RESULT_WARN = 2;// 警告
    //public static final int TYPE_RESULT_INFO = 3;// 提示信息
    /**
     * 提示代码
     */
    private int messageCode;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 提示信息明细列表
     */
    private Object details;

    public Object getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }

    public int getMessageCode() {
        return messageCode;
    }


    public void setDetails(Object details) {
        this.details = details;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }


    public ResultInfo(int messageCode,String message,Object details) {
        this.details = details;
        this.message = message;
        this.messageCode = messageCode;
    }

    public ResultInfo() {
    }
}
