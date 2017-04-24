package com.huotongtianxia.huoyuan.ui.WDCD.GRZX;

import com.huotongtianxia.huoyuan.bean.GRZXBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class RGZXMode implements GRZXContract.Mode{
    @Override
    public void loadGRZX(Callback<GRZXBean> callback, String uid, String member_type) {
        HttpUtils.newInstance().loadGRZXBean(callback,uid,member_type);
    }
}
