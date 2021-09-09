package com.xiaomi.smarthome.smartconfig;

import _m_j.fjd;
import _m_j.fmy;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miui.FindDeviceDialogActivity;
import com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity;
import com.xiaomi.smarthome.smartconfig.DevicePushBindManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum DevicePushBindManager implements fno.O000000o {
    instance;
    
    private static final String[] HANNTO_PRINTER_MODEL = {"hannto.printer.honey", "hannto.printer.honey1s"};
    private Map<String, PushBindEntity> cacheDevice = new HashMap();
    private Map<String, PushBindEntity> hideCacheDevice = new HashMap();
    private boolean isCanHidePop = true;
    private boolean isCanPop = true;
    private List<O00000Oo> mListener = new ArrayList();
    private List<O000000o> mScanCompletedListener = new ArrayList();
    public int mStateSearch = 0;

    public interface O000000o {
    }

    public interface O00000Oo {
        void O000000o(String str, PushBindEntity pushBindEntity);

        void O00000Oo(String str, PushBindEntity pushBindEntity);
    }

    public final void onRefreshClientDeviceChanged(int i, Device device) {
    }

    public final void onRefreshClientDeviceFailed(int i) {
    }

    private void initConfig() {
        if (this.mStateSearch == -1) {
            Iterator<Device> it = fjd.O000000o().O00000Oo().iterator();
            while (it.hasNext()) {
                Device next = it.next();
                if (next != null && next.isOnline() && next.isOwner() && DeviceFactory.O0000O0o(next.getModel())) {
                    gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "onRefreshClientDeviceSuccess match1:".concat(String.valueOf(next)));
                    boolean z = this.mStateSearch == 2;
                    this.mStateSearch = 1;
                    if (z) {
                        checkDeviceWifi();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void onRefreshClientDeviceSuccess(int i) {
        ArrayList<Device> O00000Oo2 = fjd.O000000o().O00000Oo();
        fno.O000000o().O00000Oo(this);
        Iterator<Device> it = O00000Oo2.iterator();
        while (it.hasNext()) {
            Device next = it.next();
            if (next != null && next.isOnline() && next.isOwner() && DeviceFactory.O0000O0o(next.getModel())) {
                gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "onRefreshClientDeviceSuccess match2:".concat(String.valueOf(next)));
                boolean z = this.mStateSearch == 2;
                this.mStateSearch = 1;
                if (z) {
                    checkDeviceWifi();
                    return;
                }
                return;
            }
        }
        this.mStateSearch = -1;
        gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "onRefreshClientDeviceSuccess no aiot router");
    }

    public final void checkDeviceWifi() {
        int i = this.mStateSearch;
        if (i == 0) {
            this.mStateSearch = 2;
        } else if (i == 1) {
            this.mStateSearch = 3;
            CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.smartconfig.DevicePushBindManager.AnonymousClass1 */

                public final void onCoreReady() {
                    DevicePushBindManager.this.getConfigDevices();
                }
            });
        }
    }

    public final void resetPopStatus() {
        this.isCanHidePop = true;
        this.isCanPop = true;
    }

    public final void getIotDevices() {
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/aiot/get_iot_devices").O000000o(new ArrayList()).O000000o(), $$Lambda$DevicePushBindManager$DSXrvQgGIvuDK3l4EKvL5yPPJ1g.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.smartconfig.DevicePushBindManager.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "getIotDevices onSuccess:");
                CommonApplication.getGlobalWorkerHandler().post(new Runnable((JSONObject) obj) {
                    /* class com.xiaomi.smarthome.smartconfig.$$Lambda$DevicePushBindManager$2$hwzXBRz7xSTW_5SqxFE3917vofw */
                    private final /* synthetic */ JSONObject f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DevicePushBindManager.AnonymousClass2.this.O000000o(this.f$1);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(JSONObject jSONObject) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("result");
                    JSONObject[] jSONObjectArr = null;
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        jSONObjectArr = new JSONObject[optJSONArray.length()];
                        for (int i = 0; i < jSONObjectArr.length; i++) {
                            jSONObjectArr[i] = optJSONArray.optJSONObject(i);
                        }
                    }
                    DevicePushBindManager.this.notifyFindDevice(false, jSONObjectArr);
                } catch (Exception e) {
                    LogType logType = LogType.KUAILIAN;
                    gsy.O00000o0(logType, "DevicePushBindManager", "checkDeviceWifi onSuccess But parse json Exception " + e.getLocalizedMessage());
                }
                DevicePushBindManager.this.dispatchScanCompletedListener();
                O000000o();
            }

            public final void onFailure(fso fso) {
                if (fso != null) {
                    LogType logType = LogType.KUAILIAN;
                    gsy.O00000o0(logType, "DevicePushBindManager", "checkDeviceWifi onFailure: " + fso.toString());
                }
                DevicePushBindManager.this.dispatchScanCompletedListener();
                O000000o();
            }

            private void O000000o() {
                if (DevicePushBindManager.this.mStateSearch == 3) {
                    DevicePushBindManager.this.mStateSearch = 1;
                }
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
    public final void getConfigDevices() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("showNotShake", true);
        } catch (JSONException e) {
            e.printStackTrace();
            gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "getConfigDevices JSONException");
        }
        KeyValuePair keyValuePair = new KeyValuePair("data", jSONObject.toString());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(keyValuePair);
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/router/config_devices").O000000o(arrayList).O000000o(), $$Lambda$DevicePushBindManager$1LwVqhSUehLhRHeqXQHkUwbhLI4.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.smartconfig.DevicePushBindManager.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "getConfigDevices onSuccess:");
                CommonApplication.getGlobalWorkerHandler().post(new Runnable((JSONObject) obj) {
                    /* class com.xiaomi.smarthome.smartconfig.$$Lambda$DevicePushBindManager$3$owOo1zlQtNVcD33GJkzXsSO5EdA */
                    private final /* synthetic */ JSONObject f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DevicePushBindManager.AnonymousClass3.this.O000000o(this.f$1);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(JSONObject jSONObject) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("devices");
                    JSONObject[] jSONObjectArr = null;
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        jSONObjectArr = new JSONObject[optJSONArray.length()];
                        for (int i = 0; i < jSONObjectArr.length; i++) {
                            jSONObjectArr[i] = optJSONArray.optJSONObject(i);
                        }
                    }
                    DevicePushBindManager.this.notifyFindDevice(true, jSONObjectArr);
                    DevicePushBindManager.this.getIotDevices();
                } catch (Exception e) {
                    LogType logType = LogType.KUAILIAN;
                    gsy.O00000o0(logType, "DevicePushBindManager", "getConfigDevices Success But parse json Exception " + e.getLocalizedMessage());
                }
            }

            public final void onFailure(fso fso) {
                if (fso != null) {
                    LogType logType = LogType.KUAILIAN;
                    gsy.O00000o0(logType, "DevicePushBindManager", "getConfigDevices onFailure: " + fso.toString());
                }
                DevicePushBindManager.this.getIotDevices();
            }
        });
    }

    public static boolean isHanntoPrinter(String str) {
        for (String equals : HANNTO_PRINTER_MODEL) {
            if (TextUtils.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    public final void notifyFindDevice(boolean z, JSONObject... jSONObjectArr) {
        HashMap hashMap = new HashMap();
        if (jSONObjectArr == null) {
            notifyFindChange(z, hashMap);
            gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "notifyFindDevice no data");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = CommonApplication.getAppContext().getSharedPreferences("DevicePushBindManager", 0).getStringSet("black_list", null);
        for (JSONObject O000000o2 : jSONObjectArr) {
            PushBindEntity O000000o3 = PushBindEntity.O000000o(O000000o2, z);
            if (O000000o3 != null && ((stringSet == null || !stringSet.contains(O000000o3.O00000o)) && !isHanntoPrinter(O000000o3.f11457O000000o.O00000Oo()))) {
                O000000o3.O0000OoO = z;
                hashMap.put(O000000o3.O00000o, O000000o3);
                gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "add pushBindEntity:");
            }
        }
        notifyFindChange(z, hashMap);
        Map<String, PushBindEntity> map = z ? this.hideCacheDevice : this.cacheDevice;
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            PushBindEntity pushBindEntity = (PushBindEntity) map.get(str);
            if (pushBindEntity == null) {
                PushBindEntity pushBindEntity2 = (PushBindEntity) entry.getValue();
                map.put(str, pushBindEntity2);
                arrayList.add(pushBindEntity2);
                dispatchListener(true, str, pushBindEntity2);
            } else {
                if (fmy.O00000o0().O00000o(DeviceFactory.O00000o0(pushBindEntity.O00000o, pushBindEntity.O00000o0)) || !pushBindEntity.O00000oO() || pushBindEntity.O00000o()) {
                    gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "isInIgnoredComboKeyList:" + pushBindEntity.O0000OOo);
                } else {
                    PushBindEntity pushBindEntity3 = (PushBindEntity) entry.getValue();
                    if (pushBindEntity.O00000o0()) {
                        pushBindEntity3.O000000o();
                    }
                    map.put(str, pushBindEntity3);
                    arrayList.add(pushBindEntity3);
                }
            }
        }
        startFindDevice(arrayList);
        gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "notifyFindDevice entities:");
    }

    private void notifyFindChange(boolean z, Map<String, PushBindEntity> map) {
        for (Map.Entry entry : (z ? this.hideCacheDevice : this.cacheDevice).entrySet()) {
            String str = (String) entry.getKey();
            PushBindEntity pushBindEntity = (PushBindEntity) entry.getValue();
            boolean containsKey = map.containsKey(str);
            if ((containsKey && !pushBindEntity.O00000oO()) || (!containsKey && pushBindEntity.O00000oO())) {
                pushBindEntity.O000000o(containsKey);
                LogType logType = LogType.KUAILIAN;
                gsy.O00000o0(logType, "DevicePushBindManager", "notifyFindChange value.isFind():  " + pushBindEntity.O00000oO());
                dispatchListener(containsKey, str, pushBindEntity);
            }
        }
    }

    private void dispatchListener(boolean z, String str, PushBindEntity pushBindEntity) {
        if (pushBindEntity == null) {
            gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "dispatchListener bssid is null,".concat(String.valueOf(str)));
            return;
        }
        gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "dispatchListener bssid:" + str + " find:" + z);
        for (int size = this.mListener.size() + -1; size >= 0; size--) {
            if (z) {
                this.mListener.get(size).O000000o(str.toUpperCase(Locale.ENGLISH), pushBindEntity);
            } else {
                this.mListener.get(size).O00000Oo(str.toUpperCase(Locale.ENGLISH), pushBindEntity);
            }
        }
    }

    public final void dispatchScanCompletedListener() {
        for (int size = this.mScanCompletedListener.size() - 1; size >= 0; size--) {
            this.mScanCompletedListener.get(size);
        }
    }

    private void startFindDevice(ArrayList<PushBindEntity> arrayList) {
        if (FindDeviceDialogActivity.sResumed) {
            gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "FindDeviceDialogActivity sResumed");
        } else if (NFCDeviceDialogActivity.sResumed) {
            gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "NFCDeviceDialogActivity sResumed");
        } else {
            CommonApplication application = CommonApplication.getApplication();
            gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "startFindActivity appForeground:" + ChooseDeviceActivity.mIsActivityResumed);
            if (!ChooseDeviceActivity.mIsActivityResumed || !ChooseDeviceActivity.isShowManually) {
                gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "receive push background json:");
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                PushBindEntity pushBindEntity = arrayList.get(size);
                if (fmy.O00000o0().O00000o(DeviceFactory.O00000o0(pushBindEntity.O00000o, pushBindEntity.O00000o0)) || !pushBindEntity.O00000oO() || pushBindEntity.O00000o()) {
                    arrayList.remove(size);
                    gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "startFindDevice not show:" + pushBindEntity.O0000OOo);
                }
            }
            if (arrayList.size() <= 0 || (!arrayList.get(0).O0000OoO ? !this.isCanPop : !this.isCanHidePop)) {
                gsy.O00000o0(LogType.KUAILIAN, "DevicePushBindManager", "receive push all showed:" + arrayList.size());
                return;
            }
            setShowStatus(arrayList.get(0).O0000OoO);
            if (arrayList.get(0).O0000OoO) {
                this.isCanHidePop = false;
            } else {
                this.isCanPop = false;
            }
            Intent intent = new Intent(CommonApplication.getAppContext(), FindDeviceDialogActivity.class);
            intent.addFlags(536870912);
            intent.addFlags(4194304);
            intent.addFlags(268435456);
            intent.putParcelableArrayListExtra("bind_aiot_wifi", arrayList);
            intent.putExtra("strategy_id", arrayList.get(0).O0000OoO ? 17 : 16);
            application.startActivity(intent);
        }
    }

    public final void setShowStatus(boolean z) {
        for (Map.Entry value : (z ? this.hideCacheDevice : this.cacheDevice).entrySet()) {
            ((PushBindEntity) value.getValue()).O000000o();
        }
    }

    public final void bind(String str) {
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            PushBindEntity pushBindEntity = this.cacheDevice.get(lowerCase);
            if (pushBindEntity == null) {
                pushBindEntity = this.cacheDevice.get(upperCase);
            }
            if (pushBindEntity != null) {
                pushBindEntity.O00000Oo();
            }
            PushBindEntity pushBindEntity2 = this.hideCacheDevice.get(lowerCase);
            PushBindEntity pushBindEntity3 = pushBindEntity2 == null ? this.hideCacheDevice.get(upperCase) : pushBindEntity2;
            if (pushBindEntity3 != null) {
                pushBindEntity3.O00000Oo();
            }
            if (pushBindEntity != null) {
                pushBindEntity3 = pushBindEntity;
            }
            dispatchListener(false, lowerCase, pushBindEntity3);
        }
    }

    public final void clear() {
        this.cacheDevice.clear();
        this.hideCacheDevice.clear();
    }

    public final Map<String, PushBindEntity> getCache(boolean z) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : (z ? this.hideCacheDevice : this.cacheDevice).entrySet()) {
            if (!((PushBindEntity) entry.getValue()).O00000o() && ((PushBindEntity) entry.getValue()).O00000oO()) {
                hashMap.put(((String) entry.getKey()).toUpperCase(Locale.ENGLISH), entry.getValue());
            }
        }
        return hashMap;
    }

    public final void registScanListener(O00000Oo o00000Oo) {
        if (o00000Oo != null && !this.mListener.contains(o00000Oo)) {
            this.mListener.add(o00000Oo);
        }
    }

    public final void unregistScanListener(O00000Oo o00000Oo) {
        this.mListener.remove(o00000Oo);
    }

    public final void registScanCompletedListener(O000000o o000000o) {
        if (o000000o != null && !this.mScanCompletedListener.contains(o000000o)) {
            this.mScanCompletedListener.add(o000000o);
        }
    }

    public final void unregistScanCompletedListener(O000000o o000000o) {
        this.mScanCompletedListener.remove(o000000o);
    }

    public final void addBlackList(final PushBindEntity pushBindEntity) {
        if (pushBindEntity != null) {
            CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.smartconfig.DevicePushBindManager.AnonymousClass4 */

                public final void run() {
                    SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("DevicePushBindManager", 0);
                    Set stringSet = sharedPreferences.getStringSet("black_list", null);
                    if (stringSet == null) {
                        stringSet = new HashSet();
                    }
                    stringSet.add(pushBindEntity.O00000o);
                    sharedPreferences.edit().putStringSet("black_list", stringSet).apply();
                }
            });
        }
    }
}
