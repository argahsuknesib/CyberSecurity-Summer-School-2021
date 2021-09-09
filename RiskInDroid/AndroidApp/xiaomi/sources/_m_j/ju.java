package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public final class ju implements Interpolator {

    /* renamed from: O000000o  reason: collision with root package name */
    private float[] f2119O000000o;
    private float[] O00000Oo;

    public ju(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
     arg types: [android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float */
    private ju(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray O000000o2 = n.O000000o(resources, theme, attributeSet, jo.O0000Ooo);
        if (n.O000000o(xmlPullParser, "pathData")) {
            String O00000o0 = n.O00000o0(O000000o2, xmlPullParser, "pathData", 4);
            Path O000000o3 = s.O000000o(O00000o0);
            if (O000000o3 != null) {
                O000000o(O000000o3);
            } else {
                throw new InflateException("The path is null, which is created from ".concat(String.valueOf(O00000o0)));
            }
        } else if (!n.O000000o(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (n.O000000o(xmlPullParser, "controlY1")) {
            float O000000o4 = n.O000000o(O000000o2, xmlPullParser, "controlX1", 0, 0.0f);
            float O000000o5 = n.O000000o(O000000o2, xmlPullParser, "controlY1", 1, 0.0f);
            boolean O000000o6 = n.O000000o(xmlPullParser, "controlX2");
            if (O000000o6 != n.O000000o(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!O000000o6) {
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.quadTo(O000000o4, O000000o5, 1.0f, 1.0f);
                O000000o(path);
            } else {
                float O000000o7 = n.O000000o(O000000o2, xmlPullParser, "controlX2", 2, 0.0f);
                float O000000o8 = n.O000000o(O000000o2, xmlPullParser, "controlY2", 3, 0.0f);
                Path path2 = new Path();
                path2.moveTo(0.0f, 0.0f);
                path2.cubicTo(O000000o4, O000000o5, O000000o7, O000000o8, 1.0f, 1.0f);
                O000000o(path2);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        O000000o2.recycle();
    }

    private void O000000o(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f2119O000000o = new float[min];
            this.O00000Oo = new float[min];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, null);
                this.f2119O000000o[i2] = fArr[0];
                this.O00000Oo[i2] = fArr[1];
            }
            if (((double) Math.abs(this.f2119O000000o[0])) <= 1.0E-5d && ((double) Math.abs(this.O00000Oo[0])) <= 1.0E-5d) {
                int i3 = min - 1;
                if (((double) Math.abs(this.f2119O000000o[i3] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.O00000Oo[i3] - 1.0f)) <= 1.0E-5d) {
                    int i4 = 0;
                    float f = 0.0f;
                    while (i < min) {
                        float[] fArr2 = this.f2119O000000o;
                        int i5 = i4 + 1;
                        float f2 = fArr2[i4];
                        if (f2 >= f) {
                            fArr2[i] = f2;
                            i++;
                            f = f2;
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :".concat(String.valueOf(f2)));
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f2119O000000o[0]);
            sb.append(",");
            sb.append(this.O00000Oo[0]);
            sb.append(" end:");
            int i6 = min - 1;
            sb.append(this.f2119O000000o[i6]);
            sb.append(",");
            sb.append(this.O00000Oo[i6]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length ".concat(String.valueOf(length)));
    }

    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f2119O000000o.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f2119O000000o[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f2119O000000o;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.O00000Oo[i];
        }
        float[] fArr2 = this.O00000Oo;
        float f3 = fArr2[i];
        return f3 + (((f - fArr[i]) / f2) * (fArr2[length] - f3));
    }
}
