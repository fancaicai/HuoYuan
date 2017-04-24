package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class GRZLBean {


    /**
     * data : {"id":84,"headimgurl":"http://wx.qlogo.cn/mmopen/f7pLv4z95Ar30ryhlCAcXEOcDAh04ib6gfQdxyGCqXvGso0PMqoLBNgweDTm0T2cGpbfrm74HXQJwibecoUkUBUmNgkZHvicZ4c/0","plate_number":"晋M30593","name":"刘寅福","tel":"13734165384","length":7,"weight":"11","type":"高栏","jiaoyi":0,"hao":0,"cha":0,"advantage":"晋城","accept":"舟山/七台河/荆门"}
     * code : 100
     * message : OK
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
         * id : 84
         * headimgurl : http://wx.qlogo.cn/mmopen/f7pLv4z95Ar30ryhlCAcXEOcDAh04ib6gfQdxyGCqXvGso0PMqoLBNgweDTm0T2cGpbfrm74HXQJwibecoUkUBUmNgkZHvicZ4c/0
         * plate_number : 晋M30593
         * name : 刘寅福
         * tel : 13734165384
         * length : 7
         * weight : 11
         * type : 高栏
         * jiaoyi : 0
         * hao : 0
         * cha : 0
         * advantage : 晋城
         * accept : 舟山/七台河/荆门
         */

        private int id;
        private String headimgurl;
        private String plate_number;
        private String name;
        private String tel;
        private int length;
        private String weight;
        private String type;
        private int jiaoyi;
        private int hao;
        private int cha;
        private String advantage;
        private String accept;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public String getPlate_number() {
            return plate_number;
        }

        public void setPlate_number(String plate_number) {
            this.plate_number = plate_number;
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

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
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

        public int getJiaoyi() {
            return jiaoyi;
        }

        public void setJiaoyi(int jiaoyi) {
            this.jiaoyi = jiaoyi;
        }

        public int getHao() {
            return hao;
        }

        public void setHao(int hao) {
            this.hao = hao;
        }

        public int getCha() {
            return cha;
        }

        public void setCha(int cha) {
            this.cha = cha;
        }

        public String getAdvantage() {
            return advantage;
        }

        public void setAdvantage(String advantage) {
            this.advantage = advantage;
        }

        public String getAccept() {
            return accept;
        }

        public void setAccept(String accept) {
            this.accept = accept;
        }
    }
}
