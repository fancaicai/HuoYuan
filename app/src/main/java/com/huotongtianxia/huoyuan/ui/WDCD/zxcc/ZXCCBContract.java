package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.ZXCCBBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCBContract {
    public interface View extends IBaseView {
        void onResponse(ZXCCBBean zxccbBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadZXCCB(Callback<ZXCCBBean> callback, String locality);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
