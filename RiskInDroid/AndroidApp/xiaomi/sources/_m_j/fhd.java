package _m_j;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipConnector$2;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import java.util.UUID;

public abstract class fhd extends fgm {
    private IBleChannelReader O0000Oo = new BleSecurityChipConnector$2(this);
    private IBleChannelWriter O0000Oo0 = few.O00000Oo().O00000Oo(O00000o0(), this.O0000Oo);
    public Handler O0000ooO = new Handler(Looper.getMainLooper()) {
        /* class _m_j.fhd.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 569) {
                fec.O00000o().O000000o(37, 8);
                if (fhd.this.O0000ooo != null) {
                    fhd.this.O0000ooo.onResponse(0, null);
                    fhd.this.O0000ooo = null;
                }
            }
        }
    };
    public BleNotifyResponse O0000ooo = null;

    public void O000000o(Message message) {
    }

    public abstract void O000000o(byte[] bArr, int i);

    /* access modifiers changed from: protected */
    public boolean O0000OoO() {
        return false;
    }

    protected fhd(fgp fgp) {
        super(fgp);
    }

    public final boolean O000000o(byte[] bArr, int i, IBleResponse iBleResponse) {
        try {
            this.O0000Oo0.write(bArr, i, iBleResponse);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void O0000OOo() {
        gnk.O00000o("receive A4 result");
        this.O0000ooO.removeMessages(569);
        BleNotifyResponse bleNotifyResponse = this.O0000ooo;
        if (bleNotifyResponse != null) {
            bleNotifyResponse.onResponse(0, null);
            this.O0000ooo = null;
        }
    }

    public void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        ChannelManager.O000000o O00000oO;
        if (glb.f17954O000000o.equals(uuid) && glb.O0000o0.equals(uuid2) && (O00000oO = few.O00000Oo().O00000oO(O00000o0())) != null) {
            O00000oO.O000000o(bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        fec.O00000o().O000000o(44);
        Bundle bundle = new Bundle();
        bundle.putString("extra.pair.code", str);
        this.f16262O000000o.O000000o(bundle);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(final BleNotifyResponse bleNotifyResponse) {
        fec.O00000o().O000000o(23);
        fec.O00000o().O000000o(23, "char", glb.O0000o0.toString());
        glw.O000000o().notify(O00000o0(), glb.f17954O000000o, glb.O0000o0, new BleNotifyResponse() {
            /* class _m_j.fhd.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    fec.O00000o().O000000o(23, 0);
                    fhd fhd = fhd.this;
                    fhd.O0000ooo = bleNotifyResponse;
                    fec.O00000o().O000000o(40);
                    fhd.O000000o(fhd.O00000o0(), new BleResponse<String>() {
                        /* class _m_j.fhd.AnonymousClass2 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            String str = (String) obj;
                            if (i != 0) {
                                fec.O00000o().O000000o(40, "error_code", String.valueOf(i));
                                fec.O00000o().O000000o(40, 2);
                                fhd.this.O0000OOo();
                                return;
                            }
                            fec.O00000o().O000000o(40, "version", str);
                            fec.O00000o().O00000Oo(40);
                            int i2 = fhd.this.O0000OoO() ? 5 : 1;
                            boolean O000000o2 = flo.O000000o(i2, str);
                            gnk.O000000o("before sendA4, check version , isMeshDevice %s, firmware version %s, need send A4 result is %s", String.valueOf(fhd.this.O0000OoO()), str, String.valueOf(O000000o2));
                            if (O000000o2) {
                                gnk.O00000o("connector start send A4");
                                fec.O00000o().O000000o(37);
                                fec.O00000o().O000000o(37, "auth-type", String.valueOf(i2));
                                fhd.this.O0000ooO.sendEmptyMessageDelayed(569, 5000);
                                few.O00000Oo().O00000o0(fhd.this.O00000o0());
                                return;
                            }
                            gnk.O00000o("at send A4 step, check no need to send A4");
                            fhd.this.O0000OOo();
                        }
                    });
                    return;
                }
                fec.O00000o().O000000o(23, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(23, 3);
                bleNotifyResponse.onResponse(i, null);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final String str, final String str2, final feo<Void, fes> feo) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            feo.O000000o(new fes(-1, "mac or did is null"));
        } else {
            O000000o(str, new BleResponse<String>() {
                /* class _m_j.fhd.AnonymousClass4 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    String str = (String) obj;
                    if (i != 0 || TextUtils.isEmpty(str)) {
                        feo feo = feo;
                        if (feo != null) {
                            feo.O000000o(new fes(-1, "read version failed"));
                            return;
                        }
                        return;
                    }
                    fgm.O000000o(str, str2, str);
                    fgo.O00000Oo(str2, str, new feo<Void, fes>() {
                        /* class _m_j.fhd.AnonymousClass4.AnonymousClass1 */

                        public final void O000000o(fes fes) {
                            if (feo != null) {
                                feo.O000000o(fes);
                            }
                        }

                        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                            if (feo != null) {
                                feo.O000000o((Object) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public final void O00000Oo() {
        few.O00000Oo().O000000o(O00000o0(), this.O0000Oo);
    }
}
