package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.ZXCCWBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCWAdapter extends BaseAdapter {
    private List<ZXCCWBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public ZXCCWAdapter(Context context, List<ZXCCWBean.DataBean> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_zxcc_b, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.zxccBText1.setText(list.get(i).getLocality());
        holder.zxccBText2.setText(list.get(i).getTp_dirver_advantage());
        holder.zxccBText4.setText(list.get(i).getCreate_time());
        holder.zxccBText5.setText(list.get(i).getLength());
        holder.zxccBText6.setText(list.get(i).getWeight());
        holder.zxccBText7.setText(list.get(i).getType());
        holder.zxccBText8.setText(list.get(i).getName());
        holder.zxccBText10.setText(list.get(i).getPlate_number());
        holder.zxccBText11.setText(list.get(i).getTp_driver_accept());
        holder.zxccbddh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call("03512340094");
            }
        });
        return view;
    }

    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void reload(List _list) {
        list.addAll(_list);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @Bind(R.id.zxcc_b_text1)
        TextView zxccBText1;
        @Bind(R.id.zxcc_b_text2)
        TextView zxccBText2;
//        @Bind(R.id.zxcc_b_text3)
//        TextView zxccBText3;
        @Bind(R.id.zxcc_b_text4)
        TextView zxccBText4;
        @Bind(R.id.zxcc_b_text11)
        TextView zxccBText11;
        @Bind(R.id.zxcc_b_text5)
        TextView zxccBText5;
        @Bind(R.id.zxcc_b_text6)
        TextView zxccBText6;
        @Bind(R.id.zxcc_b_text7)
        TextView zxccBText7;
        @Bind(R.id.zxcc_b_text8)
        TextView zxccBText8;
        @Bind(R.id.zxcc_b_text10)
        TextView zxccBText10;
        @Bind(R.id.zh_img1)
        ImageView zhImg1;
        @Bind(R.id.zxcc_b_ddh)
        ImageView zxccbddh;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
