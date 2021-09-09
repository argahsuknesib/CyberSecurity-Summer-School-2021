package com.lidroid.xutils;

import _m_j.bok;
import _m_j.bol;
import android.content.Context;

public class BitmapUtils {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f4506O000000o;
    public boolean O00000Oo;
    public bol O00000o;
    public final Object O00000o0;
    private Context O00000oO;
    private bok O00000oo;

    public BitmapUtils(Context context) {
        this(context, (byte) 0);
    }

    private BitmapUtils(Context context, byte b) {
        this.f4506O000000o = false;
        this.O00000Oo = false;
        this.O00000o0 = new Object();
        if (context != null) {
            this.O00000oO = context.getApplicationContext();
            this.O00000o = bol.O000000o(this.O00000oO, null);
            this.O00000oo = new bok();
            return;
        }
        throw new IllegalArgumentException("context may not be null");
    }
}
