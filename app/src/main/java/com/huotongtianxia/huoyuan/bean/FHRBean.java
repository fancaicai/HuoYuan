package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class FHRBean {

    /**
     * data : [{"id":57,"name":"1","tel":"2","province":"3","city":"4","area":"5","address":"6"},{"id":39,"name":"货通天下","tel":"15235116631","province":null,"city":null,"area":null,"address":"时代广场"},{"id":42,"name":"测试","tel":"扣扣","province":null,"city":null,"area":null,"address":"SJM无聊"},{"id":43,"name":"vhn","tel":"gjb","province":null,"city":null,"area":null,"address":"gjbv"},{"id":46,"name":"测试","tel":"回来","province":null,"city":null,"area":null,"address":"破坏"},{"id":47,"name":"测试","tel":"恩","province":null,"city":null,"area":null,"address":"咯"},{"id":48,"name":"测试","tel":"空","province":null,"city":null,"area":null,"address":"空"},{"id":49,"name":"太钢","tel":"15235116631","province":null,"city":null,"area":null,"address":"尖草坪"},{"id":51,"name":"德邦物流","tel":"13934519410","province":null,"city":null,"area":null,"address":"晋中市榆次区108国道"},{"id":52,"name":"亲口","tel":"758543","province":null,"city":null,"area":null,"address":"赛尔哦"},{"id":58,"name":"1","tel":"123213213","province":"3","city":"4","area":"5","address":"6"}]
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
         * id : 57
         * name : 1
         * tel : 2
         * province : 3
         * city : 4
         * area : 5
         * address : 6
         */

        private int id;
        private String name;
        private String tel;
        private String province;
        private String city;
        private String area;
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

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
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

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
