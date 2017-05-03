package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDHYBBean;
import com.huotongtianxia.huoyuan.bean.WDHYBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class WDHYBAdapter extends BaseAdapter {
    private Context context;
    private List<WDHYBBean.DataBean> list = null;
    private LayoutInflater inflater;

    public WDHYBAdapter(Context context, List<WDHYBBean.DataBean> list) {
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
            view = inflater.inflate(R.layout.item_wdhy_b, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.wdhyDjdText1.setText(list.get(i).getFprovince());
        holder.wdhyDjdText11.setText(list.get(i).getFcity());
        holder.wdhyDjdText2.setText(list.get(i).getProvince());
        holder.wdhyDjdText22.setText(list.get(i).getCity());
        holder.wdhyDjdText3.setText(list.get(i).getRequire_truck_length());
        holder.wdhyDjdText4.setText(list.get(i).getRequire_truck_weight());
        holder.wdhyDjdText5.setText(list.get(i).getRequire_truck_type());
        holder.wdhyDjdText6.setText(list.get(i).getGoods_type());
        holder.wdhyDjdText7.setText(list.get(i).getCreate_time());
        return view;
    }

    public void reload(List _list) {
        list.addAll(_list);
        notifyDataSetChanged();
    }


    static class ViewHolder {
        @Bind(R.id.wdhy_djd_text1)
        TextView wdhyDjdText1;
        @Bind(R.id.wdhy_djd_text11)
        TextView wdhyDjdText11;
        @Bind(R.id.wdhy_djd_text2)
        TextView wdhyDjdText2;
        @Bind(R.id.wdhy_djd_text22)
        TextView wdhyDjdText22;
        @Bind(R.id.wdhy_djd_text3)
        TextView wdhyDjdText3;
        @Bind(R.id.wdhy_djd_text4)
        TextView wdhyDjdText4;
        @Bind(R.id.wdhy_djd_text5)
        TextView wdhyDjdText5;
        @Bind(R.id.ysz_text1)
        TextView yszText1;
        @Bind(R.id.wdhy_djd_text6)
        TextView wdhyDjdText6;
        @Bind(R.id.wdhy_djd_text7)
        TextView wdhyDjdText7;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
