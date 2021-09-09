package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthConnector$2;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import java.util.UUID;

public abstract class fis extends fgm {
    public Handler O0000Oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.fis.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 569) {
                fec.O00000o().O000000o(37, 8);
                if (fis.this.O0000OoO != null) {
                    fis.this.O0000OoO.onResponse(0, null);
                    fis.this.O0000OoO = null;
                }
            }
        }
    };
    private IBleChannelWriter O0000Oo0 = ffa.O00000Oo().O00000Oo(O00000o0(), this.O0000Ooo);
    public BleNotifyResponse O0000OoO = null;
    private IBleChannelReader O0000Ooo = new BleStandardAuthConnector$2(this);

    public void O000000o(Message message) {
    }

    public abstract void O000000o(byte[] bArr, int i);

    protected fis(fgp fgp) {
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

    public void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        ChannelManager.O000000o O00000oO;
        if (glb.f17954O000000o.equals(uuid) && glb.O0000o.equals(uuid2) && (O00000oO = ffa.O00000Oo().O00000oO(O00000o0())) != null) {
            O00000oO.O000000o(bArr);
        }
    }

    public final void O00000Oo(final BleNotifyResponse bleNotifyResponse) {
        fec.O00000o().O000000o(23);
        fec.O00000o().O000000o(23, "char", glb.O0000o.toString());
        glw.O000000o().notify(O00000o0(), glb.f17954O000000o, glb.O0000o, new BleNotifyResponse() {
            /* class _m_j.fis.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    fis.this.O0000OoO = bleNotifyResponse;
                    fec.O00000o().O00000Oo(23);
                    fis fis = fis.this;
                    fec.O00000o().O000000o(40);
                    fis.O000000o(fis.O00000o0(), new BleResponse<String>() {
                        /* class _m_j.fis.AnonymousClass3 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            String str = (String) obj;
                            if (i != 0) {
                                fec.O00000o().O000000o(40, "error_code", String.valueOf(i));
                                fec.O00000o().O000000o(40, 2);
                                fis.this.O0000OOo();
                                return;
                            }
                            fec.O00000o().O000000o(40, "version", str);
                            fec.O00000o().O00000Oo(40);
                            boolean O000000o2 = flo.O000000o(4, str);
                            boolean z = false;
                            gnk.O000000o("before sendA4, check version , is standard auth Device, firmware version %s, need send A4 result is %s", str, String.valueOf(O000000o2));
                            String O0000Oo = ffr.O0000Oo(fis.this.O00000o0());
                            gnk.O00000o("sendA4Step model: ".concat(String.valueOf(O0000Oo)));
                            if (!TextUtils.isEmpty(O0000Oo) && O0000Oo.startsWith("xiaomi.wifispeaker.")) {
                                z = true;
                            }
                            if (!O000000o2 || z) {
                                gnk.O00000o("at send A4 step, check no need to send A4");
                                fis.this.O0000OOo();
                                return;
                            }
                            fec.O00000o().O000000o(37);
                            gnk.O00000o("connector start send A4");
                            fis.this.O0000Oo.sendEmptyMessageDelayed(569, 5000);
                            few.O00000Oo().O00000o0(fis.this.O00000o0());
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

    public final void O0000OOo() {
        gnk.O00000o("receive A4 result");
        this.O0000Oo.removeMessages(569);
        BleNotifyResponse bleNotifyResponse = this.O0000OoO;
        if (bleNotifyResponse != null) {
            bleNotifyResponse.onResponse(0, null);
            this.O0000OoO = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final String str, final String str2, final feo<Void, fes> feo) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            feo.O000000o(new fes(-1, "mac or did is null"));
        } else {
            O000000o(str, new BleResponse<String>() {
                /* class _m_j.fis.AnonymousClass4 */

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
                    ffr.O0000o0o(fis.this.O00000o0(), str);
                    fgm.O000000o(str, str2, str);
                    fgo.O00000Oo(str2, str, new feo<Void, fes>() {
                        /* class _m_j.fis.AnonymousClass4.AnonymousClass1 */

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
        ffa.O00000Oo().O000000o(O00000o0(), this.O0000Ooo);
    }
}
