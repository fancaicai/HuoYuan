package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/3/27 0027.
 */

public class DDXQBean {


    /**
     * data : {"id":"65","order_num":"2017032037115","create_time":"1489971503","cost":"100","pay_status":"1","yun_status":"0","driver_name":"","driver_tel":"13934519410","driver_card":"","shipper":"孟明海","shipper_id":"89","shipper_call":"15235116631","shipper_province":"山西省","shipper_city":"太原市","shipper_address":"山西省太原市小店区时代广场","goods_name":"钢板","way":"无","weight":"10","receive_province":"省份","receive_city":"-城市-","receive_address":"省份-城市-内蒙古呼和浩特","receiver":"石雪芳","receiver_call":"15003400417","send_time":"1489852800","gid":"318","estimate_id":"0","point":"112.56432,37.809127","company":"货通天下里"}
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
         * id : 65
         * order_num : 2017032037115
         * create_time : 1489971503
         * cost : 100
         * pay_status : 1
         * yun_status : 0
         * driver_name :
         * driver_tel : 13934519410
         * driver_card :
         * shipper : 孟明海
         * shipper_id : 89
         * shipper_call : 15235116631
         * shipper_province : 山西省
         * shipper_city : 太原市
         * shipper_address : 山西省太原市小店区时代广场
         * goods_name : 钢板
         * way : 无
         * weight : 10
         * receive_province : 省份
         * receive_city : -城市-
         * receive_address : 省份-城市-内蒙古呼和浩特
         * receiver : 石雪芳
         * receiver_call : 15003400417
         * send_time : 1489852800
         * gid : 318
         * estimate_id : 0
         * point : 112.56432,37.809127
         * company : 货通天下里
         */

        private String id;
        private String order_num;
        private String create_time;
        private String cost;
        private String pay_status;
        private String yun_status;
        private String driver_name;
        private String driver_tel;
        private String driver_card;
        private String shipper;
        private String shipper_id;
        private String shipper_call;
        private String shipper_province;
        private String shipper_city;
        private String shipper_address;
        private String goods_name;
        private String way;
        private String weight;
        private String receive_province;
        private String receive_city;
        private String receive_address;
        private String receiver;
        private String receiver_call;
        private String send_time;
        private String gid;
        private String estimate_id;
        private String point;
        private String company;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getYun_status() {
            return yun_status;
        }

        public void setYun_status(String yun_status) {
            this.yun_status = yun_status;
        }

        public String getDriver_name() {
            return driver_name;
        }

        public void setDriver_name(String driver_name) {
            this.driver_name = driver_name;
        }

        public String getDriver_tel() {
            return driver_tel;
        }

        public void setDriver_tel(String driver_tel) {
            this.driver_tel = driver_tel;
        }

        public String getDriver_card() {
            return driver_card;
        }

        public void setDriver_card(String driver_card) {
            this.driver_card = driver_card;
        }

        public String getShipper() {
            return shipper;
        }

        public void setShipper(String shipper) {
            this.shipper = shipper;
        }

        public String getShipper_id() {
            return shipper_id;
        }

        public void setShipper_id(String shipper_id) {
            this.shipper_id = shipper_id;
        }

        public String getShipper_call() {
            return shipper_call;
        }

        public void setShipper_call(String shipper_call) {
            this.shipper_call = shipper_call;
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

        public String getShipper_address() {
            return shipper_address;
        }

        public void setShipper_address(String shipper_address) {
            this.shipper_address = shipper_address;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getWay() {
            return way;
        }

        public void setWay(String way) {
            this.way = way;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
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

        public String getReceive_address() {
            return receive_address;
        }

        public void setReceive_address(String receive_address) {
            this.receive_address = receive_address;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getReceiver_call() {
            return receiver_call;
        }

        public void setReceiver_call(String receiver_call) {
            this.receiver_call = receiver_call;
        }

        public String getSend_time() {
            return send_time;
        }

        public void setSend_time(String send_time) {
            this.send_time = send_time;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getEstimate_id() {
            return estimate_id;
        }

        public void setEstimate_id(String estimate_id) {
            this.estimate_id = estimate_id;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }
}
