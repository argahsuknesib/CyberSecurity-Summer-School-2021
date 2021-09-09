package com.mi.global.shop.ui;

import _m_j.bzu;
import _m_j.cao;
import _m_j.cav;
import _m_j.cbm;
import _m_j.cbv;
import _m_j.cbw;
import _m_j.cce;
import _m_j.ccr;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.webview.BaseWebChromeClient;
import com.mi.global.shop.widget.EmptyLoadingViewPlus;
import com.mi.global.shop.widget.ptr.PtrClassicFrameLayout;
import com.xiaomi.smarthome.R;

public class MainTabWebFragment extends cao {
    public static final String O00000o = "MainTabWebFragment";
    public String O00000oO;
    public EmptyLoadingViewPlus O00000oo;
    public boolean O0000O0o;
    public PtrClassicFrameLayout O0000OOo;
    private View O0000Oo0;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.O00000oo = (EmptyLoadingViewPlus) onCreateView.findViewById(R.id.loading);
        this.O0000OOo = (PtrClassicFrameLayout) onCreateView.findViewById(R.id.home_fragment_pulltorefreshlayout);
        this.O0000OOo.setInterceptEventWhileWorking(true);
        this.O0000OOo.setPtrHandler(new cce() {
            /* class com.mi.global.shop.ui.MainTabWebFragment.AnonymousClass1 */

            public final void O000000o() {
                if (MainTabWebFragment.this.f13527O000000o != null) {
                    MainTabWebFragment mainTabWebFragment = MainTabWebFragment.this;
                    mainTabWebFragment.O0000O0o = true;
                    mainTabWebFragment.O000000o();
                }
            }

            public final boolean O00000Oo() {
                if (MainTabWebFragment.this.f13527O000000o.getVisibility() != 0 || MainTabWebFragment.this.f13527O000000o.getScrollY() == 0) {
                    return true;
                }
                return false;
            }
        });
        this.O00000oo.setPullToRefreshLayout(this.O0000OOo);
        this.O00000oo.O000000o(false);
        return onCreateView;
    }

    public void onRefresh() {
        if (isVisible() && this.f13527O000000o != null) {
            this.f13527O000000o.reload();
        }
    }

    public void onResume() {
        ccr.O00000Oo(O00000o, "on resume");
        super.onResume();
        ((BaseActivity) getActivity()).updateCartAndAccount();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13527O000000o.setWebViewClient(new O000000o(this, (byte) 0));
            this.f13527O000000o.setWebChromeClient(new MainTabWebChromeClient(this, (byte) 0));
            cbw.O000000o();
            this.O00000oO = arguments.getString("extra_fragment_http_url");
            this.O0000O0o = false;
            O000000o();
            this.O0000Oo0 = getActivity().findViewById(R.id.title_mi_logo);
            this.O0000Oo0.setVisibility(0);
        }
    }

    public final void O000000o() {
        this.f13527O000000o.loadUrl(this.O00000oO);
        String str = O00000o;
        ccr.O00000Oo(str, "mWebView.getUrl():" + this.f13527O000000o.getUrl());
    }

    @SuppressLint({"DefaultLocale"})
    class O000000o extends cbv {
        private O000000o() {
        }

        /* synthetic */ O000000o(MainTabWebFragment mainTabWebFragment, byte b) {
            this();
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            String[] O000000o2 = bzu.O000000o(str, true);
            if (O000000o2 == null || !MainTabWebFragment.this.isAdded()) {
                return super.shouldInterceptRequest(webView, str);
            }
            return O000000o(MainTabWebFragment.O00000o, webView, str, O000000o2);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            ccr.O00000Oo(MainTabWebFragment.O00000o, "shouldOverrideUrlLoading Get URL:".concat(String.valueOf(str)));
            if (O000000o(MainTabWebFragment.this.getActivity(), str) || O00000Oo(MainTabWebFragment.this.getActivity(), str) || O00000o0(MainTabWebFragment.this.getActivity(), str)) {
                return true;
            }
            if (str.equalsIgnoreCase(cav.O000O0oo())) {
                MainTabWebFragment.this.getActivity().finish();
                return true;
            }
            Intent intent = new Intent(webView.getContext(), WebActivity.class);
            intent.putExtra("url", str);
            webView.getContext().startActivity(intent);
            return true;
        }

        public final void onPageFinished(WebView webView, String str) {
            ccr.O00000Oo(MainTabWebFragment.O00000o, "progress:onPageFinished,".concat(String.valueOf(str)));
            if (!MainTabWebFragment.this.O0000O0o && cbm.O00000Oo.O000000o(MainTabWebFragment.this.getActivity())) {
                MainTabWebFragment mainTabWebFragment = MainTabWebFragment.this;
                mainTabWebFragment.O0000O0o = true;
                mainTabWebFragment.f13527O000000o.loadUrl(MainTabWebFragment.this.O00000oO);
                String str2 = MainTabWebFragment.O00000o;
                ccr.O00000Oo(str2, "mWebView.getUrl():" + MainTabWebFragment.this.f13527O000000o.getUrl());
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            ccr.O00000Oo(MainTabWebFragment.O00000o, "failingUrl:".concat(String.valueOf(str2)));
        }
    }

    class MainTabWebChromeClient extends BaseWebChromeClient {
        private MainTabWebChromeClient() {
        }

        /* synthetic */ MainTabWebChromeClient(MainTabWebFragment mainTabWebFragment, byte b) {
            this();
        }

        public void onProgressChanged(WebView webView, int i) {
            if (MainTabWebFragment.this.O00000oo != null && i >= 80) {
                MainTabWebFragment.this.O00000oo.O000000o();
                MainTabWebFragment.this.O00000oo.O00000Oo();
                ccr.O00000Oo(MainTabWebFragment.O00000o, String.valueOf(i));
            }
        }
    }
}
