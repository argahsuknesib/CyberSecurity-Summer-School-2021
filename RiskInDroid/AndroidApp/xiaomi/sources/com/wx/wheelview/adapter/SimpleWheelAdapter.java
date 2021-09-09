package com.wx.wheelview.adapter;

import _m_j.dts;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.wx.wheelview.common.WheelData;
import com.wx.wheelview.widget.WheelItem;

public class SimpleWheelAdapter extends dts<WheelData> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f5938O000000o;

    public SimpleWheelAdapter(Context context) {
        this.f5938O000000o = context;
    }

    public View bindView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new WheelItem(this.f5938O000000o);
        }
        WheelItem wheelItem = (WheelItem) view;
        wheelItem.setImage(((WheelData) this.mList.get(i)).id);
        wheelItem.setText(((WheelData) this.mList.get(i)).name);
        return view;
    }
}
