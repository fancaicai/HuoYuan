package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/2/27 0027.
 */

public class HYFBSHBean {


    /**
     * data : {"id":31,"address":"坝愣工业园区110国道西400米","contacts":"梁鹏翔","tel":"18231435007"}
     * code : 100
     * message : 获取数据成功！
     */

    private DataBean data;
    private int code;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * id : 31
         * address : 坝愣工业园区110国道西400米
         * contacts : 梁鹏翔
         * tel : 18231435007
         */

        private int id;
        private String address;
        private String contacts;
        private String tel;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }
}
