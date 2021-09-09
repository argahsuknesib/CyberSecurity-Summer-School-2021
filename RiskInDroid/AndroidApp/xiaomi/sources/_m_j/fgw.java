package _m_j;

import android.os.Message;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.UUID;

public final class fgw extends fgu {
    byte[] O0000Oo;
    private final BleNotifyResponse O0000OoO = new BleNotifyResponse() {
        /* class _m_j.fgw.AnonymousClass2 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            fte.O00000Oo("Step 2 onResponse: " + gmc.O000000o(i));
            if (i == 0) {
                fgw.this.O0000o00();
            } else {
                fgw.this.O000000o(-27);
            }
        }
    };

    protected fgw(fgp fgp) {
        super(fgp);
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O00000o0) && this.O0000OOo.hasMessages(1)) {
            this.O0000OOo.removeMessages(1);
            byte[] O000000o2 = feb.O000000o(O00000o0(), O00000o());
            String O00000o0 = O00000o0();
            if (got.O000000o(BLECipher.O000000o(BLECipher.O00000Oo(ffr.O0000OoO(O00000o0), O00000o()), BLECipher.O000000o(O000000o2, bArr)), this.O0000Oo)) {
                fec.O00000o().O00000Oo(6);
                if (this.O00000Oo) {
                    O000000o(-2);
                    return;
                }
                fte.O00000Oo("Process Step 4 ...");
                byte[] O000000o3 = BLECipher.O000000o(this.O0000Oo, got.O000000o(-95114350));
                fec.O00000o().O000000o(7);
                glw.O000000o().write(O00000o0(), glb.f17954O000000o, glb.O00000o0, O000000o3, new BleWriteResponse() {
                    /* class _m_j.fgw.AnonymousClass4 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        fte.O00000Oo("Step 4 onResponse: " + gmc.O000000o(i));
                        if (i == 0) {
                            fec.O00000o().O00000Oo(7);
                            fgw fgw = fgw.this;
                            fgw.O000000o(fgw.O0000Oo, i);
                            return;
                        }
                        fec.O00000o().O000000o(7, "error_code", String.valueOf(i));
                        fec.O00000o().O000000o(7, 2);
                        fgw.this.O000000o(i);
                    }
                });
                return;
            }
            fec.O00000o().O000000o(6, "msg", "token not match");
            fte.O00000Oo("token not match");
            fec.O00000o().O000000o(6, 10);
            O000000o(-31);
        }
    }

    public final void O000000o(Message message) {
        if (message.what == 1) {
            fte.O00000Oo("notify timeout");
            fec.O00000o().O000000o();
            O000000o(-55);
        }
    }

    public final byte[] O0000Oo0() {
        return this.O0000Oo;
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("Process Step 1 ...");
        fec.O00000o().O000000o(4);
        glw.O000000o().write(O00000o0(), glb.f17954O000000o, glb.O0000OOo, got.O000000o(-561657200), new BleWriteResponse() {
            /* class _m_j.fgw.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("Step 1 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fec.O00000o().O00000Oo(4);
                    fgw.this.O0000OoO();
                    return;
                }
                fec.O00000o().O000000o(4, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(4, 2);
                fgw.this.O000000o(-28);
            }
        });
    }

    public final void O0000OoO() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("Process Step 2 ...");
        O00000Oo(this.O0000OoO);
    }

    public final void O0000o00() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("Process Step 3");
        this.O0000Oo = feb.O00000Oo(String.format("token.%d.%f", Long.valueOf(System.currentTimeMillis()), Double.valueOf(gpw.O000000o())));
        byte[] O000000o2 = BLECipher.O000000o(feb.O000000o(O00000o0(), O00000o()), this.O0000Oo);
        fec.O00000o().O000000o(5);
        glw.O000000o().write(O00000o0(), glb.f17954O000000o, glb.O00000o0, O000000o2, new BleWriteResponse() {
            /* class _m_j.fgw.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    fec.O00000o().O00000Oo(5);
                    return;
                }
                fec.O00000o().O000000o(5, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(5, 2);
            }
        });
        fec.O00000o().O000000o(6);
        this.O0000OOo.removeMessages(1);
        this.O0000OOo.sendEmptyMessageDelayed(1, 15000);
    }
}
