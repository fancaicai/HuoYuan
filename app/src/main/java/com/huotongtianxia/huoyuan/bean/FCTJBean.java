package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class FCTJBean {

    /**
     * data : [{"create_time":1484639474,"yun_status":1,"city":"巴彦淖尔","plate_number":"晋A88886"},{"create_time":1484639474,"yun_status":1,"city":"巴彦淖尔","plate_number":"晋A88886"},{"create_time":1484639474,"yun_status":1,"city":"巴彦淖尔","plate_number":"晋A88886"}]
     * count : 3
     * code : 100
     * message : 获取数据成功！
     */

    private int count;
    private int code;
    private String message;
    private List<DataBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * create_time : 1484639474
         * yun_status : 1
         * city : 巴彦淖尔
         * plate_number : 晋A88886
         */

        private int create_time;
        private int yun_status;
        private String city;
        private String plate_number;

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getYun_status() {
            return yun_status;
        }

        public void setYun_status(int yun_status) {
            this.yun_status = yun_status;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPlate_number() {
            return plate_number;
        }

        public void setPlate_number(String plate_number) {
            this.plate_number = plate_number;
        }
    }
}
