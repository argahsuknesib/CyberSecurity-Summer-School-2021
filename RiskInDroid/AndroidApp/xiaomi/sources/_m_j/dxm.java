package _m_j;

import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mijialog.LoganModel;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;

final class dxm extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f15032O000000o = new Object();
    private volatile boolean O00000Oo = true;
    private boolean O00000o;
    private long O00000o0;
    private File O00000oO;
    private boolean O00000oo;
    private long O0000O0o;
    private dxk O0000OOo;
    private String O0000Oo;
    private ConcurrentLinkedQueue<LoganModel> O0000Oo0;
    private String O0000OoO;
    private long O0000Ooo;
    private long O0000o0;
    private long O0000o00;
    private String O0000o0O;

    dxm(ConcurrentLinkedQueue<LoganModel> concurrentLinkedQueue, String str, String str2, long j, long j2, long j3, String str3) {
        this.O0000Oo0 = concurrentLinkedQueue;
        this.O0000Oo = str;
        this.O0000OoO = str2;
        this.O0000Ooo = j;
        this.O0000o00 = j2;
        this.O0000o0 = j3;
        this.O0000o0O = str3;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (!this.O00000o) {
            synchronized (this.f15032O000000o) {
                this.f15032O000000o.notify();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r3.f6029O000000o == com.xiaomi.mijialog.LoganModel.Action.FLUSH) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004a A[Catch:{ InterruptedException -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A[Catch:{ InterruptedException -> 0x011c }] */
    public final void run() {
        boolean z;
        super.run();
        while (this.O00000Oo) {
            synchronized (this.f15032O000000o) {
                boolean z2 = true;
                this.O00000o = true;
                try {
                    LoganModel poll = this.O0000Oo0.poll();
                    if (poll == null) {
                        this.O00000o = false;
                        this.f15032O000000o.wait();
                        this.O00000o = true;
                    } else if (poll != null) {
                        if (poll.f6029O000000o != null) {
                            if (poll.f6029O000000o != LoganModel.Action.WRITE || poll.O00000Oo == null || !(!TextUtils.isEmpty(poll.O00000Oo.f15035O000000o))) {
                            }
                            z = true;
                            if (!z) {
                                if (this.O0000OOo == null) {
                                    this.O0000OOo = dxk.O000000o();
                                    this.O0000OOo.f15031O000000o = new dxn() {
                                        /* class _m_j.dxm.AnonymousClass1 */

                                        public final void O000000o(String str, int i) {
                                            dxh.O000000o(str, i);
                                        }
                                    };
                                    this.O0000OOo.O000000o(this.O0000Oo, this.O0000OoO, (int) this.O0000o00, this.O0000o0O);
                                    this.O0000OOo.O000000o(dxh.f15027O000000o);
                                }
                                if (poll.f6029O000000o == LoganModel.Action.WRITE) {
                                    dxp dxp = poll.O00000Oo;
                                    if (dxh.f15027O000000o) {
                                        gsy.O000000o(3, "MiJiaLogThread", "Logan write start");
                                    }
                                    if (this.O00000oO == null) {
                                        this.O00000oO = new File(this.O0000OoO);
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (this.O00000o0 >= currentTimeMillis || this.O00000o0 + 86400000 <= currentTimeMillis) {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        String O000000o2 = dxo.O000000o();
                                        long O000000o3 = dxo.O000000o(O000000o2);
                                        O000000o(O000000o3 - this.O0000Ooo);
                                        this.O00000o0 = O000000o3;
                                        this.O0000OOo.O000000o("mijia_log_v3_".concat(String.valueOf(O000000o2)));
                                    }
                                    if (System.currentTimeMillis() - this.O0000O0o > 60000) {
                                        this.O00000oo = O00000Oo();
                                    }
                                    this.O0000O0o = System.currentTimeMillis();
                                    if (this.O00000oo) {
                                        this.O0000OOo.O000000o(dxp.O00000oo, dxp.O0000O0o, dxp.O0000OOo, dxp.f15035O000000o, dxp.O00000oO, dxp.O00000o, dxp.O00000o0, dxp.O00000Oo);
                                    }
                                } else if (poll.f6029O000000o == LoganModel.Action.FLUSH) {
                                    if (dxh.f15027O000000o) {
                                        gsy.O000000o(3, "MiJiaLogThread", "Logan flush start");
                                    }
                                    if (this.O0000OOo != null) {
                                        this.O0000OOo.O00000o0();
                                    }
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.O00000o = false;
                }
            }
        }
    }

    private void O000000o(long j) {
        String[] list;
        String str;
        File file = new File(this.O0000OoO);
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str2 : list) {
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.startsWith("mijia_log_v2_")) {
                            str = str2.substring(13);
                        } else {
                            str = str2.startsWith("mijia_log_v3_") ? str2.substring(13) : str2;
                        }
                        if (dxo.O000000o(str) <= j) {
                            new File(this.O0000OoO, str2).delete();
                        }
                    }
                } catch (Exception e) {
                    Log.e("MiJiaLogThread", "deleteExpiredFile", e);
                }
            }
        }
    }

    private boolean O00000Oo() {
        boolean z = false;
        try {
            StatFs statFs = new StatFs(this.O0000OoO);
            long availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            if (availableBlocksLong > this.O0000o0) {
                z = true;
            }
            gsy.O000000o(6, "LoganThread", "isCanWriteSDCard:" + availableBlocksLong + "  " + this.O0000o0);
        } catch (IllegalArgumentException e) {
            Log.e("LoganThread", "fatal", e);
        }
        return z;
    }
}
