package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class GSZLBean {

    /**
     * data : {"factory_id":89,"company":"sssss","address":"2","main_products":"","truck_type":"","head":"","mobile":"","door":"20170317/06c045c0442daa3b5c02c5e2bcfe46e1.jpg","photo":"20170317/d3c06f2fa4d71883fb3b3e29faa17e01.jpg","photo2":"20170317/2b83df97090aa00f3bdba95fa4d9e2d5.jpg","photo3":"20170317/18e5f7a6116d017223d68a2e802cfd57.jpg","photo4":"20170317/498e4ca953ca7e4ba0e9bc06526a4e89.jpg","photo5":"20170317/ac11db66e91e2ecbae3666291d597c1c.jpg","photo6":"20170317/d9ad381985d7e6f49f2110dbbab9ead8.jpg"}
     * code : 100
     * message : 获取数据成功！
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
         * factory_id : 89
         * company : sssss
         * address : 2
         * main_products :
         * truck_type :
         * head :
         * mobile :
         * door : 20170317/06c045c0442daa3b5c02c5e2bcfe46e1.jpg
         * photo : 20170317/d3c06f2fa4d71883fb3b3e29faa17e01.jpg
         * photo2 : 20170317/2b83df97090aa00f3bdba95fa4d9e2d5.jpg
         * photo3 : 20170317/18e5f7a6116d017223d68a2e802cfd57.jpg
         * photo4 : 20170317/498e4ca953ca7e4ba0e9bc06526a4e89.jpg
         * photo5 : 20170317/ac11db66e91e2ecbae3666291d597c1c.jpg
         * photo6 : 20170317/d9ad381985d7e6f49f2110dbbab9ead8.jpg
         */

        private int factory_id;
        private String company;
        private String address;
        private String main_products;
        private String truck_type;
        private String head;
        private String mobile;
        private String door;
        private String photo;
        private String photo2;
        private String photo3;
        private String photo4;
        private String photo5;
        private String photo6;

        public int getFactory_id() {
            return factory_id;
        }

        public void setFactory_id(int factory_id) {
            this.factory_id = factory_id;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getDoor() {
            return door;
        }

        public void setDoor(String door) {
            this.door = door;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getPhoto2() {
            return photo2;
        }

        public void setPhoto2(String photo2) {
            this.photo2 = photo2;
        }

        public String getPhoto3() {
            return photo3;
        }

        public void setPhoto3(String photo3) {
            this.photo3 = photo3;
        }

        public String getPhoto4() {
            return photo4;
        }

        public void setPhoto4(String photo4) {
            this.photo4 = photo4;
        }

        public String getPhoto5() {
            return photo5;
        }

        public void setPhoto5(String photo5) {
            this.photo5 = photo5;
        }

        public String getPhoto6() {
            return photo6;
        }

        public void setPhoto6(String photo6) {
            this.photo6 = photo6;
        }
    }
}
