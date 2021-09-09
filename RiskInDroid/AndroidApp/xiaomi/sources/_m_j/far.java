package _m_j;

import _m_j.fno;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.google.gson.Gson;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class far {
    private static String O0000OOo = "MiuiDeviceCacheManager";
    private static volatile far O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f16029O000000o = false;
    public ArrayMap<String, String> O00000Oo = new ArrayMap<>();
    public ArrayList<GridViewData> O00000o = new ArrayList<>();
    public ArrayMap<String, String> O00000o0 = new ArrayMap<>();
    public fno.O000000o O00000oO = new fno.O000000o() {
        /* class _m_j.far.AnonymousClass1 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3 && ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                CommonApplication.getGlobalWorkerHandler().removeCallbacks(far.this.O0000O0o);
                CommonApplication.getGlobalWorkerHandler().postDelayed(far.this.O0000O0o, 1000);
            }
        }
    };
    public BroadcastReceiver O00000oo = new BroadcastReceiver() {
        /* class _m_j.far.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "home_room_updated") && ggb.O00000Oo().O0000OoO.O00000oo) {
                far.this.O0000O0o.run();
            }
        }
    };
    public Runnable O0000O0o = new Runnable() {
        /* class _m_j.far.AnonymousClass3 */

        public final void run() {
            far.this.f16029O000000o = false;
            goq.O00000o0(new Runnable() {
                /* class _m_j.far.AnonymousClass3.AnonymousClass1 */

                public final void run() {
                    if (ggb.O00000Oo().O0000OoO.O00000oo) {
                        List<GridViewData> O0000o0 = ggb.O00000Oo().O0000o0();
                        far.this.O000000o(O0000o0, true);
                        LogType logType = LogType.MIJIA_WIDGET_CACHE;
                        gsy.O00000o0(logType, "zhudong_mStartCacheRunnable_save", "gridViewDataList_device update size: " + O0000o0.size());
                    }
                }
            });
        }
    };
    private String O0000Oo = "";
    private int O0000OoO = 0;

    public interface O000000o {
        void O000000o();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private far() {
        O00000oo();
        O0000O0o();
        this.f16029O000000o = CommonApplication.getAppContext().getSharedPreferences("SP_THREADPOOL_AB_CONFIG", 0).getBoolean("SP_KEY_USE_MIUI_MEMORY_OPT", false);
        LogType logType = LogType.MIJIA_WIDGET_CACHE;
        String str = O0000OOo;
        gsy.O00000o0(logType, str, "xxxx mOptimizeOpen: " + this.f16029O000000o);
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.far.AnonymousClass4 */

            public final void run() {
                fno.O000000o().O000000o(far.this.O00000oO);
                ft.O000000o(CommonApplication.getAppContext()).O000000o(far.this.O00000oo, new IntentFilter("home_room_updated"));
            }
        });
    }

    public static far O000000o() {
        if (O0000Oo0 == null) {
            synchronized (far.class) {
                if (O0000Oo0 == null) {
                    O0000Oo0 = new far();
                }
            }
        }
        return O0000Oo0;
    }

    public final boolean O00000Oo() {
        LogType logType = LogType.MIJIA_WIDGET;
        gsy.O00000o0(logType, "isEnableMiuiWidgetMemoryOpt", "hasEnteredForeground:" + CommonApplication.hasEnteredForeground() + "---mOptimizeOpen:" + this.f16029O000000o + "---mCacheDataList:" + this.O00000o.size());
        return !CommonApplication.hasEnteredForeground() && this.f16029O000000o && this.O00000o.size() > 0;
    }

    public final Device O000000o(String str) {
        Iterator<GridViewData> it = this.O00000o.iterator();
        while (it.hasNext()) {
            GridViewData next = it.next();
            if (TextUtils.equals(next.O00000Oo.did, str)) {
                return next.O00000Oo;
            }
        }
        return null;
    }

    public final ArrayList<GridViewData> O00000o0() {
        return new ArrayList<>(this.O00000o);
    }

    private static File O00000o() {
        String O00000Oo2 = fcn.O000000o().O00000Oo();
        if (TextUtils.isEmpty(O00000Oo2)) {
            O00000Oo2 = "0";
        }
        return new File(CommonApplication.getAppContext().getFilesDir(), "miui_cache_device_list_".concat(String.valueOf(grv.O000000o(O00000Oo2 + "cache"))));
    }

    private static File O00000oO() {
        String O00000Oo2 = fcn.O000000o().O00000Oo();
        if (TextUtils.isEmpty(O00000Oo2)) {
            O00000Oo2 = "0";
        }
        return new File(CommonApplication.getAppContext().getFilesDir(), "miui_room_name_list_".concat(String.valueOf(grv.O000000o(O00000Oo2 + "cache"))));
    }

    private void O00000oo() {
        Parcel O000000o2;
        byte[] O000000o3 = fkw.O000000o(O00000o());
        if (!(O000000o3 == null || (O000000o2 = fkw.O000000o(O000000o3)) == null)) {
            try {
                this.O0000Oo = O000000o2.readString();
                this.O0000OoO = O000000o2.readInt();
                ArrayList readArrayList = O000000o2.readArrayList(GridViewData.class.getClassLoader());
                LogType logType = LogType.MIJIA_WIDGET_CACHE;
                String str = O0000OOo;
                gsy.O00000o0(logType, str, "initCacheDevice cacheList: " + readArrayList.size());
                if (readArrayList != null && readArrayList.size() > 0) {
                    Iterator it = readArrayList.iterator();
                    while (it.hasNext()) {
                        GridViewData gridViewData = (GridViewData) it.next();
                        LogType logType2 = LogType.MIJIA_WIDGET_CACHE;
                        String str2 = O0000OOo;
                        StringBuilder sb = new StringBuilder("initCacheDevice 判断条件: ");
                        sb.append(gridViewData.O00000Oo != null && !TextUtils.isEmpty(gridViewData.O00000Oo.did));
                        gsy.O00000o0(logType2, str2, sb.toString());
                        if (gridViewData.O00000Oo != null && !TextUtils.isEmpty(gridViewData.O00000Oo.did)) {
                            Device O00000o02 = DeviceFactory.O00000o0(gridViewData.O00000Oo);
                            if (O00000o02 != null) {
                                gridViewData.O00000Oo = O00000o02;
                                this.O00000o.add(gridViewData);
                            } else {
                                LogType logType3 = LogType.MIJIA_WIDGET_CACHE;
                                String str3 = O0000OOo;
                                gsy.O00000o0(logType3, str3, "initCacheDevice newDevice==null,Device_string:" + gridViewData.O00000Oo.toString());
                            }
                        }
                    }
                }
                LogType logType4 = LogType.MIJIA_WIDGET_CACHE;
                String str4 = O0000OOo;
                gsy.O00000o0(logType4, str4, "initCacheDevice mCacheDataList: " + this.O00000o.size());
            } catch (Throwable th) {
                O000000o2.recycle();
                throw th;
            }
            O000000o2.recycle();
        }
        LogType logType5 = LogType.MIJIA_WIDGET_CACHE;
        String str5 = O0000OOo;
        gsy.O00000o0(logType5, str5, "initCacheDevice_mCacheDataList size: " + this.O00000o.size());
    }

    private void O0000O0o() {
        String O000000o2 = fkw.O000000o(O00000oO().getAbsolutePath());
        if (!TextUtils.isEmpty(O000000o2)) {
            try {
                JSONArray jSONArray = new JSONArray(O000000o2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("did", "");
                        String optString2 = optJSONObject.optString("home_name", "");
                        String optString3 = optJSONObject.optString("room_name", "");
                        if (!TextUtils.isEmpty(optString)) {
                            this.O00000o0.put(optString, optString2);
                            this.O00000Oo.put(optString, optString3);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(List<GridViewData> list, boolean z) {
        String str;
        ArrayList<GridViewData> arrayList = new ArrayList<>(list);
        LogType logType = LogType.MIJIA_WIDGET_CACHE;
        gsy.O00000o0(logType, "zhudong_Start_saveCacheDevice_之前:", "saveList_mCacheDataList:" + arrayList.size());
        String O0000o0 = CoreApi.O000000o().O0000o0();
        if (TextUtils.isEmpty(O0000o0)) {
            O0000o0 = "0";
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeString(O0000o0);
            obtain.writeInt(arrayList.size());
            obtain.writeList(arrayList);
            boolean O000000o2 = fkw.O000000o(O00000o(), obtain.marshall());
            LogType logType2 = LogType.MIJIA_WIDGET_CACHE;
            gsy.O00000o0(logType2, "zhudong_saveCacheDevice:", "writeFile:" + O000000o2 + "---saveList_size:" + arrayList.size());
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
        obtain.recycle();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<GridViewData> it = arrayList.iterator();
            while (it.hasNext()) {
                GridViewData next = it.next();
                if (!arrayList2.contains(next.O00000Oo.getModel())) {
                    arrayList2.add(next.O00000Oo.getModel());
                }
                if (z) {
                    Home O0000o02 = ggb.O00000Oo().O0000o0(next.O00000Oo.getDid());
                    String str2 = "";
                    if (O0000o02 == null) {
                        str = str2;
                    } else {
                        ggb.O00000Oo();
                        str = ggb.O000000o(O0000o02);
                    }
                    if (str == null) {
                        str = str2;
                    }
                    this.O00000o0.put(next.O00000Oo.getDid(), str);
                    String O0000o0O = ggb.O00000Oo().O0000o0O(next.O00000Oo.getDid());
                    if (O0000o0O != null) {
                        str2 = O0000o0O;
                    }
                    this.O00000Oo.put(next.O00000Oo.getDid(), str2);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("did", next.O00000Oo.getDid());
                        jSONObject.put("home_name", str);
                        jSONObject.put("room_name", str2);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (z) {
            fkw.O000000o(O00000oO().getAbsolutePath(), jSONArray.toString());
        }
        PluginDeviceManager.instance.saveMiuiModelInfo(arrayList2);
        this.O0000Oo = O0000o0;
        this.O0000OoO = list.size();
        this.O00000o = arrayList;
        LogType logType3 = LogType.MIJIA_WIDGET_CACHE;
        String str3 = O0000OOo;
        gsy.O00000o0(logType3, str3, "saveCacheDevice_initCacheDevice之后 mCacheDataList: " + this.O00000o.size());
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
    public final void O000000o(final O000000o o000000o) {
        final ArrayList arrayList = new ArrayList();
        if (this.O00000o.size() > 0) {
            Iterator<GridViewData> it = this.O00000o.iterator();
            while (it.hasNext()) {
                GridViewData next = it.next();
                if (!TextUtils.isEmpty(next.O00000Oo.did) && next.f8988O000000o != GridViewData.GridType.TYPE_IR && !fno.O000000o().O00000oO(next.O00000Oo)) {
                    arrayList.add(next.O00000Oo.did);
                }
            }
        }
        if (arrayList.size() == 0) {
            o000000o.O000000o();
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                jSONArray.put(arrayList.get(i));
            }
            jSONObject.put("dids", jSONArray);
            jSONObject.put("get_online_status", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList2.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/deviceinfo").O000000o(arrayList2).O000000o(), $$Lambda$far$m2RAgSjVLVv8Bd1Tnm5orehbuo.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class _m_j.far.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                LogType logType = LogType.MIJIA_WIDGET_CACHE;
                gsy.O00000o0(logType, "zhudong_responseCallback", "result:" + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O000000o();
                        return;
                    }
                    return;
                }
                LogType logType2 = LogType.MIJIA_WIDGET_CACHE;
                gsy.O00000o0(logType2, "zhudong_updateDeviceCache:", "before_didList:" + arrayList.size() + "---" + new Gson().toJson(arrayList));
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("did");
                        String optString2 = optJSONObject.optString("name");
                        boolean z = optJSONObject.optInt("is_online") != 0;
                        Device O000000o2 = far.this.O000000o(optString);
                        if (O000000o2 != null) {
                            O000000o2.name = optString2;
                            O000000o2.isOnline = z;
                        }
                        arrayList.remove(optString);
                    }
                }
                LogType logType3 = LogType.MIJIA_WIDGET_CACHE;
                gsy.O00000o0(logType3, "zhudong_updateDeviceCache:", "after_didList:" + arrayList.size() + "---" + new Gson().toJson(arrayList));
                if (arrayList.size() > 0) {
                    Iterator<GridViewData> it = far.this.O00000o.iterator();
                    while (it.hasNext()) {
                        GridViewData next = it.next();
                        if (arrayList.contains(next.O00000Oo.did)) {
                            LogType logType4 = LogType.MIJIA_WIDGET_CACHE;
                            gsy.O00000o0(logType4, "zhudong_before_save:", "remove_did:" + next.O00000Oo.did);
                            it.remove();
                        }
                    }
                    LogType logType5 = LogType.MIJIA_WIDGET_CACHE;
                    gsy.O00000o0(logType5, "zhudong_before_saveCacheDevice:", "mCacheDataList:" + far.this.O00000o.size() + "---hasEnteredForeground:" + CommonApplication.hasEnteredForeground());
                    if (!CommonApplication.hasEnteredForeground()) {
                        far far = far.this;
                        far.O000000o(far.O00000o, false);
                    }
                }
                O000000o o000000o2 = o000000o;
                if (o000000o2 != null) {
                    o000000o2.O000000o();
                }
            }

            public final void onFailure(fso fso) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        });
    }
}
