package _m_j;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStackHeaderConfig;

@SuppressLint({"ValidFragment"})
public final class dfz extends dfy {
    private static final float O00000Oo = PixelUtil.toPixelFromDIP(4.0f);
    private Toolbar O00000o;
    private AppBarLayout O00000o0;
    private boolean O00000oO;

    @SuppressLint({"ValidFragment"})
    public dfz(Screen screen) {
        super(screen);
    }

    public final void O00000Oo() {
        if (this.O00000o0 != null) {
            ((CoordinatorLayout) getView()).removeView(this.O00000o0);
        }
    }

    public final void O000000o(Toolbar toolbar) {
        AppBarLayout appBarLayout = this.O00000o0;
        if (appBarLayout != null) {
            appBarLayout.addView(toolbar);
        }
        this.O00000o = toolbar;
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        this.O00000o.setLayoutParams(layoutParams);
    }

    public final void O000000o(boolean z) {
        if (this.O00000oO != z) {
            this.O00000o0.setTargetElevation(z ? 0.0f : O00000Oo);
            this.O00000oO = z;
        }
    }

    public final void O00000o0() {
        View childAt = this.f14592O000000o.getChildAt(0);
        if (childAt instanceof ScreenStackHeaderConfig) {
            ((ScreenStackHeaderConfig) childAt).O000000o();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CoordinatorLayout coordinatorLayout = new CoordinatorLayout(getContext());
        CoordinatorLayout.O00000o o00000o = new CoordinatorLayout.O00000o(-1, -1);
        o00000o.O000000o(new AppBarLayout.ScrollingViewBehavior());
        this.f14592O000000o.setLayoutParams(o00000o);
        coordinatorLayout.addView(this.f14592O000000o);
        this.O00000o0 = new AppBarLayout(getContext());
        this.O00000o0.setBackgroundColor(0);
        this.O00000o0.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
        coordinatorLayout.addView(this.O00000o0);
        Toolbar toolbar = this.O00000o;
        if (toolbar != null) {
            this.O00000o0.addView(toolbar);
        }
        return coordinatorLayout;
    }

    public final boolean O00000o() {
        View childAt = this.f14592O000000o.getChildAt(0);
        if (childAt instanceof ScreenStackHeaderConfig) {
            return ((ScreenStackHeaderConfig) childAt).O00000Oo;
        }
        return true;
    }
}
