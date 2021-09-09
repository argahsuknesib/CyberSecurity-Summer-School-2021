package com.horcrux.svg;

import _m_j.baq;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class CircleView extends RenderableView {
    private baq mCx;
    private baq mCy;
    private baq mR;

    public CircleView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "cx")
    public void setCx(Dynamic dynamic) {
        this.mCx = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "cy")
    public void setCy(Dynamic dynamic) {
        this.mCy = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "r")
    public void setR(Dynamic dynamic) {
        this.mR = baq.O000000o(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        path.addCircle((float) relativeOnWidth(this.mCx), (float) relativeOnHeight(this.mCy), (float) relativeOnOther(this.mR), Path.Direction.CW);
        return path;
    }
}
