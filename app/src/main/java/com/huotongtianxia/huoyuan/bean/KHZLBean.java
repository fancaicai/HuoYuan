package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class KHZLBean {
    /**
     * data : [{"id":"50","customer_id":"50","factory_id":"55","create_time":"2017-02-17 17:43:49","company_name":"3","contacts":"1","tel":"1","area":"莱城区","city":"莱芜市","province":"山东省","address":"1","isdelete":"0"},{"id":"51","customer_id":"51","factory_id":"55","create_time":"2017-02-17 17:43:51","company_name":"1","contacts":"1","tel":"1","area":"市、县级市","city":"地级市","province":"省份","address":"1","isdelete":"0"},{"id":"52","customer_id":"52","factory_id":"55","create_time":"2017-02-17 17:43:56","company_name":"1","contacts":"1","tel":"1","area":"小溪镇","city":"漳州市","province":"福建省","address":"1","isdelete":"0"}]
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
         * id : 50
         * customer_id : 50
         * factory_id : 55
         * create_time : 2017-02-17 17:43:49
         * company_name : 3
         * contacts : 1
         * tel : 1
         * area : 莱城区
         * city : 莱芜市
         * province : 山东省
         * address : 1
         * isdelete : 0
         */

        private String id;
        private String customer_id;
        private String factory_id;
        private String create_time;
        private String company_name;
        private String contacts;
        private String tel;
        private String area;
        private String city;
        private String province;
        private String address;
        private String isdelete;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getFactory_id() {
            return factory_id;
        }

        public void setFactory_id(String factory_id) {
            this.factory_id = factory_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
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

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIsdelete() {
            return isdelete;
        }

        public void setIsdelete(String isdelete) {
            this.isdelete = isdelete;
        }
    }
}
