package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import com.huotongtianxia.huoyuan.bean.GYSBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class GYSZMode implements GYSContract.Mode{
    @Override
    public void loadGYS(Callback<GYSBean> callback, String uid , String member_type) {
        HttpUtils.newInstance().loadGYSBean(callback,uid,member_type);
    }
}
