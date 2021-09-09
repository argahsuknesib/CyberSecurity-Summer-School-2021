package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.proguard.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dht {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final long f14646O000000o = System.currentTimeMillis();
    private static dht O00000Oo;
    /* access modifiers changed from: private */
    public String O00000o = dgs.O000000o().O00000oo;
    private Context O00000o0;
    /* access modifiers changed from: private */
    public Map<Integer, Map<String, m>> O00000oO = new HashMap();
    /* access modifiers changed from: private */
    public SharedPreferences O00000oo;

    private dht(Context context) {
        this.O00000o0 = context;
        this.O00000oo = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized dht O000000o(Context context) {
        dht dht;
        synchronized (dht.class) {
            if (O00000Oo == null) {
                O00000Oo = new dht(context);
            }
            dht = O00000Oo;
        }
        return dht;
    }

    public static synchronized dht O000000o() {
        dht dht;
        synchronized (dht.class) {
            dht = O00000Oo;
        }
        return dht;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        return true;
     */
    public synchronized boolean O00000o0(int i) {
        try {
            List<m> O00000o2 = O00000o(i);
            if (O00000o2 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (m mVar : O00000o2) {
                if (mVar.b != null && mVar.b.equalsIgnoreCase(this.O00000o) && mVar.d > 0) {
                    arrayList.add(mVar);
                }
                if (mVar.c + 86400000 < currentTimeMillis) {
                    arrayList2.add(mVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() < 2) {
                O00000o2.removeAll(arrayList2);
                O000000o(i, O00000o2);
                return false;
            } else if (arrayList.size() > 0 && ((m) arrayList.get(arrayList.size() - 1)).c + 86400000 < currentTimeMillis) {
                O00000o2.clear();
                O000000o(i, O00000o2);
                return false;
            }
        } catch (Exception unused) {
            did.O00000oO("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final synchronized void O000000o(final int i) {
        dic.O000000o().O000000o(new Runnable() {
            /* class _m_j.dht.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            private /* synthetic */ int f14647O000000o = 1004;

            public final void run() {
                m mVar;
                try {
                    if (!TextUtils.isEmpty(dht.this.O00000o)) {
                        List<m> O000000o2 = dht.this.O00000o(this.f14647O000000o);
                        if (O000000o2 == null) {
                            O000000o2 = new ArrayList<>();
                        }
                        if (dht.this.O00000oO.get(Integer.valueOf(this.f14647O000000o)) == null) {
                            dht.this.O00000oO.put(Integer.valueOf(this.f14647O000000o), new HashMap());
                        }
                        if (((Map) dht.this.O00000oO.get(Integer.valueOf(this.f14647O000000o))).get(dht.this.O00000o) == null) {
                            mVar = new m();
                            mVar.f5840a = (long) this.f14647O000000o;
                            mVar.g = dht.f14646O000000o;
                            mVar.b = dht.this.O00000o;
                            mVar.f = dgs.O000000o().O0000o0;
                            dgs.O000000o().getClass();
                            mVar.e = "2.6.6";
                            mVar.c = System.currentTimeMillis();
                            mVar.d = i;
                            ((Map) dht.this.O00000oO.get(Integer.valueOf(this.f14647O000000o))).put(dht.this.O00000o, mVar);
                        } else {
                            mVar = (m) ((Map) dht.this.O00000oO.get(Integer.valueOf(this.f14647O000000o))).get(dht.this.O00000o);
                            mVar.d = i;
                        }
                        ArrayList arrayList = new ArrayList();
                        boolean z = false;
                        for (m mVar2 : O000000o2) {
                            if (mVar2.g == mVar.g && mVar2.b != null && mVar2.b.equalsIgnoreCase(mVar.b)) {
                                z = true;
                                mVar2.d = mVar.d;
                            }
                            if ((mVar2.e != null && !mVar2.e.equalsIgnoreCase(mVar.e)) || ((mVar2.f != null && !mVar2.f.equalsIgnoreCase(mVar.f)) || mVar2.d <= 0)) {
                                arrayList.add(mVar2);
                            }
                        }
                        O000000o2.removeAll(arrayList);
                        if (!z) {
                            O000000o2.add(mVar);
                        }
                        dht.this.O000000o(this.f14647O000000o, O000000o2);
                    }
                } catch (Exception unused) {
                    did.O00000oO("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (r6 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        if (r6 != null) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0050 A[SYNTHETIC, Splitter:B:35:0x0050] */
    public synchronized <T extends List<?>> T O00000o(int i) {
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.O00000o0.getDir("crashrecord", 0), String.valueOf(i));
            if (!file.exists()) {
                return null;
            }
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                try {
                    T t = (List) objectInputStream.readObject();
                    objectInputStream.close();
                    return t;
                } catch (IOException unused) {
                    did.O000000o("open record file error", new Object[0]);
                } catch (ClassNotFoundException unused2) {
                    try {
                        did.O000000o("get object error", new Object[0]);
                    } catch (Throwable th) {
                        th = th;
                        if (objectInputStream != null) {
                        }
                        throw th;
                    }
                }
            } catch (IOException unused3) {
                objectInputStream = null;
                did.O000000o("open record file error", new Object[0]);
            } catch (ClassNotFoundException unused4) {
                objectInputStream = null;
                did.O000000o("get object error", new Object[0]);
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused5) {
            did.O00000oO("readCrashRecord error", new Object[0]);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041 A[SYNTHETIC, Splitter:B:25:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004a A[SYNTHETIC, Splitter:B:32:0x004a] */
    public synchronized <T extends List<?>> void O000000o(int i, T t) {
        if (t != null) {
            try {
                File file = new File(this.O00000o0.getDir("crashrecord", 0), String.valueOf(i));
                ObjectOutputStream objectOutputStream = null;
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
                    try {
                        objectOutputStream2.writeObject(t);
                        objectOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        try {
                            e.printStackTrace();
                            did.O000000o("open record file error", new Object[0]);
                            if (objectOutputStream == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    did.O000000o("open record file error", new Object[0]);
                    if (objectOutputStream == null) {
                        objectOutputStream.close();
                    }
                }
            } catch (Exception unused) {
                did.O00000oO("writeCrashRecord error", new Object[0]);
            }
        }
    }

    public final synchronized boolean O00000Oo(final int i) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.O00000oo;
            z = sharedPreferences.getBoolean(i + "_" + this.O00000o, true);
            dic.O000000o().O000000o(new Runnable() {
                /* class _m_j.dht.AnonymousClass2 */

                public final void run() {
                    boolean O00000Oo2 = dht.this.O00000o0(i);
                    SharedPreferences.Editor edit = dht.this.O00000oo.edit();
                    edit.putBoolean(i + "_" + dht.this.O00000o, !O00000Oo2).commit();
                }
            });
        } catch (Exception unused) {
            did.O00000oO("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
