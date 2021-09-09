package com.xiaomi.account.openauth;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.xiaomi.account.auth.AuthorizeApi;
import com.xiaomi.account.auth.OAuthConfig;
import com.xiaomi.account.auth.OAuthFactory;
import com.xiaomi.account.auth.XiaomiOAuthFutureImpl;
import com.xiaomi.account.openauth.internal.MiAccountPhoneInfo;
import com.xiaomi.phonenum.PhoneNumKeeper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class XiaomiOAuthorize {
    public static final Class<? extends AuthorizeActivityBase> DEFAULT_AUTHORIZE_ACTIVITY_CLASS = AuthorizeActivity.class;
    public OAuthConfig.Builder mConfigBuilder = new OAuthConfig.Builder();

    public XiaomiOAuthorize setScope(int[] iArr) {
        this.mConfigBuilder.scopes(iArr);
        return this;
    }

    public XiaomiOAuthorize setAppId(long j) {
        this.mConfigBuilder.appId(j);
        return this;
    }

    public XiaomiOAuthorize setRedirectUrl(String str) {
        this.mConfigBuilder.redirectUrl(str);
        return this;
    }

    public XiaomiOAuthorize setSkipConfirm(boolean z) {
        this.mConfigBuilder.skipConfirm(z);
        return this;
    }

    public XiaomiOAuthorize setNoMiui(boolean z) {
        this.mConfigBuilder.notUseMiui(z);
        return this;
    }

    public XiaomiOAuthorize setState(String str) {
        this.mConfigBuilder.state(str);
        return this;
    }

    public XiaomiOAuthorize setKeepCookies(boolean z) {
        this.mConfigBuilder.keepCookies(z);
        return this;
    }

    public XiaomiOAuthorize setCustomizedAuthorizeActivityClass(Class<? extends AuthorizeActivityBase> cls) {
        this.mConfigBuilder.authorizeActivityClazz(cls);
        return this;
    }

    public XiaomiOAuthorize setAccountAuth(AccountAuth accountAuth) {
        this.mConfigBuilder.accountAuth(accountAuth);
        return this;
    }

    public XiaomiOAuthorize setPhoneNumAutoFill(Context context, boolean z, long j) {
        if (z) {
            Class<PhoneNumKeeper> cls = PhoneNumKeeper.class;
            try {
                this.mConfigBuilder.phoneInfo(new MiAccountPhoneInfo(context, j));
            } catch (NoClassDefFoundError unused) {
                Log.e("XiaomiOAuthorize", "please add 'com.xiaomi.account:phoneNumKeep:+' to support setPhoneNumAutoFill");
            }
        }
        return this;
    }

    public XiaomiOAuthorize setPhoneNumAutoFill(Context context, boolean z) {
        return setPhoneNumAutoFill(context, z, 2000);
    }

    public XiaomiOAuthorize setPlatform(int i) {
        this.mConfigBuilder.platform(i);
        return this;
    }

    public XiaomiOAuthorize setDeviceID(String str) {
        this.mConfigBuilder.deviceID(str);
        return this;
    }

    public XiaomiOAuthorize setContext(Context context) {
        this.mConfigBuilder.context(context);
        return this;
    }

    public XiaomiOAuthorize setLoginType(String str) {
        this.mConfigBuilder.loginType(str);
        return this;
    }

    public XiaomiOAuthorize setHideSwitch(boolean z) {
        this.mConfigBuilder.hideSwitch(z);
        return this;
    }

    public XiaomiOAuthFuture<XiaomiOAuthResults> fastOAuth(Activity activity, String str) {
        this.mConfigBuilder.fastOAuth(true);
        this.mConfigBuilder.responseType(str);
        return oauth(activity);
    }

    public XiaomiOAuthFuture<XiaomiOAuthResults> startGetAccessToken(Activity activity) {
        this.mConfigBuilder.responseType("token");
        return oauth(activity);
    }

    public XiaomiOAuthFuture<XiaomiOAuthResults> startGetOAuthCode(Activity activity) {
        this.mConfigBuilder.responseType("code");
        return oauth(activity);
    }

    private XiaomiOAuthFuture<XiaomiOAuthResults> oauth(final Activity activity) {
        if (this.mConfigBuilder.getContext() == null) {
            if (activity != null) {
                this.mConfigBuilder.context(activity.getApplicationContext());
            } else {
                throw new IllegalArgumentException("please set Context or Activity!!!");
            }
        }
        XiaomiOAuthFutureImpl xiaomiOAuthFutureImpl = new XiaomiOAuthFutureImpl(new Callable<XiaomiOAuthResults>() {
            /* class com.xiaomi.account.openauth.XiaomiOAuthorize.AnonymousClass1 */

            public XiaomiOAuthResults call() throws Exception {
                OAuthConfig build = new OAuthConfig.Builder(XiaomiOAuthorize.this.mConfigBuilder).build();
                return OAuthFactory.createOAuth(build).startOAuth(activity, build);
            }
        });
        AsyncTask.THREAD_POOL_EXECUTOR.execute(xiaomiOAuthFutureImpl);
        return xiaomiOAuthFutureImpl;
    }

    public XiaomiOAuthFuture<String> callOpenApi(Context context, long j, String str, String str2, String str3, String str4) {
        final Context context2 = context;
        final String str5 = str;
        final long j2 = j;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final FutureTask futureTask = new FutureTask(new Callable<String>() {
            /* class com.xiaomi.account.openauth.XiaomiOAuthorize.AnonymousClass2 */

            public String call() throws Exception {
                return AuthorizeApi.doHttpGet(context2, str5, j2, str6, str7, str8);
            }
        });
        AsyncTask.THREAD_POOL_EXECUTOR.execute(futureTask);
        return new XiaomiOAuthFuture<String>() {
            /* class com.xiaomi.account.openauth.XiaomiOAuthorize.AnonymousClass3 */

            public String getResult() throws OperationCanceledException, IOException, XMAuthericationException {
                try {
                    return (String) futureTask.get();
                } catch (InterruptedException e) {
                    throw new XMAuthericationException(e);
                } catch (ExecutionException e2) {
                    throw new XMAuthericationException(e2.getCause());
                }
            }

            public String getResult(long j, TimeUnit timeUnit) throws OperationCanceledException, IOException, XMAuthericationException {
                try {
                    return (String) futureTask.get(j, timeUnit);
                } catch (InterruptedException e) {
                    throw new XMAuthericationException(e);
                } catch (ExecutionException e2) {
                    throw new XMAuthericationException(e2.getCause());
                } catch (TimeoutException e3) {
                    throw new XMAuthericationException(e3);
                }
            }
        };
    }

    @Deprecated
    public static void startGetAccessToken(Activity activity, long j, String str, Bundle bundle, int i) {
        Log.w("XiaomiOAuthorize", "you are calling startGetAccessToken(). Is still works but it is deprecated. Instead please use \n                XiaomiOAuthFuture<XiaomiOAuthResults> future = new XiaomiOAuthorize()\n                        .setAppId(appId)\n                        .setRedirectUrl(redirectUri)\n                        .setScope(scope)\n                        .setAllowSwitchAccount(true)\n                        .startGetAccessToken(acitivity);\n                XiaomiOAuthResults results = future.getResult();//call on background thread.\nIt provides better user experience! Checkout the Demo codes!");
        startGetOAuthorize(activity, j, str, "token", bundle, i);
    }

    @Deprecated
    public static void startGetOAuthCode(Activity activity, long j, String str, Bundle bundle, int i) {
        Log.w("XiaomiOAuthorize", "you are calling startGetOAuthCode(). Is still works but it is deprecated. Instead please use \n                XiaomiOAuthFuture<XiaomiOAuthResults> future = new XiaomiOAuthorize()\n                        .setAppId(appId)\n                        .setRedirectUrl(redirectUri)\n                        .setScope(scope)\n                        .setAllowSwitchAccount(true)\n                        .startGetOAuthCode(acitivity);\n                XiaomiOAuthResults results = future.getResult();//call on background thread.\nIt provides better user experience! Checkout the Demo codes!");
        startGetOAuthorize(activity, j, str, "code", bundle, i);
    }

    @Deprecated
    private static void startGetOAuthorize(final Activity activity, long j, String str, final String str2, Bundle bundle, final int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        XiaomiOAuthorize state = new XiaomiOAuthorize().setAppId(j).setRedirectUrl(str).setScope(scopeStringToIntArray(bundle.getString("extra_scope"))).setState(bundle.getString("extra_state"));
        if (bundle.containsKey("extra_skip_confirm")) {
            state.setSkipConfirm(bundle.getBoolean("extra_skip_confirm"));
        }
        final XiaomiOAuthFuture<XiaomiOAuthResults> startGetOAuthCode = "code".equalsIgnoreCase(str2) ? state.startGetOAuthCode(activity) : state.startGetAccessToken(activity);
        new AsyncTask<Void, Void, XiaomiOAuthResults>() {
            /* class com.xiaomi.account.openauth.XiaomiOAuthorize.AnonymousClass4 */
            Exception e;

            /* access modifiers changed from: protected */
            public final XiaomiOAuthResults doInBackground(Void... voidArr) {
                try {
                    return (XiaomiOAuthResults) startGetOAuthCode.getResult();
                } catch (OperationCanceledException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (IOException e3) {
                    this.e = e3;
                    return null;
                } catch (XMAuthericationException e4) {
                    this.e = e4;
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public final void onPostExecute(XiaomiOAuthResults xiaomiOAuthResults) {
                int i;
                Bundle bundle = new Bundle();
                if (xiaomiOAuthResults == null) {
                    if (this.e == null) {
                        i = AuthorizeActivityBase.RESULT_CANCEL;
                        bundle.putInt("error", AuthorizeActivityBase.RESULT_CANCEL);
                        bundle.putString("error_description", "canceled");
                    } else {
                        i = AuthorizeActivityBase.RESULT_FAIL;
                        bundle.putInt("error", AuthorizeActivityBase.RESULT_FAIL);
                        bundle.putString("error_description", this.e.getMessage());
                    }
                } else if (xiaomiOAuthResults.hasError()) {
                    int i2 = AuthorizeActivityBase.RESULT_FAIL;
                    bundle.putInt("error", xiaomiOAuthResults.getErrorCode());
                    bundle.putString("error_description", xiaomiOAuthResults.getErrorMessage());
                    i = i2;
                } else {
                    int i3 = AuthorizeActivityBase.RESULT_SUCCESS;
                    if ("code".equalsIgnoreCase(str2)) {
                        bundle.putString("code", xiaomiOAuthResults.getCode());
                        bundle.putString("state", xiaomiOAuthResults.getState());
                        bundle.putString("token_type", xiaomiOAuthResults.getTokenType());
                        bundle.putString("mac_key", xiaomiOAuthResults.getMacKey());
                        bundle.putString("mac_algorithm", xiaomiOAuthResults.getMacAlgorithm());
                    } else {
                        bundle.putString("access_token", xiaomiOAuthResults.getAccessToken());
                        bundle.putString("expires_in", xiaomiOAuthResults.getExpiresIn());
                        bundle.putString("scope", xiaomiOAuthResults.getScopes());
                        bundle.putString("state", xiaomiOAuthResults.getState());
                        bundle.putString("token_type", xiaomiOAuthResults.getTokenType());
                        bundle.putString("mac_key", xiaomiOAuthResults.getMacKey());
                        bundle.putString("mac_algorithm", xiaomiOAuthResults.getMacAlgorithm());
                    }
                    i = i3;
                }
                Activity activity = activity;
                activity.startActivityForResult(AuthorizeActivityBase.asMiddleActivity(activity, i, bundle, XiaomiOAuthorize.DEFAULT_AUTHORIZE_ACTIVITY_CLASS), i);
            }
        }.execute(new Void[0]);
    }

    @Deprecated
    private static int[] scopeStringToIntArray(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            for (String valueOf : str.split(" ")) {
                try {
                    arrayList.add(Integer.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }
}
