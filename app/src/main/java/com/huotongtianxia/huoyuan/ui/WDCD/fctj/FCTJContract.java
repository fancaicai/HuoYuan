package com.huotongtianxia.huoyuan.ui.WDCD.fctj;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.FCTJBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class FCTJContract {
    public interface View extends IBaseView {
        void onResponse(FCTJBean fctjBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadFCTJ(Callback<FCTJBean> callback, String create_time, String factory_id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
