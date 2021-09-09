package com.transitionseverywhere;

import _m_j.drd;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

public class PatternPathMotion extends PathMotion {
    private Path O00000Oo;
    private final Matrix O00000o = new Matrix();
    private final Path O00000o0 = new Path();

    public PatternPathMotion() {
        this.O00000o0.lineTo(1.0f, 0.0f);
        this.O00000Oo = this.O00000o0;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.patternPathData});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Path O000000o2 = drd.O000000o(string);
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
                this.O00000o.setTranslate(-f3, -f4);
                float f5 = f2 - f4;
                double d = (double) (f - f3);
                double d2 = (double) f5;
                float hypot = 1.0f / ((float) Math.hypot(d, d2));
                this.O00000o.postScale(hypot, hypot);
                this.O00000o.postRotate((float) Math.toDegrees(-Math.atan2(d2, d)));
                O000000o2.transform(this.O00000o, this.O00000o0);
                this.O00000Oo = O000000o2;
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
