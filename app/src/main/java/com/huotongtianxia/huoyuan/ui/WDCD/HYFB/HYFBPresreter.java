package com.huotongtianxia.huoyuan.ui.WDCD.HYFB;

import android.os.Handler;
import android.util.Log;

import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.bean.HYFB2Bean;
import com.huotongtianxia.huoyuan.bean.HYFBBean;
import com.huotongtianxia.huoyuan.bean.HYFBSHBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/18 0018.
 */

public class HYFBPresreter implements HYFBContract.Presreter{
    private HYFBContract.View view;
    private HYFBContract.Mode mode;
    private String name,we,send,truck_type,truck_length,provinc,cit,rmb;
    private int fhrid, shrid;

    public HYFBPresreter(HYFBContract.View view,int fhrid,int shrid,String name,String we,String send,String truck_type,String truck_length,String provinc,String cit,String rmb){
        this.view = view;
        this.mode = new HYFBMode();
        this.fhrid = fhrid;
        this.shrid = shrid;
        this.name = name;
        this.we = we;
        this.send = send;
        this.truck_type = truck_type;
        this.truck_length = truck_length;
        this.provinc = provinc;
        this.cit = cit;
        this.rmb = rmb;
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        int shi_id = fhrid;
        int customer_id = shrid;
        String send_time = send;
        String goods_type = name;
        String require_truck_weight = we;
        String require_truck_length = truck_length;
        String require_truck_type =truck_type;
        String offer_price = rmb;
        mode.loadHYFB(new Callback<HYFBBean>() {
            @Override
            public void onResponse(Call<HYFBBean> call, Response<HYFBBean> response) {
                if (response.isSuccessful()){
                    final HYFBBean body = response.body();
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
            public void onFailure(Call<HYFBBean> call, Throwable t) {

            }
        },factory_id,shi_id,customer_id,send_time,goods_type,require_truck_weight,require_truck_length,require_truck_type,offer_price);

    }

    @Override
    public void getData1() {
        String uid = DLActivity.id;
        String member_type = DLActivity.membertype;
        String province = provinc;
        String city = cit;
        mode.loadHYFBSH(new Callback<HYFBSHBean>() {
            @Override
            public void onResponse(Call<HYFBSHBean> call, Response<HYFBSHBean> response) {
                if (response.isSuccessful()){
                    final HYFBSHBean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse1(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<HYFBSHBean> call, Throwable t) {

            }
        },uid,member_type,province,city);
    }

    @Override
    public void getData3() {
        String uid = DLActivity.id;
        String member_type = DLActivity.membertype;
        String province = provinc;
        String city = cit;
        mode.loadHYFB2(new Callback<HYFB2Bean>() {
            @Override
            public void onResponse(Call<HYFB2Bean> call, Response<HYFB2Bean> response) {
                if (response.isSuccessful()){
                    final HYFB2Bean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse3(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<HYFB2Bean> call, Throwable t) {

            }
        },uid,member_type,province,city);
    }

}
