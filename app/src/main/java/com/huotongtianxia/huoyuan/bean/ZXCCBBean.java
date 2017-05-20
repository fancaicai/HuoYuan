package com.huotongtianxia.huoyuan.bean;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5 0005.
 */

public class ZXCCBBean {

    /**
     * data : [{"id":"64","name":"武续平","plate_number":"晋B77635","register_place":"太原市","tel":"13835147768","weight":"33吨","type":"高栏","length":"13.5米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"84","name":"刘寅福","plate_number":"晋M30593","register_place":"太原市","tel":"13734165384","weight":"11吨","type":"高栏","length":"6.8米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"93","name":"张卫国","plate_number":"晋3408","register_place":"太原市","tel":"18734144748","weight":"49吨","type":"高栏","length":"13.0米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"96","name":"王志俊","plate_number":"鲁HQJ419","register_place":"太原市","tel":"13223517360","weight":"30吨","type":"平板","length":"17.5米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"117","name":"杜宏盛","plate_number":"晋AA2196","register_place":"太原市","tel":"13509730040","weight":"14吨","type":"高栏","length":"9.6米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"118","name":"张拉拴","plate_number":"晋AU512L","register_place":"太原市","tel":"18435127673","weight":"5吨","type":"厢货","length":"4.2米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"125","name":"郑俊刚","plate_number":"晋AV699H","register_place":"太原市","tel":"18235825771","weight":"12吨","type":"高栏","length":"4.2米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"255","name":"尚振","plate_number":"晋A23231","register_place":"太原市","tel":"13934519410","weight":"1吨","type":"厢货","length":"4.2米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"256","name":"侯晓东","plate_number":"晋M80929","register_place":"太原市","tel":"18603571749","weight":"15吨","type":"高栏","length":"9.6米","photo":"http://www.cnhttx.com","create_time":"17248天前"},{"id":"260","name":"段九文","plate_number":"晋AA0540","register_place":"太原市","tel":"13623460010","weight":"30吨","type":"高栏","length":"13.0米","photo":"http://www.cnhttx.com","create_time":"17248天前"}]
     * count : 10辆
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
         * id : 64
         * name : 武续平
         * plate_number : 晋B77635
         * register_place : 太原市
         * tel : 13835147768
         * weight : 33吨
         * type : 高栏
         * length : 13.5米
         * photo : http://www.cnhttx.com
         * create_time : 17248天前
         * "preference_way":[
         {
         "id":33,
         "driver_info_id":64,
         "start_province":"台湾",
         "start_city":"台北",
         "end_province":"河北省",
         "end_city":"秦皇岛",
         "way_type":""
         },
         {
         "id":40,
         "driver_info_id":64,
         "start_province":"山西省",
         "start_city":"太原",
         "end_province":"上海",
         "end_city":"上海",
         "way_type":""
         },
         {
         "id":41,
         "driver_info_id":64,
         "start_province":"山西省",
         "start_city":"太原",
         "end_province":"浙江省",
         "end_city":"杭州",
         "way_type":""
         },
         {
         "id":42,
         "driver_info_id":64,
         "start_province":"山西省",
         "start_city":"太原",
         "end_province":"浙江省",
         "end_city":"台州",
         "way_type":""
         }
         ]
         */

        private String id;
        private String name;
        private String plate_number;
        private String register_place;
        private String tel;
        private String weight;
        private String type;
        private String length;
        private String photo;
        private String create_time;
        private List<PreferenceWayBean> preference_way;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public List<PreferenceWayBean> getPreference_way() {
            return preference_way;
        }

        public void setPreference_way(List<PreferenceWayBean> preference_way) {
            this.preference_way = preference_way;
        }

        public static class PreferenceWayBean {
            /**
             * id : 33
             * driver_info_id : 64
             * start_province : 台湾
             * start_city : 台北
             * end_province : 河北省
             * end_city : 秦皇岛
             * way_type :
             */

            @SerializedName("id")
            private int idX;
            private int driver_info_id;
            private String start_province;
            private String start_city;
            private String end_province;
            private String end_city;
            private String way_type;

            public int getIdX() {
                return idX;
            }

            public void setIdX(int idX) {
                this.idX = idX;
            }

            public int getDriver_info_id() {
                return driver_info_id;
            }

            public void setDriver_info_id(int driver_info_id) {
                this.driver_info_id = driver_info_id;
            }

            public String getStart_province() {
                return start_province;
            }

            public void setStart_province(String start_province) {
                this.start_province = start_province;
            }

            public String getStart_city() {
                return start_city;
            }

            public void setStart_city(String start_city) {
                this.start_city = start_city;
            }

            public String getEnd_province() {
                return end_province;
            }

            public void setEnd_province(String end_province) {
                this.end_province = end_province;
            }

            public String getEnd_city() {
                return end_city;
            }

            public void setEnd_city(String end_city) {
                this.end_city = end_city;
            }

            public String getWay_type() {
                return way_type;
            }

            public void setWay_type(String way_type) {
                this.way_type = way_type;
            }
        }
    }
}
