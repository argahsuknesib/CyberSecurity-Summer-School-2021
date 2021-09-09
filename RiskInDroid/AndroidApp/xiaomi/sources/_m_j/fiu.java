package _m_j;

import android.os.Message;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthLoginConnector$4;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthLoginConnector$5;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

public final class fiu extends fis {
    private static final byte[] O0000Oo0 = {36, 0, 0, 0};
    private static final byte[] O0000Ooo = {33, 0, 0, 0};
    private static final byte[] O0000o0 = {35, 0, 0, 0};
    private static final byte[] O0000o00 = {34, 0, 0, 0};
    private static final byte[] O0000o0O = {-32, 0, 0, 0};
    private static final byte[] O0000o0o = {-30, 0, 0, 0};
    private byte[] O0000o;
    private byte[] O0000oO;
    private byte[] O0000oO0;
    private byte[] O0000oOO;
    private byte[] O0000oOo;
    private byte[] O0000oo;
    private byte[] O0000oo0;
    private byte[] O0000ooO;

    protected fiu(fgp fgp) {
        super(fgp);
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (!uuid.equals(glb.f17954O000000o) || !uuid2.equals(glb.O0000OOo)) {
            if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O0000o)) {
                super.O000000o(uuid, uuid2, bArr);
            }
        } else if (this.O00000Oo) {
            O000000o(-2);
        } else {
            fte.O00000Oo("BleStandardAuthLoginConnector receiveDeviceResult ..., value = " + got.O00000o0(bArr));
            if (got.O00000Oo(bArr, O0000Ooo)) {
                this.O0000OOo.removeMessages(4103);
                this.O00000oO.putByteArray("session_key", this.O0000oOO);
                O000000o(0);
            } else if (got.O00000Oo(bArr, O0000o00) || got.O00000Oo(bArr, O0000o0)) {
                this.O0000OOo.removeMessages(4103);
                O000000o(-52);
            } else if (got.O00000Oo(bArr, O0000o0O)) {
                this.O0000OOo.removeMessages(4103);
                O000000o(-16);
            } else if (got.O00000Oo(bArr, O0000o0o)) {
                this.O0000OOo.removeMessages(4103);
                O000000o(-53);
            }
        }
    }

    public final void O000000o(Message message) {
        if (message.what == 4103) {
            fte.O00000Oo("BleStandardAuthLoginConnector notify timeout");
            O000000o(-7);
        }
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, bArr2);
            return O000000o2.O000000o("mible-login-info".getBytes(), 64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(byte[] bArr, int i) {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        if (i == 12) {
            fte.O00000Oo("BleStandardAuthLoginConnector recvDevConfirmation ...");
            if (this.O00000Oo) {
                O000000o(-2);
                return;
            }
            this.O0000OOo.removeMessages(4103);
            byte[] bArr2 = this.O0000oO;
            byte[] bArr3 = new byte[(bArr2.length + this.O0000o.length)];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            byte[] bArr4 = this.O0000o;
            System.arraycopy(bArr4, 0, bArr3, this.O0000oO.length, bArr4.length);
            if (got.O00000Oo(bArr, fir.O000000o(this.O0000oOo, bArr3))) {
                fte.O00000Oo("BleStandardAuthLoginConnector verify device confirm success ...");
                fte.O00000Oo("BleStandardAuthLoginConnector sendAppConfirm ...");
                if (this.O00000Oo) {
                    O000000o(-2);
                } else if (got.O00000o(this.O0000oO0)) {
                    fte.O00000Oo("BleStandardAuthLoginConnector sendAppConfirm mAppConfirm is empty");
                    O000000o(-52);
                } else if (!O000000o(this.O0000oO0, 10, new BleStandardAuthLoginConnector$5(this))) {
                    O000000o(-28);
                }
                this.O0000OOo.removeMessages(4103);
                this.O0000OOo.sendEmptyMessageDelayed(4103, 15000);
                return;
            }
        } else if (i == 13) {
            if (this.O00000Oo) {
                O000000o(-2);
                return;
            }
            fte.O00000Oo("BleStandardAuthLoginConnector recvDevRandom ...");
            this.O0000OOo.removeMessages(4103);
            this.O0000oO = bArr;
            byte[] bArr5 = this.O0000o;
            byte[] bArr6 = new byte[(bArr5.length + this.O0000oO.length)];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            byte[] bArr7 = this.O0000oO;
            System.arraycopy(bArr7, 0, bArr6, this.O0000o.length, bArr7.length);
            this.O0000oOO = O000000o(O00000oO(), bArr6);
            byte[] bArr8 = this.O0000oOO;
            if (bArr8 != null) {
                this.O0000oOo = new byte[16];
                System.arraycopy(bArr8, 0, this.O0000oOo, 0, 16);
                this.O0000oo0 = new byte[16];
                System.arraycopy(this.O0000oOO, 16, this.O0000oo0, 0, 16);
                this.O0000oo = new byte[4];
                System.arraycopy(this.O0000oOO, 32, this.O0000oo, 0, 4);
                this.O0000ooO = new byte[4];
                System.arraycopy(this.O0000oOO, 36, this.O0000ooO, 0, 4);
                this.O0000oO0 = fir.O000000o(this.O0000oo0, bArr6);
                this.O0000OOo.sendEmptyMessageDelayed(4103, 15000);
                return;
            }
        } else {
            return;
        }
        O000000o(-52);
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleStandardAuthLoginConnector Process Step 1 ...");
        ffr.O00000o(O00000o0(), "".getBytes());
        O00000Oo(new BleNotifyResponse() {
            /* class _m_j.fiu.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleStandardAuthLoginConnector Step 1 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fiu.this.O0000OoO();
                } else {
                    fiu.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000OoO() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleStandardAuthLoginConnector Process Step 1 plus ...");
        O000000o(new BleNotifyResponse() {
            /* class _m_j.fiu.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleStandardAuthLoginConnector Step 1 plus onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fiu.this.O0000Ooo();
                } else {
                    fiu.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000Ooo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleStandardAuthLoginConnector sendLoginStart ...");
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, O0000Oo0, new BleWriteResponse() {
            /* class _m_j.fiu.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleStandardAuthLoginConnector sendRegStart onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fiu.this.O0000o00();
                } else {
                    fiu.this.O000000o(-28);
                }
            }
        });
    }

    public final void O0000o00() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleStandardAuthLoginConnector sendAppRandom ...");
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        this.O0000o = bArr;
        if (!O000000o(this.O0000o, 11, new BleStandardAuthLoginConnector$4(this))) {
            O000000o(-28);
        }
    }
}
