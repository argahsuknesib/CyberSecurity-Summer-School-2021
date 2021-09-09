package com.mi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public abstract class ArrayAdapter<T> extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f4566O000000o;
    protected ArrayList<T> O00000Oo = new ArrayList<>();
    protected boolean O00000o0;

    public abstract View O000000o();

    public abstract void O000000o(View view, T t);

    public ArrayAdapter(Context context) {
        this.f4566O000000o = context;
        this.O00000o0 = false;
    }

    public final void O000000o(ArrayList<T> arrayList) {
        this.O00000o0 = true;
        this.O00000Oo.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getCount() {
        ArrayList<T> arrayList;
        if (!this.O00000o0 || (arrayList = this.O00000Oo) == null) {
            return 0;
        }
        return arrayList.size();
    }

    public Object getItem(int i) {
        ArrayList<T> arrayList;
        if (!this.O00000o0 || (arrayList = this.O00000Oo) == null) {
            return null;
        }
        return arrayList.get(i);
    }

    public long getItemId(int i) {
        if (!this.O00000o0 || this.O00000Oo == null) {
            return 0;
        }
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.O00000o0) {
            throw new IllegalStateException("this should only be called when the data is valid");
        } else if (i < 0 || i >= this.O00000Oo.size()) {
            throw new IllegalStateException("couldn't get view at this position ".concat(String.valueOf(i)));
        } else {
            T t = this.O00000Oo.get(i);
            if (view == null) {
                view = O000000o();
            }
            O000000o(view, t);
            return view;
        }
    }
}
