package com.xiaomi.smarthome.smartconfig;

import _m_j.ekq;
import _m_j.eks;
import _m_j.gku;
import _m_j.gpc;
import android.accounts.Account;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.utils.AbstractAccountWebViewSingleCookieUtil;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.FidNonce;
import com.xiaomi.accountsdk.utils.ServerTimeUtil;
import com.xiaomi.accountsdk.utils.UserSpaceIdUtil;
import com.xiaomi.accountsdk.utils.WebViewDeviceIdUtil;
import com.xiaomi.accountsdk.utils.WebViewFidNonceUtil;
import com.xiaomi.accountsdk.utils.WebViewNativeUserAgentUtil;
import com.xiaomi.accountsdk.utils.WebViewUserSpaceIdUtil;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import com.xiaomi.smarthome.R;

public class ScDeviceLocalAccountWebAuthActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    final WebViewClient f11458O000000o = new WebViewClient() {
        /* class com.xiaomi.smarthome.smartconfig.ScDeviceLocalAccountWebAuthActivity.AnonymousClass1 */

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (str.contains("#closewebview")) {
                boolean isScanResultSuccess = ScDeviceLocalAccountWebAuthActivity.this.isScanResultSuccess(str);
                AccountLog.i("ScDeviceLocalAccountWebAuthActivity", "onPageFinished ".concat(String.valueOf(isScanResultSuccess)));
                ScDeviceLocalAccountWebAuthActivity.this.finishActivityAndHandleResponse(isScanResultSuccess);
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (str.contains("#closewebview")) {
                boolean isScanResultSuccess = ScDeviceLocalAccountWebAuthActivity.this.isScanResultSuccess(str);
                AccountLog.i("ScDeviceLocalAccountWebAuthActivity", "onPageStarted ".concat(String.valueOf(isScanResultSuccess)));
                ScDeviceLocalAccountWebAuthActivity.this.finishActivityAndHandleResponse(isScanResultSuccess);
            }
        }
    };
    final WebChromeClient O00000Oo = new WebChromeClient() {
        /* class com.xiaomi.smarthome.smartconfig.ScDeviceLocalAccountWebAuthActivity.AnonymousClass2 */

        public void onCloseWindow(WebView webView) {
            super.onCloseWindow(webView);
            boolean isScanResultSuccess = ScDeviceLocalAccountWebAuthActivity.this.isScanResultSuccess(webView.getUrl());
            AccountLog.i("ScDeviceLocalAccountWebAuthActivity", "onCloseWindow ".concat(String.valueOf(isScanResultSuccess)));
            ScDeviceLocalAccountWebAuthActivity.this.finishActivityAndHandleResponse(isScanResultSuccess);
        }
    };
    private WebView O00000o;
    private View O00000o0;
    private ServerTimeUtil.ServerTimeAlignedListener O00000oO;
    private String O00000oo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sc_device_login);
        this.O00000o0 = findViewById(R.id.view_title);
        this.O00000o = (WebView) findViewById(R.id.web_view);
        this.O00000oo = getIntent().getStringExtra("login_url");
        if (TextUtils.isEmpty(this.O00000oo)) {
            finish();
        } else if (!ekq.O00000Oo(this.O00000oo)) {
            AccountLog.w("ScDeviceLocalAccountWebAuthActivity", "illegal account login url");
            finishActivityAndHandleResponse(false);
        } else {
            if (eks.O000000o(getApplicationContext()) == null) {
                Intent O000000o2 = eks.O000000o((String) null, new Bundle(), (Parcelable) null);
                O000000o2.setPackage(getPackageName());
                startActivityForResult(O000000o2, 1);
                overridePendingTransition(0, 0);
            }
            WebSettings settings = this.O00000o.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowContentAccess(false);
            settings.setAllowFileAccess(false);
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            this.O00000o.setWebViewClient(this.f11458O000000o);
            this.O00000o.setWebChromeClient(this.O00000Oo);
            Account O000000o3 = eks.O000000o(getApplicationContext());
            if (O000000o3 != null) {
                O000000o(O000000o3);
            }
            this.O00000oO = new WebViewFidNonceUtil.ServerTimeAlignedListenerImpl(this.O00000o);
            ServerTimeUtil.addServerTimeChangedListener(this.O00000oO);
            double doubleExtra = getIntent().getDoubleExtra("height_ratio", 0.0d);
            if (doubleExtra != 0.0d) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O00000o.getLayoutParams();
                double O000000o4 = (double) gpc.O000000o();
                Double.isNaN(O000000o4);
                layoutParams.height = (int) (O000000o4 * doubleExtra);
                this.O00000o.setLayoutParams(layoutParams);
                this.O00000o0.setVisibility(0);
            } else {
                this.O00000o0.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 29) {
                return;
            }
            if (gku.O000000o(this)) {
                settings.setForceDark(2);
            } else {
                settings.setForceDark(0);
            }
        }
    }

    private void O000000o(Account account) {
        if (account != null) {
            String O00000o02 = eks.O00000o0(getApplicationContext(), account);
            CookieSyncManager.createInstance(this);
            CookieManager instance = CookieManager.getInstance();
            instance.removeAllCookie();
            instance.setCookie(AbstractAccountWebViewSingleCookieUtil.DOMAIN_URL_SET_COOKIE, O000000o("userId", account.name));
            instance.setCookie(AbstractAccountWebViewSingleCookieUtil.DOMAIN_URL_SET_COOKIE, O000000o("passToken", O00000o02));
            String O000000o2 = ekq.O000000o();
            if (!TextUtils.isEmpty(O000000o2)) {
                new WebViewDeviceIdUtil().setDeviceIdCookie(O000000o2, instance);
            }
            FidNonce build = new FidNonce.Builder().build(FidNonce.Type.WEB_VIEW);
            if (build != null) {
                new WebViewFidNonceUtil().setFidNonceCookie(build, instance);
            }
            String nullableUserSpaceIdCookie = UserSpaceIdUtil.getNullableUserSpaceIdCookie();
            if (!TextUtils.isEmpty(nullableUserSpaceIdCookie)) {
                new WebViewUserSpaceIdUtil().setupUserSpaceIdCookie(nullableUserSpaceIdCookie, instance);
            }
            String userAgent = XMPassportSettings.getUserAgent();
            if (!TextUtils.isEmpty(userAgent)) {
                new WebViewNativeUserAgentUtil().setupUserAgentCookie(userAgent, instance);
            }
            CookieSyncManager.getInstance().sync();
            this.O00000o.loadUrl(XMPassportUtil.buildUrlWithLocaleQueryParam(this.O00000oo));
        }
    }

    private static String O000000o(String str, String str2) {
        return str + "=" + str2 + "; domain = account.xiaomi.com; path=/";
    }

    public void onBackPressed() {
        if (this.O00000o.canGoBack()) {
            this.O00000o.goBack();
            return;
        }
        finishActivityAndHandleResponse(false);
        super.onBackPressed();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                O000000o(eks.O000000o(getApplicationContext()));
            } else {
                finishActivityAndHandleResponse(false);
            }
        }
    }

    public void finishActivityAndHandleResponse(boolean z) {
        if (!isFinishing()) {
            O000000o(z);
            Intent intent = new Intent();
            intent.putExtra("login_result", isScanResultSuccess(this.O00000oo));
            setResult(-1, intent);
            finish();
        }
    }

    private void O000000o(boolean z) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("booleanResult", z);
            eks.O000000o(extras.getParcelable("accountAuthenticatorResponse"), bundle);
        }
    }

    public boolean isScanResultSuccess(String str) {
        String cookie = CookieManager.getInstance().getCookie(str);
        if (cookie == null) {
            return false;
        }
        for (String str2 : cookie.split(";")) {
            if (!TextUtils.isEmpty(str2) && str2.contains("scanInfo")) {
                AccountLog.i("ScDeviceLocalAccountWebAuthActivity", "cookie scan result: ".concat(String.valueOf(str2)));
                String[] split = str2.split("=");
                if (split[0].trim().equals("scanInfo")) {
                    return "0".equals(split[1].trim());
                }
            }
        }
        return false;
    }

    public void checkScanCodeSuccess() {
        O000000o(isScanResultSuccess(this.O00000oo));
    }
}
