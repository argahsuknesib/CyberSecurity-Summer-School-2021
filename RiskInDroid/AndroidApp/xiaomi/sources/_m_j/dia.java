package _m_j;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class dia {
    private static dia O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f14654O000000o;
    String O00000Oo = null;
    /* access modifiers changed from: package-private */
    public byte[] O00000o = null;
    byte[] O00000o0 = null;
    /* access modifiers changed from: package-private */
    public String O00000oO = null;
    public boolean O00000oo = true;
    private final dhv O0000OOo;
    private long O0000Oo;
    private Map<Integer, Long> O0000Oo0 = new HashMap();
    private long O0000OoO;
    private LinkedBlockingQueue<Runnable> O0000Ooo = new LinkedBlockingQueue<>();
    private long O0000o = 0;
    /* access modifiers changed from: private */
    public final Object O0000o0 = new Object();
    private LinkedBlockingQueue<Runnable> O0000o00 = new LinkedBlockingQueue<>();
    private long O0000o0O = 0;
    private long O0000o0o = 0;
    /* access modifiers changed from: private */
    public boolean O0000oO = false;
    private final Object O0000oO0 = new Object();
    /* access modifiers changed from: private */
    public final Object O0000oOO = new Object();
    private int O0000oOo = 0;

    static /* synthetic */ int O00000Oo(dia dia) {
        int i = dia.O0000oOo - 1;
        dia.O0000oOo = i;
        return i;
    }

    private dia(Context context) {
        this.f14654O000000o = context;
        this.O0000OOo = dhv.O000000o();
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException unused) {
            did.O000000o("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.O00000oo = false;
        }
        if (this.O00000oo) {
            this.O00000Oo = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB";
        }
    }

    public static synchronized dia O000000o(Context context) {
        dia dia;
        synchronized (dia.class) {
            if (O0000O0o == null) {
                O0000O0o = new dia(context);
            }
            dia = O0000O0o;
        }
        return dia;
    }

    public static synchronized dia O000000o() {
        dia dia;
        synchronized (dia.class) {
            dia = O0000O0o;
        }
        return dia;
    }

    public final void O000000o(int i, int i2, byte[] bArr, String str, String str2, dhz dhz, int i3, int i4, boolean z, Map<String, String> map) {
        try {
            O000000o(new dib(this.f14654O000000o, i, i2, bArr, str, str2, dhz, this.O00000oo, i3, i4, false, map), z, false, 0);
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void O000000o(int i, am amVar, String str, String str2, dhz dhz, boolean z) {
        O000000o(i, amVar.g, dhg.O000000o((Object) amVar), str, str2, dhz, 0, 0, z, null);
    }

    public final long O000000o(boolean z) {
        long j;
        long O00000Oo2 = dif.O00000Oo();
        int i = z ? 5 : 3;
        List<dhx> O000000o2 = this.O0000OOo.O000000o(i);
        if (O000000o2 == null || O000000o2.size() <= 0) {
            j = z ? this.O0000OoO : this.O0000Oo;
        } else {
            j = 0;
            try {
                dhx dhx = O000000o2.get(0);
                if (dhx.O00000oO >= O00000Oo2) {
                    j = dif.O00000oO(dhx.O0000O0o);
                    if (i == 3) {
                        this.O0000Oo = j;
                    } else {
                        this.O0000OoO = j;
                    }
                    O000000o2.remove(dhx);
                }
            } catch (Throwable th) {
                did.O000000o(th);
            }
            if (O000000o2.size() > 0) {
                this.O0000OOo.O000000o(O000000o2);
            }
        }
        did.O00000o0("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    /* access modifiers changed from: protected */
    public final synchronized void O000000o(long j, boolean z) {
        int i = z ? 5 : 3;
        dhx dhx = new dhx();
        dhx.O00000Oo = i;
        dhx.O00000oO = dif.O00000Oo();
        dhx.O00000o0 = "";
        dhx.O00000o = "";
        dhx.O0000O0o = dif.O00000o0(j);
        this.O0000OOo.O00000Oo(i);
        this.O0000OOo.O000000o(dhx);
        if (z) {
            this.O0000OoO = j;
        } else {
            this.O0000Oo = j;
        }
        did.O00000o0("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    public final synchronized void O000000o(int i, long j) {
        if (i >= 0) {
            this.O0000Oo0.put(Integer.valueOf(i), Long.valueOf(j));
            dhx dhx = new dhx();
            dhx.O00000Oo = i;
            dhx.O00000oO = j;
            dhx.O00000o0 = "";
            dhx.O00000o = "";
            dhx.O0000O0o = new byte[0];
            this.O0000OOo.O00000Oo(i);
            this.O0000OOo.O000000o(dhx);
            did.O00000o0("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), dif.O000000o(j));
            return;
        }
        did.O00000oO("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
    }

    public final synchronized long O000000o(int i) {
        long j;
        j = 0;
        if (i >= 0) {
            Long l = this.O0000Oo0.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            List<dhx> O000000o2 = this.O0000OOo.O000000o(i);
            if (O000000o2 != null && O000000o2.size() > 0) {
                if (O000000o2.size() > 1) {
                    for (dhx next : O000000o2) {
                        if (next.O00000oO > j) {
                            j = next.O00000oO;
                        }
                    }
                    this.O0000OOo.O00000Oo(i);
                } else {
                    try {
                        j = O000000o2.get(0).O00000oO;
                    } catch (Throwable th) {
                        did.O000000o(th);
                    }
                }
            }
        } else {
            did.O00000oO("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
        }
        return j;
    }

    public final boolean O00000Oo(int i) {
        if (dgm.O00000o0) {
            did.O00000o0("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - O000000o(i);
        did.O00000o0("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis >= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
            return true;
        }
        did.O000000o("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    private static boolean O00000o0() {
        did.O00000o0("[UploadManager] Drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            dhv O000000o2 = dhv.O000000o();
            if (O000000o2 != null) {
                return O000000o2.O000000o(555, "security_info", (dhu) null);
            }
            did.O00000o("[UploadManager] Failed to get Database", new Object[0]);
            return false;
        } catch (Throwable th) {
            did.O000000o(th);
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhv.O000000o(int, java.lang.String, byte[], boolean):boolean
     arg types: [int, java.lang.String, byte[], int]
     candidates:
      _m_j.dhv.O000000o(java.lang.String, java.lang.String, java.lang.String[], _m_j.dhu):int
      _m_j.dhv.O000000o(_m_j.dhv, java.lang.String, android.content.ContentValues, _m_j.dhu):long
      _m_j.dhv.O000000o(int, java.lang.String, byte[], _m_j.dhu):boolean
      _m_j.dhv.O000000o(_m_j.dhv, int, java.lang.String, _m_j.dhu):boolean
      _m_j.dhv.O000000o(int, java.lang.String, byte[], boolean):boolean */
    private boolean O00000o() {
        did.O00000o0("[UploadManager] Record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            dhv O000000o2 = dhv.O000000o();
            if (O000000o2 == null) {
                did.O00000o("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            StringBuilder sb = new StringBuilder();
            if (this.O00000o != null) {
                sb.append(Base64.encodeToString(this.O00000o, 0));
                sb.append("#");
                if (this.O0000o0o != 0) {
                    sb.append(Long.toString(this.O0000o0o));
                } else {
                    sb.append("null");
                }
                sb.append("#");
                if (this.O00000oO != null) {
                    sb.append(this.O00000oO);
                } else {
                    sb.append("null");
                }
                sb.append("#");
                if (this.O0000o != 0) {
                    sb.append(Long.toString(this.O0000o));
                } else {
                    sb.append("null");
                }
                O000000o2.O000000o(555, "security_info", sb.toString().getBytes(), true);
                return true;
            }
            did.O00000o0("[UploadManager] AES key is null, will not record", new Object[0]);
            return false;
        } catch (Throwable th) {
            did.O000000o(th);
            O00000o0();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean O00000oO() {
        boolean z;
        did.O00000o0("[UploadManager] Load security info from database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            dhv O000000o2 = dhv.O000000o();
            if (O000000o2 == null) {
                did.O00000o("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            Map<String, byte[]> O000000o3 = O000000o2.O000000o(555, (dhu) null);
            if (O000000o3 != null && O000000o3.containsKey("security_info")) {
                String str = new String(O000000o3.get("security_info"));
                String[] split = str.split("#");
                if (split.length == 4) {
                    if (!split[0].isEmpty()) {
                        if (!split[0].equals("null")) {
                            this.O00000o = Base64.decode(split[0], 0);
                        }
                    }
                    z = false;
                    if (!z && !split[1].isEmpty() && !split[1].equals("null")) {
                        try {
                            this.O0000o0o = Long.parseLong(split[1]);
                        } catch (Throwable th) {
                            did.O000000o(th);
                            z = true;
                        }
                    }
                    if (!z && !split[2].isEmpty() && !split[2].equals("null")) {
                        this.O00000oO = split[2];
                    }
                    if (!z && !split[3].isEmpty() && !split[3].equals("null")) {
                        try {
                            this.O0000o = Long.parseLong(split[3]);
                        } catch (Throwable th2) {
                            did.O000000o(th2);
                        }
                    }
                } else {
                    did.O000000o("SecurityInfo = %s, Strings.length = %d", str, Integer.valueOf(split.length));
                    z = true;
                }
                if (z) {
                    O00000o0();
                }
            }
            return true;
        } catch (Throwable th3) {
            did.O000000o(th3);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O00000Oo() {
        if (this.O00000oO == null || this.O0000o == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.O0000o0O;
        long j = this.O0000o;
        if (j >= currentTimeMillis) {
            return true;
        }
        did.O00000o0("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(j), new Date(this.O0000o).toString(), Long.valueOf(currentTimeMillis), new Date(currentTimeMillis).toString());
        return false;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(boolean z) {
        synchronized (this.O0000oO0) {
            did.O00000o0("[UploadManager] Clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.O00000o = null;
            this.O00000oO = null;
            this.O0000o = 0;
        }
        if (z) {
            O00000o0();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dia.O000000o(java.lang.Runnable, boolean):boolean
     arg types: [java.lang.Runnable, int]
     candidates:
      _m_j.dia.O000000o(_m_j.dia, int):void
      _m_j.dia.O000000o(java.lang.Runnable, long):void
      _m_j.dia.O000000o(_m_j.dia, byte[]):byte[]
      _m_j.dia.O000000o(int, long):void
      _m_j.dia.O000000o(int, com.tencent.bugly.proguard.an):void
      _m_j.dia.O000000o(long, boolean):void
      _m_j.dia.O000000o(java.lang.Runnable, boolean):boolean */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b9, code lost:
        if (r5 <= 0) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bb, code lost:
        _m_j.did.O00000o0("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(r5), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00dc, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dd, code lost:
        if (r7 >= r5) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00df, code lost:
        r8 = (java.lang.Runnable) r2.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        if (r8 == null) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e7, code lost:
        r10 = r12.O0000o0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e9, code lost:
        monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ec, code lost:
        if (r12.O0000oOo < 2) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ee, code lost:
        if (r1 == null) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f0, code lost:
        r1.O000000o(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f3, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f5, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f6, code lost:
        _m_j.did.O000000o("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010c, code lost:
        if (_m_j.dif.O000000o(new _m_j.dia.AnonymousClass1(r12), "BUGLY_ASYNC_UPLOAD") == null) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010e, code lost:
        r8 = r12.O0000o0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0110, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r12.O0000oOo++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0116, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x011b, code lost:
        _m_j.did.O00000o("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new java.lang.Object[0]);
        O000000o(r8, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0125, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x012b, code lost:
        if (r13 <= 0) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x012d, code lost:
        _m_j.did.O00000o0("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(r13), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x014e, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0150, code lost:
        r1.O000000o(new _m_j.dia.AnonymousClass2());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c A[Catch:{ Throwable -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0093 A[Catch:{ Throwable -> 0x007f }] */
    public void O00000o0(int i) {
        final int i2;
        int i3;
        int i4;
        if (i < 0) {
            did.O000000o("[UploadManager] Number of task to execute should >= 0", new Object[0]);
            return;
        }
        dic O000000o2 = dic.O000000o();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.O0000o0) {
            did.O00000o0("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.O0000Ooo.size();
            int size2 = this.O0000o00.size();
            if (size == 0 && size2 == 0) {
                did.O00000o0("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (i != 0) {
                if (i < size) {
                    size = i;
                    i2 = 0;
                } else if (i < size + size2) {
                    i2 = i - size;
                }
                if (O000000o2 == null || !O000000o2.O00000o0()) {
                    i2 = 0;
                }
                for (i3 = 0; i3 < size; i3++) {
                    Runnable peek = this.O0000Ooo.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        linkedBlockingQueue.put(peek);
                        this.O0000Ooo.poll();
                    } catch (Throwable th) {
                        did.O00000oO("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
                    }
                }
                for (i4 = 0; i4 < i2; i4++) {
                    Runnable peek2 = this.O0000o00.peek();
                    if (peek2 == null) {
                        break;
                    }
                    try {
                        linkedBlockingQueue2.put(peek2);
                        this.O0000o00.poll();
                    } catch (Throwable th2) {
                        did.O00000oO("[UploadManager] Failed to add upload task to temp urgent queue: %s", th2.getMessage());
                    }
                }
            }
            i2 = size2;
            i2 = 0;
            while (i3 < size) {
            }
            while (i4 < i2) {
            }
        }
    }

    private boolean O000000o(Runnable runnable, boolean z) {
        if (runnable == null) {
            did.O000000o("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            did.O00000o0("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.O0000o0) {
                if (z) {
                    this.O0000Ooo.put(runnable);
                } else {
                    this.O0000o00.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            did.O00000oO("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dia.O000000o(java.lang.Runnable, boolean):boolean
     arg types: [java.lang.Runnable, int]
     candidates:
      _m_j.dia.O000000o(_m_j.dia, int):void
      _m_j.dia.O000000o(java.lang.Runnable, long):void
      _m_j.dia.O000000o(_m_j.dia, byte[]):byte[]
      _m_j.dia.O000000o(int, long):void
      _m_j.dia.O000000o(int, com.tencent.bugly.proguard.an):void
      _m_j.dia.O000000o(long, boolean):void
      _m_j.dia.O000000o(java.lang.Runnable, boolean):boolean */
    /* access modifiers changed from: private */
    public void O000000o(Runnable runnable, long j) {
        if (runnable == null) {
            did.O00000o("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        did.O00000o0("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread O000000o2 = dif.O000000o(runnable, "BUGLY_SYNC_UPLOAD");
        if (O000000o2 == null) {
            did.O00000oO("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            O000000o(runnable, true);
            return;
        }
        try {
            O000000o2.join(j);
        } catch (Throwable th) {
            did.O00000oO("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            O000000o(runnable, true);
            O00000o0(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
        _m_j.did.O00000o0("[UploadManager] Initialize security context now (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        if (r10 == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009a, code lost:
        O000000o(new _m_j.dia.O000000o(r2, r7.f14654O000000o, r8, r11), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00aa, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ab, code lost:
        O000000o(r8, r9);
        r0 = new _m_j.dia.O000000o(r7, r7.f14654O000000o);
        _m_j.did.O000000o("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c6, code lost:
        if (_m_j.dif.O000000o(r0, "BUGLY_ASYNC_UPLOAD") != null) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c8, code lost:
        _m_j.did.O00000o("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new java.lang.Object[0]);
        r1 = _m_j.dic.O000000o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d3, code lost:
        if (r1 == null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d5, code lost:
        r1.O000000o(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d9, code lost:
        _m_j.did.O00000oO("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new java.lang.Object[0]);
        r1 = r7.O0000oOO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e2, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r7.O0000oO = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e5, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ea, code lost:
        return;
     */
    public final void O000000o(Runnable runnable, boolean z, boolean z2, long j) {
        did.O00000o0("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.O00000oO != null) {
            if (O00000Oo()) {
                did.O00000o0("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z2) {
                    O000000o(runnable, j);
                    return;
                }
                O000000o(runnable, z);
                O00000o0(0);
                return;
            }
            did.O000000o("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            O00000Oo(false);
        }
        synchronized (this.O0000oOO) {
            if (this.O0000oO) {
                O000000o(runnable, z);
                return;
            }
            this.O0000oO = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        if (r9 == null) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        _m_j.did.O00000o0("[UploadManager] Record security context (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r8 = r9.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        if (r8 == null) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r8.containsKey("S1") == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r8.containsKey("S2") == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        r7.O0000o0O = r9.e - java.lang.System.currentTimeMillis();
        _m_j.did.O00000o0("[UploadManager] Time lag of server is: %d", java.lang.Long.valueOf(r7.O0000o0O));
        r7.O00000oO = r8.get("S1");
        _m_j.did.O00000o0("[UploadManager] Session ID from server is: %s", r7.O00000oO);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0098, code lost:
        if (r7.O00000oO.length() <= 0) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r7.O0000o = java.lang.Long.parseLong(r8.get("S2"));
        _m_j.did.O00000o0("[UploadManager] Session expired time from server is: %d(%s)", java.lang.Long.valueOf(r7.O0000o), new java.util.Date(r7.O0000o).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cd, code lost:
        if (r7.O0000o >= 1000) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
        _m_j.did.O00000o("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new java.lang.Object[0]);
        r7.O0000o = 259200000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        _m_j.did.O00000o("[UploadManager] Session expired time is invalid, will set to default value", new java.lang.Object[0]);
        r7.O0000o = 259200000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f5, code lost:
        _m_j.did.O00000o0("[UploadManager] Session ID from server is invalid, try next time", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fd, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fe, code lost:
        _m_j.did.O000000o(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0107, code lost:
        _m_j.did.O00000o0("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        O00000Oo(false);
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0128 A[SYNTHETIC] */
    public final void O000000o(int i, an anVar) {
        boolean z;
        if (this.O00000oo) {
            z = true;
            if (i == 2) {
                did.O00000o0("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                O00000Oo(true);
            } else {
                synchronized (this.O0000oOO) {
                    if (!this.O0000oO) {
                        return;
                    }
                }
            }
            synchronized (this.O0000oOO) {
                if (this.O0000oO) {
                    this.O0000oO = false;
                    dif.O00000Oo(this.f14654O000000o, "security_info");
                }
            }
            return;
        }
        return;
        if (z) {
            O00000Oo(false);
        }
        synchronized (this.O0000oOO) {
        }
        if (O00000o()) {
            z = false;
        } else {
            did.O00000o0("[UploadManager] Failed to record database", new Object[0]);
        }
        O00000o0(0);
        if (z) {
        }
        synchronized (this.O0000oOO) {
        }
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Context f14657O000000o;
        private final Runnable O00000Oo;
        private final long O00000o0;

        public O000000o(Context context) {
            this.f14657O000000o = context;
            this.O00000Oo = null;
            this.O00000o0 = 0;
        }

        public O000000o(Context context, Runnable runnable, long j) {
            this.f14657O000000o = context;
            this.O00000Oo = runnable;
            this.O00000o0 = j;
        }

        public final void run() {
            if (!dif.O000000o(this.f14657O000000o, "security_info", (long) DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS)) {
                did.O00000o0("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", 5000, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                dif.O00000Oo(5000);
                if (dif.O000000o(this, "BUGLY_ASYNC_UPLOAD") == null) {
                    did.O00000o("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                    dic O000000o2 = dic.O000000o();
                    if (O000000o2 != null) {
                        O000000o2.O000000o(this);
                    } else {
                        did.O00000oO("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                    }
                }
            } else {
                if (!dia.this.O00000oO()) {
                    did.O00000o("[UploadManager] Failed to load security info from database", new Object[0]);
                    dia.this.O00000Oo(false);
                }
                if (dia.this.O00000oO != null) {
                    if (dia.this.O00000Oo()) {
                        did.O00000o0("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        Runnable runnable = this.O00000Oo;
                        if (runnable != null) {
                            dia.this.O000000o(runnable, this.O00000o0);
                        }
                        dia.this.O00000o0(0);
                        dif.O00000Oo(this.f14657O000000o, "security_info");
                        synchronized (dia.this.O0000oOO) {
                            boolean unused = dia.this.O0000oO = false;
                        }
                        return;
                    }
                    did.O000000o("[UploadManager] Session ID is expired, drop it.", new Object[0]);
                    dia.this.O00000Oo(true);
                }
                byte[] O00000o02 = dif.O00000o0();
                if (O00000o02 == null || (O00000o02.length << 3) != 128) {
                    did.O00000o("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    dia.this.O00000Oo(false);
                    dif.O00000Oo(this.f14657O000000o, "security_info");
                    synchronized (dia.this.O0000oOO) {
                        boolean unused2 = dia.this.O0000oO = false;
                    }
                    return;
                }
                byte[] unused3 = dia.this.O00000o = O00000o02;
                did.O00000o0("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                Runnable runnable2 = this.O00000Oo;
                if (runnable2 != null) {
                    dia.this.O000000o(runnable2, this.O00000o0);
                } else {
                    dia.this.O00000o0(1);
                }
            }
        }
    }
}
