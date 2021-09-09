package com.mi.global.shop.feature.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mi.global.shop.feature.search.newmodel.SearchResult;
import com.xiaomi.smarthome.R;
import java.util.List;

public class GirdDropDownAdapter extends BaseAdapter {
    private int checkItemPosition = 0;
    private Context context;
    private List<SearchResult.AllCategoriesBean> list;

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void setCheckItem(int i) {
        this.checkItemPosition = i;
        notifyDataSetChanged();
    }

    public GirdDropDownAdapter(Context context2, List<SearchResult.AllCategoriesBean> list2) {
        this.context = context2;
        this.list = list2;
    }

    public void setData(List<SearchResult.AllCategoriesBean> list2) {
        if (list2 != null) {
            List<SearchResult.AllCategoriesBean> list3 = this.list;
            if (list3 != null) {
                list3.clear();
            }
            this.list = list2;
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        List<SearchResult.AllCategoriesBean> list2 = this.list;
        if (list2 == null) {
            return 0;
        }
        return list2.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(this.context).inflate((int) R.layout.feature_search_item_list_drop_down, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        viewHolder.mText.setText(this.list.get(i).cat_name);
        return view;
    }

    static class ViewHolder {
        TextView mText;

        ViewHolder(View view) {
            this.mText = (TextView) view.findViewById(R.id.text);
        }
    }
}
