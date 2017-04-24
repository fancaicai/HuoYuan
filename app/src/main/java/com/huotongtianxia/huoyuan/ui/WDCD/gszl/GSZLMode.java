package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class GSZLMode implements GSZLContract.Mode{
    @Override
    public void loadGSZL(Callback<GSZLBean> callback, String factory_id) {
        HttpUtils.newInstance().loadGSZLBean(callback,factory_id);
    }

}
