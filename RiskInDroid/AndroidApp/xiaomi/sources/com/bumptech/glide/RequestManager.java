package com.bumptech.glide;

import _m_j.up;
import _m_j.ve;
import _m_j.vg;
import _m_j.vh;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public final CopyOnWriteArrayList<vg<Object>> f3571O000000o = new CopyOnWriteArrayList<>();
    private Context O00000Oo;
    private vh O00000o0;

    public RequestManager(Context context) {
        this.O00000Oo = context;
    }

    public final up O000000o() {
        return O000000o(ve.class);
    }

    public final up O00000Oo() {
        return O000000o(File.class);
    }

    public final up O00000o0() {
        return O000000o(Bitmap.class);
    }

    private <ResourceType> up O000000o(Class<ResourceType> cls) {
        up upVar = new up(this, cls, this.O00000Oo);
        vh vhVar = this.O00000o0;
        if (vhVar != null) {
            upVar.O00000Oo(vhVar);
        }
        return upVar;
    }

    public final up O000000o(Integer num) {
        String concat = "res:///".concat(String.valueOf(num));
        up O000000o2 = O000000o(Drawable.class);
        O000000o2.f2542O000000o = concat;
        return O000000o2;
    }

    public final up O000000o(String str) {
        up O000000o2 = O000000o(Drawable.class);
        O000000o2.f2542O000000o = str;
        return O000000o2;
    }

    public final up O000000o(Uri uri) {
        up O000000o2 = O000000o(Drawable.class);
        O000000o2.f2542O000000o = uri.toString();
        return O000000o2;
    }
}
