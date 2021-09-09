package com.mi.adapter;

import _m_j.jz;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class BasePageAdapter<T> extends jz {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<T> f4567O000000o = new ArrayList<>();
    private Context O00000Oo;
    private HashMap<Integer, View> O00000o0 = new HashMap<>();

    public BasePageAdapter(Context context) {
        this.O00000Oo = context;
    }
}
