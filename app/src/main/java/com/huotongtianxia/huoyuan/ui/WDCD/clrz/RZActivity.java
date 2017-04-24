package com.huotongtianxia.huoyuan.ui.WDCD.clrz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.CLRZBean;
import com.huotongtianxia.huoyuan.bean.SJRZ1Bean;
import com.huotongtianxia.huoyuan.widget.LoadingDialog;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RZActivity extends AppCompatActivity implements CLRZContract.View {
    @Bind(R.id.sfrz_img01)
    ImageView sfrzImg01;
    @Bind(R.id.sfrz_text01)
    TextView sfrzText01;
    @Bind(R.id.clrz_edit)
    EditText clrzEdit;
    @Bind(R.id.clrz_edit2)
    EditText clrzEdit2;
    @Bind(R.id.sfrz_spinner1)
    Spinner sfrzSpinner1;
    @Bind(R.id.clrz_edit3)
    EditText clrzEdit3;
    @Bind(R.id.clrz_edit4)
    EditText clrzEdit4;
    @Bind(R.id.sfrz_spinner2)
    Spinner sfrzSpinner2;
    @Bind(R.id.sfrz_spinner3)
    Spinner sfrzSpinner3;
    @Bind(R.id.sfrz_spinner6)
    Spinner sfrzSpinner6;
    @Bind(R.id.sjrz1_button)
    Button sjrz1Button;
    @Bind(R.id.sfrz_spinner7)
    Spinner sfrzSpinner7;
    @Bind(R.id.sfrz_spinner8)
    Spinner sfrzSpinner8;
    @Bind(R.id.sfrz_spinner5)
    Spinner sfrzSpinner5;
    private LoadingDialog loadingDialog;
    private String truck_type, truck_length, truck_cp, namee, tell, cph, cz,id;
    private String provinc, cit,provinc2,cit2;
    private File w1, w2, w3, w4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rz);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        initView();
    }

    public void initView() {
        sfrzText01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RZActivity.this.finish();
            }
        });
        sfrzImg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RZActivity.this.finish();
            }
        });
        //添加一个下拉列表项的数组，这里存的项就是下拉列表的菜单项
        String[] spiner = getResources().getStringArray(R.array.buy_cars);
        String[] spinersort = getResources().getStringArray(R.array.buy_cars_sort);
        String[] spinercp = getResources().getStringArray(R.array.cp);
        //为下拉列表定义一个适配器，这里就用到里前面定义的list。
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(RZActivity.this, android.R.layout.simple_spinner_item, spiner);
        ArrayAdapter<String> sortAdapter = new ArrayAdapter(RZActivity.this, android.R.layout.simple_spinner_item, spinersort);
        ArrayAdapter<String> sortcpAdapter = new ArrayAdapter(RZActivity.this, android.R.layout.simple_spinner_item, spinercp);
        //为适配器设置下拉列表下拉时的菜单样式。
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortcpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将适配器添加到下拉列表上
        sfrzSpinner3.setAdapter(arrayAdapter);
        sfrzSpinner2.setAdapter(sortAdapter);
        sfrzSpinner1.setAdapter(sortcpAdapter);
        //为下拉列表设置各种事件的响应，这个事响应菜单被选中
        sfrzSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                truck_cp = sfrzSpinner1.getSelectedItem().toString();
                parent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                parent.setVisibility(View.VISIBLE);
            }
        });
        sfrzSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                truck_type = sfrzSpinner3.getSelectedItem().toString();
                parent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                parent.setVisibility(View.VISIBLE);
            }
        });
        sfrzSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                truck_length = sfrzSpinner2.getSelectedItem().toString();
                parent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                parent.setVisibility(View.VISIBLE);
            }
        });

        //省市联动
        ArrayAdapter adapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.province, R.layout.support_simple_spinner_dropdown_item);
        sfrzSpinner5.setAdapter(adapter);
        sfrzSpinner5.setOnItemSelectedListener(new spinnerItemSelected());
        sfrzSpinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cit = sfrzSpinner6.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //省市联动
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(RZActivity.this, R.array.province, R.layout.support_simple_spinner_dropdown_item);
        sfrzSpinner7.setAdapter(adapter2);
        sfrzSpinner7.setOnItemSelectedListener(new spinnerItemSelected2());
        sfrzSpinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cit2 = sfrzSpinner8.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            loadingDialog.show();
            namee = clrzEdit.getText().toString().trim();    //获取当前输入的用户名和密码信息
            tell = clrzEdit2.getText().toString().trim();
            cph = clrzEdit3.getText().toString().trim();
            cz = clrzEdit4.getText().toString().trim();
        }
        CLRZPresreter presreter = new CLRZPresreter(this, w1, w2, w3, w4, truck_type, truck_length, truck_cp, namee, tell, cph, cz, cit,provinc2,cit2,id);
        presreter.getData1();
    }

    public boolean isUserNameAndPwdValid() {
        if (clrzEdit.getText().toString().trim().equals("")) {
            Toast.makeText(RZActivity.this, getString(R.string.q9),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (clrzEdit2.getText().toString().trim().equals("")) {
            Toast.makeText(RZActivity.this, getString(R.string.q6),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (clrzEdit3.getText().toString().trim().equals("")) {
            Toast.makeText(RZActivity.this, getString(R.string.q10),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (clrzEdit4.getText().toString().trim().equals("")) {
            Toast.makeText(RZActivity.this, getString(R.string.hyfb_we),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (truck_length.toString().trim().equals("车长")) {
            Toast.makeText(RZActivity.this, "请选择车长", Toast.LENGTH_SHORT).show();
            return false;
        } else if (truck_type.toString().trim().equals("车型")) {
            Toast.makeText(RZActivity.this, "请选择车型", Toast.LENGTH_SHORT).show();
            return false;
        } else if (cit.toString().trim().equals("-城市-")) {
            Toast.makeText(RZActivity.this, "请选择车辆常驻地", Toast.LENGTH_SHORT).show();
            return false;
        } else if (cit2.toString().trim().equals("-城市-")) {
            Toast.makeText(RZActivity.this, "请选择优势路线", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(CLRZBean clrzBean) {

    }

    @Override
    public void onResponse1(SJRZ1Bean clrzBean) {
        int cointt = clrzBean.getCode();
        id = clrzBean.getData().getId();
        if (cointt == 100){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "司机不存在，请添加", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RZActivity.this, CLRZActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("id",id);
            intent.putExtras(bundle);
            RZActivity.this.finish();
            startActivity(intent);
        }else if (cointt == 200){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "提交失败，请再次提交", Toast.LENGTH_SHORT).show();
        }else if (cointt == 101){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "提交成功，数据没有更新", Toast.LENGTH_SHORT).show();
        }else if (cointt == 102){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "提交成功，数据以更新", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(String s) {

    }

    @OnClick(R.id.sjrz1_button)
    public void onClick() {
        login();
    }

    private class spinnerItemSelected implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Spinner spinner = (Spinner) parent;
            String pro = (String) spinner.getItemAtPosition(position);
            provinc = spinner.getSelectedItem().toString();
            ArrayAdapter cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.def, R.layout.support_simple_spinner_dropdown_item);
            if (pro.equals("北京")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.北京,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("天津")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.天津,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("河北")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.河北,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("山西")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.山西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("内蒙古")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.内蒙古,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("辽宁")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.辽宁,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("吉林")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.吉林,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("黑龙江")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.黑龙江,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("上海")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.上海,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("江苏")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.江苏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("浙江")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.浙江,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("安徽")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.安徽,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("福建")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.福建,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("江西")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.江西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("山东")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.山东,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("河南")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.河南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("湖北")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.湖北,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("湖南")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.湖南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("广东")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.广东,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("广西")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.广西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("海南")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.海南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("重庆")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.重庆,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("四川")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.四川,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("贵州")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.贵州,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("云南")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.云南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("西藏")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.西藏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("陕西")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.陕西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("甘肃")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.甘肃,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("青海")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.青海,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("宁夏")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.宁夏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("新疆")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.新疆,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("台湾")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.台湾,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("香港")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.香港,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("澳门")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.澳门,
                        R.layout.support_simple_spinner_dropdown_item);
            }
            sfrzSpinner6.setAdapter(cityadapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class spinnerItemSelected2 implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Spinner spinner = (Spinner) parent;
            String pro = (String) spinner.getItemAtPosition(position);
            provinc2 = spinner.getSelectedItem().toString();
            ArrayAdapter cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.def, R.layout.support_simple_spinner_dropdown_item);
            if (pro.equals("北京")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.北京,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("天津")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.天津,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("河北")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.河北,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("山西")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.山西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("内蒙古")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.内蒙古,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("辽宁")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.辽宁,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("吉林")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.吉林,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("黑龙江")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.黑龙江,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("上海")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.上海,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("江苏")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.江苏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("浙江")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.浙江,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("安徽")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.安徽,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("福建")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.福建,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("江西")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.江西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("山东")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.山东,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("河南")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.河南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("湖北")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.湖北,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("湖南")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.湖南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("广东")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.广东,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("广西")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.广西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("海南")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.海南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("重庆")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.重庆,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("四川")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.四川,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("贵州")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.贵州,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("云南")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.云南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("西藏")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.西藏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("陕西")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.陕西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("甘肃")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.甘肃,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("青海")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.青海,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("宁夏")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.宁夏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("新疆")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.新疆,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("台湾")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.台湾,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("香港")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.香港,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("澳门")) {
                cityadapter = ArrayAdapter.createFromResource(RZActivity.this, R.array.澳门,
                        R.layout.support_simple_spinner_dropdown_item);
            }
            sfrzSpinner8.setAdapter(cityadapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
