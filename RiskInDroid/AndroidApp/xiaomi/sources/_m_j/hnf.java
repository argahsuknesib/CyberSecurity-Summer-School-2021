package _m_j;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.operation.js_sdk.statistics.WebViewDurationStatManager;
import in.srain.cube.views.ptr.PtrFrameLayout;

public final class hnf extends hke implements TabLayout.OnTabSelectedListener {

    /* renamed from: O000000o  reason: collision with root package name */
    ViewGroup f19068O000000o;
    PtrFrameLayout O00000Oo;
    private long O00000o = 0;
    private boolean O00000o0;
    private boolean O00000oO = false;

    public static hnf O000000o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg_url", str);
        bundle.putString("arg_title", str2);
        bundle.putBoolean("arg_use_title_bar", false);
        hnf hnf = new hnf();
        hnf.setArguments(bundle);
        return hnf;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f19068O000000o = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
        this.O00000Oo = (PtrFrameLayout) this.f19068O000000o.findViewById(R.id.pull_down_refresh);
        if (this.O00000o0) {
            this.O00000Oo.requestDisallowInterceptTouchEvent(true);
            this.O00000Oo.setEnabled(false);
        }
        return onCreateView;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        try {
            getActivity().getLifecycle().O000000o(O000000o());
        } catch (Exception unused) {
        }
    }

    public final void init() {
        super.init();
        getWebView().setFixHorizontalSwipe(true);
        if (Build.VERSION.SDK_INT >= 29) {
            getWebView().getSettings().setForceDark(0);
        }
    }

    public final void onResume() {
        super.onResume();
        hxp hxp = hxi.O00000o0;
        String O0000OOo = ggb.O00000Oo().O0000OOo();
        hxp.f957O000000o.O000000o("scene_favorite_show", "homeid", O0000OOo);
        if (this.mPageSelected) {
            O000000o(true);
        }
    }

    public final void onPause() {
        super.onPause();
        if (this.mPageSelected) {
            O000000o(false);
        }
    }

    public final void onPageDeselected() {
        super.onPageDeselected();
        this.O00000o0 = false;
        O000000o(false);
    }

    public final void onPageSelected() {
        super.onPageSelected();
        this.O00000o0 = true;
        hxk hxk = hxi.O00000o;
        String O0000OOo = ggb.O00000Oo().O0000OOo();
        hxk.f952O000000o.O000000o("scene_favorite_click", "homeid", O0000OOo);
        PtrFrameLayout ptrFrameLayout = this.O00000Oo;
        if (ptrFrameLayout != null) {
            ptrFrameLayout.requestDisallowInterceptTouchEvent(true);
            this.O00000Oo.setEnabled(false);
        }
        O000000o(true);
    }

    private void O000000o(boolean z) {
        if (z) {
            this.O00000o = hxi.O00000o0.O00000Oo(0L);
        } else if (this.O00000o > 0) {
            hxi.O00000o0.O00000Oo(this.O00000o);
            this.O00000o = 0;
        }
    }

    public final void onTabSelected(TabLayout.Tab tab) {
        if (!this.O00000oO) {
            O00000Oo(true);
        }
        this.O00000oO = true;
        gsy.O00000Oo("ChoicenessFragment", "onTabSelected: ");
    }

    public final void onTabUnselected(TabLayout.Tab tab) {
        gsy.O00000Oo("ChoicenessFragment", "onTabUnselected: ");
        this.O00000oO = false;
        O00000Oo(false);
    }

    public final void onTabReselected(TabLayout.Tab tab) {
        gsy.O000000o(3, "ChoicenessFragment", "onTabReselected: ");
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!this.O00000oO) {
            return;
        }
        if (z) {
            gsy.O00000Oo("ChoicenessFragment", "setUserVisibleHint: ");
            O00000Oo(true);
            return;
        }
        O00000Oo(false);
    }

    private void O00000Oo(boolean z) {
        WebViewDurationStatManager O000000o2 = O000000o();
        if (O000000o2 != null) {
            O000000o2.O000000o(z);
        }
    }

    private WebViewDurationStatManager O000000o() {
        try {
            return WebViewDurationStatManager.O000000o(getActivity());
        } catch (Exception unused) {
            return null;
        }
    }
}
