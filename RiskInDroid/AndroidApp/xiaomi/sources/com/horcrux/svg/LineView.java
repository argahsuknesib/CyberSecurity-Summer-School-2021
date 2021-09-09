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
class LineView extends RenderableView {
    private baq mX1;
    private baq mX2;
    private baq mY1;
    private baq mY2;

    public LineView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x1")
    public void setX1(Dynamic dynamic) {
        this.mX1 = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "y1")
    public void setY1(Dynamic dynamic) {
        this.mY1 = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "x2")
    public void setX2(Dynamic dynamic) {
        this.mX2 = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "y2")
    public void setY2(Dynamic dynamic) {
        this.mY2 = baq.O000000o(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.mX1);
        double relativeOnHeight = relativeOnHeight(this.mY1);
        double relativeOnWidth2 = relativeOnWidth(this.mX2);
        double relativeOnHeight2 = relativeOnHeight(this.mY2);
        path.moveTo((float) relativeOnWidth, (float) relativeOnHeight);
        path.lineTo((float) relativeOnWidth2, (float) relativeOnHeight2);
        return path;
    }
}
