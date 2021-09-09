package _m_j;

import _m_j.fap;
import _m_j.gmy;
import _m_j.gmz;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchResult;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchTask;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.bluetooth.SearchResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothApi$6;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.IPCChannelManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattService;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadRssiResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleRequestMtuResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fea {

    /* renamed from: O000000o  reason: collision with root package name */
    public static List<fei> f16147O000000o = new ArrayList();
    public static Handler O00000Oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.fea.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                fea.O000000o();
                fea.O00000Oo.sendEmptyMessageDelayed(1, 10000);
            } else if (i == 2) {
                Bundle data = message.getData();
                fei fei = new fei();
                fei.O00000Oo = data.getString("extra.mac", "");
                fei.f16183O000000o = data.getLong("extra.delay", 10000) + System.currentTimeMillis();
                fea.f16147O000000o.add(fei);
                Collections.sort(fea.f16147O000000o);
            }
        }
    };
    public static IBleChannelReader O00000o0 = new BluetoothApi$6();

    public static boolean O000000o(int i) {
        return 5 >= i;
    }

    public static void O000000o() {
        while (!gpn.O000000o(f16147O000000o)) {
            fei fei = f16147O000000o.get(0);
            if (System.currentTimeMillis() < fei.f16183O000000o) {
                break;
            }
            f16147O000000o.remove(0);
            O00000oo(fei.O00000Oo);
        }
        if (gpn.O000000o(f16147O000000o)) {
            O00000Oo.removeMessages(1);
        }
    }

    static void O000000o(final String str, BleConnectOptions bleConnectOptions, final IBleResponse iBleResponse) {
        O000000o(str, bleConnectOptions, new BleConnectResponse() {
            /* class _m_j.fea.AnonymousClass23 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Pair<Boolean, String> O00000o;
                Bundle bundle = (Bundle) obj;
                if (i == 0 && (O00000o = fec.O00000o0().O00000o(str)) != null && ((Boolean) O00000o.first).booleanValue()) {
                    fgo.O000000o(str, (String) O00000o.second, (feo<Void, fes>) null);
                }
                IBleResponse iBleResponse = iBleResponse;
                if (iBleResponse != null) {
                    try {
                        iBleResponse.onResponse(i, bundle);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void O000000o(final String str, BleConnectOptions bleConnectOptions, final BleConnectResponse bleConnectResponse) {
        fte.O00000Oo("connect mac = " + fte.O000000o(str));
        glw.O000000o().connect(str, bleConnectOptions, new BleConnectResponse() {
            /* class _m_j.fea.AnonymousClass24 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Bundle bundle = (Bundle) obj;
                fte.O00000Oo("connect mac = " + fte.O000000o(str) + ", code = " + i);
                try {
                    BleGattProfile bleGattProfile = (BleGattProfile) bundle.getParcelable("key_gatt_profile");
                    if (bleGattProfile != null) {
                        ffr.O000000o(str, bleGattProfile);
                    }
                    fea.O000000o(str, bleGattProfile);
                    if (bleConnectResponse != null) {
                        bleConnectResponse.onResponse(i, bundle);
                    }
                } catch (Exception e) {
                    gnk.O000000o(e);
                }
            }
        });
    }

    public static void O000000o(final String str, BleGattProfile bleGattProfile) {
        BleGattService O000000o2;
        gnk.O00000o0(String.format("registerChannelReaderIfSupported mac = %s", str));
        if (bleGattProfile != null && (O000000o2 = bleGattProfile.O000000o(glb.f17954O000000o)) != null && O000000o2.O000000o(glb.O0000o00)) {
            glw.O000000o().notify(str, glb.f17954O000000o, glb.O0000o00, new BleNotifyResponse() {
                /* class _m_j.fea.AnonymousClass25 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i == 0) {
                        IPCChannelManager.O00000Oo().O00000Oo(str, fea.O00000o0);
                    }
                }
            });
        }
    }

    private static void O00000oo(String str) {
        fte.O00000Oo("disconnect mac = " + fte.O000000o(str));
        glw.O000000o().disconnect(str);
    }

    public static void O000000o(String str, long j) {
        if (j < 0) {
            j = 0;
        }
        if (j == 0) {
            O00000oo(str);
            return;
        }
        Message obtainMessage = O00000Oo.obtainMessage(2);
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        bundle.putLong("extra.delay", j);
        obtainMessage.setData(bundle);
        O00000Oo.sendMessage(obtainMessage);
        if (!O00000Oo.hasMessages(1)) {
            O00000Oo.sendEmptyMessage(1);
        }
    }

    public static void O000000o(String str, UUID uuid, UUID uuid2, final IBleResponse iBleResponse) {
        glw.O000000o().read(str, uuid, uuid2, new BleReadResponse() {
            /* class _m_j.fea.AnonymousClass26 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("extra.byte.array", (byte[]) obj);
                try {
                    iBleResponse.onResponse(i, bundle);
                } catch (Exception e) {
                    gnk.O000000o(e);
                }
            }
        });
    }

    static void O000000o(final String str, byte[] bArr, final IBleResponse iBleResponse) {
        fte.O00000Oo("securityChipEncrypt mac = " + fte.O000000o(str));
        fhe.O000000o(str, bArr, new BleReadResponse() {
            /* class _m_j.fea.AnonymousClass27 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("securityChipEncrypt mac = " + fte.O000000o(str) + ", code = " + i);
                Bundle bundle = new Bundle();
                bundle.putByteArray("extra.byte.array", (byte[]) obj);
                try {
                    iBleResponse.onResponse(i, bundle);
                } catch (Exception e) {
                    gnk.O000000o(e);
                }
            }
        });
    }

    static void O00000Oo(final String str, byte[] bArr, final IBleResponse iBleResponse) {
        fte.O00000Oo("securityChipDecrypt mac = " + fte.O000000o(str));
        fhe.O00000Oo(str, bArr, new BleReadResponse() {
            /* class _m_j.fea.AnonymousClass28 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("securityChipDecrypt mac = " + fte.O000000o(str) + ", code = " + i);
                Bundle bundle = new Bundle();
                bundle.putByteArray("extra.byte.array", (byte[]) obj);
                try {
                    iBleResponse.onResponse(i, bundle);
                } catch (Exception e) {
                    gnk.O000000o(e);
                }
            }
        });
    }

    static void O000000o(final String str, int i, final IBleResponse iBleResponse) {
        fte.O00000Oo("securityChipOperate mac = " + fte.O000000o(str) + ", operator = " + i);
        fhh.O000000o(str, i, new BleReadResponse() {
            /* class _m_j.fea.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("securityChipOperate mac = " + fte.O000000o(str) + ", code = " + i);
                Bundle bundle = new Bundle();
                bundle.putByteArray("extra.byte.array", (byte[]) obj);
                try {
                    iBleResponse.onResponse(i, bundle);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static List<Device> O00000o0() {
        List<Device> O00000Oo2 = fec.O00000o0().O00000Oo();
        ArrayList arrayList = new ArrayList();
        for (Device next : O00000Oo2) {
            if (next.isOwner() && fec.O00000o0().O0000O0o(next.getModel())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    static void O000000o(final String str, final IBleResponse iBleResponse) {
        if (iBleResponse != null) {
            fec.O00000oo().submit(new Runnable() {
                /* class _m_j.fea.AnonymousClass3 */

                public final void run() {
                    List<Device> O00000Oo2 = fec.O00000o0().O00000Oo();
                    ArrayList arrayList = new ArrayList();
                    String str = "";
                    for (Device next : O00000Oo2) {
                        if (TextUtils.equals(str, next.getMac())) {
                            str = next.getDid();
                        }
                        if (next.isOwner() && fec.O00000o0().O0000O0o(next.getModel())) {
                            arrayList.add(next.getDid());
                        }
                    }
                    if (TextUtils.isEmpty(str) || arrayList.size() == 0) {
                        try {
                            iBleResponse.onResponse(-1, null);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    } else {
                        fea.O000000o(str, arrayList, new feo<Boolean, fes>() {
                            /* class _m_j.fea.AnonymousClass3.AnonymousClass1 */

                            public final /* synthetic */ void O000000o(Object obj) {
                                if (((Boolean) obj).booleanValue()) {
                                    try {
                                        iBleResponse.onResponse(0, null);
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    try {
                                        iBleResponse.onResponse(-1, null);
                                    } catch (RemoteException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }

                            public final void O000000o(fes fes) {
                                try {
                                    iBleResponse.onResponse(-1, null);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    static void O000000o(final String str, final List<String> list, final feo<Boolean, fes> feo) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dids", new JSONArray((Collection<?>) list));
        } catch (JSONException unused) {
        }
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        gnk.O00000o0(String.format("getBleDeviceByGateway: [%s]", jSONObject));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/device/get_bledevice_by_gateway";
        o000000o.O00000o0 = arrayList;
        BleNetRequest O000000o2 = o000000o.O000000o();
        final AnonymousClass4 r1 = new feq<Boolean>() {
            /* class _m_j.fea.AnonymousClass4 */

            /* access modifiers changed from: private */
            /* renamed from: O00000Oo */
            public Boolean O000000o(JSONObject jSONObject) throws JSONException {
                gnk.O00000o0(String.format("Http Response: [%s]", jSONObject));
                if (jSONObject != null) {
                    for (String optString : list) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(jSONObject.optString(optString));
                            if (jSONObject2.length() > 0) {
                                Iterator<String> keys = jSONObject2.keys();
                                while (keys.hasNext()) {
                                    if (TextUtils.equals(str, keys.next())) {
                                        return Boolean.TRUE;
                                    }
                                }
                                continue;
                            } else {
                                continue;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                return Boolean.FALSE;
            }
        };
        fec.O00000o0().O000000o(O000000o2, new fer() {
            /* class _m_j.fea.AnonymousClass5 */

            public final void O000000o(String str) {
                fet.O000000o().O000000o(str, r1, feo);
            }

            public final void O000000o(int i, String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    static void O000000o(String str, UUID uuid, UUID uuid2, byte[] bArr, final IBleResponse iBleResponse) {
        glw.O000000o().write(str, uuid, uuid2, bArr, new BleWriteResponse() {
            /* class _m_j.fea.AnonymousClass6 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                try {
                    iBleResponse.onResponse(i, null);
                } catch (Exception e) {
                    gnk.O00000Oo(gnk.O00000Oo(e));
                }
            }
        });
    }

    static void O00000Oo(String str, UUID uuid, UUID uuid2, byte[] bArr, final IBleResponse iBleResponse) {
        glw.O000000o().writeNoRsp(str, uuid, uuid2, bArr, new BleWriteResponse() {
            /* class _m_j.fea.AnonymousClass7 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                try {
                    iBleResponse.onResponse(i, null);
                } catch (Exception e) {
                    gnk.O00000Oo(gnk.O00000Oo(e));
                }
            }
        });
    }

    static void O00000o0(String str, byte[] bArr, IBleResponse iBleResponse) {
        IPCChannelManager.O00000Oo().O000000o(str, bArr, iBleResponse);
    }

    static void O00000Oo(String str, IBleResponse iBleResponse) {
        fdy.O000000o(str, iBleResponse);
    }

    static void O000000o(String str) {
        fdy.O000000o(str);
    }

    public static void O00000Oo(String str, UUID uuid, UUID uuid2, final IBleResponse iBleResponse) {
        glw.O000000o().notify(str, uuid, uuid2, new BleNotifyResponse() {
            /* class _m_j.fea.AnonymousClass8 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                try {
                    iBleResponse.onResponse(i, null);
                } catch (Exception e) {
                    gnk.O00000Oo(gnk.O00000Oo(e));
                }
            }
        });
    }

    public static void O000000o(String str, UUID uuid, UUID uuid2) {
        glw.O000000o().unnotify(str, uuid, uuid2);
    }

    static void O00000o0(String str, UUID uuid, UUID uuid2, final IBleResponse iBleResponse) {
        glw.O000000o().indication(str, uuid, uuid2, new BleNotifyResponse() {
            /* class _m_j.fea.AnonymousClass9 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                try {
                    iBleResponse.onResponse(i, null);
                } catch (Exception e) {
                    gnk.O00000Oo(gnk.O00000Oo(e));
                }
            }
        });
    }

    static void O00000Oo(String str, UUID uuid, UUID uuid2) {
        glw.O000000o().unindication(str, uuid, uuid2);
    }

    static void O00000Oo(String str) {
        glw.O000000o().refreshGattCache(str);
    }

    static void O00000o0(String str, final IBleResponse iBleResponse) {
        glw.O000000o().readRemoteRssi(str, new BleReadRssiResponse() {
            /* class _m_j.fea.AnonymousClass10 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Bundle bundle = new Bundle();
                bundle.putInt("extra.rssi", ((Integer) obj).intValue());
                try {
                    iBleResponse.onResponse(i, bundle);
                } catch (Exception e) {
                    gnk.O000000o(e);
                }
            }
        });
    }

    static void O00000Oo(String str, int i, final IBleResponse iBleResponse) {
        glw.O000000o().requestMtu(str, i, new BleRequestMtuResponse() {
            /* class _m_j.fea.AnonymousClass11 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Bundle bundle = new Bundle();
                bundle.putInt("extra.mtu", ((Integer) obj).intValue());
                try {
                    iBleResponse.onResponse(i, bundle);
                } catch (Exception e) {
                    gnk.O000000o(e);
                }
            }
        });
    }

    static void O00000o(String str, byte[] bArr, IBleResponse iBleResponse) {
        fte.O00000Oo("miotBleEncrypt mac = " + fte.O000000o(str));
        byte[] O0000o0o = ffr.O0000o0o(str);
        if (O0000o0o == null || O0000o0o.length == 0) {
            try {
                iBleResponse.onResponse(-1, new Bundle());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            fte.O00000Oo("miotBleEncrypt failed, token is empty");
            return;
        }
        byte[] O000000o2 = BLECipher.O000000o(O0000o0o, bArr);
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", O000000o2);
        try {
            iBleResponse.onResponse(0, bundle);
        } catch (Exception e2) {
            gnk.O000000o(e2);
        }
    }

    static byte[] O000000o(String str, byte[] bArr) {
        fte.O00000Oo("miotBleEncryptSync mac = " + fte.O000000o(str));
        if (!TextUtils.isEmpty(str) && bArr != null) {
            byte[] O0000o0o = ffr.O0000o0o(str);
            if (O0000o0o != null && O0000o0o.length != 0) {
                return BLECipher.O000000o(O0000o0o, bArr);
            }
            fte.O00000Oo("miotBleEncryptSync failed, token is empty");
        }
        return null;
    }

    static void O00000oO(String str, byte[] bArr, IBleResponse iBleResponse) {
        fte.O00000Oo("miotBleDecrypt mac = " + fte.O000000o(str));
        byte[] O0000o0o = ffr.O0000o0o(str);
        if (O0000o0o == null || O0000o0o.length == 0) {
            try {
                iBleResponse.onResponse(-1, new Bundle());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            fte.O00000Oo("miotBleDecrypt failed, token is empty");
            return;
        }
        byte[] O000000o2 = BLECipher.O000000o(O0000o0o, bArr);
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", O000000o2);
        try {
            iBleResponse.onResponse(0, bundle);
        } catch (Exception e2) {
            gnk.O000000o(e2);
        }
    }

    static byte[] O00000Oo(String str, byte[] bArr) {
        fte.O00000Oo("miotBleDecryptSync mac = " + fte.O000000o(str));
        if (!TextUtils.isEmpty(str) && bArr != null) {
            byte[] O0000o0o = ffr.O0000o0o(str);
            if (O0000o0o != null && O0000o0o.length != 0) {
                return BLECipher.O000000o(O0000o0o, bArr);
            }
            fte.O00000Oo("miotBleDecryptSync failed, token is empty");
        }
        return null;
    }

    static void O00000oo(final String str, byte[] bArr, final IBleResponse iBleResponse) {
        fte.O00000Oo("standardAuthEncrypt mac = " + fte.O000000o(str));
        fhe.O000000o(str, bArr, new BleReadResponse() {
            /* class _m_j.fea.AnonymousClass13 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("standardAuthEncrypt mac = " + fte.O000000o(str) + ", code = " + i);
                Bundle bundle = new Bundle();
                bundle.putByteArray("extra.byte.array", (byte[]) obj);
                try {
                    iBleResponse.onResponse(i, bundle);
                } catch (Exception e) {
                    gnk.O000000o(e);
                }
            }
        });
    }

    static void O0000O0o(final String str, byte[] bArr, final IBleResponse iBleResponse) {
        fte.O00000Oo("standardAuthDecrypt mac = " + fte.O000000o(str));
        fhe.O00000Oo(str, bArr, new BleReadResponse() {
            /* class _m_j.fea.AnonymousClass14 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("standardAuthDecrypt mac = " + fte.O000000o(str) + ", code = " + i);
                Bundle bundle = new Bundle();
                bundle.putByteArray("extra.byte.array", (byte[]) obj);
                try {
                    iBleResponse.onResponse(i, bundle);
                } catch (Exception e) {
                    gnk.O000000o(e);
                }
            }
        });
    }

    static void O00000o(String str, UUID uuid, UUID uuid2, IBleResponse iBleResponse) {
        fdx.O000000o(str, uuid, uuid2, iBleResponse);
    }

    static void O00000o0(String str, UUID uuid, UUID uuid2) {
        fdx.O000000o(str, uuid, uuid2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    static void O000000o(final String str, long j, final IBleResponse iBleResponse) {
        final Bundle bundle = new Bundle();
        for (BluetoothSearchResult O000000o2 : gnl.O00000oO()) {
            if (str.equalsIgnoreCase(O000000o2.O000000o())) {
                bundle.putInt("extra.device.status", 16);
                O000000o(bundle, iBleResponse);
                return;
            }
        }
        final gmz O000000o3 = new gmz.O00000Oo().O000000o(1000, (int) (Math.min(Math.max(j, 5000L), 15000L) / 1000)).O000000o();
        gmy.O000000o.f18027O000000o.O000000o(O000000o3, new gna() {
            /* class _m_j.fea.AnonymousClass15 */

            public final void O000000o() {
            }

            public final /* synthetic */ void O000000o(Object obj) {
                BluetoothSearchResult bluetoothSearchResult = (BluetoothSearchResult) obj;
                if (bluetoothSearchResult.O000000o().equalsIgnoreCase(str)) {
                    ffx.O000000o().O000000o(bluetoothSearchResult, 5000);
                    bundle.putInt("extra.device.status", 48);
                    fea.O000000o(bundle, iBleResponse);
                    gmy.O000000o.f18027O000000o.O000000o(O000000o3);
                }
            }

            public final void O00000Oo() {
                if (!bundle.containsKey("extra.device.status")) {
                    bundle.putInt("extra.device.status", 64);
                    fea.O000000o(bundle, iBleResponse);
                }
            }

            public final void O00000o0() {
                if (!bundle.containsKey("extra.device.status")) {
                    bundle.putInt("extra.device.status", 64);
                    fea.O000000o(bundle, iBleResponse);
                }
            }
        });
    }

    static void O000000o(String str, int i, int i2, long j, IBleResponse iBleResponse) {
        fte.O00000Oo("getOneTimePassword mac = " + fte.O000000o(str));
        if (i <= 0 || i > 60) {
            fte.O00000Oo("getOneTimePassword interval illegal");
            O000000o(-1, "interval illegal", (int[]) null, iBleResponse);
        } else if (i2 < 6 || i2 > 8) {
            fte.O00000Oo("getOneTimePassword digits illegal");
            O000000o(-1, "digits illegal", (int[]) null, iBleResponse);
        } else {
            String O00000oo = ffr.O00000oo(str);
            if (TextUtils.isEmpty(O00000oo)) {
                fte.O00000Oo("getOneTimePassword can't find this device did");
                O000000o(-1, "can't find this device did", (int[]) null, iBleResponse);
                return;
            }
            byte[] O0000oO0 = ffr.O0000oO0(str);
            if (got.O00000o(O0000oO0)) {
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                final long j2 = j;
                final IBleResponse iBleResponse2 = iBleResponse;
                fgo.O000000o(O00000oo, new feo<JSONObject, fes>() {
                    /* class _m_j.fea.AnonymousClass16 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        String optString = jSONObject != null ? jSONObject.optString("key") : "";
                        if (!TextUtils.isEmpty(optString)) {
                            ffr.O0000Oo(str2, optString);
                            int optInt = jSONObject.optInt("encrypt_type", 0);
                            if (optInt == 0) {
                                fea.O000000o(got.O000000o(optString), i3, i4, j2, iBleResponse2);
                                return;
                            }
                            String O0000oO = ffr.O0000oO(str2);
                            if (TextUtils.isEmpty(O0000oO)) {
                                fte.O00000Oo("getOneTimePassword pincode is empty");
                                fea.O000000o(-38, "pincode is empty", (int[]) null, iBleResponse2);
                                return;
                            }
                            fea.O000000o(got.O000000o(fll.O00000Oo(O0000oO, optString, optInt)), i3, i4, j2, iBleResponse2);
                            return;
                        }
                        fte.O00000Oo("getOneTimePassword get ltmk failed");
                        fea.O000000o(-1, "get ltmk failed", (int[]) null, iBleResponse2);
                    }

                    public final void O000000o(fes fes) {
                        fte.O00000Oo(String.format("getOneTimePassword %s error: getOwnLtmk failed(%s)", fte.O000000o(str2), fes.O00000Oo));
                        fea.O000000o(-1, "get ltmk failed", (int[]) null, iBleResponse2);
                    }
                });
                return;
            }
            int O0000oOO = ffr.O0000oOO(str);
            if (O0000oOO == 0) {
                O000000o(O0000oO0, i, i2, j, iBleResponse);
                return;
            }
            String O0000oO = ffr.O0000oO(str);
            if (TextUtils.isEmpty(O0000oO)) {
                fte.O00000Oo("getOneTimePassword pincode is empty");
                O000000o(-38, "pincode is empty", (int[]) null, iBleResponse);
                return;
            }
            O000000o(got.O000000o(fll.O00000Oo(O0000oO, got.O00000o0(O0000oO0), O0000oOO)), i, i2, j, iBleResponse);
        }
    }

    public static void O000000o(final byte[] bArr, final int i, final int i2, long j, final IBleResponse iBleResponse) {
        if (j > 0) {
            O000000o(i, i2, bArr, j, iBleResponse);
        } else {
            fgo.O000000o(new feo<Long, fes>() {
                /* class _m_j.fea.AnonymousClass17 */

                public final /* synthetic */ void O000000o(Object obj) {
                    Long l = (Long) obj;
                    if (l == null || l.longValue() == -1) {
                        fea.O000000o(-1, "get utc time failed(1)", (int[]) null, iBleResponse);
                    } else {
                        fea.O000000o(i, i2, bArr, l.longValue(), iBleResponse);
                    }
                }

                public final void O000000o(fes fes) {
                    if (fes != null) {
                        fea.O000000o(-1, fes.O00000Oo, (int[]) null, iBleResponse);
                    } else {
                        fea.O000000o(-1, "get utc time failed", (int[]) null, iBleResponse);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
    public static void O000000o(int i, int i2, byte[] bArr, long j, IBleResponse iBleResponse) {
        byte[] bArr2;
        byte[] bArr3;
        int[] iArr;
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, "mi-lock-otp-salt".getBytes());
            bArr2 = O000000o2.O000000o("mi-lock-otp-info".getBytes(), 32);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            bArr2 = null;
        }
        int i3 = 1;
        if (bArr2 != null) {
            try {
                Mac instance = Mac.getInstance("HmacSHA256");
                instance.init(new SecretKeySpec(bArr2, "HmacSHA256"));
                int i4 = (int) (j / ((long) (i * 60)));
                byte[] bArr4 = new byte[4];
                bArr4[3] = (byte) ((i4 >> 24) & 255);
                bArr4[2] = (byte) ((i4 >> 16) & 255);
                bArr4[1] = (byte) ((i4 >> 8) & 255);
                bArr4[0] = (byte) (i4 & 255);
                bArr3 = instance.doFinal(bArr4);
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
            }
            if (bArr3 == null && bArr3.length == 32) {
                iArr = new int[8];
                for (int i5 = 0; i5 < i2; i5++) {
                    i3 *= 10;
                }
                for (int i6 = 0; i6 < bArr3.length; i6 += 4) {
                    iArr[i6 / 4] = (int) ((((long) ((((bArr3[i6] & 255) | ((bArr3[i6 + 1] & 255) << 8)) | ((bArr3[i6 + 2] & 255) << 16)) | ((bArr3[i6 + 3] & 255) << 24))) & 4294967295L) % ((long) i3));
                }
            } else {
                iArr = null;
            }
            if (iArr != null) {
                fte.O00000Oo("generateOneTimePassword generate failed");
                O000000o(-1, "generate failed", (int[]) null, iBleResponse);
                return;
            }
            O000000o(0, "", iArr, iBleResponse);
            return;
        }
        bArr3 = null;
        if (bArr3 == null) {
        }
        iArr = null;
        if (iArr != null) {
        }
    }

    static void O00000o(String str, final IBleResponse iBleResponse) {
        O000000o(str, new BleResponse<String>() {
            /* class _m_j.fea.AnonymousClass18 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str = (String) obj;
                if (iBleResponse != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("extra.value", str);
                    try {
                        iBleResponse.onResponse(i, bundle);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    static void O00000oO(String str, final IBleResponse iBleResponse) {
        O000000o(str, new BleResponse<String>() {
            /* class _m_j.fea.AnonymousClass19 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str = (String) obj;
                if (iBleResponse != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("extra.value", str);
                    try {
                        iBleResponse.onResponse(i, bundle);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void O000000o(final String str, final BleResponse<String> bleResponse) {
        fte.O00000Oo("getBleMeshFirmwareVersion mac = " + fte.O000000o(str));
        glw.O000000o().read(str, glb.f17954O000000o, glb.O00000oO, new BleReadResponse() {
            /* class _m_j.fea.AnonymousClass20 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                byte[] bArr = (byte[]) obj;
                if (i == 0 && !got.O00000o(bArr)) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < bArr.length && bArr[i2] != 0) {
                        i3++;
                        i2++;
                    }
                    if (i3 != 0) {
                        byte[] bArr2 = new byte[i3];
                        for (int i4 = 0; i4 < i3; i4++) {
                            bArr2[i4] = bArr[i4];
                        }
                        String str = new String(bArr2);
                        fap.O000000o.f16027O000000o.O000000o(str).O00000Oo(str);
                        bleResponse.onResponse(0, str);
                        return;
                    }
                }
                bleResponse.onResponse(-1, "");
            }
        });
    }

    static void O00000oO(String str, UUID uuid, UUID uuid2, final IBleResponse iBleResponse) {
        glw.O000000o().isCharacterExist(str, uuid, uuid2, new BleResponse<Void>() {
            /* class _m_j.fea.AnonymousClass21 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                IBleResponse iBleResponse = iBleResponse;
                if (iBleResponse != null) {
                    try {
                        iBleResponse.onResponse(i, new Bundle());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void O000000o(int i, String str, int[] iArr, IBleResponse iBleResponse) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("extra.message", str);
        }
        if (iArr != null) {
            bundle.putIntArray("extra.int.array", iArr);
        }
        try {
            iBleResponse.onResponse(i, bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Bundle bundle, IBleResponse iBleResponse) {
        try {
            iBleResponse.onResponse(0, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ffr.O000000o(java.lang.String, java.lang.String, boolean):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.ffr.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      _m_j.ffr.O000000o(java.lang.String, java.lang.String, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    public static void O00000o0(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            byte[] O0000o0o = ffr.O0000o0o(str);
            if (!got.O00000o(O0000o0o)) {
                z = fen.O000000o().O000000o(str, O0000o0o);
                if (!z) {
                    ffr.O000000o(str, "key.miui.bind", true);
                    return;
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ffr.O000000o(java.lang.String, java.lang.String, boolean):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.ffr.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      _m_j.ffr.O000000o(java.lang.String, java.lang.String, boolean):void */
    public static void O00000o(String str) {
        if (!TextUtils.isEmpty(str) ? fen.O000000o().O000000o(str) : false) {
            ffr.O000000o(str, "key.miui.bind", false);
        }
    }

    public static void O00000oo(final String str, final IBleResponse iBleResponse) {
        fec.O00000o0().O00000Oo("BluetoothApi", String.format("BluetoothApi.findComboMac subMac = %s", str));
        if (str == null || str.length() != 4) {
            fec.O00000o0().O00000Oo("BluetoothApi", "findComboMac error subMac must 4 char but get ".concat(String.valueOf(str)));
            return;
        }
        String O000000o2 = fee.O000000o(str);
        final Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(O000000o2)) {
            gnk.O00000oO("findComboMac by BluetoothDeviceSearch");
            bundle.putString("extra.mac", O000000o2);
            try {
                iBleResponse.onResponse(0, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            final gmz O000000o3 = new gmz.O00000Oo().O000000o(3000, 5).O000000o();
            gmy.O000000o.f18027O000000o.O000000o(O000000o3, new gna() {
                /* class _m_j.fea.AnonymousClass22 */

                public final void O000000o() {
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    final BluetoothSearchResult bluetoothSearchResult = (BluetoothSearchResult) obj;
                    ffx.O000000o().O000000o(bluetoothSearchResult, new ffy() {
                        /* class _m_j.fea.AnonymousClass22.AnonymousClass1 */

                        public final void O000000o(ffw ffw) {
                            if (!TextUtils.isEmpty(fee.O000000o(str))) {
                                gmy.O000000o.f18027O000000o.O000000o(O000000o3);
                                bundle.putString("extra.mac", bluetoothSearchResult.O000000o());
                                try {
                                    iBleResponse.onResponse(0, bundle);
                                } catch (Exception e) {
                                    fej O00000o0 = fec.O00000o0();
                                    O00000o0.O00000Oo("BluetoothApi", "findComboMac onRecognized" + Log.getStackTraceString(e));
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }

                public final void O00000Oo() {
                    if (!bundle.containsKey("extra.mac")) {
                        try {
                            iBleResponse.onResponse(-1, bundle);
                        } catch (Exception e) {
                            fej O00000o02 = fec.O00000o0();
                            O00000o02.O00000Oo("BluetoothApi", "findComboMac onSearchStopped" + Log.getStackTraceString(e));
                            e.printStackTrace();
                        }
                    }
                }

                public final void O00000o0() {
                    if (!bundle.containsKey("extra.mac")) {
                        try {
                            iBleResponse.onResponse(-1, bundle);
                        } catch (Exception e) {
                            fej O00000o02 = fec.O00000o0();
                            O00000o02.O00000Oo("BluetoothApi", "findComboMac onSearchCanceled" + Log.getStackTraceString(e));
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void O000000o(String str, String str2) {
        fec.O00000o0().O00000o(str, str2);
    }

    public static ArrayList<BtDevice> O00000o() {
        return ffr.O00000Oo();
    }

    public static ArrayList<BtDevice> O00000oO() {
        return ffr.O00000o0();
    }

    public static ArrayList<BtDevice> O00000oo() {
        return ffr.O00000o();
    }

    public static void O00000oO(String str) {
        gnk.O00000o0(String.format("clearDisconnection %s", str));
        f16147O000000o.remove(new fei(str));
        if (gpn.O000000o(f16147O000000o)) {
            O00000Oo.removeMessages(1);
        }
    }

    public static void O0000O0o() {
        gnk.O00000o0(String.format("clearAllDisconnection", new Object[0]));
        f16147O000000o.clear();
        O00000Oo.removeMessages(1);
    }

    static void O000000o(SearchRequest searchRequest, final SearchResponse searchResponse) {
        if (searchRequest == null) {
            fte.O00000Oo("searchBluetoothDevice request is null");
            if (searchResponse != null) {
                try {
                    searchResponse.onSearchCanceled();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            gmz.O00000Oo o00000Oo = new gmz.O00000Oo();
            for (SearchTask next : searchRequest.O00000Oo()) {
                if (next.f6725O000000o == 2) {
                    o00000Oo.O000000o(next.O00000Oo, next.O00000o0);
                } else if (next.f6725O000000o == 1) {
                    o00000Oo.O000000o(next.O00000Oo);
                }
            }
            gmy.O000000o.f18027O000000o.O000000o(o00000Oo.O000000o(), new gna() {
                /* class _m_j.fea.AnonymousClass12 */

                public final /* synthetic */ void O000000o(Object obj) {
                    try {
                        searchResponse.onDeviceFounded(new SearchResult((BluetoothSearchResult) obj));
                    } catch (Exception e) {
                        gnk.O00000Oo(gnk.O00000Oo(e));
                    }
                }

                public final void O000000o() {
                    try {
                        searchResponse.onSearchStarted();
                    } catch (Exception e) {
                        gnk.O00000Oo(gnk.O00000Oo(e));
                    }
                }

                public final void O00000Oo() {
                    try {
                        searchResponse.onSearchStopped();
                    } catch (Exception e) {
                        gnk.O00000Oo(gnk.O00000Oo(e));
                    }
                }

                public final void O00000o0() {
                    try {
                        searchResponse.onSearchCanceled();
                    } catch (Exception e) {
                        gnk.O00000Oo(gnk.O00000Oo(e));
                    }
                }
            });
        }
    }

    static void O00000Oo() {
        fte.O00000Oo("BluetoothApi.disconnectAll");
        glw.O000000o().disconnectAllDevices();
    }
}
