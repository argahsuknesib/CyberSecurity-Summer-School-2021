package com.mi.global.shop.feature.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.List;

public class ListDropDownAdapter extends BaseAdapter {
    private int checkItemPosition = 0;
    private Context context;
    private List<String> list;

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

    public ListDropDownAdapter(Context context2, List<String> list2) {
        this.context = context2;
        this.list = list2;
    }

    public int getCount() {
        return this.list.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(this.context).inflate((int) R.layout.feature_search_item_default_drop_down, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        fillValue(i, viewHolder);
        return view;
    }

    private void fillValue(int i, ViewHolder viewHolder) {
        viewHolder.mText.setText(this.list.get(i));
        int i2 = this.checkItemPosition;
        if (i2 == -1) {
            return;
        }
        if (i2 == i) {
            viewHolder.mText.setTextColor(this.context.getResources().getColor(R.color.feature_search_drop_down_selected));
            viewHolder.mText.setBackgroundResource(R.color.feature_search_check_bg);
            return;
        }
        viewHolder.mText.setTextColor(this.context.getResources().getColor(R.color.feature_search_drop_down_unselected));
        viewHolder.mText.setBackgroundResource(R.color.white);
    }

    static class ViewHolder {
        TextView mText;

        ViewHolder(View view) {
            this.mText = (TextView) view.findViewById(R.id.text);
        }
    }
}
