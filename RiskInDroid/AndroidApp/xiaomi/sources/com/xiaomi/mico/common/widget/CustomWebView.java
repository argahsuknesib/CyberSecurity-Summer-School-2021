package com.xiaomi.mico.common.widget;

import _m_j.ahg;
import _m_j.ahh;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.mico.common.util.VersionUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Stack;

public class CustomWebView extends WebView {
    ahg loggerNew = new ahg();
    Stack<String> mHistory = new Stack<>();
    private OnScrollChangeCallback mListener;
    public WebViewClient mWebViewClient;

    public interface CustomWebViewClient {
        String getFinalUrl();
    }

    public CustomWebView(Context context) {
        super(context);
        new ahh();
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new ahh();
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.mico.common.widget.CustomWebView.AnonymousClass1 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (CustomWebView.this.mWebViewClient == null || !(CustomWebView.this.mWebViewClient instanceof CustomWebViewClient)) {
                    return false;
                }
                CustomWebView.this.addHistory(((CustomWebViewClient) CustomWebView.this.mWebViewClient).getFinalUrl());
                return false;
            }
        });
        setupWebView();
    }

    /* access modifiers changed from: protected */
    public void setupWebView() {
        WebSettings settings = getSettings();
        settings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < 19) {
            settings.setDatabasePath("/data/data/" + getContext().getPackageName() + "/databases/");
        }
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setBlockNetworkLoads(false);
        settings.setBlockNetworkImage(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setUserAgentString(buildUserAgentString(settings));
        CookieManager.getInstance().setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(2);
        }
    }

    private String buildUserAgentString(WebSettings webSettings) {
        return webSettings.getUserAgentString() + " /XiaoMi/HybridView/ micoSoundboxApp/i appVersion/A_" + VersionUtils.getVersionName(CommonApplication.getAppContext());
    }

    public void setScrollChangeCallback(OnScrollChangeCallback onScrollChangeCallback) {
        this.mListener = onScrollChangeCallback;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeCallback onScrollChangeCallback = this.mListener;
        if (onScrollChangeCallback != null) {
            onScrollChangeCallback.onScrollChange(this, i, i2, i3, i4);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        this.mWebViewClient = webViewClient;
    }

    public boolean canGoBack() {
        if (this.mHistory.size() > 0 && this.mHistory.peek().equals(getUrl())) {
            this.mHistory.pop();
        }
        return this.mHistory.size() > 0;
    }

    public boolean originalCanGoBack() {
        return super.canGoBack();
    }

    public void goBack() {
        String pop = this.mHistory.pop();
        loadUrl(pop);
        ahg.O00000Oo("load url %s", pop);
    }

    public void originalGoBack() {
        super.goBack();
    }

    public void addHistory(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mHistory.size() == 0 || !this.mHistory.peek().equals(str)) {
            this.mHistory.add(str);
            ahg.O00000Oo("add url %s", str);
        }
    }
}
