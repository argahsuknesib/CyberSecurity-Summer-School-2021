package _m_j;

import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthRegisterConnector$11;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthRegisterConnector$13;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthRegisterConnector$14;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthRegisterConnector$8;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.util.UUID;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class fiw extends fis {
    private static final byte[] O0000o = {-94, 0, 0, 0};
    private static final byte[] O0000oO = {18, 0, 0, 0};
    private static final byte[] O0000oO0 = {17, 0, 0, 0};
    private static final byte[] O0000oOO = {19, 0, 0, 0};
    private static final byte[] O0000oOo = {20, 0, 0, 0};
    private static final byte[] O0000oo0 = {-31, 0, 0, 0};
    public byte[] O0000Oo0;
    public SecretKey O0000Ooo;
    public byte[] O0000o0;
    public byte[] O0000o00;
    public final BleWriteResponse O0000o0O = new BleWriteResponse() {
        /* class _m_j.fiw.AnonymousClass4 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            if (i == 0) {
                fiw fiw = fiw.this;
                fiw.O000000o(fiw.O0000o0o);
                return;
            }
            fiw.this.O000000o(i);
        }
    };
    public final BleWriteResponse O0000o0o = new BleWriteResponse() {
        /* class _m_j.fiw.AnonymousClass5 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
         arg types: [int, _m_j.fiw$5$1]
         candidates:
          _m_j.fiw.O000000o(byte[], byte[]):byte[]
          _m_j.fiw.O000000o(byte[], int):void
          _m_j.fiw.O000000o(byte[], com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
          _m_j.fis.O000000o(byte[], int):void
          _m_j.fgm.O000000o(int, boolean):void
          _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
          _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
          _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
         arg types: [int, _m_j.fiw$5$2]
         candidates:
          _m_j.fiw.O000000o(byte[], byte[]):byte[]
          _m_j.fiw.O000000o(byte[], int):void
          _m_j.fiw.O000000o(byte[], com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
          _m_j.fis.O000000o(byte[], int):void
          _m_j.fgm.O000000o(int, boolean):void
          _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
          _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
          _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void */
        public final /* synthetic */ void onResponse(final int i, Object obj) {
            if (i == 0) {
                ffr.O00000o(fiw.this.O00000o0(), 2);
                fiw.this.O000000o(true, (BleWriteResponse) new BleWriteResponse() {
                    /* class _m_j.fiw.AnonymousClass5.AnonymousClass1 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        fiw.this.O0000OOo.removeMessages(4102);
                        fiw.this.O0000OOo.sendEmptyMessageDelayed(4102, 15000);
                    }
                });
                return;
            }
            fiw.this.O000000o(false, (BleWriteResponse) new BleWriteResponse() {
                /* class _m_j.fiw.AnonymousClass5.AnonymousClass2 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    fiw.this.O000000o(i);
                }
            });
        }
    };
    private int O0000oo;
    private int O0000ooO;
    private int O0000ooo;
    private PublicKey O000O00o;
    private byte[] O000O0OO;
    private byte[] O000O0Oo;
    private byte[] O000O0o;
    private byte[] O000O0o0;
    private byte[] O000O0oO;
    private final BleReadResponse O000O0oo = new BleReadResponse() {
        /* class _m_j.fiw.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
         arg types: [int, _m_j.fiw$1$1]
         candidates:
          _m_j.fiw.O000000o(byte[], byte[]):byte[]
          _m_j.fiw.O000000o(byte[], int):void
          _m_j.fiw.O000000o(byte[], com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
          _m_j.fis.O000000o(byte[], int):void
          _m_j.fgm.O000000o(int, boolean):void
          _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
          _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
          _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void */
        public final /* synthetic */ void onResponse(final int i, Object obj) {
            byte[] bArr = (byte[]) obj;
            if (i != 0) {
                fiw.this.O000000o(false, (BleWriteResponse) new BleWriteResponse() {
                    /* class _m_j.fiw.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        fiw.this.O000000o(i);
                    }
                });
            } else if (!got.O00000o(bArr)) {
                if (!got.O00000o(fiw.this.O0000Oo0) && !got.O000000o(fiw.this.O0000Oo0, bArr)) {
                    fte.O00000Oo("BleStandardAuthRegisterConnector device did don't match server did, device did = " + got.O00000o0(fiw.this.O0000Oo0) + ", server did = " + got.O00000o0(bArr));
                }
                fiw.this.O0000Oo0 = bArr;
                byte[] O00000oo = got.O00000oo(bArr);
                fte.O00000Oo("BleStandardAuthRegisterConnector write Did to Device: " + got.O00000o0(O00000oo));
                fiw fiw = fiw.this;
                fiw.O000000o(O00000oo, fiw.O0000o0O);
            } else {
                throw new IllegalStateException("strange exception");
            }
        }
    };
    private byte[] O00oOoOo;
    private String O00oOooO;
    private KeyPair O00oOooo;

    private static int O000000o(int i, int i2, int i3) {
        return (i >> i2) & ((1 << ((i3 - i2) + 1)) - 1);
    }

    public fiw(fgp fgp, String str) {
        super(fgp);
        this.O00oOooO = str;
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (!uuid.equals(glb.f17954O000000o) || !uuid2.equals(glb.O0000OOo)) {
            if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O0000o)) {
                super.O000000o(uuid, uuid2, bArr);
            }
        } else if (this.O00000Oo) {
            O000000o(-2);
        } else {
            fte.O00000Oo("BleStandardAuthRegisterConnector receiveDeviceResult ..., value = " + got.O00000o0(bArr));
            if (got.O00000Oo(bArr, O0000oO0)) {
                this.O0000OOo.removeMessages(4102);
                fec.O00000o().O000000o(14, 0);
                O000000o(0);
            } else if (got.O00000Oo(bArr, O0000oO)) {
                fec.O00000o().O000000o(14, "msg", "reg fail");
                fec.O00000o().O000000o(14, 13);
                this.O0000OOo.removeMessages(4102);
                O000000o(-51);
            } else if (got.O00000Oo(bArr, O0000oo0)) {
                fec.O00000o().O000000o(14, "msg", "registered error");
                fec.O00000o().O000000o(14, 13);
                this.O0000OOo.removeMessages(4102);
                O000000o(-17);
            }
        }
    }

    public final void O000000o(Message message) {
        if (message.what == 4102) {
            fte.O00000Oo("BleStandardAuthRegisterConnector notify timeout");
            O000000o(-55);
            fec.O00000o().O000000o();
        }
    }

    public final byte[] O0000Oo0() {
        return this.O00oOoOo;
    }

    /* access modifiers changed from: protected */
    public final String O0000o0O() {
        if (got.O00000o(this.O0000Oo0)) {
            return "";
        }
        return new String(this.O0000Oo0);
    }

    private String O0000o0o() {
        if (got.O00000o(this.O00oOoOo)) {
            return "";
        }
        return got.O00000o0(this.O00oOoOo);
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

    /* access modifiers changed from: protected */
    public final void O000000o(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        int i2 = i;
        if (this.O00000Oo) {
            O000000o(-2);
        } else if (i2 == 0) {
            fte.O00000Oo("BleStandardAuthRegisterConnector recvDeviceInfo ...");
            if (bArr2.length >= 4) {
                this.O0000oo = bArr2[0] + (bArr2[1] << 8);
                if (this.O0000oo > 1) {
                    fec.O00000o().O000000o(15, "msg", "version not support");
                    fec.O00000o().O000000o(38, 104);
                    O000000o(-37);
                    return;
                }
                fec.O00000o().O00000Oo(38);
                byte[] bArr3 = {bArr2[2], bArr2[3]};
                this.O0000ooO = O000000o(bArr3[0], 0, 3);
                this.O0000ooo = O000000o(bArr3[0], 4, 7);
                if (bArr2.length > 4) {
                    this.O0000Oo0 = got.O0000O0o(Arrays.copyOfRange(bArr2, 4, bArr2.length));
                }
                byte[] bArr4 = {bArr2[2], bArr2[3]};
                if (this.O00000Oo) {
                    O000000o(-2);
                    return;
                }
                byte[] bArr5 = new byte[4];
                bArr5[0] = 21;
                bArr5[1] = bArr4[0];
                bArr5[2] = bArr4[1];
                fec.O00000o().O000000o(4);
                fte.O00000Oo("BleStandardAuthRegisterConnector sendRegStart ...");
                fec.O00000o().O000000o(4, "data", got.O00000o0(bArr5));
                glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, bArr5, new BleWriteResponse() {
                    /* class _m_j.fiw.AnonymousClass9 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        fte.O00000Oo("BleStandardAuthRegisterConnector sendRegStart onResponse: " + gmc.O000000o(i));
                        if (i == 0) {
                            fec.O00000o().O00000Oo(4);
                            fiw.this.O0000o00();
                            return;
                        }
                        fec.O00000o().O000000o(4, "error_code", String.valueOf(i));
                        fec.O00000o().O00000Oo(4);
                        fiw.this.O000000o(-28);
                    }
                });
                return;
            }
            fec.O00000o().O000000o(15, "msg", "receive data wrong format");
            fec.O00000o().O000000o(38, 105);
            fte.O00000Oo("BleStandardAuthRegisterConnector recvDeviceInfo data format error");
            O000000o(-47);
        } else if (i2 == 3) {
            fte.O00000Oo("BleStandardAuthRegisterConnector recvDevicePubKey ...");
            this.O0000OOo.removeMessages(4102);
            fec.O00000o().O00000Oo(17);
            this.O000O0OO = bArr2;
            byte[] bArr6 = new byte[65];
            bArr6[0] = 4;
            System.arraycopy(bArr2, 0, bArr6, 1, bArr2.length);
            try {
                this.O000O00o = fio.O000000o(bArr6, ((ECPublicKey) this.O00oOooo.getPublic()).getParams());
            } catch (Exception e) {
                e.printStackTrace();
            }
            fte.O00000Oo("BleStandardAuthRegisterConnector verifyDeviceParams ...");
            fec.O00000o().O000000o(22);
            PublicKey publicKey = this.O000O00o;
            if (publicKey == null) {
                fte.O00000Oo("BleStandardAuthRegisterConnector mDevicePubKey is null ...");
                fec.O00000o().O000000o(22, "msg", " dev pub key is empty");
                fec.O00000o().O000000o(22, 10);
                O000000o(-51);
                return;
            }
            this.O0000Ooo = fir.O000000o(publicKey, this.O00oOooo.getPrivate());
            if (this.O0000Ooo == null) {
                fte.O00000Oo("BleStandardAuthRegisterConnector eShareKey is null ...");
                fec.O00000o().O000000o(22, "msg", " eShare key is empty");
                fec.O00000o().O000000o(22, 10);
                O000000o(-51);
            } else if (this.O0000ooO != 0) {
                fec.O00000o().O000000o(22, "msg", "not support input capability");
                fec.O00000o().O000000o(22, 10);
                fte.O00000Oo("BleStandardAuthRegisterConnectordon't support this input capability: " + this.O0000ooO);
                O000000o(-37);
            } else {
                int i3 = this.O0000ooo;
                if (i3 == 0) {
                    this.O0000o00 = new byte[16];
                    O0000o0();
                } else if (i3 != 8) {
                    fec.O00000o().O000000o(22, "msg", "not support output capability");
                    fec.O00000o().O000000o(22, 10);
                    fte.O00000Oo("BleStandardAuthRegisterConnector don't support this output capability: " + this.O0000ooo);
                    O000000o(-37);
                } else if (TextUtils.isEmpty(this.O00oOooO)) {
                    fec.O00000o().O000000o(22, "msg", "QrCodeOOB is empty");
                    fec.O00000o().O000000o(22, 10);
                    fte.O00000Oo("BleStandardAuthRegisterConnector  get qrcode oob failed");
                    O000000o(-50);
                } else {
                    fec.O00000o().O00000Oo(22);
                    fec.O00000o().O000000o(21);
                    this.O0000o00 = new byte[16];
                    byte[] O000000o2 = got.O000000o(this.O00oOooO);
                    System.arraycopy(O000000o2, 0, this.O0000o00, 0, Math.min(O000000o2.length, 16));
                    byte[] bArr7 = new byte[16];
                    new SecureRandom().nextBytes(bArr7);
                    this.O000O0Oo = bArr7;
                    byte[] bArr8 = new byte[32];
                    System.arraycopy(this.O000O0Oo, 0, bArr8, 0, 16);
                    System.arraycopy(this.O0000o00, 0, bArr8, 16, 16);
                    this.O000O0oO = fir.O000000o(this.O0000Ooo.getEncoded(), bArr8);
                    this.O0000OOo.removeMessages(4102);
                    this.O0000OOo.sendEmptyMessageDelayed(4102, 15000);
                }
            }
        } else if (i2 == 12) {
            fte.O00000Oo("BleStandardAuthRegisterConnector recvDevConfirmation ...");
            this.O0000o0 = bArr2;
            this.O0000OOo.removeMessages(4102);
            if (got.O00000o(this.O000O0oO)) {
                fec.O00000o().O000000o(21, "msg", "app confirm is empty");
                fec.O00000o().O000000o(21, 105);
                O000000o(-48);
                return;
            }
            fec.O00000o().O00000Oo(21);
            fte.O00000Oo("BleStandardAuthRegisterConnector sendAppConfirmation ...");
            if (this.O00000Oo) {
                O000000o(-2);
                return;
            }
            fec.O00000o().O000000o(18);
            if (got.O00000o(this.O000O0oO)) {
                fec.O00000o().O000000o(18, "msg", "app confirm is empty");
                fec.O00000o().O00000Oo(18);
                fte.O00000Oo("BleStandardAuthRegisterConnector mAppConfirmation is null ...");
                O000000o(-51);
            } else if (!O000000o(this.O000O0oO, 10, new BleStandardAuthRegisterConnector$13(this))) {
                fec.O00000o().O000000o(18, 2);
                O000000o(-28);
            }
        } else if (i2 == 13) {
            fte.O00000Oo("BleStandardAuthRegisterConnector recvDevRandom ...");
            this.O0000OOo.removeMessages(4102);
            fec.O00000o().O00000Oo(19);
            fec.O00000o().O000000o(20);
            if (!O000000o(this.O000O0Oo, 11, new BleStandardAuthRegisterConnector$14(this, bArr2))) {
                fec.O00000o().O000000o(20, 2);
                O000000o(-28);
            }
        }
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleStandardAuthRegisterConnector Process Step 1 ...");
        ffr.O00000o(O00000o0(), "".getBytes());
        O00000Oo(new BleNotifyResponse() {
            /* class _m_j.fiw.AnonymousClass6 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleStandardAuthRegisterConnector Step 1 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fiw.this.O0000OoO();
                } else {
                    fiw.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000OoO() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleStandardAuthRegisterConnector Process Step 1 plus ...");
        O000000o(new BleNotifyResponse() {
            /* class _m_j.fiw.AnonymousClass7 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleStandardAuthRegisterConnector Step 1 plus onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fiw.this.O0000Ooo();
                } else {
                    fiw.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000Ooo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fec.O00000o().O000000o(15);
        fte.O00000Oo("BleStandardAuthRegisterConnector requestDeviceInfo ...");
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, O0000o, new BleWriteResponse() {
            /* class _m_j.fiw.AnonymousClass8 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleStandardAuthRegisterConnector requestDeviceInfo onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fec.O00000o().O00000Oo(15);
                    fec.O00000o().O000000o(38);
                    fiw.this.O0000OOo.removeMessages(4102);
                    fiw.this.O0000OOo.sendEmptyMessageDelayed(4102, 15000);
                    return;
                }
                fec.O00000o().O000000o(15, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(15, 2);
                fiw.this.O000000o(-28);
            }
        });
    }

    public final void O0000o00() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleStandardAuthRegisterConnector sendAppPublicKey ...");
        this.O00oOooo = fir.O000000o();
        fec.O00000o().O000000o(16);
        if (!O000000o(fir.O000000o(this.O00oOooo.getPublic()), 3, new BleStandardAuthRegisterConnector$8(this))) {
            fec.O00000o().O000000o(16, 2);
            O000000o(-28);
        }
    }

    public final void O0000o0() {
        fte.O00000Oo("BleStandardAuthRegisterConnector startBindAfterAuthSuccess");
        byte[] O000000o2 = O000000o(this.O0000Ooo.getEncoded(), this.O0000o00);
        this.O00oOoOo = new byte[12];
        System.arraycopy(O000000o2, 0, this.O00oOoOo, 0, 12);
        this.O000O0o0 = new byte[16];
        System.arraycopy(O000000o2, 12, this.O000O0o0, 0, 16);
        this.O000O0o = new byte[16];
        System.arraycopy(O000000o2, 28, this.O000O0o, 0, 16);
        O000000o(this.O000O0oo);
    }

    public final void O000000o(boolean z, final BleWriteResponse bleWriteResponse) {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        byte[] bArr = z ? O0000oOO : O0000oOo;
        fte.O00000Oo(String.format("BleStandardAuthRegisterConnector writeBindResultToDevice : %s", got.O00000o0(bArr)));
        fec.O00000o().O000000o(13);
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, bArr, new BleWriteResponse() {
            /* class _m_j.fiw.AnonymousClass10 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Void voidR = (Void) obj;
                if (i == 0) {
                    fec.O00000o().O00000Oo(13);
                    fec.O00000o().O000000o(14);
                } else {
                    fec.O00000o().O000000o(13, "error_code", String.valueOf(i));
                    fec.O00000o().O00000Oo(13);
                }
                BleWriteResponse bleWriteResponse = bleWriteResponse;
                if (bleWriteResponse != null) {
                    bleWriteResponse.onResponse(i, voidR);
                }
            }
        });
    }

    private void O000000o(final BleReadResponse bleReadResponse) {
        fte.O00000Oo("BleStandardAuthRegisterConnector applyDid");
        String O000000o2 = fec.O00000o0().O000000o(O00000o());
        fec.O00000o().O000000o(10);
        fgo.O000000o(O0000o0O(), this.f16262O000000o.O000000o(), O000000o2, O0000o0o(), new feo<String, fes>() {
            /* class _m_j.fiw.AnonymousClass2 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                fte.O00000Oo("BleStandardAuthRegisterConnector applyDid >>> onSuccess ".concat(String.valueOf(str)));
                if (!TextUtils.isEmpty(str)) {
                    fec.O00000o().O00000Oo(10);
                    bleReadResponse.onResponse(0, str.getBytes());
                    return;
                }
                fec.O00000o().O000000o(10, "msg", "result is empty");
                fec.O00000o().O000000o(10, 11);
                bleReadResponse.onResponse(-29, null);
            }

            public final void O000000o(fes fes) {
                if (fes != null) {
                    fec.O00000o().O000000o(10, "msg", fes.toString());
                }
                fec.O00000o().O000000o(10, 11);
                fte.O00000Oo("BleStandardAuthRegisterConnector applyDid >>> onFailure ".concat(String.valueOf(fes)));
                bleReadResponse.onResponse(-29, null);
            }
        });
    }

    public final void O000000o(byte[] bArr, BleWriteResponse bleWriteResponse) {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fec.O00000o().O000000o(11);
        byte[] bArr2 = null;
        byte[] bArr3 = {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
        try {
            bArr2 = fir.O000000o(new SecretKeySpec(this.O000O0o, "AES"), bArr3, bArr, "devID".getBytes()).O000000o();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bArr2 == null) {
            fec.O00000o().O000000o(11, "msg", "encrypt did is empty");
            fec.O00000o().O000000o(11, 2);
            fte.O00000Oo("BleStandardAuthRegisterConnector encrypt did failed");
            O000000o(-51);
            return;
        }
        fte.O00000Oo("BleStandardAuthRegisterConnector start writeDidToDevice");
        if (!O000000o(bArr2, 0, new BleStandardAuthRegisterConnector$11(this, bleWriteResponse))) {
            fec.O00000o().O000000o(11, 2);
            O000000o(-28);
        }
    }

    public final void O000000o(final BleWriteResponse bleWriteResponse) {
        String str;
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleStandardAuthRegisterConnector bindDidToServer start");
        String O0000OoO = ffr.O0000OoO(O00000o0());
        fec.O00000o().O000000o(12);
        String O0000o0O2 = O0000o0O();
        if (got.O00000o(this.O000O0o0)) {
            str = "";
        } else {
            str = got.O00000o0(this.O000O0o0);
        }
        fgo.O00000Oo(O0000o0O2, str, O0000o0o(), O0000OoO, new feo<Boolean, fes>() {
            /* class _m_j.fiw.AnonymousClass3 */

            public final /* synthetic */ void O000000o(Object obj) {
                Boolean bool = (Boolean) obj;
                if (bool == null || !bool.booleanValue()) {
                    fec.O00000o().O000000o(12, 11);
                } else {
                    fec.O00000o().O00000Oo(12);
                }
                fte.O00000Oo("BleStandardAuthRegisterConnector bindDidToServer return ".concat(String.valueOf(bool)));
                bleWriteResponse.onResponse(bool.booleanValue() ? (char) 0 : 65506, null);
            }

            public final void O000000o(fes fes) {
                if (fes != null) {
                    fec.O00000o().O000000o(12, "msg", fes.toString());
                }
                fec.O00000o().O000000o(12, 11);
                fte.O00000Oo("BleStandardAuthRegisterConnector bindDidToServer return failed: ".concat(String.valueOf(fes)));
                if (fes.f16189O000000o == -1) {
                    String str = fes.O00000Oo;
                    if (TextUtils.isEmpty(str) || str.contains("Unable to resolve")) {
                        bleWriteResponse.onResponse(-30, null);
                        return;
                    }
                    if (fiw.this.O00000oO != null) {
                        fiw.this.O00000oO.putString("key_device_did", fiw.this.O0000o0O());
                    }
                    bleWriteResponse.onResponse(-14, null);
                    return;
                }
                bleWriteResponse.onResponse(-30, null);
            }
        });
    }
}
