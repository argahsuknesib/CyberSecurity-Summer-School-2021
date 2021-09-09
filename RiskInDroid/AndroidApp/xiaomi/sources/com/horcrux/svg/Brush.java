package com.horcrux.svg;

import _m_j.bao;
import _m_j.baq;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.react.bridge.ReadableArray;

public final class Brush {

    /* renamed from: O000000o  reason: collision with root package name */
    final BrushType f4385O000000o;
    final baq[] O00000Oo;
    final boolean O00000o;
    public ReadableArray O00000o0;
    boolean O00000oO;
    public Matrix O00000oo;
    public Rect O0000O0o;
    PatternView O0000OOo;

    public enum BrushType {
        LINEAR_GRADIENT,
        RADIAL_GRADIENT,
        PATTERN
    }

    public enum BrushUnits {
        OBJECT_BOUNDING_BOX,
        USER_SPACE_ON_USE
    }

    public Brush(BrushType brushType, baq[] baqArr, BrushUnits brushUnits) {
        this.f4385O000000o = brushType;
        this.O00000Oo = baqArr;
        this.O00000o = brushUnits == BrushUnits.OBJECT_BOUNDING_BOX;
    }

    static void O000000o(ReadableArray readableArray, int i, float[] fArr, int[] iArr, float f) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            fArr[i2] = (float) readableArray.getDouble(i3);
            int i4 = readableArray.getInt(i3 + 1);
            iArr[i2] = (i4 & 16777215) | (Math.round(((float) (i4 >>> 24)) * f) << 24);
        }
    }

    /* access modifiers changed from: package-private */
    public final double O000000o(baq baq, double d, float f, float f2) {
        double d2;
        if (this.O00000o) {
            if (baq.O00000Oo == SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER) {
                d2 = d;
                return bao.O000000o(baq, d, 0.0d, d2, (double) f2);
            }
        }
        d2 = (double) f;
        return bao.O000000o(baq, d, 0.0d, d2, (double) f2);
    }
}
