package com.huotongtianxia.huoyuan.ui.WDCD.gen;

import com.huotongtianxia.huoyuan.bean.GenBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class GenMode implements GenContract.Mode{
    @Override
    public void loadGen(Callback<GenBean> callback, String factory_id, String version_id,String version_mini) {
        HttpUtils.newInstance().loadGenBean(callback,factory_id,version_id,version_mini);
    }
}
