package com.miui.tsmclient.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.miui.tsmclient.account.internal.ExtendedAuthToken;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.ReflectUtil;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class OAuthAccountManager implements IAccountManager {
    private IMiOAuth mMiOAuth;
    private ThreadLocal<Integer> mRetryCount = new ThreadLocal<Integer>() {
        /* class com.miui.tsmclient.account.OAuthAccountManager.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public Integer initialValue() {
            return 0;
        }
    };

    public AccountManagerFuture<Bundle> addAccount(Activity activity, AccountManagerCallback accountManagerCallback) {
        return null;
    }

    public AccountManagerFuture<Bundle> confirmCredentials(Activity activity, AccountManagerCallback accountManagerCallback) {
        return null;
    }

    public Account getAccount(Context context) {
        return null;
    }

    public final class MiOAuthConstant {
        private MiOAuthConstant() {
        }
    }

    public AccountInfo loadAccountInfo(Context context) {
        return loadAccountInfo(context, (String) null);
    }

    public AccountInfo loadAccountInfo(Context context, String str) {
        IMiOAuth miOAuth = getMiOAuth(context);
        if (miOAuth == null) {
            return null;
        }
        String clientId = EnvironmentConfig.isLoginAuth() ? str : EnvironmentConfig.getClientId();
        Future<Bundle> accessToken = miOAuth.getAccessToken(clientId);
        try {
            Bundle bundle = accessToken.get(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, TimeUnit.MILLISECONDS);
            if (accessToken.isDone() && bundle != null) {
                String string = bundle.getString("accessToken");
                AccountInfo loadAccountInfo = loadAccountInfo(bundle.getString("userId"), string);
                if (loadAccountInfo != null) {
                    this.mRetryCount.set(0);
                    return loadAccountInfo;
                } else if (this.mRetryCount.get().intValue() <= 0) {
                    LogUtils.d("getAccessToken met an invalid token, so invalidateAuthToken.");
                    miOAuth.invalidateAccessToken(clientId, string);
                    this.mRetryCount.set(Integer.valueOf(this.mRetryCount.get().intValue() + 1));
                    return loadAccountInfo(context, str);
                } else {
                    this.mRetryCount.set(0);
                    LogUtils.w("After invalidating the AccessToken, but result is still invalid.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LogUtils.e("OAuthAccountManager#loadAccountInfo invoke failed with an InterruptedException!", e);
        } catch (ExecutionException e2) {
            LogUtils.e("OAuthAccountManager#loadAccountInfo invoke failed with an ExecutionException!", e2);
        } catch (TimeoutException e3) {
            LogUtils.e("OAuthAccountManager#loadAccountInfo invoke failed with an TimeoutException!", e3);
        }
        return null;
    }

    public void resetAccount(Context context, String str) {
        IMiOAuth miOAuth = getMiOAuth(context);
        if (miOAuth != null) {
            miOAuth.invalidateAccessToken(EnvironmentConfig.getClientId(), str);
        }
    }

    private AccountInfo loadAccountInfo(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        AccountInfo accountInfo = new AccountInfo();
        boolean z = true;
        if (EnvironmentConfig.isLoginAuth()) {
            ExtendedAuthToken parse = ExtendedAuthToken.parse(str2);
            if (parse != null) {
                accountInfo.setServiceToken(parse.authToken);
                accountInfo.setSecurity(parse.security);
            } else {
                LogUtils.d("extendedAuthToken is null as token format is not right");
                z = false;
            }
        }
        if (!z) {
            return null;
        }
        accountInfo.setUserId(str);
        accountInfo.setAuthToken(str2);
        return accountInfo;
    }

    private IMiOAuth getMiOAuth(Context context) {
        this.mMiOAuth = EnvironmentConfig.getMiOAuth();
        if (this.mMiOAuth == null) {
            if (context == null) {
                return null;
            }
            Object newInstance = ReflectUtil.newInstance(context.getPackageName() + ".mitsmsdk.MiOAuthImpl", new Class[]{Context.class}, context);
            if (newInstance instanceof IMiOAuth) {
                this.mMiOAuth = (IMiOAuth) newInstance;
            } else {
                throw new IllegalStateException("MiOAuthImpl can not be found!");
            }
        }
        return this.mMiOAuth;
    }
}
