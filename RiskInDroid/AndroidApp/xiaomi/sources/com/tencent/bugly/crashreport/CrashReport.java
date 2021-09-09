package com.tencent.bugly.crashreport;

import _m_j.dgj;
import _m_j.dgk;
import _m_j.dgm;
import _m_j.dgq;
import _m_j.dgs;
import _m_j.dha;
import _m_j.did;
import android.content.Context;
import android.util.Log;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;

public final class CrashReport {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Context f5809O000000o;

    public static class O000000o extends dgj.O000000o {
    }

    public static void O000000o(Throwable th) {
        Thread currentThread = Thread.currentThread();
        if (!dgm.f14605O000000o) {
            Log.w(did.f14660O000000o, "Can not post crash caught because bugly is disable.");
        } else if (!dgk.O00000Oo()) {
            Log.e(did.f14660O000000o, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            did.O00000o("throwable is null, just return", new Object[0]);
        } else {
            if (currentThread == null) {
                currentThread = Thread.currentThread();
            }
            dha O000000o2 = dha.O000000o();
            O000000o2.O0000oO0.O000000o(new Runnable(currentThread, th, false) {
                /* class _m_j.dha.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                private /* synthetic */ boolean f14632O000000o = false;
                private /* synthetic */ Thread O00000Oo;
                private /* synthetic */ String O00000o;
                private /* synthetic */ Throwable O00000o0;
                private /* synthetic */ byte[] O00000oO;
                private /* synthetic */ boolean O00000oo;

                {
                    this.O00000Oo = r2;
                    this.O00000o0 = r3;
                    this.O00000o = null;
                    this.O00000oO = null;
                    this.O00000oo = false;
                }

                public final void run() {
                    try {
                        did.O00000o0("post a throwable %b", Boolean.valueOf(this.f14632O000000o));
                        dha.this.O0000o0o.O000000o(this.O00000Oo, this.O00000o0, false, this.O00000o, this.O00000oO);
                        if (this.O00000oo) {
                            did.O000000o("clear user datas", new Object[0]);
                            dgs.O000000o(dha.this.O0000oOO).O00oOooO();
                        }
                    } catch (Throwable th) {
                        if (!did.O00000Oo(th)) {
                            th.printStackTrace();
                        }
                        did.O00000oO("java catch error: %s", this.O00000o0.toString());
                    }
                }
            });
        }
    }

    public static void O000000o(Context context, String str, String str2) {
        if (!dgm.f14605O000000o) {
            Log.w(did.f14660O000000o, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(did.f14660O000000o, "putUserData args context should not be null");
        } else if (str2 == null) {
            String.valueOf(str2);
            did.O00000o("putUserData args value should not be null", new Object[0]);
        } else if (!str.matches("[a-zA-Z[0-9]]+")) {
            did.O00000o("putUserData args key should match [a-zA-Z[0-9]]+  {" + str + "}", new Object[0]);
        } else {
            if (str2.length() > 200) {
                did.O00000o("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            dgs O000000o2 = dgs.O000000o(context);
            if (O000000o2.O000O00o().contains(str)) {
                NativeCrashHandler O000000o3 = NativeCrashHandler.O000000o();
                if (O000000o3 != null) {
                    O000000o3.O000000o(str, str2);
                }
                dgs.O000000o(context).O000000o(str, str2);
                did.O00000o0("replace KV %s %s", str, str2);
            } else if (O000000o2.O00oOooo() >= 10) {
                did.O00000o("user data size is over limit %d, it will be cutted!", 10);
            } else {
                if (str.length() > 50) {
                    did.O00000o("user data key length over limit %d , will drop this new key %s", 50, str);
                    str = str.substring(0, 50);
                }
                NativeCrashHandler O000000o4 = NativeCrashHandler.O000000o();
                if (O000000o4 != null) {
                    O000000o4.O000000o(str, str2);
                }
                dgs.O000000o(context).O000000o(str, str2);
                did.O00000Oo("[param] set user data: %s - %s", str, str2);
            }
        }
    }

    public static void O000000o(String str) {
        if (!dgm.f14605O000000o) {
            Log.w(did.f14660O000000o, "Can not set user ID because bugly is disable.");
        } else if (!dgk.O00000Oo()) {
            Log.e(did.f14660O000000o, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            Context context = f5809O000000o;
            if (!dgm.f14605O000000o) {
                Log.w(did.f14660O000000o, "Can not set user ID because bugly is disable.");
            } else if (context == null) {
                Log.e(did.f14660O000000o, "Context should not be null when bugly has not been initialed!");
            } else if (str == null) {
                did.O00000o("userId should not be null", new Object[0]);
            } else {
                if (str.length() > 100) {
                    String substring = str.substring(0, 100);
                    did.O00000o("userId %s length is over limit %d substring to %s", str, 100, substring);
                    str = substring;
                }
                if (!str.equals(dgs.O000000o(context).O00000o())) {
                    dgs O000000o2 = dgs.O000000o(context);
                    synchronized (O000000o2.O000OOo) {
                        O000000o2.O0000Ooo = String.valueOf(str == null ? "10000" : str);
                    }
                    did.O00000Oo("[user] set userId : %s", str);
                    NativeCrashHandler O000000o3 = NativeCrashHandler.O000000o();
                    if (O000000o3 != null) {
                        O000000o3.O000000o(11, str);
                    }
                    if (dgk.O00000Oo()) {
                        dgq.O000000o();
                    }
                }
            }
        }
    }

    public static class UserStrategy extends dgj {
        private O000000o O00000Oo;

        public UserStrategy(Context context) {
        }

        /* access modifiers changed from: private */
        /* renamed from: O0000o0O */
        public synchronized O000000o O0000o0() {
            return this.O00000Oo;
        }

        public final synchronized void O000000o(O000000o o000000o) {
            this.O00000Oo = o000000o;
        }
    }
}
