package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.GYSBean;
import com.huotongtianxia.huoyuan.bean.ZXCCBBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/17 0017.
 */
//管理器
public class GYSContract {
    public interface View extends IBaseView {
        void onResponse(GYSBean gysBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadGYS(Callback<GYSBean> callback, String uid,String member_type);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
