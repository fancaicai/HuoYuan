package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import com.huotongtianxia.huoyuan.bean.ZXCCWBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class ZXCCWMode implements ZXCCWContract.Mode{
    @Override
    public void loadZXCCW(Callback<ZXCCWBean> callback, String locality) {
        HttpUtils.newInstance().loadZXCCWBean(callback,locality);
    }
}
