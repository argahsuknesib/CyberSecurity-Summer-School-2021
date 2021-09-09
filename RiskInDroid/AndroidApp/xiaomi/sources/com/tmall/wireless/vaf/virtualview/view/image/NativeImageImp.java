package com.tmall.wireless.vaf.virtualview.view.image;

import _m_j.dox;
import _m_j.dpb;
import _m_j.dpc;
import _m_j.dpf;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class NativeImageImp extends ImageView implements dpb, dpc {
    protected dpf mVirtualView;

    public void attachViews() {
    }

    public void destroy() {
    }

    public View getHolderView() {
        return this;
    }

    public int getType() {
        return -1;
    }

    public NativeImageImp(Context context) {
        super(context);
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

    public void setVirtualView(dpf dpf) {
        this.mVirtualView = dpf;
        dpf.O00000Oo((View) this);
        new dox(this);
    }

    public dpf getVirtualView() {
        return this.mVirtualView;
    }
}
