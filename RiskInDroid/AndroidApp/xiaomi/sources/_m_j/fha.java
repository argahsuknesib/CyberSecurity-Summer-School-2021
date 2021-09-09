package _m_j;

import android.os.Message;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleMeshLoginConnector$4;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleMeshLoginConnector$5;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.util.UUID;

public final class fha extends fhd {
    private static final byte[] O0000Oo = {80, 0, 0, 0};
    public static final byte[] O0000Oo0 = {-32, 0, 0, 0};
    private static final byte[] O0000OoO = {81, 0, 0, 0};
    private static final byte[] O0000Ooo = {82, 0, 0, 0};
    private PublicKey O0000o0;
    private KeyPair O0000o00;
    private byte[] O0000o0O;
    private byte[] O0000o0o;

    /* access modifiers changed from: protected */
    public final boolean O0000OoO() {
        return true;
    }

    protected fha(fgp fgp, byte[] bArr) {
        super(fgp);
        this.O0000o0o = bArr;
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (!uuid.equals(glb.f17954O000000o) || !uuid2.equals(glb.O0000OOo)) {
            if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O0000o0)) {
                super.O000000o(uuid, uuid2, bArr);
            }
        } else if (this.O00000Oo) {
            O000000o(-2);
        } else {
            fte.O00000Oo("BleMeshLoginConnector Process Step 7 ..., value = " + got.O00000o0(bArr));
            if (got.O00000Oo(bArr, O0000OoO)) {
                this.O0000OOo.removeMessages(4099);
                this.O00000oO.putByteArray("session_key", this.O0000o0O);
                O000000o(0);
            } else if (got.O00000Oo(bArr, O0000Ooo)) {
                this.O0000OOo.removeMessages(4099);
                O000000o(-22);
            } else if (got.O00000Oo(bArr, O0000Oo0)) {
                this.O0000OOo.removeMessages(4099);
                O000000o(-16);
            }
        }
    }

    private byte[] O000000o(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[65];
        bArr3[0] = 4;
        System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        try {
            this.O0000o0 = fio.O000000o(bArr3, ((ECPublicKey) this.O0000o00.getPublic()).getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            byte[] bArr4 = new byte[64];
            System.arraycopy(fir.O000000o(this.O0000o0, this.O0000o00.getPrivate()).getEncoded(), 0, bArr4, 0, 32);
            System.arraycopy(bArr2, 0, bArr4, 32, 32);
            this.O0000o0O = O000000o(bArr4);
            return fir.O000000o(Arrays.copyOfRange(this.O0000o0O, 16, 32), new byte[]{16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27}, glf.O000000o(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static byte[] O000000o(byte[] bArr) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, "miot-mesh-login-salt".getBytes());
            return O000000o2.O000000o("miot-mesh-login-info".getBytes(), 64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O000000o(Message message) {
        if (message.what == 4099) {
            fte.O00000Oo("BleMeshLoginConnector notify timeout");
            O000000o(-7);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(byte[] bArr, int i) {
        if (i == 3) {
            if (this.O00000Oo) {
                O000000o(-2);
                return;
            }
            fte.O00000Oo("BleMeshLoginConnector Process Step 5 ...");
            this.O0000OOo.removeMessages(4099);
            byte[] O000000o2 = O000000o(bArr, this.O0000o0o);
            if (this.O00000Oo) {
                O000000o(-2);
                return;
            }
            fte.O00000Oo("BleMeshLoginConnector Process Step 6 ...");
            if (O000000o2 != null) {
                this.O0000OOo.removeMessages(4099);
                this.O0000OOo.sendEmptyMessageDelayed(4099, 15000);
                if (!O000000o(O000000o2, 5, new BleMeshLoginConnector$5(this))) {
                    O000000o(-28);
                    return;
                }
                return;
            }
            fte.O00000Oo("BleMeshLoginConnector Process Step 6 encryptData is null ... ");
            O000000o(-21);
        }
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleMeshLoginConnector Process Step 1 ...");
        ffr.O00000o(O00000o0(), "".getBytes());
        O00000Oo(new BleNotifyResponse() {
            /* class _m_j.fha.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleMeshLoginConnector Step 1 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fha.this.O0000Ooo();
                } else {
                    fha.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000Ooo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleMeshLoginConnector Process Step 2 ...");
        O000000o(new BleNotifyResponse() {
            /* class _m_j.fha.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleMeshLoginConnector Step 2 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fha.this.O0000o00();
                } else {
                    fha.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000o00() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleMeshLoginConnector Process Step 3 ...");
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, O0000Oo, new BleWriteResponse() {
            /* class _m_j.fha.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleMeshLoginConnector Step 3 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fha.this.O0000o0();
                } else {
                    fha.this.O000000o(-28);
                }
            }
        });
    }

    public final void O0000o0() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleMeshLoginConnector Process Step 4 ...");
        this.O0000o00 = fir.O000000o();
        if (!O000000o(fir.O000000o(this.O0000o00.getPublic()), 3, new BleMeshLoginConnector$4(this))) {
            O000000o(-28);
        }
    }
}
