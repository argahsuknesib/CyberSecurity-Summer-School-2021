package com.tmall.wireless.vaf.virtualview.view.text;

import _m_j.dov;
import _m_j.dpc;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

public class NativeTextImp extends TextView implements dpc {
    private int mBackgroundColor = 0;
    private int mBorderBottomLeftRadius = 0;
    private int mBorderBottomRightRadius = 0;
    private int mBorderColor = -16777216;
    private int mBorderTopLeftRadius = 0;
    private int mBorderTopRightRadius = 0;
    private int mBorderWidth = 0;

    public NativeTextImp(Context context) {
        super(context);
        getPaint().setAntiAlias(true);
    }

    public void setBorderTopLeftRadius(int i) {
        this.mBorderTopLeftRadius = i;
    }

    public void setBorderTopRightRadius(int i) {
        this.mBorderTopRightRadius = i;
    }

    public void setBorderBottomLeftRadius(int i) {
        this.mBorderBottomLeftRadius = i;
    }

    public void setBorderBottomRightRadius(int i) {
        this.mBorderBottomRightRadius = i;
    }

    public void setBorderWidth(int i) {
        this.mBorderWidth = i;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.mBackgroundColor;
        if (i != 0) {
            dov.O00000Oo(canvas, i, canvas.getWidth(), canvas.getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        }
        super.onDraw(canvas);
        dov.O000000o(canvas, this.mBorderColor, canvas.getWidth(), canvas.getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }

    public void onComMeasure(int i, int i2) {
        onMeasure(i, i2);
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayout(z, i, i2, i3, i4);
    }

    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    public void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }
}
