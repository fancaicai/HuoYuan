package com.huotongtianxia.huoyuan.ui.WDCD.login;


import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.DLBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/7 0007.
 */

public class DLContract {
    public interface View extends IBaseView {
        void onResponse(DLBean dlBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadDL(Callback<DLBean> callback, String tel, String password);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }

}
