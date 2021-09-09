package com.xiaomi.onetrack.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.xiaomi.onetrack.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f6170a = "d";
    private static volatile d e;
    /* access modifiers changed from: private */
    public final Context g = a.a();
    /* access modifiers changed from: private */
    public Handler h = new e(this, Looper.getMainLooper());
    private BroadcastReceiver i = new f(this);

    public static d a() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    private d() {
        a(this.g);
    }

    private void a(Context context) {
        if (context != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.xiaomi.onetrack.DEBUG");
                context.registerReceiver(this.i, intentFilter, "com.xiaomi.onetrack.permissions.DEBUG_MODE", null);
            } catch (Exception e2) {
                q.a(f6170a, "registerDebugModeReceiver: ".concat(String.valueOf(e2)));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        j.a(new g(this, str, str2, str3));
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("message");
            String optString2 = jSONObject.optString("result");
            boolean optBoolean = jSONObject.optBoolean("success");
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            if (optInt != 0 || !optBoolean) {
                bundle.putString("hint", optString);
            } else {
                bundle.putString("hint", optString2);
            }
            obtain.setData(bundle);
            this.h.sendMessage(obtain);
        } catch (JSONException e2) {
            q.b(f6170a, e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        Toast.makeText(this.g, str, 1).show();
    }
}
