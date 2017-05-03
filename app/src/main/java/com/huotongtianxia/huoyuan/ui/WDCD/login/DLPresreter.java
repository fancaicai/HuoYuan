package com.huotongtianxia.huoyuan.ui.WDCD.login;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.bean.DLBean;
import com.huotongtianxia.huoyuan.util.ToastUtil;

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
    private LoginView mLoginView;
    public DLPresreter (DLContract.View view ,String userName , String userPwd , Context context,LoginView loginView){
        this.mLoginView=loginView;
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
//        点击登录后，显示一张图片
        mLoginView.showImageView();
        mode.loadDL(new Callback<DLBean>() {
            @Override
            public void onResponse(Call<DLBean> call, Response<DLBean> response) {
//                登录成功后将图片隐藏起来
                mLoginView.hideImageView();
                if (response.isSuccessful()){
                    final DLBean bady = response.body();
                    if (bady==null){
                        ToastUtil.show(context,"未知错误");
                        return;
                    }
                        Handler handler = new Handler();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                view.onResponse(bady);
                            }
                        });
//                    登录成功后吐司一个登录成功的提示
                        ToastUtil.show(context,"登录成功！");
                }
            }
            @Override
            public void onFailure(Call<DLBean> call, Throwable t) {
//                登录失败，隐藏图片，显示一段错误的信息
                mLoginView.hideImageView();
                Toast.makeText(context, "用户名或密码错误"+t.getMessage(), Toast.LENGTH_SHORT).show();
                mLoginView.showOther();
            }
        },tel,password);
    }
}
