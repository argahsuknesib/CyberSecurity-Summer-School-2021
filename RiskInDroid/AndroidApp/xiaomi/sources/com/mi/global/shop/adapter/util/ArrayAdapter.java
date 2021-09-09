package com.mi.global.shop.adapter.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class ArrayAdapter<T> extends BaseAdapter {
    public Context O00000o;
    protected ArrayList<T> O00000oO = new ArrayList<>();
    protected boolean O00000oo;

    public abstract View O000000o(Context context, int i, T t, ViewGroup viewGroup);

    public abstract void O000000o(View view, int i, T t);

    public ArrayAdapter(Context context) {
        this.O00000o = context;
        this.O00000oo = false;
    }

    public void O000000o(ArrayList arrayList) {
        if (arrayList != null) {
            this.O00000oo = true;
            this.O00000oO.addAll(arrayList);
            notifyDataSetChanged();
            return;
        }
        this.O00000oo = false;
        notifyDataSetInvalidated();
    }

    public void O000000o(List list) {
        if (list != null) {
            this.O00000oo = true;
            this.O00000oO.clear();
            this.O00000oO.addAll(list);
            notifyDataSetChanged();
            return;
        }
        this.O00000oo = false;
        notifyDataSetInvalidated();
    }

    public final ArrayList<T> O00000Oo() {
        ArrayList<T> arrayList = new ArrayList<>();
        ArrayList<T> arrayList2 = this.O00000oO;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public int getCount() {
        ArrayList<T> arrayList;
        if (!this.O00000oo || (arrayList = this.O00000oO) == null) {
            return 0;
        }
        return arrayList.size();
    }

    public Object getItem(int i) {
        ArrayList<T> arrayList;
        if (!this.O00000oo || (arrayList = this.O00000oO) == null) {
            return null;
        }
        return arrayList.get(i);
    }

    public long getItemId(int i) {
        if (!this.O00000oo || this.O00000oO == null) {
            return 0;
        }
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.O00000oo) {
            throw new IllegalStateException("this should only be called when the data is valid");
        } else if (i < 0 || i >= this.O00000oO.size()) {
            throw new IllegalStateException("couldn't get view at this position ".concat(String.valueOf(i)));
        } else {
            T t = this.O00000oO.get(i);
            if (view == null) {
                view = O000000o(this.O00000o, i, t, viewGroup);
            }
            O000000o(view, i, t);
            return view;
        }
    }

    public final void O00000o0() {
        ArrayList<T> arrayList = this.O00000oO;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
