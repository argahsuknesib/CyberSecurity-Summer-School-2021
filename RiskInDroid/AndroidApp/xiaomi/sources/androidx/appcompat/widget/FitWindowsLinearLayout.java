package androidx.appcompat.widget;

import _m_j.OOo000;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements OOo000 {

    /* renamed from: O000000o  reason: collision with root package name */
    private OOo000.O000000o f2719O000000o;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(OOo000.O000000o o000000o) {
        this.f2719O000000o = o000000o;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        OOo000.O000000o o000000o = this.f2719O000000o;
        if (o000000o != null) {
            o000000o.O000000o(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
