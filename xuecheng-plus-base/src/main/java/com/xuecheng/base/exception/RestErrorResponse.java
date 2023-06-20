package com.xuecheng.base.exception;

import java.io.Serializable;

/**
 * 和前端约定返回的异常信息模型（响应用户的统一类型）
 */
public class RestErrorResponse implements Serializable {

    private String errMessage;

    public RestErrorResponse(String errMessage){
        this.errMessage= errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

}
