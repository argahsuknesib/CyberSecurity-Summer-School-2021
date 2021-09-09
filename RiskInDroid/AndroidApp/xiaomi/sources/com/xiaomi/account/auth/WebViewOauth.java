package com.xiaomi.account.auth;

import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.XiaomiOAuthResponse;
import com.xiaomi.account.http.HttpClient;
import com.xiaomi.account.http.Request;
import com.xiaomi.account.http.Response;
import com.xiaomi.account.http.UrlConnHttpFactory;
import com.xiaomi.account.openauth.AccountAuth;
import com.xiaomi.account.openauth.XMAuthericationException;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.utils.OAuthUrlPaser;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class WebViewOauth implements XiaomiOAuth {
    private static final String AUTHORIZE_PATH = (XiaomiOAuthConstants.OAUTH2_HOST + "/oauth2/authorize");
    private String mAppId;
    private Context mContext;
    private String mRedirectUrl;

    public WebViewOauth(Context context, String str, String str2) {
        this.mContext = context;
        this.mAppId = str;
        this.mRedirectUrl = str2;
    }

    public XiaomiOAuthResults startOAuth(Activity activity, OAuthConfig oAuthConfig) throws AuthenticatorException, IOException, XMAuthericationException, InterruptedException, OperationCanceledException {
        if (!oAuthConfig.fastOAuth) {
            try {
                return quietOAuth(oAuthConfig);
            } catch (AuthenticatorException unused) {
                Activity activity2 = (Activity) new WeakReference(activity).get();
                if (activity2 == null || activity2.isFinishing()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("extra_error_code", -1001);
                    bundle.putString("extra_error_description", "activity is null");
                    return XiaomiOAuthResults.parseBundle(bundle);
                }
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final ArrayList arrayList = new ArrayList();
                activity2.startActivity(getIntent(activity2, oAuthConfig, new IXiaomiAuthResponse.Stub() {
                    /* class com.xiaomi.account.auth.WebViewOauth.AnonymousClass1 */

                    public void onResult(Bundle bundle) throws RemoteException {
                        arrayList.add(XiaomiOAuthResults.parseBundle(bundle));
                        countDownLatch.countDown();
                    }

                    public void onCancel() throws RemoteException {
                        countDownLatch.countDown();
                    }
                }));
                countDownLatch.await();
                if (arrayList.size() > 0) {
                    return (XiaomiOAuthResults) arrayList.get(0);
                }
                throw new OperationCanceledException();
            }
        } else {
            throw new XMAuthericationException("only miui support fastOAuth");
        }
    }

    private XiaomiOAuthResults quietOAuth(OAuthConfig oAuthConfig) throws AuthenticatorException, IOException, XMAuthericationException {
        if (oAuthConfig.accountAuth != null) {
            AccountAuth accountAuth = oAuthConfig.accountAuth;
            int i = 0;
            while (i < 2) {
                HttpClient createHttpClient = new UrlConnHttpFactory().createHttpClient();
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("userId", accountAuth.getUserId());
                hashMap2.put("serviceToken", accountAuth.getServiceToken());
                hashMap.put("Cookie", joinMap(hashMap2, "; "));
                Response excute = createHttpClient.excute(new Request.Builder().url(getUrl(oAuthConfig)).followRedirects(false).headers(hashMap).build());
                if (excute.location == null) {
                    throw new AuthenticatorException();
                } else if (excute.location.startsWith(this.mRedirectUrl)) {
                    Bundle parse = OAuthUrlPaser.parse(excute.location);
                    if (parse != null) {
                        return XiaomiOAuthResults.parseBundle(parse);
                    }
                    throw new XMAuthericationException("parse url fail:" + excute.location);
                } else {
                    accountAuth.invalideServiceToken();
                    i++;
                }
            }
            throw new AuthenticatorException();
        }
        throw new AuthenticatorException();
    }

    private Intent getIntent(Activity activity, OAuthConfig oAuthConfig, IXiaomiAuthResponse iXiaomiAuthResponse) {
        Intent intent = new Intent(activity, oAuthConfig.authorizeActivityClazz);
        intent.putExtra("url", getUrl(oAuthConfig));
        intent.putExtra("extra_keep_cookies ", oAuthConfig.keepCookies);
        intent.putExtra("extra_response", new XiaomiOAuthResponse(iXiaomiAuthResponse));
        AccountAuth accountAuth = oAuthConfig.accountAuth;
        if (accountAuth != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("userId", accountAuth.getUserId());
            hashMap.put("serviceToken", accountAuth.getServiceToken());
            intent.putExtra("userid", "userId=" + accountAuth.getUserId());
            intent.putExtra("serviceToken", "serviceToken=" + accountAuth.getServiceToken());
        }
        PhoneInfo phoneInfo = oAuthConfig.phoneInfo;
        if (phoneInfo != null) {
            intent.putExtras(phoneInfo.blokingGetPhoneInfo(getDefaultSmsSlotId()));
        }
        return intent;
    }

    private int getDefaultSmsSlotId() {
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        try {
            int defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
            List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(this.mContext).getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList == null) {
                return 0;
            }
            for (SubscriptionInfo next : activeSubscriptionInfoList) {
                if (next.getSubscriptionId() == defaultDataSubscriptionId) {
                    return next.getSimSlotIndex();
                }
            }
            return 0;
        } catch (SecurityException e) {
            Log.e("WebViewOauth", e.toString());
            return 0;
        }
    }

    private String getUrl(OAuthConfig oAuthConfig) {
        Bundle bundle = new Bundle();
        bundle.putString("client_id", this.mAppId);
        bundle.putString("redirect_uri", this.mRedirectUrl);
        bundle.putString("response_type", oAuthConfig.responseType);
        bundle.putString("scope", oAuthConfig.scopes);
        bundle.putString("state", oAuthConfig.state);
        if (oAuthConfig.skipConfirm != null) {
            bundle.putString("skip_confirm", String.valueOf(oAuthConfig.skipConfirm));
        }
        if (oAuthConfig.loginType != null) {
            bundle.putString("_loginType", oAuthConfig.loginType);
        }
        if (oAuthConfig.hideSwitch != null) {
            bundle.putString("_hideSwitch", "true");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(oAuthConfig.platform);
        bundle.putString("pt", sb.toString());
        bundle.putString("device_id", oAuthConfig.deviceID);
        addLocaleIfNeeded(bundle);
        return AUTHORIZE_PATH + "?" + parseBundle(bundle);
    }

    private void addLocaleIfNeeded(Bundle bundle) {
        if (bundle != null && !bundle.containsKey("_locale")) {
            String localeString = getLocaleString(Locale.getDefault());
            if (!TextUtils.isEmpty(localeString)) {
                bundle.putString("_locale", localeString);
            }
        }
    }

    private static String getLocaleString(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return String.format("%s_%s", language, country);
    }

    private String parseBundle(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (String next : bundle.keySet()) {
            String string = bundle.getString(next);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                arrayList.add(new BasicNameValuePair(next, string));
            }
        }
        return URLEncodedUtils.format(arrayList, "UTF-8");
    }

    private String getCookie(String str, String str2) {
        return str + "=" + str2;
    }

    protected static String joinMap(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
            i++;
        }
        return sb.toString();
    }
}
