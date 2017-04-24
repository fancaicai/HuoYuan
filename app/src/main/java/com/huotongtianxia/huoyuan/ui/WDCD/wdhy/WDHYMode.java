package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;

import com.huotongtianxia.huoyuan.bean.WDHYBBean;
import com.huotongtianxia.huoyuan.bean.WDHYBean;
import com.huotongtianxia.huoyuan.bean.WDHYQXBean;
import com.huotongtianxia.huoyuan.bean.WDHYSCBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class WDHYMode implements WDHYContract.Mode{
    @Override
    public void loadWDHY(Callback<WDHYBean> callback, String factory_id, int status) {
        HttpUtils.newInstance().loadWDHYBean(callback,factory_id,status);
    }

    @Override
    public void loadWDHYB(Callback<WDHYBBean> callback, String factory_id, int status) {
        HttpUtils.newInstance().loadWDHYBBean(callback,factory_id,status);
    }

    @Override
    public void loadWDHYQX(Callback<WDHYQXBean> callback, String id) {
        HttpUtils.newInstance().loadWDHYQXBean(callback,id);
    }

    @Override
    public void loadWDHYSC(Callback<WDHYSCBean> callback, String member_typeint, String order_num) {
        HttpUtils.newInstance().loadWDHYSCBean(callback,member_typeint,order_num);
    }
}
