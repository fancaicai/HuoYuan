package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */

public class HYXXPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> totalist = null;

    private String[] titlelist = null;

    public HYXXPagerAdapter(FragmentManager fm, List<Fragment> totalist, String[] titlelist) {
        super(fm);
        this.totalist = totalist;
        this.titlelist= titlelist;
    }

    @Override
    public Fragment getItem(int position) {
        return totalist.get(position);
    }

    @Override
    public int getCount() {
        return totalist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist[position];
    }
}
