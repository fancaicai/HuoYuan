package com.huotongtianxia.huoyuan.util.iamgebroswer;

import android.graphics.drawable.Drawable;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;

/**
 * Created by Gjl on 2016/7/8 15:07.
 */
public class CustomBitmapLoadCallBack implements Callback.ProgressCallback<Drawable> {

    @Override
    public void onWaiting() {

        LogUtil.e("下载等待中");

    }

    @Override
    public void onStarted() {

        LogUtil.e("下载开始");

    }

    @Override
    public void onLoading(long total, long current, boolean isDownloading) {

        LogUtil.e("下载中");
    }

    @Override
    public void onSuccess(Drawable result) {

        LogUtil.e("下载成功");

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

        LogUtil.e("下载出错，" + ex.getMessage());

    }

    @Override
    public void onCancelled(CancelledException cex) {

        LogUtil.e("下载取消");

    }

    @Override
    public void onFinished() {

        LogUtil.e("下载完成");

    }
}
