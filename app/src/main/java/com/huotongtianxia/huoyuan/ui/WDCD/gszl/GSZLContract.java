package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.GSZLBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class GSZLContract {
    public interface View extends IBaseView {
        void onResponse(GSZLBean gszlBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadGSZL(Callback<GSZLBean> callback, String factory_id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
