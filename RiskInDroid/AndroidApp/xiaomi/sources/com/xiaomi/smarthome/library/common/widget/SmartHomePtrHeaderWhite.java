package com.xiaomi.smarthome.library.common.widget;

import _m_j.gqq;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public class SmartHomePtrHeaderWhite extends FrameLayout implements PtrUIHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f9258O000000o;
    private ImageView O00000Oo;
    private View O00000o;
    private ProgressBar O00000o0;
    private String O00000oO;
    private Animation O00000oo;
    private Animation O0000O0o;
    private boolean O0000OOo = false;
    private gqq O0000Oo0 = new gqq();

    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
    }

    public SmartHomePtrHeaderWhite(Context context) {
        super(context);
        O000000o(null);
    }

    public SmartHomePtrHeaderWhite(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public SmartHomePtrHeaderWhite(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.use_white});
            obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        this.O00000o = LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pull_header_ptr_white, (ViewGroup) null);
        this.f9258O000000o = (TextView) this.O00000o.findViewById(R.id.pull_header_txt);
        this.O00000Oo = (ImageView) this.O00000o.findViewById(R.id.pull_header_indc);
        this.O00000o0 = (ProgressBar) this.O00000o.findViewById(R.id.pull_header_prog);
        addView(this.O00000o);
        O000000o();
    }

    private void O000000o() {
        View view = this.O00000o;
        if (view != null) {
            view.setBackgroundResource(R.color.mj_color_black_00_transparent);
            this.O00000o0.setVisibility(4);
            this.O00000Oo.setVisibility(0);
            this.f9258O000000o.setVisibility(0);
            this.O0000OOo = false;
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
        if (!TextUtils.isEmpty(str)) {
            this.O00000oO = str;
        }
    }

    public void setLastUpdateTimeRelateObject(Object obj) {
        setLastUpdateTimeKey(obj.getClass().getName());
    }

    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
        if (!this.O0000OOo) {
            this.O00000o0.setVisibility(4);
            this.O00000Oo.setVisibility(0);
            this.f9258O000000o.setVisibility(0);
            this.f9258O000000o.setText(getResources().getString(R.string.pull_down_refresh));
        }
    }

    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        if (!this.O0000OOo) {
            this.O00000o0.setVisibility(0);
            this.f9258O000000o.setVisibility(0);
            this.f9258O000000o.setText((int) R.string.refreshing);
            this.O00000Oo.setVisibility(8);
        }
        this.O00000Oo.clearAnimation();
    }

    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        if (!this.O0000OOo) {
            this.O00000o0.setVisibility(4);
            this.O00000Oo.setVisibility(0);
            this.f9258O000000o.setVisibility(0);
            this.f9258O000000o.setText(getResources().getString(R.string.refresh_complete));
        }
    }

    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, PtrIndicator ptrIndicator) {
        this.O0000Oo0.onUIPositionChange(ptrFrameLayout, z, b, ptrIndicator);
        int offsetToRefresh = ptrFrameLayout.getOffsetToRefresh();
        int currentPosY = ptrIndicator.getCurrentPosY();
        int lastPosY = ptrIndicator.getLastPosY();
        if (currentPosY >= offsetToRefresh || lastPosY < offsetToRefresh) {
            if (currentPosY > offsetToRefresh && lastPosY <= offsetToRefresh && z && b == 2) {
                if (!ptrFrameLayout.isPullToRefresh()) {
                    if (!this.O0000OOo) {
                        this.f9258O000000o.setVisibility(0);
                    }
                    this.f9258O000000o.setText((int) R.string.release_to_refresh);
                }
                if (this.O0000O0o == null) {
                    this.O0000O0o = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_180);
                    this.O0000O0o.setFillAfter(true);
                }
                this.O00000Oo.startAnimation(this.O0000O0o);
            }
        } else if (z && b == 2) {
            if (!this.O0000OOo) {
                this.f9258O000000o.setVisibility(0);
            }
            this.f9258O000000o.setText(getResources().getString(R.string.pull_down_refresh));
            if (this.O00000oo == null) {
                this.O00000oo = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_back_180);
                this.O00000oo.setFillAfter(true);
            }
            this.O00000Oo.startAnimation(this.O00000oo);
        }
    }

    public void setProgressBarDrawable(Drawable drawable) {
        this.O00000o0.setIndeterminateDrawable(drawable);
    }

    public void setRefreshArrow(int i) {
        this.O00000Oo.setBackgroundResource(i);
    }

    public void setHeaderTextColor(int i) {
        this.f9258O000000o.setTextColor(i);
    }
}
