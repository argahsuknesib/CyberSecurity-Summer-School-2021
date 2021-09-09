package com.xiaomi.push.service;

import _m_j.ell;
import _m_j.elo;
import _m_j.emf;
import _m_j.ess;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;

public final class bq implements al {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bq f6532a;

    /* renamed from: a  reason: collision with other field name */
    private long f298a;

    /* renamed from: a  reason: collision with other field name */
    Context f299a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f300a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f301a = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f302a = false;

    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        long f6533a;

        /* renamed from: a  reason: collision with other field name */
        String f303a;

        a(String str, long j) {
            this.f303a = str;
            this.f6533a = j;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(bq bqVar);

        public void run() {
            if (bq.a() != null && emf.O00000o0(bq.a().f299a)) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences a2 = bq.a(bq.a());
                if (currentTimeMillis - a2.getLong(":ts-" + this.f303a, 0) > this.f6533a || ell.O000000o()) {
                    SharedPreferences.Editor edit = bq.a(bq.a()).edit();
                    ess.O000000o(edit.putLong(":ts-" + this.f303a, System.currentTimeMillis()));
                    a(bq.a());
                }
            }
        }
    }

    private bq(Context context) {
        this.f299a = context.getApplicationContext();
        this.f300a = context.getSharedPreferences("sync", 0);
    }

    public static bq a(Context context) {
        if (f6532a == null) {
            synchronized (bq.class) {
                if (f6532a == null) {
                    f6532a = new bq(context);
                }
            }
        }
        return f6532a;
    }

    public final String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f300a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    public final void a() {
        if (!this.f302a) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f298a >= 3600000) {
                this.f298a = currentTimeMillis;
                this.f302a = true;
                elo.O000000o(this.f299a).O000000o(new br(this), (int) (Math.random() * 10.0d));
            }
        }
    }

    public final void a(a aVar) {
        if (this.f301a.putIfAbsent(aVar.f303a, aVar) == null) {
            elo.O000000o(this.f299a).O000000o(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public final void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f6532a.f300a.edit();
        ess.O000000o(edit.putString(str + ":" + str2, str3));
    }
}
