package _m_j;

import _m_j.dxz;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.miot.support.monitor.exceptions.MiotMonitorBaseException;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONObject;

public final class gzj {

    /* renamed from: O000000o  reason: collision with root package name */
    public dxy f18616O000000o;
    private boolean O00000Oo = true;

    public gzj(boolean z) {
        this.O00000Oo = z;
        if (this.f18616O000000o == null) {
            dxz dxz = dxz.O000000o.f15051O000000o;
            dxz.f15050O000000o.f15049O000000o = new dzd() {
                /* class _m_j.gzj.AnonymousClass1 */

                public final void O000000o(int i, String str, MiotMonitorBaseException miotMonitorBaseException) {
                    try {
                        gsy.O00000o0(LogType.MONITOR, String.valueOf(i), miotMonitorBaseException.getLogInfo());
                        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && TextUtils.equals(str, "1")) {
                            CrashReport.O000000o(miotMonitorBaseException);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public final void O000000o(String str, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        gsy.O00000o0(LogType.MONITOR, str, jSONObject.toString());
                    }
                }

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                public final void O000000o(int i, String str, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            if (!TextUtils.equals(str, "1")) {
                                if (TextUtils.equals(str, "2")) {
                                    switch (i) {
                                        case 103:
                                            gsy.O00000o0(LogType.MONITOR, String.valueOf(i), jSONObject.toString());
                                            hxi.O0000O0o.f955O000000o.O000000o("lifecycle_time", null, jSONObject, "");
                                            return;
                                        case 104:
                                            hxi.O0000O0o.f955O000000o.O000000o("appstart_time", null, jSONObject, "");
                                            return;
                                        case 105:
                                            hxi.O0000O0o.f955O000000o.O000000o("fps", null, jSONObject, "");
                                            return;
                                        case 106:
                                            hxi.O0000O0o.f955O000000o.O000000o("ram_statistics", null, jSONObject, "");
                                            return;
                                        case 107:
                                            hxi.O0000O0o.f955O000000o.O000000o("http_time", null, jSONObject, "");
                                            return;
                                        case 108:
                                            hxi.O0000O0o.f955O000000o.O000000o("http_net_rate", null, jSONObject, "");
                                            return;
                                        case 109:
                                            hxi.O0000O0o.f955O000000o.O000000o("http_net_failed", null, jSONObject, "");
                                            return;
                                        case 110:
                                            hxi.O0000O0o.f955O000000o.O000000o("http_dns_ip", null, jSONObject, "");
                                            return;
                                        case 111:
                                            hxi.O0000O0o.f955O000000o.O000000o("http_dns_type", null, jSONObject, "");
                                            return;
                                        default:
                                            return;
                                    }
                                    e.printStackTrace();
                                }
                                gsy.O00000o0(LogType.MONITOR, String.valueOf(i), jSONObject.toString());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            dxz.f15050O000000o.O0000Oo = this.O00000Oo;
            this.f18616O000000o = dxz.f15050O000000o;
        }
    }
}
