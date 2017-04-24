package com.huotongtianxia.huoyuan.ui.WDCD.sscl;

import com.huotongtianxia.huoyuan.bean.SSCLBean;
import com.huotongtianxia.huoyuan.bean.TJCLBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class SSCLMode implements SSCLContract.Mode{
    @Override
    public void loadSSCL(Callback<SSCLBean> callback, String factory_id ,String plate_number) {
        HttpUtils.newInstance().loadSSCLBean(callback,factory_id,plate_number);
    }

    @Override
    public void loadWDCDSS(Callback<WDCDSCBean> callback, String plate_number) {
        HttpUtils.newInstance().loadWDCDSS(callback,plate_number);
    }

    @Override
    public void loadTJCL(Callback<TJCLBean> callback, String factory_id, String driver_id ) {
        HttpUtils.newInstance().loadTJCLBean(callback,factory_id,driver_id);
    }
}
