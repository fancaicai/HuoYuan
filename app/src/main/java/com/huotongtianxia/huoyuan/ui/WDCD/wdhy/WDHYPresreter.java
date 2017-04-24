package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;

import android.os.Handler;
import android.util.Log;

import com.huotongtianxia.huoyuan.bean.WDHYBBean;
import com.huotongtianxia.huoyuan.bean.WDHYBean;
import com.huotongtianxia.huoyuan.bean.WDHYQXBean;
import com.huotongtianxia.huoyuan.bean.WDHYSCBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class WDHYPresreter implements WDHYContract.Presreter{
    private WDHYContract.View view;
    private WDHYContract.Mode mode;
    private int status1;
    private String id;
    private String order_num;

    public WDHYPresreter(WDHYContract.View view,int status1,String id,String order_num){
        this.view = view;
        this.mode = new WDHYMode();
        this.status1 = status1;
        this.id = id;
        this.order_num = order_num;
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        int status =status1;
        mode.loadWDHY(new Callback<WDHYBean>() {
            @Override
            public void onResponse(Call<WDHYBean> call, Response<WDHYBean> response) {
                if (response.isSuccessful()){
                    final WDHYBean body = response.body();
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
            public void onFailure(Call<WDHYBean> call, Throwable t) {

            }
        },factory_id,status);
    }

    @Override
    public void getData1() {
        String factory_id = DLActivity.id;
        int status =0;
        mode.loadWDHYB(new Callback<WDHYBBean>() {
            @Override
            public void onResponse(Call<WDHYBBean> call, Response<WDHYBBean> response) {
                if (response.isSuccessful()){
                    final WDHYBBean body = response.body();
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
            public void onFailure(Call<WDHYBBean> call, Throwable t) {

            }
        },factory_id,status);
    }

    @Override
    public void getData2() {
        mode.loadWDHYQX(new Callback<WDHYQXBean>() {
            @Override
            public void onResponse(Call<WDHYQXBean> call, Response<WDHYQXBean> response) {
                if (response.isSuccessful()){
                    final WDHYQXBean body = response.body();
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
            public void onFailure(Call<WDHYQXBean> call, Throwable t) {

            }
        },id);
    }

    @Override
    public void getData3() {
        String member_type = DLActivity.membertype;
        mode.loadWDHYSC(new Callback<WDHYSCBean>() {
            @Override
            public void onResponse(Call<WDHYSCBean> call, Response<WDHYSCBean> response) {
                if (response.isSuccessful()){
                    final WDHYSCBean body = response.body();
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
            public void onFailure(Call<WDHYSCBean> call, Throwable t) {

            }
        },member_type,order_num);
    }
}
