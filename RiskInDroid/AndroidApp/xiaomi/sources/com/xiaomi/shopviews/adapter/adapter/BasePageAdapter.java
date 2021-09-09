package com.xiaomi.shopviews.adapter.adapter;

import _m_j.jz;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class BasePageAdapter<T> extends jz {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<T> f3589O000000o = new ArrayList<>();
    private Context O00000Oo;
    private HashMap<Integer, View> O00000o0 = new HashMap<>();

    public abstract View O000000o(Context context, T t, ViewGroup viewGroup);

    public abstract void O000000o(View view, T t);

    public boolean isViewFromObject(View view, Object obj) {
        return obj == view;
    }

    public BasePageAdapter(Context context) {
        this.O00000Oo = context;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView(this.O00000o0.get(Integer.valueOf(i)));
    }

    public int getCount() {
        return this.f3589O000000o.size();
    }

    public T O000000o(int i) {
        return this.f3589O000000o.get(i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = i < this.O00000o0.size() ? this.O00000o0.get(Integer.valueOf(i)) : null;
        Object O000000o2 = O000000o(i);
        if (view == null) {
            view = O000000o(this.O00000Oo, O000000o2, viewGroup);
            this.O00000o0.put(Integer.valueOf(i), view);
        }
        viewGroup.addView(view);
        O000000o(view, O000000o2);
        view.setId(i);
        view.setTag(O000000o2);
        return view;
    }
}
