package com.xiaomi.passport.ui.internal;

import _m_j.efm;
import _m_j.egu;
import _m_j.eit;
import _m_j.eks;
import _m_j.ixe;
import _m_j.iyo;
import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.XMPassportUserAgent;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.utils.WebViewDeviceIdUtil;
import com.xiaomi.accountsdk.utils.WebViewFidNonceUtil;
import com.xiaomi.accountsdk.utils.WebViewNativeUserAgentUtil;
import com.xiaomi.accountsdk.utils.WebViewUserSpaceIdUtil;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PassportWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCookieManager", "Landroid/webkit/CookieManager;", "originLoadUrl", "", "getExistedAccountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "loadUrl", "", "url", "onAuthEnd", "", "onLoginEnd", "accountInfo", "onNeedReLogin", "onPageFinished", "view", "onReceivedLoginRequest", "realm", "args", "onSnsBindCancel", "onSnsBindFinished", "shouldOverrideUrlLoading", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public class PassportWebView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f6254O000000o;
    private final CookieManager O00000Oo;

    public boolean O000000o() {
        return false;
    }

    public boolean O000000o(AccountInfo accountInfo) {
        ixe.O00000o0(accountInfo, "accountInfo");
        return false;
    }

    public boolean O000000o(String str) {
        ixe.O00000o0(str, "url");
        return false;
    }

    public void O00000Oo() {
    }

    public boolean O00000Oo(AccountInfo accountInfo) {
        return false;
    }

    public boolean O00000o0(AccountInfo accountInfo) {
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.webkit.CookieManager, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.webkit.WebSettings, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportWebView(Context context) {
        super(context);
        ixe.O00000o0(context, "context");
        CookieSyncManager.createInstance(context);
        CookieManager instance = CookieManager.getInstance();
        ixe.O000000o((Object) instance, "CookieManager.getInstance()");
        this.O00000Oo = instance;
        this.O00000Oo.removeAllCookie();
        WebSettings settings = getSettings();
        ixe.O000000o((Object) settings, "settings");
        WebView webView = this;
        settings.setUserAgentString(XMPassportUserAgent.getWebViewUserAgent(webView, context));
        WebSettings settings2 = getSettings();
        ixe.O000000o((Object) settings2, "settings");
        settings2.setJavaScriptEnabled(true);
        WebSettings settings3 = getSettings();
        ixe.O000000o((Object) settings3, "settings");
        settings3.setBuiltInZoomControls(false);
        getSettings().setSupportZoom(false);
        setWebChromeClient(new WebChromeClient());
        setWebViewClient(new egu(this));
        new WebViewDeviceIdUtil().setupDeviceIdForAccountWeb(webView);
        new WebViewFidNonceUtil().setupFidNonceForAccountWeb(webView);
        new WebViewUserSpaceIdUtil().setupUserSpaceIdForAccountWeb(webView);
        new WebViewNativeUserAgentUtil().setupUserAgentForAccountWeb(webView);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean
     arg types: [java.lang.CharSequence, java.lang.String, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, int, int):int
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.xiaomi.accountsdk.account.data.AccountInfo, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public boolean O000000o(WebView webView, String str) {
        ixe.O00000o0(str, "url");
        if (!eit.O000000o(str)) {
            eit.O000000o(getContext(), str);
            return true;
        }
        String cookie = this.O00000Oo.getCookie(URLs.ACCOUNT_DOMAIN);
        CharSequence charSequence = cookie;
        if (!TextUtils.isEmpty(charSequence)) {
            ixe.O000000o((Object) cookie, "cookieStr");
            if (iyo.O000000o(charSequence, (CharSequence) "sns-bind-step", false)) {
                if (iyo.O000000o(charSequence, (CharSequence) "bind-finish", false)) {
                    AccountInfo existedAccountInfo = getExistedAccountInfo();
                    if (existedAccountInfo == null) {
                        existedAccountInfo = new AccountInfo.Builder().userId(efm.O000000o(cookie, "userId")).passToken(efm.O000000o(cookie, "passToken")).build();
                    }
                    if (O00000Oo(existedAccountInfo)) {
                        return true;
                    }
                } else if (iyo.O000000o(charSequence, (CharSequence) "bind-cancel", false) && O00000o0(getExistedAccountInfo())) {
                    return true;
                }
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            ixe.O000000o((Object) cookie, "cookieStr");
            if (iyo.O000000o(charSequence, (CharSequence) "passInfo", false)) {
                if (iyo.O000000o(charSequence, (CharSequence) "need-relogin", false) && O000000o()) {
                    return true;
                }
                if (iyo.O000000o(charSequence, (CharSequence) "login-end", false)) {
                    AccountInfo build = new AccountInfo.Builder().userId(XMPassportUtil.extractUserIdFromNotificationLoginEndCookie(cookie)).passToken(XMPassportUtil.extractPasstokenFromNotificationLoginEndCookie(cookie)).build();
                    ixe.O000000o((Object) build, "accountInfo");
                    if (O000000o(build)) {
                        return true;
                    }
                }
                if (!iyo.O000000o(charSequence, (CharSequence) "auth-end", false) || !O000000o(str)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private final AccountInfo getExistedAccountInfo() {
        String O00000o0 = eks.O00000o0(getContext());
        Account O000000o2 = eks.O000000o(getContext());
        if (O000000o2 == null) {
            return null;
        }
        return new AccountInfo.Builder().userId(O000000o2.name).passToken(O00000o0).build();
    }

    public void loadUrl(String str) {
        ixe.O00000o0(str, "url");
        this.f6254O000000o = str;
        super.loadUrl(str);
    }
}
