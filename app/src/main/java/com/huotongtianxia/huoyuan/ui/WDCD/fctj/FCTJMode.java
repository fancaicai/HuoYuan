package com.huotongtianxia.huoyuan.ui.WDCD.fctj;

import com.huotongtianxia.huoyuan.bean.FCTJBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class FCTJMode implements FCTJContract.Mode{
    @Override
    public void loadFCTJ(Callback<FCTJBean> callback, String create_time, String factory_id) {
        HttpUtils.newInstance().loadFCTJBean(callback,create_time,factory_id);
    }
}
