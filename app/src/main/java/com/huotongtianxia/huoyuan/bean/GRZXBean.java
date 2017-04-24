package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class GRZXBean {


    /**
     * data : {"logo":"20170225/c21a1052f025908e1430c81642cde724.jpg","door":"1.jpg","company":"货通天下里","main_products":"钢板","truck_type":"17.5米","head":"孟明海","tel":"","mobile":"15235116631","website":"无","address":"时代广场"}
     * code : 100
     * message : 查询成功
     */

    private DataBean data;
    private int code;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * logo : 20170225/c21a1052f025908e1430c81642cde724.jpg
         * door : 1.jpg
         * company : 货通天下里
         * main_products : 钢板
         * truck_type : 17.5米
         * head : 孟明海
         * tel :
         * mobile : 15235116631
         * website : 无
         * address : 时代广场
         */

        private String logo;
        private String door;
        private String company;
        private String main_products;
        private String truck_type;
        private String head;
        private String tel;
        private String mobile;
        private String website;
        private String address;

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getDoor() {
            return door;
        }

        public void setDoor(String door) {
            this.door = door;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getMain_products() {
            return main_products;
        }

        public void setMain_products(String main_products) {
            this.main_products = main_products;
        }

        public String getTruck_type() {
            return truck_type;
        }

        public void setTruck_type(String truck_type) {
            this.truck_type = truck_type;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
