package com.xiaomi.smarthome.library.common.widget;

import _m_j.gpo;
import _m_j.gqq;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.xiaomi.smarthome.R;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public class SmartHomePtrHeader extends FrameLayout implements PtrUIHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f9257O000000o;
    private boolean O00000Oo = false;
    private LottieAnimationView O00000o;
    private TextView O00000o0;
    private final gqq O00000oO = new gqq();

    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
    }

    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
    }

    public SmartHomePtrHeader(Context context) {
        super(context);
        O000000o(null);
    }

    public SmartHomePtrHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public SmartHomePtrHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.use_white}).recycle();
        }
        this.f9257O000000o = LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pull_header, (ViewGroup) null);
        this.O00000o0 = (TextView) this.f9257O000000o.findViewById(R.id.pull_header_txt);
        this.O00000o = (LottieAnimationView) this.f9257O000000o.findViewById(R.id.pull_animation);
        addView(this.f9257O000000o);
        O000000o();
    }

    private void O000000o() {
        View view = this.f9257O000000o;
        if (view != null) {
            view.setBackgroundResource(R.color.mj_color_black_00_transparent);
            this.O00000Oo = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent != null) {
            ((PtrFrameLayout) parent).addPtrUIHandler(this);
        }
    }

    public void setLastUpdateTimeKey(String str) {
        if (TextUtils.isEmpty(str)) {
        }
    }

    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
        this.O00000o0.setVisibility(0);
        this.O00000o.setVisibility(0);
        gpo.O000000o(this.O00000o);
    }

    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        this.O00000o0.setVisibility(0);
        this.O00000o.setVisibility(0);
        gpo.O000000o(this.O00000o);
    }

    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, PtrIndicator ptrIndicator) {
        this.O00000oO.onUIPositionChange(ptrFrameLayout, z, b, ptrIndicator);
        this.O00000o0.setVisibility(0);
        this.O00000o.setVisibility(0);
        if (z && ptrIndicator.getCurrentPosY() > 0) {
            gpo.O000000o(this.O00000o);
        }
        if (ptrIndicator.getCurrentPosY() == 0) {
            gpo.O00000Oo(this.O00000o);
        }
    }
}
