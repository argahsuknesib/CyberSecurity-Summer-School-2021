package _m_j;

import _m_j.gjt;
import _m_j.gka;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.kuailian.process.ble.register.BleComboConnector$3;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class gjz extends gjv {
    private gkc O00000oO;
    private O000000o O00000oo;
    private BleConnectOptions O0000O0o;

    public gjz(gjw gjw) {
        super(gjw);
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 35000;
        o000000o.O00000Oo = 1;
        o000000o.O00000o = C.MSG_CUSTOM_BASE;
        this.O0000O0o = o000000o.O000000o();
    }

    public final void O000000o(ScanResult scanResult) {
        super.O000000o(scanResult);
        boolean z = true;
        Object[] objArr = new Object[1];
        if (scanResult == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        O000000o("searchComboAddress scanResult not empty:%s", objArr);
        fte.O00000Oo("BleComboConnector.connectCombo");
        gsy.O000000o(4, "stopScan", "BCC stop");
        fiz.O000000o().O00000Oo();
        final Future<String> O000000o2 = fef.O000000o(scanResult);
        if (O000000o2 == null) {
            O000000o((String) null);
        } else {
            gqe.O000000o(new gqe() {
                /* class _m_j.gjz.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
                public final void O000000o() {
                    String str;
                    try {
                        str = (String) O000000o2.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e2) {
                        e2.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        gjz.O000000o("searchComboAddress mac address not empty", new Object[0]);
                        gjz.this.O00000o0 = str;
                    }
                    gjz.this.O000000o(str);
                    str = "";
                    if (!TextUtils.isEmpty(str)) {
                    }
                    gjz.this.O000000o(str);
                }
            }, AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    public final void O00000o() {
        super.O00000o();
        O00000Oo();
        glw.O000000o().disconnect(this.O00000o0);
    }

    public final void O000000o(boolean z, gju gju) {
        super.O000000o(z, gju);
        if (this.O00000oO == null) {
            if (z) {
                this.O00000oO = new gka(this.O00000o0, gju);
            } else {
                this.O00000oO = new gkb(this.O00000o0, gju);
            }
        }
        this.O00000oO.O000000o(this.O0000O0o, new gka.O000000o() {
            /* class _m_j.gjz.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str;
                Bundle bundle = (Bundle) obj;
                gnk.O00000oO(String.format("mBleFastConnector onResponse = %s", gmc.O000000o(i)));
                String str2 = "";
                if (bundle != null) {
                    str = bundle.getString("key_version");
                    if (bundle.containsKey("key_device_did")) {
                        str2 = bundle.getString("key_device_did");
                    }
                } else {
                    str = str2;
                }
                gjz.this.O000000o(i, str, str2);
            }
        });
    }

    public final void O000000o() {
        super.O000000o();
        O000000o("openComboNotify", new Object[0]);
        if (this.O00000oo == null) {
            this.O00000oo = new O000000o(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter("com.xiaomi.smarthome.bluetooth.character_changed");
            intentFilter.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
            gnl.O000000o(this.O00000oo, intentFilter);
        }
        fea.O00000Oo(this.O00000o0, glb.f17954O000000o, glb.O0000Oo, new BleComboConnector$3(this));
    }

    public final void O00000Oo() {
        super.O00000Oo();
        O000000o("closeComboNotify", new Object[0]);
        O00000oO();
        fea.O000000o(this.O00000o0, glb.f17954O000000o, glb.O0000Oo);
    }

    private void O00000oO() {
        O000000o o000000o = this.O00000oo;
        if (o000000o != null) {
            gnl.O000000o(o000000o);
            this.O00000oo = null;
        }
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(gjz gjz, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("key_device_address");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(gjz.this.O00000o0) && "com.xiaomi.smarthome.bluetooth.character_changed".equalsIgnoreCase(intent.getAction())) {
                    UUID uuid = (UUID) intent.getSerializableExtra("key_character_uuid");
                    byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                    if (((UUID) intent.getSerializableExtra("key_service_uuid")).equals(glb.f17954O000000o) && uuid.equals(glb.O0000Oo) && !gkk.O000000o(byteArrayExtra)) {
                        gjz.O000000o("combo device receive notify ,value =" + gkk.O00000Oo(byteArrayExtra), new Object[0]);
                        gjz.this.O000000o(byteArrayExtra[0]);
                    }
                }
            }
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O00000oO.O000000o(new gjt.O000000o() {
            /* class _m_j.gjz.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ void onResponse(int i, Object obj) {
            }
        });
    }

    public final void O000000o(final gjx gjx) {
        super.O000000o(gjx);
        gkc gkc = this.O00000oO;
        if (gkc != null) {
            gkc.O00000Oo(new gjt.O000000o() {
                /* class _m_j.gjz.AnonymousClass4 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    gjx gjx = gjx;
                    if (gjx != null) {
                        gjx.O000000o();
                    }
                }
            });
        }
    }
}
