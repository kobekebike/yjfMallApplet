package com.bl.base;

import com.bl.constants.Constant;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by michael on 2018/12/24.
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Response implements Serializable {
    /**
     * 返回code，0：成功；1：失败
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回结果，业务对象
     */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Response createSuccessResult(String message, Object data){
        Response response = new Response();
        response.setCode(Constant.CODE_SUCCESS);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static Response createFailResult(String message, Object data){
        Response response = new Response();
        response.setCode(Constant.CODE_FAIL);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
