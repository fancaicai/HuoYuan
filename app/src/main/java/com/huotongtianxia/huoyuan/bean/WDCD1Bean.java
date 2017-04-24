package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16 0016.
 */

public class WDCD1Bean {


    /**
     * data : [{"driver_id":"64","name":"武续平","plate_number":"晋B77635","register_place":"太原市","tel":"13835147768","weight":"33","type":"高栏","length":"13.5","photo":"","lng":"112.55086359","lat":"37.89027705","city":"太原市"},{"driver_id":"84","name":"刘寅福","plate_number":"晋M30593","register_place":"太原市","tel":"13734165384","weight":"11","type":"高栏","length":"6.8","photo":"","lng":"112.55086359","lat":"37.89027705","city":"太原市"},{"driver_id":"93","name":"张卫国","plate_number":"晋3408","register_place":"太原市","tel":"18734144748","weight":"49","type":"高栏","length":"13.0","photo":"","lng":"112.55086359","lat":"37.89027705","city":"太原市"},{"driver_id":"96","name":"王志俊","plate_number":"鲁HQJ419","register_place":"太原市","tel":"13223517360","weight":"30","type":"平板","length":"17.5","photo":"","lng":"112.55086359","lat":"37.89027705","city":"太原市"}]
     * count : 4
     * code : 100
     * message : OK
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
         * driver_id : 64
         * name : 武续平
         * plate_number : 晋B77635
         * register_place : 太原市
         * tel : 13835147768
         * weight : 33
         * type : 高栏
         * length : 13.5
         * photo :
         * lng : 112.55086359
         * lat : 37.89027705
         * city : 太原市
         */

        private String driver_id;
        private String name;
        private String plate_number;
        private String register_place;
        private String tel;
        private String weight;
        private String type;
        private String length;
        private String photo;
        private String lng;
        private String lat;
        private String city;

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlate_number() {
            return plate_number;
        }

        public void setPlate_number(String plate_number) {
            this.plate_number = plate_number;
        }

        public String getRegister_place() {
            return register_place;
        }

        public void setRegister_place(String register_place) {
            this.register_place = register_place;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
