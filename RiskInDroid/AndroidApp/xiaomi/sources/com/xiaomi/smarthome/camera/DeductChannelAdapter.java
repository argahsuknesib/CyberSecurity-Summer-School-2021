package com.xiaomi.smarthome.camera;

import _m_j.gkv;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class DeductChannelAdapter implements ListAdapter {
    private Context appContext = gkv.f17949O000000o;
    private final Integer[] drawableResources = {Integer.valueOf((int) R.drawable.icon_wechat_pay), Integer.valueOf((int) R.drawable.icon_alipay)};
    private final String[] items = {this.appContext.getString(R.string.deduct_wechat_pay), this.appContext.getString(R.string.deduct_alipay)};

    public boolean areAllItemsEnabled() {
        return false;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return false;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public boolean isEnabled(int i) {
        String[] strArr = this.items;
        return strArr != null && i < strArr.length;
    }

    public int getCount() {
        String[] strArr = this.items;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public Object getItem(int i) {
        String[] strArr = this.items;
        if (strArr == null || i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.appContext).inflate((int) R.layout.item_deduct_channel, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_deduct_name)).setText(this.items[i]);
        ((ImageView) inflate.findViewById(R.id.iv_icon_channel)).setImageResource(this.drawableResources[i].intValue());
        return inflate;
    }

    public boolean isEmpty() {
        String[] strArr = this.items;
        return strArr == null || strArr.length <= 0;
    }
}
