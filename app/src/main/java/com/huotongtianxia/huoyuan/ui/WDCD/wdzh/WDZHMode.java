package com.huotongtianxia.huoyuan.ui.WDCD.wdzh;

import com.huotongtianxia.huoyuan.bean.WDZHBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class WDZHMode implements WDZHContract.Mode{
    @Override
    public void loadWDZH(Callback<WDZHBean> callback, String factory_id) {
        HttpUtils.newInstance().loadWDZHBean(callback,factory_id);
    }
}
