package com.mi.global.shop.webview;

import _m_j.byl;
import _m_j.cad;
import _m_j.cbc;
import _m_j.cbm;
import _m_j.ccn;
import _m_j.ccr;
import _m_j.cdw;
import _m_j.cek;
import _m_j.cem;
import _m_j.cen;
import _m_j.cpf;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.user.FeedbackActivity;
import com.mi.util.Device;
import java.io.File;

public final class WebViewHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f4936O000000o;

    public static void O000000o(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setTextZoom(100);
            settings.setCacheMode(-1);
            String userAgentString = settings.getUserAgentString();
            settings.setUserAgentString(userAgentString + " XiaoMi/GlobalShop/" + Device.O0000oO);
            settings.setUseWideViewPort(true);
            settings.setTextZoom(100);
            if (cad.O0000OoO()) {
                settings.setUseWideViewPort(false);
            }
            WebSettings settings2 = webView.getSettings();
            settings2.setAppCacheEnabled(true);
            String path = webView.getContext().getApplicationContext().getDir("cache", 0).getPath();
            cpf.O000000o((Object) "app cacheDir:".concat(String.valueOf(path)));
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            settings2.setAppCachePath(path);
            WebSettings settings3 = webView.getSettings();
            settings3.setDomStorageEnabled(true);
            settings3.setDatabaseEnabled(true);
            String path2 = webView.getContext().getApplicationContext().getDir("database", 0).getPath();
            cpf.O000000o((Object) "dom storageDir:".concat(String.valueOf(path2)));
            settings3.setDatabasePath(path2);
            settings.setBuiltInZoomControls(false);
            webView.addJavascriptInterface(new WebEvent(webView), "WE");
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            }
        }
    }

    static class WebEvent {
        WebView mWebView;

        WebEvent(WebView webView) {
            this.mWebView = webView;
        }

        @JavascriptInterface
        public void logHTML(String str) {
            ccr.O00000Oo("WebActivity", "html:".concat(String.valueOf(str)));
        }

        @JavascriptInterface
        public void reload() {
            this.mWebView.post(new Runnable() {
                /* class com.mi.global.shop.webview.WebViewHelper.WebEvent.AnonymousClass1 */

                public final void run() {
                    WebEvent.this.mWebView.goBack();
                    WebEvent.this.mWebView.reload();
                }
            });
        }

        @JavascriptInterface
        public void reload2() {
            this.mWebView.post(new Runnable() {
                /* class com.mi.global.shop.webview.WebViewHelper.WebEvent.AnonymousClass2 */

                public final void run() {
                    WebEvent.this.mWebView.reload();
                }
            });
        }

        @JavascriptInterface
        public void logout() {
            ccn.O0000o00().O0000Oo();
        }

        @JavascriptInterface
        public void login() {
            if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                ((BaseActivity) this.mWebView.getContext()).gotoAccount();
            } else {
                byl.O00000Oo();
            }
        }

        @JavascriptInterface
        public void updateCart(final int i) {
            ccr.O00000Oo("WebViewHelper", "update cart from js:".concat(String.valueOf(i)));
            if (!this.mWebView.getContext().getClass().equals(WebActivity.class)) {
                ccr.O00000Oo("WebViewHelper", "ignore update cart from " + this.mWebView.getContext().getClass().getName());
                return;
            }
            ((BaseActivity) this.mWebView.getContext()).runOnUiThread(new Runnable() {
                /* class com.mi.global.shop.webview.WebViewHelper.WebEvent.AnonymousClass3 */

                public final void run() {
                    ((BaseActivity) WebEvent.this.mWebView.getContext()).updateShoppingCart(i);
                }
            });
        }

        @JavascriptInterface
        public void goToPay(final String str, final String str2) {
            ((WebActivity) this.mWebView.getContext()).runOnUiThread(new Runnable() {
                /* class com.mi.global.shop.webview.WebViewHelper.WebEvent.AnonymousClass4 */

                public final void run() {
                    ((WebActivity) WebEvent.this.mWebView.getContext()).jumpToPayment(str, str2);
                }
            });
        }

        @JavascriptInterface
        public void updatePinCode(String str, String str2, String str3, String str4) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str)) {
                cbm.O00000o0.O000000o(this.mWebView.getContext(), "pref_key_zip_code", str);
                cbm.O00000o0.O000000o(this.mWebView.getContext(), "pref_key_city_name", str2);
                cbm.O00000o0.O000000o(this.mWebView.getContext(), "pref_key_state_id", str3);
                cbm.O00000o0.O000000o(this.mWebView.getContext(), "pref_key_warehouse_id", str4);
            }
        }

        @JavascriptInterface
        public void shareToFacebook(String str, String str2, String str3, String str4) {
            ShareLinkContent shareLinkContent;
            if (str4 != null && !str4.equals("") && str3 != null && !str3.equals("")) {
                shareLinkContent = ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(str4))).setImageUrl(Uri.parse(str3)).setContentTitle(str).setContentDescription(str2).build();
            } else if (str4 == null || str4.equals("")) {
                shareLinkContent = new ShareLinkContent.Builder().setContentTitle(str).setContentDescription(str2).build();
            } else {
                shareLinkContent = ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(str4))).setContentTitle(str).setContentDescription(str2).build();
            }
            if (ShareDialog.canShow((Class<? extends ShareContent>) ShareLinkContent.class)) {
                ((WebActivity) this.mWebView.getContext()).shareDialog.show(shareLinkContent);
            }
        }

        @JavascriptInterface
        public int getVersionCode() {
            return Device.O0000oO0;
        }

        @JavascriptInterface
        public void goToFeedback() {
            this.mWebView.getContext().startActivity(new Intent(this.mWebView.getContext(), FeedbackActivity.class));
        }

        @JavascriptInterface
        public boolean isGoogleMapInstalled() {
            return cdw.O000000o(this.mWebView.getContext(), "com.google.android.apps.maps");
        }

        @JavascriptInterface
        public void openGoogleMap(String str) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (isGoogleMapInstalled()) {
                    intent.setPackage("com.google.android.apps.maps");
                }
                if (intent.resolveActivity(this.mWebView.getContext().getPackageManager()) != null) {
                    this.mWebView.getContext().startActivity(intent);
                }
            } catch (Exception unused) {
            }
        }

        @JavascriptInterface
        public void requestLocationPermission() {
            final WebActivity webActivity = this.mWebView.getContext() instanceof WebActivity ? (WebActivity) this.mWebView.getContext() : null;
            if (webActivity != null && !cem.O000000o(webActivity, "android.permission.ACCESS_COARSE_LOCATION")) {
                cem.O000000o(webActivity, new cen() {
                    /* class com.mi.global.shop.webview.WebViewHelper.WebEvent.AnonymousClass5 */

                    public final void O00000o0() {
                        cbc.O000000o(webActivity);
                        String url = WebEvent.this.mWebView.getUrl();
                        String O000000o2 = cbc.O000000o();
                        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(O000000o2)) {
                            WebView webView = WebEvent.this.mWebView;
                            webView.loadUrl(url + "&location=" + cbc.O000000o());
                        }
                    }
                }, cek.O000000o.O00000o);
            }
        }
    }
}
