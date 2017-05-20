package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.customview.IconSelectWindow;
import com.huotongtianxia.huoyuan.util.ToastUtil;

import org.hybridsquad.android.library.CropHandler;
import org.hybridsquad.android.library.CropHelper;
import org.hybridsquad.android.library.CropParams;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class GSZLActivity extends AppCompatActivity implements GSZLContract.View,AccountView {

    @Bind(R.id.gszl_text1)
    TextView gszlText1;
    @Bind(R.id.gszl_text2)
    TextView gszlText2;
    @Bind(R.id.gszl_text3)
    TextView gszlText3;
    @Bind(R.id.gszl_text4)
    TextView gszlText4;
    @Bind(R.id.gszl_text5)
    TextView gszlText5;
    @Bind(R.id.gszl_text6)
    TextView gszlText6;
    @Bind(R.id.back_tv)
    TextView backTv;
    @Bind(R.id.gszl_text7)
    TextView gszlText7;
    @Bind(R.id.gszl_text8)
    TextView gszlText8;
    @Bind(R.id.activity_gszl)
    LinearLayout activityGszl;

    public static String fac;
    public static String b1, b2, b3, b4, b5, b6, b7, b8;
    @Bind(R.id.huoyuan_photo)
    LinearLayout huoyuanPhoto;
    @Bind(R.id.mentou_photp)
    LinearLayout mentouPhotp;
    private int count = 0;
    private IconSelectWindow mSelectWindow;
    private GSZLPresreter presreter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
        setContentView(R.layout.activity_gszl);
        ButterKnife.bind(this);
        presreter = new GSZLPresreter(this,getApplicationContext());
        presreter.getData();
        initView();
    }
//    @OnClick({R.id.huoyuan_photo,R.id.mentou_photp})
//    public void showPhotoWindow(View view){
//        switch (view.getId()){
//            case R.id.huoyuan_photo:
////                Intent intent=new Intent(GSZLActivity.this,UploadPhotoActivity.class);
////                startActivity(intent);
//                if (mSelectWindow==null){
//                    mSelectWindow = new IconSelectWindow(this,mListener);
//                }
//                if (mSelectWindow.isShowing()){
//                    mSelectWindow.dismiss();
//                    return;
//                }
//                break;
//            case R.id.mentou_photp:
//                Intent intent1=new Intent(GSZLActivity.this,UploadPhotoActivity.class);
//                startActivity(intent1);
//                if (mSelectWindow==null){
//                    mSelectWindow = new IconSelectWindow(this,mListener);
//                }
//                if (mSelectWindow.isShowing()){
//                    mSelectWindow.dismiss();
//                    return;
//                }
//                break;
//
//        }
//        mSelectWindow.show();
//
//    }

    //添加货源照片
    @OnClick(R.id.huoyuan_photo)
    void huoyuanPhoto(){

        Intent intent=new Intent(GSZLActivity.this,PhotosActivity.class);
        intent.putExtra("numPhoto",6);
        startActivity(intent);
    }


    //添加门头照片
    @OnClick(R.id.mentou_photp)
    void mentouPhoto(){

        Intent intent=new Intent(GSZLActivity.this,PhotosActivity.class);
        intent.putExtra("numPhoto",1);
        startActivity(intent);
    }

    /**
     * 自定义字体
     *
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        GSZLPresreter presreter = new GSZLPresreter(this,getApplicationContext());
//        presreter.getData();
//    }

    public void initView() {
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }


    @Override
    public void onResponse(GSZLBean gszlBean) {
        b1 = gszlBean.getData().getCompany();
        b2 = gszlBean.getData().getAddress();
        b3 = gszlBean.getData().getMain_products();
        b4 = gszlBean.getData().getTruck_type();
        b5 = gszlBean.getData().getHead();
        b6 = gszlBean.getData().getMobile();
        gszlText1.setText(gszlBean.getData().getCompany());
        gszlText2.setText(gszlBean.getData().getAddress());
        gszlText3.setText(gszlBean.getData().getMain_products());
        gszlText4.setText(gszlBean.getData().getTruck_type());
        gszlText5.setText(gszlBean.getData().getHead());
        gszlText6.setText(gszlBean.getData().getMobile());
    }

    @Override
    public void onFailure(String s) {

    }

    @OnClick({R.id.gszl_text1, R.id.gszl_text2, R.id.gszl_text3, R.id.gszl_text4, R.id.gszl_text5, R.id.gszl_text6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gszl_text1:
                count = 1;
                Intent intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("count", count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text2:
                count = 2;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count", count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text3:
                count = 3;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count", count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text4:
                count = 4;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count", count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text5:
                count = 5;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count", count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text6:
                count = 6;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count", count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }

    // 跳转的监听
    private IconSelectWindow.Listener mListener = new IconSelectWindow.Listener() {
        // 到相册
        @Override
        public void toGallery() {
            Log.e("我是相册","您调用了相册");
            // 清除缓存
            CropHelper.clearCachedCropFile(mCropHandler.getCropParams().uri);
            Intent intent = CropHelper.buildCropFromGalleryIntent(mCropHandler.getCropParams());
            startActivityForResult(intent, CropHelper.REQUEST_CROP);
        }

        // 到相机
        @Override
        public void toCamera() {
            Log.e("我是相机","您调用了相机");
            // 清除之前剪切的图片的缓存
            CropHelper.clearCachedCropFile(mCropHandler.getCropParams().uri);
            // 跳转
            Intent intent = CropHelper.buildCaptureIntent(mCropHandler.getCropParams().uri);
            startActivityForResult(intent, CropHelper.REQUEST_CAMERA);
        }
    };

    // 图片处理
    private CropHandler mCropHandler = new CropHandler() {
        // 图片剪切之后：参数Uri代表剪切后的图片
        @Override
        public void onPhotoCropped(Uri uri) {
            // 拿到剪切之后的图片
            File file = new File(uri.getPath());
            //进行网络请求将图片上传
            presreter .uploadPhoto(file);

        }

        @Override
        public void onCropCancel() {
            ToastUtil.showShortToast(getContext(),"剪切取消");
        }

        @Override
        public void onCropFailed(String message) {
            ToastUtil.showShortToast(getContext(),message);
        }

        // 剪切的参数设置：Uri(图片剪切之后保存的路径)
        @Override
        public CropParams getCropParams() {
            // 默认的剪切设置
            CropParams cropParams = new CropParams();
            return cropParams;
        }

        // 上下文
        @Override
        public Activity getContext() {
            return GSZLActivity.this;
        }
    };

    // 处理图片剪切的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CropHelper.handleResult(mCropHandler,requestCode,resultCode,data);
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void updatePhoto(String photoUrl) {

    }
}
