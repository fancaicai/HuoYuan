package com.huotongtianxia.huoyuan.common.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Gjl on 2016/6/26 18:00.
 */
public class TwoViewpagerView extends RelativeLayout {


    private int colorFont;
    private int colorFontSelected;
    public View pager0;
    public View pager1;
    private Context context;
    private ViewHolder holder;

    public TwoViewpagerView(Context context) {
        this(context, null, 0);
    }

    public TwoViewpagerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TwoViewpagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_two_viewpager, this, true);
        holder = new ViewHolder(view);
        colorFont = getResources().getColor(R.color.home1);
        colorFontSelected = getResources().getColor(R.color.zi);
        holder.twoViewpagerPager.setAdapter(new PagesAdapter());
        holder.twoViewpagerPager.addOnPageChangeListener(new GuidePageChangeListener());
        holder.twoViewpagerTxt0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.twoViewpagerPager.setCurrentItem(0);
            }
        });
        holder.twoViewpagerTxt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.twoViewpagerPager.setCurrentItem(1);
            }
        });
    }


    public void setTitle0(String txt0) {

        holder.twoViewpagerTxt0.setText(txt0);
    }

    public void setTitle1(String txt1) {

        holder.twoViewpagerTxt1.setText(txt1);
    }

    public void setPager0(View view) {
        pager0 = view;
    }

    public void setPager1(View view) {
        pager1 = view;
    }


    private void showPager0() {

        holder.twoViewpagerTxt0.setTextColor(colorFontSelected);
        if (holder.twoViewpagerTxt0Selected.getVisibility() != View.VISIBLE) {
            holder.twoViewpagerTxt0Selected.setVisibility(View.VISIBLE);
        }
        holder.twoViewpagerTxt1.setTextColor(colorFont);
        if (holder.twoViewpagerTxt1Selected.getVisibility() != View.INVISIBLE) {
            holder.twoViewpagerTxt1Selected.setVisibility(View.INVISIBLE);
        }
    }

    private void showPager1() {

        holder.twoViewpagerTxt0.setTextColor(colorFont);
        if (holder.twoViewpagerTxt0Selected.getVisibility() != View.INVISIBLE) {
            holder.twoViewpagerTxt0Selected.setVisibility(View.INVISIBLE);
        }
        holder.twoViewpagerTxt1.setTextColor(colorFontSelected);
        if (holder.twoViewpagerTxt1Selected.getVisibility() != View.VISIBLE) {
            holder.twoViewpagerTxt1Selected.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.two_viewpager_txt0)
    void onClick0() {
        showPager0();
    }

    @OnClick(R.id.two_viewpager_txt1)
    void onClick1() {
        showPager1();
    }

    private class PagesAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            if (position == 0) {

                container.addView(pager0);
                return pager0;
            } else {

                container.addView(pager1);
                return pager1;
            }
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (position == 0) {
                container.removeView(pager0);

            } else {
                container.removeView(pager1);

            }
        }
    }

    class GuidePageChangeListener implements ViewPager.OnPageChangeListener {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position == 0) {

                showPager0();
            } else {

                showPager1();

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    static class ViewHolder {
        @Bind(R.id.two_viewpager_view)
        View twoViewpagerView;
        @Bind(R.id.two_viewpager_txt0)
        TextView twoViewpagerTxt0;
        @Bind(R.id.two_viewpager_txt1)
        TextView twoViewpagerTxt1;
        @Bind(R.id.two_viewpager_txt0_selected)
        View twoViewpagerTxt0Selected;
        @Bind(R.id.two_viewpager_txt1_selected)
        View twoViewpagerTxt1Selected;
        @Bind(R.id.two_viewpager_pager)
        ViewPager twoViewpagerPager;
        @Bind(R.id.two_viewpager)
        RelativeLayout twoViewpager;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
