package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import android.content.Context;
import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.bean.HuoYuanPhoto;
import com.huotongtianxia.huoyuan.http.HttpUtils;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;
import com.huotongtianxia.huoyuan.util.ToastUtil;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class GSZLPresreter implements GSZLContract.Presreter{
    private GSZLContract.View view;
    private GSZLContract.Mode mode;
    private Context context;

    public GSZLPresreter (GSZLContract.View view, Context context){
        this.context=context;
        this.view = view;
        this.mode = new GSZLMode();
    }

    @Override
    public void getData() {
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
                            view.onResponse(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<GSZLBean> call, Throwable t) {

            }
        },factory_id);
    }
    // 上传及更新头像
    public void uploadPhoto(File file) {

//        // 显示进度
//        mAccountView.showProgress();

        // 构建上传的文件的部分
        MultipartBody.Part part = MultipartBody.Part.createFormData("image", "photo.png", RequestBody.create(null, file));

        Call<HuoYuanPhoto> upload = HttpUtils.newInstance().getTreasureApi().upload(part);
        upload.enqueue(new Callback<HuoYuanPhoto>() {
            @Override
            public void onResponse(Call<HuoYuanPhoto> call, Response<HuoYuanPhoto> response) {
                if (response.isSuccessful()) {
                    HuoYuanPhoto body = response.body();
                    if (body==null) {
                        ToastUtil.showShortToast(context,"未知错误");
                    }
                        ToastUtil.show(context,"上传成功");
                }
            }

            @Override
            public void onFailure(Call<HuoYuanPhoto> call, Throwable t) {
                ToastUtil.showShortToast(context,"上传失败");
            }
        });
    }
}
