package com.huotongtianxia.huoyuan.ui.WDCD.grzl;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.GRZLBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class GRZLContract {
    public interface View extends IBaseView {
        void onResponse(GRZLBean grzlBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadGRZL(Callback<GRZLBean> callback, int driver_id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
