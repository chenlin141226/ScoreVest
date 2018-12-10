package com.hardy.jaffa.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class UserLoginState {

    /**
     * code : 1
     * msg : 登录成功
     * data : {"id":59,"username":"hehe","nickname":"hehe","user-token":"f1a74f490c0ff673edbb60ab97a1ee52"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public static class DataBean {
        /**
         * id : 59
         * username : hehe
         * nickname : hehe
         * user-token : f1a74f490c0ff673edbb60ab97a1ee52
         */

        private int id;
        private String username;
        private String nickname;
        @SerializedName("user-token")
        private String usertoken;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUsertoken() {
            return usertoken;
        }

        public void setUsertoken(String usertoken) {
            this.usertoken = usertoken;
        }
    }
}
