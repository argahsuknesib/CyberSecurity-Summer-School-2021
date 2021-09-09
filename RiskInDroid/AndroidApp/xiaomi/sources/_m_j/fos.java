package _m_j;

import _m_j.foa;
import _m_j.foh;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class fos extends Cfor {
    private fom O00000oO;
    private O000000o O00000oo;
    private BleConnectOptions O0000O0o;

    public fos(fot fot) {
        super(fot);
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
        SmartConfigRouterFactory.getCoreApiManager().stopSearchBluetoothDevice();
        final Future<String> O000000o2 = fol.O000000o(scanResult);
        if (O000000o2 == null) {
            O000000o((String) null);
        } else {
            gqe.O000000o(new gqe() {
                /* class _m_j.fos.AnonymousClass1 */

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
                        Cfor.O000000o("searchComboAddress mac address not empty", new Object[0]);
                        fos.this.O00000o0 = str;
                    }
                    fos.this.O000000o(str);
                    str = "";
                    if (!TextUtils.isEmpty(str)) {
                    }
                    fos.this.O000000o(str);
                }
            }, AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    public final void O00000o() {
        super.O00000o();
        O00000Oo();
        XmBluetoothManager.getInstance().disconnect(this.O00000o0);
    }

    public final void O000000o(boolean z, String str, String str2, String str3) {
        super.O000000o(z, str, str2, str3);
        O000000o(z, str, 0, null, str2, str3);
    }

    public final void O000000o(boolean z, String str, long j, String str2, String str3, String str4) {
        super.O000000o(z, str, j, str2, str3, str4);
        String O00000Oo = htr.O000000o().O00000Oo();
        String O00000o0 = htr.O000000o().O00000o0();
        O000000o("BleComboConnector.sendSSIDAndPassWd ssid = %s,  bindKey = %s, bindkeyTs = %s, bindketIndex = %s,  configType = %s", O00000Oo, str, Long.valueOf(j), str2, str3);
        if (this.O00000oO == null) {
            if (z) {
                this.O00000oO = new foh(this.O00000o0, O00000Oo, O00000o0, str, str3);
            } else {
                this.O00000oO = new foi(this.O00000o0, O00000Oo, O00000o0, str, j, str2, str3, str4);
            }
        }
        foc.O0000o(this.O00000o0);
        this.O00000oO.O000000o(this.O0000O0o, new foh.O000000o() {
            /* class _m_j.fos.AnonymousClass2 */

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
                fos.this.O000000o(i, str, str2);
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
        XmBluetoothManager.getInstance().notify(this.O00000o0, glb.f17954O000000o, glb.O0000Oo, new Response.BleNotifyResponse() {
            /* class _m_j.fos.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ void onResponse(int i, Object obj) {
            }
        });
    }

    public final void O00000Oo() {
        super.O00000Oo();
        O000000o("closeComboNotify", new Object[0]);
        O00000oO();
        XmBluetoothManager.getInstance().unnotify(this.O00000o0, glb.f17954O000000o, glb.O0000Oo);
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

        /* synthetic */ O000000o(fos fos, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("key_device_address");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(fos.this.O00000o0)) {
                    String action = intent.getAction();
                    if ("com.xiaomi.smarthome.bluetooth.character_changed".equalsIgnoreCase(action)) {
                        UUID uuid = (UUID) intent.getSerializableExtra("key_character_uuid");
                        byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                        if (((UUID) intent.getSerializableExtra("key_service_uuid")).equals(glb.f17954O000000o) && uuid.equals(glb.O0000Oo) && !got.O00000o(byteArrayExtra)) {
                            Cfor.O000000o("combo device receive notify ,value =" + got.O00000o0(byteArrayExtra), new Object[0]);
                            fos.this.O000000o(byteArrayExtra[0]);
                        }
                    } else if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equalsIgnoreCase(action)) {
                        intent.getIntExtra("key_connect_status", 5);
                    }
                }
            }
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O00000oO.O000000o(new foa.O000000o() {
            /* class _m_j.fos.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ void onResponse(int i, Object obj) {
            }
        });
    }

    public final void O000000o(final fou fou) {
        super.O000000o(fou);
        fom fom = this.O00000oO;
        if (fom != null) {
            fom.O00000Oo(new foa.O000000o() {
                /* class _m_j.fos.AnonymousClass5 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    fou fou = fou;
                    if (fou != null) {
                        fou.O000000o();
                    }
                }
            });
        }
    }
}
