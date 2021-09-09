package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;

public final class izh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1666O000000o = (Build.VERSION.SDK_INT >= 21);

    public static int O000000o(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    public static int O00000Oo(int i, int i2) {
        return (i & 255) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24) | (((i >> 16) & 255) << 16) | (((i >> 8) & 255) << 8);
    }

    public static int O00000o0(int i, int i2) {
        return (i & 255) | (i2 << 24) | (((i >> 16) & 255) << 16) | (((i >> 8) & 255) << 8);
    }

    public static Typeface O000000o(Context context, String str) {
        String concat = "fonts/".concat(String.valueOf(str));
        try {
            return Typeface.createFromAsset(context.getAssets(), concat);
        } catch (Exception unused) {
            Log.e("Genius Ui", "Font file at " + concat + " cannot be found or the file is not a valid font file. Please be sure that library assets are included to project. If not, copy assets/fonts folder of the library to your projects assets folder.");
            return null;
        }
    }

    public static boolean O000000o(Context context, AttributeSet attributeSet, int i, int i2, boolean z) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842766}, i, i2);
        if (obtainStyledAttributes.length() > 0) {
            z = obtainStyledAttributes.getBoolean(0, z);
        }
        obtainStyledAttributes.recycle();
        return z;
    }

    public static boolean O000000o(AttributeSet attributeSet, String str) {
        return attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }
}
