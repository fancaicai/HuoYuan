package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import com.huotongtianxia.huoyuan.bean.TJKHZLBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class TJKHZLMode implements TJKHZLContract.Mode{

    @Override
    public void loadTJKHZL(Callback<TJKHZLBean> callback, String uid, String member_type, String company_name, String contacts, String tel, String province, String city, String address) {
        HttpUtils.newInstance().loadTJKHZLBean(callback,uid,member_type,company_name,contacts,tel,province,city,address);
    }
}
