package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.mi.global.shop.widget.ptr.PtrClassicFrameLayout;
import com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout;
import java.lang.ref.WeakReference;

public class EmptyLoadingViewPlus extends EmptyLoadingView {
    public WeakReference<SimplePullToRefreshLayout> O0000Oo;
    public WeakReference<PtrClassicFrameLayout> O0000Oo0;

    public EmptyLoadingViewPlus(Context context) {
        super(context);
        this.O0000O0o = true;
    }

    public EmptyLoadingViewPlus(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000O0o = true;
    }

    public final void O000000o(boolean z) {
        super.O000000o(z);
        if (z) {
            this.f4954O000000o.setVisibility(8);
        } else {
            this.f4954O000000o.setVisibility(0);
        }
    }

    public final void O00000Oo() {
        SimplePullToRefreshLayout simplePullToRefreshLayout;
        PtrClassicFrameLayout ptrClassicFrameLayout;
        if (this.O0000Oo0 != null || this.O0000Oo != null) {
            WeakReference<PtrClassicFrameLayout> weakReference = this.O0000Oo0;
            if (!(weakReference == null || (ptrClassicFrameLayout = weakReference.get()) == null)) {
                ptrClassicFrameLayout.O00000o0();
            }
            WeakReference<SimplePullToRefreshLayout> weakReference2 = this.O0000Oo;
            if (weakReference2 != null && (simplePullToRefreshLayout = weakReference2.get()) != null) {
                simplePullToRefreshLayout.O000000o();
            }
        }
    }

    public void setPullToRefreshLayout(PtrClassicFrameLayout ptrClassicFrameLayout) {
        this.O0000Oo0 = new WeakReference<>(ptrClassicFrameLayout);
    }

    public void setPullToRefreshLayout(SimplePullToRefreshLayout simplePullToRefreshLayout) {
        this.O0000Oo = new WeakReference<>(simplePullToRefreshLayout);
    }
}
