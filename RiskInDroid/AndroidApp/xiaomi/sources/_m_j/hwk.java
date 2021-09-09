package _m_j;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.LockWifiConfigStep$1;
import com.xiaomi.smarthome.smartconfig.step.LockWifiConfigStep$4;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

public class hwk extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public BleComboWifiConfig f869O000000o;
    public String O00000Oo;
    private boolean O00000o;
    O000000o O00000o0;
    private IBleChannelWriter O00000oO;
    private IBleChannelReader O00000oo = new LockWifiConfigStep$1(this);

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final int O00000Oo() {
        return 0;
    }

    public final void z_() {
    }

    public hwk() {
        this.O000Ooo = "LockCameraConfigStep";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    public final void O000000o(Context context) {
        Intent intent;
        this.O00000Oo = (String) htr.O000000o().O000000o("key_lock_wifi_device_mac");
        this.f869O000000o = new BleComboWifiConfig();
        this.f869O000000o.f6885O000000o = SmartConfigRouterFactory.getCoreApiManager().getMiId();
        this.f869O000000o.O00000Oo = htr.O000000o().O00000Oo();
        this.f869O000000o.O00000o0 = htr.O000000o().O00000o0();
        this.f869O000000o.O00000o = foi.O000000o();
        this.f869O000000o.O00000oO = foi.O00000Oo();
        this.f869O000000o.O00000oo = foi.O00000o0();
        BleComboWifiConfig bleComboWifiConfig = this.f869O000000o;
        bleComboWifiConfig.O0000O0o = "app";
        bleComboWifiConfig.O0000Oo0 = foi.O00000o();
        this.f869O000000o.O0000OoO = (String) htr.O000000o().O000000o("key_lock_wifi_device_token");
        this.O00000o = ((Boolean) htr.O000000o().O000000o("key_lock_wifi_from_plugin")).booleanValue();
        if (!this.O00000o) {
            fbt O000000o2 = new fbt(this.O000O0oo, "BleBindActivityV2").O000000o("extra_from", "from_match").O000000o("key_lock_wifi_config", (Parcelable) this.f869O000000o);
            if ((this.O000O0oo instanceof Activity) && (intent = ((Activity) this.O000O0oo).getIntent()) != null) {
                O000000o2.O000000o("connect_source", intent.getIntExtra("connect_source", 0)).O000000o("connect_unique", intent.getStringExtra("connect_unique"));
                if (intent.hasExtra("key_already_found")) {
                    O000000o2.O000000o("key_already_found", intent.getBooleanExtra("key_already_found", false));
                }
                if (intent.hasExtra("key_qrcode_oob")) {
                    O000000o2.O000000o("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                }
            }
            fbs.O000000o(O000000o2);
            b_(false);
            return;
        }
        try {
            this.O00000oO = SmartConfigRouterFactory.getCoreApiManager().registerSecureAuthChannelReader(this.O00000Oo, this.O00000oo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.O000000o(context);
        if (this.O00000o0 == null) {
            this.O00000o0 = new O000000o(this, (byte) 0);
            gnl.O000000o(this.O00000o0, new IntentFilter("com.xiaomi.smarthome.bluetooth.character_changed"));
        }
        XmBluetoothManager.getInstance().notify(this.O00000Oo, glb.f17954O000000o, glb.O0000Oo, new Response.BleNotifyResponse() {
            /* class _m_j.hwk.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                hwk.this.O000000o("open wifi notify: ".concat(String.valueOf(i)), new Object[0]);
            }
        });
    }

    public final ArrayList<gke> O0000Oo0() {
        gke gke = new gke();
        gke.O00000Oo = 120000;
        gke.f17943O000000o = 0;
        ArrayList<gke> arrayList = new ArrayList<>();
        arrayList.add(gke);
        return arrayList;
    }

    public final void O00000o0(int i) {
        Handler x_ = x_();
        if (x_ != null) {
            x_.sendEmptyMessage(133);
        }
    }

    public final void O000000o(Message message) {
        if (message.what == 133) {
            htq.O000000o().O00000Oo(new hua<JSONObject, hud>() {
                /* class _m_j.hwk.AnonymousClass2 */

                public final /* synthetic */ void O000000o(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    hwk.this.O000000o(" get bind key onSuccess: ".concat(String.valueOf(jSONObject)), new Object[0]);
                    hwk.this.f869O000000o.O0000OOo = jSONObject.optString("bindkey");
                    Handler x_ = hwk.this.x_();
                    if (x_ != null) {
                        x_.sendEmptyMessage(114);
                    }
                }

                public final void O000000o(hud hud) {
                    hwk.this.O000000o("get bind key onfail code %d,msg=%s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                    Handler x_ = hwk.this.x_();
                    if (x_ != null) {
                        x_.removeMessages(133);
                        x_.sendEmptyMessageDelayed(133, 2000);
                    }
                }
            });
        } else if (message.what == 114) {
            XmBluetoothManager.getInstance().write(this.O00000Oo, glb.f17954O000000o, glb.O0000OOo, new byte[]{-91}, new Response.BleWriteResponse() {
                /* class _m_j.hwk.AnonymousClass1 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    fte.O00000Oo(" send a5 result = ".concat(String.valueOf(i)));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fhe.O000000o(hwk.this.O00000Oo, hwk.this.f869O000000o.O000000o(), new BleReadResponse() {
                        /* class _m_j.hwk.AnonymousClass1.AnonymousClass1 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            Handler x_;
                            byte[] bArr = (byte[]) obj;
                            fte.O00000Oo(" BleSecurityChipEncrypt result = ".concat(String.valueOf(i)));
                            if (i == 0) {
                                hwk hwk = hwk.this;
                                hwk.O000000o(" sendWifiConfig", new Object[0]);
                                if (!hwk.O000000o(bArr, new LockWifiConfigStep$4(hwk)) && (x_ = hwk.x_()) != null) {
                                    x_.removeMessages(114);
                                    x_.sendEmptyMessageDelayed(114, 5000);
                                    return;
                                }
                                return;
                            }
                            Handler x_2 = hwk.this.x_();
                            if (x_2 != null) {
                                x_2.removeMessages(114);
                                x_2.sendEmptyMessageDelayed(114, 5000);
                            }
                        }
                    });
                }
            });
        } else {
            super.O000000o(message);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(byte[] bArr, IBleResponse iBleResponse) {
        try {
            this.O00000oO.write(bArr, 15, iBleResponse);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, int, ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    public final SmartConfigStep.Step O00000o(int i) {
        O000000o(" onStateTimeout", new Object[0]);
        Handler x_ = x_();
        if (x_ != null) {
            x_.removeMessages(114);
            x_.removeMessages(133);
        }
        O000000o(false, 0, (SmartConfigStep.Step) null);
        if (!hze.O000000o(this.O000O0oo)) {
            O00000Oo(R.string.kuailian_device_connect_wifi_fail, R.string.phone_wifi_error, R.drawable.common_bind_app_connect_network_failed);
        } else {
            O00000Oo(R.string.kuailian_device_connect_wifi_fail, R.string.make_device_near_router, R.drawable.common_bind_device_connect_network_failed);
        }
        return null;
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.kuailian_device_connect_wifi, (int) R.string.make_device_near_router);
        this.O000O0o0.O000000o(3);
    }

    public final void C_() {
        this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_device_connect_wifi_success, (int) R.string.make_device_near_router);
    }

    public final boolean G_() {
        O000000o("onBackPressed ,stay page time %s ms", String.valueOf(System.currentTimeMillis() - this.O000OO), new Object[0]);
        Handler x_ = x_();
        if (x_ != null) {
            x_.removeMessages(114);
            x_.removeMessages(133);
        }
        b_(false);
        return true;
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(hwk hwk, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                hwk.this.O000000o("get mReceiver action： ".concat(String.valueOf(action)), new Object[0]);
                if ("com.xiaomi.smarthome.bluetooth.character_changed".equalsIgnoreCase(action)) {
                    if (hwk.this.O00000Oo.equalsIgnoreCase(intent.getStringExtra("key_device_address"))) {
                        UUID uuid = (UUID) intent.getSerializableExtra("key_service_uuid");
                        UUID uuid2 = (UUID) intent.getSerializableExtra("key_character_uuid");
                        byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                        if (uuid != null && uuid2 != null) {
                            hwk hwk = hwk.this;
                            if (!glb.f17954O000000o.equals(uuid)) {
                                return;
                            }
                            if (glb.O0000o0.equals(uuid2)) {
                                ChannelManager.O000000o O00000oO = few.O00000Oo().O00000oO(hwk.O00000Oo);
                                if (O00000oO != null) {
                                    O00000oO.O000000o(byteArrayExtra);
                                }
                            } else if (glb.O0000Oo.equals(uuid2) && !got.O00000o(byteArrayExtra)) {
                                byte b = byteArrayExtra[0];
                                hwk.O000000o("onNotifyStatus: ".concat(String.valueOf((int) b)), new Object[0]);
                                if (b != 0 && b != 1 && b != 2 && b == 3) {
                                    hwk.e_(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void O0000O0o() {
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            gnl.O000000o(o000000o);
            this.O00000o0 = null;
        }
        XmBluetoothManager.getInstance().unnotify(this.O00000Oo, glb.f17954O000000o, glb.O0000Oo);
        if (this.O00000o) {
            try {
                SmartConfigRouterFactory.getCoreApiManager().unRegisterSecureAuthChannelReader(this.O00000Oo, this.O00000oo);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        super.O0000O0o();
    }
}
