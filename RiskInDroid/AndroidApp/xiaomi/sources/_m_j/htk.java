package _m_j;

import _m_j.gov;
import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class htk {
    private static htk O0000o00;

    /* renamed from: O000000o  reason: collision with root package name */
    Map<String, Boolean> f631O000000o = new HashMap();
    public HashMap<String, String> O00000Oo = new HashMap<>();
    public boolean O00000o = false;
    public List<Device> O00000o0 = new ArrayList();
    public ScanResult O00000oO;
    public htl O00000oo;
    public gov O0000O0o;
    public long O0000OOo = 0;
    public hul<String> O0000Oo = new hul<String>() {
        /* class _m_j.htk.AnonymousClass1 */

        @SuppressLint({"WifiManagerLeak"})
        public final /* synthetic */ void O000000o(Object obj) {
            htk htk = htk.this;
            htk.O00000o = false;
            htk.O000000o(htk.O00000o0);
            htk.this.O00000Oo.remove((String) obj);
            gjn.O000000o().O00000o0();
        }

        public final void O000000o(int i) {
            htk.this.O00000o0();
        }

        public final void O00000Oo(int i) {
            htk.this.O00000o0();
        }
    };
    public String O0000Oo0;
    public Handler O0000OoO = new Handler(Looper.getMainLooper()) {
        /* class _m_j.htk.AnonymousClass2 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
         arg types: [java.lang.String, int]
         candidates:
          org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
        public final void handleMessage(Message message) {
            boolean z = false;
            switch (message.what) {
                case 102:
                    break;
                case 103:
                    gjn.O000000o().O00000o();
                    return;
                case 104:
                    htk htk = htk.this;
                    htk.O000000o(htk.this.O00000o0.get(0), htk.O0000Oo);
                    return;
                case 105:
                    htk htk2 = htk.this;
                    htk2.O000000o(htk2.O00000o0.get(0), htk.this.O0000Oo);
                    return;
                case 106:
                    MiioLocalAPI.O000000o();
                    break;
                case 107:
                    htk htk3 = htk.this;
                    int i = message.arg1;
                    if (htk3.O00000oo != null && (htk3.O00000oo instanceof htm)) {
                        ((htm) htk3.O00000oo).onDeviceConnectionFailure(i);
                        return;
                    } else if (i == -6) {
                        izb.O000000o(gjn.O000000o().O000000o(), gjn.O000000o().O0000o0O(), 0).show();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            Object obj = message.obj;
            htk.this.O0000OoO.removeMessages(102);
            htk.O000000o(" handle message Find Device  size:" + htk.this.O00000o0.size(), new Object[0]);
            if (htk.this.O0000O0o != null) {
                htk.this.O0000O0o.O00000Oo();
            }
            if (htk.this.O00000o0.size() == 0) {
                htk htk4 = htk.this;
                htk4.O00000o = false;
                if (htk4.O00000oo != null) {
                    htk4.O00000oo.onDeviceConnectionFailure();
                    htk4.O00000oo = null;
                } else {
                    Device O00000Oo = gjn.O000000o().O00000Oo(htk4.O00000oO);
                    if (O00000Oo != null) {
                        izb.O000000o(gjn.O000000o().O000000o(), String.format(gjn.O000000o().O0000o00(), O00000Oo.name), 0).show();
                    }
                    gjn.O000000o().O0000Oo0();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("kuailian_result", false);
                    jSONObject.put("reason", "find 0 device");
                    gjn.O000000o().O000000o("EVENT", "kuailian_result", jSONObject.toString(), null);
                } catch (JSONException unused) {
                }
                gsy.O00000o0(LogType.KUAILIAN, "", "kuailian_result false, find 0 device");
                htk htk5 = htk.this;
                if (!TextUtils.isEmpty(gog.O00000Oo(gjn.O000000o().O000000o()))) {
                    htk5.f631O000000o.put(gog.O00000Oo(gjn.O000000o().O000000o()), Boolean.FALSE);
                }
            } else {
                Device device = htk.this.O00000o0.get(0);
                if (device.isBinded()) {
                    htk.O000000o("handle message, device found  and  bind, callback onSuccess", new Object[0]);
                    device.setOwner(true);
                    gjn.O000000o().O000000o(device);
                    gjn.O000000o().O00000Oo(device);
                    gjn.O000000o().O00000o();
                    htk.this.O0000Oo.O000000o(device.did);
                } else {
                    htk.O000000o("handle message, find device but not bind,so start bind device ", new Object[0]);
                    htk htk6 = htk.this;
                    htk6.O000000o(device, htk6.O0000Oo);
                }
                gjn.O000000o().O00000oO();
                gjn.O000000o().O000000o(htk.this.O00000oO);
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isApConnection", false);
                if (htk.this.O00000o0 != null) {
                    z = true;
                }
                jSONObject2.put("isSingleDevice", z);
                jSONObject2.put("device_model", "");
                jSONObject2.put("connection_count", htk.this.O00000o0.size());
                jSONObject2.put("bssid", gog.O00000Oo(gjn.O000000o().O000000o()));
                jSONObject2.put("ssid", gog.O00000o0(gjn.O000000o().O000000o()));
                gjn.O000000o().O000000o("TIME", "get_connection_statistic", Long.toString(currentTimeMillis), jSONObject2.toString());
            } catch (JSONException unused2) {
            }
        }
    };
    public HashMap<String, Integer> O0000Ooo = new HashMap<>();
    private Map<String, Bundle> O0000o0 = new HashMap();

    public interface O000000o {
        void O000000o(String str, String str2, hua<List<Device>, hud> hua);
    }

    public static htk O000000o() {
        if (O0000o00 == null) {
            O0000o00 = new htk();
        }
        return O0000o00;
    }

    public final void O000000o(htl htl, String str, String str2, String str3, O000000o o000000o) {
        O000000o("DeviceFinderscanNewDevice model = ".concat(String.valueOf(str)), new Object[0]);
        if (!this.O00000o) {
            this.O00000o0.clear();
            this.O00000o = true;
            this.O0000Oo0 = str;
            this.O00000oo = htl;
            this.O0000OOo = System.currentTimeMillis();
            this.O0000OoO.sendEmptyMessageDelayed(102, 50000);
            gov gov = this.O0000O0o;
            if (gov != null) {
                gov.O00000Oo();
            }
            this.O0000O0o = new gov();
            final O000000o o000000o2 = o000000o;
            final String str4 = str2;
            final String str5 = str3;
            final htl htl2 = htl;
            this.O0000O0o.O000000o(new gov.O000000o() {
                /* class _m_j.htk.AnonymousClass3 */

                public final void O000000o() {
                    htk.O000000o("DeviceFinderdeviceLooper.getNewDevice", new Object[0]);
                    O000000o o000000o = o000000o2;
                    if (htk.this.O00000oO != null) {
                        String str = htk.this.O00000oO.BSSID;
                    }
                    o000000o.O000000o(str4, str5, new hua<List<Device>, hud>() {
                        /* class _m_j.htk.AnonymousClass3.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            List<Device> list = (List) obj;
                            Object[] objArr = new Object[1];
                            objArr[0] = Integer.valueOf(list != null ? list.size() : 0);
                            htk.O000000o("DeviceFinderdeviceLooper.getNewDevice onSuccess size = %d", objArr);
                            if (list != null) {
                                for (Device device : list) {
                                    htk.O000000o("DeviceFinder" + String.format(">>> name = %s, did = %s, model = %s", device.name, device.did, device.model), new Object[0]);
                                }
                            }
                            int size = htk.this.O00000o0.size();
                            ArrayList arrayList = new ArrayList();
                            for (Device device2 : list) {
                                Device device3 = null;
                                if (device2.model.equalsIgnoreCase(htk.this.O0000Oo0)) {
                                    if (htk.this.O00000o0.size() > 0) {
                                        Iterator<Device> it = htk.this.O00000o0.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                if (it.next().did.equalsIgnoreCase(device2.did)) {
                                                    device3 = device2;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (device3 == null) {
                                        htk.this.O00000o0.add(device2);
                                        device2.scrollTo = true;
                                        device2.isNew = true;
                                        gjn.O000000o().O000000o(device2.did);
                                    }
                                    arrayList.add(device2.did);
                                }
                            }
                            gjn.O000000o().O000000o(arrayList);
                            if (size != htk.this.O00000o0.size()) {
                                Message obtainMessage = htk.this.O0000OoO.obtainMessage();
                                obtainMessage.what = 106;
                                obtainMessage.arg1 = htk.this.O00000o0.size();
                                htk.this.O0000OoO.sendMessage(obtainMessage);
                            }
                        }

                        public final void O000000o(hud hud) {
                            htk.O000000o("DeviceFinder" + String.format("onFailure: %s", hud), new Object[0]);
                            if (htl2 != null && (htl2 instanceof htm)) {
                                ((htm) htl2).onDeviceConnectionFailure(hud.f693O000000o);
                            }
                        }
                    });
                    htk.this.O0000O0o.O00000o0();
                }
            }, 5000);
            this.O0000O0o.O000000o();
        }
    }

    public final int O000000o(String str) {
        Integer remove;
        if (TextUtils.isEmpty(str) || (remove = this.O0000Ooo.remove(str)) == null) {
            return -1;
        }
        return remove.intValue();
    }

    public final void O000000o(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.O0000Ooo.put(str, Integer.valueOf(i));
        }
    }

    public static void O000000o(String str, Object... objArr) {
        gjn.O000000o().O000000o("DeviceFinder", String.format(str, objArr));
    }

    public final boolean O000000o(hto hto, long j, htl htl) {
        if (hto == null) {
            return false;
        }
        if (!O000000o(htl, hto.f644O000000o, hto.O00000Oo, hto.O00000o0, hto.O00000o, j)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("startTime", System.currentTimeMillis());
        bundle.putString("bindKey", hto.O00000o0);
        bundle.putString("did", hto.O00000Oo == null ? "0" : hto.O00000Oo);
        bundle.putString("model", hto.O00000o);
        this.O0000o0.put(hto.O00000oO, bundle);
        return true;
    }

    public final boolean O000000o(htl htl, String str, String str2, String str3, String str4, long j) {
        O000000o("scanNewDevice did = " + str2 + " model = " + str4 + " bindkey = " + str3, new Object[0]);
        if (this.O00000o) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            this.O0000Ooo.remove(str);
        }
        this.O00000o0.clear();
        this.O00000o = true;
        this.O00000oo = htl;
        this.O0000OOo = System.currentTimeMillis();
        Message message = new Message();
        message.what = 102;
        message.obj = str2 == null ? "0" : str2;
        this.O0000OoO.sendMessageDelayed(message, j);
        gov gov = this.O0000O0o;
        if (gov != null) {
            gov.O00000Oo();
        }
        this.O0000O0o = new gov();
        final String str5 = str;
        final String str6 = str3;
        final String str7 = str2;
        final String str8 = str4;
        this.O0000O0o.O000000o(new gov.O000000o() {
            /* class _m_j.htk.AnonymousClass4 */

            public final void O000000o() {
                String str;
                String str2 = str5;
                String str3 = str6;
                String O0000Oo = gjn.O000000o().O0000Oo();
                String O0000OoO = gjn.O000000o().O0000OoO();
                gjn.O000000o().O000000o(gjn.O000000o().O000000o(), str7, !TextUtils.isEmpty(str7), str2, O0000Oo, O0000OoO, str3, str8, new hua<List<Device>, hud>() {
                    /* class _m_j.htk.AnonymousClass4.AnonymousClass1 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        List<Device> list = (List) obj;
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
                        htk.O000000o(" getNewDevice onSuccess, resulit size %d", objArr);
                        if (list != null && !list.isEmpty()) {
                            for (Device device : list) {
                                htk.O000000o(" getNewDevice onSuccess, device model %s ,did =%s", device.model, device.did);
                            }
                        }
                        int size = htk.this.O00000o0.size();
                        for (Device device2 : list) {
                            Device device3 = null;
                            if (htk.this.O00000o0.size() > 0) {
                                Iterator<Device> it = htk.this.O00000o0.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().did.equalsIgnoreCase(device2.did)) {
                                            htk.O000000o(" find device " + device2.toString(), new Object[0]);
                                            device3 = device2;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            if (device3 == null) {
                                htk.this.O00000o0.add(device2);
                                device2.scrollTo = true;
                                device2.isNew = true;
                            }
                            gjn.O000000o().O000000o(device2.did);
                        }
                        gjn.O000000o().O00000Oo(htk.this.O00000o0);
                        if (size != htk.this.O00000o0.size()) {
                            if (!TextUtils.isEmpty(str5)) {
                                htk.this.O0000Ooo.remove(str5);
                            }
                            htk.O000000o("getNewDevice,after check,found device success", new Object[0]);
                            Message obtainMessage = htk.this.O0000OoO.obtainMessage();
                            if (htk.this.O00000o0 != null) {
                                obtainMessage.what = 106;
                            } else {
                                obtainMessage.what = 103;
                            }
                            obtainMessage.arg1 = htk.this.O00000o0.size();
                            obtainMessage.obj = str7 == null ? "0" : str7;
                            htk.this.O0000OoO.sendMessage(obtainMessage);
                        }
                    }

                    public final void O000000o(hud hud) {
                        htk.O000000o(" getNewDevice onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                        if (hud.f693O000000o == -6) {
                            Message obtainMessage = htk.this.O0000OoO.obtainMessage();
                            obtainMessage.what = 107;
                            obtainMessage.arg1 = hud.f693O000000o;
                            htk.this.O0000OoO.sendMessage(obtainMessage);
                        }
                    }
                });
                htk htk = htk.this;
                String str4 = str7;
                if (TextUtils.isEmpty(str4)) {
                    str = "";
                } else {
                    str = htk.O00000Oo.get(str4);
                }
                if (!gjq.O0000o00()) {
                    htk.O000000o(" phone has not connect the select wifi!", new Object[0]);
                } else if (gjn.O000000o().O00000o(str8) && !TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str)) {
                    htk.O000000o(" getLocalDeviceListAll start.", new Object[0]);
                    gjn.O000000o().O000000o(str7, (hua<List<Device>, hud>) new hua<List<Device>, hud>() {
                        /* class _m_j.htk.AnonymousClass4.AnonymousClass2 */

                        public final void O000000o(hud hud) {
                        }

                        public final /* synthetic */ void O000000o(Object obj) {
                            for (Device device : (List) obj) {
                                if (device != null && str7.equalsIgnoreCase(device.getDid())) {
                                    htk.O000000o(" router contains the config device.", new Object[0]);
                                }
                            }
                        }
                    });
                }
                htk.this.O0000O0o.O00000o0();
            }
        }, 5000);
        this.O0000O0o.O000000o();
        return true;
    }

    public final void O00000Oo() {
        if (this.O00000o) {
            this.O00000o = false;
            this.O0000OoO.removeMessages(102);
            MiioLocalAPI.O000000o();
            this.O0000O0o.O00000Oo();
        }
    }

    public final void O000000o(hto hto) {
        Bundle remove;
        if (this.O00000o) {
            this.O00000o = false;
            this.O0000OoO.removeMessages(102);
            MiioLocalAPI.O000000o();
            this.O0000O0o.O00000Oo();
        }
        if (hto != null && (remove = this.O0000o0.remove(hto.O00000oO)) != null && remove.containsKey("startTime")) {
            long j = remove.getLong("startTime");
            String string = remove.getString("model");
            String string2 = remove.getString("did");
            String O00000Oo2 = gjn.O000000o().O00000Oo();
            long currentTimeMillis = System.currentTimeMillis();
            String string3 = remove.getString("bindKey");
            O000000o(" stopScanNewDevice4Timeout：poll wifi device timeout, startTime=%s,endTime=%s,model=%s,uid=%s,did=%s,bindKey=%s", String.valueOf(j), String.valueOf(currentTimeMillis), string, O00000Oo2, string2, string3);
            gjn.O000000o().O000000o(j, currentTimeMillis, string, O00000Oo2, string2, string3);
        }
    }

    public final void O000000o(final Device device, final hul<String> hul) {
        if (gjn.O000000o().O00000o0(device)) {
            O000000o(" startBindDevice,but device is Camera Device,return ", new Object[0]);
        } else if (this.O00000Oo.containsKey(device.did)) {
            device.token = this.O00000Oo.get(device.did);
            O00000Oo(device, null);
        } else {
            O000000o(" startBindDevice, but cannot find token with  did, so start fetchTokenByIp ", new Object[0]);
            gjn.O000000o().O00000Oo(device.ip, new hua<String, hud>() {
                /* class _m_j.htk.AnonymousClass5 */

                public final /* synthetic */ void O000000o(Object obj) {
                    device.token = (String) obj;
                    htk.O000000o(" startBindDevice, fetch token success", new Object[0]);
                    htk.this.O00000Oo(device, hul);
                }

                public final void O000000o(hud hud) {
                    gjn.O000000o().O000000o("TIME", "fetch_token_error", null, null);
                    htk.O000000o(" startBindDevice,fetch token fail", new Object[0]);
                    hul.O000000o(-1);
                }
            });
        }
    }

    public final void O00000Oo(final Device device, hul<String> hul) {
        if (gjn.O000000o().O00000o0(device) && hul != null) {
            hul.O000000o(-1);
        }
        O000000o(" bindDevice by MiioManager", new Object[0]);
        gjn.O000000o().O000000o(device, new hua<Integer, hud>() {
            /* class _m_j.htk.AnonymousClass6 */

            public final /* synthetic */ void O000000o(Object obj) {
                Integer num = (Integer) obj;
                if (num.intValue() == 1) {
                    htk.O000000o("DeviceFinder bindDevice success", new Object[0]);
                    device.setOwner(true);
                    htk.this.O0000Oo.O000000o(device.did);
                    gjn.O000000o().O000000o(device);
                    return;
                }
                htk.O000000o(" bindDevice fail,code %d", Integer.valueOf(num.intValue()));
                htk.this.O0000Oo.O000000o(-1);
            }

            public final void O000000o(hud hud) {
                htk.O000000o(" bindDevice onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                htk.this.O00000o0();
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public final void O00000o0() {
        O000000o(" handleBindingError,but config complete", new Object[0]);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("kuailian_result", false);
            jSONObject.put("reason", "network bind error");
            gjn.O000000o().O000000o("EVENT", "kuailian_result", jSONObject.toString(), null);
        } catch (JSONException unused) {
        }
        gsy.O00000o0(LogType.GENERAL, "", "kuailian_result false, network bind error");
        O000000o(this.O00000o0);
        this.O00000o = false;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(List<Device> list) {
        List<Device> list2 = this.O00000o0;
        if (list2 == null || list2.size() == 0) {
            htl htl = this.O00000oo;
            if (htl != null) {
                htl.onDeviceConnectionSuccess(this.O00000o0);
                this.O00000oo = null;
                return;
            }
            return;
        }
        gjn.O000000o().O000000o("connected_device", this.O00000o0.get(0));
        if (list != null && list.size() > 0) {
            gjn.O000000o().O00000Oo(list.get(0));
        }
        htl htl2 = this.O00000oo;
        if (htl2 != null) {
            htl2.onDeviceConnectionSuccess(this.O00000o0);
            this.O00000oo = null;
            return;
        }
        izb.O000000o(gjn.O000000o().O000000o(), String.format(gjn.O000000o().O0000o0(), this.O00000o0.get(0).name), 0).show();
        gjn.O000000o().O0000Oo0();
    }

    public final void O000000o(String str, String str2) {
        this.O00000Oo.put(str, str2);
    }

    public final void O00000o() {
        this.O0000OOo = 0;
        this.O00000oO = null;
        gjn.O000000o().O00000oo();
    }

    public static String O00000oO() {
        return gjn.O000000o().O0000O0o();
    }

    public static void O00000Oo(String str) {
        gjn.O000000o().O000000o(str);
    }
}
