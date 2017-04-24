package com.huotongtianxia.huoyuan;

import android.Manifest;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.huotongtianxia.huoyuan.config.UrlConfig;
import com.huotongtianxia.huoyuan.ui.WDCD.GRZX.GRZXFragment;
import com.huotongtianxia.huoyuan.ui.WDCD.WDCD.MainFragment;
import com.huotongtianxia.huoyuan.ui.WDCD.WDCD.WDCDFragment;
import com.huotongtianxia.huoyuan.ui.WDCD.bx.BXFragment;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AMapLocationListener {
    @Bind(R.id.main_framelayout)
    FrameLayout mainFramelayout;
    @Bind(R.id.main_home)
    ImageView mainHome;
    @Bind(R.id.main_home_text)
    TextView mainHomeText;
    @Bind(R.id.main_home_lin)
    LinearLayout mainHomeLin;
    @Bind(R.id.main_adcice)
    ImageView mainAdcice;
    @Bind(R.id.main_adcice_text)
    TextView mainAdciceText;
    @Bind(R.id.main_advice_lin)
    LinearLayout mainAdviceLin;
    @Bind(R.id.main_my)
    ImageView mainMy;
    @Bind(R.id.main_my_text)
    TextView mainMyText;
    @Bind(R.id.main_my_lin)
    LinearLayout mainMyLin;
    @Bind(R.id.main_linear)
    LinearLayout mainLinear;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    public static WDCDFragment wdcdFragment;
    public static FragmentManager manager;
    public static MainFragment hyfbFragment;
    public static GRZXFragment grzxFragment;
    private long time;
    private Context mContext;
    public static BXFragment bxFragment;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    private AMapLocationClient mlocationClient = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        InitView();
        if (AndPermission.hasPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CHANGE_WIFI_STATE,Manifest.permission.CHANGE_CONFIGURATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.READ_PHONE_STATE,Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.INTERNET)){

        }else {
            AndPermission.with(this)
                    .requestCode(101)
                    .permission(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CHANGE_WIFI_STATE,Manifest.permission.CHANGE_CONFIGURATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.READ_PHONE_STATE,Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.INTERNET)
                    .send();
        }
        // 权限申请失败回调。
        mlocationClient = new AMapLocationClient(MainActivity.this);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置返回地址信息，默认为true
        mLocationOption.setNeedAddress(true);
        //设置定位监听
        mlocationClient.setLocationListener(MainActivity.this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient.startLocation();
    }
    private void InitView() {
        manager = getSupportFragmentManager();
        Switchfragment(0);
    }

    //切换碎片的方法,根据索引对碎片进行切换
    public static void Switchfragment(int index) {
        //创建碎片管理器
        FragmentTransaction transaction = manager.beginTransaction();
        AddTransaction(transaction);
        //根据id对碎片进行切换 ,如果碎片开始为空 进行创建
        switch (index) {
            case 0:
                if (hyfbFragment == null) {
                    hyfbFragment = new MainFragment();
                    transaction.add(R.id.main_framelayout, hyfbFragment);
                } else {
                    transaction.show(hyfbFragment);
                }
                break;
            case 1:
            if (wdcdFragment == null) {
                wdcdFragment = new WDCDFragment();
                transaction.add(R.id.main_framelayout, wdcdFragment);
            } else {
                transaction.show(wdcdFragment);
            }
            break;
            case 2:
                if (grzxFragment == null) {
                    grzxFragment = new GRZXFragment();
                    transaction.add(R.id.main_framelayout, grzxFragment);
                } else {
                    transaction.show(grzxFragment);
                }
                break;
            case 3:
                if (bxFragment == null) {
                    bxFragment = new BXFragment();
                    transaction.add(R.id.main_framelayout, bxFragment);
                } else {
                    transaction.show(bxFragment);
                }
                break;
        }
        transaction.commit();
    }

    public static void AddTransaction(FragmentTransaction transaction) {
        if (hyfbFragment != null) {
            if (hyfbFragment.isVisible()) {
                transaction.hide(hyfbFragment);
            }
        }
        if (wdcdFragment != null) {
            transaction.hide(wdcdFragment);
        }
        if (grzxFragment != null) {
            transaction.hide(grzxFragment);
        }
        if (bxFragment != null) {
            transaction.hide(bxFragment);
        }
    }

    @OnClick({R.id.main_home, R.id.main_home_text, R.id.main_home_lin, R.id.main_adcice, R.id.main_adcice_text, R.id.main_advice_lin, R.id.main_my, R.id.main_my_text, R.id.main_my_lin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                mainHome.setImageResource(R.mipmap.sy5);
                mainAdcice.setImageResource(R.mipmap.sy1);
                mainMy.setImageResource(R.mipmap.sy3);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.zi));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(0);
                break;
            case R.id.main_home_text:
                mainHome.setImageResource(R.mipmap.sy5);
                mainAdcice.setImageResource(R.mipmap.sy1);
                mainMy.setImageResource(R.mipmap.sy3);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.zi));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(0);
                break;
            case R.id.main_home_lin:
                mainHome.setImageResource(R.mipmap.sy5);
                mainAdcice.setImageResource(R.mipmap.sy1);
                mainMy.setImageResource(R.mipmap.sy3);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.zi));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(0);
                break;
            case R.id.main_adcice:
                mainHome.setImageResource(R.mipmap.sy2);
                mainAdcice.setImageResource(R.mipmap.sy4);
                mainMy.setImageResource(R.mipmap.sy3);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.zi));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(3);
                break;
            case R.id.main_adcice_text:
                mainHome.setImageResource(R.mipmap.sy2);
                mainAdcice.setImageResource(R.mipmap.sy4);
                mainMy.setImageResource(R.mipmap.sy3);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.zi));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(3);
                break;
            case R.id.main_advice_lin:
                mainHome.setImageResource(R.mipmap.sy2);
                mainAdcice.setImageResource(R.mipmap.sy4);
                mainMy.setImageResource(R.mipmap.sy3);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.zi));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(3);
                break;
            case R.id.main_my:
                Switchfragment(2);
                mainHome.setImageResource(R.mipmap.sy2);
                mainAdcice.setImageResource(R.mipmap.sy1);
                mainMy.setImageResource(R.mipmap.sy6);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.zi));
                break;
            case R.id.main_my_text:
                mainHome.setImageResource(R.mipmap.sy2);
                mainAdcice.setImageResource(R.mipmap.sy1);
                mainMy.setImageResource(R.mipmap.sy6);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.zi));
                Switchfragment(2);
                break;
            case R.id.main_my_lin:
                mainHome.setImageResource(R.mipmap.sy2);
                mainAdcice.setImageResource(R.mipmap.sy1);
                mainMy.setImageResource(R.mipmap.sy6);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.zi));
                Switchfragment(2);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            long time2 = System.currentTimeMillis();
            if (time2 - time > 3000) {
                Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            } else {
//                finish();
                System.exit(0);
                Runtime.getRuntime().gc();
            }
        }
        return true;
    }

    //黄油刀解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                amapLocation.getLatitude();//获取纬度
                amapLocation.getLongitude();//获取经度
                amapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amapLocation.getTime());
                df.format(date);//定位时间
                amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，ssssGPS定位不返回地址信息。
                amapLocation.getCountry();//国家信息
                amapLocation.getProvince();//省信息
                amapLocation.getCity();//城市信息
                amapLocation.getDistrict();//城区信息
                amapLocation.getStreet();//街道信息
                amapLocation.getStreetNum();//街道门牌号信息
                amapLocation.getCityCode();//城市编码
                amapLocation.getAdCode();//地区编码
                UrlConfig.city = amapLocation.getCity();
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError","location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        AndPermission.onRequestPermissionsResult(requestCode, permissions, grantResults, listener);
    }

    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            // 权限申请成功回调。
            if(requestCode == 100) {
                mlocationClient = new AMapLocationClient(MainActivity.this);
                //初始化定位参数
                mLocationOption = new AMapLocationClientOption();
                //设置返回地址信息，默认为true
                mLocationOption.setNeedAddress(true);
                //设置定位监听
                mlocationClient.setLocationListener(MainActivity.this);
                //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
                mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                //设置定位间隔,单位毫秒,默认为2000ms
                mLocationOption.setInterval(2000);
                //设置定位参数
                mlocationClient.setLocationOption(mLocationOption);
                // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
                // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
                // 在定位结束后，在合适的生命周期调用onDestroy()方法
                // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
                //启动定位
                mlocationClient.startLocation();
            } else if(requestCode == 101) {
                mlocationClient = new AMapLocationClient(MainActivity.this);
                //初始化定位参数
                mLocationOption = new AMapLocationClientOption();
                //设置返回地址信息，默认为true
                mLocationOption.setNeedAddress(true);
                //设置定位监听
                mlocationClient.setLocationListener(MainActivity.this);
                //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
                mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                //设置定位间隔,单位毫秒,默认为2000ms
                mLocationOption.setInterval(2000);
                //设置定位参数
                mlocationClient.setLocationOption(mLocationOption);
                // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
                // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
                // 在定位结束后，在合适的生命周期调用onDestroy()方法
                // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
                //启动定位
                mlocationClient.startLocation();
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // 权限申请失败回调。
            mlocationClient = new AMapLocationClient(MainActivity.this);
            //初始化定位参数
            mLocationOption = new AMapLocationClientOption();
            //设置返回地址信息，默认为true
            mLocationOption.setNeedAddress(true);
            //设置定位监听
            mlocationClient.setLocationListener(MainActivity.this);
            //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位间隔,单位毫秒,默认为2000ms
            mLocationOption.setInterval(2000);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            //启动定位
            mlocationClient.startLocation();
            // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
//            if (AndPermission.hasAlwaysDeniedPermission(ZXCCActivity.this, deniedPermissions)) {
//                // 用默认的提示语。
//                AndPermission.defaultSettingDialog(ZXCCActivity.this, REQUEST_CODE_SETTING).show();
//
//            }
        }
    };
}
