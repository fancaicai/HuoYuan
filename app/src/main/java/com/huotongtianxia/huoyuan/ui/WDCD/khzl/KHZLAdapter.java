package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.KHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class KHZLAdapter extends BaseAdapter {
    private Context context;
    private List<SHRBean.DataBean> list = null;
    private LayoutInflater inflater;

    public KHZLAdapter(Context context, List<SHRBean.DataBean> list) {
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
            view = inflater.inflate(R.layout.khzl_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        /**
         * id : 60
         * company_name : 大同煤业有限集团
         * contacts : 白
         * tel : 13653582497
         * province : 山西省
         * city : 大同
         * area :
         * address : 山西大同小北街1号
         */
        holder.khzlText2.setText(list.get(i).getCompany_name());
        holder.khzlText3.setText(list.get(i).getTel());
        holder.khzlText5.setText(list.get(i).getProvince()+"-"+list.get(i).getCity()+"-"+list.get(i).getArea()+","+list.get(i).getAddress());
        return view;
    }



    public void reload(List _list) {

        list.addAll(_list);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @Bind(R.id.khzl_text2)
        TextView khzlText2;
        @Bind(R.id.khzl_text3)
        TextView khzlText3;
        @Bind(R.id.khzl_text5)
        TextView khzlText5;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
