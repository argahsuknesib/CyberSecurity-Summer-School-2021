package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.titles;

import _m_j.hhv;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class CommonPagerTitleView extends FrameLayout implements hhv {

    /* renamed from: O000000o  reason: collision with root package name */
    private O00000Oo f10353O000000o;
    private O000000o O00000Oo;

    public interface O000000o {
        int O000000o();

        int O00000Oo();

        int O00000o();

        int O00000o0();
    }

    public interface O00000Oo {
    }

    public void onDeselected(int i, int i2) {
    }

    public void onEnter(int i, int i2, float f, boolean z) {
    }

    public void onLeave(int i, int i2, float f, boolean z) {
    }

    public void onSelected(int i, int i2) {
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    public int getContentLeft() {
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            return o000000o.O000000o();
        }
        return getLeft();
    }

    public int getContentTop() {
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            return o000000o.O00000Oo();
        }
        return getTop();
    }

    public int getContentRight() {
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            return o000000o.O00000o0();
        }
        return getRight();
    }

    public int getContentBottom() {
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            return o000000o.O00000o();
        }
        return getBottom();
    }

    public void setContentView(View view) {
        setContentView$7972f4c4(view);
    }

    private void setContentView$7972f4c4(View view) {
        removeAllViews();
        if (view != null) {
            addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setContentView(int i) {
        setContentView$7972f4c4(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public O00000Oo getOnPagerTitleChangeListener() {
        return this.f10353O000000o;
    }

    public void setOnPagerTitleChangeListener(O00000Oo o00000Oo) {
        this.f10353O000000o = o00000Oo;
    }

    public O000000o getContentPositionDataProvider() {
        return this.O00000Oo;
    }

    public void setContentPositionDataProvider(O000000o o000000o) {
        this.O00000Oo = o000000o;
    }
}
