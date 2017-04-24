package com.huotongtianxia.huoyuan.ui.WDCD.HYFB;

import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.bean.HYFB2Bean;
import com.huotongtianxia.huoyuan.bean.HYFBBean;
import com.huotongtianxia.huoyuan.bean.HYFBSHBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class HYFBMode implements HYFBContract.Mode{
    @Override
    public void loadHYFB(Callback<HYFBBean> callback, String factory_id, int shi_id, int customer_id, String send_time, String goods_type, String require_truck_weight, String require_truck_length, String require_truck_type,String offer_price) {
        HttpUtils.newInstance().loadHYFBBean(callback,factory_id,shi_id,customer_id,send_time,goods_type,require_truck_weight,require_truck_length,require_truck_type,offer_price);
    }

    @Override
    public void loadHYFBSH(Callback<HYFBSHBean> callback, String uid, String member_type, String province, String city) {
        HttpUtils.newInstance().loadHYFBSHBean(callback,uid,member_type,province,city);
    }

    @Override
    public void loadHYFB2(Callback<HYFB2Bean> callback, String uid, String member_type, String province, String city) {
        HttpUtils.newInstance().loadHYFB2Bean(callback,uid,member_type,province,city);
    }

}
