package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import com.huotongtianxia.huoyuan.bean.WDCD1Bean;
import com.huotongtianxia.huoyuan.bean.WDCD2Bean;
import com.huotongtianxia.huoyuan.bean.WDCDBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCSJBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class WDCDMode implements WDCDContract.Mode{
    @Override
    public void loadWDCD(Callback<WDCDBean> callback, String factory_id) {
        HttpUtils.newInstance().loadWDCDBean(callback,factory_id);
    }

    @Override
    public void loadWDCD1(Callback<WDCDBean> callback, String factory_id, String locality) {
        HttpUtils.newInstance().loadWDCD1Bean(callback,factory_id,locality);
    }

    @Override
    public void loadWDCD2(Callback<WDCDSCSJBean> callback, String driver_id, String factory_id) {
        HttpUtils.newInstance().loadWDCDSCSJBean(callback,driver_id,factory_id);
    }

}
