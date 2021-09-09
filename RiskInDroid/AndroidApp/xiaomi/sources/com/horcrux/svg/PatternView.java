package com.horcrux.svg;

import _m_j.bao;
import _m_j.baq;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.Brush;

@SuppressLint({"ViewConstructor"})
class PatternView extends GroupView {
    private static final float[] sRawMatrix = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    String mAlign;
    private baq mH;
    private Matrix mMatrix = null;
    int mMeetOrSlice;
    private float mMinX;
    private float mMinY;
    private Brush.BrushUnits mPatternContentUnits;
    private Brush.BrushUnits mPatternUnits;
    private float mVbHeight;
    private float mVbWidth;
    private baq mW;
    private baq mX;
    private baq mY;

    public PatternView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.mX = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.mY = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.mW = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.mH = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "patternUnits")
    public void setPatternUnits(int i) {
        if (i == 0) {
            this.mPatternUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mPatternUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "patternContentUnits")
    public void setPatternContentUnits(int i) {
        if (i == 0) {
            this.mPatternContentUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mPatternContentUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "patternTransform")
    public void setPatternTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int O000000o2 = bao.O000000o(readableArray, sRawMatrix, this.mScale);
            if (O000000o2 == 6) {
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                }
                this.mMatrix.setValues(sRawMatrix);
            } else if (O000000o2 != -1) {
                FLog.w("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.mMatrix = null;
        }
        invalidate();
    }

    @ReactProp(name = "minX")
    public void setMinX(float f) {
        this.mMinX = f;
        invalidate();
    }

    @ReactProp(name = "minY")
    public void setMinY(float f) {
        this.mMinY = f;
        invalidate();
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(float f) {
        this.mVbWidth = f;
        invalidate();
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(float f) {
        this.mVbHeight = f;
        invalidate();
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public RectF getViewBox() {
        return new RectF(this.mMinX * this.mScale, this.mMinY * this.mScale, (this.mMinX + this.mVbWidth) * this.mScale, (this.mMinY + this.mVbHeight) * this.mScale);
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            boolean z = false;
            Brush brush = new Brush(Brush.BrushType.PATTERN, new baq[]{this.mX, this.mY, this.mW, this.mH}, this.mPatternUnits);
            if (this.mPatternContentUnits == Brush.BrushUnits.OBJECT_BOUNDING_BOX) {
                z = true;
            }
            brush.O00000oO = z;
            brush.O0000OOo = this;
            Matrix matrix = this.mMatrix;
            if (matrix != null) {
                brush.O00000oo = matrix;
            }
            SvgView svgView = getSvgView();
            if (this.mPatternUnits == Brush.BrushUnits.USER_SPACE_ON_USE || this.mPatternContentUnits == Brush.BrushUnits.USER_SPACE_ON_USE) {
                brush.O0000O0o = svgView.getCanvasBounds();
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}
