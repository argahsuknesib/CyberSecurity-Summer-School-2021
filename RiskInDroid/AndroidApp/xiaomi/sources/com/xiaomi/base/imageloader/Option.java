package com.xiaomi.base.imageloader;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public final class Option {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Option f5974O000000o;
    public int O00000Oo;
    public int O00000o;
    public Drawable O00000o0;
    public Drawable O00000oO;
    public Strategy O00000oo;
    public int O0000O0o;
    public boolean O0000OOo;
    public boolean O0000Oo = false;
    public boolean O0000Oo0 = false;
    public boolean O0000OoO = false;
    public boolean O0000Ooo = false;
    public ImageView.ScaleType O0000o0;
    public boolean O0000o00 = false;

    public enum Strategy {
        ALL,
        NONE,
        AUTOMATIC
    }

    static {
        Option option = new Option();
        option.O00000oo = Strategy.ALL;
        f5974O000000o = option;
    }

    public final String toString() {
        return "Option{placeholderRes=" + this.O00000Oo + ", errorRes=" + this.O00000o + ", strategy=" + this.O00000oo + '}';
    }
}
