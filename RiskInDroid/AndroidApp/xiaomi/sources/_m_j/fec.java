package _m_j;

import _m_j.ffq;
import _m_j.fiz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.bluetooth.SearchResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothService$3;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothService$4;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.IPCChannelManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class fec implements fel {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fel f16177O000000o;
    private static Context O00000Oo;
    private static fej O00000o = new feg();
    private static fek O00000o0 = new feh();
    private static ExecutorService O00000oO = Executors.newSingleThreadExecutor();
    private static hmh O00000oo = new hmg();
    private final BroadcastReceiver O0000O0o = new BroadcastReceiver() {
        /* class _m_j.fec.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("process_name");
                gnk.O00000o0(String.format("BluetoothService onReceive %s, processName = %s", action, stringExtra));
                if ("action.coremanager.process_dead".equals(action) && TextUtils.equals(stringExtra, context.getPackageName())) {
                    gnk.O00000o0(String.format("App process died", new Object[0]));
                    fiz.O000000o().O00000Oo();
                }
            }
        }
    };

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.glc.O000000o(android.content.Context, boolean):void
     arg types: [android.content.Context, int]
     candidates:
      _m_j.glc.O000000o(java.lang.Runnable, long):void
      _m_j.glc.O000000o(android.content.Context, boolean):void */
    private fec(Context context) {
        Context applicationContext = context.getApplicationContext();
        O00000Oo = applicationContext;
        glc.O000000o(applicationContext, true);
    }

    public final void O000000o() {
        ffr.O000000o();
        fen.O000000o();
        IPCChannelManager O00000Oo2 = IPCChannelManager.O00000Oo();
        gnl.O000000o(new IPCChannelManager.NotifyReceiver(O00000Oo2), new IntentFilter("com.xiaomi.smarthome.bluetooth.character_changed"));
        ffa.O00000Oo();
        ffa.O00000o0();
        fey.O00000o().O00000Oo();
        fez.O00000o().O00000Oo();
        ft.O000000o(O00000Oo).O000000o(this.O0000O0o, new IntentFilter("action.coremanager.process_dead"));
        fhh.O000000o();
    }

    public static Context O00000Oo() {
        return O00000Oo;
    }

    public static fej O00000o0() {
        return O00000o;
    }

    public static hmh O00000o() {
        return O00000oo;
    }

    public static fek O00000oO() {
        return O00000o0;
    }

    public static ExecutorService O00000oo() {
        return O00000oO;
    }

    public static fel O000000o(Context context) {
        if (f16177O000000o == null) {
            synchronized (fec.class) {
                if (f16177O000000o == null) {
                    f16177O000000o = new fec(context);
                }
            }
        }
        return f16177O000000o;
    }

    public final void O000000o(boolean z) {
        glc.O000000o(O00000Oo, z);
    }

    public final void O000000o(fej fej) {
        if (fej != null) {
            O00000o = fej;
        }
    }

    public final void O000000o(SearchRequest searchRequest, SearchResponse searchResponse) {
        fea.O000000o(searchRequest, searchResponse);
    }

    public final void O0000O0o() {
        fiz.O000000o().O00000Oo();
    }

    public final void O000000o(String str, int i, Bundle bundle, IBleResponse iBleResponse) {
        switch (i) {
            case 1:
                fea.O000000o(str, bundle != null ? (BleConnectOptions) bundle.getParcelable("key.options") : null, iBleResponse);
                return;
            case 2:
                long j = 0;
                if (bundle != null) {
                    j = bundle.getLong("extra.delay", 0);
                }
                if (!(bundle != null ? bundle.getBoolean("extra.from.RN", false) : false) || !ffq.O000000o().O00000Oo() || !TextUtils.equals(str, ffq.O000000o().O00000oo)) {
                    fea.O000000o(str, j);
                    return;
                } else {
                    gnk.O000000o("BluetoothService RN request disconnect ble,but current ble device is doing OTA, so ignore it!!!", new Object[0]);
                    return;
                }
            case 3:
                fea.O000000o(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"), iBleResponse);
                return;
            case 4:
                fea.O000000o(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"), bundle.getByteArray("extra.byte.array"), iBleResponse);
                return;
            case 5:
                fea.O00000Oo(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"), bundle.getByteArray("extra.byte.array"), iBleResponse);
                return;
            case 6:
                fea.O00000Oo(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"), iBleResponse);
                return;
            case 7:
                fea.O000000o(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"));
                return;
            default:
                switch (i) {
                    case 10:
                        fea.O00000o0(str, iBleResponse);
                        return;
                    case 11:
                        fea.O00000o0(str, bundle.getByteArray("extra.byte.array"), iBleResponse);
                        return;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                        fea.O00000Oo(str, iBleResponse);
                        return;
                    case 13:
                        fea.O000000o(str);
                        return;
                    case 14:
                        fea.O00000Oo(str, bundle.getInt("extra.mtu"), iBleResponse);
                        return;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        fea.O00000o0(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"), iBleResponse);
                        return;
                    case 16:
                        fea.O00000Oo(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"));
                        return;
                    default:
                        switch (i) {
                            case 30:
                                fea.O00000Oo();
                                return;
                            case 31:
                                fea.O00000oO(str);
                                return;
                            case 32:
                                fea.O0000O0o();
                                return;
                            case 33:
                                fea.O00000o0(str);
                                return;
                            case 34:
                                fea.O00000o(str);
                                return;
                            case 35:
                                fea.O000000o(str, bundle.getLong("extra.duration"), iBleResponse);
                                return;
                            case 36:
                                fea.O000000o(bundle.getString("extra.key", ""), bundle.getString("extra.value", ""));
                                return;
                            case 37:
                                fea.O00000oo(bundle.getString("extra.submac", ""), iBleResponse);
                                return;
                            default:
                                switch (i) {
                                    case 40:
                                        fea.O00000Oo(str);
                                        return;
                                    case 41:
                                        fea.O00000o(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"), iBleResponse);
                                        return;
                                    case 42:
                                        fea.O00000o0(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"));
                                        return;
                                    case 43:
                                        fea.O000000o(str, bundle.getByteArray("extra.byte.array"), iBleResponse);
                                        return;
                                    case 44:
                                        fea.O00000Oo(str, bundle.getByteArray("extra.byte.array"), iBleResponse);
                                        return;
                                    case 45:
                                        fea.O000000o(str, bundle.getInt("extra.value"), iBleResponse);
                                        return;
                                    case 46:
                                        fea.O000000o(str, iBleResponse);
                                        return;
                                    case 47:
                                        fea.O000000o(str, bundle.getInt("extra.interval"), bundle.getInt("extra.digits"), bundle.getLong("extra.utcdelaytime", -1), iBleResponse);
                                        return;
                                    case 48:
                                        fea.O00000o(str, iBleResponse);
                                        return;
                                    case 49:
                                        fea.O00000o(str, bundle.getByteArray("extra.byte.array"), iBleResponse);
                                        return;
                                    case 50:
                                        fea.O00000oO(str, bundle.getByteArray("extra.byte.array"), iBleResponse);
                                        return;
                                    case 51:
                                        fea.O00000oo(str, bundle.getByteArray("extra.byte.array"), iBleResponse);
                                        return;
                                    case 52:
                                        fea.O0000O0o(str, bundle.getByteArray("extra.byte.array"), iBleResponse);
                                        return;
                                    case 53:
                                        fea.O00000oO(str, iBleResponse);
                                        return;
                                    case 54:
                                        fea.O00000oO(str, (UUID) bundle.getSerializable("extra.service.uuid"), (UUID) bundle.getSerializable("extra.character.uuid"), iBleResponse);
                                        return;
                                    default:
                                        gnk.O00000oo(String.format("callBluetoothApi unknown code %d", Integer.valueOf(i)));
                                        return;
                                }
                        }
                }
        }
    }

    public final void O000000o(String str, int i, Bundle bundle) {
        switch (i) {
            case 1:
                bundle.putString("extra.result", ffr.O000000o(str));
                return;
            case 2:
                bundle.putString("extra.result", ffr.O00000oo(str));
                return;
            case 3:
                bundle.putString("extra.result", ffr.O0000Oo0(str));
                return;
            case 4:
                bundle.putString("extra.result", ffr.O0000Oo(str));
                return;
            case 5:
                bundle.putInt("extra.result", ffr.O0000o0(str));
                return;
            case 6:
                bundle.putString("extra.result", ffr.O0000o0O(str));
                return;
            case 7:
                bundle.putString("extra.result", ffr.O0000o0O(str, bundle.getString("extra.key")));
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                bundle.putByteArray("extra.result", ffr.O0000Ooo(str));
                return;
            case 9:
                bundle.putParcelable("extra.result", ffr.O00oOooO(str));
                return;
            case 10:
                bundle.putString("extra.result", ffr.O00000o(str));
                return;
            case 11:
                bundle.putInt("extra.result", ffr.O0000O0o(str));
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                bundle.putInt("extra.result", ffr.O0000o00(str));
                return;
            case 13:
                bundle.putString("extra.result", ffr.O00000o0(str));
                return;
            case 14:
                bundle.putInt("extra.result", ffr.O0000OOo(str));
                return;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                bundle.putInt("extra.result", ffr.O00000oO(str));
                return;
            case 16:
                bundle.putString("extra.result", ffr.O00000Oo(str));
                return;
            case 17:
                bundle.putString("extra.result", ffr.O0000OoO(str));
                return;
            case 18:
                bundle.putString("extra.result", ffr.O0000oo0(str));
                return;
            case 19:
                bundle.putString("extra.result", ffr.O0000o(str));
                return;
            case 20:
                bundle.putString("extra.result", ffr.O0000ooO(str));
                return;
            case 21:
                bundle.putString("extra.result", ffr.O0000oO(str));
                return;
            case 22:
                bundle.putInt("extra.result", ffr.O0000oOO(str));
                return;
            case 23:
                bundle.putBoolean("extra.result", ffr.O0000oOo(str));
                return;
            case 24:
                bundle.putString("extra.result", ffr.O0000ooo(str));
                return;
            default:
                switch (i) {
                    case 100:
                        bundle.putParcelableArrayList("extra.devices", fea.O00000o());
                        return;
                    case 101:
                        bundle.putParcelableArrayList("extra.devices", fea.O00000oO());
                        return;
                    case 102:
                        bundle.putParcelableArrayList("extra.devices", fea.O00000oo());
                        return;
                    default:
                        gnk.O00000oo(String.format("getBluetoothCache unknown code %d", Integer.valueOf(i)));
                        return;
                }
        }
    }

    public final void O00000Oo(String str, int i, Bundle bundle) {
        switch (i) {
            case 1:
                ffr.O000000o(str, bundle.getString("extra.value", ""));
                return;
            case 2:
                ffr.O00000oO(str, bundle.getString("extra.value", ""));
                return;
            case 3:
                ffr.O00000oo(str, bundle.getString("extra.value", ""));
                return;
            case 4:
                ffr.O0000O0o(str, bundle.getString("extra.value", ""));
                return;
            case 5:
                ffr.O00000o(str, bundle.getInt("extra.value", 0));
                return;
            case 6:
                ffr.O0000Oo0(str, bundle.getString("extra.value", ""));
                return;
            case 7:
                String string = bundle.getString("extra.key");
                if (!TextUtils.isEmpty(string)) {
                    ffr.O000000o(str, string, bundle.getString("extra.value", ""));
                    return;
                }
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                ffr.O000000o(str, bundle.getByteArray("extra.value"));
                return;
            case 9:
                ffr.O000000o(str, (BleGattProfile) bundle.getParcelable("extra.value"));
                return;
            case 10:
                ffr.O00000o(str, bundle.getString("extra.value", ""));
                return;
            case 11:
            default:
                gnk.O00000oo(String.format("setBluetoothCache unknown code %d", Integer.valueOf(i)));
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                ffr.O00000oO(str, bundle.getInt("extra.value", 0));
                return;
            case 13:
                ffr.O00000o0(str, bundle.getString("extra.value", ""));
                return;
            case 14:
                ffr.O00000o0(str, bundle.getInt("extra.value", -60));
                return;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                ffr.O000000o(str, bundle.getInt("extra.value", 0));
                return;
            case 16:
                ffr.O00000Oo(str, bundle.getString("extra.value", ""));
                return;
            case 17:
                ffr.O0000OOo(str, bundle.getString("extra.value", ""));
                return;
            case 18:
                ffr.O0000Ooo(str, bundle.getString("extra.value", ""));
                return;
            case 19:
                ffr.O0000Oo(str, bundle.getString("extra.value", ""));
                return;
            case 20:
                ffr.O0000o00(str, bundle.getString("extra.value", ""));
                return;
            case 21:
                ffr.O0000OoO(str, bundle.getString("extra.value", ""));
                return;
            case 22:
                ffr.O00000oo(str, bundle.getInt("extra.value", 0));
                return;
            case 23:
                ffr.O000000o(str, bundle.getBoolean("extra.value", true));
                return;
        }
    }

    public final void O000000o(SearchRequest searchRequest, final IBleResponse iBleResponse) {
        fiz O000000o2 = fiz.O000000o();
        AnonymousClass2 r1 = new fem() {
            /* class _m_j.fec.AnonymousClass2 */

            public final /* synthetic */ void O000000o(Object obj) {
                BtDevice btDevice = (BtDevice) obj;
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("extra.device", btDevice);
                    iBleResponse.onResponse(fed.O00000o, bundle);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            public final void O000000o() {
                try {
                    iBleResponse.onResponse(fed.f16180O000000o, null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            public final void O00000Oo() {
                try {
                    iBleResponse.onResponse(fed.O00000o0, null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            public final void O00000o0() {
                try {
                    iBleResponse.onResponse(fed.O00000Oo, null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
        if (!gnl.O00000Oo()) {
            return;
        }
        if (!O000000o2.O00000o0) {
            O000000o2.O00000o0 = true;
            synchronized (O000000o2.f16432O000000o) {
                O000000o2.f16432O000000o.clear();
            }
            O000000o2.O00000o = r1;
            O000000o2.O00000oo = O000000o2.O00000oO.schedule(new fiz.O000000o(searchRequest), 500, TimeUnit.MILLISECONDS);
            return;
        }
        gnk.O00000oO("BluetoothDeviceSearch current request execute,please cancel");
    }

    public final void O000000o(String str, String str2, String str3, boolean z, String str4, int i, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) {
        ffq O000000o2 = ffq.O000000o();
        BluetoothService$3 bluetoothService$3 = new BluetoothService$3(this, iBleMeshUpgradeResponse);
        gnk.O00000o0(String.format("Ble-OTA:MeshDfuManager startMcuUpgrade mac = %s, filePath = %s", str, str4));
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager startMcuUpgrade failed, mac is null");
            ffq.O000000o(bluetoothService$3, -102, "mac is null");
        } else if (O000000o2.O00000o0) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager startMcuUpgrade failed, has another updating");
            ffq.O000000o(bluetoothService$3, -103, "has another updating");
        } else if (!gnl.O00000o0(str)) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager startMcuUpgrade failed, device is not connected");
            ffq.O000000o(bluetoothService$3, -100, "device is not connected");
        } else if (!ffq.O000000o(str4)) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager startMcuUpgrade failed, file is not exist : ".concat(String.valueOf(str4)));
            ffq.O000000o(bluetoothService$3, -104, "file is not exist");
        } else {
            if (i > O000000o2.O00000Oo) {
                O000000o2.O00000Oo = i;
            }
            O000000o2.O00000o = true;
            O000000o2.O00000oo = str;
            O000000o2.O00000oO = z;
            O000000o2.O0000OOo = bluetoothService$3;
            ffq.O0000OOo o0000OOo = O000000o2.f16225O000000o.get(str);
            if (o0000OOo == null) {
                o0000OOo = new ffq.O0000OOo();
                O000000o2.f16225O000000o.put(str, o0000OOo);
            }
            O000000o2.O0000o0 = str3;
            o0000OOo.O0000Oo0 = true;
            o0000OOo.O00000o0 = str2;
            o0000OOo.O00000o = str3;
            o0000OOo.f16240O000000o = str4;
            try {
                o0000OOo.O0000Oo = bluetoothService$3.isMeshDevice();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (O000000o2.O0000o0O == null) {
                O000000o2.O0000o0O = fev.O00000Oo().O00000Oo(str, O000000o2.O0000o0o);
            }
            O000000o2.O00000o0();
        }
    }

    public final void O000000o(String str, String str2, String str3, String str4, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) {
        ffq O000000o2 = ffq.O000000o();
        BluetoothService$4 bluetoothService$4 = new BluetoothService$4(this, iBleMeshUpgradeResponse, str2, str3);
        gnk.O00000o0(String.format("Ble-OTA:MeshDfuManager startUpgrade mac = %s, filePath = %s", str, str4));
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager startUpdate failed, mac is null");
            ffq.O000000o(bluetoothService$4, -102, "mac is null");
        } else if (O000000o2.O00000o0) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager startUpdate failed, has another updating");
            ffq.O000000o(bluetoothService$4, -103, "has another updating");
        } else if (!gnl.O00000o0(str)) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager startUpdate failed, device is not connected");
            ffq.O000000o(bluetoothService$4, -100, "device is not connected");
        } else if (!ffq.O000000o(str4)) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager startUpdate failed, file is not exist : ".concat(String.valueOf(str4)));
            ffq.O000000o(bluetoothService$4, -104, "file is not exist");
        } else {
            O000000o2.O00000o0 = true;
            O000000o2.O00000oO = false;
            O000000o2.O00000oo = str;
            O000000o2.O0000O0o = str4;
            O000000o2.O0000OOo = bluetoothService$4;
            O000000o2.O0000o0 = str3;
            ffq.O0000OOo o0000OOo = O000000o2.f16225O000000o.get(str);
            if (o0000OOo == null) {
                o0000OOo = new ffq.O0000OOo();
                O000000o2.f16225O000000o.put(str, o0000OOo);
            }
            o0000OOo.O0000Oo0 = false;
            o0000OOo.O00000o = str3;
            o0000OOo.O00000Oo = str4;
            try {
                o0000OOo.O0000Oo = bluetoothService$4.isMeshDevice();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (O000000o2.O0000o0O == null) {
                O000000o2.O0000o0O = fev.O00000Oo().O00000Oo(str, O000000o2.O0000o0o);
            }
            O000000o2.O00000o0();
        }
    }

    public final void O000000o(String str) {
        ffq O000000o2 = ffq.O000000o();
        fte.O00000Oo(String.format("Ble-OTA:MeshDfuManager cancelUpgrade mac = %s", fte.O000000o(str)));
        if (O000000o2.O00000o0 && TextUtils.equals(str, O000000o2.O00000oo)) {
            ChannelManager.O000000o O00000oO2 = fev.O00000Oo().O00000oO(O000000o2.O00000oo);
            if (O00000oO2 != null) {
                O00000oO2.O00000oo();
            }
            O000000o2.O000000o(2, "cancel upgrade");
        }
    }

    public final byte[] O000000o(String str, byte[] bArr) {
        return fea.O000000o(str, bArr);
    }

    public final byte[] O00000Oo(String str, byte[] bArr) {
        return fea.O00000Oo(str, bArr);
    }

    public final List<Device> O0000OOo() {
        return fea.O00000o0();
    }

    public final void O000000o(hmh hmh) {
        if (hmh != null) {
            O00000oo = hmh;
        }
    }

    public final void O000000o(fek fek) {
        if (fek != null) {
            O00000o0 = fek;
        }
    }
}
