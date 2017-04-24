package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDHYBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class WDHYAdapter extends BaseAdapter {
    private Context context;
    private List<WDHYBean.DataBean> list = null;
    private LayoutInflater inflater;
    private int status1;

    public WDHYAdapter(Context context, List<WDHYBean.DataBean> list, int status1) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        this.status1 = status1;
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
            view = inflater.inflate(R.layout.item_wdhy_a, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.wdhyText1.setText(list.get(i).getShipper_province());
        holder.wdhyText11.setText(list.get(i).getShipper_city());
        holder.wdhyText2.setText(list.get(i).getReceive_province());
        holder.wdhyText22.setText(list.get(i).getReceive_city());
        holder.wdhyText3.setText(list.get(i).getLength());
        holder.wdhyText4.setText(list.get(i).getWeight());
        holder.wdhyText5.setText(list.get(i).getType());
        holder.wdhyText6.setText(list.get(i).getName());
        holder.wdhyText7.setText(list.get(i).getCreate_time());
        if (status1 == 1) {
            holder.wdhyText8.setText("运输中");
        } else if (status1 == 2) {
            holder.wdhyText8.setText("已完成");
        }
        return view;
    }

    public void reload(List _list) {

        list.addAll(_list);
        notifyDataSetChanged();
    }


    static class ViewHolder {
        @Bind(R.id.wdhy_text1)
        TextView wdhyText1;
        @Bind(R.id.wdhy_text11)
        TextView wdhyText11;
        @Bind(R.id.wdhy_text2)
        TextView wdhyText2;
        @Bind(R.id.wdhy_text22)
        TextView wdhyText22;
        @Bind(R.id.wdhy_text3)
        TextView wdhyText3;
        @Bind(R.id.wdhy_text4)
        TextView wdhyText4;
        @Bind(R.id.wdhy_text5)
        TextView wdhyText5;
        @Bind(R.id.wdhy_img)
        ImageView wdhyImg;
        @Bind(R.id.wdhy_text7)
        TextView wdhyText7;
        @Bind(R.id.ysz_text1)
        TextView yszText1;
        @Bind(R.id.wdhy_text6)
        TextView wdhyText6;
        @Bind(R.id.wdhy_text8)
        TextView wdhyText8;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
