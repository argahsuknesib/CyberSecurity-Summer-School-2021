package com.xiaomi.onetrack.a;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.CrashAnalysis;
import com.xiaomi.onetrack.OnMainThreadException;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.r;
import com.xiaomi.onetrack.h.s;
import com.xiaomi.onetrack.h.v;
import com.xiaomi.onetrack.h.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private static ExecutorService c;
    /* access modifiers changed from: private */
    public d b;
    private Context d;
    private e e;
    /* access modifiers changed from: private */
    public Configuration f;
    private OneTrack.ICommonPropertyProvider g;
    /* access modifiers changed from: private */
    public OneTrack.IEventHook h;
    private BroadcastReceiver i = new w(this);

    public f(Context context, Configuration configuration) {
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        this.f = configuration;
        b(applicationContext);
        Log.d("OneTrackImp", "OneTrackImp init : " + configuration.toString());
    }

    private void b(Context context) {
        q.a();
        r.a(this.f.isInternational(), this.f.getRegion(), this.f.getMode());
        if (c == null) {
            c = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
        if (!r.a() || !e() || !c()) {
            p.a().a(Boolean.FALSE);
            this.b = new ae(context, this.f);
        } else {
            p.a().a(Boolean.TRUE);
            this.b = new ag(context, this.f);
        }
        if (this.f.getMode() == OneTrack.Mode.APP) {
            r.a(this.f.isOverrideMiuiRegionSetting());
            c(context);
            if (this.f.isExceptionCatcherEnable()) {
                CrashAnalysis.start(context, this);
                if (!CrashAnalysis.isSupport()) {
                    this.e = new e();
                    this.e.a();
                }
            }
        }
        d(context);
        c.execute(new g(this));
    }

    private boolean c() {
        if (!this.f.isOverrideMiuiRegionSetting()) {
            return true;
        }
        return TextUtils.equals(r.C(), this.f.getRegion());
    }

    public void a(String str, String str2, Map<String, Object> map) {
        c.execute(new r(this, str2, map, str));
    }

    public void a(String str, Map<String, Object> map) {
        c.execute(new x(this, str, map));
    }

    public void a(String str, String str2) {
        c.execute(new y(this, str, str2));
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        c.execute(new z(this, str, str2, str3, str5, str4));
    }

    public void a(Map<String, Object> map) {
        c.execute(new aa(this, map));
    }

    public void a(String str, Object obj) {
        c.execute(new ab(this, obj, str));
    }

    public void a(String str, OneTrack.UserIdType userIdType, Map<String, Object> map, boolean z) {
        c.execute(new ac(this, str, userIdType, z, map));
    }

    public void b(Map<String, ? extends Number> map) {
        c.execute(new ad(this, map));
    }

    public void a(String str, Number number) {
        c.execute(new h(this, str, number));
    }

    public void a(Map<String, Object> map, boolean z) {
        c.execute(new i(this, z, map));
    }

    private void c(Context context) {
        ((Application) context).registerActivityLifecycleCallbacks(new j(this));
    }

    /* access modifiers changed from: private */
    public void d() {
        c.execute(new k(this));
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z) {
        c.execute(new l(this, str, z));
    }

    /* access modifiers changed from: private */
    public void a(String str, long j) {
        c.execute(new m(this, str, j));
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        c.execute(new n(this, z));
    }

    private boolean e() {
        if (q.f6178a) {
            q.a("OneTrackImp", "enable:" + f() + " isServiceOnline: " + g());
        }
        return f() && g() && h();
    }

    private boolean f() {
        try {
            int componentEnabledSetting = a.a().getPackageManager().getComponentEnabledSetting(new ComponentName("com.miui.analytics", "com.miui.analytics.onetrack.OneTrackService"));
            if (componentEnabledSetting == 1 || componentEnabledSetting == 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            q.b("OneTrackImp", "enable error:" + e2.toString());
            return false;
        }
    }

    private static boolean g() {
        List<ResolveInfo> queryIntentServices;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.miui.analytics", "com.miui.analytics.onetrack.OneTrackService");
            if (a.a() == null || a.a().getPackageManager() == null || (queryIntentServices = a.a().getPackageManager().queryIntentServices(intent, 0)) == null || queryIntentServices.size() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            q.a("OneTrackImp", "isServiceOnline: " + e2.toString());
        }
    }

    private static boolean h() {
        try {
            int i2 = a.a().getPackageManager().getPackageInfo("com.miui.analytics", 0).versionCode;
            if (i2 >= 2020062900) {
                return true;
            }
            q.a("OneTrackImp", "system analytics version: ".concat(String.valueOf(i2)));
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        boolean a2 = s.a(str);
        if (!a2) {
            q.b("OneTrackImp", String.format("Invalid eventname: %s. Eventname can only consist of numbers, letters, underscores ,and can not start with a number or \"onetrack_\" or \"ot_\"", str));
        }
        return !a2;
    }

    public void c(Map<String, Object> map) {
        if (map != null) {
            c.execute(new o(this, map));
        }
    }

    /* access modifiers changed from: private */
    public String i() {
        StringBuilder sb = new StringBuilder();
        String appId = this.f.getAppId();
        String pluginId = this.f.getPluginId();
        if (!TextUtils.isEmpty(appId)) {
            sb.append(appId);
        }
        if (!TextUtils.isEmpty(pluginId)) {
            sb.append(pluginId);
        }
        return d.h(sb.toString());
    }

    public void a() {
        c.execute(new p(this));
    }

    public void a(String str) {
        c.execute(new q(this, str));
    }

    public void a(OneTrack.ICommonPropertyProvider iCommonPropertyProvider) {
        this.g = iCommonPropertyProvider;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, boolean):org.json.JSONObject
     arg types: [java.util.Map<java.lang.String, java.lang.Object>, int]
     candidates:
      com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, com.xiaomi.onetrack.h.s$a):org.json.JSONObject
      com.xiaomi.onetrack.h.s.a(org.json.JSONObject, org.json.JSONObject):org.json.JSONObject
      com.xiaomi.onetrack.h.s.a(java.lang.String, java.lang.String):void
      com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, boolean):org.json.JSONObject */
    /* access modifiers changed from: private */
    public JSONObject d(String str) {
        try {
            JSONObject a2 = s.a(this.g != null ? this.g.getDynamicProperty(str) : null, false);
            String a3 = l.a(i());
            return s.a(a2, !TextUtils.isEmpty(a3) ? new JSONObject(a3) : null);
        } catch (Exception e2) {
            q.b("OneTrackImp", "getCommonProperty: " + e2.toString());
            return null;
        }
    }

    public void b(String str) {
        c.execute(new s(this, str));
    }

    public String b() throws OnMainThreadException {
        if (!v.a()) {
            return p.a().b();
        }
        throw new OnMainThreadException("Can't call this method on main thread");
    }

    public String a(Context context) throws OnMainThreadException {
        if (!v.a()) {
            return h.y(context);
        }
        throw new OnMainThreadException("Can't call this method on main thread");
    }

    public void a(ServiceQualityEvent serviceQualityEvent) {
        if (serviceQualityEvent != null) {
            c.execute(new t(this, serviceQualityEvent));
        }
    }

    public void a(boolean z) {
        q.f6178a = z;
    }

    private void j() {
        c.execute(new u(this));
    }

    /* access modifiers changed from: private */
    public void k() {
        c.execute(new v(this));
    }

    /* access modifiers changed from: private */
    public void l() {
        try {
            if (this.f.getMode() == OneTrack.Mode.APP) {
                long c2 = (long) a.c();
                String a2 = a(c2, a.b());
                String A = z.A();
                if (TextUtils.isEmpty(A)) {
                    z.j(a2);
                    return;
                }
                JSONObject jSONObject = new JSONObject(A);
                long optLong = jSONObject.optLong("last_ver_code");
                String optString = jSONObject.optString("last_ver_name");
                if (optLong != c2) {
                    z.j(a2);
                    this.b.a("onetrack_upgrade", c.a(optLong, optString, c2, a.e(), this.f, this.h));
                }
            }
        } catch (Exception e2) {
            q.b("OneTrackImp", "trackUpgradeEvent error: " + e2.toString());
        }
    }

    private String a(long j, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("last_ver_name", str);
        jSONObject.put("last_ver_code", j);
        return jSONObject.toString();
    }

    public void a(OneTrack.IEventHook iEventHook) {
        this.h = iEventHook;
    }

    private void d(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(this.i, intentFilter);
        } catch (Exception unused) {
        }
    }
}
