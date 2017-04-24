package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.BJGSZLBean;
import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class BJGSZLPresreter implements BJGSZLContract.Presreter{
    private BJGSZLContract.View view;
    private BJGSZLContract.Mode mode;
    private int count;
    private String id;
    private String company,address,main_products,truck_type,head,mobile;

    public BJGSZLPresreter (BJGSZLContract.View view ,String id,int count){
        this.view = view;
        this.mode = new BJGSZLMode();
        this.id = id;
        this.count = count;
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        if (count ==1){
            company = id;
        }else if (count == 2){
            address = id;
        }else if (count == 3){
            main_products = id;
        }else if (count == 4){
            truck_type = id;
        }else if (count == 5){
            head = id;
        }else if (count == 6){
            mobile = id;
        }
        mode.loadBJGSZL(new Callback<BJGSZLBean>() {
            @Override
            public void onResponse(Call<BJGSZLBean> call, Response<BJGSZLBean> response) {
                if (response.isSuccessful()){
                    final BJGSZLBean body = response.body();
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
            public void onFailure(Call<BJGSZLBean> call, Throwable t) {

            }
        },factory_id,company,address,main_products,truck_type,head,mobile);

    }

    @Override
    public void getData1() {
        String factory_id = DLActivity.id;
        mode.loadGSZL(new Callback<GSZLBean>() {
            @Override
            public void onResponse(Call<GSZLBean> call, Response<GSZLBean> response) {
                if (response.isSuccessful()){
                    final GSZLBean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse2(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<GSZLBean> call, Throwable t) {

            }
        },factory_id);
    }
}
