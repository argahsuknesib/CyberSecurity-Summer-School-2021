package _m_j;

import _m_j.blp;
import _m_j.bmd;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.ishumei.smantifraud.SmAntiFraud;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class bmc {

    /* renamed from: O000000o  reason: collision with root package name */
    AtomicInteger f13088O000000o;
    bmd O00000Oo;
    private Runnable O00000o0;

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final bmc f13091O000000o = new bmc((byte) 0);
    }

    private bmc() {
        this.O00000o0 = new Runnable() {
            /* class _m_j.bmc.AnonymousClass1 */

            public final void run() {
                try {
                    blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
                    if (O000000o2 != null) {
                        if (O000000o2.O0000o0O) {
                            int i = bmc.this.f13088O000000o.get();
                            if (O000000o2.O0000oo < 0 || i < O000000o2.O0000oo) {
                                bmz.O000000o("UploadChecker", "start check...", new Object[0]);
                                if (bmc.this.O00000Oo != null) {
                                    List<bmd.O000000o> O000000o3 = bmc.this.O00000Oo.O000000o();
                                    bmz.O000000o("UploadChecker", "load from db, size: %d", Integer.valueOf(O000000o3.size()));
                                    if (O000000o3.size() == 0) {
                                        bmc.O000000o(bmc.this, 3);
                                        return;
                                    }
                                    int i2 = O000000o2.O0000oOo;
                                    if (i2 > 0 && i <= i2) {
                                        bmo.O000000o();
                                        if (!bmo.O0000Oo()) {
                                            bmc.O000000o(bmc.this, 4);
                                            return;
                                        }
                                    }
                                    boolean z = true;
                                    for (bmd.O000000o O000000o4 : O000000o3) {
                                        if (!bmc.this.O000000o(O000000o4)) {
                                            z = false;
                                        }
                                    }
                                    bmz.O000000o("UploadChecker", "process result: %b", Boolean.valueOf(z));
                                    if (z) {
                                        bmc.O000000o(bmc.this, 1);
                                        return;
                                    } else {
                                        bmc.O000000o(bmc.this, 2);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                bmz.O000000o("UploadChecker", "reach max retry count...", new Object[0]);
                                return;
                            }
                        }
                    }
                    bmz.O000000o("UploadChecker", "disabled, return.", new Object[0]);
                } catch (Throwable th) {
                    bmz.O000000o(th);
                }
            }
        };
        this.f13088O000000o = new AtomicInteger(0);
        if (blw.f13081O000000o != null) {
            this.O00000Oo = new bmd();
        }
    }

    /* synthetic */ bmc(byte b) {
        this();
    }

    private static int O000000o(String str) {
        try {
            return new JSONObject(str).getInt("code");
        } catch (Exception unused) {
            return -1;
        }
    }

    private void O000000o(long j) {
        bmf.O00000Oo().O000000o(this.O00000o0, 4, j, true);
    }

    private long O00000Oo() {
        if (this.f13088O000000o.get() > 9) {
            return DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        }
        if (this.f13088O000000o.get() > 6) {
            return 15000;
        }
        return this.f13088O000000o.get() > 3 ? 5000 : 2000;
    }

    public final void O000000o() {
        this.f13088O000000o.set(0);
        O000000o(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bln.O000000o(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      _m_j.bln.O000000o(_m_j.blk, int):java.lang.String
      _m_j.bln.O000000o(_m_j.bln, java.lang.String):java.lang.String
      _m_j.bln.O000000o(java.lang.String, boolean):java.lang.String */
    /* access modifiers changed from: package-private */
    public final boolean O000000o(bmd.O000000o o000000o) {
        try {
            bmz.O000000o("UploadChecker", "process id = %d", Integer.valueOf(o000000o.f13093O000000o));
            String str = o000000o.O00000o0;
            String O000000o2 = new bmv().O000000o(bmu.O000000o(str, SmAntiFraud.f4498O000000o.O0000o0o, SmAntiFraud.f4498O000000o.O0000o)).O000000o(o000000o.O00000Oo.getBytes("utf-8"), null, str);
            String O000000o3 = bln.O000000o().O000000o(O000000o2, true);
            if (TextUtils.isEmpty(O000000o3)) {
                if (O000000o(O000000o2) != 1903) {
                    this.O00000Oo.O000000o(o000000o.f13093O000000o);
                    return true;
                }
                return false;
            }
            bmz.O000000o("UploadChecker", "process id = %s, deviceId: %s", Integer.valueOf(o000000o.f13093O000000o), O000000o3);
            blo.O000000o().O000000o(O000000o3);
            this.O00000Oo.O000000o(o000000o.f13093O000000o);
            SmAntiFraud.IServerSmidCallback serverIdCallback = SmAntiFraud.getServerIdCallback();
            if (serverIdCallback == null) {
                return true;
            }
            serverIdCallback.onSuccess(O000000o3);
            return true;
        } catch (Exception unused) {
            bmz.O000000o("UploadChecker", "failed.", new Object[0]);
        }
    }

    static /* synthetic */ void O000000o(bmc bmc, int i) {
        bmz.O000000o("UploadChecker", "process finish with state=%s", Integer.valueOf(i));
        if (i == 3) {
            bmz.O000000o("UploadChecker", "process end because empty db.", new Object[0]);
        } else if (i == 1) {
            bmc.f13088O000000o.set(0);
            bmz.O000000o("UploadChecker", "success, process again. retryCount=%s", Integer.valueOf(bmc.f13088O000000o.get()));
            bmc.O000000o(bmc.O00000Oo());
        } else if (i == 2) {
            int incrementAndGet = bmc.f13088O000000o.incrementAndGet();
            bmz.O000000o("UploadChecker", "failure, process again. retryCount=%s", Integer.valueOf(bmc.f13088O000000o.get()));
            if (incrementAndGet > 1000000) {
                bmc.f13088O000000o.set(10);
            }
            bmc.O000000o(bmc.O00000Oo());
        } else if (i == 4) {
            bmc.O000000o(1000);
        }
    }
}
