package com.xiaomi.shopviews.adapter.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"WrongConstant"})
public abstract class ArraysAdapter<T> extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<T> f3587O000000o = new ArrayList();
    private Context O00000Oo;
    private final Object O00000o = new Object();
    private LayoutInflater O00000o0;
    private boolean O00000oO = true;

    public ArraysAdapter(Context context) {
        this.O00000Oo = context;
        this.O00000o0 = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
