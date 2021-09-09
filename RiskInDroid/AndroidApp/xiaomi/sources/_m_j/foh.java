package _m_j;

import _m_j.foa;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public final class foh implements fom {
    private static final byte[] O0000Oo = "restore".getBytes();
    private static final byte[] O0000OoO = "retry".getBytes();

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16748O000000o;
    byte[] O00000Oo;
    byte[] O00000o;
    public byte[] O00000o0;
    byte[] O00000oO;
    public String O00000oo;
    public long O0000O0o;
    O000000o O0000OOo;
    public Bundle O0000Oo0;
    private byte[] O0000Ooo;
    private final Response.BleConnectResponse O0000o00 = new Response.BleConnectResponse() {
        /* class _m_j.foh.AnonymousClass1 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            long j;
            fte.O00000Oo(String.format("BleFastConnector onResponse, code = %d", Integer.valueOf(i)));
            foh foh = foh.this;
            foh.O0000Oo0 = (Bundle) obj;
            if (i == 0) {
                foh.O00000o0 = foc.O0000OoO(foh.f16748O000000o);
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(205);
                foh foh2 = foh.this;
                String miId = SmartConfigRouterFactory.getCoreApiManager().getMiId();
                try {
                    j = Long.parseLong(miId);
                } catch (Throwable th) {
                    gnk.O00000Oo(gnk.O00000Oo(th));
                    j = 0;
                }
                if (j > 0) {
                    gnk.O00000o0(String.format("sendUserId %s", miId));
                    foa.O000000o(foh2.f16748O000000o, glb.O00000oo, 0, got.O000000o(j), foh2.O00000o0, new foa.O000000o() {
                        /* class _m_j.foh.AnonymousClass5 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("uid", String.valueOf(i));
                            if (i == 0) {
                                foh foh = foh.this;
                                gnk.O00000o0(String.format("sendAPSSID %s", new String(foh.O00000Oo)));
                                foa.O000000o(foh.f16748O000000o, glb.O00000oo, 1, foh.O00000Oo, foh.O00000o0, new foa.O000000o() {
                                    /* class _m_j.foh.AnonymousClass9 */

                                    public final /* synthetic */ void onResponse(int i, Object obj) {
                                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ssid", String.valueOf(i));
                                        if (i == 0) {
                                            foh foh = foh.this;
                                            int convert = (int) TimeUnit.SECONDS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
                                            gnk.O00000o0(String.format("sendTimeZone %ds", Integer.valueOf(convert)));
                                            foa.O000000o(foh.f16748O000000o, glb.O00000oo, 5, got.O000000o(convert), foh.O00000o0, new foa.O000000o() {
                                                /* class _m_j.foh.AnonymousClass6 */

                                                public final /* synthetic */ void onResponse(int i, Object obj) {
                                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("tz", String.valueOf(i));
                                                    if (i == 0) {
                                                        foh foh = foh.this;
                                                        String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
                                                        byte[] bArr = {0, 0, 0};
                                                        if (!TextUtils.isEmpty(countryDomain)) {
                                                            got.O000000o(bArr, countryDomain.getBytes(), 0, 0);
                                                        }
                                                        gnk.O00000o0(String.format("sendZoneCode %s", countryDomain));
                                                        foa.O000000o(foh.f16748O000000o, glb.O00000oo, 6, bArr, foh.O00000o0, new foa.O000000o() {
                                                            /* class _m_j.foh.AnonymousClass7 */

                                                            public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("zc", String.valueOf(i));
                                                                if (i == 0) {
                                                                    foh foh = foh.this;
                                                                    String str = (String) htr.O000000o().O000000o("gmt_tz", "");
                                                                    gnk.O00000o0(String.format("timeArea %s", str));
                                                                    foa.O000000o(foh.f16748O000000o, glb.O00000oo, 7, str.getBytes(), foh.O00000o0, new foa.O000000o() {
                                                                        /* class _m_j.foh.AnonymousClass8 */

                                                                        public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ta", String.valueOf(i));
                                                                            if (i == 0) {
                                                                                foh foh = foh.this;
                                                                                gnk.O00000o0("sendConfigType " + new String(foh.O00000oO));
                                                                                foa.O000000o(foh.f16748O000000o, glb.O00000oo, 8, foh.O00000oO, foh.O00000o0, new foa.O000000o() {
                                                                                    /* class _m_j.foh.AnonymousClass10 */

                                                                                    public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ct", String.valueOf(i));
                                                                                        if (i == 0) {
                                                                                            foh foh = foh.this;
                                                                                            gnk.O00000o0("sendBindKey " + new String(foh.O00000o));
                                                                                            foa.O000000o(foh.f16748O000000o, glb.O00000oo, 9, foh.O00000o, foh.O00000o0, new foa.O000000o() {
                                                                                                /* class _m_j.foh.AnonymousClass11 */

                                                                                                public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bk", String.valueOf(i));
                                                                                                    if (i != 0) {
                                                                                                        foh.this.O000000o(i);
                                                                                                    } else if (TextUtils.isEmpty(foh.this.O00000oo) || foh.this.O0000O0o <= 0) {
                                                                                                        foh.this.O000000o(SmartConfigRouterFactory.getCoreApiManager().getCountryCode());
                                                                                                    } else {
                                                                                                        foh foh = foh.this;
                                                                                                        gnk.O00000o0("sendBindkeyIndex, bindkeyIndex = " + foh.O00000oo);
                                                                                                        foa.O000000o(foh.f16748O000000o, glb.O00000oo, 13, foh.O00000oo.getBytes(), foh.O00000o0, new foa.O000000o() {
                                                                                                            /* class _m_j.foh.AnonymousClass12 */

                                                                                                            public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                                                                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bki", String.valueOf(i));
                                                                                                                if (i == 0) {
                                                                                                                    foh foh = foh.this;
                                                                                                                    gnk.O00000o0("sendBindkeyTimeStamp, bindkeyTimestamp = " + foh.O0000O0o);
                                                                                                                    foa.O000000o(foh.f16748O000000o, glb.O00000oo, 14, got.O000000o(foh.O0000O0o), foh.O00000o0, new foa.O000000o() {
                                                                                                                        /* class _m_j.foh.AnonymousClass2 */

                                                                                                                        public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                                                                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bkt", String.valueOf(i));
                                                                                                                            if (i == 0) {
                                                                                                                                foh.this.O000000o(SmartConfigRouterFactory.getCoreApiManager().getCountryCode());
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            foh.this.O000000o(i);
                                                                                                                        }
                                                                                                                    });
                                                                                                                    return;
                                                                                                                }
                                                                                                                foh.this.O000000o(i);
                                                                                                            }
                                                                                                        });
                                                                                                    }
                                                                                                }
                                                                                            });
                                                                                            return;
                                                                                        }
                                                                                        foh.this.O000000o(i);
                                                                                    }
                                                                                });
                                                                                return;
                                                                            }
                                                                            foh.this.O000000o(i);
                                                                        }
                                                                    });
                                                                    return;
                                                                }
                                                                foh.this.O000000o(i);
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    foh.this.O000000o(i);
                                                }
                                            });
                                            return;
                                        }
                                        foh.this.O000000o(i);
                                    }
                                });
                                return;
                            }
                            foh.this.O000000o(i);
                        }
                    });
                    return;
                }
                return;
            }
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(i);
            foh.this.O000000o(i);
        }
    };

    public interface O000000o extends Response.BleResponse<Bundle> {
    }

    public foh(String str, String str2, String str3, String str4, String str5) {
        str2 = str2 == null ? "" : str2;
        str3 = str3 == null ? "" : str3;
        str4 = str4 == null ? "" : str4;
        str5 = str5 == null ? "" : str5;
        this.f16748O000000o = str;
        this.O00000Oo = str2.getBytes();
        this.O0000Ooo = str3.getBytes();
        this.O00000o = str4.getBytes();
        this.O00000oO = str5.getBytes();
        this.O0000O0o = 0;
        this.O00000oo = null;
    }

    public final void O000000o(BleConnectOptions bleConnectOptions, O000000o o000000o) {
        this.O0000OOo = o000000o;
        fpo.O000000o(this.f16748O000000o, bleConnectOptions, this.O0000o00);
    }

    public final void O000000o(String str) {
        if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(str)) {
            str = "CN";
        }
        gnk.O00000o0("sendCountryCode, countryCode = ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            O000000o();
            return;
        }
        byte[] bArr = {0, 0, 0};
        got.O000000o(bArr, str.getBytes(), 0, 0);
        foa.O000000o(this.f16748O000000o, glb.O00000oo, 10, bArr, this.O00000o0, new foa.O000000o() {
            /* class _m_j.foh.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("cc", String.valueOf(i));
                if (i == 0) {
                    foh.this.O000000o();
                } else {
                    foh.this.O000000o(i);
                }
            }
        });
    }

    public final void O000000o() {
        gnk.O00000o0(String.format("sendAPPWD %s", new String(this.O0000Ooo)));
        foa.O000000o(this.f16748O000000o, glb.O00000oo, 2, this.O0000Ooo, this.O00000o0, new foa.O000000o() {
            /* class _m_j.foh.AnonymousClass4 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("pwd", String.valueOf(i));
                if (i == 0) {
                    foh foh = foh.this;
                    if (foh.O0000OOo != null) {
                        foh.O0000OOo.onResponse(0, foh.O0000Oo0);
                        return;
                    }
                    return;
                }
                foh.this.O000000o(i);
            }
        });
    }

    public final void O000000o(foa.O000000o o000000o) {
        gnk.O00000o0(String.format("sendRetryCommand %s", got.O00000o0(O0000OoO)));
        foa.O000000o(this.f16748O000000o, glb.O00000oo, 3, O0000OoO, this.O00000o0, o000000o);
    }

    public final void O00000Oo(foa.O000000o o000000o) {
        gnk.O00000o0(String.format("sendRestoreCommand %s", got.O00000o0(O0000Oo)));
        foa.O000000o(this.f16748O000000o, glb.O00000oo, 4, O0000Oo, this.O00000o0, o000000o);
    }

    public final void O000000o(int i) {
        O000000o o000000o = this.O0000OOo;
        if (o000000o != null) {
            o000000o.onResponse(i, this.O0000Oo0);
        }
    }
}
