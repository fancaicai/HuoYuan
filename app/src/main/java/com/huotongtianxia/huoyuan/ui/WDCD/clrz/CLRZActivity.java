package com.huotongtianxia.huoyuan.ui.WDCD.clrz;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.CLRZBean;
import com.huotongtianxia.huoyuan.bean.SJRZ1Bean;
import com.huotongtianxia.huoyuan.ui.WDCD.zxcc.ZXCCActivity;
import com.huotongtianxia.huoyuan.widget.LoadingDialog;
import com.huotongtianxia.huoyuan.widget.SelectPicturePopup;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
//车辆认证的Activity
public class CLRZActivity extends AppCompatActivity implements CLRZContract.View{
    @Bind(R.id.clrz_img1)
    ImageView clrzImg1;
    @Bind(R.id.clrz_img2)
    ImageView clrzImg2;
    @Bind(R.id.clrz_lin1)
    LinearLayout clrzLin1;
    @Bind(R.id.clrz_img3)
    ImageView clrzImg3;
    @Bind(R.id.clrz_img4)
    ImageView clrzImg4;
    @Bind(R.id.clrz_lin2)
    LinearLayout clrzLin2;
    @Bind(R.id.button)
    Button button;
    private static final int REQUEST_CODE_SETTING = 300;
    public static final int REQUEST_CODE_PICTURE = 1;
    public static final int REQUEST_CODE_CAMERA = 2;
    public static final int aa = 3;
    public static final int REQUEST_CODE_PICTURE2 = 21;
    public static final int REQUEST_CODE_CAMERA2 = 22;
    public static final int bb = 23;
    public static final int REQUEST_CODE_PICTURE3 = 31;
    public static final int REQUEST_CODE_CAMERA3 = 32;
    public static final int cc = 33;
    public static final int REQUEST_CODE_PICTURE4 = 41;
    public static final int REQUEST_CODE_CAMERA4 = 42;
    public static final int dd = 44;
    private String picturePath;
    private String picturePath2;
    private String picturePath3;
    private String picturePath4;
    private Uri imageUri;
    private Uri imageUri2;
    private Uri imageUri3;
    private Uri imageUri4;
    private LoadingDialog loadingDialog;
    private File w1,w2,w3,w4;
    private String truck_type, truck_length, truck_cp, namee, tell, cph, cz ,cit,provinc2,cit2,id;

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
        setContentView(R.layout.activity_clrz);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        Bundle bundle = this.getIntent().getExtras();
        id = bundle.getString("id");
    }

    @OnClick({R.id.clrz_img1, R.id.clrz_img2, R.id.clrz_img3, R.id.clrz_img4, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clrz_img1:
                if (AndPermission.hasPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE)){

                }else {
                    AndPermission.with(this)
                            .requestCode(101)
                            .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE)
                            .send();
                }
                final SelectPicturePopup spp = new SelectPicturePopup(CLRZActivity.this);
                spp.showPopup(clrzLin1);
                spp.setOnClickFlagDialogListener(new SelectPicturePopup.OnClickFlagDialogListener() {
                    @Override
                    public void getFlag(int flag) {
                        if (flag == 1) {
                            spp.dismiss();
                            Intent intent;
                            if (Build.VERSION.SDK_INT < 19) {
                                intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                            } else {
                                intent = new Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            }
                            startActivityForResult(intent, REQUEST_CODE_PICTURE);
                        } else if (flag == 0) {
                            spp.dismiss();
                            File out = new File(Environment.getExternalStorageDirectory(),"otu.jpg");
                            try {
                                if (out.exists()){
                                    out.delete();
                                }
                                out.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            imageUri = Uri.fromFile(out);
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                            startActivityForResult(intent,REQUEST_CODE_CAMERA);//启动相机程序
                        }
                    }
                });
                break;
            case R.id.clrz_img2:
                final SelectPicturePopup spp2 = new SelectPicturePopup(CLRZActivity.this);
                spp2.showPopup(clrzLin1);
                spp2.setOnClickFlagDialogListener(new SelectPicturePopup.OnClickFlagDialogListener() {
                    @Override
                    public void getFlag(int flag) {
                        if (flag == 1) {
                            spp2.dismiss();
                            Intent intent;
                            if (Build.VERSION.SDK_INT < 19) {
                                intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                            } else {
                                intent = new Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            }
                            startActivityForResult(intent, REQUEST_CODE_PICTURE2);
                        } else if (flag == 0) {
                            spp2.dismiss();
                            File out = new File(Environment.getExternalStorageDirectory(),"otu2.jpg");
                            try {
                                if (out.exists()){
                                    out.delete();
                                }
                                out.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            imageUri2 = Uri.fromFile(out);
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri2);
                            startActivityForResult(intent,REQUEST_CODE_CAMERA2);//启动相机程序
                        }
                    }
                });
                break;
            case R.id.clrz_img3:
                final SelectPicturePopup spp3 = new SelectPicturePopup(CLRZActivity.this);
                spp3.showPopup(clrzLin2);
                spp3.setOnClickFlagDialogListener(new SelectPicturePopup.OnClickFlagDialogListener() {
                    @Override
                    public void getFlag(int flag) {
                        if (flag == 1) {
                            spp3.dismiss();
                            Intent intent;
                            if (Build.VERSION.SDK_INT < 19) {
                                intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                            } else {
                                intent = new Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            }
                            startActivityForResult(intent, REQUEST_CODE_PICTURE3);
                        } else if (flag == 0) {
                            spp3.dismiss();
                            File out = new File(Environment.getExternalStorageDirectory(),"otu3.jpg");
                            try {
                                if (out.exists()){
                                    out.delete();
                                }
                                out.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            imageUri3 = Uri.fromFile(out);
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri3);
                            startActivityForResult(intent,REQUEST_CODE_CAMERA3);//启动相机程序
                        }
                    }
                });
                break;
            case R.id.clrz_img4:
                final SelectPicturePopup spp4 = new SelectPicturePopup(CLRZActivity.this);
                spp4.showPopup(clrzLin2);
                spp4.setOnClickFlagDialogListener(new SelectPicturePopup.OnClickFlagDialogListener() {
                    @Override
                    public void getFlag(int flag) {
                        if (flag == 1) {
                            spp4.dismiss();
                            Intent intent;
                            if (Build.VERSION.SDK_INT < 19) {
                                intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                            } else {
                                intent = new Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            }
                            startActivityForResult(intent, REQUEST_CODE_PICTURE4);
                        } else if (flag == 0) {
                            spp4.dismiss();
                            File out = new File(Environment.getExternalStorageDirectory(),"otu4.jpg");
                            try {
                                if (out.exists()){
                                    out.delete();
                                }
                                out.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            imageUri4 = Uri.fromFile(out);
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri4);
                            startActivityForResult(intent,REQUEST_CODE_CAMERA4);//启动相机程序
                        }
                    }
                });
                break;
            case R.id.button:
                login();
                break;
        }
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            loadingDialog.show();
            w2 = new File(picturePath2);
            w3 = new File(picturePath3);
            w4 = new File(picturePath4);
            w1 = new File(picturePath);
        }
        CLRZPresreter presreter = new CLRZPresreter(this, w1, w2, w3, w4, truck_type, truck_length, truck_cp, namee, tell, cph, cz, cit,provinc2,cit2,id);
        presreter.getData();
    }

    public boolean isUserNameAndPwdValid() {
        if (picturePath == null) {
            Toast.makeText(CLRZActivity.this, "请上传身份证正面",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (picturePath2 == null) {
            Toast.makeText(CLRZActivity.this, "请上传身份证反面",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (picturePath3 == null) {
            Toast.makeText(CLRZActivity.this, "请上传驾驶证正面",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (picturePath4 == null) {
            Toast.makeText(CLRZActivity.this,"请上传驾驶证反面",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE_CAMERA:
                if (resultCode == RESULT_OK){
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri , "image/*");
                    intent.putExtra("scale",true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                    startActivityForResult(intent,aa);//启动裁剪程序
                }
                break;
            case aa:
                if (resultCode  == RESULT_OK){
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        clrzImg1.setImageBitmap(bitmap);
                        picturePath = imageUri.getPath();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
        if (requestCode == REQUEST_CODE_PICTURE) {
                if (data != null) {
                    Uri selectedImage = data.getData();
                    if (selectedImage != null) {
                        sendPicByUri(selectedImage);
                    }
                }
            }

        switch (requestCode){
            case REQUEST_CODE_CAMERA2:
                if (resultCode == RESULT_OK){
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri2 , "image/*");
                    intent.putExtra("scale",true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri2);
                    startActivityForResult(intent,bb);//启动裁剪程序
                }
                break;
            case bb:
                if (resultCode  == RESULT_OK){
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri2));
                        clrzImg2.setImageBitmap(bitmap);
                        picturePath2 = imageUri2.getPath();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
        if (requestCode == REQUEST_CODE_PICTURE3) {
                if (data != null) {
                    Uri selectedImage3 = data.getData();
                    if (selectedImage3 != null) {
                        sendPicByUri3(selectedImage3);
                    }
                }
            }

        switch (requestCode){
            case REQUEST_CODE_CAMERA3:
                if (resultCode == RESULT_OK){
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri3 , "image/*");
                    intent.putExtra("scale",true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri3);
                    startActivityForResult(intent,cc);//启动裁剪程序
                }
                break;
            case cc:
                if (resultCode  == RESULT_OK){
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri3));
                        clrzImg3.setImageBitmap(bitmap);
                        picturePath3 = imageUri3.getPath();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        } if (requestCode == REQUEST_CODE_PICTURE2) {
                if (data != null) {
                    Uri selectedImage2 = data.getData();
                    if (selectedImage2 != null) {
                        sendPicByUri2(selectedImage2);
                    }
                }
            }

        switch (requestCode) {
            case REQUEST_CODE_CAMERA4:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri4, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri4);
                    startActivityForResult(intent, dd);//启动裁剪程序
                }
                break;
            case dd:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri4));
                        clrzImg4.setImageBitmap(bitmap);
                        picturePath4 = imageUri4.getPath();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
            if (requestCode == REQUEST_CODE_PICTURE4) {
                if (data != null) {
                    Uri selectedImage4 = data.getData();
                    if (selectedImage4 != null) {
                        sendPicByUri4(selectedImage4);
                    }
                }
            }


    }

    private void setPic(String path) {
        Glide.with(this).load(new File(path)).into(clrzImg1);
    }

    private void setPic2(String path) {
        Glide.with(this).load(new File(path)).skipMemoryCache(true).into(clrzImg2);
    }

    private void setPic3(String path) {
        Glide.with(this).load(new File(path)).into(clrzImg3);
    }

    private void setPic4(String path) {
        Glide.with(this).load(new File(path)).into(clrzImg4);
    }

    /**
     * 根据图库图片uri发送图片
     *
     * @param selectedImage
     */
    private void sendPicByUri(Uri selectedImage) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = this.getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        String st8 = "未能找到任何图片";
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            cursor = null;
            if (picturePath == null || picturePath.equals("null")) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic(picturePath);
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic(file.getAbsolutePath());
        }
    }

    private void sendPicByUri2(Uri selectedImage) {
        String[] filePathColumn2 = {MediaStore.Images.Media.DATA};
        Cursor cursor2 = this.getContentResolver().query(selectedImage,
                filePathColumn2, null, null, null);
        String st8 = "未能找到任何图片";
        if (cursor2 != null) {
            cursor2.moveToFirst();
            int columnIndex = cursor2.getColumnIndex(filePathColumn2[0]);
            picturePath2 = cursor2.getString(columnIndex);
            cursor2.close();
            cursor2 = null;
            if (picturePath2 == null || picturePath2.equals("null")) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic2(picturePath2);
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic2(file.getAbsolutePath());
        }
    }

    private void sendPicByUri3(Uri selectedImage) {
        String[] filePathColumn3 = {MediaStore.Images.Media.DATA};
        Cursor cursor3 = this.getContentResolver().query(selectedImage,
                filePathColumn3, null, null, null);
        String st8 = "未能找到任何图片";
        if (cursor3 != null) {
            cursor3.moveToFirst();
            int columnIndex = cursor3.getColumnIndex(filePathColumn3[0]);
            picturePath3 = cursor3.getString(columnIndex);
            cursor3.close();
            cursor3 = null;
            if (picturePath3 == null || picturePath3.equals("null")) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic3(picturePath3);
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic3(file.getAbsolutePath());
        }
    }

    private void sendPicByUri4(Uri selectedImage) {
        String[] filePathColumn4 = {MediaStore.Images.Media.DATA};
        Cursor cursor4 = this.getContentResolver().query(selectedImage,
                filePathColumn4, null, null, null);
        String st8 = "未能找到任何图片";
        if (cursor4 != null) {
            cursor4.moveToFirst();
            int columnIndex = cursor4.getColumnIndex(filePathColumn4[0]);
            picturePath4 = cursor4.getString(columnIndex);
            cursor4.close();
            cursor4 = null;
            if (picturePath4 == null || picturePath4.equals("null")) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic4(picturePath4);
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic4(file.getAbsolutePath());
        }
    }

    @Override
    public void onResponse(CLRZBean clrzBean) {
        int count = clrzBean.getCode();
        if (count == 100){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "上传成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ZXCCActivity.class);
            CLRZActivity.this.finish();
            startActivity(intent);
        }else if (count == 200){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "上传失败", Toast.LENGTH_SHORT).show();
        }else if(count == 201){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "司机已存在", Toast.LENGTH_SHORT).show();
        }else if (count == 101){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "用户已存在", Toast.LENGTH_SHORT).show();
        }else if (count == 102){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "更新成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse1(SJRZ1Bean clrzBean) {

    }

    @Override
    public void onFailure(String s) {

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
                // TODO 相应代码。
            } else if(requestCode == 101) {
                // TODO 相应代码。
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // 权限申请失败回调。

            // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
            if (AndPermission.hasAlwaysDeniedPermission(CLRZActivity.this, deniedPermissions)) {
                // 用默认的提示语。
                AndPermission.defaultSettingDialog(CLRZActivity.this, REQUEST_CODE_SETTING).show();

            }
        }
    };

}
