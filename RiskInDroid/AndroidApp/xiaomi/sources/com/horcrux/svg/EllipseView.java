package com.horcrux.svg;

import _m_j.baq;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class EllipseView extends RenderableView {
    private baq mCx;
    private baq mCy;
    private baq mRx;
    private baq mRy;

    public EllipseView(ReactContext reactContext) {
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

    @ReactProp(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.mRx = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.mRy = baq.O000000o(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.mCx);
        double relativeOnHeight = relativeOnHeight(this.mCy);
        double relativeOnWidth2 = relativeOnWidth(this.mRx);
        double relativeOnHeight2 = relativeOnHeight(this.mRy);
        path.addOval(new RectF((float) (relativeOnWidth - relativeOnWidth2), (float) (relativeOnHeight - relativeOnHeight2), (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2)), Path.Direction.CW);
        return path;
    }
}
