package com.huotongtianxia.huoyuan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class FHRBean1 {

    /**
     * data : [{"id":60,"company_name":"大同煤业有限集团","contacts":"白","tel":"13653582497","province":"山西省","city":"大同","area":"","address":"山西大同小北街1号"},{"id":64,"company_name":"好好","contacts":"jjjjjj","tel":"北京","province":"北京","city":"东城","area":"","address":"uuuuu"},{"id":65,"company_name":"公积金","contacts":"给您","tel":"后脑","province":"北京","city":"东城","area":"","address":"给您"},{"id":66,"company_name":"工贸","contacts":"161616","tel":"灵敏","province":"北京","city":"东城","area":"","address":"161616"},{"id":67,"company_name":"张巧","contacts":"张巧","tel":"15235116631","province":"北京","city":"东城","area":"","address":"时代广场"},{"id":69,"company_name":"货通天下","contacts":"孟明海","tel":"15235116631","province":"山西省","city":"太原","area":"","address":"时代广场709"},{"id":102,"company_name":"货通天下","contacts":"尚振","tel":"13934519410","province":"内蒙古","city":"呼和浩特","area":"","address":"创业街9号"},{"id":113,"company_name":"pls阿萨","contacts":"肉末","tel":"肉欧诺","province":"省份","city":"-城市-","area":"","address":"说通"},{"id":120,"company_name":"pls阿萨","contacts":"肉末","tel":"肉欧诺","province":"省份","city":"-城市-","area":"","address":"说通"},{"id":148,"company_name":"萨尔吧","contacts":"754383","tel":"7556735","province":"河北省","city":"邯郸","area":"","address":"十二年"},{"id":150,"company_name":"了POS机","contacts":"43554243","tel":"5427675","province":"天津","city":"河北","area":"","address":"pls哦咯"},{"id":151,"company_name":"了POS机","contacts":"43554243","tel":"5427675","province":"山西省","city":"长治","area":"","address":"pls哦咯"},{"id":226,"company_name":"ww","contacts":"qq","tel":"123213213","province":"3","city":"4","area":"5","address":"6"},{"id":227,"company_name":"ww","contacts":"qq","tel":"11112222","province":"3","city":"4","area":"5","address":"6"}]
     * code : 100
     * message : 获取数据成功！
     */

    private int code;
    private String message;
    private List<SHRBean.DataBean> data;

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

    public List<SHRBean.DataBean> getData() {
        return data;
    }

    public void setData(List<SHRBean.DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 60
         * company_name : 大同煤业有限集团
         * contacts : 白
         * tel : 13653582497
         * province : 山西省
         * city : 大同
         * area :
         * address : 山西大同小北街1号
         */

        private int id;
        private String company_name;
        private String contacts;
        private String tel;
        private String province;
        private String city;
        private String area;
        private String address;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
