package _m_j;

import _m_j.fap;
import android.os.Bundle;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattService;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;

public abstract class fgu extends fgm {
    protected boolean O0000Oo0 = true;

    protected fgu(fgp fgp) {
        super(fgp);
    }

    public final boolean O0000Ooo() {
        return this.O0000Oo0;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(final BleNotifyResponse bleNotifyResponse) {
        fec.O00000o().O000000o(23);
        fec.O00000o().O000000o(23, "char", glb.O00000o0.toString());
        glw.O000000o().notify(O00000o0(), glb.f17954O000000o, glb.O00000o0, new BleNotifyResponse() {
            /* class _m_j.fgu.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    fec.O00000o().O00000Oo(23);
                } else {
                    fec.O00000o().O000000o(23, "error_code", String.valueOf(i));
                    fec.O00000o().O000000o(23, 3);
                }
                bleNotifyResponse.onResponse(i, null);
            }
        });
    }

    public final void O00000Oo(Bundle bundle) {
        BleGattService O000000o2;
        boolean z = false;
        if (bundle != null && (O000000o2 = ((BleGattProfile) bundle.getParcelable("key_gatt_profile")).O000000o(glb.f17954O000000o)) != null && O000000o2.O000000o(glb.O0000OoO) && O000000o2.O000000o(glb.O0000Ooo)) {
            z = true;
        }
        this.O0000Oo0 = z;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(final byte[] bArr, final int i) {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("readFirmwareVersionFromDevice: ");
        fec.O00000o().O000000o(40);
        glw.O000000o().read(O00000o0(), glb.f17954O000000o, glb.O00000oO, new BleReadResponse() {
            /* class _m_j.fgu.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                byte[] bArr = (byte[]) obj;
                if (i != 0 || got.O00000o(bArr)) {
                    if (got.O00000o(bArr)) {
                        fec.O00000o().O000000o(40, "msg", "data is empty");
                    }
                    fec.O00000o().O000000o(40, "error_code", String.valueOf(i));
                    fec.O00000o().O000000o(40, 2);
                } else {
                    String str = new String(got.O0000OOo(BLECipher.O000000o(bArr, bArr)));
                    fte.O00000Oo("firmWare version ".concat(str));
                    ffr.O0000o0o(fgu.this.O00000o0(), str);
                    fgu.this.O00000oO.putString("key_version", str);
                    fap.O000000o.f16027O000000o.O000000o(fgu.this.O00000o0()).O00000Oo(str);
                    fec.O00000o().O00000Oo(40);
                }
                fgu.this.O000000o(i);
            }
        });
    }
}
