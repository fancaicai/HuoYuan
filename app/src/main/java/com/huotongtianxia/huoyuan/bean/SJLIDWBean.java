package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
//司机历史定位Result类
public class SJLIDWBean {

    /**
     * code : 100
     * message : 获取数据成功！
     * data : {"fac_point":"112.56432,37.809127","id":255,"tel":"13934519410","lng":"112.618006","lat":"37.809127"}
     */

    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * fac_point : 112.56432,37.809127
         * id : 255
         * tel : 13934519410
         * lng : 112.618006
         * lat : 37.809127
         */

        private String fac_point;
        private int id;
        private String tel;
        private String lng;
        private String lat;

        public String getFac_point() {
            return fac_point;
        }

        public void setFac_point(String fac_point) {
            this.fac_point = fac_point;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }
}
