package com.huotongtianxia.huoyuan.ui.WDCD.sscl;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.bean.SSCLBean;
import com.huotongtianxia.huoyuan.bean.TJCLBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class SSCLPresreter implements SSCLContract.Presreter{
    private SSCLContract.View view;
    private SSCLContract.Mode mode;
    private String tel;
    private Context context;

    public SSCLPresreter (SSCLContract.View view,String tel,Context context){
        this.view = view;
        this.mode = new SSCLMode();
        this.tel = tel;
        this.context = context;
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        String plate_number = tel;
        mode.loadSSCL(new Callback<SSCLBean>() {
            @Override
            public void onResponse(Call<SSCLBean> call, Response<SSCLBean> response) {
                if (response.isSuccessful()){
                    final SSCLBean body = response.body();
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
            public void onFailure(Call<SSCLBean> call, Throwable t) {
                Toast.makeText(context, "没有找到您想要的数据", Toast.LENGTH_SHORT).show();
            }

            },factory_id,plate_number);
    }

    @Override
    public void getData1() {
        String factory_id = DLActivity.id;
        String driver_id = tel;
        mode.loadTJCL(new Callback<TJCLBean>() {
            @Override
            public void onResponse(Call<TJCLBean> call, Response<TJCLBean> response) {
                if (response.isSuccessful()){
                    final TJCLBean body = response.body();
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
            public void onFailure(Call<TJCLBean> call, Throwable t) {

            }
        },factory_id,driver_id);
    }

    @Override
    public void getData2() {
        String plate_number = tel;
        mode.loadWDCDSS(new Callback<WDCDSCBean>() {
            @Override
            public void onResponse(Call<WDCDSCBean> call, Response<WDCDSCBean> response) {
                if (response.isSuccessful()){
                    final WDCDSCBean body = response.body();
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
            public void onFailure(Call<WDCDSCBean> call, Throwable t) {

            }
        },plate_number);
    }
}
