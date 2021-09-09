package _m_j;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
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
import com.xiaomi.passport.ui.internal.ScanCodeLoginFragment$2;

public final class ehs extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public WebView f15299O000000o;
    public String O00000Oo;
    final WebChromeClient O00000o = new ScanCodeLoginFragment$2(this);
    final WebViewClient O00000o0 = new WebViewClient() {
        /* class _m_j.ehs.AnonymousClass1 */

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (str.contains("#closewebview")) {
                boolean O000000o2 = ehs.O000000o(str);
                AccountLog.i("ScanCodeLoginFragment", "onPageFinished ".concat(String.valueOf(O000000o2)));
                ehs.this.O000000o(O000000o2);
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (str.contains("#closewebview")) {
                boolean O000000o2 = ehs.O000000o(str);
                AccountLog.i("ScanCodeLoginFragment", "onPageStarted ".concat(String.valueOf(O000000o2)));
                ehs.this.O000000o(O000000o2);
            }
        }
    };
    private ServerTimeUtil.ServerTimeAlignedListener O00000oO;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000Oo = getActivity().getIntent().getDataString();
        if (!ekq.O00000Oo(this.O00000Oo)) {
            AccountLog.w("ScanCodeLoginFragment", "illegal account login url");
            O000000o(false);
        } else if (eks.O000000o(getActivity().getApplicationContext()) == null) {
            getActivity();
            Intent O000000o2 = eks.O000000o((String) null, new Bundle(), (Parcelable) null);
            O000000o2.setPackage(getActivity().getPackageName());
            startActivityForResult(O000000o2, 1);
            getActivity().overridePendingTransition(0, 0);
        }
    }

    private void O000000o(Account account) {
        if (account != null) {
            String O00000o02 = eks.O00000o0(getActivity().getApplicationContext(), account);
            CookieSyncManager.createInstance(getActivity());
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
            this.f15299O000000o.loadUrl(XMPassportUtil.buildUrlWithLocaleQueryParam(getActivity().getIntent().getDataString()));
        }
    }

    public final void onDestroy() {
        ServerTimeUtil.ServerTimeAlignedListener serverTimeAlignedListener = this.O00000oO;
        if (serverTimeAlignedListener != null) {
            ServerTimeUtil.removeServerTimeChangedListener(serverTimeAlignedListener);
            this.O00000oO = null;
        }
        super.onDestroy();
    }

    private static String O000000o(String str, String str2) {
        return str + "=" + str2 + "; domain = account.xiaomi.com; path=/";
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                O000000o(eks.O000000o(getActivity().getApplicationContext()));
            } else {
                O000000o(false);
            }
        }
    }

    public final void O000000o(boolean z) {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            O00000Oo(z);
            activity.finish();
        }
    }

    public final void O00000Oo(boolean z) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("booleanResult", z);
            eks.O000000o(arguments.getParcelable("accountAuthenticatorResponse"), bundle);
        }
    }

    public static boolean O000000o(String str) {
        String cookie = CookieManager.getInstance().getCookie(str);
        if (cookie == null) {
            return false;
        }
        for (String str2 : cookie.split(";")) {
            if (!TextUtils.isEmpty(str2) && str2.contains("scanInfo")) {
                AccountLog.i("ScanCodeLoginFragment", "cookie scan result: ".concat(String.valueOf(str2)));
                String[] split = str2.split("=");
                if (split[0].trim().equals("scanInfo")) {
                    return "0".equals(split[1].trim());
                }
            }
        }
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        this.f15299O000000o = new WebView(getActivity());
        linearLayout.addView(this.f15299O000000o, new ViewGroup.LayoutParams(-1, -1));
        WebSettings settings = this.f15299O000000o.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        this.f15299O000000o.setWebViewClient(this.O00000o0);
        this.f15299O000000o.setWebChromeClient(this.O00000o);
        Account O000000o2 = eks.O000000o(getActivity().getApplicationContext());
        if (O000000o2 != null) {
            O000000o(O000000o2);
        }
        this.O00000oO = new WebViewFidNonceUtil.ServerTimeAlignedListenerImpl(this.f15299O000000o);
        ServerTimeUtil.addServerTimeChangedListener(this.O00000oO);
        return linearLayout;
    }
}
