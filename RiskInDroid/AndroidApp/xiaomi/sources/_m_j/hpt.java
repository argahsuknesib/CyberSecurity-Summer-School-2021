package _m_j;

import _m_j.hpt;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.frame.plugin.runtime.util.DeviceCategory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.model.RecommendSceneDetailInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hpt {
    private static volatile hpt O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public PluginRecommendSceneInfo.RecommendSceneItem f492O000000o = null;
    public Map<String, JSONObject> O00000Oo = new HashMap();
    public Map<Integer, SceneApi.Action> O00000o = new HashMap();
    public Map<Integer, SceneApi.O000000o> O00000o0 = new HashMap();
    public Map<String, List<SceneApi.O000000o>> O00000oO = new HashMap();
    public Map<String, List<SceneApi.Action>> O00000oo = new HashMap();
    public O00000Oo O0000O0o;
    public SceneApi.O000OOOo O0000OOo;

    public interface O000000o {
        void O000000o(int i, Intent intent);
    }

    public interface O00000Oo {
        Map<String, List<SceneApi.O000000o>> getSelctionConditions(Map<Integer, SceneApi.O000000o> map);

        Map<String, List<SceneApi.Action>> getSelectionActions(Map<Integer, SceneApi.Action> map);
    }

    private hpt() {
    }

    public static hpt O000000o() {
        if (O0000Oo0 == null) {
            synchronized (hpt.class) {
                if (O0000Oo0 == null) {
                    O0000Oo0 = new hpt();
                }
            }
        }
        return O0000Oo0;
    }

    public static void O000000o(final SceneApi.O000OOOo o000OOOo, final hqy hqy) {
        Device O000000o2 = O000000o(o000OOOo);
        if (O000000o2 == null) {
            O00000Oo(o000OOOo, hqy);
        } else if (O000000o2.isOnline || hqy == null) {
            SceneApi.O000000o(o000OOOo);
            SceneInfo O00000o2 = hod.O00000o(o000OOOo);
            final boolean[] zArr = {false};
            final AnonymousClass1 r2 = new CountDownTimer() {
                /* class _m_j.hpt.AnonymousClass1 */

                public final void onTick(long j) {
                }

                public final void onFinish() {
                    hqy hqy = hqy;
                    if (hqy != null) {
                        hqy.onSaveLocalFail();
                    }
                    zArr[0] = true;
                }
            };
            r2.start();
            hpp.O000000o().O000000o(O00000o2, new Callback<SceneInfo>() {
                /* class _m_j.hpt.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    SceneInfo sceneInfo = (SceneInfo) obj;
                    if (!zArr[0]) {
                        r2.cancel();
                        zArr[0] = true;
                        if (sceneInfo != null) {
                            for (int i = 0; i < sceneInfo.mLaunchList.size(); i++) {
                                if (o000OOOo.O0000O0o.get(i).O00000o0 != null && (o000OOOo.O0000O0o.get(i).O00000o0 instanceof SceneApi.O00000o0)) {
                                    ((SceneApi.O00000o0) o000OOOo.O0000O0o.get(i).O00000o0).O0000o00 = sceneInfo.mLaunchList.get(i).mExtra;
                                }
                            }
                            for (int i2 = 0; i2 < sceneInfo.mActions.size(); i2++) {
                                if (o000OOOo.O00000oo.get(i2).O0000O0o != null && (o000OOOo.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000OO0o)) {
                                    ((SceneApi.O000OO0o) o000OOOo.O00000oo.get(i2).O0000O0o).f11130O000000o = sceneInfo.mActions.get(i2).mExtra;
                                }
                            }
                        }
                        hpt.O00000Oo(o000OOOo, hqy);
                    }
                }

                public final void onFailure(int i, String str) {
                    r2.cancel();
                    zArr[0] = true;
                    hqy hqy = hqy;
                    if (hqy != null) {
                        hqy.onSaveLocalFail();
                    }
                }
            });
        } else {
            hqy.onSaveCloudFail(-9000, "gateway offline");
        }
    }

    public static void O00000Oo(final SceneApi.O000OOOo o000OOOo, final hqy hqy) {
        if (eys.f15955O000000o) {
            hob.O000000o().O000000o(ServiceApplication.getAppContext(), o000OOOo, new fsm<JSONObject, fso>() {
                /* class _m_j.hpt.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    String optString = jSONObject.optString("us_id");
                    boolean optBoolean = jSONObject.optBoolean("local");
                    String optString2 = jSONObject.optString("local_dev");
                    o000OOOo.f11131O000000o = optString;
                    if (TextUtils.isEmpty(optString2) || !optBoolean) {
                        hqy hqy = hqy;
                        if (hqy != null) {
                            hqy.onSaveCloudSuccess(true);
                            return;
                        }
                        return;
                    }
                    hpt.O000000o(optString2, jSONObject.optJSONObject("data").toString(), o000OOOo, hqy);
                }

                public final void onFailure(fso fso) {
                    hqy hqy = hqy;
                    if (hqy != null) {
                        hqy.onSaveCloudFail(fso.f17063O000000o, fso.O00000Oo);
                    }
                }
            });
        } else if (hqy != null) {
            hqy.onSaveCloudFail(-9990, "is not smarttttttt home");
        }
    }

    public static void O000000o(String str, String str2, final SceneApi.O000OOOo o000OOOo, final hqy hqy) {
        Device O00000o02 = fno.O000000o().O00000o0(str);
        if (O00000o02 != null) {
            hpn.O000000o().O000000o(XmPluginHostApi.instance().getDeviceByDid(O00000o02.did), str2, new MessageCallback() {
                /* class _m_j.hpt.AnonymousClass4 */

                public final void onSuccess(Intent intent) {
                    hob.O000000o();
                    hob.O00000Oo(ServiceApplication.getAppContext(), o000OOOo, new fsm<Void, fso>() {
                        /* class _m_j.hpt.AnonymousClass4.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                            if (hqy != null) {
                                hqy.onSaveCloudSuccess(false);
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (hqy != null) {
                                hqy.onSaveCloudSuccess(true);
                            }
                        }
                    });
                }

                public final void onFailure(int i, String str) {
                    hqy hqy = hqy;
                    if (hqy != null) {
                        hqy.onSaveCloudSuccess(false);
                    }
                }
            });
            new CountDownTimer() {
                /* class _m_j.hpt.AnonymousClass5 */

                public final void onTick(long j) {
                }

                public final void onFinish() {
                    hqy hqy = hqy;
                    if (hqy != null) {
                        hqy.onSaveCloudSuccess(false);
                    }
                }
            }.start();
        } else if (hqy != null) {
            hqy.onSaveCloudSuccess(false);
        }
    }

    private static Device O000000o(SceneApi.O000OOOo o000OOOo) {
        Device O00000o02;
        String str;
        Device O00000o03;
        String str2;
        boolean z = false;
        String str3 = null;
        for (SceneApi.O000000o next : o000OOOo.O0000O0o) {
            if (!(next.O00000o0 == null || next.O00000o0.O00000o == null || (O00000o03 = fno.O000000o().O00000o0(next.O00000o0.f11122O000000o)) == null)) {
                if (O00000o03.isSubDevice()) {
                    str2 = O00000o03.parentId;
                } else {
                    str2 = O00000o03.did;
                }
                if (hnw.O000000o(fno.O000000o().O00000o0(str2))) {
                    str3 = str2;
                    z = true;
                }
            }
        }
        if (!z) {
            for (SceneApi.Action next2 : o000OOOo.O00000oo) {
                if (!(next2.O00000oO == null || next2.O0000O0o.O00000o == null || (O00000o02 = fno.O000000o().O00000o0(next2.O0000O0o.O00000o)) == null)) {
                    if (O00000o02.isSubDevice()) {
                        str = O00000o02.parentId;
                    } else {
                        str = O00000o02.did;
                    }
                    if (hnw.O000000o(fno.O000000o().O00000o0(str))) {
                        str3 = str;
                        z = true;
                    }
                }
            }
        }
        if (!z || TextUtils.isEmpty(str3)) {
            return null;
        }
        return fno.O000000o().O00000o0(str3);
    }

    public final void O000000o(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.f492O000000o.mConditionList != null && jSONObject != null) {
            ArrayList arrayList = new ArrayList();
            for (PluginRecommendSceneInfo.ConditionActionItem next : this.f492O000000o.mConditionList) {
                if (next.modelListJobj == null) {
                    break;
                }
                Iterator<String> keys = next.modelListJobj.keys();
                while (keys.hasNext()) {
                    String next2 = keys.next();
                    int optInt = next.modelListJobj.optInt(next2);
                    arrayList.clear();
                    if (optInt == 0) {
                        JSONArray optJSONArray = next.modelListJobj.optJSONArray(next2);
                        int i = 0;
                        while (true) {
                            if (i >= (optJSONArray != null ? optJSONArray.length() : 0)) {
                                break;
                            }
                            arrayList.add(Integer.valueOf(optJSONArray.optInt(i)));
                            i++;
                        }
                    } else {
                        arrayList.add(Integer.valueOf(optInt));
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (!this.O00000Oo.containsKey(arrayList.get(i2)) && ((Integer) arrayList.get(i2)).intValue() > 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(arrayList.get(i2));
                            JSONObject optJSONObject = jSONObject.optJSONObject(sb.toString());
                            if (optJSONObject != null) {
                                Map<String, JSONObject> map = this.O00000Oo;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(arrayList.get(i2));
                                map.put(sb2.toString(), optJSONObject);
                            }
                        }
                    }
                }
            }
        }
        if (this.f492O000000o.mActionList != null && jSONObject2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (PluginRecommendSceneInfo.ConditionActionItem next3 : this.f492O000000o.mActionList) {
                if (next3.modelListJobj != null) {
                    Iterator<String> keys2 = next3.modelListJobj.keys();
                    while (keys2.hasNext()) {
                        String next4 = keys2.next();
                        int optInt2 = next3.modelListJobj.optInt(next4);
                        arrayList2.clear();
                        if (optInt2 == 0) {
                            JSONArray optJSONArray2 = next3.modelListJobj.optJSONArray(next4);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= (optJSONArray2 != null ? optJSONArray2.length() : 0)) {
                                    break;
                                }
                                arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i3)));
                                i3++;
                            }
                        } else {
                            arrayList2.add(Integer.valueOf(optInt2));
                        }
                        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                            if (!this.O00000o.containsKey(arrayList2.get(i4)) && ((Integer) arrayList2.get(i4)).intValue() > 0) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(arrayList2.get(i4));
                                JSONObject optJSONObject2 = jSONObject2.optJSONObject(sb3.toString());
                                if (optJSONObject2 != null) {
                                    try {
                                        SceneApi.Action O000000o2 = SceneApi.Action.O000000o(optJSONObject2);
                                        if (O000000o2.f11120O000000o == 0) {
                                            SceneApi.O000OO00 o000oo00 = O000000o2.O0000O0o;
                                            o000oo00.O00000o0 = next4 + "." + O000000o2.O0000O0o.O00000o0;
                                            O000000o2.O0000O0o.O0000O0o = 0;
                                        }
                                        this.O00000o.put(arrayList2.get(i4), O000000o2);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void O00000Oo() {
        this.O00000oo.clear();
        this.O00000oO.clear();
        O00000Oo o00000Oo = this.O0000O0o;
        if (o00000Oo != null) {
            this.O00000oo.putAll(o00000Oo.getSelectionActions(this.O00000o));
            this.O00000oO.putAll(this.O0000O0o.getSelctionConditions(this.O00000o0));
        }
    }

    public static List<Device> O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Device next : ggb.O00000Oo().O0000Oo(str)) {
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(next.model);
            if (next.isOwner() && O00000oO2 != null && O00000oO2.O000O0OO() == 1 && hnw.O00000Oo(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static void O00000o0() {
        O0000Oo0 = null;
    }

    public final void O000000o(BaseActivity baseActivity, SceneApi.Action action, Object obj, O000000o o000000o) {
        final Intent intent = new Intent(((SceneApi.O000OO0o) action.O0000O0o).O0000Oo0);
        intent.putExtra("action", action.O0000O0o.O00000o0);
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (str.contains("action_tts")) {
                str = str.replace("action_tts", "");
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("value", str);
            }
        } else if (obj != null) {
            String obj2 = obj.toString();
            if (obj2.contains("action_tts")) {
                obj2 = obj2.replace("action_tts", "");
            }
            if (!TextUtils.isEmpty(obj2)) {
                intent.putExtra("value", obj2);
            }
        }
        intent.putExtra("actionId", action.O00000oo);
        intent.putExtra("plug_id", ((SceneApi.O000OO0o) action.O0000O0o).O0000Oo0);
        intent.putExtra("name", action.O00000Oo);
        intent.putExtra("tr_id", action.O00000o);
        intent.putExtra("scene_type", 2);
        final BaseActivity baseActivity2 = baseActivity;
        final SceneApi.Action action2 = action;
        final O000000o o000000o2 = o000000o;
        ServiceApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.hpt.AnonymousClass6 */

            public final void run() {
                hpt.this.O000000o(baseActivity2, fno.O000000o().O000000o(action2.O0000O0o.O00000o), intent, o000000o2);
            }
        });
    }

    public final void O000000o(BaseActivity baseActivity, Device device, Intent intent, O000000o o000000o) {
        BaseActivity baseActivity2 = baseActivity;
        Device device2 = device;
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device2.model);
        if (O00000oO2 != null) {
            final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(baseActivity2, baseActivity2.getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0() + baseActivity2.getString(R.string.plugin));
            final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
            final boolean z = CoreApi.O000000o().O0000Oo(device2.model) == null && CoreApi.O000000o().O0000OoO(device2.model) == null;
            PluginApi instance = PluginApi.getInstance();
            String str = device2.model;
            DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2);
            final BaseActivity baseActivity3 = baseActivity;
            final Device device3 = device;
            final O000000o o000000o2 = o000000o;
            instance.sendMessage(baseActivity, str, 3, intent, newDeviceStat, null, true, new SendMessageCallback() {
                /* class _m_j.hpt.AnonymousClass8 */

                public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    pluginDownloadTask.O000000o(pluginDownloadTask);
                    if (O000000o2 != null && !baseActivity3.isFinishing() && !baseActivity3.isDestroyed()) {
                        O000000o2.O000000o(100, 0);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        xQProgressHorizontalDialog.f9117O000000o = false;
                        xQProgressHorizontalDialog.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener(pluginDownloadTask) {
                            /* class _m_j.$$Lambda$hpt$8$exMgLVrd6kMxo8D81NwGYCS6geQ */
                            private final /* synthetic */ PluginDownloadTask f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                CoreApi.O000000o().O000000o(Device.this.model, this.f$1);
                            }
                        });
                    }
                }

                public final void onDownloadProgress(String str, float f) {
                    if (z) {
                        int i = (int) (f * 100.0f);
                        if (i >= 99) {
                            i = 99;
                        }
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        if (xQProgressHorizontalDialog != null) {
                            xQProgressHorizontalDialog.O000000o(100, i);
                            return;
                        }
                        return;
                    }
                    XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                    if (xQProgressHorizontalDialog2 != null) {
                        xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
                    }
                }

                public final void onDownloadSuccess(String str) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onDownloadFailure(PluginError pluginError) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onDownloadCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onSendSuccess(Bundle bundle) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onSendFailure(fso fso) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onSendCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onMessageSuccess(Intent intent) {
                    baseActivity3.mHandler.post(new Runnable(intent) {
                        /* class _m_j.$$Lambda$hpt$8$ewAln1hayN9JDZ5TWZcFg_KnqvM */
                        private final /* synthetic */ Intent f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            hpt.AnonymousClass8.O000000o(hpt.O000000o.this, this.f$1);
                        }
                    });
                    this.mObj = null;
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void O000000o(O000000o o000000o, Intent intent) {
                    if (o000000o != null) {
                        o000000o.O000000o(-1, intent);
                    }
                }

                public final void onMessageFailure(int i, String str) {
                    baseActivity3.mHandler.post(new Runnable() {
                        /* class _m_j.$$Lambda$hpt$8$QLfDePAIMXPkI3Xyvn78ab6ErM4 */

                        public final void run() {
                            hpt.AnonymousClass8.O000000o(hpt.O000000o.this);
                        }
                    });
                    this.mObj = null;
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void O000000o(O000000o o000000o) {
                    if (o000000o != null) {
                        o000000o.O000000o(0, null);
                    }
                }
            });
        }
    }

    public static boolean O00000Oo(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null && DeviceCategory.fromPid(O000000o2.pid) == DeviceCategory.Bluetooth) {
            return true;
        }
        return false;
    }

    public static void O000000o(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem, String str, hqy hqy) {
        SceneApi.Action O000000o2;
        SceneApi.O000000o O00000Oo2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        SceneApi.O000OOOo o000OOOo = null;
        if (recommendSceneItem != null) {
            RecommendSceneDetailInfo recommendSceneDetailInfo = new RecommendSceneDetailInfo();
            if (recommendSceneItem != null) {
                recommendSceneDetailInfo.O00000o0 = recommendSceneItem.gifUrl;
                recommendSceneDetailInfo.O00000o = recommendSceneItem.url;
                recommendSceneDetailInfo.O0000O0o = recommendSceneItem.enable;
                recommendSceneDetailInfo.O0000OOo = recommendSceneItem.enable_push;
                recommendSceneDetailInfo.O0000Oo0 = recommendSceneItem.st_id;
                recommendSceneDetailInfo.O00000oO = recommendSceneItem.sr_id;
                recommendSceneDetailInfo.O00000oo = recommendSceneItem.intro;
                try {
                    List<PluginRecommendSceneInfo.ConditionActionItem> list = recommendSceneItem.mConditionList;
                    recommendSceneDetailInfo.f11162O000000o.clear();
                    for (int i = 0; i < list.size(); i++) {
                        PluginRecommendSceneInfo.ConditionActionItem conditionActionItem = list.get(i);
                        RecommendSceneDetailInfo.O00000Oo o00000Oo = new RecommendSceneDetailInfo.O00000Oo();
                        o00000Oo.O00000o0 = conditionActionItem.mGidJArray;
                        o00000Oo.O00000oO = conditionActionItem.modelListJobj;
                        o00000Oo.O00000oo = conditionActionItem.mConditionSrc;
                        o00000Oo.O0000O0o = conditionActionItem.mConditionKey;
                        o00000Oo.O0000OOo = conditionActionItem.name;
                        if (o00000Oo.O00000oo.equalsIgnoreCase("device")) {
                            JSONObject jSONObject = conditionActionItem.modelListJobj;
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                List<Device> O0000Ooo = fno.O000000o().O0000Ooo(keys.next());
                                if (O0000Ooo != null) {
                                    o00000Oo.O00000Oo.addAll(O0000Ooo);
                                }
                            }
                            if (o00000Oo.O00000Oo.size() > 0) {
                                o00000Oo.f11164O000000o = RecommendSceneDetailInfo.O00000Oo(o00000Oo.O00000Oo.get(0).model, jSONObject.getString(o00000Oo.O00000Oo.get(0).model));
                                if (!(hpu.O000000o().O00000Oo.O00000Oo == null || (optJSONObject2 = hpu.O000000o().O00000Oo.O00000Oo.optJSONObject(jSONObject.getString(o00000Oo.O00000Oo.get(0).model))) == null)) {
                                    o00000Oo.O0000Oo0 = optJSONObject2.optString("fw_version", "");
                                }
                            } else {
                                Iterator<String> keys2 = jSONObject.keys();
                                if (keys2.hasNext()) {
                                    String next = keys2.next();
                                    o00000Oo.f11164O000000o = RecommendSceneDetailInfo.O00000Oo(next, jSONObject.getString(next));
                                }
                            }
                        } else if (o00000Oo.O00000oo.equalsIgnoreCase("user")) {
                            if (conditionActionItem.mConditionKey.equalsIgnoreCase("click") || TextUtils.isEmpty(conditionActionItem.mConditionKey)) {
                                o00000Oo.f11164O000000o = new hot().O000000o(0, null);
                            }
                        } else if (conditionActionItem.mConditionSrc.equalsIgnoreCase("cloud")) {
                            String optString = conditionActionItem.modelListJobj.optString("virtual");
                            if (!TextUtils.isEmpty(optString)) {
                                o00000Oo.f11164O000000o = SceneApi.O000000o.O000000o(hpu.O000000o().O00000Oo.O00000Oo.optJSONObject(optString));
                                if (o00000Oo.f11164O000000o.O0000OoO == null) {
                                    o00000Oo.f11164O000000o.O0000OoO = new SceneApi.O0000o00();
                                }
                                o00000Oo.f11164O000000o.O0000OoO.O00000oO = gwq.O000000o().O00000o().O000000o();
                                o00000Oo.f11164O000000o.O0000OoO.O00000oo = gwq.O000000o().O00000o().O00000o();
                                SceneApi.O0000o00 o0000o00 = o00000Oo.f11164O000000o.O0000OoO;
                                o0000o00.O0000O0o = gwq.O000000o().O00000o().O00000o() + o00000Oo.f11164O000000o.O0000OoO.O00000Oo;
                            }
                        } else {
                            if (conditionActionItem.mConditionSrc.equalsIgnoreCase("timer")) {
                                String optString2 = conditionActionItem.modelListJobj.optString("virtual");
                                if (!TextUtils.isEmpty(optString2)) {
                                    o00000Oo.f11164O000000o = SceneApi.O000000o.O000000o(hpu.O000000o().O00000Oo.O00000Oo.optJSONObject(optString2));
                                }
                            }
                        }
                        recommendSceneDetailInfo.f11162O000000o.add(o00000Oo);
                    }
                    List<PluginRecommendSceneInfo.ConditionActionItem> list2 = recommendSceneItem.mActionList;
                    recommendSceneDetailInfo.O00000Oo.clear();
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        PluginRecommendSceneInfo.ConditionActionItem conditionActionItem2 = list2.get(i2);
                        RecommendSceneDetailInfo.O000000o o000000o = new RecommendSceneDetailInfo.O000000o();
                        o000000o.O00000oO = conditionActionItem2.modelListJobj;
                        o000000o.O00000o0 = conditionActionItem2.mGidJArray;
                        o000000o.O00000oo = conditionActionItem2.actionType;
                        o000000o.O0000O0o = conditionActionItem2.name;
                        if (o000000o.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                            JSONObject jSONObject2 = conditionActionItem2.modelListJobj;
                            Iterator<String> keys3 = jSONObject2.keys();
                            while (keys3.hasNext()) {
                                List<Device> O0000Ooo2 = fno.O000000o().O0000Ooo(keys3.next());
                                if (O0000Ooo2 != null) {
                                    o000000o.O00000Oo.addAll(O0000Ooo2);
                                }
                            }
                            if (o000000o.O00000Oo.size() > 0) {
                                o000000o.f11163O000000o = RecommendSceneDetailInfo.O000000o(o000000o.O00000Oo.get(0).model, jSONObject2.getString(o000000o.O00000Oo.get(0).model));
                                if (!(hpu.O000000o().O00000Oo.f515O000000o == null || (optJSONObject = hpu.O000000o().O00000Oo.f515O000000o.optJSONObject(jSONObject2.getString(o000000o.O00000Oo.get(0).model))) == null)) {
                                    o000000o.O0000OOo = optJSONObject.optString("fw_version", "");
                                }
                            } else {
                                Iterator<String> keys4 = jSONObject2.keys();
                                if (keys4.hasNext()) {
                                    String next2 = keys4.next();
                                    o000000o.f11163O000000o = RecommendSceneDetailInfo.O000000o(next2, jSONObject2.getString(next2));
                                }
                            }
                        } else if (o000000o.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_PUSH.value) {
                            o000000o.f11163O000000o = new hnt().O000000o("", 0, null, null);
                            ((SceneApi.O000OO) o000000o.f11163O000000o.O0000O0o).O00000Oo = recommendSceneDetailInfo.O00000oo;
                        }
                        recommendSceneDetailInfo.O00000Oo.add(o000000o);
                    }
                    recommendSceneDetailInfo.O000000o();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            o000OOOo = new SceneApi.O000OOOo();
            o000OOOo.O0000oO = new SceneApi.O0000o0();
            o000OOOo.O00000Oo = recommendSceneDetailInfo.O00000oo;
            o000OOOo.O0000Oo0 = recommendSceneDetailInfo.O0000O0o == 1;
            o000OOOo.O0000Oo = recommendSceneDetailInfo.O0000OOo == 1;
            o000OOOo.O00000o = Integer.valueOf(recommendSceneDetailInfo.O00000oO).intValue();
            if (recommendSceneDetailInfo.O0000Oo0 == 30) {
                o000OOOo.O0000oO0 = true;
            } else {
                o000OOOo.O0000oO0 = false;
            }
            if (recommendSceneDetailInfo.f11162O000000o != null) {
                for (int i3 = 0; i3 < recommendSceneDetailInfo.f11162O000000o.size(); i3++) {
                    RecommendSceneDetailInfo.O00000Oo o00000Oo2 = recommendSceneDetailInfo.f11162O000000o.get(i3);
                    if (o00000Oo2.O00000oo.equalsIgnoreCase("device")) {
                        if (o00000Oo2.O00000Oo.size() != 0) {
                            for (int i4 = 0; i4 < o00000Oo2.O00000Oo.size(); i4++) {
                                Device device = o00000Oo2.O00000Oo.get(i4);
                                if (!(o00000Oo2.O00000o.get(device.did) == null || !o00000Oo2.O00000o.get(device.did).booleanValue() || (O00000Oo2 = RecommendSceneDetailInfo.O00000Oo(device.model, o00000Oo2.O00000oO.optString(device.model))) == null || O00000Oo2.O00000o0 == null || o000OOOo.O0000O0o == null)) {
                                    O00000Oo2.O00000o0.f11122O000000o = device.did;
                                    o000OOOo.O0000O0o.add(O00000Oo2);
                                }
                            }
                        }
                    } else if (!(o00000Oo2.f11164O000000o == null || o000OOOo.O0000O0o == null)) {
                        o000OOOo.O0000O0o.add(o00000Oo2.f11164O000000o);
                    }
                }
            }
            if (recommendSceneDetailInfo.O00000Oo != null) {
                for (int i5 = 0; i5 < recommendSceneDetailInfo.O00000Oo.size(); i5++) {
                    RecommendSceneDetailInfo.O000000o o000000o2 = recommendSceneDetailInfo.O00000Oo.get(i5);
                    if (o000000o2.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                        if (o000000o2.O00000Oo.size() != 0) {
                            for (int i6 = 0; i6 < o000000o2.O00000Oo.size(); i6++) {
                                Device device2 = o000000o2.O00000Oo.get(i6);
                                if (!(o000000o2.O00000o.get(device2.did) == null || !o000000o2.O00000o.get(device2.did).booleanValue() || ((!TextUtils.isEmpty(str) && (TextUtils.isEmpty(str) || !TextUtils.equals(str, device2.did))) || (O000000o2 = RecommendSceneDetailInfo.O000000o(device2.model, o000000o2.O00000oO.optString(device2.model))) == null || O000000o2.O0000O0o == null))) {
                                    O000000o2.O0000O0o.O00000o = device2.did;
                                    SceneApi.O000OO00 o000oo00 = O000000o2.O0000O0o;
                                    o000oo00.O00000o0 = device2.model + "." + O000000o2.O0000O0o.O00000o0;
                                    O000000o2.O00000Oo = device2.name;
                                    o000OOOo.O00000oo.add(O000000o2);
                                }
                            }
                        }
                    } else if (o000000o2.f11163O000000o != null) {
                        o000OOOo.O00000oo.add(o000000o2.f11163O000000o);
                    }
                }
            }
        }
        if (o000OOOo != null) {
            O000000o(o000OOOo, hqy);
        } else if (hqy != null) {
            hqy.onSaveCloudFail(-9990, "create scene from RecommendSceneItem fail");
        }
    }
}
