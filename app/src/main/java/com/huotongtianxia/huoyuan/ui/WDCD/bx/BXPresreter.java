package com.huotongtianxia.huoyuan.ui.WDCD.bx;


import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.BXBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class BXPresreter implements BXContract.Presreter{
    private BXContract.Mode mode;
    private BXContract.View view;
    private String insure_name, insure_tel, recognizee_name, recognizee_tel, plate_number, yun_number, sum_assured, good_basic, goods_quantity,
            goods_name, goods_pack, goods_value, yun_start, yun_end, create_time;

    public BXPresreter (BXContract.View view, String insure_name, String insure_tel, String recognizee_name, String recognizee_tel, String plate_number, String yun_number, String sum_assured, String good_basic, String goods_quantity, String goods_name, String goods_pack, String goods_value, String yun_start, String yun_end, String create_time){
        this.view = view;
        this.mode = new BXMode();
        this.insure_name = insure_name;
        this.insure_tel = insure_tel;
        this.recognizee_name = recognizee_name;
        this.recognizee_tel = recognizee_tel;
        this.plate_number = plate_number;
        this.yun_number = yun_number;
        this.sum_assured = sum_assured;
        this.good_basic = good_basic;
        this.goods_quantity = goods_quantity;
        this.goods_name = goods_name;
        this.goods_pack = goods_pack;
        this.goods_value = goods_value;
        this.yun_start = yun_start;
        this.yun_end = yun_end;
        this.create_time = create_time;
    }

    @Override
    public void getData() {
        mode.loadBXB(new Callback<BXBean>() {
            @Override
            public void onResponse(Call<BXBean> call, Response<BXBean> response) {
                if (response.isSuccessful()){
                    final BXBean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<BXBean> call, Throwable t) {

            }
        },insure_name, insure_tel, recognizee_name, recognizee_tel, plate_number, yun_number, sum_assured, good_basic, goods_quantity,
                goods_name, goods_pack, goods_value, yun_start, yun_end, create_time);
    }
}
