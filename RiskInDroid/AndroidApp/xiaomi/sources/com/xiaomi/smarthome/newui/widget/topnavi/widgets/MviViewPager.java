package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.ayk;
import _m_j.ayl;
import _m_j.ayq;
import _m_j.ays;
import _m_j.itz;
import _m_j.iua;
import _m_j.ixc;
import _m_j.ixe;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0002\b\u0003\u0018\u00010\u00042\u00020\u00052\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0006B\u001b\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0014\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0015J\r\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\f\u001a\u00020\rH\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0017J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MviViewPager;", "V", "Lcom/hannesdorfmann/mosby3/mvp/MvpView;", "P", "Lcom/hannesdorfmann/mosby3/mvi/MviPresenter;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/EditableViewPager;", "Lcom/hannesdorfmann/mosby3/ViewGroupMviDelegateCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isRestoringViewState", "", "mvpDelegate", "Lcom/hannesdorfmann/mosby3/ViewGroupMviDelegate;", "getMvpDelegate", "()Lcom/hannesdorfmann/mosby3/ViewGroupMviDelegate;", "mvpDelegate$delegate", "Lkotlin/Lazy;", "createPresenter", "()Lcom/hannesdorfmann/mosby3/mvi/MviPresenter;", "getMvpView", "()Lcom/hannesdorfmann/mosby3/mvp/MvpView;", "onAttachedToWindow", "", "onDetachedFromWindow", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "setRestoringViewState", "restoringViewState", "superOnRestoreInstanceState", "superOnSaveInstanceState", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class MviViewPager<V extends ays, P extends ayq<V, ?>> extends EditableViewPager implements ayl<V, P>, ays {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f10369O000000o;
    private final itz O00000Oo;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MviViewPager(Context context) {
        this(context, null, 2, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MviViewPager(Context context, AttributeSet attributeSet, int i, ixc ixc) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MviViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ixe.O00000o(context, "context");
        this.O00000Oo = iua.O000000o(new MviViewPager$mvpDelegate$2(this));
    }

    private final ayk<V, P> getMvpDelegate() {
        return (ayk) this.O00000Oo.O000000o();
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
        ixe.O00000o(parcelable, "state");
        getMvpDelegate().O000000o(parcelable);
    }

    public V getMvpView() {
        return this;
    }

    public final Parcelable m_() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        ixe.O000000o(onSaveInstanceState);
        return onSaveInstanceState;
    }

    public final void O000000o(Parcelable parcelable) {
        ixe.O00000o(parcelable, "state");
        super.onRestoreInstanceState(parcelable);
    }

    public void setRestoringViewState(boolean z) {
        this.f10369O000000o = z;
    }
}
