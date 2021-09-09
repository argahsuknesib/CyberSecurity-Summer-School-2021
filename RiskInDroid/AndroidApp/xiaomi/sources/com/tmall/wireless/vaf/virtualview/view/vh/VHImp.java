package com.tmall.wireless.vaf.virtualview.view.vh;

import _m_j.dpb;
import _m_j.dpc;
import _m_j.dpf;
import android.content.Context;
import android.view.View;

public class VHImp extends VHView implements dpb, dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dpf f5899O000000o;

    public void attachViews() {
    }

    public View getHolderView() {
        return null;
    }

    public int getType() {
        return -1;
    }

    public VHImp(Context context) {
        super(context);
    }

    public void setVirtualView(dpf dpf) {
        this.f5899O000000o = dpf;
    }

    public dpf getVirtualView() {
        return this.f5899O000000o;
    }

    public void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
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
}
