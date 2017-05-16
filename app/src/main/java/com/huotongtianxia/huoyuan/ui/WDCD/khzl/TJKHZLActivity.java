package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.MyApplication;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.TJKHZLBean;
import com.huotongtianxia.huoyuan.util.Check;
import com.huotongtianxia.huoyuan.widget.ChangeAddressPopwindow;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.huotongtianxia.huoyuan.R.id.inputName_et;

public class TJKHZLActivity extends AppCompatActivity implements TJKHZLContract.View{
@Bind(R.id.tjshdaaress_chooseare_rl)
    RelativeLayout tjshAddressCoRl;
    @Bind(R.id.back_text)
//            返回
    TextView backText;
    @Bind(R.id.save_btn)
//            保存
    TextView saveBtn;
    @Bind(inputName_et)
    //    输入姓名
    EditText inputNameEt;
    @Bind(R.id.inputTel_et)
//            请输入联系电话
    EditText inputTelEt;
    @Bind(R.id.inputaddress_tv)
    TextView inputaddressTv;
    @Bind(R.id.inputAdress_txt)
//            请输入详细收货地址
    EditText inputAdressTxt;

    public static String a1;
    public static String a2;
    public static String a3;
    public static String a5;
    public static String provinc,cit;
    /**
     * 添加联系人
     */
    @OnClick(R.id.tjsh_txt_contacts)
    void addContacts() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            //申请权限  第二个参数是一个 数组 说明可以同时申请多个权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        } else {//已授权
            Intent intent = new Intent(Intent.ACTION_PICK,
                    ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, MyApplication.CONTACT);
        }

    }
//    添加收货地址
    @OnClick(R.id.tjshdaaress_chooseare_rl)
    void addAddress(){
        ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(this);
        mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
        mChangeAddressPopwindow.showAtLocation(inputaddressTv, Gravity.BOTTOM, 0, 0);
        mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
            @Override
            public void onClick(String province, String city, String area) {
                Toast.makeText(TJKHZLActivity.this,
                        province + "-" + city + "-" + area,
                        Toast.LENGTH_LONG).show();
                //yun_end = province + "-" + city + "-" + area;
                inputaddressTv.setText(province +" " +city +" " +area);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
        setContentView(R.layout.activity_tjkhzl);
//        绑定视图
        ButterKnife.bind(this);
    }
//返回和保存的点击事件
    @OnClick({ R.id.back_text, R.id.save_btn})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.back_text:
                finish();
                break;
            case R.id.save_btn:
                login();
                TJKHZLPresreter presreter = new TJKHZLPresreter(this,a1,a2,a3,a5,provinc,cit);
                presreter.getData();
                break;
        }
    }

    public void login() {
        if (isUserNameAndPwdValid()) {
            a2 = inputNameEt.getText().toString().trim();
            a3 = inputTelEt.getText().toString().trim();
            a5 = inputAdressTxt.getText().toString().trim();
        }
    }
//判断输入是否为空
    public boolean isUserNameAndPwdValid() {
       if (inputNameEt.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.q5),
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (inputTelEt.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.q6),
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (inputTelEt.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.a5),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(TJKHZLBean tjkhzlBean) {

    }

    @Override
    public void onFailure(String s) {

    }

    /**
     * 自定义字体
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == MyApplication.CONTACT) {
            Uri contactData = data.getData();
            Cursor cursor = getContentResolver().query(contactData, null, null, null,
                    null);
            cursor.moveToFirst();
            // 读取所有的联系人
            getContactPhone(cursor);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, MyApplication.CONTACT);
            } else {
                Toast.makeText(TJKHZLActivity.this, "获取联系人的权限申请失败", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    // 读取所有的联系人
    private void getContactPhone(Cursor cursor) {
        int phoneColumn = cursor
                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
        int phoneNum = cursor.getInt(phoneColumn);
        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        //LogUtils.i("联系人姓名",name+Check.checkNotNull(name));
        if (Check.checkNotNull(name))
            inputNameEt.setText(name);
        String result = "";
        if (phoneNum > 0) {
            // 获得联系人的ID号
            int idColumn = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            String contactId = cursor.getString(idColumn);
            // 获得联系人电话的cursor
            Cursor phone = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "="
                            + contactId, null, null);
            if (phone.moveToFirst()) {
                for (; !phone.isAfterLast(); phone.moveToNext()) {
                    int index = phone
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    int typeindex = phone
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE);
                    int phone_type = phone.getInt(typeindex);
                    String phoneNumber = phone.getString(index);
                    switch (phone_type) {//此处请看下方注释
                        case 2:
                            inputTelEt.setText(phoneNumber);
                            break;
                        default:
                            break;
                    }
                }
                if (!phone.isClosed()) {
                    phone.close();
                }
            }
        }
    }
}
