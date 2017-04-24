package com.huotongtianxia.huoyuan.ui.WDCD.ddxq;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.PJBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class PJContract {
    public interface View extends IBaseView {
        void onResponse(PJBean pjBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadPJ(Callback<PJBean> callback, String uid, int estimate_id, String order_num);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
