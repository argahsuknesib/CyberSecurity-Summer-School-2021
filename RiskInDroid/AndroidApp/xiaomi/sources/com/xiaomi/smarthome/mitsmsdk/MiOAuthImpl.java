package com.xiaomi.smarthome.mitsmsdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.account.IMiOAuth;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.PrefUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MiOAuthImpl implements IMiOAuth {
    static ExecutorService sExecutor = Executors.newCachedThreadPool();
    private Context mContext;

    public MiOAuthImpl(Context context) {
        this.mContext = context;
    }

    public Future<Bundle> getAccessToken(String str) {
        LogUtils.i("MiOAuthImpl getAccessToken by OAuth");
        final String serviceToken = NfcChannelManager.getInstance().getServiceToken();
        final String uid = NfcChannelManager.getInstance().getUid();
        if (TextUtils.isEmpty(PrefUtils.getString(this.mContext, "accessToken", null))) {
            PrefUtils.putString(this.mContext, "accessToken", serviceToken);
            PrefUtils.putString(this.mContext, "userId", uid);
        }
        return sExecutor.submit(new Callable<Bundle>() {
            /* class com.xiaomi.smarthome.mitsmsdk.MiOAuthImpl.AnonymousClass1 */

            public Bundle call() throws Exception {
                Bundle bundle = new Bundle();
                bundle.putString("accessToken", serviceToken);
                bundle.putString("userId", uid);
                return bundle;
            }
        });
    }

    public void invalidateAccessToken(String str, String str2) {
        PrefUtils.remove(this.mContext, "accessToken");
    }
}
