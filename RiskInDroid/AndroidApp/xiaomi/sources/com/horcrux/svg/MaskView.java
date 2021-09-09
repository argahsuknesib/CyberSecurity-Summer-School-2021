package com.horcrux.svg;

import _m_j.bao;
import _m_j.baq;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.Brush;

@SuppressLint({"ViewConstructor"})
class MaskView extends GroupView {
    private static final float[] sRawMatrix = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    baq mH;
    private Brush.BrushUnits mMaskContentUnits;
    private Brush.BrushUnits mMaskUnits;
    private Matrix mMatrix = null;
    baq mW;
    baq mX;
    baq mY;

    public MaskView(ReactContext reactContext) {
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

    @ReactProp(name = "maskUnits")
    public void setMaskUnits(int i) {
        if (i == 0) {
            this.mMaskUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mMaskUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "maskContentUnits")
    public void setMaskContentUnits(int i) {
        if (i == 0) {
            this.mMaskContentUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mMaskContentUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "maskTransform")
    public void setMaskTransform(ReadableArray readableArray) {
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

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMask(this, this.mName);
        }
    }
}
