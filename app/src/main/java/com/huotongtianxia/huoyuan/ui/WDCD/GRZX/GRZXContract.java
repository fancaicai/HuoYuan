package com.huotongtianxia.huoyuan.ui.WDCD.GRZX;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.GRZXBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class GRZXContract {
    public interface View extends IBaseView {
        void onResponse(GRZXBean grzxBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadGRZX(Callback<GRZXBean> callback, String uid, String member_type);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
