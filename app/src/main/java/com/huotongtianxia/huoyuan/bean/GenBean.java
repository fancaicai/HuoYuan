package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class GenBean {


    /**
     * code : 101
     * message : 版本需要升级！
     * data : {"id":2,"app_id":0,"version_id":"2.1","apk_url":"http://m.shouji.360tpcdn.com/170413/6d652e86c0fb9466b439ef6200545552/com.huotongtianxia.huoyuan_2.apk","create_time":null,"update_time":null}
     */

    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * app_id : 0
         * version_id : 2.1
         * apk_url : http://m.shouji.360tpcdn.com/170413/6d652e86c0fb9466b439ef6200545552/com.huotongtianxia.huoyuan_2.apk
         * create_time : null
         * update_time : null
         */

        private int id;
        private int app_id;
        private String version_id;
        private String apk_url;
        private Object create_time;
        private Object update_time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getApp_id() {
            return app_id;
        }

        public void setApp_id(int app_id) {
            this.app_id = app_id;
        }

        public String getVersion_id() {
            return version_id;
        }

        public void setVersion_id(String version_id) {
            this.version_id = version_id;
        }

        public String getApk_url() {
            return apk_url;
        }

        public void setApk_url(String apk_url) {
            this.apk_url = apk_url;
        }

        public Object getCreate_time() {
            return create_time;
        }

        public void setCreate_time(Object create_time) {
            this.create_time = create_time;
        }

        public Object getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(Object update_time) {
            this.update_time = update_time;
        }
    }
}
