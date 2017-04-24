package com.huotongtianxia.huoyuan.ui.WDCD.ddxq;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.DDXQBean;
import com.huotongtianxia.huoyuan.bean.QRSHBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/27 0027.
 */

public class DDXQContract {
    public interface View extends IBaseView {
        void onResponse(DDXQBean ddxqBean);
        void onResponse1(QRSHBean qrshBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadDDXQ(Callback<DDXQBean> callback, String order_num);
        void  loadQRSH(Callback<QRSHBean> callback, String uid, String order_num, String yun_status);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData1();
    }
}
