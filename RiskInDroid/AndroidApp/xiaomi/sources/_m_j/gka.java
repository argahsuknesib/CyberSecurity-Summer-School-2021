package _m_j;

import _m_j.gjt;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.BleSecureConnectManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

final class gka implements gkc {
    private static final byte[] O0000Ooo = "restore".getBytes();
    private static final byte[] O0000o00 = "retry".getBytes();

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17925O000000o;
    byte[] O00000Oo;
    byte[] O00000o;
    public byte[] O00000o0;
    byte[] O00000oO;
    public String O00000oo;
    public long O0000O0o;
    O000000o O0000OOo;
    gju O0000Oo;
    public Bundle O0000Oo0;
    public final BleConnectResponse O0000OoO = new BleConnectResponse() {
        /* class _m_j.gka.AnonymousClass6 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            long j;
            Bundle bundle = (Bundle) obj;
            fte.O00000Oo(String.format("BleFastConnector onResponse, code = %d", Integer.valueOf(i)));
            gka gka = gka.this;
            gka.O0000Oo0 = bundle;
            if (i == 0) {
                gka.O00000o0 = bundle.getByteArray("token");
                gka gka2 = gka.this;
                String str = gka2.O0000Oo.f17913O000000o;
                try {
                    j = Long.parseLong(str);
                } catch (Throwable th) {
                    gnk.O00000Oo(gnk.O00000Oo(th));
                    j = 0;
                }
                if (j > 0) {
                    gnk.O00000o0(String.format("sendUserId %s", str));
                    gjt.O000000o(gka2.f17925O000000o, glb.O00000oo, 0, gkk.O000000o(j), gka2.O00000o0, new gjt.O000000o() {
                        /* class _m_j.gka.AnonymousClass7 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            if (i == 0) {
                                gka gka = gka.this;
                                gnk.O00000o0(String.format("sendAPSSID %s", new String(gka.O00000Oo)));
                                gjt.O000000o(gka.f17925O000000o, glb.O00000oo, 1, gka.O00000Oo, gka.O00000o0, new gjt.O000000o() {
                                    /* class _m_j.gka.AnonymousClass11 */

                                    public final /* synthetic */ void onResponse(int i, Object obj) {
                                        if (i == 0) {
                                            gka gka = gka.this;
                                            int convert = (int) TimeUnit.SECONDS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
                                            gnk.O00000o0(String.format("sendTimeZone %ds", Integer.valueOf(convert)));
                                            gjt.O000000o(gka.f17925O000000o, glb.O00000oo, 5, gkk.O000000o(convert), gka.O00000o0, new gjt.O000000o() {
                                                /* class _m_j.gka.AnonymousClass8 */

                                                public final /* synthetic */ void onResponse(int i, Object obj) {
                                                    if (i == 0) {
                                                        gka gka = gka.this;
                                                        String str = gka.O0000Oo.O0000Oo0;
                                                        byte[] bArr = {0, 0, 0};
                                                        if (!TextUtils.isEmpty(str)) {
                                                            gkk.O000000o(bArr, str.getBytes(), 0, 0);
                                                        }
                                                        gnk.O00000o0(String.format("sendZoneCode %s", str));
                                                        gjt.O000000o(gka.f17925O000000o, glb.O00000oo, 6, bArr, gka.O00000o0, new gjt.O000000o() {
                                                            /* class _m_j.gka.AnonymousClass9 */

                                                            public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                if (i == 0) {
                                                                    gka gka = gka.this;
                                                                    String str = gka.O0000Oo.O0000Oo;
                                                                    gnk.O00000o0(String.format("timeArea %s", str));
                                                                    gjt.O000000o(gka.f17925O000000o, glb.O00000oo, 7, str.getBytes(), gka.O00000o0, new gjt.O000000o() {
                                                                        /* class _m_j.gka.AnonymousClass10 */

                                                                        public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                            if (i == 0) {
                                                                                gka gka = gka.this;
                                                                                gnk.O00000o0("sendConfigType " + new String(gka.O00000oO));
                                                                                gjt.O000000o(gka.f17925O000000o, glb.O00000oo, 8, gka.O00000oO, gka.O00000o0, new gjt.O000000o() {
                                                                                    /* class _m_j.gka.AnonymousClass12 */

                                                                                    public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                                        if (i == 0) {
                                                                                            gka gka = gka.this;
                                                                                            gnk.O00000o0("sendBindKey " + new String(gka.O00000o));
                                                                                            gjt.O000000o(gka.f17925O000000o, glb.O00000oo, 9, gka.O00000o, gka.O00000o0, new gjt.O000000o() {
                                                                                                /* class _m_j.gka.AnonymousClass13 */

                                                                                                public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                                                    if (i != 0) {
                                                                                                        gka.this.O000000o(i);
                                                                                                    } else if (TextUtils.isEmpty(gka.this.O00000oo) || gka.this.O0000O0o <= 0) {
                                                                                                        gka.this.O000000o(gka.this.O0000Oo.O0000OoO);
                                                                                                    } else {
                                                                                                        gka gka = gka.this;
                                                                                                        gnk.O00000o0("sendBindkeyIndex, bindkeyIndex = " + gka.O00000oo);
                                                                                                        gjt.O000000o(gka.f17925O000000o, glb.O00000oo, 13, gka.O00000oo.getBytes(), gka.O00000o0, new gjt.O000000o() {
                                                                                                            /* class _m_j.gka.AnonymousClass2 */

                                                                                                            public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                                                                if (i == 0) {
                                                                                                                    gka gka = gka.this;
                                                                                                                    gnk.O00000o0("sendBindkeyTimeStamp, bindkeyTimestamp = " + gka.O0000O0o);
                                                                                                                    gjt.O000000o(gka.f17925O000000o, glb.O00000oo, 14, gkk.O000000o(gka.O0000O0o), gka.O00000o0, new gjt.O000000o() {
                                                                                                                        /* class _m_j.gka.AnonymousClass3 */

                                                                                                                        public final /* synthetic */ void onResponse(int i, Object obj) {
                                                                                                                            if (i == 0) {
                                                                                                                                gka.this.O000000o(gka.this.O0000Oo.O0000OoO);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            gka.this.O000000o(i);
                                                                                                                        }
                                                                                                                    });
                                                                                                                    return;
                                                                                                                }
                                                                                                                gka.this.O000000o(i);
                                                                                                            }
                                                                                                        });
                                                                                                    }
                                                                                                }
                                                                                            });
                                                                                            return;
                                                                                        }
                                                                                        gka.this.O000000o(i);
                                                                                    }
                                                                                });
                                                                                return;
                                                                            }
                                                                            gka.this.O000000o(i);
                                                                        }
                                                                    });
                                                                    return;
                                                                }
                                                                gka.this.O000000o(i);
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    gka.this.O000000o(i);
                                                }
                                            });
                                            return;
                                        }
                                        gka.this.O000000o(i);
                                    }
                                });
                                return;
                            }
                            gka.this.O000000o(i);
                        }
                    });
                    return;
                }
                return;
            }
            gka.O000000o(i);
        }
    };
    private byte[] O0000o0;

    public interface O000000o extends BleResponse<Bundle> {
    }

    public gka(String str, gju gju) {
        this.O0000Oo = gju;
        this.f17925O000000o = str;
        this.O00000Oo = gju.O00000Oo().getBytes();
        this.O0000o0 = gju.O00000o0().getBytes();
        this.O00000o = gju.O000000o().getBytes();
        this.O00000oO = gju.O00000o().getBytes();
        this.O0000O0o = gju.O00000oO;
        this.O00000oo = gju.O00000oo;
    }

    public final void O000000o(BleConnectOptions bleConnectOptions, O000000o o000000o) {
        this.O0000OOo = o000000o;
        SecureConnectOptions.O000000o o000000o2 = new SecureConnectOptions.O000000o();
        o000000o2.f6884O000000o = bleConnectOptions;
        BleSecureConnectManager.O000000o(this.f17925O000000o, o000000o2.O000000o(), new gle() {
            /* class _m_j.gka.AnonymousClass1 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", gka.this.f17925O000000o);
                    intent.putExtra("extra_online_status", 80);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gka.this.O0000OoO.onResponse(i, bundle);
            }
        });
    }

    public final void O000000o(String str) {
        if ("IL".equalsIgnoreCase(str)) {
            str = "CN";
        }
        gnk.O00000o0("sendCountryCode, countryCode = ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            O000000o();
            return;
        }
        byte[] bArr = {0, 0, 0};
        gkk.O000000o(bArr, str.getBytes(), 0, 0);
        gjt.O000000o(this.f17925O000000o, glb.O00000oo, 10, bArr, this.O00000o0, new gjt.O000000o() {
            /* class _m_j.gka.AnonymousClass4 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    gka.this.O000000o();
                } else {
                    gka.this.O000000o(i);
                }
            }
        });
    }

    public final void O000000o() {
        gnk.O00000o0(String.format("sendAPPWD %s", new String(this.O0000o0)));
        gjt.O000000o(this.f17925O000000o, glb.O00000oo, 2, this.O0000o0, this.O00000o0, new gjt.O000000o() {
            /* class _m_j.gka.AnonymousClass5 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    gka gka = gka.this;
                    if (gka.O0000OOo != null) {
                        gka.O0000OOo.onResponse(0, gka.O0000Oo0);
                        return;
                    }
                    return;
                }
                gka.this.O000000o(i);
            }
        });
    }

    public final void O000000o(gjt.O000000o o000000o) {
        gnk.O00000o0(String.format("sendRetryCommand %s", gkk.O00000Oo(O0000o00)));
        gjt.O000000o(this.f17925O000000o, glb.O00000oo, 3, O0000o00, this.O00000o0, o000000o);
    }

    public final void O00000Oo(gjt.O000000o o000000o) {
        gnk.O00000o0(String.format("sendRestoreCommand %s", gkk.O00000Oo(O0000Ooo)));
        gjt.O000000o(this.f17925O000000o, glb.O00000oo, 4, O0000Ooo, this.O00000o0, o000000o);
    }

    public final void O000000o(int i) {
        O000000o o000000o = this.O0000OOo;
        if (o000000o != null) {
            o000000o.onResponse(i, this.O0000Oo0);
        }
    }
}
