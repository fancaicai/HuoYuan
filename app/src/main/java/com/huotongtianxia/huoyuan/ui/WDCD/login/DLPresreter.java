package com.huotongtianxia.huoyuan.ui.WDCD.login;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.bean.DLBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/15 0015.
 */

public class DLPresreter implements DLContract.Presreter{
    private DLContract.View view;
    private DLContract.Mode mode;
    private String userName;
    private String userPwd;
    private Context context;

    public DLPresreter (DLContract.View view ,String userName , String userPwd , Context context){
        this.view = view;
        this.mode = new DLMode();
        this.userName = userName;
        this.userPwd = userPwd;
        this.context = context;
    }

    @Override
    public void getData() {
        String tel = userName;
        String password = userPwd;
        mode.loadDL(new Callback<DLBean>() {
            @Override
            public void onResponse(Call<DLBean> call, Response<DLBean> response) {
                if (response.isSuccessful()){
                    final DLBean bady = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(bady);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<DLBean> call, Throwable t) {
                Toast.makeText(context, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        },tel,password);
    }
}
