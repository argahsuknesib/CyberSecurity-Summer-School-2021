package com.mi.global.shop.ui;

import _m_j.bzu;
import _m_j.can;
import _m_j.cav;
import _m_j.cbm;
import _m_j.cbv;
import _m_j.cbw;
import _m_j.ccr;
import _m_j.cec;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.webview.BaseWebChromeClient;
import com.mi.global.shop.webview.WebViewHelper;
import com.mi.global.shop.widget.BaseWebView;
import com.mi.global.shop.widget.EmptyLoadingViewPlus;
import com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout;
import com.xiaomi.smarthome.R;

public class MainTabLazyWebFragment extends can {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f4890O000000o = "MainTabLazyWebFragment";
    protected BaseWebView O00000Oo;
    public float O00000o;
    protected ProgressBar O00000o0;
    public String O00000oO;
    public EmptyLoadingViewPlus O00000oo;
    boolean O0000O0o = false;
    boolean O0000OOo = false;
    public boolean O0000Oo;
    boolean O0000Oo0 = false;
    public SimplePullToRefreshLayout O0000OoO;
    private View O0000Ooo;
    private View O0000o0;
    private ViewStub O0000o0O;

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.O0000O0o = z;
        if (this.O0000OOo && (this.O0000O0o && (!this.O0000Oo0))) {
            try {
                this.O0000o0O.inflate();
                View view = this.O0000o0;
                this.O00000Oo = (BaseWebView) view.findViewById(R.id.browser);
                WebViewHelper.O000000o(this.O00000Oo);
                this.O00000o0 = (ProgressBar) view.findViewById(R.id.browser_progress_bar);
                this.O00000oo = (EmptyLoadingViewPlus) view.findViewById(R.id.loading);
                this.O0000OoO = (SimplePullToRefreshLayout) view.findViewById(R.id.home_fragment_pulltorefreshlayout);
                this.O0000OoO.setOnRefreshListener(new SimplePullToRefreshLayout.O00000o() {
                    /* class com.mi.global.shop.ui.MainTabLazyWebFragment.AnonymousClass1 */

                    public final void onRefresh() {
                        if (MainTabLazyWebFragment.this.O00000Oo != null) {
                            MainTabLazyWebFragment mainTabLazyWebFragment = MainTabLazyWebFragment.this;
                            mainTabLazyWebFragment.O0000Oo = true;
                            mainTabLazyWebFragment.O000000o();
                        }
                        MainTabLazyWebFragment.this.O0000OoO.O000000o();
                    }
                });
                this.O00000oo.setPullToRefreshLayout(this.O0000OoO);
                this.O00000oo.O000000o(false);
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.O00000Oo.setWebViewClient(new O000000o(this, (byte) 0));
                    this.O00000Oo.setWebChromeClient(new MainTabWebChromeClient(this, (byte) 0));
                    cbw.O000000o();
                    this.O00000oO = arguments.getString("extra_fragment_http_url");
                    this.O0000Oo = false;
                    O000000o();
                    this.O0000Ooo = getActivity().findViewById(R.id.title_mi_logo);
                    this.O0000Ooo.setVisibility(0);
                }
                this.O0000Oo0 = true;
            } catch (Exception e) {
                if (e.getMessage() == null || !e.getMessage().contains("MissingWebViewPackageException")) {
                    cec.O000000o(getContext(), getContext().getResources().getString(R.string.loading_error), 0);
                } else {
                    cec.O000000o(getContext(), getContext().getResources().getString(R.string.webview_tips_uploaing), 0);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.O00000o = O000000o(this.O00000Oo);
        bundle.putFloat("mProgressToRestore", this.O00000o);
        super.onSaveInstanceState(bundle);
        BaseWebView baseWebView = this.O00000Oo;
        if (baseWebView != null) {
            baseWebView.saveState(bundle);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.O00000o = bundle.getFloat("mProgressToRestore");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.O0000o0 = layoutInflater.inflate((int) R.layout.shop_main_tab_web_fragment_view_stub, viewGroup, false);
        this.O0000o0O = (ViewStub) this.O0000o0.findViewById(R.id.view_stub);
        return this.O0000o0;
    }

    public void onDestroy() {
        this.O00000o = O000000o(this.O00000Oo);
        BaseWebView baseWebView = this.O00000Oo;
        if (baseWebView != null) {
            baseWebView.stopLoading();
            this.O00000Oo.removeAllViews();
            this.O00000Oo.destroy();
        }
        SimplePullToRefreshLayout simplePullToRefreshLayout = this.O0000OoO;
        if (simplePullToRefreshLayout != null) {
            simplePullToRefreshLayout.removeAllViews();
            this.O0000OoO = null;
        }
        super.onDestroy();
    }

    private float O000000o(WebView webView) {
        if (this.O00000Oo == null) {
            return 0.0f;
        }
        return (((float) webView.getScrollY()) - ((float) webView.getTop())) / ((float) webView.getContentHeight());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000OOo = true;
        if (!this.O0000Oo0 && this.O0000O0o) {
            setUserVisibleHint(true);
        }
    }

    public void onRefresh() {
        BaseWebView baseWebView;
        if (isVisible() && (baseWebView = this.O00000Oo) != null) {
            baseWebView.reload();
        }
    }

    public void onResume() {
        ccr.O00000Oo(f4890O000000o, "on resume");
        super.onResume();
        ((BaseActivity) getActivity()).updateCartAndAccount();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public static MainTabLazyWebFragment O000000o(String str, String str2) {
        MainTabLazyWebFragment mainTabLazyWebFragment = new MainTabLazyWebFragment();
        Bundle bundle = new Bundle();
        bundle.putString("extra_fragment_http_url", str);
        bundle.putString("extra_fragment_provider_url", str2);
        mainTabLazyWebFragment.setArguments(bundle);
        return mainTabLazyWebFragment;
    }

    public final void O000000o() {
        BaseWebView baseWebView = this.O00000Oo;
        if (baseWebView != null) {
            baseWebView.loadUrl(this.O00000oO);
        }
    }

    @SuppressLint({"DefaultLocale"})
    class O000000o extends cbv {
        private O000000o() {
        }

        /* synthetic */ O000000o(MainTabLazyWebFragment mainTabLazyWebFragment, byte b) {
            this();
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            String[] O000000o2 = bzu.O000000o(str, true);
            if (O000000o2 == null || !MainTabLazyWebFragment.this.isAdded()) {
                return super.shouldInterceptRequest(webView, str);
            }
            return O000000o(MainTabLazyWebFragment.f4890O000000o, webView, str, O000000o2);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            ccr.O00000Oo(MainTabLazyWebFragment.f4890O000000o, "shouldOverrideUrlLoading Get URL:".concat(String.valueOf(str)));
            if (O000000o(MainTabLazyWebFragment.this.getActivity(), str) || O00000Oo(MainTabLazyWebFragment.this.getActivity(), str) || O00000o0(MainTabLazyWebFragment.this.getActivity(), str)) {
                return true;
            }
            if (str.equalsIgnoreCase(cav.O000O0oo())) {
                MainTabLazyWebFragment.this.getActivity().finish();
                return true;
            } else if (str.contains("app/category/")) {
                webView.loadUrl(str);
                return true;
            } else {
                Intent intent = new Intent(webView.getContext(), WebActivity.class);
                intent.putExtra("url", str);
                webView.getContext().startActivity(intent);
                return true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            ccr.O00000Oo(MainTabLazyWebFragment.f4890O000000o, "progress:onPageFinished,".concat(String.valueOf(str)));
            if (!MainTabLazyWebFragment.this.O0000Oo && cbm.O00000Oo.O000000o(MainTabLazyWebFragment.this.getActivity())) {
                MainTabLazyWebFragment mainTabLazyWebFragment = MainTabLazyWebFragment.this;
                mainTabLazyWebFragment.O0000Oo = true;
                mainTabLazyWebFragment.O00000Oo.loadUrl(MainTabLazyWebFragment.this.O00000oO);
                String str2 = MainTabLazyWebFragment.f4890O000000o;
                ccr.O00000Oo(str2, "mWebView.getUrl():" + MainTabLazyWebFragment.this.O00000Oo.getUrl());
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            ccr.O00000Oo(MainTabLazyWebFragment.f4890O000000o, "failingUrl:".concat(String.valueOf(str2)));
        }
    }

    class MainTabWebChromeClient extends BaseWebChromeClient {
        private MainTabWebChromeClient() {
        }

        /* synthetic */ MainTabWebChromeClient(MainTabLazyWebFragment mainTabLazyWebFragment, byte b) {
            this();
        }

        public void onProgressChanged(WebView webView, int i) {
            if (MainTabLazyWebFragment.this.O00000oo != null && i >= 80) {
                MainTabLazyWebFragment.this.O00000oo.O000000o();
                MainTabLazyWebFragment.this.O00000oo.O00000Oo();
                ccr.O00000Oo(MainTabLazyWebFragment.f4890O000000o, String.valueOf(i));
            }
        }
    }
}
