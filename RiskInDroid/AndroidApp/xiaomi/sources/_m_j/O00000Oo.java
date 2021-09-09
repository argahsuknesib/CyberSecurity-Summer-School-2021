package _m_j;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;

public final class O00000Oo {
    public static int O000000o(int i) {
        float f = (float) i;
        O0000Oo0 o0000Oo0 = O0000Oo0.f5251O000000o;
        if (o0000Oo0 != null) {
            return (int) (f * o0000Oo0.O00000oo);
        }
        throw new IllegalStateException("Must init before using.");
    }

    public static RoundRectShape O000000o(int i, int i2, int i3, int i4) {
        float[] fArr = new float[8];
        if (i > 0) {
            float f = (float) i;
            fArr[0] = f;
            fArr[1] = f;
        }
        if (i2 > 0) {
            float f2 = (float) i2;
            fArr[2] = f2;
            fArr[3] = f2;
        }
        if (i3 > 0) {
            float f3 = (float) i3;
            fArr[4] = f3;
            fArr[5] = f3;
        }
        if (i4 > 0) {
            float f4 = (float) i4;
            fArr[6] = f4;
            fArr[7] = f4;
        }
        return new RoundRectShape(fArr, null, null);
    }

    public static boolean O000000o() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        String str = locale.getLanguage() + "-" + locale.getCountry();
        return !TextUtils.isEmpty(str) && str.startsWith("zh");
    }

    public static int[] O000000o(Context context) {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 14 && i3 < 17) {
            try {
                i = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        } else if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            i = point.x;
            i2 = point.y;
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }
}
