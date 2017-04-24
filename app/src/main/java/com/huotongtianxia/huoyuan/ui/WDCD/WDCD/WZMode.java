package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import com.huotongtianxia.huoyuan.bean.WZBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public class WZMode implements WZContract.Mode{
    @Override
    public void loadWZ(Callback<WZBean> callback, int id) {
        HttpUtils.newInstance().loadWZBean(callback,id);
    }
}
