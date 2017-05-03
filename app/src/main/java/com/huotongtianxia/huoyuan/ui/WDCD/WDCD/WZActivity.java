package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WZBean;
import com.huotongtianxia.huoyuan.util.AMapUtil;
import com.huotongtianxia.huoyuan.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WZActivity extends AppCompatActivity implements WZContract.View
        , GeocodeSearch.OnGeocodeSearchListener, View.OnClickListener, AMap.OnMarkerClickListener {

    @Bind(R.id.wz_img01)
    ImageView wzImg01;
    @Bind(R.id.wz_text01)
    TextView wzText01;
    @Bind(R.id.wz_text1)
    TextView wzText1;
    @Bind(R.id.wz_mapview)
    MapView wzMapview;
    DPoint examplePoint = null;
    @Bind(R.id.wz_list)
    ListView wzList;
    private WZAdapter adapter;
    private GeocodeSearch geocoderSearch;
    private DPoint destPoint;
    private AMap aMap;
    LatLonPoint latLonPoint = null;
    private Marker regeoMarker;
    private ExecutorService mExecutorService;
    private ProgressDialog progDialog = null;
    private int driver_id;
    private String item;
    private String item1;
    private double w;
    private double j;
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private String dz;
    private int b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_wz
                );
        ButterKnife.bind(this);
        Bundle bundle = this.getIntent().getExtras();
        driver_id = bundle.getInt("driver_id");
        WZPresreter presreter = new WZPresreter(this, driver_id);
        presreter.getData();
        wzMapview.onCreate(savedInstanceState);// 此方法必须重写
        init();
        adapter = new WZAdapter(WZActivity.this,list1);
        wzList.setAdapter(adapter);
    }

    @OnClick({R.id.wz_img01, R.id.wz_text01})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wz_img01:
                WZActivity.this.finish();
                break;
            case R.id.wz_text01:
                WZActivity.this.finish();
                break;
        }
    }

    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = wzMapview.getMap();
            regeoMarker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
                    .icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            aMap.setOnMarkerClickListener(this);
        }
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
        progDialog = new ProgressDialog(this);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        wzMapview.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        wzMapview.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        wzMapview.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        wzMapview.onDestroy();
        if (mExecutorService != null) {
            mExecutorService.shutdownNow();
        }
    }

    //坐标转换
    private void convert() {
        try {
            //初始化坐标转换类
            CoordinateConverter converter = new CoordinateConverter(
                    WZActivity.this);
            /**
             * 设置坐标来源,这里使用百度坐标作为示例
             * 可选的来源包括：
             * <li>CoordType.BAIDU ： 百度坐标
             * <li>CoordType.MAPBAR ： 图吧坐标
             * <li>CoordType.MAPABC ： 图盟坐标
             * <li>CoordType.SOSOMAP ： 搜搜坐标
             * <li>CoordType.ALIYUN ： 阿里云坐标
             * <li>CoordType.GOOGLE ： 谷歌坐标
             * <li>CoordType.GPS ： GPS坐标
             */
            converter.from(CoordinateConverter.CoordType.BAIDU);
            //设置需要转换的坐标
            converter.coord(examplePoint);
            //转换成高德坐标
            destPoint = converter.convert();
            if (null != destPoint) {
                //tvConvertReult.setText("转换后坐标(经度、纬度):" + destPoint.getLongitude() + "," + destPoint.getLatitude());
                j = destPoint.getLongitude();
                w = destPoint.getLatitude();
            } else {
                Toast.makeText(WZActivity.this, "坐标转换失败", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(WZActivity.this, "坐标转换失败", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onRegeocodeSearched(RegeocodeResult result, int rCode) {
        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getRegeocodeAddress() != null
                    && result.getRegeocodeAddress().getFormatAddress() != null) {
                wzText1.setText(item1 + result.getRegeocodeAddress().getCity());
                aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        AMapUtil.convertToLatLng(latLonPoint), 15));
                regeoMarker.setPosition(AMapUtil.convertToLatLng(latLonPoint));
                dz=list2.get(b)+"\n"+result.getRegeocodeAddress().getFormatAddress();
                b++;
                list1.add(dz);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
            } else {
                ToastUtil.show(WZActivity.this, R.string.no_result);
            }
        } else {
            ToastUtil.showerror(WZActivity.this, rCode);
        }
    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return false;
    }

    @Override
    public void onResponse(WZBean wzBean) {
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
        item1 = wzBean.getData().get(0).getUpdate_time();
        for (int i = 0; i < wzBean.getData().size(); i++) {
            item = wzBean.getData().get(i).getUpdate_time();
            list2.add(item);
            w = Double.parseDouble(wzBean.getData().get(i).getLat());
            j = Double.parseDouble(wzBean.getData().get(i).getLng());
            //构造一个示例坐标，第一个参数是纬度，第二个参数是经度
            examplePoint = new DPoint(w, j);
            convert();
            latLonPoint = new LatLonPoint(destPoint.getLatitude(), destPoint.getLongitude());
//          第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
            RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 200, GeocodeSearch.AMAP);
            geocoderSearch.getFromLocationAsyn(query);
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
