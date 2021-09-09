package androidx.transition;

import _m_j.in;
import _m_j.n;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final float f2993O000000o = ((float) Math.tan(Math.toRadians(35.0d)));
    private float O00000Oo = 0.0f;
    private float O00000o = 70.0f;
    private float O00000o0 = 0.0f;
    private float O00000oO = 0.0f;
    private float O00000oo = 0.0f;
    private float O0000O0o = f2993O000000o;

    public ArcMotion() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
     arg types: [android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float */
    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O0000Oo);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        float O000000o2 = n.O000000o(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f);
        this.O00000o0 = O000000o2;
        this.O00000oo = O000000o(O000000o2);
        float O000000o3 = n.O000000o(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f);
        this.O00000Oo = O000000o3;
        this.O00000oO = O000000o(O000000o3);
        float O000000o4 = n.O000000o(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f);
        this.O00000o = O000000o4;
        this.O0000O0o = O000000o(O000000o4);
        obtainStyledAttributes.recycle();
    }

    private static float O000000o(float f) {
        if (f >= 0.0f && f <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public Path getPath(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        Path path = new Path();
        path.moveTo(f, f2);
        float f10 = f3 - f;
        float f11 = f4 - f2;
        float f12 = (f10 * f10) + (f11 * f11);
        float f13 = (f + f3) / 2.0f;
        float f14 = (f2 + f4) / 2.0f;
        float f15 = 0.25f * f12;
        boolean z = f2 > f4;
        if (Math.abs(f10) < Math.abs(f11)) {
            float abs = Math.abs(f12 / (f11 * 2.0f));
            if (z) {
                f6 = abs + f4;
                f7 = f3;
            } else {
                f6 = abs + f2;
                f7 = f;
            }
            f5 = this.O00000oo;
        } else {
            float f16 = f12 / (f10 * 2.0f);
            if (z) {
                f9 = f2;
                f8 = f16 + f;
            } else {
                f8 = f3 - f16;
                f9 = f4;
            }
            f5 = this.O00000oO;
        }
        float f17 = f15 * f5 * f5;
        float f18 = f13 - f7;
        float f19 = f14 - f6;
        float f20 = (f18 * f18) + (f19 * f19);
        float f21 = this.O0000O0o;
        float f22 = f15 * f21 * f21;
        if (f20 < f17) {
            f22 = f17;
        } else if (f20 <= f22) {
            f22 = 0.0f;
        }
        if (f22 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f22 / f20));
            f7 = ((f7 - f13) * sqrt) + f13;
            f6 = f14 + (sqrt * (f6 - f14));
        }
        path.cubicTo((f + f7) / 2.0f, (f2 + f6) / 2.0f, (f7 + f3) / 2.0f, (f6 + f4) / 2.0f, f3, f4);
        return path;
    }
}
