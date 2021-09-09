package com.xiaomi.account.auth;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.openauth.XMAuthericationException;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class MiuiOauth implements XiaomiOAuth {
    private String mAppId;
    public Context mContext;
    private String mRedirectUrl;

    MiuiOauth(Context context, String str, String str2) {
        this.mContext = context;
        this.mAppId = str;
        this.mRedirectUrl = str2;
    }

    public XiaomiOAuthResults startOAuth(Activity activity, OAuthConfig oAuthConfig) throws Exception {
        MiuiOAuthSession miuiOAuthSession = new MiuiOAuthSession(activity, oAuthConfig);
        try {
            if (miuiOAuthSession.bind()) {
                return miuiOAuthSession.getResult();
            }
        } catch (FallBackWebOAuthException unused) {
        }
        Log.i("MiuiOauth", "fallBack to WebView OAuth");
        return new WebViewOauth(this.mContext, this.mAppId, this.mRedirectUrl).startOAuth(activity, oAuthConfig);
    }

    class MiuiOAuthSession extends FutureTask<Bundle> implements ServiceConnection {
        WeakReference<Activity> mActivityWeakReference;
        XiaomiAuthService mAuthService;
        OAuthConfig mOAuthConfig;
        IXiaomiAuthResponse mResponse;

        MiuiOAuthSession(Activity activity, OAuthConfig oAuthConfig) {
            super(new Callable<Bundle>() {
                /* class com.xiaomi.account.auth.MiuiOauth.MiuiOAuthSession.AnonymousClass1 */

                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            this.mActivityWeakReference = new WeakReference<>(activity);
            this.mOAuthConfig = oAuthConfig;
            this.mResponse = new IXiaomiAuthResponse.Stub(MiuiOauth.this) {
                /* class com.xiaomi.account.auth.MiuiOauth.MiuiOAuthSession.AnonymousClass2 */

                public void onResult(Bundle bundle) throws RemoteException {
                    MiuiOAuthSession.this.set(bundle);
                }

                public void onCancel() throws RemoteException {
                    MiuiOAuthSession.this.setException(new OperationCanceledException());
                }
            };
        }

        /* access modifiers changed from: package-private */
        public boolean bind() {
            Intent blockGetDefaultIntent = new OAuthServiceManager(MiuiOauth.this.mContext).blockGetDefaultIntent();
            if (blockGetDefaultIntent == null) {
                Log.i("MiuiOauth", "no xiaomi OAuth service");
                return false;
            }
            boolean bindService = MiuiOauth.this.mContext.bindService(blockGetDefaultIntent, this, 1);
            if (!bindService) {
                Log.i("MiuiOauth", "bind failed");
            }
            return bindService;
        }

        private void unbind() {
            if (this.mAuthService != null) {
                this.mAuthService = null;
                MiuiOauth.this.mContext.unbindService(this);
            }
        }

        private void close() {
            unbind();
        }

        /* access modifiers changed from: package-private */
        public XiaomiOAuthResults getResult() throws Exception {
            return XiaomiOAuthResults.parseBundle(internalGetResult());
        }

        /* access modifiers changed from: protected */
        public void set(Bundle bundle) {
            if (bundle == null || !bundle.containsKey("extra_intent")) {
                close();
                super.set((Object) bundle);
                return;
            }
            Intent intent = (Intent) bundle.getParcelable("extra_intent");
            if (intent == null) {
                setException(new XMAuthericationException("intent == null"));
                return;
            }
            Activity activity = this.mActivityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("extra_error_code", -1001);
                bundle2.putString("extra_error_description", "activity is null");
                super.set((Object) bundle2);
                return;
            }
            activity.startActivity(intent);
        }

        /* access modifiers changed from: protected */
        public void setException(Throwable th) {
            close();
            super.setException(th);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.mAuthService = new XiaomiAuthService(iBinder);
            try {
                this.mAuthService.oauthInResponse(MiuiOauth.this.mContext, this.mResponse, this.mOAuthConfig);
            } catch (RemoteException e) {
                setException(e);
            } catch (XMAuthericationException e2) {
                setException(e2);
            } catch (FallBackWebOAuthException e3) {
                setException(e3);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.mAuthService = null;
            if (Build.VERSION.SDK_INT >= 15) {
                setException(new RemoteException("onServiceDisconnected"));
            } else {
                setException(new XMAuthericationException("onServiceDisconnected"));
            }
        }

        private Bundle internalGetResult() throws Exception {
            try {
                return (Bundle) get(10, TimeUnit.MINUTES);
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Exception) {
                    throw ((Exception) cause);
                }
                throw ((Error) cause);
            }
        }
    }
}
