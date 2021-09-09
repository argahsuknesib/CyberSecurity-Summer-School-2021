package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.SpecWriteChannelManager$2;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;

public final class fez extends fex {
    private O00000Oo O00000oo;

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final fez f16203O000000o = new fez((byte) 0);
    }

    /* synthetic */ fez(byte b) {
        this();
    }

    private fez() {
        super(glb.O0000oO0);
        this.O00000oo = null;
    }

    public static fez O00000o() {
        return O000000o.f16203O000000o;
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        if (this.O00000oo == null) {
            this.O00000oo = new O00000Oo();
            gnl.O000000o(this.O00000oo, new IntentFilter("action.miot.write.specv2.ble.data"));
        }
    }

    public final void O000000o(String str, byte[] bArr, byte[] bArr2) {
        try {
            IBleChannelWriter O0000O0o = O0000O0o(str);
            if (O0000O0o == null) {
                O000000o(str, bArr2, -1006);
            } else {
                O0000O0o.write(bArr, 0, new SpecWriteChannelManager$2(this, str, bArr2));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(String str, byte[] bArr, int i) {
        Intent intent = new Intent("action.miot.write.specv2.ble.data.resp");
        intent.putExtra("mac", str);
        intent.putExtra("value", bArr);
        intent.putExtra("code", i);
        glc.O0000O0o.sendBroadcast(intent);
    }

    class O00000Oo extends BroadcastReceiver {
        O00000Oo() {
        }

        public final void onReceive(Context context, Intent intent) {
            if ("action.miot.write.specv2.ble.data".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("mac");
                byte[] byteArrayExtra = intent.getByteArrayExtra("value");
                fhe.O000000o(stringExtra, byteArrayExtra, new BleReadResponse(stringExtra, byteArrayExtra) {
                    /* class _m_j.fez.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f16202O000000o;
                    final /* synthetic */ byte[] O00000Oo;

                    {
                        this.f16202O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        byte[] bArr = (byte[]) obj;
                        if (i == 0) {
                            fez.this.O000000o(this.f16202O000000o, bArr, this.O00000Oo);
                            return;
                        }
                        gnk.O000000o("%s, encryptSendData fail,code %d", "SpecChannelManager", Integer.valueOf(i));
                        fez.O000000o(this.f16202O000000o, this.O00000Oo, i);
                    }
                });
            }
        }
    }
}
