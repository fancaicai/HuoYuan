package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public class WZBean {

    /**
     * data : [{"lng":"112.564336","lat":"37.809319","update_time":"2017-03-31 09:03:09"},{"lng":"112.564343","lat":"37.809307","update_time":"2017-03-31 09:03:34"},{"lng":"112.55086359","lat":"37.89027705","update_time":"2017-03-31 10:03:00"},{"lng":"112.564348","lat":"37.809305","update_time":"2017-03-31 11:03:25"},{"lng":"112.564349","lat":"37.809306","update_time":"2017-03-31 13:03:19"},{"lng":"112.564325","lat":"37.809324","update_time":"2017-03-31 14:03:20"}]
     * code : 100
     * message : 获取数据成功！
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
         * lng : 112.564336
         * lat : 37.809319
         * update_time : 2017-03-31 09:03:09
         */

        private String lng;
        private String lat;
        private String update_time;

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }
}
