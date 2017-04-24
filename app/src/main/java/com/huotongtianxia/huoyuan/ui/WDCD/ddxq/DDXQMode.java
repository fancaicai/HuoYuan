package com.huotongtianxia.huoyuan.ui.WDCD.ddxq;

import com.huotongtianxia.huoyuan.bean.DDXQBean;
import com.huotongtianxia.huoyuan.bean.QRSHBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/27 0027.
 */

public class DDXQMode implements DDXQContract.Mode{

    @Override
    public void loadDDXQ(Callback<DDXQBean> callback, String order_num) {
        HttpUtils.newInstance().loadDDXQBean(callback,order_num);
    }

    @Override
    public void loadQRSH(Callback<QRSHBean> callback, String uid, String order_num, String yun_status) {
        HttpUtils.newInstance().loadQRSHBean(callback,uid,order_num,yun_status);
    }
}
