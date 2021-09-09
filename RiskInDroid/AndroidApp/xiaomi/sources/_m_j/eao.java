package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.hz;
import com.xiaomi.push.ic;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.iv;
import com.xiaomi.push.ja;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class eao {
    private static eao O00000o0 = null;
    private static boolean O00000oo = false;
    private static final ArrayList<O000000o> O0000O0o = new ArrayList<>();
    /* access modifiers changed from: package-private */

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f15127O000000o;
    private boolean O00000Oo = false;
    private String O00000o;
    /* access modifiers changed from: private */
    public Messenger O00000oO;
    private Handler O0000OOo = null;
    /* access modifiers changed from: private */
    public boolean O0000Oo = false;
    /* access modifiers changed from: private */
    public List<Message> O0000Oo0 = new ArrayList();
    private Intent O0000OoO = null;
    /* access modifiers changed from: private */
    public Integer O0000Ooo = null;

    static class O000000o<T extends ja<T, ?>> {

        /* renamed from: O000000o  reason: collision with root package name */
        T f15128O000000o;
        hp O00000Oo;
        boolean O00000o0;

        O000000o() {
        }
    }

    public static synchronized eao O000000o(Context context) {
        eao eao;
        synchronized (eao.class) {
            if (O00000o0 == null) {
                O00000o0 = new eao(context);
            }
            eao = O00000o0;
        }
        return eao;
    }

    private synchronized void O000000o(int i) {
        this.f15127O000000o.getSharedPreferences("mipush_extra", 0).edit().putInt("service_boot_mode", i).commit();
    }

    private static <T extends ja<T, ?>> void O000000o(ja jaVar, hp hpVar, boolean z) {
        O000000o o000000o = new O000000o();
        o000000o.f15128O000000o = jaVar;
        o000000o.O00000Oo = hpVar;
        o000000o.O00000o0 = z;
        synchronized (O0000O0o) {
            O0000O0o.add(o000000o);
            if (O0000O0o.size() > 10) {
                O0000O0o.remove(0);
            }
        }
    }

    private synchronized void O00000o(Intent intent) {
        if (this.O0000Oo) {
            Message O00000oO2 = O00000oO(intent);
            if (this.O0000Oo0.size() >= 50) {
                this.O0000Oo0.remove(0);
            }
            this.O0000Oo0.add(O00000oO2);
        } else if (this.O00000oO == null) {
            this.f15127O000000o.bindService(intent, new eas(this), 1);
            this.O0000Oo = true;
            this.O0000Oo0.clear();
            this.O0000Oo0.add(O00000oO(intent));
        } else {
            try {
                this.O00000oO.send(O00000oO(intent));
            } catch (RemoteException unused) {
                this.O00000oO = null;
                this.O0000Oo = false;
            }
        }
    }

    private static Message O00000oO(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    private synchronized int O0000O0o() {
        return this.f15127O000000o.getSharedPreferences("mipush_extra", 0).getInt("service_boot_mode", -1);
    }

    private boolean O0000OOo() {
        try {
            PackageInfo packageInfo = this.f15127O000000o.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Intent O0000Oo() {
        Intent intent = new Intent();
        String packageName = this.f15127O000000o.getPackageName();
        O0000o00();
        intent.setComponent(new ComponentName(this.f15127O000000o, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private Intent O0000Oo0() {
        Intent intent = new Intent();
        String packageName = this.f15127O000000o.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", O0000OoO());
        intent.putExtra("mipush_app_package", packageName);
        O0000Ooo();
        return intent;
    }

    private String O0000OoO() {
        try {
            return this.f15127O000000o.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private void O0000Ooo() {
        try {
            PackageManager packageManager = this.f15127O000000o.getPackageManager();
            ComponentName componentName = new ComponentName(this.f15127O000000o, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean O0000o0() {
        if (O00000o0()) {
            try {
                return this.f15127O000000o.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private void O0000o00() {
        try {
            PackageManager packageManager = this.f15127O000000o.getPackageManager();
            ComponentName componentName = new ComponentName(this.f15127O000000o, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean O0000o0O() {
        String packageName = this.f15127O000000o.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f15127O000000o.getApplicationInfo().flags & 1) != 0;
    }

    public final void O000000o() {
        O00000Oo(O00000Oo());
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, int i2) {
        Intent O00000Oo2 = O00000Oo();
        O00000Oo2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        O00000Oo2.putExtra(bd.A, this.f15127O000000o.getPackageName());
        O00000Oo2.putExtra(bd.B, i);
        O00000Oo2.putExtra(bd.C, i2);
        O00000o0(O00000Oo2);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Intent intent) {
        intent.fillIn(O00000Oo(), 24);
        O00000o0(intent);
    }

    public final <T extends ja<T, ?>> void O000000o(ja jaVar, hp hpVar, ic icVar) {
        O000000o(jaVar, hpVar, !hpVar.equals(hp.f6389a), icVar);
    }

    public final <T extends ja<T, ?>> void O000000o(T t, hp hpVar, boolean z, ic icVar) {
        O000000o(t, hpVar, z, true, icVar, true);
    }

    public final <T extends ja<T, ?>> void O000000o(T t, hp hpVar, boolean z, boolean z2) {
        O000000o(t, hpVar, z, true, null, z2);
    }

    public final <T extends ja<T, ?>> void O000000o(T t, hp hpVar, boolean z, boolean z2, ic icVar, boolean z3, String str, String str2) {
        O000000o(t, hpVar, z, z2, icVar, z3, str, str2, true);
    }

    public final <T extends ja<T, ?>> void O000000o(T t, hp hpVar, boolean z, boolean z2, ic icVar, boolean z3, String str, String str2, boolean z4) {
        O000000o(t, hpVar, z, z2, icVar, z3, str, str2, z4, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
     arg types: [java.lang.String, com.xiaomi.mipush.sdk.au, int, java.util.HashMap<java.lang.String, java.lang.String>]
     candidates:
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void */
    public final void O000000o(String str, au auVar, e eVar) {
        eah.O000000o(this.f15127O000000o).O000000o(auVar, "syncing");
        O000000o(str, auVar, false, ebb.O00000Oo(this.f15127O000000o, eVar));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
     arg types: [java.lang.String, com.xiaomi.mipush.sdk.au, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void */
    public final void O000000o(boolean z, String str) {
        au auVar;
        if (z) {
            eah.O000000o(this.f15127O000000o).O000000o(au.f6052a, "syncing");
            eah.O000000o(this.f15127O000000o).O000000o(au.b, "");
            auVar = au.f6052a;
        } else {
            eah.O000000o(this.f15127O000000o).O000000o(au.b, "syncing");
            eah.O000000o(this.f15127O000000o).O000000o(au.f6052a, "");
            auVar = au.b;
        }
        O000000o(str, auVar, true, (HashMap<String, String>) null);
    }

    /* access modifiers changed from: package-private */
    public final Intent O00000Oo() {
        return (!O00000o0() || "com.xiaomi.xmsf".equals(this.f15127O000000o.getPackageName())) ? O0000Oo() : O0000Oo0();
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(Intent intent) {
        try {
            if (esl.O000000o() || Build.VERSION.SDK_INT < 26) {
                this.f15127O000000o.startService(intent);
            } else {
                O00000o(intent);
            }
        } catch (Exception e) {
            duv.O000000o(e);
        }
    }

    public final void O00000o() {
        Intent intent = this.O0000OoO;
        if (intent != null) {
            O00000o0(intent);
            this.O0000OoO = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(Intent intent) {
        int a2 = at.a(this.f15127O000000o).a(hu.T.a(), hq.f6390a.a());
        int O0000O0o2 = O0000O0o();
        boolean z = a2 == hq.b.a() && O00000oo;
        int a3 = (z ? hq.b : hq.f6390a).a();
        if (a3 != O0000O0o2) {
            O00000Oo(a3);
        }
        if (z) {
            O00000o(intent);
        } else {
            O00000Oo(intent);
        }
    }

    public final void O00000oO() {
        synchronized (O0000O0o) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<O000000o> it = O0000O0o.iterator();
            while (it.hasNext()) {
                O000000o next = it.next();
                O000000o(next.f15128O000000o, next.O00000Oo, next.O00000o0, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            O0000O0o.clear();
        }
    }

    public final boolean O00000oo() {
        if (!O00000o0() || !O0000o0O()) {
            return true;
        }
        if (this.O0000Ooo == null) {
            this.O0000Ooo = Integer.valueOf(bg.a(this.f15127O000000o).a());
            if (this.O0000Ooo.intValue() == 0) {
                this.f15127O000000o.getContentResolver().registerContentObserver(bg.a(this.f15127O000000o).m186a(), false, new ear(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.O0000Ooo.intValue() != 0;
    }

    private eao(Context context) {
        Intent intent;
        this.f15127O000000o = context.getApplicationContext();
        this.O00000o = null;
        this.O00000Oo = O0000OOo();
        O00000oo = O0000o0();
        this.O0000OOo = new eap(this, Looper.getMainLooper());
        if (esl.O000000o(context)) {
            com.xiaomi.push.service.e.a(new eaq(this));
        }
        if ("com.xiaomi.xmsf".equals(this.f15127O000000o.getPackageName())) {
            duv.O00000o0("pushChannel xmsf create own channel");
            intent = O0000Oo();
        } else if (O00000o0()) {
            duv.O00000o0("pushChannel app start miui china channel");
            intent = O0000Oo0();
        } else {
            duv.O00000o0("pushChannel app start  own channel");
            intent = O0000Oo();
        }
        O00000Oo(intent);
    }

    public final void O000000o(ip ipVar, boolean z) {
        epj.O000000o(this.f15127O000000o.getApplicationContext()).O000000o(this.f15127O000000o.getPackageName(), "E100003", ipVar.f144b, 6001, null);
        this.O0000OoO = null;
        b.O000000o(this.f15127O000000o).O00000o = ipVar.f144b;
        Intent O00000Oo2 = O00000Oo();
        byte[] O000000o2 = eru.O000000o(eai.O000000o(this.f15127O000000o, ipVar, hp.f6389a));
        if (O000000o2 == null) {
            duv.O000000o("register fail, because msgBytes is null.");
            return;
        }
        O00000Oo2.setAction("com.xiaomi.mipush.REGISTER_APP");
        O00000Oo2.putExtra("mipush_app_id", b.O000000o(this.f15127O000000o).O00000Oo.f6054O000000o);
        O00000Oo2.putExtra("mipush_payload", O000000o2);
        O00000Oo2.putExtra("mipush_session", this.O00000o);
        O00000Oo2.putExtra("mipush_env_chanage", z);
        O00000Oo2.putExtra("mipush_env_type", b.O000000o(this.f15127O000000o).O00000Oo.O0000OoO);
        if (!emf.O000000o(this.f15127O000000o) || !O00000oo()) {
            this.O0000OoO = O00000Oo2;
        } else {
            O00000o0(O00000Oo2);
        }
    }

    public final void O000000o(iv ivVar) {
        byte[] O000000o2 = eru.O000000o(eai.O000000o(this.f15127O000000o, ivVar, hp.b));
        if (O000000o2 == null) {
            duv.O000000o("unregister fail, because msgBytes is null.");
            return;
        }
        Intent O00000Oo2 = O00000Oo();
        O00000Oo2.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        O00000Oo2.putExtra("mipush_app_id", b.O000000o(this.f15127O000000o).O00000Oo.f6054O000000o);
        O00000Oo2.putExtra("mipush_payload", O000000o2);
        O00000o0(O00000Oo2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* access modifiers changed from: private */
    public void O000000o(String str, au auVar, boolean z, HashMap<String, String> hashMap) {
        io ioVar;
        if (b.O000000o(this.f15127O000000o).O000000o() && emf.O000000o(this.f15127O000000o)) {
            io ioVar2 = new io();
            ioVar2.O000000o(true);
            Intent O00000Oo2 = O00000Oo();
            if (TextUtils.isEmpty(str)) {
                str = aw.a();
                ioVar2.b = str;
                ioVar = z ? new io(str, true) : null;
                synchronized (eah.class) {
                    eah.O000000o(this.f15127O000000o).O000000o(str);
                }
            } else {
                ioVar2.b = str;
                ioVar = z ? new io(str, true) : null;
            }
            switch (eat.f15133O000000o[auVar.ordinal()]) {
                case 1:
                    ioVar2.d = hz.E.f70a;
                    ioVar.d = hz.E.f70a;
                    if (hashMap != null) {
                        ioVar2.f133a = hashMap;
                        ioVar.f133a = hashMap;
                    }
                    O00000Oo2.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    ioVar2.d = hz.F.f70a;
                    ioVar.d = hz.F.f70a;
                    if (hashMap != null) {
                        ioVar2.f133a = hashMap;
                        ioVar.f133a = hashMap;
                    }
                    O00000Oo2.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ioVar2.d = hz.N.f70a;
                    if (hashMap != null) {
                        ioVar2.f133a = hashMap;
                        break;
                    }
                    break;
            }
            duv.O00000oo("type:" + auVar + ", " + str);
            ioVar2.c = b.O000000o(this.f15127O000000o).O00000Oo.f6054O000000o;
            ioVar2.f = this.f15127O000000o.getPackageName();
            O000000o((ja) ioVar2, hp.i, false, (ic) null);
            if (z) {
                ioVar.c = b.O000000o(this.f15127O000000o).O00000Oo.f6054O000000o;
                ioVar.f = this.f15127O000000o.getPackageName();
                byte[] O000000o2 = eru.O000000o(eai.O000000o(this.f15127O000000o, ioVar, hp.i, false, this.f15127O000000o.getPackageName(), b.O000000o(this.f15127O000000o).O00000Oo.f6054O000000o));
                if (O000000o2 != null) {
                    env.O000000o(this.f15127O000000o.getPackageName(), this.f15127O000000o, ioVar, hp.i, O000000o2.length);
                    O00000Oo2.putExtra("mipush_payload", O000000o2);
                    O00000Oo2.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    O00000Oo2.putExtra("mipush_app_id", b.O000000o(this.f15127O000000o).O00000Oo.f6054O000000o);
                    O00000Oo2.putExtra("mipush_app_token", b.O000000o(this.f15127O000000o).O00000Oo.O00000Oo);
                    O00000o0(O00000Oo2);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = auVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.O0000OOo.sendMessageDelayed(obtain, 5000);
        }
    }

    private <T extends ja<T, ?>> void O000000o(T t, hp hpVar, boolean z, boolean z2, ic icVar, boolean z3) {
        O000000o(t, hpVar, z, z2, icVar, z3, this.f15127O000000o.getPackageName(), b.O000000o(this.f15127O000000o).O00000Oo.f6054O000000o);
    }

    public final <T extends ja<T, ?>> void O000000o(T t, hp hpVar, boolean z, boolean z2, ic icVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        ic icVar2 = icVar;
        if (!z5 || b.O000000o(this.f15127O000000o).O00000Oo.O000000o()) {
            il O000000o2 = z4 ? eai.O000000o(this.f15127O000000o, t, hpVar, z, str, str2) : eai.O00000Oo(this.f15127O000000o, t, hpVar, z, str, str2);
            if (icVar2 != null) {
                O000000o2.f122a = icVar2;
            }
            byte[] O000000o3 = eru.O000000o(O000000o2);
            if (O000000o3 == null) {
                duv.O000000o("send message fail, because msgBytes is null.");
                return;
            }
            env.O000000o(this.f15127O000000o.getPackageName(), this.f15127O000000o, t, hpVar, O000000o3.length);
            Intent O00000Oo2 = O00000Oo();
            O00000Oo2.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            O00000Oo2.putExtra("mipush_payload", O000000o3);
            O00000Oo2.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            O00000o0(O00000Oo2);
        } else if (z2) {
            O000000o(t, hpVar, z);
        } else {
            duv.O000000o("drop the message before initialization.");
        }
    }

    public final boolean O00000o0() {
        return this.O00000Oo && 1 == b.O000000o(this.f15127O000000o).O00000Oo.O0000OoO;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    private boolean O00000Oo(int i) {
        if (!b.O000000o(this.f15127O000000o).O000000o()) {
            return false;
        }
        O000000o(i);
        io ioVar = new io();
        ioVar.b = aw.a();
        ioVar.c = b.O000000o(this.f15127O000000o).O00000Oo.f6054O000000o;
        ioVar.f = this.f15127O000000o.getPackageName();
        ioVar.d = hz.G.f70a;
        ioVar.f133a = new HashMap();
        ioVar.f133a.put("boot_mode", String.valueOf(i));
        O000000o(this.f15127O000000o).O000000o((ja) ioVar, hp.i, false, (ic) null);
        return true;
    }
}
