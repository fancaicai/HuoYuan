package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class GYSBean {

    /**
     * data : [{"id":1,"name":"韵达","photo":"http://192.168.0.5/uploads/","head":"刘德华","tel":"18636640620","address":"高新区"},{"id":2,"name":"圆通","photo":"http://192.168.0.5/uploads/","head":"周杰轮","tel":"1888888888","address":"高新区"},{"id":3,"name":"中通","photo":"http://192.168.0.5/uploads/","head":"刘欢","tel":"18636640650","address":"高新区"}]
     * code : 100
     * message : 查询成功
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 韵达
         * photo : http://192.168.0.5/uploads/
         * head : 刘德华
         * tel : 18636640620
         * address : 高新区
         */

        private int id;
        private String name;
        private String photo;
        private String head;
        private String tel;
        private String address;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
