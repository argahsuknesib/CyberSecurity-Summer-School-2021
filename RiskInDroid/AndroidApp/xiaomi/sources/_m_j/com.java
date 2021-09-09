package _m_j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public final class com implements cok {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f14170O000000o;
    protected final cod O00000Oo;
    protected final ViewScaleType O00000o0;

    public final boolean O000000o(Bitmap bitmap) {
        return true;
    }

    public final boolean O000000o(Drawable drawable) {
        return true;
    }

    public final View O00000o() {
        return null;
    }

    public final boolean O00000oO() {
        return false;
    }

    public com(String str, cod cod, ViewScaleType viewScaleType) {
        if (cod == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        } else if (viewScaleType != null) {
            this.f14170O000000o = str;
            this.O00000Oo = cod;
            this.O00000o0 = viewScaleType;
        } else {
            throw new IllegalArgumentException("scaleType must not be null");
        }
    }

    public final int O000000o() {
        return this.O00000Oo.f14165O000000o;
    }

    public final int O00000Oo() {
        return this.O00000Oo.O00000Oo;
    }

    public final ViewScaleType O00000o0() {
        return this.O00000o0;
    }

    public final int O00000oo() {
        return TextUtils.isEmpty(this.f14170O000000o) ? super.hashCode() : this.f14170O000000o.hashCode();
    }
}
