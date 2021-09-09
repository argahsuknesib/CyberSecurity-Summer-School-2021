package _m_j;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class gfx {
    private static int O00000o = 8;
    private static volatile gfx O00000o0;
    private static final String[] O00000oO = {"小米", "米家", "米兔", "小蚁", "青米", "飞利浦", "Yeelight", "智米", "90分", "美的", "奥克斯", "金兴", "iHealth", "小吉", "云米", "Aqara", "素士", "创米", "夏洛克"};

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, List<String>> f17665O000000o = new ConcurrentHashMap();
    boolean O00000Oo = true;
    private boolean O00000oo;
    private AtomicBoolean O0000O0o = new AtomicBoolean(false);
    private boolean O0000OOo = true;

    private gfx() {
    }

    private void O00000oO() {
        if (this.O0000O0o.compareAndSet(false, true)) {
            ggr ggr = ggr.f17748O000000o;
            for (ggo next : ggr.O000000o()) {
                List list = this.f17665O000000o.get(next.f17746O000000o);
                ArrayList<String> arrayList = next.O00000o0.f17745O000000o;
                if (!arrayList.isEmpty() && ((arrayList.size() != 1 || !TextUtils.equals("-", arrayList.get(0))) && (list == null || list.isEmpty()))) {
                    this.f17665O000000o.put(next.f17746O000000o, new ArrayList(arrayList));
                }
            }
        }
    }

    public static gfx O000000o() {
        if (O00000o0 == null) {
            synchronized (gfx.class) {
                if (O00000o0 == null) {
                    O00000o0 = new gfx();
                }
            }
        }
        return O00000o0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
      _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
      _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
    public final boolean O00000Oo() {
        if (this.O0000OOo) {
            this.O0000OOo = gpv.O000000o("mFreqCameraRedDotVisiable", true);
        }
        return this.O0000OOo;
    }

    public final void O000000o(boolean z) {
        if (this.O0000OOo != z) {
            gpv.O00000o0(CommonApplication.getAppContext(), "mFreqCameraRedDotVisiable", z);
        }
        this.O0000OOo = z;
    }

    public static void O00000o0() {
        O00000o0 = null;
    }

    private boolean O00000oo() {
        if (this.O00000Oo && !TextUtils.equals(CoreApi.O000000o().O0000o0(), "0")) {
            SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences("sp_common_use_device_data_manager", 0);
            this.O00000oo = gpv.O000000o(sharedPreferences, "sp_key_ir_common_use" + CoreApi.O000000o().O0000o0());
            this.O00000Oo = false;
        }
        return this.O00000oo;
    }

    private void O00000Oo(boolean z) {
        this.O00000oo = z;
        if (fqw.O00000Oo() != null) {
            fqw.O00000Oo().freqFlag = z;
        }
        SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences("sp_common_use_device_data_manager", 0);
        gpv.O000000o(sharedPreferences, "sp_key_ir_common_use" + CoreApi.O000000o().O0000o0(), z);
    }

    public static List<GridViewData> O000000o(String str) {
        gsy.O00000o0(LogType.HOME_ROOM, "CommonUseDeviceDataManager", "getCommonUseDevicesByHomeId homeid == ".concat(String.valueOf(str)));
        List<GridViewData> O00000o02 = O00000o0(str);
        LogType logType = LogType.HOME_ROOM;
        gsy.O00000o0(logType, "CommonUseDeviceDataManager", "getCommonUseDevicesByHomeId allDevicesByHomeId size == " + O00000o02.size());
        Iterator<GridViewData> it = O00000o02.iterator();
        while (it.hasNext()) {
            Device device = it.next().O00000Oo;
            if (device == null) {
                it.remove();
            } else if (!device.freqFlag) {
                it.remove();
            }
        }
        LogType logType2 = LogType.HOME_ROOM;
        gsy.O00000o0(logType2, "CommonUseDeviceDataManager", "getCommonUseDevicesByHomeId commonDevicesByHomeId == " + Arrays.deepToString(O00000o02.toArray()));
        return O00000o02;
    }

    public static List<GridViewData> O00000Oo(String str) {
        List<GridViewData> O00000o02 = O00000o0(str);
        Iterator<GridViewData> it = O00000o02.iterator();
        while (it.hasNext()) {
            Device device = it.next().O00000Oo;
            if (device == null) {
                it.remove();
            } else if (device.freqFlag) {
                it.remove();
            }
        }
        return O00000o02;
    }

    public static List<GridViewData> O00000o0(String str) {
        Home O00000o2 = ggb.O00000Oo().O00000o(str);
        if (O00000o2 == null) {
            gsy.O00000o0(LogType.HOME_ROOM, "CommonUseDeviceDataManager", "getAllDevices home == null");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(ggb.O00000Oo().O000000o(str, new boolean[0]));
        int size = arrayList.size();
        gsy.O00000o0(LogType.HOME_ROOM, "CommonUseDeviceDataManager", "getAllDevices getHomeDids size=".concat(String.valueOf(size)));
        if (O00000o2.isOwner()) {
            gge.O000000o();
            List<String> O00000oo2 = gge.O00000oo();
            if (!O00000oo2.isEmpty()) {
                arrayList.addAll(O00000oo2);
            }
            LogType logType = LogType.HOME_ROOM;
            gsy.O00000o0(logType, "CommonUseDeviceDataManager", "getAllDevices getShareDidList size=" + (arrayList.size() - size));
        }
        List<Device> list = gge.O000000o().O00000Oo;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Device device = list.get(i);
                if (device != null) {
                    arrayList.add(device.did);
                }
            }
        }
        LogType logType2 = LogType.HOME_ROOM;
        gsy.O00000o0(logType2, "CommonUseDeviceDataManager", "getAllDevices alldid include virtual device size=" + arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        String O0000o0o = fno.O000000o().O0000o0o();
        if (!TextUtils.isEmpty(O0000o0o)) {
            arrayList2.add(O0000o0o);
        }
        LogType logType3 = LogType.HOME_ROOM;
        gsy.O00000Oo(logType3, "CommonUseDeviceDataManager", "getAllDevices newDids: " + Arrays.deepToString(arrayList2.toArray()));
        HashSet hashSet = new HashSet(arrayList);
        LinkedHashSet linkedHashSet = new LinkedHashSet(arrayList.size() * 2, 0.75f);
        linkedHashSet.addAll(arrayList2);
        linkedHashSet.addAll(arrayList);
        LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet.size() * 2, 0.75f);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!TextUtils.isEmpty(str2) && !linkedHashSet2.contains(str2) && hashSet.contains(str2)) {
                linkedHashSet2.add(str2);
            } else if (TextUtils.equals("com.xiaomi.smarthome.common_use.ir_did", str2)) {
                linkedHashSet2.add(str2);
            } else {
                Device O000000o2 = fno.O000000o().O000000o(str2);
                if (O000000o2 != null && ggd.O000000o(O000000o2.model)) {
                    linkedHashSet2.add(str2);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        boolean z = false;
        for (String str3 : linkedHashSet2) {
            Device O000000o3 = fno.O000000o().O000000o(str3);
            if (O000000o3 != null) {
                GridViewData gridViewData = new GridViewData();
                gridViewData.O00000Oo = O000000o3;
                if (fqw.O000000o(str3)) {
                    gridViewData.f8988O000000o = GridViewData.GridType.TYPE_IR;
                    gridViewData.O00000Oo = O0000O0o();
                    z = true;
                } else {
                    gridViewData.f8988O000000o = GridViewData.GridType.TYPE_NORMAL;
                }
                gridViewData.O00000o0 = O00000o(gridViewData.O00000Oo.getName());
                arrayList3.add(gridViewData);
            } else if (TextUtils.equals(str3, "com.xiaomi.smarthome.common_use.ir_did") && !z && fqw.O00000o0()) {
                GridViewData gridViewData2 = new GridViewData();
                gridViewData2.f8988O000000o = GridViewData.GridType.TYPE_IR;
                gridViewData2.O00000Oo = O0000O0o();
                arrayList3.add(gridViewData2);
                z = true;
            }
        }
        if (!z && fqw.O00000o0()) {
            GridViewData gridViewData3 = new GridViewData();
            gridViewData3.f8988O000000o = GridViewData.GridType.TYPE_IR;
            gridViewData3.O00000Oo = O0000O0o();
            arrayList3.add(0, gridViewData3);
        }
        LogType logType4 = LogType.HOME_ROOM;
        gsy.O00000o0(logType4, "CommonUseDeviceDataManager", "getAllDevices return size=" + arrayList3.size());
        ggv.O000000o(O000000o().O00000oO(O00000o2.getId()), arrayList3);
        if (gfr.O0000o00 || gfr.O0000Ooo) {
            LogType logType5 = LogType.HOME_ROOM;
            gsy.O00000o0(logType5, "CommonUseDeviceDataManager", "getAllDevices return did=" + Arrays.toString(arrayList3.toArray()));
        }
        return arrayList3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gfx.O000000o(java.util.List<java.lang.String>, boolean):void
     arg types: [java.util.List<java.lang.String>, int]
     candidates:
      _m_j.gfx.O000000o(java.lang.String, boolean):void
      _m_j.gfx.O000000o(java.util.List<java.lang.String>, com.xiaomi.smarthome.homeroom.model.Home):void
      _m_j.gfx.O000000o(java.util.List<java.lang.String>, _m_j.fsm<org.json.JSONObject, _m_j.fso>[]):void
      _m_j.gfx.O000000o(java.util.List<java.lang.String>, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fru.O000000o(java.util.List<java.lang.String>, boolean, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
     arg types: [java.util.List<java.lang.String>, int, _m_j.gfx$1]
     candidates:
      _m_j.fru.O000000o(android.content.Context, long, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(android.content.Context, org.json.JSONObject, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(long, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(android.content.Context, java.lang.String, _m_j.fsm<java.lang.String, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(android.content.Context, java.util.ArrayList<java.lang.String>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(android.content.Context, java.util.Map<java.lang.String, java.lang.Long>, _m_j.fsm<org.json.JSONArray, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(java.lang.String, java.util.List<java.lang.String>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(java.util.List<java.lang.String>, boolean, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn */
    public final void O000000o(final List<String> list, final fsm<JSONObject, fso>... fsmArr) {
        if (list != null && !list.isEmpty()) {
            LogType logType = LogType.HOME_ROOM;
            gsy.O00000o0(logType, "CommonUseDeviceDataManager", "addCommonUseDeviceBatch " + Arrays.deepToString(list.toArray()));
            O000000o(list, true);
            if (!list.isEmpty()) {
                fru.O000000o().O000000o(list, true, (fsm<JSONObject, fso>) new fsm<JSONObject, fso>() {
                    /* class _m_j.gfx.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        gfx.O000000o(jSONObject, list, true);
                        gqg.O00000Oo((int) R.string.action_success);
                        int i = 0;
                        while (true) {
                            fsm[] fsmArr = fsmArr;
                            if (i < fsmArr.length) {
                                fsmArr[i].onSuccess(jSONObject);
                                i++;
                            } else {
                                return;
                            }
                        }
                    }

                    public final void onFailure(fso fso) {
                        LogType logType = LogType.HOME_ROOM;
                        gsy.O00000o0(logType, "CommonUseDeviceDataManager", "addCommonUseDeviceBatch " + fso.toString());
                        gqg.O00000Oo((int) R.string.code_default_error);
                        int i = 0;
                        while (true) {
                            fsm[] fsmArr = fsmArr;
                            if (i < fsmArr.length) {
                                fsmArr[i].onFailure(fso);
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gfx.O000000o(java.util.List<java.lang.String>, boolean):void
     arg types: [java.util.List<java.lang.String>, int]
     candidates:
      _m_j.gfx.O000000o(java.lang.String, boolean):void
      _m_j.gfx.O000000o(java.util.List<java.lang.String>, com.xiaomi.smarthome.homeroom.model.Home):void
      _m_j.gfx.O000000o(java.util.List<java.lang.String>, _m_j.fsm<org.json.JSONObject, _m_j.fso>[]):void
      _m_j.gfx.O000000o(java.util.List<java.lang.String>, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fru.O000000o(java.util.List<java.lang.String>, boolean, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
     arg types: [java.util.List<java.lang.String>, int, _m_j.gfx$2]
     candidates:
      _m_j.fru.O000000o(android.content.Context, long, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(android.content.Context, org.json.JSONObject, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(long, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(android.content.Context, java.lang.String, _m_j.fsm<java.lang.String, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(android.content.Context, java.util.ArrayList<java.lang.String>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(android.content.Context, java.util.Map<java.lang.String, java.lang.Long>, _m_j.fsm<org.json.JSONArray, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(java.lang.String, java.util.List<java.lang.String>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.fru.O000000o(java.util.List<java.lang.String>, boolean, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn */
    public final void O00000Oo(final List<String> list, final fsm<JSONObject, fso>... fsmArr) {
        if (list != null && !list.isEmpty()) {
            LogType logType = LogType.HOME_ROOM;
            gsy.O00000o0(logType, "CommonUseDeviceDataManager", "deleteCommonUseDeviceBatch " + Arrays.deepToString(list.toArray()));
            O000000o(list, false);
            if (!list.isEmpty()) {
                fru.O000000o().O000000o(list, false, (fsm<JSONObject, fso>) new fsm<JSONObject, fso>() {
                    /* class _m_j.gfx.AnonymousClass2 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        int i = 0;
                        gfx.O000000o(jSONObject, list, false);
                        gqg.O00000Oo((int) R.string.action_success);
                        while (true) {
                            fsm[] fsmArr = fsmArr;
                            if (i < fsmArr.length) {
                                fsmArr[i].onSuccess(jSONObject);
                                i++;
                            } else {
                                return;
                            }
                        }
                    }

                    public final void onFailure(fso fso) {
                        LogType logType = LogType.HOME_ROOM;
                        gsy.O00000o0(logType, "CommonUseDeviceDataManager", "deleteCommonUseDeviceBatch " + fso.toString());
                        gqg.O00000Oo((int) R.string.code_default_error);
                        int i = 0;
                        while (true) {
                            fsm[] fsmArr = fsmArr;
                            if (i < fsmArr.length) {
                                fsmArr[i].onFailure(fso);
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                });
            }
        }
    }

    private static void O000000o(List<String> list, boolean z) {
        Iterator<String> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (fqw.O000000o(next)) {
                O000000o(next, z);
                it.remove();
                break;
            }
        }
        if (list.isEmpty()) {
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("common_used_device_updated"));
        }
    }

    public static void O000000o(JSONObject jSONObject, List<String> list, boolean z) {
        if (jSONObject != null && jSONObject.optInt("succ_count") > 0) {
            JSONArray optJSONArray = jSONObject.optJSONArray("fail_list");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
            }
            list.removeAll(arrayList);
            for (int i2 = 0; i2 < list.size(); i2++) {
                O000000o(list.get(i2), z);
            }
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
            fno.O000000o().O0000Oo0();
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("common_used_device_updated"));
        }
    }

    private static void O000000o(String str, boolean z) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null) {
            O000000o2.freqFlag = z;
            if (fqw.O000000o(str) || (O000000o2 instanceof PhoneIRDevice)) {
                O000000o().O00000Oo(z);
            }
        }
    }

    public static void O00000o() {
        Intent intent = new Intent("common_used_device_updated");
        intent.putExtra("common_used_device_updated_result_code", ErrorCode.ERROR_UNLOGIN);
        intent.putExtra("common_use_device_operation", "operation_sync");
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(intent);
    }

    public final void O000000o(List<String> list, Home home) {
        if (list != null && !list.isEmpty() && home != null && home.isOwner()) {
            List list2 = this.f17665O000000o.get(home.getId());
            if (!list.equals(list2)) {
                List arrayList = new ArrayList(list);
                if (list2 != null && !list2.isEmpty()) {
                    if (list2.size() == 1) {
                        String str = (String) list2.get(0);
                        if (!arrayList.contains(str)) {
                            arrayList.add(str);
                        }
                    } else {
                        arrayList = ggp.O000000o(list2, arrayList);
                    }
                }
                this.f17665O000000o.put(home.getId(), arrayList);
                ggr ggr = ggr.f17748O000000o;
                ggr.O000000o(arrayList, home.getId());
            }
        }
    }

    private List<String> O00000oO(String str) {
        O00000oO();
        List list = this.f17665O000000o.get(str);
        if (list == null) {
            return new ArrayList();
        }
        return new ArrayList(list);
    }

    private static Device O0000O0o() {
        PhoneIRDevice phoneIRDevice = new PhoneIRDevice();
        phoneIRDevice.name = ServiceApplication.getAppContext().getString(R.string.group_type_phoneir);
        phoneIRDevice.freqFlag = O000000o().O00000oo();
        if (fqw.O00000Oo() != null) {
            fqw.O00000Oo().freqFlag = phoneIRDevice.freqFlag;
        }
        return phoneIRDevice;
    }

    public static String O00000o(String str) {
        if (TextUtils.isEmpty(str) || gqb.O000000o((CharSequence) str) <= O00000o) {
            return str;
        }
        String[] strArr = O00000oO;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = strArr[i];
            if (!str.startsWith(str2)) {
                i++;
            } else if (str.trim().length() > str2.length()) {
                return str.substring(str2.length()).trim();
            }
        }
        return str;
    }
}
