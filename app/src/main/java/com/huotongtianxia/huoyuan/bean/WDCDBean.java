package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class WDCDBean {


    /**
     * data : [{"id":118,"factory_id":89,"driver_id":357,"create_time":"2017-04-13 11:42:00","company":"sssss","headimgurl":"","name":"","plate_number":"","locality":"晋中市","tel":"13834088294","weight":"","type":"","length":"0米"},{"id":115,"factory_id":89,"driver_id":354,"create_time":"2017-04-13 11:12:17","company":"sssss","headimgurl":"","name":"王建新","plate_number":"冀A8489Y","locality":"","tel":"15935678667","weight":"31","type":"高栏","length":"10米"},{"id":114,"factory_id":89,"driver_id":353,"create_time":"2017-04-13 11:12:16","company":"sssss","headimgurl":"","name":"张小林","plate_number":"冀A9156Y","locality":"石家庄市","tel":"18835429388","weight":"46","type":"高栏","length":"10米"},{"id":124,"factory_id":89,"driver_id":335,"create_time":"2017-04-14 15:43:06","company":"sssss","headimgurl":"","name":"贾荣河","plate_number":"冀AKG440","locality":"","tel":"13453013522","weight":"30.5","type":"高栏","length":"10米"},{"id":112,"factory_id":89,"driver_id":343,"create_time":"2017-04-08 10:18:21","company":"sssss","headimgurl":"","name":"郭文刚","plate_number":"冀EC0516","locality":"","tel":"13603198822","weight":"15","type":"高栏","length":"10米"},{"id":119,"factory_id":89,"driver_id":358,"create_time":"2017-04-13 11:42:35","company":"sssss","headimgurl":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM7fYNqoIA1xDNEVfkSLFdOTdTJy31tsjeal8eATh0NMlRCUCr1HxOZibL2QRVkn36bAelib7xMLGNgHXgHE5ib6B570qsp4XZGHG4/0","name":"夏青","plate_number":"夏青","locality":"太原市","tel":"18635795207","weight":"66","type":"高栏","length":"4米"},{"id":65,"factory_id":89,"driver_id":93,"create_time":"2017-03-30 11:01:35","company":"sssss","headimgurl":"","name":"张卫国","plate_number":"晋3408","locality":"","tel":"18734144748","weight":"49","type":"高栏","length":"10米"},{"id":123,"factory_id":89,"driver_id":339,"create_time":"2017-04-14 15:46:20","company":"sssss","headimgurl":"","name":"黄飞杰","plate_number":"晋AL675A","locality":"太原市","tel":"18734600098","weight":"8.5","type":"高栏","length":"4米"},{"id":69,"factory_id":89,"driver_id":98,"create_time":"2017-03-30 11:01:47","company":"sssss","headimgurl":"","name":"段俊斌","plate_number":"晋K26728","locality":"","tel":"13546689123","weight":"11","type":"高栏","length":"7米"},{"id":116,"factory_id":89,"driver_id":355,"create_time":"2017-04-13 11:38:54","company":"sssss","headimgurl":"","name":"郑宏义","plate_number":"晋K28661","locality":"晋中市","tel":"13096636053","weight":"32","type":"厢货","length":"10米"},{"id":113,"factory_id":89,"driver_id":352,"create_time":"2017-04-13 11:12:11","company":"sssss","headimgurl":"","name":"闫志军","plate_number":"晋K5K680","locality":"晋中市","tel":"18235443446","weight":"10","type":"高栏","length":"4米"},{"id":117,"factory_id":89,"driver_id":356,"create_time":"2017-04-13 11:41:58","company":"sssss","headimgurl":"","name":"胡文霞","plate_number":"晋KD7002","locality":"吕梁市","tel":"15835835233","weight":"28","type":"平板","length":"20米"},{"id":64,"factory_id":89,"driver_id":84,"create_time":"2017-03-30 11:01:32","company":"sssss","headimgurl":"http://wx.qlogo.cn/mmopen/f7pLv4z95Ar30ryhlCAcXEOcDAh04ib6gfQdxyGCqXvGso0PMqoLBNgweDTm0T2cGpbfrm74HXQJwibecoUkUBUmNgkZHvicZ4c/0","name":"刘寅福","plate_number":"晋M30593","locality":"","tel":"13734165384","weight":"11","type":"高栏","length":"7米"},{"id":62,"factory_id":89,"driver_id":91,"create_time":"2017-03-30 11:01:05","company":"sssss","headimgurl":"","name":"侯永杰","plate_number":"晋M47096","locality":"","tel":"15713595600","weight":"18","type":"高栏","length":"10米"},{"id":63,"factory_id":89,"driver_id":81,"create_time":"2017-03-30 11:01:20","company":"sssss","headimgurl":"","name":"赵忙虎","plate_number":"晋M54597","locality":"","tel":"15503402281","weight":"33","type":"高栏","length":"10米"}]
     * count : 18
     * code : 100
     * message : 获取数据成功!
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
         * id : 118
         * factory_id : 89
         * driver_id : 357
         * create_time : 2017-04-13 11:42:00
         * company : sssss
         * headimgurl :
         * name :
         * plate_number :
         * locality : 晋中市
         * tel : 13834088294
         * weight :
         * type :
         * length : 0米
         */

        private int id;
        private int factory_id;
        private int driver_id;
        private String create_time;
        private String company;
        private String headimgurl;
        private String name;
        private String plate_number;
        private String locality;
        private String tel;
        private String weight;
        private String type;
        private String length;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFactory_id() {
            return factory_id;
        }

        public void setFactory_id(int factory_id) {
            this.factory_id = factory_id;
        }

        public int getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(int driver_id) {
            this.driver_id = driver_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
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

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
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
    }
}
