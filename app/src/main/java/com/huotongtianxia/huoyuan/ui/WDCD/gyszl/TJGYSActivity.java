package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

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
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.MyApplication;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.TJGYSBean;
import com.huotongtianxia.huoyuan.util.Check;
import com.huotongtianxia.huoyuan.widget.ChangeAddressPopwindow;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

//常用地址页面
public class TJGYSActivity extends AppCompatActivity implements TJGYSContract.View {

    @Bind(R.id.text)
    TextView text;
//    @Bind(R.id.choose_iv)
//    ImageView chooseIv;
    @Bind(R.id.inputAdress_txt)
    EditText inputAdressTxt;
    @Bind(R.id.activity_tjgys)
    LinearLayout activityTjgys;
    @Bind(R.id.tjgys_txt_contacts)
    TextView tjgysTxtContacts;
    @Bind(R.id.tjgys_edt_name)
    EditText tjgysEdtName;
    @Bind(R.id.tjgys_edt_phone)
    EditText tjgysEdtPhone;
    @Bind(R.id.tjgys_txt_address)
    TextView tjgysTxtAddress;
    private String tjgyszl1, tjgyszl2, tjgyszl3, tjgyszl4;

    @OnClick(R.id.back_text)
    void back() {
        finish();
    }

    /**
     * 添加联系人
     */
    @OnClick(R.id.tjgys_txt_contacts)
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

    /**
     * 设置地址
     */
    @OnClick(R.id.tjgys_txt_address)
    void address() {
        ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(this);
        mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
        mChangeAddressPopwindow.showAtLocation(tjgysTxtAddress, Gravity.CENTER, 0, 0);
        mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
            @Override
            public void onClick(String province, String city, String area) {
                Toast.makeText(TJGYSActivity.this,
                        province + "-" + city + "-" + area,
                        Toast.LENGTH_LONG).show();
                //yun_end = province + "-" + city + "-" + area;
                tjgysTxtAddress.setText(province +" " +city +" " +area);
            }
        });
    }

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
        setContentView(R.layout.activity_tjgys);
        ButterKnife.bind(this);
    }

    /**
     * 自定义字体
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
//    @OnClick({R.id.tjgrs_img01, R.id.tjgrs_text01, R.id.jtgys_btn})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.tjgrs_img01:
//                TJGYSActivity.this.finish();
//                break;
//            case R.id.tjgrs_text01:
//                TJGYSActivity.this.finish();
//                break;
//            case R.id.jtgys_btn:
//                login();
//                TJGYSPresreter presreter = new TJGYSPresreter(this,tjgyszl1,tjgyszl2,tjgyszl3,tjgyszl4);
//                presreter.getData();
//                break;
//        }
//    }
//
//    public void login() {                                              //登录按钮监听事件
//        if (isUserNameAndPwdValid()) {
//            tjgyszl1 = tjgysEt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
//            tjgyszl2 = tjgysEt2.getText().toString().trim();
//            tjgyszl3 = tjgysEt3.getText().toString().trim();
//            tjgyszl4 = tjgysEt4.getText().toString().trim();
//        }
//    }
//
//    public boolean isUserNameAndPwdValid() {
//        if (tjgysEt1.getText().toString().trim().equals("")) {
//            Toast.makeText(this, getString(R.string.tjgys1),
//                    Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (tjgysEt2.getText().toString().trim().equals("")) {
//            Toast.makeText(this, getString(R.string.tjgys2),
//                    Toast.LENGTH_SHORT).show();
//            return false;
//        }else if (tjgysEt3.getText().toString().trim().equals("")) {
//            Toast.makeText(this, getString(R.string.tjgys3),
//                    Toast.LENGTH_SHORT).show();
//            return false;
//        }else if (tjgysEt4.getText().toString().trim().equals("")) {
//            Toast.makeText(this, getString(R.string.tjgys4),
//                    Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }

    @Override
    public void onResponse(TJGYSBean tjgysBean) {
        int count = tjgysBean.hashCode();
        if (count == 202) {
            Toast.makeText(this, "物流公司已存在", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(TJGYSActivity.this, GYSZLActivity.class);
        TJGYSActivity.this.finish();
        startActivity(intent);
    }

    @Override
    public void onFailure(String s) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == MyApplication.CONTACT) {
            Uri contactData = data.getData();
            Cursor cursor = getContentResolver().query(contactData, null, null, null,
                    null);
            cursor.moveToFirst();
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
                Toast.makeText(TJGYSActivity.this, "获取联系人的权限申请失败", Toast.LENGTH_SHORT).show();
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
            tjgysEdtName.setText(name);
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
                            tjgysEdtPhone.setText(phoneNumber);
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
