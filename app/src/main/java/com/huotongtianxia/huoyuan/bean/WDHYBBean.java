package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27 0027.
 */

public class WDHYBBean {


    /**
     * data : [{"id":"326","require_truck_weight":"30","require_truck_length":"13.5","require_truck_type":"高栏","goods_type":"钢","create_time":"7天前","fprovince":"山西省","fcity":"太原市","province":"山西省","city":"太原市"},{"id":"325","require_truck_weight":"30","require_truck_length":"13.5","require_truck_type":"高栏","goods_type":"钢","create_time":"7天前","fprovince":"山西省","fcity":"太原市","province":"省份","city":"-城市-"},{"id":"319","require_truck_weight":"20","require_truck_length":"16.5","require_truck_type":"高栏","goods_type":"显示","create_time":"8天前","fprovince":"山西省","fcity":"太原市","province":"省份","city":"-城市-"},{"id":"298","require_truck_weight":"50","require_truck_length":"17.5","require_truck_type":"板车","goods_type":"铁板","create_time":"9天前","fprovince":"山西省","fcity":"太原市","province":"省份","city":"-城市-"}]
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
         * id : 326
         * require_truck_weight : 30
         * require_truck_length : 13.5
         * require_truck_type : 高栏
         * goods_type : 钢
         * create_time : 7天前
         * fprovince : 山西省
         * fcity : 太原市
         * province : 山西省
         * city : 太原市
         */

        private String id;
        private String require_truck_weight;
        private String require_truck_length;
        private String require_truck_type;
        private String goods_type;
        private String create_time;
        private String fprovince;
        private String fcity;
        private String province;
        private String city;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRequire_truck_weight() {
            return require_truck_weight;
        }

        public void setRequire_truck_weight(String require_truck_weight) {
            this.require_truck_weight = require_truck_weight;
        }

        public String getRequire_truck_length() {
            return require_truck_length;
        }

        public void setRequire_truck_length(String require_truck_length) {
            this.require_truck_length = require_truck_length;
        }

        public String getRequire_truck_type() {
            return require_truck_type;
        }

        public void setRequire_truck_type(String require_truck_type) {
            this.require_truck_type = require_truck_type;
        }

        public String getGoods_type() {
            return goods_type;
        }

        public void setGoods_type(String goods_type) {
            this.goods_type = goods_type;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getFprovince() {
            return fprovince;
        }

        public void setFprovince(String fprovince) {
            this.fprovince = fprovince;
        }

        public String getFcity() {
            return fcity;
        }

        public void setFcity(String fcity) {
            this.fcity = fcity;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
