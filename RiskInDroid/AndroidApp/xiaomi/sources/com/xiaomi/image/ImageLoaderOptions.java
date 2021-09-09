package com.xiaomi.image;

import _m_j.uu;
import _m_j.vg;
import _m_j.vl;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.squareup.picasso.Transformation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ImageLoaderOptions {

    /* renamed from: O000000o  reason: collision with root package name */
    public View f5978O000000o;
    public vl O00000Oo;
    public Drawable O00000o;
    public String O00000o0;
    public int O00000oO;
    public Drawable O00000oo;
    public O000000o O0000O0o;
    public int O0000OOo;
    public boolean O0000Oo;
    public Drawable O0000Oo0;
    public boolean O0000OoO;
    public boolean O0000Ooo = true;
    public List<vg> O0000o;
    public int O0000o0;
    public ImageLoaderDiskCacheStrategy O0000o00 = ImageLoaderDiskCacheStrategy.All;
    public Map<Class<?>, uu<?>> O0000o0O = new HashMap();
    public Class O0000o0o;
    public List<Transformation> O0000oO;
    public int O0000oO0;

    public enum ImageLoaderDiskCacheStrategy {
        All,
        NONE,
        DISK,
        MEMORY
    }

    public ImageLoaderOptions(View view, String str) {
        this.f5978O000000o = view;
        this.O00000o0 = str;
    }

    public final void O000000o(int i, int i2) {
        this.O0000O0o = new O000000o(i, i2);
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5979O000000o;
        public int O00000Oo;

        public O000000o(int i, int i2) {
            this.f5979O000000o = i;
            this.O00000Oo = i2;
        }
    }
}
