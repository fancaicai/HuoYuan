package com.huotongtianxia.huoyuan.ui.WDCD.login;


import com.huotongtianxia.huoyuan.bean.DLBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/7 0007.
 */

public class DLMode implements DLContract.Mode{
    @Override
    public void loadDL(Callback<DLBean> callback, String tel, String password) {
        HttpUtils.newInstance().loadDLBean(callback,tel,password);
    }
}
