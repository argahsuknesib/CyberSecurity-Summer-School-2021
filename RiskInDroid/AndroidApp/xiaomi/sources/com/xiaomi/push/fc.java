package com.xiaomi.push;

import _m_j.duv;
import _m_j.emg;
import _m_j.epp;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.i;

public class fc implements epp.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f6376O000000o = null;
    private PendingIntent O00000Oo = null;
    private volatile long O00000o0 = 0;

    public fc(Context context) {
        this.f6376O000000o = context;
    }

    public final void O000000o() {
        if (this.O00000Oo != null) {
            try {
                ((AlarmManager) this.f6376O000000o.getSystemService("alarm")).cancel(this.O00000Oo);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.O00000Oo = null;
                duv.O00000o0("[Alarm] unregister timer");
                this.O00000o0 = 0;
                throw th;
            }
            this.O00000Oo = null;
            duv.O00000o0("[Alarm] unregister timer");
            this.O00000o0 = 0;
        }
        this.O00000o0 = 0;
    }

    public final boolean O00000Oo() {
        return this.O00000o0 != 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [android.app.AlarmManager, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r11.O00000o0 < r4) goto L_0x003c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085  */
    public final void O000000o(boolean z) {
        long a2 = i.a(this.f6376O000000o).m205a();
        if (z || this.O00000o0 != 0) {
            if (z) {
                O000000o();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.O00000o0 == 0) {
                a2 -= elapsedRealtime % a2;
            } else {
                if (this.O00000o0 <= elapsedRealtime) {
                    this.O00000o0 += a2;
                }
                Intent intent = new Intent(bd.o);
                intent.setPackage(this.f6376O000000o.getPackageName());
                long j = this.O00000o0;
                AlarmManager alarmManager = (AlarmManager) this.f6376O000000o.getSystemService("alarm");
                this.O00000Oo = PendingIntent.getBroadcast(this.f6376O000000o, 0, intent, 0);
                if (Build.VERSION.SDK_INT < 23) {
                    emg.O000000o((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.O00000Oo);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    try {
                        AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), this.O00000Oo);
                    } catch (Exception e) {
                        duv.O00000o("[Alarm] invoke setExact method meet error. ".concat(String.valueOf(e)));
                    }
                } else {
                    alarmManager.set(2, j, this.O00000Oo);
                }
                duv.O00000o0("[Alarm] register timer ".concat(String.valueOf(j)));
            }
            this.O00000o0 = elapsedRealtime + a2;
            Intent intent2 = new Intent(bd.o);
            intent2.setPackage(this.f6376O000000o.getPackageName());
            long j2 = this.O00000o0;
            AlarmManager alarmManager2 = (AlarmManager) this.f6376O000000o.getSystemService("alarm");
            this.O00000Oo = PendingIntent.getBroadcast(this.f6376O000000o, 0, intent2, 0);
            if (Build.VERSION.SDK_INT < 23) {
            }
            duv.O00000o0("[Alarm] register timer ".concat(String.valueOf(j2)));
        }
    }
}
