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
import android.widget.LinearLayout;

public abstract class MviLinearLayout<V extends ays, P extends ayq<V, ?>> extends LinearLayout implements ayl<V, P>, ays {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ayk<V, P> f4335O000000o;
    private boolean O00000Oo = false;

    public V getMvpView() {
        return this;
    }

    public MviLinearLayout(Context context) {
        super(context);
    }

    public MviLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MviLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public ayk<V, P> getMvpDelegate() {
        if (this.f4335O000000o == null) {
            this.f4335O000000o = new aym(this, this);
        }
        return this.f4335O000000o;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMvpDelegate().O000000o();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMvpDelegate().O00000Oo();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"MissingSuperCall"})
    public Parcelable onSaveInstanceState() {
        return getMvpDelegate().O00000o0();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"MissingSuperCall"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        getMvpDelegate().O000000o(parcelable);
    }

    public void setRestoringViewState(boolean z) {
        this.O00000Oo = z;
    }
}
