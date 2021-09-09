package _m_j;

import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.xmlpull.v1.XmlPullParserException;

public final class gba implements SharedPreferences {
    private static final Object O0000o0 = new Object();
    private static HashMap<File, gba> O0000o0O = new HashMap<>();

    /* renamed from: O000000o  reason: collision with root package name */
    final File f17478O000000o;
    final File O00000Oo;
    public final Object O00000o = new Object();
    public final Object O00000o0 = new Object();
    public Map<String, Object> O00000oO;
    Throwable O00000oo;
    public int O0000O0o = 0;
    boolean O0000OOo = false;
    public long O0000Oo;
    public final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> O0000Oo0 = new WeakHashMap<>();
    long O0000OoO;
    final gay O0000Ooo = new gay();
    int O0000o00 = 0;

    private gba(File file) {
        this.f17478O000000o = file;
        this.O00000Oo = new File(file.getPath() + ".bak");
        this.O0000OOo = false;
        this.O00000oO = null;
        this.O00000oo = null;
        synchronized (this.O00000o0) {
            this.O0000OOo = false;
        }
        new Thread("SharedPreferencesImpl-load") {
            /* class _m_j.gba.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
                if (r0.f17478O000000o.exists() == false) goto L_0x004b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
                if (r0.f17478O000000o.canRead() != false) goto L_0x004b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
                _m_j.gsy.O000000o(5, "SharedPreferencesImpl", "Attempt to read preferences file " + r0.f17478O000000o + " without permission");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
                r1 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
                if (r0.f17478O000000o.canRead() == false) goto L_0x0095;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
                r2 = new java.io.BufferedInputStream(new java.io.FileInputStream(r0.f17478O000000o), 16384);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
                r3 = _m_j.gbb.O000000o(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
                _m_j.gsc.O000000o((java.io.Closeable) r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x006a, code lost:
                r1 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
                r3 = e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
                r3 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
                r2 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x0071, code lost:
                r3 = e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x0072, code lost:
                r2 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
                android.util.Log.w("SharedPreferencesImpl", "Cannot read " + r0.f17478O000000o.getAbsolutePath(), r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
                _m_j.gsc.O000000o((java.io.Closeable) r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
                r3 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
                _m_j.gsc.O000000o((java.io.Closeable) r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
                throw r3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x0095, code lost:
                r3 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x0097, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
                r3 = null;
                r1 = r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x009c, code lost:
                monitor-enter(r0.O00000o0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
                r0.O0000OOo = true;
                r0.O00000oo = r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a2, code lost:
                if (r1 == null) goto L_0x00a4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a4, code lost:
                if (r3 != null) goto L_0x00a6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
                r0.O00000oO = r3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a9, code lost:
                r0.O00000oO = new java.util.HashMap();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b1, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b3, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
                r0.O00000oo = r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
                r0 = r0.O00000o0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b8, code lost:
                r0.notifyAll();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:62:0x00bc, code lost:
                r0.O00000o0.notifyAll();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c1, code lost:
                throw r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c2, code lost:
                r0 = r0.O00000o0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c6, code lost:
                return;
             */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x009d  */
            public final void run() {
                gba gba = gba.this;
                synchronized (gba.O00000o0) {
                    if (!gba.O0000OOo) {
                        if (gba.O00000Oo.exists()) {
                            gba.f17478O000000o.delete();
                            gba.O00000Oo.renameTo(gba.f17478O000000o);
                        }
                    }
                }
            }
        }.start();
    }

    public static SharedPreferences O000000o(File file) {
        gba gba = O0000o0O.get(file);
        if (gba != null) {
            return gba;
        }
        gba gba2 = new gba(file);
        O0000o0O.put(file, gba2);
        return gba2;
    }

