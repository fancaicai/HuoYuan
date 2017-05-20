package com.huotongtianxia.huoyuan.common.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.huotongtianxia.huoyuan.R;


/**
 * 类描述:    [progressbar数据加载时使用]
 * 创建人:    Gjl
 * 创建时间:  2016/7/20 09:18
 * 修改人:
 * 修改时间:  2016/7/20 09:18
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class ProgressbarView {


    private View viewProgressbar;
    private Dialog dialogProgressbar;
    private Context context;

    public ProgressbarView(Context context) {


        this.context=context;
        init();
    }

    private void init(){

        /**
         * 图片选择器的创建与显示
         */
        viewProgressbar=  LayoutInflater.from(context).inflate(R.layout.layout_progressbar, null);
        dialogProgressbar = new AlertDialog.Builder(context,R.style.NobackDialog).create();
    }

    public void showDialog(){

        dialogProgressbar.show();
        dialogProgressbar.setContentView(viewProgressbar);


    }
    public void dismissDialog(){

        dialogProgressbar.dismiss();
    }

//    public void cancel(){
//
//        dialogProgressbar.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                dialogProgressbar.dismiss();
//            }
//        });
//    }
}
