package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import java.util.UUID;

public final class foa {

    /* renamed from: O000000o  reason: collision with root package name */
    String f16731O000000o;
    UUID O00000Oo;
    public byte[] O00000o;
    int O00000o0;
    byte[] O00000oO;
    public int O00000oo;
    public Handler O0000O0o = new Handler(Looper.getMainLooper()) {
        /* class _m_j.foa.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 16) {
                if (got.O00000o(foa.this.O00000o)) {
                    foa foa = foa.this;
                    byte[] bArr = {0, (byte) foa.O00000o0};
                    if (!got.O00000o(foa.O00000oO)) {
                        bArr = BLECipher.O000000o(foa.O00000oO, bArr);
                    }
                    XmBluetoothManager.getInstance().write(foa.f16731O000000o, glb.f17954O000000o, foa.O00000Oo, bArr, new Response.BleWriteResponse() {
                        /* class _m_j.foa.AnonymousClass2 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            if (i == 0) {
                                foa.this.O000000o();
                            } else {
                                foa.this.O00000Oo();
                            }
                        }
                    });
                } else if (foa.this.O00000oo < foa.this.O00000o.length) {
                    foa foa2 = foa.this;
                    int length = foa2.O00000o.length - foa2.O00000oo;
                    int min = Math.min(18, length);
                    byte[] bArr2 = new byte[(min + 2)];
                    bArr2[0] = (byte) length;
                    bArr2[1] = (byte) foa2.O00000o0;
                    got.O000000o(bArr2, foa2.O00000o, 2, foa2.O00000oo);
                    foa2.O00000oo += min;
                    if (!got.O00000o(foa2.O00000oO)) {
                        bArr2 = BLECipher.O000000o(foa2.O00000oO, bArr2);
                    }
                    XmBluetoothManager.getInstance().write(foa2.f16731O000000o, glb.f17954O000000o, foa2.O00000Oo, bArr2, new Response.BleWriteResponse() {
                        /* class _m_j.foa.AnonymousClass3 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            if (i == 0) {
                                foa.this.O0000O0o.obtainMessage(16).sendToTarget();
                            } else {
                                foa.this.O00000Oo();
                            }
                        }
                    });
                } else {
                    foa.this.O000000o();
                }
            }
        }
    };
    private O000000o O0000OOo;

    public interface O000000o extends Response.BleResponse<Void> {
    }

    private foa(String str, UUID uuid, int i, byte[] bArr, byte[] bArr2, O000000o o000000o) {
        this.f16731O000000o = str;
        this.O00000Oo = uuid;
        this.O00000o0 = i;
        this.O00000oO = bArr2;
        this.O00000o = bArr;
        this.O0000OOo = o000000o;
    }

    public static void O000000o(String str, UUID uuid, int i, byte[] bArr, byte[] bArr2, O000000o o000000o) {
        new foa(str, uuid, i, bArr, bArr2, o000000o).O0000O0o.obtainMessage(16, 0).sendToTarget();
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
