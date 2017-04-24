package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class WDHYBean {

    /**
     * data : [{"order_num":"2017032037115","create_time":"1489971503","shipper_province":"山西省","shipper_city":"太原市","receive_province":"省份","receive_city":"-城市-","name":"尚振","photo":"","length":"4.2","type":"厢货","weight":"1","goods_type":"显示"}]
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
         * order_num : 2017032037115
         * create_time : 1489971503
         * shipper_province : 山西省
         * shipper_city : 太原市
         * receive_province : 省份
         * receive_city : -城市-
         * name : 尚振
         * photo :
         * length : 4.2
         * type : 厢货
         * weight : 1
         * goods_type : 显示
         */

        private String order_num;
        private String create_time;
        private String shipper_province;
        private String shipper_city;
        private String receive_province;
        private String receive_city;
        private String name;
        private String photo;
        private String length;
        private String type;
        private String weight;
        private String goods_type;

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getShipper_province() {
            return shipper_province;
        }

        public void setShipper_province(String shipper_province) {
            this.shipper_province = shipper_province;
        }

        public String getShipper_city() {
            return shipper_city;
        }

        public void setShipper_city(String shipper_city) {
            this.shipper_city = shipper_city;
        }

        public String getReceive_province() {
            return receive_province;
        }

        public void setReceive_province(String receive_province) {
            this.receive_province = receive_province;
        }

        public String getReceive_city() {
            return receive_city;
        }

        public void setReceive_city(String receive_city) {
            this.receive_city = receive_city;
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

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getGoods_type() {
            return goods_type;
        }

        public void setGoods_type(String goods_type) {
            this.goods_type = goods_type;
        }
    }
}
