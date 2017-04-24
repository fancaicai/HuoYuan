package com.huotongtianxia.huoyuan.ui.WDCD.gen;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.GenBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class GenContract {
    public interface View extends IBaseView {
        void onResponse(GenBean genBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadGen(Callback<GenBean> callback, String factory_id, String version_id,String version_mini);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
