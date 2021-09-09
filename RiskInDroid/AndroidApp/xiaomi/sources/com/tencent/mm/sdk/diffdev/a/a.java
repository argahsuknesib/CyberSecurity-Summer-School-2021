package com.tencent.mm.sdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.b.d;
import com.tencent.mm.sdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

public final class a implements IDiffDevOAuth {
    /* access modifiers changed from: private */
    public d ac = null;
    /* access modifiers changed from: private */
    public List<OAuthListener> ad = new ArrayList();
    /* access modifiers changed from: private */
    public d ae;
    private OAuthListener af = new b(this);

    public final void addListener(OAuthListener oAuthListener) {
        if (!this.ad.contains(oAuthListener)) {
            this.ad.add(oAuthListener);
        }
    }

    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
            return false;
        }
        if (this.ac == null) {
            this.ac = new d(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.ae != null) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        this.ae = new d(str, str2, str3, str4, str5, this.af);
        d dVar = this.ae;
        if (Build.VERSION.SDK_INT >= 11) {
            dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            dVar.execute(new Void[0]);
        }
        return true;
    }

    public final void detach() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.ad.clear();
        stopAuth();
    }

    public final void removeAllListeners() {
        this.ad.clear();
    }

    public final void removeListener(OAuthListener oAuthListener) {
        this.ad.remove(oAuthListener);
    }

    public final boolean stopAuth() {
        boolean z;
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            z = this.ae == null ? true : this.ae.q();
        } catch (Exception e) {
            Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            z = false;
        }
        this.ae = null;
        return z;
    }
}
