package com.xiaomi.smarthome.newui.mainpage;

import _m_j.ayk;
import _m_j.ayl;
import _m_j.aym;
import _m_j.ayq;
import _m_j.ays;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

public abstract class MviRecyclerView<V extends ays, P extends ayq<V, ?>> extends RecyclerView implements ayl<V, P>, ays {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f10245O000000o = false;
    protected ayk<V, P> O00000oO;

    public V getMvpView() {
        return this;
    }

    public MviRecyclerView(Context context) {
        super(context);
    }

    public MviRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MviRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public ayk<V, P> getMvpDelegate() {
        if (this.O00000oO == null) {
            this.O00000oO = new aym(this, this);
        }
        return this.O00000oO;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMvpDelegate().O000000o();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMvpDelegate().O00000Oo();
    }

    @SuppressLint({"MissingSuperCall"})
    public Parcelable onSaveInstanceState() {
        return getMvpDelegate().O00000o0();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        getMvpDelegate().O000000o(parcelable);
    }

    public final Parcelable m_() {
        return super.onSaveInstanceState();
    }

    public final void O000000o(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    public void setRestoringViewState(boolean z) {
        this.f10245O000000o = z;
    }
}
