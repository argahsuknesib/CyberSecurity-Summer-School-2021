package com.hannesdorfmann.mosby3.mvi.layout;

import _m_j.ayk;
import _m_j.ayl;
import _m_j.aym;
import _m_j.ayq;
import _m_j.ays;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class MviFrameLayout<V extends ays, P extends ayq<V, ?>> extends FrameLayout implements ayl<V, P>, ays {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ayk<V, P> f4334O000000o;
    private boolean O00000Oo = false;

    public V getMvpView() {
        return this;
    }

    public MviFrameLayout(Context context) {
        super(context);
    }

    public MviFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MviFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public ayk<V, P> getMviDelegate() {
        if (this.f4334O000000o == null) {
            this.f4334O000000o = new aym(this, this);
        }
        return this.f4334O000000o;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMviDelegate().O000000o();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMviDelegate().O00000Oo();
    }

    @SuppressLint({"MissingSuperCall"})
    public Parcelable onSaveInstanceState() {
        return getMviDelegate().O00000o0();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        getMviDelegate().O000000o(parcelable);
    }

    public void setRestoringViewState(boolean z) {
        this.O00000Oo = z;
    }
}
