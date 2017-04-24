package com.huotongtianxia.huoyuan.ui.WDCD.grzl;

import com.huotongtianxia.huoyuan.bean.GRZLBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class GRZLMode implements GRZLContract.Mode{
    @Override
    public void loadGRZL(Callback<GRZLBean> callback, int driver_id) {
        HttpUtils.newInstance().loadGRZLBean(callback,driver_id);
    }
}
