package _m_j;

import _m_j.fap;
import _m_j.fgs;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;

public abstract class fgv extends fgn {
    protected fgs O0000Oo0 = new fgs(this.O0000OOo);

    public fgv(String str, int i, BleConnectOptions bleConnectOptions) {
        super(str, i, bleConnectOptions);
    }

    public fgv(String str, int i, byte[] bArr, BleConnectOptions bleConnectOptions) {
        super(str, i, bArr, bleConnectOptions);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if ((r0 == 1 || r0 == 2) != false) goto L_0x0025;
     */
    public final boolean O00000o() {
        fgm O00000o0 = O00000o0();
        boolean z = true;
        if (O00000o0 instanceof fgu) {
            if (((fgu) O00000o0).O0000Ooo()) {
                int O000000o2 = feb.O000000o(this.f16274O000000o);
            }
            z = false;
        }
        fte.O00000Oo("ShouldBindToServer: ".concat(String.valueOf(z)));
        return z;
    }

    public final int O00000oO() {
        return feb.O000000o(this.O0000Oo0.O00000Oo());
    }

    public final void O000000o(fgs.O000000o o000000o) {
        fgs fgs = this.O0000Oo0;
        fgs.O00000o0 = o000000o;
        if (o000000o != null) {
            fec.O00000o().O000000o(8);
            BleReadResponse bleReadResponse = fgs.O00000oo;
            if (fgs.O00000o) {
                fgs.O000000o(-2);
            } else {
                glw.O000000o().read(fgs.O000000o(), glb.f17954O000000o, glb.O0000OoO, bleReadResponse);
            }
        } else {
            throw new NullPointerException("bind response should not be null");
        }
    }

    public final void O00000Oo() {
        fgs fgs = this.O0000Oo0;
        if (fgs != null) {
            fgs.O00000o = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final String str) {
        final String O00000oo = ffr.O00000oo(str);
        final byte[] O0000o0o = ffr.O0000o0o(str);
        if (!TextUtils.isEmpty(O00000oo) && !got.O00000o(O0000o0o)) {
            glw.O000000o().read(str, glb.f17954O000000o, glb.O00000oO, new BleReadResponse() {
                /* class _m_j.fgv.AnonymousClass1 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    byte[] bArr = (byte[]) obj;
                    if (i == 0 && !got.O00000o(bArr)) {
                        String str = new String(got.O0000OOo(BLECipher.O000000o(O0000o0o, bArr)));
                        if (!TextUtils.isEmpty(str)) {
                            fap.O000000o.f16027O000000o.O000000o(str).O00000Oo(str);
                            fgo.O00000Oo(O00000oo, str, new feo<Void, fes>() {
                                /* class _m_j.fgv.AnonymousClass1.AnonymousClass1 */

                                public final void O000000o(fes fes) {
                                }

                                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(int i) {
        int i2 = 0;
        int i3 = 1;
        boolean z = i == 0;
        int O000000o2 = feb.O000000o(this.O0000Oo0.O00000Oo());
        if (O000000o2 == 1) {
            String str = this.O00000Oo;
            if (z) {
                i2 = 2;
            }
            ffr.O00000o(str, i2);
        } else if (O000000o2 == 2) {
            String str2 = this.O00000Oo;
            if (z) {
                i3 = 2;
            }
            ffr.O00000o(str2, i3);
        }
    }
}
