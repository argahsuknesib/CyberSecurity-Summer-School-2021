package com.horcrux.svg;

import _m_j.bao;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class PathView extends RenderableView {
    private Path mPath;

    public PathView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "d")
    public void setD(String str) {
        bao.O000000o o000000o = new bao.O000000o(str, this.mScale);
        o000000o.O00000o = new Path();
        o000000o.O0000O0o = Arguments.createArray();
        o000000o.O00000o0 = bao.O000000o.f12750O000000o.matcher(bao.O000000o.O00000Oo.matcher(o000000o.O00000oO).replaceAll("$1,"));
        while (o000000o.O00000o0.find() && o000000o.O00000oo) {
            o000000o.O000000o(o000000o.O00000o0.group());
        }
        this.mPath = o000000o.O00000o;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }
}
