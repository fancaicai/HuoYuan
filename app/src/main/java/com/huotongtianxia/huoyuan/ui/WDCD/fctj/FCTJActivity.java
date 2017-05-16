package com.huotongtianxia.huoyuan.ui.WDCD.fctj;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.FCTJBean;
import com.huotongtianxia.huoyuan.ui.WDCD.datepicker.MonthDateView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FCTJActivity extends AppCompatActivity implements FCTJContract.View {
    @Bind(R.id.fctj_list)
    ListView fctjList;
    @Bind(R.id.back_tv)
    TextView backTv;
    private ImageView iv_left;
    private ImageView iv_right;
    private TextView tv_date;
    private TextView tv_week;
    private TextView tv_today;
    private MonthDateView monthDateView;
    public static String b1;
    private FCTJPresreter presreter = new FCTJPresreter(this);
    private List<FCTJBean.DataBean> titlelist = new ArrayList<>();
    private FCTJAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Integer> list = new ArrayList<Integer>();
//        list.add(10);
//        list.add(12);
//        list.add(15);
//        list.add(16);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
        setContentView(R.layout.activity_fctj);
        ButterKnife.bind(this);
        initView();

        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
        monthDateView = (MonthDateView) findViewById(R.id.monthDateView);
        tv_date = (TextView) findViewById(R.id.date_text);
        tv_week = (TextView) findViewById(R.id.week_text);
        tv_today = (TextView) findViewById(R.id.tv_today);
        monthDateView.setTextView(tv_date, tv_week);
        monthDateView.setDaysHasThingList(list);
        monthDateView.setmSelectBGColor(R.color.zi);
        adapter = new FCTJAdapter(this, titlelist);
        monthDateView.setDateClick(new MonthDateView.DateClick() {
            @Override
            public void onClickOnDate() {
                titlelist.clear();
                int b2 = monthDateView.getmSelMonth() + 1;
                b1 = monthDateView.getmSelYear() + "-" + b2 + "-" + monthDateView.getmSelDay();
                presreter.getData();
                fctjList.setAdapter(adapter);
                //Toast.makeText(getApplication(), "点击了：" + monthDateView.getmSelDay(), Toast.LENGTH_SHORT).show();
            }
        });
        setOnlistener();
    }


    /**
     * 自定义字体
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void initView() {
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setOnlistener() {
        iv_left.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                monthDateView.onLeftClick();
            }
        });

        iv_right.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                monthDateView.onRightClick();
            }
        });

        tv_today.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                monthDateView.setTodayToView();
            }
        });
    }

    @Override
    public void onResponse(FCTJBean fctjBean) {
        adapter.reload(fctjBean.getData());
    }

    @Override
    public void onFailure(String s) {

    }
}
