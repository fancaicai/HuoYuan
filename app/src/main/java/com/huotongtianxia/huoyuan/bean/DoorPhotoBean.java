package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/5/20 0020.
 */

public class DoorPhotoBean {

    /**
     * code : 100
     * data : {"factory_id":89,"door":"20170317/06c045c0442daa3b5c02c5e2bcfe46e1.jpg"}
     * message : 获取数据成功！
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * factory_id : 89
         * door : 20170317/06c045c0442daa3b5c02c5e2bcfe46e1.jpg
         */

        private int factory_id;
        private String door;

        public int getFactory_id() {
            return factory_id;
        }

        public void setFactory_id(int factory_id) {
            this.factory_id = factory_id;
        }

        public String getDoor() {
            return door;
        }

        public void setDoor(String door) {
            this.door = door;
        }
    }
}
