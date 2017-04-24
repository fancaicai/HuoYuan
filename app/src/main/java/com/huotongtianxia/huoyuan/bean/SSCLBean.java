package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class SSCLBean {

    /**
     * data : [{"driver_id":358,"headimgurl":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM7fYNqoIA1xDNEVfkSLFdOTdTJy31tsjeal8eATh0NMlRCUCr1HxOZibL2QRVkn36bAelib7xMLGNgHXgHE5ib6B570qsp4XZGHG4/0","name":"夏青","plate_number":"夏青","locality":"太原市","tel":"18635795207","weight":"66","type":"高栏","length":"4米"}]
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
         * driver_id : 358
         * headimgurl : http://wx.qlogo.cn/mmopen/Q3auHgzwzM7fYNqoIA1xDNEVfkSLFdOTdTJy31tsjeal8eATh0NMlRCUCr1HxOZibL2QRVkn36bAelib7xMLGNgHXgHE5ib6B570qsp4XZGHG4/0
         * name : 夏青
         * plate_number : 夏青
         * locality : 太原市
         * tel : 18635795207
         * weight : 66
         * type : 高栏
         * length : 4米
         */

        private int driver_id;
        private String headimgurl;
        private String name;
        private String plate_number;
        private String locality;
        private String tel;
        private String weight;
        private String type;
        private String length;

        public int getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(int driver_id) {
            this.driver_id = driver_id;
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
