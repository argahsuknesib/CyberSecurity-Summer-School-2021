package androidx.transition;

import _m_j.in;
import _m_j.n;
import _m_j.s;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {

    /* renamed from: O000000o  reason: collision with root package name */
    private Path f3014O000000o;
    private final Path O00000Oo = new Path();
    private final Matrix O00000o0 = new Matrix();

    public PatternPathMotion() {
        this.O00000Oo.lineTo(1.0f, 0.0f);
        this.f3014O000000o = this.O00000Oo;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O0000OoO);
        try {
            String O00000o02 = n.O00000o0(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (O00000o02 != null) {
                Path O000000o2 = s.O000000o(O00000o02);
                PathMeasure pathMeasure = new PathMeasure(O000000o2, false);
                float[] fArr = new float[2];
                pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
                float f = fArr[0];
                float f2 = fArr[1];
                pathMeasure.getPosTan(0.0f, fArr, null);
                float f3 = fArr[0];
                float f4 = fArr[1];
                if (f3 == f) {
                    if (f4 == f2) {
                        throw new IllegalArgumentException("pattern must not end at the starting point");
                    }
                }
                this.O00000o0.setTranslate(-f3, -f4);
                float f5 = f - f3;
                float f6 = f2 - f4;
                float O000000o3 = 1.0f / O000000o(f5, f6);
                this.O00000o0.postScale(O000000o3, O000000o3);
                this.O00000o0.postRotate((float) Math.toDegrees(-Math.atan2((double) f6, (double) f5)));
                O000000o2.transform(this.O00000o0, this.O00000Oo);
                this.f3014O000000o = O000000o2;
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public Path getPath(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float O000000o2 = O000000o(f5, f6);
        double atan2 = Math.atan2((double) f6, (double) f5);
        this.O00000o0.setScale(O000000o2, O000000o2);
        this.O00000o0.postRotate((float) Math.toDegrees(atan2));
        this.O00000o0.postTranslate(f, f2);
        Path path = new Path();
        this.O00000Oo.transform(this.O00000o0, path);
        return path;
    }

    private static float O000000o(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
