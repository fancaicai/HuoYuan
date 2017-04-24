package com.huotongtianxia.huoyuan.bean;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class WDZHBean {

    /**
     * data : {"company":"sssss","mobile":"","wechat":"","bank":"","bankid":0,"owner":""}
     * count : 8
     * code : 100
     * message : 数据获取成功！
     */

    private DataBean data;
    private String count;
    private int code;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
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

    public static class DataBean {
        /**
         * company : sssss
         * mobile :
         * wechat :
         * bank :
         * bankid : 0
         * owner :
         */

        private String company;
        private String mobile;
        private String wechat;
        private String bank;
        private int bankid;
        private String owner;

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public int getBankid() {
            return bankid;
        }

        public void setBankid(int bankid) {
            this.bankid = bankid;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }
}
