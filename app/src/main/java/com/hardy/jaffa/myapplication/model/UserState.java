package com.hardy.jaffa.myapplication.model;

import java.util.List;

public class UserState {

    /**
     * code : 1
     * msg : 操作成功
     * data : []
     * debug : [true]
     */

    private int code;
    private String msg;
    private List<?> data;
    private List<Boolean> debug;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public List<Boolean> getDebug() {
        return debug;
    }

    public void setDebug(List<Boolean> debug) {
        this.debug = debug;
    }
}
