package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.SCKHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class KHZLMode implements KHZLContract.Mode{
    @Override
    public void loadFHR(Callback<FHRBean> callback, String factory_id) {
        HttpUtils.newInstance().loadFHRBean(callback,factory_id);
    }

    @Override
    public void loadSHR(Callback<SHRBean> callback, String factory_id) {
        HttpUtils.newInstance().loadSHRBean(callback,factory_id);
    }

    @Override
    public void loadSCKHZL(Callback<SCKHZLBean> callback, String uid, String member_type, String cus_id) {
        HttpUtils.newInstance().loadSCKHZLBean(callback,uid,member_type,cus_id);
    }
}
