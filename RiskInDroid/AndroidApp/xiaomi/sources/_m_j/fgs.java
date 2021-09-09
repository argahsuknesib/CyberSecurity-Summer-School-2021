package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;

public final class fgs {

    /* renamed from: O000000o  reason: collision with root package name */
    public byte[] f16303O000000o;
    public byte[] O00000Oo;
    boolean O00000o;
    O000000o O00000o0;
    public int O00000oO = 1;
    final BleReadResponse O00000oo = new BleReadResponse() {
        /* class _m_j.fgs.AnonymousClass1 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            byte[] bArr = (byte[]) obj;
            if (i != 0 || got.O00000o(bArr)) {
                if (got.O00000o(bArr)) {
                    fec.O00000o().O000000o(8, "msg", "sn is empty");
                }
                fec.O00000o().O000000o(8, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(8, 2);
            } else {
                gnk.O00000oO("local did(encrypted): " + got.O00000o0(bArr));
                gnk.O00000oO("local token is " + fgs.O000000o(fgs.this.O00000o0()));
                byte[] O000000o2 = BLECipher.O000000o(fgs.this.O00000o0(), bArr);
                gnk.O00000oO("local did(decrypted): " + got.O00000o0(O000000o2));
                if (!got.O00000oO(O000000o2)) {
                    fgs.this.f16303O000000o = got.O0000O0o(O000000o2);
                    if (got.O000000o(fgs.this.f16303O000000o).startsWith("blt.")) {
                        ffr.O00000oO(fgs.this.O000000o(), fgs.this.O00000o());
                    } else {
                        fgs.this.f16303O000000o = got.f18097O000000o;
                    }
                }
                fec.O00000o().O00000Oo(8);
            }
            fec.O00000o().O000000o(9);
            fgs fgs = fgs.this;
            BleReadResponse bleReadResponse = fgs.O0000O0o;
            if (fgs.O00000o) {
                fgs.O000000o(-2);
            } else {
                glw.O000000o().read(fgs.O000000o(), glb.f17954O000000o, glb.O0000Ooo, bleReadResponse);
            }
        }
    };
    public final BleReadResponse O0000O0o = new BleReadResponse() {
        /* class _m_j.fgs.AnonymousClass2 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            byte[] bArr = (byte[]) obj;
            if (i != 0 || got.O00000o(bArr)) {
                if (got.O00000o(bArr)) {
                    fec.O00000o().O000000o(9, "msg", "beacon key is empty");
                }
                fec.O00000o().O000000o(9, "error_code", String.valueOf(i));
            } else {
                fgs fgs = fgs.this;
                fgs.O00000Oo = BLECipher.O000000o(fgs.O00000o0(), bArr);
                fec.O00000o().O00000Oo(9);
            }
            fgs fgs2 = fgs.this;
            fgs2.O000000o(fgs2.O0000OOo);
        }
    };
    public final BleReadResponse O0000OOo = new BleReadResponse() {
        /* class _m_j.fgs.AnonymousClass3 */

        public final /* synthetic */ void onResponse(final int i, Object obj) {
            byte[] bArr = (byte[]) obj;
            if (i != 0) {
                fgs.this.O000000o(i, new BleWriteResponse() {
                    /* class _m_j.fgs.AnonymousClass3.AnonymousClass1 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        fgs.this.O000000o(i);
                    }
                });
            } else if (got.O00000o(fgs.this.f16303O000000o) && !got.O00000o(bArr)) {
                fgs.this.f16303O000000o = bArr;
                byte[] O00000oo = got.O00000oo(bArr);
                gnk.O00000oO("write SN to Device: " + got.O00000o0(O00000oo));
                byte[] O000000o2 = BLECipher.O000000o(fgs.this.O00000o0(), O00000oo);
                fec.O00000o().O000000o(11);
                fgs fgs = fgs.this;
                BleWriteResponse bleWriteResponse = fgs.O0000Oo0;
                if (fgs.O00000o) {
                    fgs.O000000o(-2);
                } else {
                    glw.O000000o().write(fgs.O000000o(), glb.f17954O000000o, glb.O0000OoO, O000000o2, bleWriteResponse);
                }
                ffr.O00000oO(fgs.this.O000000o(), fgs.this.O00000o());
            } else if (got.O00000o(fgs.this.f16303O000000o) || !got.O000000o(fgs.this.f16303O000000o, bArr)) {
                throw new IllegalStateException("strange exception");
            } else {
                fgs fgs2 = fgs.this;
                fgs2.O000000o(fgs2.O0000Oo);
            }
        }
    };
    public final BleWriteResponse O0000Oo = new BleWriteResponse() {
        /* class _m_j.fgs.AnonymousClass5 */

        public final /* synthetic */ void onResponse(final int i, Object obj) {
            if (i == 0) {
                ffr.O00000o(fgs.this.O000000o(), fec.O00000o0().O000000o());
                ffr.O00000o(fgs.this.O000000o(), 2);
            } else {
                ffr.O00000o(fgs.this.O000000o(), 1);
            }
            fgs.this.O000000o(i, new BleWriteResponse() {
                /* class _m_j.fgs.AnonymousClass5.AnonymousClass1 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    fgs.this.O000000o(i);
                }
            });
        }
    };
    public final BleWriteResponse O0000Oo0 = new BleWriteResponse() {
        /* class _m_j.fgs.AnonymousClass4 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            if (i == 0) {
                fec.O00000o().O00000Oo(11);
                fgs fgs = fgs.this;
                fgs.O000000o(fgs.O0000Oo);
                return;
            }
            fec.O00000o().O000000o(11, "error_code", String.valueOf(i));
            fec.O00000o().O000000o(11, 2);
            fgs.this.O000000o(i);
        }
    };
    private fgp O0000OoO;

    public interface O000000o extends BleResponse<Void> {
    }

    public fgs(fgp fgp) {
        this.O0000OoO = fgp;
        if (fgp == null) {
            throw new NullPointerException("launcher should not be null");
        }
    }

    public final String O000000o() {
        return this.O0000OoO.O000000o();
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo() {
        return this.O0000OoO.O00000Oo();
    }

    public final byte[] O00000o0() {
        return this.O0000OoO.O00000o0();
    }

    static String O000000o(byte[] bArr) {
        if (got.O00000o(bArr)) {
            return "";
        }
        return got.O00000o0(bArr);
    }

    public final String O00000o() {
        byte[] bArr = this.f16303O000000o;
        if (got.O00000o(bArr)) {
            return "";
        }
        return new String(bArr);
    }

    public final void O000000o(int i) {
        this.O00000o0.onResponse(i, null);
    }

    public final void O000000o(int i, BleWriteResponse bleWriteResponse) {
        if (this.O00000o) {
            O000000o(-2);
            return;
        }
        if (feb.O000000o(O00000Oo()) == 2) {
            i = 0;
        }
        byte[] O000000o2 = got.O000000o(i == 0 ? -1402883792 : -381567184);
        fte.O00000Oo(String.format("writeBindResultToDevice %d: %s", Integer.valueOf(i), got.O00000o0(O000000o2)));
        glw.O000000o().write(O000000o(), glb.f17954O000000o, glb.O0000OOo, BLECipher.O000000o(O00000o0(), O000000o2), bleWriteResponse);
    }

    public final void O000000o(final BleReadResponse bleReadResponse) {
        if (this.O00000o) {
            O000000o(-2);
            return;
        }
        String O000000o2 = fec.O00000o0().O000000o(O00000Oo());
        fec.O00000o().O000000o(10);
        fgo.O000000o(O00000o(), O000000o(), O000000o2, O000000o(O00000o0()), new feo<String, fes>() {
            /* class _m_j.fgs.AnonymousClass6 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                fte.O00000Oo(">>> onSuccess ".concat(String.valueOf(str)));
                if (!TextUtils.isEmpty(str)) {
                    fec.O00000o().O00000Oo(10);
                    bleReadResponse.onResponse(0, str.getBytes());
                } else if (fgs.this.O00000oO > 0) {
                    fgs.this.O00000oO--;
                    fec.O00000o().O000000o(10, "msg", "try again");
                    fec.O00000o().O000000o(10, 11);
                    fgs.this.O000000o(bleReadResponse);
                } else {
                    fec.O00000o().O000000o(10, "msg", "did is empty");
                    fec.O00000o().O000000o(10, 11);
                    fgs.this.O00000oO = 1;
                    bleReadResponse.onResponse(-29, null);
                }
            }

            public final void O000000o(fes fes) {
                fte.O00000Oo(">>> onFailure ".concat(String.valueOf(fes)));
                if (fgs.this.O00000oO > 0) {
                    fgs.this.O00000oO--;
                    fec.O00000o().O000000o(10, "msg", "try again");
                    fec.O00000o().O000000o(10, 11);
                    fgs.this.O000000o(bleReadResponse);
                    return;
                }
                if (fes != null) {
                    fec.O00000o().O000000o(10, "msg", fes.toString());
                }
                fec.O00000o().O000000o(10, 11);
                fgs.this.O00000oO = 1;
                bleReadResponse.onResponse(-29, null);
            }
        });
    }

    public final void O000000o(final BleWriteResponse bleWriteResponse) {
        if (this.O00000o) {
            O000000o(-2);
            return;
        }
        String O0000OoO2 = ffr.O0000OoO(O000000o());
        fec.O00000o().O000000o(12);
        fgo.O00000Oo(O00000o(), O000000o(this.O00000Oo), O000000o(O00000o0()), O0000OoO2, new feo<Boolean, fes>() {
            /* class _m_j.fgs.AnonymousClass7 */

            public final /* synthetic */ void O000000o(Object obj) {
                Boolean bool = (Boolean) obj;
                fte.O00000Oo("bindSNToServer return ".concat(String.valueOf(bool)));
                if (bool.booleanValue()) {
                    fec.O00000o().O00000Oo(12);
                } else {
                    fec.O00000o().O000000o(12, 11);
                }
                bleWriteResponse.onResponse(bool.booleanValue() ? (char) 0 : 65506, null);
            }

            public final void O000000o(fes fes) {
                if (fes != null) {
                    fec.O00000o().O000000o(12, "msg", fes.toString());
                }
                fec.O00000o().O000000o(12, 11);
                fte.O00000Oo("bindSNToServer return failed: ".concat(String.valueOf(fes)));
                if (fes.f16189O000000o == -1) {
                    String str = fes.O00000Oo;
                    if (TextUtils.isEmpty(str) || str.contains("Unable to resolve")) {
                        bleWriteResponse.onResponse(-30, null);
                    } else {
                        bleWriteResponse.onResponse(-14, null);
                    }
                } else {
                    bleWriteResponse.onResponse(-30, null);
                }
            }
        });
    }
}
