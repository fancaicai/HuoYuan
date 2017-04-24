package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCWBean {


    /**
     * data : [{"id":17,"user_id":2,"locality":"太原","tp_dirver_advantage":"天津-楠楠","tp_driver_accept":"山西-大同/北京-北京","create_time":"10天前","browse":0,"status":0,"isdelete":0,"name":"zhuxia","plate_number":"aaaa","tel":"13832454445","weight":"255吨","type":"8","length":"4米","photo":"http://192.168.0.15"}]
     * count : 1辆
     * code : 100
     * message : 获取数据成功！
     */

    private String count;
    private int code;
    private String message;
    private List<DataBean> data;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
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
         * id : 17
         * user_id : 2
         * locality : 太原
         * tp_dirver_advantage : 天津-楠楠
         * tp_driver_accept : 山西-大同/北京-北京
         * create_time : 10天前
         * browse : 0
         * status : 0
         * isdelete : 0
         * name : zhuxia
         * plate_number : aaaa
         * tel : 13832454445
         * weight : 255吨
         * type : 8
         * length : 4米
         * photo : http://192.168.0.15
         */

        private int id;
        private int user_id;
        private String locality;
        private String tp_dirver_advantage;
        private String tp_driver_accept;
        private String create_time;
        private String name;
        private String plate_number;
        private String tel;
        private String weight;
        private String type;
        private String length;
        private String photo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getTp_dirver_advantage() {
            return tp_dirver_advantage;
        }

        public void setTp_dirver_advantage(String tp_dirver_advantage) {
            this.tp_dirver_advantage = tp_dirver_advantage;
        }

        public String getTp_driver_accept() {
            return tp_driver_accept;
        }

        public void setTp_driver_accept(String tp_driver_accept) {
            this.tp_driver_accept = tp_driver_accept;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
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
    }
}
