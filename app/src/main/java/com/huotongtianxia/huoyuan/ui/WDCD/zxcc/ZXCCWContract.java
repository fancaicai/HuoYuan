package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.ZXCCWBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCWContract {
    public interface View extends IBaseView {
        void onResponse(ZXCCWBean zxccwBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadZXCCW(Callback<ZXCCWBean> callback, String locality);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
