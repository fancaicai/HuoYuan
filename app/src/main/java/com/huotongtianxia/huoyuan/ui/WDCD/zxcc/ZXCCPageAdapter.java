package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class ZXCCPageAdapter extends FragmentPagerAdapter {

    public ZXCCPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment content=null;
        if(position==0){
            content=new HCCFragment();
        }else{
            content=new BDCFragment();
        }
        return content;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title=null;
        if(position==0){
            title="回程车";
        }else{
            title="本地车";
        }
        return title;
    }
}
