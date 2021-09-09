package _m_j;

import _m_j.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public final TypedArray f12340O000000o;
    private final Context O00000Oo;
    private TypedValue O00000o0;

    public static Oo O000000o(Context context, AttributeSet attributeSet, int[] iArr) {
        return new Oo(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static Oo O000000o(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new Oo(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static Oo O000000o(Context context, int i, int[] iArr) {
        return new Oo(context, context.obtainStyledAttributes(i, iArr));
    }

    private Oo(Context context, TypedArray typedArray) {
        this.O00000Oo = context;
        this.f12340O000000o = typedArray;
    }

    public final Drawable O000000o(int i) {
        int resourceId;
        if (!this.f12340O000000o.hasValue(i) || (resourceId = this.f12340O000000o.getResourceId(i, 0)) == 0) {
            return this.f12340O000000o.getDrawable(i);
        }
        return OO0000o.O00000Oo(this.O00000Oo, resourceId);
    }

    public final Drawable O00000Oo(int i) {
        int resourceId;
        if (!this.f12340O000000o.hasValue(i) || (resourceId = this.f12340O000000o.getResourceId(i, 0)) == 0) {
            return null;
        }
        return OOO0o0.O00000Oo().O00000Oo(this.O00000Oo, resourceId);
    }

    public final Typeface O000000o(int i, int i2, m.O000000o o000000o) {
        int resourceId = this.f12340O000000o.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.O00000o0 == null) {
            this.O00000o0 = new TypedValue();
        }
        return m.O000000o(this.O00000Oo, resourceId, this.O00000o0, i2, o000000o);
    }

    public final CharSequence O00000o0(int i) {
        return this.f12340O000000o.getText(i);
    }

    public final String O00000o(int i) {
        return this.f12340O000000o.getString(i);
    }

    public final boolean O000000o(int i, boolean z) {
        return this.f12340O000000o.getBoolean(i, z);
    }

    public final int O000000o(int i, int i2) {
        return this.f12340O000000o.getInt(i, i2);
    }

    public final int O00000Oo(int i, int i2) {
        return this.f12340O000000o.getColor(i, i2);
    }

    public final ColorStateList O00000oO(int i) {
        int resourceId;
        ColorStateList O000000o2;
        if (!this.f12340O000000o.hasValue(i) || (resourceId = this.f12340O000000o.getResourceId(i, 0)) == 0 || (O000000o2 = OO0000o.O000000o(this.O00000Oo, resourceId)) == null) {
            return this.f12340O000000o.getColorStateList(i);
        }
        return O000000o2;
    }

    public final int O00000o0(int i, int i2) {
        return this.f12340O000000o.getInteger(i, i2);
    }

    public final float O00000oo(int i) {
        return this.f12340O000000o.getDimension(i, -1.0f);
    }

    public final int O00000o(int i, int i2) {
        return this.f12340O000000o.getDimensionPixelOffset(i, i2);
    }

    public final int O00000oO(int i, int i2) {
        return this.f12340O000000o.getDimensionPixelSize(i, i2);
    }

    public final int O00000oo(int i, int i2) {
        return this.f12340O000000o.getLayoutDimension(i, i2);
    }

    public final int O0000O0o(int i, int i2) {
        return this.f12340O000000o.getResourceId(i, i2);
    }

    public final boolean O0000O0o(int i) {
        return this.f12340O000000o.hasValue(i);
    }
}
