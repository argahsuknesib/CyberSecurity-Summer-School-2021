package com.xiaomi.passport;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.passport.ISecurityDeviceSignResponse;
import com.xiaomi.passport.ISecurityDeviceSignService;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class SecurityDeviceSignManager {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ExecutorService f6191O000000o = Executors.newCachedThreadPool();

    public static FutureTask<Bundle> O000000o(final Context context, final String str, Bundle bundle) {
        if (context == null) {
            throw new IllegalArgumentException("context should not be null");
        } else if (!TextUtils.isEmpty(str)) {
            FutureTask<Bundle> futureTask = new FutureTask<>(new Callable<Bundle>(null) {
                /* class com.xiaomi.passport.SecurityDeviceSignManager.AnonymousClass1 */

                public final Bundle call() throws Exception {
                    if (SecurityDeviceSignManager.O000000o(context)) {
                        return SecurityDeviceSignManager.O00000Oo(context, str, null);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("booleanResult", false);
                    bundle.putInt("errorCode", 4);
                    bundle.putString("errorMessage", "no sign service");
                    return bundle;
                }
            });
            f6191O000000o.submit(futureTask);
            return futureTask;
        } else {
            throw new IllegalArgumentException("input data should not be empty");
        }
    }

    public static String O000000o(Context context, String[] strArr) {
        try {
            Bundle bundle = O000000o(context, TextUtils.join("&", strArr), null).get(10000, TimeUnit.MILLISECONDS);
            boolean z = bundle.getBoolean("booleanResult", false);
            String string = bundle.getString("errorMessage");
            if (z) {
                return bundle.getString("userData");
            }
            Log.e("SecurityDeviceSignMngr", "failed with ".concat(String.valueOf(string)));
            return null;
        } catch (InterruptedException e) {
            Log.e("SecurityDeviceSignMngr", "syncSignStringArray", e);
            return null;
        } catch (ExecutionException e2) {
            Log.e("SecurityDeviceSignMngr", "syncSignStringArray", e2);
            return null;
        } catch (TimeoutException e3) {
            Log.e("SecurityDeviceSignMngr", "syncSignStringArray", e3);
            return null;
        }
    }

    public static boolean O000000o(Context context) {
        Intent intent = new Intent("com.xiaomi.account.action.SECURITY_DEVICE_SIGN");
        intent.setPackage("com.xiaomi.account");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            return false;
        }
        return true;
    }

    public static Bundle O00000Oo(final Context context, final String str, final Bundle bundle) {
        String str2;
        try {
            return (Bundle) new SignServiceFutureTask(context) {
                /* class com.xiaomi.passport.SecurityDeviceSignManager.AnonymousClass2 */

                /* access modifiers changed from: protected */
                public final void callServiceWork(ISecurityDeviceSignService iSecurityDeviceSignService) throws RemoteException {
                    iSecurityDeviceSignService.sign(this.mResponse, context.getPackageName(), str, bundle);
                }
            }.start().get();
        } catch (InterruptedException e) {
            str2 = e.getMessage();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("booleanResult", false);
            bundle2.putInt("errorCode", 1);
            bundle2.putString("errorMessage", str2);
            return bundle2;
        } catch (ExecutionException e2) {
            str2 = e2.getMessage();
            Bundle bundle22 = new Bundle();
            bundle22.putBoolean("booleanResult", false);
            bundle22.putInt("errorCode", 1);
            bundle22.putString("errorMessage", str2);
            return bundle22;
        }
    }

    static abstract class SignServiceFutureTask extends FutureTask<Bundle> implements ServiceConnection {
        private Context mContext;
        protected ISecurityDeviceSignResponse mResponse = new Response();

        /* access modifiers changed from: protected */
        public abstract void callServiceWork(ISecurityDeviceSignService iSecurityDeviceSignService) throws RemoteException;

        public SignServiceFutureTask(Context context) {
            super(new Callable<Bundle>() {
                /* class com.xiaomi.passport.SecurityDeviceSignManager.SignServiceFutureTask.AnonymousClass1 */

                public Bundle call() throws Exception {
                    throw new IllegalStateException("should not be call here!");
                }
            });
            this.mContext = context;
        }

        public SignServiceFutureTask start() {
            Intent intent = new Intent("com.xiaomi.account.action.SECURITY_DEVICE_SIGN");
            intent.setPackage("com.xiaomi.account");
            if (!this.mContext.bindService(intent, this, 1)) {
                setException(Build.VERSION.SDK_INT >= 15 ? new RemoteException("failed to bind service") : new RemoteException());
                unbind();
            }
            return this;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                callServiceWork(ISecurityDeviceSignService.Stub.asInterface(iBinder));
            } catch (RemoteException e) {
                setException(e);
                unbind();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            unbind();
        }

        private void unbind() {
            Context context = this.mContext;
            if (context != null) {
                context.unbindService(this);
                this.mContext = null;
            }
        }

        class Response extends ISecurityDeviceSignResponse.Stub {
            private Response() {
            }

            public void onResult(Bundle bundle) throws RemoteException {
                SignServiceFutureTask.this.set(bundle);
            }
        }
    }
}
