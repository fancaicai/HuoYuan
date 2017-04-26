package com.huotongtianxia.huoyuan.ui.WDCD.ddgz;

import com.huotongtianxia.huoyuan.bean.SJLIDWBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

public interface DdgzView {
    // 请求数据的展示
    public void showMessage(String msg);
    public void setData(List<SJLIDWBean> list);
}
