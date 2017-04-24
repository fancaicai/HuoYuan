package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import com.huotongtianxia.huoyuan.bean.BJGSZLBean;
import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class BJGSZLMode implements BJGSZLContract.Mode{
    @Override
    public void loadBJGSZL(Callback<BJGSZLBean> callback, String factory_id, String company, String address, String main_products, String truck_type, String head, String mobile) {
        HttpUtils.newInstance().loadBJGSZLBean(callback,factory_id,company,address,main_products,truck_type,head ,mobile);
    }

    @Override
    public void loadGSZL(Callback<GSZLBean> callback, String factory_id) {
        HttpUtils.newInstance().loadGSZLBean(callback,factory_id);
    }
}
