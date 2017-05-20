package com.huotongtianxia.huoyuan.common.view;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.util.MyUtil;
import com.huotongtianxia.huoyuan.util.iamgebroswer.CustomBitmapLoadCallBack;
import com.huotongtianxia.huoyuan.util.iamgebroswer.PhotoView;

import org.xutils.x;

import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageBrowserActivity extends AppCompatActivity {



    @Bind(R.id.imgbrow_pager)
    ViewPager imgbrowPager;
    //private int[] imgsId = new int[]{R.drawable.test3,R.drawable.test3, R.drawable.test3,R.drawable.test3, R.drawable.test3,R.drawable.test3};
    private List<Map<String, String>> imgList;
    private int currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagebrowser);
        ButterKnife.bind(this);
        initView();

    }


    private void initView() {

//        MyApplication.flagSapcestateRefresh=false;
        final CustomBitmapLoadCallBack callBack = new CustomBitmapLoadCallBack();
        imgList = (List<Map<String, String>>) getIntent().getSerializableExtra("imglist");
        currentItem = getIntent().getIntExtra("currentitem", 0);
        imgbrowPager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));
        imgbrowPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Map<String, String> map = imgList.get(position);
                final PhotoView view = new PhotoView(ImageBrowserActivity.this);
                view.enable();
                view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//                x.image().loadDrawable(map.get("yuan"), MyUtil.imageYuanOptions, new Callback.CommonCallback<Drawable>() {
//
//                    @Override
//                    public void onSuccess(Drawable result) {
//
//                        Log.i("浏览大图请求", "成功");
//                        view.setImageDrawable(result);
//                    }
//
//                    @Override
//                    public void onError(Throwable ex, boolean isOnCallback) {
//
//                        Log.i("浏览大图请求失败", ex.toString());
//                    }
//
//                    @Override
//                    public void onCancelled(CancelledException cex) {
//
//                    }
//
//                    @Override
//                    public void onFinished() {
//
//                    }
//                });
                x.image().bind(view, map.get("yuan"), MyUtil.imageYuanOptions, callBack);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        imgbrowPager.setCurrentItem(currentItem);
    }


}