    public static void O00000Oo(File file) {
        O0000o0O.remove(file);
    }

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.O00000o0) {
            this.O0000Oo0.put(onSharedPreferenceChangeListener, O0000o0);
        }
    }

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.O00000o0) {
            this.O0000Oo0.remove(onSharedPreferenceChangeListener);
        }
    }

    private void O000000o() {
        while (!this.O0000OOo) {
            try {
                this.O00000o0.wait();
            } catch (InterruptedException unused) {
            }
        }
        Throwable th = this.O00000oo;
        if (th != null) {
            throw new IllegalStateException(th);
        }
    }

    public final Map<String, ?> getAll() {
        HashMap hashMap;
        synchronized (this.O00000o0) {
            O000000o();
            hashMap = new HashMap(this.O00000oO);
        }
        return hashMap;
    }

    public final String getString(String str, String str2) {
        String str3;
        synchronized (this.O00000o0) {
            O000000o();
            str3 = (String) this.O00000oO.get(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this.O00000o0) {
            O000000o();
            set2 = (Set) this.O00000oO.get(str);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        synchronized (this.O00000o0) {
            O000000o();
            Integer num = (Integer) this.O00000oO.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        synchronized (this.O00000o0) {
            O000000o();
            Long l = (Long) this.O00000oO.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        synchronized (this.O00000o0) {
            O000000o();
            Float f2 = (Float) this.O00000oO.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        synchronized (this.O00000o0) {
            O000000o();
            Boolean bool = (Boolean) this.O00000oO.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        synchronized (this.O00000o0) {
            O000000o();
            containsKey = this.O00000oO.containsKey(str);
        }
        return containsKey;
    }

    public final SharedPreferences.Editor edit() {
        synchronized (this.O00000o0) {
            O000000o();
        }
        return new O000000o();
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final long f17485O000000o;
        final List<String> O00000Oo;
        final Map<String, Object> O00000o;
        final Set<SharedPreferences.OnSharedPreferenceChangeListener> O00000o0;
        final CountDownLatch O00000oO;
        volatile boolean O00000oo;
        boolean O0000O0o;

        /* synthetic */ O00000Oo(long j, List list, Set set, Map map, byte b) {
            this(j, list, set, map);
        }

        private O00000Oo(long j, List<String> list, Set<SharedPreferences.OnSharedPreferenceChangeListener> set, Map<String, Object> map) {
            this.O00000oO = new CountDownLatch(1);
            this.O00000oo = false;
            this.O0000O0o = false;
            this.f17485O000000o = j;
            this.O00000Oo = list;
            this.O00000o0 = set;
            this.O00000o = map;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(boolean z, boolean z2) {
            this.O0000O0o = z;
            this.O00000oo = z2;
            this.O00000oO.countDown();
        }
    }

    public final class O000000o implements SharedPreferences.Editor {
        private final Object O00000Oo = new Object();
        private boolean O00000o = false;
        private final Map<String, Object> O00000o0 = new HashMap();

        public O000000o() {
        }

        public final SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this.O00000Oo) {
                this.O00000o0.put(str, str2);
            }
            return this;
        }

        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            synchronized (this.O00000Oo) {
                this.O00000o0.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        public final SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this.O00000Oo) {
                this.O00000o0.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public final SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this.O00000Oo) {
                this.O00000o0.put(str, Long.valueOf(j));
            }
            return this;
        }

        public final SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this.O00000Oo) {
                this.O00000o0.put(str, Float.valueOf(f));
            }
            return this;
        }

        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this.O00000Oo) {
                this.O00000o0.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final SharedPreferences.Editor remove(String str) {
            synchronized (this.O00000Oo) {
                this.O00000o0.put(str, this);
            }
            return this;
        }

        public final SharedPreferences.Editor clear() {
            synchronized (this.O00000Oo) {
                this.O00000o = true;
            }
            return this;
        }

        public final void apply() {
            final long currentTimeMillis = System.currentTimeMillis();
            final O00000Oo O000000o2 = O000000o();
            final AnonymousClass1 r3 = new Runnable() {
                /* class _m_j.gba.O000000o.AnonymousClass1 */

                public final void run() {
                    try {
                        O000000o2.O00000oO.await();
                    } catch (InterruptedException unused) {
                    }
                }
            };
            gaz.O000000o(r3);
            gba.this.O000000o(O000000o2, new Runnable() {
                /* class _m_j.gba.O000000o.AnonymousClass2 */

                public final void run() {
                    r3.run();
                    gaz.O00000Oo(r3);
                }
            });
            O000000o(O000000o2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a8  */
        private O00000Oo O000000o() {
            Map<String, Object> map;
            HashSet hashSet;
            ArrayList arrayList;
            long j;
            Object obj;
            boolean z;
            synchronized (gba.this.O00000o0) {
                if (gba.this.O0000O0o > 0) {
                    gba.this.O00000oO = new HashMap(gba.this.O00000oO);
                }
                map = gba.this.O00000oO;
                gba.this.O0000O0o++;
                boolean z2 = false;
                boolean z3 = gba.this.O0000Oo0.size() > 0;
                if (z3) {
                    ArrayList arrayList2 = new ArrayList();
                    hashSet = new HashSet(gba.this.O0000Oo0.keySet());
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                    hashSet = null;
                }
                synchronized (this.O00000Oo) {
                    if (this.O00000o) {
                        if (!map.isEmpty()) {
                            map.clear();
                            z = true;
                        } else {
                            z = false;
                        }
                        this.O00000o = false;
                        z2 = z;
                    }
                    for (Map.Entry next : this.O00000o0.entrySet()) {
                        String str = (String) next.getKey();
                        Object value = next.getValue();
                        if (value != this) {
                            if (value != null) {
                                if (!map.containsKey(str) || (obj = map.get(str)) == null || !obj.equals(value)) {
                                    map.put(str, value);
                                    if (z3) {
                                        arrayList.add(str);
                                    }
                                    z2 = true;
                                }
                            }
                        }
                        if (map.containsKey(str)) {
                            map.remove(str);
                            if (z3) {
                            }
                            z2 = true;
                        }
                    }
                    this.O00000o0.clear();
                    if (z2) {
                        gba.this.O0000Oo++;
                    }
                    j = gba.this.O0000Oo;
                }
            }
            return new O00000Oo(j, arrayList, hashSet, map, (byte) 0);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
            return false;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        public final boolean commit() {
            O00000Oo O000000o2 = O000000o();
            gba.this.O000000o(O000000o2, null);
            O000000o2.O00000oO.await();
            O000000o(O000000o2);
            return O000000o2.O00000oo;
        }

        public final void O000000o(final O00000Oo o00000Oo) {
            if (o00000Oo.O00000o0 != null && o00000Oo.O00000Oo != null && o00000Oo.O00000Oo.size() != 0) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    for (int size = o00000Oo.O00000Oo.size() - 1; size >= 0; size--) {
                        String str = o00000Oo.O00000Oo.get(size);
                        for (SharedPreferences.OnSharedPreferenceChangeListener next : o00000Oo.O00000o0) {
                            if (next != null) {
                                next.onSharedPreferenceChanged(gba.this, str);
                            }
                        }
                    }
                    return;
                }
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class _m_j.gba.O000000o.AnonymousClass3 */

                    public final void run() {
                        O000000o.this.O000000o(o00000Oo);
                    }
                });
            }
        }
    }

    public final void O000000o(final O00000Oo o00000Oo, final Runnable runnable) {
        boolean z = false;
        final boolean z2 = runnable == null;
        AnonymousClass2 r3 = new Runnable() {
            /* class _m_j.gba.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:59:0x0134 A[SYNTHETIC] */
            public final void run() {
                boolean z;
                synchronized (gba.this.O00000o) {
                    gba gba = gba.this;
                    O00000Oo o00000Oo = o00000Oo;
                    boolean z2 = z2;
                    if (gba.f17478O000000o.exists()) {
                        if (gba.O0000OoO >= o00000Oo.f17485O000000o) {
                            z = false;
                        } else if (z2) {
                            z = true;
                        } else {
                            synchronized (gba.O00000o0) {
                                z = gba.O0000Oo == o00000Oo.f17485O000000o;
                            }
                        }
                        if (!z) {
                            o00000Oo.O000000o(false, true);
                        } else if (gba.O00000Oo.exists()) {
                            gba.f17478O000000o.delete();
                        } else if (!gba.f17478O000000o.renameTo(gba.O00000Oo)) {
                            gsy.O000000o(6, "SharedPreferencesImpl", "Couldn't rename file " + gba.f17478O000000o + " to backup file " + gba.O00000Oo);
                            o00000Oo.O000000o(false, false);
                        }
                    }
                    try {
                        FileOutputStream O00000o02 = gba.O00000o0(gba.f17478O000000o);
                        if (O00000o02 == null) {
                            o00000Oo.O000000o(false, false);
                        } else {
                            gbb.O000000o(o00000Oo.O00000o, O00000o02);
                            long currentTimeMillis = System.currentTimeMillis();
                            gba.O000000o(O00000o02);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            O00000o02.close();
                            gba.O00000Oo.delete();
                            gba.O0000OoO = o00000Oo.f17485O000000o;
                            o00000Oo.O000000o(true, true);
                            long j = currentTimeMillis2 - currentTimeMillis;
                            gay gay = gba.O0000Ooo;
                            int i = (int) j;
                            if (i <= 0) {
                                int[] iArr = gay.f17474O000000o;
                                iArr[0] = iArr[0] + 1;
                            } else {
                                int[] iArr2 = gay.f17474O000000o;
                                int min = Math.min(gay.f17474O000000o.length - 1, 32 - Integer.numberOfLeadingZeros(i));
                                iArr2[min] = iArr2[min] + 1;
                            }
                            gba.O0000o00++;
                            if (gba.O0000o00 % 1024 == 0 || j > 256) {
                                gba.O0000Ooo.O000000o("SharedPreferencesImpl", "Time required to fsync " + gba.f17478O000000o + ": ");
                            }
                        }
                    } catch (XmlPullParserException e) {
                        Log.w("SharedPreferencesImpl", "writeToFile: Got exception:", e);
                        if (gba.f17478O000000o.exists() && !gba.f17478O000000o.delete()) {
                            gsy.O000000o(6, "SharedPreferencesImpl", "Couldn't clean up partially-written file " + gba.f17478O000000o);
                        }
                        o00000Oo.O000000o(false, false);
                        synchronized (gba.this.O00000o0) {
                        }
                    } catch (IOException e2) {
                        Log.w("SharedPreferencesImpl", "writeToFile: Got exception:", e2);
                        gsy.O000000o(6, "SharedPreferencesImpl", "Couldn't clean up partially-written file " + gba.f17478O000000o);
                        o00000Oo.O000000o(false, false);
                        synchronized (gba.this.O00000o0) {
                        }
                    }
                }
                synchronized (gba.this.O00000o0) {
                    gba.this.O0000O0o--;
                }
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        };
        if (z2) {
            synchronized (this.O00000o0) {
                if (this.O0000O0o == 1) {
                    z = true;
                }
            }
            if (z) {
                r3.run();
                return;
            }
        }
        gaz.O000000o(r3, !z2);
    }

    static FileOutputStream O00000o0(File file) {
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException unused) {
            if (!file.getParentFile().mkdir()) {
                gsy.O000000o(6, "SharedPreferencesImpl", "Couldn't create directory for SharedPreferences file ".concat(String.valueOf(file)));
                return null;
            }
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                Log.e("SharedPreferencesImpl", "Couldn't create SharedPreferences file ".concat(String.valueOf(file)), e);
                return null;
            }
        }
    }

    public static boolean O000000o(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
