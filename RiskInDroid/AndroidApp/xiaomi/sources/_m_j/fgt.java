package _m_j;

import android.os.Message;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.Arrays;
import java.util.UUID;

public final class fgt extends fgu {
    private byte[] O0000Oo;
    private final BleNotifyResponse O0000OoO = new BleNotifyResponse() {
        /* class _m_j.fgt.AnonymousClass1 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            fte.O00000Oo("Step 1 onResponse: " + gmc.O000000o(i));
            if (i == 0) {
                fgt.this.O0000OoO();
            } else {
                fgt.this.O000000o(-27);
            }
        }
    };

    protected fgt(fgp fgp) {
        super(fgp);
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O00000o0)) {
            if (this.O0000OOo.hasMessages(1)) {
                this.O0000OOo.removeMessages(1);
                if (bArr == null || bArr.length < 4) {
                    O000000o(-31);
                    return;
                }
                byte[] O00000oO = O00000oO();
                byte[] O000000o2 = BLECipher.O000000o(O00000oO, bArr);
                this.O0000Oo = Arrays.copyOfRange(O00000oO, 0, O00000oO.length);
                for (int i = 0; i < 4; i++) {
                    byte[] bArr2 = this.O0000Oo;
                    bArr2[i] = (byte) (bArr2[i] ^ O000000o2[i]);
                }
                byte[] O000000o3 = BLECipher.O000000o(this.O0000Oo, got.O000000o(-1816155127));
                if (this.O00000Oo) {
                    O000000o(-2);
                    return;
                }
                fte.O00000Oo("Process Step 3");
                glw.O000000o().write(O00000o0(), glb.f17954O000000o, glb.O00000o0, O000000o3, new BleWriteResponse() {
                    /* class _m_j.fgt.AnonymousClass3 */

                    public final /* bridge */ /* synthetic */ void onResponse(int i, Object obj) {
                    }
                });
                this.O0000OOo.removeMessages(2);
                this.O0000OOo.sendEmptyMessageDelayed(2, 15000);
            } else if (this.O0000OOo.hasMessages(2)) {
                this.O0000OOo.removeMessages(2);
                if (got.O000000o(Arrays.copyOfRange(BLECipher.O000000o(this.O0000Oo, bArr), 0, 4), got.O000000o(916084937))) {
                    O000000o(O00000oO(), 0);
                } else {
                    O000000o(-10);
                }
            }
        }
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 1) {
            fte.O00000Oo("tick notify timeout");
            this.O0000OOo.removeMessages(1);
            O000000o(-7);
        } else if (i == 2) {
            fte.O00000Oo("confirm notify timeout");
            this.O0000OOo.removeMessages(2);
            if (O0000Ooo()) {
                O000000o(-7);
            } else {
                O000000o(-10);
            }
        }
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("Process Step 1 ...");
        O00000Oo(this.O0000OoO);
    }

    public final void O0000OoO() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("Process Step 2");
        glw.O000000o().write(O00000o0(), glb.f17954O000000o, glb.O0000OOo, got.O000000o(-851198976), new BleWriteResponse() {
            /* class _m_j.fgt.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void onResponse(int i, Object obj) {
            }
        });
        this.O0000OOo.removeMessages(1);
        this.O0000OOo.sendEmptyMessageDelayed(1, 15000);
    }
}
