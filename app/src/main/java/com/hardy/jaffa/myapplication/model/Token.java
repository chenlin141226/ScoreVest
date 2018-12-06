package com.hardy.jaffa.myapplication.model;

import java.util.List;

public class Token {
    private int code;
    private String msg;
    private DataBean data;
    private List<DebugBean> debug;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<DebugBean> getDebug() {
        return debug;
    }

    public void setDebug(List<DebugBean> debug) {
        this.debug = debug;
    }

    public static class DataBean {
    }

    public static class DebugBean {
        /**
         * signature : e57142daa725e45d50404e72d4fb5394
         */

        private String signature;

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }
    }
}
