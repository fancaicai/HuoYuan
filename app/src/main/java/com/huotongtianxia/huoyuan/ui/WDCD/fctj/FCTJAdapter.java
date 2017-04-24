package com.huotongtianxia.huoyuan.ui.WDCD.fctj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.FCTJBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

public class FCTJAdapter extends BaseAdapter {
    private Context context;
    private List<FCTJBean.DataBean> list = null;
    private LayoutInflater inflater;

    public FCTJAdapter(Context context, List<FCTJBean.DataBean> list) {
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
            view = inflater.inflate(R.layout.item_fctj, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.fctjItemText1.setText(list.get(i).getCity());
        holder.fctjItemText2.setText(list.get(i).getPlate_number());
        int b1 = 0;
        if (b1 == 0){
            holder.fctjItemText3.setText("未到达");
        }else if (b1 == 1){
            holder.fctjItemText3.setText("已到达");
        }
        return view;
    }

    public void reload(List _list) {

        list.addAll(_list);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @Bind(R.id.fctj_item_text1)
        TextView fctjItemText1;
        @Bind(R.id.fctj_item_text2)
        TextView fctjItemText2;
        @Bind(R.id.fctj_item_text3)
        TextView fctjItemText3;
        @Bind(R.id.fctj_item_text4)
        TextView fctjItemText4;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
