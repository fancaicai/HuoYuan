package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class SearchBean {


    /**
     * code : 100
     * message : 数据获取成功！
     * data : [{"factory_id":89,"company_name":"公积金","contacts":"给您","tel":"后脑","province":"北京","city":"东城","area":"西区","address":"给您"}]
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
         * factory_id : 89
         * company_name : 公积金
         * contacts : 给您
         * tel : 后脑
         * province : 北京
         * city : 东城
         * area : 西区
         * address : 给您
         */

        private int factory_id;
        private String company_name;
        private String contacts;
        private String tel;
        private String province;
        private String city;
        private String area;
        private String address;

        public int getFactory_id() {
            return factory_id;
        }

        public void setFactory_id(int factory_id) {
            this.factory_id = factory_id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
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
