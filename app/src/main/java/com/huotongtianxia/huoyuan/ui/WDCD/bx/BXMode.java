package com.huotongtianxia.huoyuan.ui.WDCD.bx;

import com.huotongtianxia.huoyuan.bean.BXBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class BXMode implements BXContract.Mode{
    @Override
    public void loadBXB(Callback<BXBean> callback, String insure_name, String insure_tel, String recognizee_name, String recognizee_tel, String plate_number, String yun_number, String sum_assured, String good_basic, String goods_quantity, String goods_name, String goods_pack, String goods_value, String yun_start, String yun_end, String create_time) {
        HttpUtils.newInstance().loadBXBean(callback,insure_name, insure_tel, recognizee_name, recognizee_tel, plate_number, yun_number, sum_assured, good_basic, goods_quantity, goods_name, goods_pack, goods_value, yun_start, yun_end, create_time);
    }
}
