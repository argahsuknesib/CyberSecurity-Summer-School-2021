package com.xiaomi.smarthome.core.server.internal.bluetooth.model;

import _m_j.fas;
import _m_j.fec;
import _m_j.fkv;
import _m_j.fte;
import _m_j.glc;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public final class BleDevicePropCache extends glc {
    public static final Executor O00000o = new SerialExecutor();
    private static volatile BleDevicePropCache O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    String f6813O000000o;
    SharedPreferences O00000Oo;
    HashMap<String, BleDeviceProp> O00000o0 = new HashMap<>();
    public volatile int O00000oO = 1;
    public final List<fkv<Integer, Integer>> O00000oo = new ArrayList();

    interface O00000Oo<T> {
        T O000000o(BleDeviceProp bleDeviceProp);
    }

    public interface O00000o {
        boolean O000000o(String str, BleDeviceProp bleDeviceProp);
    }

    interface O00000o0 {
        boolean O000000o(BleDeviceProp bleDeviceProp);
    }

    public static BleDevicePropCache O000000o() {
        if (O0000Oo0 == null) {
            synchronized (BleDevicePropCache.class) {
                if (O0000Oo0 == null) {
                    O0000Oo0 = new BleDevicePropCache();
                }
            }
        }
        return O0000Oo0;
    }

    private BleDevicePropCache() {
    }

    public final void O00000Oo() {
        this.O00000oO = 2;
        final AnonymousClass1 r0 = new O000000o() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public final void O000000o() {
                String str;
                BleDevicePropCache bleDevicePropCache = BleDevicePropCache.this;
                if (!fas.O000000o.f16038O000000o.f16036O000000o) {
                    fas.O000000o.f16038O000000o.O000000o(glc.O0000O0o);
                }
                String O000000o2 = fec.O00000o0().O000000o();
                if (TextUtils.isEmpty(O000000o2) || "0".equals(O000000o2)) {
                    str = null;
                } else {
                    String O00000o0 = fec.O00000o0().O00000o0();
                    if (O00000o0 == null) {
                        O00000o0 = "";
                    }
                    str = String.format("%s.%s.%s", "ble_device_prop_cache", O000000o2, O00000o0);
                }
                if (TextUtils.isEmpty(str)) {
                    synchronized (bleDevicePropCache.O00000o0) {
                        bleDevicePropCache.O00000o0.clear();
                    }
                    bleDevicePropCache.O00000Oo = null;
                    bleDevicePropCache.O00000oO = 1;
                    bleDevicePropCache.f6813O000000o = "";
                } else if (!str.equalsIgnoreCase(bleDevicePropCache.f6813O000000o)) {
                    bleDevicePropCache.f6813O000000o = str;
                    fte.O00000Oo("start loadPropCache");
                    bleDevicePropCache.O00000Oo = glc.O0000O0o.getSharedPreferences(bleDevicePropCache.f6813O000000o, 0);
                    Map<String, ?> all = bleDevicePropCache.O00000Oo.getAll();
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : all.entrySet()) {
                        BleDeviceProp O00000Oo = BleDeviceProp.O00000Oo((String) next.getValue());
                        if (O00000Oo != null) {
                            hashMap.put(next.getKey(), O00000Oo);
                        }
                    }
                    synchronized (bleDevicePropCache.O00000o0) {
                        bleDevicePropCache.O00000o0.clear();
                        bleDevicePropCache.O00000o0.putAll(hashMap);
                        fte.O00000Oo("end loadPropCache");
                        bleDevicePropCache.O00000oO = 3;
                    }
                } else {
                    bleDevicePropCache.O00000oO = 3;
                }
                bleDevicePropCache.O00000o0();
            }
        };
        glc.O000000o(new Runnable() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass51 */

            public final void run() {
                r0.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }, 0);
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        synchronized (this.O00000oo) {
            if (!this.O00000oo.isEmpty()) {
                for (fkv call : this.O00000oo) {
                    try {
                        call.call(Integer.valueOf(this.O00000oO));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.O00000oo.clear();
            }
        }
    }

    public final void O000000o(O00000o o00000o) {
        synchronized (this.O00000o0) {
            for (Map.Entry next : this.O00000o0.entrySet()) {
                o00000o.O000000o((String) next.getKey(), (BleDeviceProp) next.getValue());
            }
        }
    }

    public final String O000000o(String str) {
        return (String) O000000o(str, new O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass19 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.encryptedToken;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$20, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public final void O000000o(String str, final String str2) {
        O000000o(str, (O0000O0o) new O0000O0o("encryptedToken") {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass20 */

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (str2.equals(bleDeviceProp.encryptedToken)) {
                    return false;
                }
                bleDeviceProp.encryptedToken = str2;
                return true;
            }
        }, true);
    }

    public final String O00000Oo(String str) {
        return (String) O000000o(str, new O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass21 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.encryptedLtmk;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$22, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public final void O00000Oo(String str, final String str2) {
        O000000o(str, (O0000O0o) new O0000O0o("encryptedLtmk") {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass22 */

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (str2.equals(bleDeviceProp.encryptedLtmk)) {
                    return false;
                }
                bleDeviceProp.encryptedLtmk = str2;
                return true;
            }
        }, true);
    }

    public final String O00000o0(String str) {
        return (String) O000000o(str, new O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass24 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.pincode;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$25, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public final void O00000o0(String str, final String str2) {
        O000000o(str, (O0000O0o) new O0000O0o("pincode") {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass25 */

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (str2.equals(bleDeviceProp.pincode)) {
                    return false;
                }
                bleDeviceProp.pincode = str2;
                return true;
            }
        }, true);
    }

    public final String O00000o(String str) {
        return (String) O000000o(str, new O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass30 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.encryptedSession;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$31, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public final void O00000o(String str, final String str2) {
        O000000o(str, (O0000O0o) new O0000O0o("encryptedSession") {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass31 */

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (str2.equals(bleDeviceProp.encryptedSession)) {
                    return false;
                }
                bleDeviceProp.encryptedSession = str2;
                return true;
            }
        }, false);
    }

    public final String O00000oO(String str) {
        return (String) O000000o(str, new O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass32 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.encryptedKeyId;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$33, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public final void O00000oO(String str, final String str2) {
        O000000o(str, (O0000O0o) new O0000O0o("encryptedKeyId") {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass33 */

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (str2.equals(bleDeviceProp.encryptedKeyId)) {
                    return false;
                }
                bleDeviceProp.encryptedKeyId = str2;
                return true;
            }
        }, true);
    }

    public final String O00000oo(String str) {
        return (String) O000000o(str, new O00000Oo<String>() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass35 */

            public final /* bridge */ /* synthetic */ Object O000000o(BleDeviceProp bleDeviceProp) {
                return bleDeviceProp.encryptedMeshBindInfo;
            }
        }, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$36, int]
     candidates:
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(android.content.SharedPreferences, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDeviceProp):void
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O00000Oo, java.lang.Object):T
      com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache$O0000O0o, boolean):void */
    public final void O00000oo(String str, final String str2) {
        O000000o(str, (O0000O0o) new O0000O0o("encryptedMeshBindInfo") {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass36 */

            public final boolean O000000o(BleDeviceProp bleDeviceProp) {
                if (str2.equals(bleDeviceProp.encryptedMeshBindInfo)) {
                    return false;
                }
                bleDeviceProp.encryptedMeshBindInfo = str2;
                return true;
            }
        }, true);
    }

    abstract class O0000O0o implements O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        private String f6869O000000o;

        O0000O0o(String str) {
            this.f6869O000000o = str;
        }

        public String toString() {
            return "PropSetter{name='" + this.f6869O000000o + '\'' + '}';
        }
    }

    public final <T> T O000000o(String str, O00000Oo o00000Oo, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return obj;
        }
        synchronized (this.O00000o0) {
            BleDeviceProp bleDeviceProp = this.O00000o0.get(str);
            if (bleDeviceProp == null) {
                return obj;
            }
            T O000000o2 = o00000Oo.O000000o(bleDeviceProp);
            return O000000o2;
        }
    }

    public final void O000000o(String str, O0000O0o o0000O0o, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.O00000o0) {
                BleDeviceProp bleDeviceProp = this.O00000o0.get(str);
                if (bleDeviceProp == null) {
                    bleDeviceProp = new BleDeviceProp();
                    this.O00000o0.put(str, bleDeviceProp);
                }
                if (o0000O0o.O000000o(bleDeviceProp) && z) {
                    O000000o(this.O00000Oo, str, bleDeviceProp);
                }
            }
        }
    }

    private void O000000o(final SharedPreferences sharedPreferences, final String str, final BleDeviceProp bleDeviceProp) {
        O000000o(new O000000o() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass49 */

            /* access modifiers changed from: package-private */
            public final void O000000o() {
                SharedPreferences sharedPreferences = sharedPreferences;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(str, bleDeviceProp.O000000o()).apply();
                }
            }
        });
    }

    static class SerialExecutor implements Executor {
        Runnable mActive;
        final ArrayDeque<Runnable> mTasks;

        private SerialExecutor() {
            this.mTasks = new ArrayDeque<>();
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.SerialExecutor.AnonymousClass1 */

                public final void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
            }
        }
    }

    abstract class O000000o extends AsyncTask<Void, Void, Void> {
        /* access modifiers changed from: package-private */
        public abstract void O000000o();

        private O000000o() {
        }

        /* synthetic */ O000000o(BleDevicePropCache bleDevicePropCache, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public /* synthetic */ Object doInBackground(Object[] objArr) {
            O000000o();
            return null;
        }
    }

    private void O000000o(final O000000o o000000o) {
        glc.O000000o(new Runnable() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.model.BleDevicePropCache.AnonymousClass50 */

            public final void run() {
                o000000o.executeOnExecutor(BleDevicePropCache.O00000o, new Void[0]);
            }
        }, 0);
    }
}
