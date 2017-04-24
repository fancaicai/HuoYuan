package com.huotongtianxia.huoyuan.ui.WDCD.ddxq;

import com.huotongtianxia.huoyuan.bean.PJBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class PJMode implements PJContract.Mode{
    @Override
    public void loadPJ(Callback<PJBean> callback, String uid, int estimate_id, String order_num) {
        HttpUtils.newInstance().loadPJBean(callback,uid,order_num,estimate_id);
    }
}
