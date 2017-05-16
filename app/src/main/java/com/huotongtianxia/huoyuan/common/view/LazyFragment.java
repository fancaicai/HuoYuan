package com.huotongtianxia.huoyuan.common.view;

import android.support.v4.app.Fragment;

/**
 * 类描述:    [fragment的懒加载]
 * 创建人:    Gjl
 * 创建时间:  2016/11/19 16:16
 * 修改人:
 * 修改时间:  2016/11/19 16:16
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */

public abstract class LazyFragment extends Fragment {
    protected boolean isVisible;
    /**
     * 在这里实现Fragment数据的缓加载.
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible(){
        lazyLoad();
    }

    protected abstract void lazyLoad();

    protected void onInvisible(){}
}
