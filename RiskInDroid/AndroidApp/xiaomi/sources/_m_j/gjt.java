package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.UUID;

public final class gjt {

    /* renamed from: O000000o  reason: collision with root package name */
    String f17909O000000o;
    UUID O00000Oo;
    public byte[] O00000o;
    int O00000o0;
    byte[] O00000oO;
    public int O00000oo;
    public Handler O0000O0o = new Handler(Looper.getMainLooper()) {
        /* class _m_j.gjt.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 16) {
                if (gkk.O000000o(gjt.this.O00000o)) {
                    gjt gjt = gjt.this;
                    byte[] bArr = {0, (byte) gjt.O00000o0};
                    if (!gkk.O000000o(gjt.O00000oO)) {
                        bArr = BLECipher.O000000o(gjt.O00000oO, bArr);
                    }
                    glw.O000000o().write(gjt.f17909O000000o, glb.f17954O000000o, gjt.O00000Oo, bArr, new BleWriteResponse() {
                        /* class _m_j.gjt.AnonymousClass2 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            if (i == 0) {
                                gjt.this.O000000o();
                            } else {
                                gjt.this.O00000Oo();
                            }
                        }
                    });
                } else if (gjt.this.O00000oo < gjt.this.O00000o.length) {
                    gjt gjt2 = gjt.this;
                    int length = gjt2.O00000o.length - gjt2.O00000oo;
                    int min = Math.min(18, length);
                    byte[] bArr2 = new byte[(min + 2)];
                    bArr2[0] = (byte) length;
                    bArr2[1] = (byte) gjt2.O00000o0;
                    gkk.O000000o(bArr2, gjt2.O00000o, 2, gjt2.O00000oo);
                    gjt2.O00000oo += min;
                    if (!gkk.O000000o(gjt2.O00000oO)) {
                        bArr2 = BLECipher.O000000o(gjt2.O00000oO, bArr2);
                    }
                    glw.O000000o().write(gjt2.f17909O000000o, glb.f17954O000000o, gjt2.O00000Oo, bArr2, new BleWriteResponse() {
                        /* class _m_j.gjt.AnonymousClass3 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            if (i == 0) {
                                gjt.this.O0000O0o.obtainMessage(16).sendToTarget();
                            } else {
                                gjt.this.O00000Oo();
                            }
                        }
                    });
                } else {
                    gjt.this.O000000o();
                }
            }
        }
    };
    private O000000o O0000OOo;

    public interface O000000o extends BleResponse<Void> {
    }

    private gjt(String str, UUID uuid, int i, byte[] bArr, byte[] bArr2, O000000o o000000o) {
        this.f17909O000000o = str;
        this.O00000Oo = uuid;
        this.O00000o0 = i;
        this.O00000oO = bArr2;
        this.O00000o = bArr;
        this.O0000OOo = o000000o;
    }

    public static void O000000o(String str, UUID uuid, int i, byte[] bArr, byte[] bArr2, O000000o o000000o) {
        new gjt(str, uuid, i, bArr, bArr2, o000000o).O0000O0o.obtainMessage(16, 0).sendToTarget();
    }

    public final void O000000o() {
        O000000o o000000o = this.O0000OOo;
        if (o000000o != null) {
            o000000o.onResponse(0, null);
        }
    }

    public final void O00000Oo() {
        O000000o o000000o = this.O0000OOo;
        if (o000000o != null) {
            o000000o.onResponse(-1, null);
        }
    }
}
