package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/EditableViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interceptScroll", "", "getInterceptScroll", "()Z", "setInterceptScroll", "(Z)V", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class EditableViewPager extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f10366O000000o;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditableViewPager(Context context) {
        this(context, null, 2, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditableViewPager(Context context, AttributeSet attributeSet, int i, ixc ixc) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final boolean getInterceptScroll() {
        return this.f10366O000000o;
    }

    public final void setInterceptScroll(boolean z) {
        this.f10366O000000o = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ixe.O00000o(motionEvent, "ev");
        return !this.f10366O000000o && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ixe.O00000o(motionEvent, "ev");
        try {
            return !this.f10366O000000o && super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }
}
