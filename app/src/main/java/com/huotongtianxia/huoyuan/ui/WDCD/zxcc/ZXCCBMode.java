package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import com.huotongtianxia.huoyuan.bean.ZXCCBBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class ZXCCBMode implements ZXCCBContract.Mode {
    @Override
    public void loadZXCCB(Callback<ZXCCBBean> callback, String locality) {
        HttpUtils.newInstance().loadZXCCBBean(callback,locality);
    }
}
