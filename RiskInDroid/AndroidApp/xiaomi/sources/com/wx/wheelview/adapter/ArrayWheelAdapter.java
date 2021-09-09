package com.wx.wheelview.adapter;

import _m_j.dts;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.wx.wheelview.widget.WheelItem;

public class ArrayWheelAdapter extends dts<String> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f5937O000000o;

    public ArrayWheelAdapter(Context context) {
        this.f5937O000000o = context;
    }

    public View bindView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new WheelItem(this.f5937O000000o);
        }
        ((WheelItem) view).setText((CharSequence) this.mList.get(i));
        return view;
    }
}
