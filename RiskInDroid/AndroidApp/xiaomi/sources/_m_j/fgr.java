package _m_j;

import _m_j.fhe;
import android.os.Message;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboStandardAuthConnector$5;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboStandardAuthConnector$6;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.util.UUID;
import javax.crypto.SecretKey;

public final class fgr extends fis {
    private static final byte[] O0000Ooo = {-94, 0, 0, 0};
    private static final byte[] O0000o = {-31, 0, 0, 0};
    private static final byte[] O0000o0 = {18, 0, 0, 0};
    private static final byte[] O0000o00 = {17, 0, 0, 0};
    private static final byte[] O0000o0O = {19, 0, 0, 0};
    private static final byte[] O0000o0o = {20, 0, 0, 0};
    public String O0000Oo0 = "";
    private byte[] O0000oO;
    private int O0000oO0;
    private BleComboWifiConfig O0000oOO;
    private KeyPair O0000oOo;
    private SecretKey O0000oo;
    private PublicKey O0000oo0;
    private byte[] O0000ooO;
    private byte[] O0000ooo;
    private byte[] O000O00o;
    private boolean O000O0OO = false;
    private fhe.O000000o O000O0Oo = new fhe.O000000o();
    private byte[] O00oOooO;
    private byte[] O00oOooo;

    public final byte[] O0000Oo0() {
        return null;
    }

