package _m_j;

import _m_j.qv;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import java.util.Calendar;
import java.util.HashMap;

public final class qh {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f2396O000000o;
    public Handler O00000Oo;
    public ConnectivityManager O00000o;
    oh O00000o0;
    public BroadcastReceiver O00000oO;
    uc O00000oo;
    tt O0000O0o;
    ox O0000OOo;
    public O000000o O0000Oo = new O000000o(this, (byte) 0);
    public qv O0000Oo0 = new qv();
    public Looper O0000OoO;
    private SharedPreferences O0000Ooo;

    public qh(Context context, Looper looper, uc ucVar, ox oxVar, oh ohVar) {
        this.f2396O000000o = context;
        this.O0000OoO = looper;
        this.O00000oo = ucVar;
        this.O0000OOo = oxVar;
        this.O00000o0 = ohVar;
        this.O00000o = (ConnectivityManager) context.getSystemService("connectivity");
        this.O0000O0o = new tt();
        this.O0000Ooo = context.getSharedPreferences("AMAP_LOCATION_COLLECTOR", 0);
        if (!O00000Oo()) {
            O00000o0();
        }
    }

    private void O000000o(String str, int i) {
        SharedPreferences.Editor edit = this.O0000Ooo.edit();
        edit.putInt(str, i);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private boolean O00000Oo() {
        return Calendar.getInstance().get(6) == this.O0000Ooo.getInt("today_value", 0);
    }

    private void O00000o0() {
        O000000o("today_value", Calendar.getInstance().get(6));
        O000000o("uploaded_wifi_size", 0);
        O000000o("uploaded_gprs_size", 0);
    }

    public final void O000000o() {
        try {
            if (O00000o()) {
                this.O0000Oo0.O000000o(500);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        return;
     */
    public final synchronized void O000000o(int i, Object obj) {
        if (obj != null) {
            if (!O00000Oo()) {
                O00000o0();
            }
            qg qgVar = (qg) obj;
            if (i == 1) {
                O000000o("uploaded_wifi_size", this.O0000Ooo.getInt("uploaded_wifi_size", 0) + qgVar.O00000o0);
            } else if (i == 0) {
                O000000o("uploaded_gprs_size", this.O0000Ooo.getInt("uploaded_gprs_size", 0) + qgVar.O00000o0);
            }
        }
    }

    class O000000o implements qv.O000000o {
        private boolean O00000Oo;

        private O000000o() {
            this.O00000Oo = true;
        }

        /* synthetic */ O000000o(qh qhVar, byte b) {
            this();
        }

        public final Object O000000o(long j) {
            qh qhVar;
            boolean z;
            if (this.O00000Oo) {
                qhVar = qh.this;
                z = true;
            } else {
                qhVar = qh.this;
                z = false;
            }
            return qhVar.O000000o(z, j);
        }

        public final void O000000o(int i) {
            om.O00000Oo("@_3_3_@", "@_3_3_2_@".concat(String.valueOf(i)));
        }

        public final void O000000o(int i, Object obj) {
            qh.this.O000000o(i, obj);
        }

        public final void O00000Oo(Object obj) {
            qh.this.O000000o((qg) obj);
            this.O00000Oo = !this.O00000Oo;
        }

        public final int O00000o() {
            return 20000;
        }

        public final long O00000o(int i) {
            return i == 1 ? 512000 : 51200;
        }

        public final long O00000o0() {
            return 300000;
        }

        public final long O00000o0(int i) {
            return qh.this.O000000o(i);
        }

        public final void O00000oO() {
        }

        public final boolean O00000Oo(int i) {
            if (i == 1) {
                return true;
            }
            if (i == 0) {
                return qh.this.O00000o0.O00000oO.f2345O000000o;
            }
            return false;
        }

        public final long O000000o() {
            long j;
            if (!this.O00000Oo) {
                int i = (int) qh.this.O00000oo.O00000o.O00000o0;
                if (i <= 0) {
                    this.O00000Oo = true;
                } else if (i < 512000 && ((int) qh.this.O00000oo.O00000o.O00000Oo) > 512000) {
                    this.O00000Oo = true;
                }
            } else {
                int i2 = (int) qh.this.O00000oo.O00000o.O00000Oo;
                if (i2 <= 0) {
                    this.O00000Oo = false;
                } else if (i2 < 512000 && ((int) qh.this.O00000oo.O00000o.O00000o0) > 512000) {
                    this.O00000Oo = false;
                }
            }
            if (this.O00000Oo) {
                j = qh.this.O00000oo.O00000o.O00000Oo;
            } else {
                j = qh.this.O00000oo.O00000o.O00000o0;
            }
            int i3 = (int) j;
            if (i3 > 4000) {
                i3 = 512000;
            }
            return (long) i3;
        }

        public final boolean O000000o(Object obj) {
            qg qgVar = (qg) obj;
            byte[] O000000o2 = qh.this.O0000O0o.O000000o(qh.this.f2396O000000o, qh.this.O00000o0, qgVar);
            boolean z = false;
            if (O000000o2 != null) {
                byte[] bArr = null;
                try {
                    boolean z2 = qgVar.O00000Oo.get(0).f2524O000000o == 0;
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/octet-stream");
                    ov ovVar = new ov();
                    ovVar.O00000Oo = hashMap;
                    ovVar.O00000o0 = O000000o2;
                    ovVar.f2376O000000o = z2 ? oh.f2342O000000o ? "http://aps.testing.amap.com/collection/collectData?src=baseCol&ver=v74&" : "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&" : oh.f2342O000000o ? "http://aps.testing.amap.com/collection/collectData?src=extCol&ver=v74&" : "http://cgicol.amap.com/collection/collectData?src=extCol&ver=v74&";
                    ow O000000o3 = qh.this.O0000OOo.O000000o(ovVar);
                    if (O000000o3 != null && O000000o3.f2377O000000o == 200) {
                        bArr = O000000o3.O00000o0;
                    }
                    if (bArr != null) {
                        if ("true".equals(new String(bArr, "UTF-8"))) {
                            z = true;
                        }
                    }
                    StringBuilder sb = new StringBuilder("@_3_3_1_@");
                    sb.append(bArr != null ? new String(bArr, "UTF-8") : "null");
                    om.O00000Oo("@_3_3_@", sb.toString());
                } catch (Exception unused) {
                }
            }
            return z;
        }

        public final int O00000Oo() {
            return qh.this.O00000o0.O00000oO.O00000o;
        }
    }

    public final synchronized long O000000o(int i) {
        int i2;
        int i3;
        int i4;
        i2 = 0;
        if (i == 1) {
            try {
                if (!O00000Oo()) {
                    O00000o0();
                }
                i3 = this.O00000o0.O00000oO.O00000Oo;
                i4 = this.O0000Ooo.getInt("uploaded_wifi_size", 0);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            if (i == 0) {
                if (!O00000Oo()) {
                    O00000o0();
                }
                i3 = this.O00000o0.O00000oO.O00000o0;
                i4 = this.O0000Ooo.getInt("uploaded_gprs_size", 0);
            }
        }
        i2 = i3 - i4;
        return (long) i2;
    }

    public final synchronized qg O000000o(boolean z, long j) {
        return this.O00000oo.O00000o.O000000o(z, C.MSG_CUSTOM_BASE, j);
    }

    public final synchronized void O000000o(qg qgVar) {
        if (qgVar != null) {
            this.O00000oo.O00000o.O000000o(qgVar);
        }
    }

    private boolean O00000o() {
        return qq.O000000o(this.f2396O000000o) || this.O00000o0.O00000oO.f2345O000000o;
    }
}
