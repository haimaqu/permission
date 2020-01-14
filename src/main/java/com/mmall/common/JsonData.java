package com.mmall.common;
import	java.util.HashMap;


import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;

import java.util.Map;

@Data
public class JsonData {


    // 返回结果,
    // 项目里如果是json返回时，返回值一定是JsonData，当拿到JsonData对象时，首先判断ret是true还是false
    // 如果是true代表当前请求是正常处理过的，然后从data里拿数据，
    // 如果ret是false则通过msg告诉他后端因为什么原因处理错误了
    private Boolean ret;


    // 有异常时给的message
    private String msg;


    // 正常返回给前台的数据
    private Object data;

    public JsonData(Boolean ret) {
        this.ret = ret;
    }

    public static JsonData success(Object data, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = data;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object data) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = data;
        return jsonData;
    }

    public static JsonData success() {
        return new JsonData(true);
    }


    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}

