    public fgr(fgp fgp, BleComboWifiConfig bleComboWifiConfig) {
        super(fgp);
        this.O0000oOO = bleComboWifiConfig;
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (!uuid.equals(glb.f17954O000000o) || !uuid2.equals(glb.O0000OOo)) {
            if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O0000o)) {
                super.O000000o(uuid, uuid2, bArr);
            }
        } else if (this.O00000Oo) {
            O000000o(-2);
        } else {
            fte.O00000Oo("BleComboStandardAuthConnector receiveDeviceResult ..., value = " + got.O00000o0(bArr));
            if (got.O00000Oo(bArr, O0000o00)) {
                this.O0000OOo.removeMessages(4102);
                O000000o(0);
            } else if (got.O00000Oo(bArr, O0000o0)) {
                this.O0000OOo.removeMessages(4102);
                O000000o(-51);
            } else if (got.O00000Oo(bArr, O0000o)) {
                this.O0000OOo.removeMessages(4102);
                O000000o(-17);
            }
        }
    }

    public final void O000000o(Message message) {
        if (message.what == 4102) {
            fte.O00000Oo("BleComboStandardAuthConnector notify timeout");
            O000000o(-55);
        }
    }

    /* access modifiers changed from: protected */
    public final String O0000o0() {
        if (got.O00000o(this.O0000oO)) {
            return "";
        }
        return new String(this.O0000oO);
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, bArr2);
            return O000000o2.O000000o("mible-setup-info".getBytes(), 64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O000000o(byte[] bArr, int i) {
        byte[] bArr2;
        byte[] bArr3 = bArr;
        int i2 = i;
        if (this.O00000Oo) {
            O000000o(-2);
        } else if (i2 == 0) {
            fte.O00000Oo("BleComboStandardAuthConnector recvDeviceInfo ...");
            if (bArr3.length >= 4) {
                this.O0000oO0 = bArr3[0] + (bArr3[1] << 8);
                if (this.O0000oO0 > 1) {
                    O000000o(-37);
                    return;
                }
                if (bArr3.length > 4) {
                    byte[] copyOfRange = Arrays.copyOfRange(bArr3, 4, bArr3.length);
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < copyOfRange.length && copyOfRange[i3] != 0) {
                        i4 = i3;
                        i3++;
                    }
                    this.O0000oO = Arrays.copyOfRange(copyOfRange, 0, i4 + 1);
                }
                fte.O00000Oo("BleComboStandardAuthConnector device id = " + O0000o0());
                if (bArr3[2] + (bArr3[3] << 8) > 0) {
                    this.O000O0OO = true;
                    O000000o(-37);
                    return;
                }
                this.O000O0OO = false;
                if (this.O00000Oo) {
                    O000000o(-2);
                    return;
                }
                fte.O00000Oo("BleComboStandardAuthConnector sendRegStart ...");
                glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, new byte[]{21, 0, 0, 0}, new BleWriteResponse() {
                    /* class _m_j.fgr.AnonymousClass4 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        fte.O00000Oo("BleComboStandardAuthConnector sendRegStart onResponse: " + gmc.O000000o(i));
                        if (i == 0) {
                            fgr.this.O0000o00();
                        } else {
                            fgr.this.O000000o(-28);
                        }
                    }
                });
                return;
            }
            fte.O00000Oo("BleComboStandardAuthConnector recvDeviceInfo data format error");
            O000000o(-47);
        } else if (i2 == 3) {
            fte.O00000Oo("BleComboStandardAuthConnector recvDevicePubKey ...");
            this.O0000OOo.removeMessages(4102);
            byte[] bArr4 = new byte[65];
            bArr4[0] = 4;
            System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
            try {
                this.O0000oo0 = fio.O000000o(bArr4, ((ECPublicKey) this.O0000oOo.getPublic()).getParams());
            } catch (Exception e) {
                e.printStackTrace();
            }
            fte.O00000Oo("BleComboStandardAuthConnector verifyDeviceParams ..., mNeedRealOOB = " + this.O000O0OO);
            PublicKey publicKey = this.O0000oo0;
            if (publicKey == null) {
                fte.O00000Oo("BleComboStandardAuthConnector mDevicePubKey is null ...");
                O000000o(-51);
                return;
            }
            this.O0000oo = fir.O000000o(publicKey, this.O0000oOo.getPrivate());
            if (this.O0000oo == null) {
                fte.O00000Oo("BleComboStandardAuthConnector eShareKey is null ...");
                O000000o(-51);
            } else if (this.O000O0OO) {
                O000000o(-37);
            } else {
                this.O0000ooO = new byte[16];
                fte.O00000Oo("BleComboStandardAuthConnector startSendWifiConfigAfterAuthSuccess");
                byte[] O000000o2 = O000000o(this.O0000oo.getEncoded(), this.O0000ooO);
                this.O0000ooo = new byte[16];
                System.arraycopy(O000000o2, 0, this.O0000ooo, 0, 16);
                this.O00oOooO = new byte[16];
                System.arraycopy(O000000o2, 16, this.O00oOooO, 0, 16);
                this.O00oOooo = new byte[4];
                System.arraycopy(O000000o2, 32, this.O00oOooo, 0, 4);
                this.O000O00o = new byte[4];
                System.arraycopy(O000000o2, 36, this.O000O00o, 0, 4);
                byte[] O000000o3 = this.O0000oOO.O000000o();
                byte[] bArr5 = this.O00oOooO;
                byte[] bArr6 = this.O000O00o;
                this.O000O0Oo.O00000Oo();
                short s = this.O000O0Oo.f16346O000000o;
                byte[] O00000o0 = this.O000O0Oo.O00000o0();
                byte[] bArr7 = new byte[12];
                System.arraycopy(bArr6, 0, bArr7, 0, 4);
                System.arraycopy(O00000o0, 0, bArr7, 8, 4);
                byte[] O000000o4 = fir.O000000o(bArr5, bArr7, O000000o3);
                if (O000000o4 == null) {
                    bArr2 = null;
                } else {
                    ByteBuffer order = ByteBuffer.allocate(O000000o4.length + 2).order(ByteOrder.LITTLE_ENDIAN);
                    order.putShort((short) (65535 & s));
                    order.put(O000000o4);
                    bArr2 = order.array();
                }
                if (bArr2 == null) {
                    fte.O00000Oo("BleComboStandardAuthConnector encrypt wifi config failed");
                    O000000o(-51);
                    return;
                }
                fte.O00000Oo("BleComboStandardAuthConnector sendWifiConfig");
                if (!O000000o(bArr2, 15, new BleComboStandardAuthConnector$6(this))) {
                    O000000o(-28);
                }
            }
        }
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleComboStandardAuthConnector Process Step 1 ...");
        ffr.O00000o(O00000o0(), "".getBytes());
        this.O000O0Oo.O000000o();
        O000000o(O00000o0(), new BleResponse<String>() {
            /* class _m_j.fgr.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str = (String) obj;
                if (i == 0) {
                    fgr.this.O0000Oo0 = str;
                    fte.O00000Oo("BleComboStandardAuthConnector get device version: ".concat(String.valueOf(str)));
                } else {
                    fte.O00000Oo("BleComboStandardAuthConnector get device version failed");
                }
                ffr.O0000o0o(fgr.this.O00000o0(), fgr.this.O0000Oo0);
                fgr.this.O00000Oo(new BleNotifyResponse() {
                    /* class _m_j.fgr.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        fte.O00000Oo("BleComboStandardAuthConnector Step 1 onResponse: " + gmc.O000000o(i));
                        if (i == 0) {
                            fgr.this.O0000OoO();
                        } else {
                            fgr.this.O000000o(-27);
                        }
                    }
                });
            }
        });
    }

    public final void O0000OoO() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleComboStandardAuthConnector Process Step 1 plus ...");
        O000000o(new BleNotifyResponse() {
            /* class _m_j.fgr.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleComboStandardAuthConnector Step 1 plus onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fgr.this.O0000Ooo();
                } else {
                    fgr.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000Ooo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleComboStandardAuthConnector requestDeviceInfo ...");
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, O0000Ooo, new BleWriteResponse() {
            /* class _m_j.fgr.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleComboStandardAuthConnector requestDeviceInfo onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fgr.this.O0000OOo.removeMessages(4102);
                    fgr.this.O0000OOo.sendEmptyMessageDelayed(4102, 15000);
                    return;
                }
                fgr.this.O000000o(-28);
            }
        });
    }

    public final void O0000o00() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleComboStandardAuthConnector sendAppPublicKey ...");
        this.O0000oOo = fir.O000000o();
        if (!O000000o(fir.O000000o(this.O0000oOo.getPublic()), 3, new BleComboStandardAuthConnector$5(this))) {
            O000000o(-28);
        }
    }
}
