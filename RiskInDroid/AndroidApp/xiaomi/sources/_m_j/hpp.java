package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hpp {

    /* renamed from: O000000o  reason: collision with root package name */
    static Map<String, JSONObject[]> f477O000000o = new LinkedHashMap();
    static Set<String> O00000Oo;
    private static final hpp O00000o0 = new hpp();

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        O00000Oo = linkedHashSet;
        linkedHashSet.add("^event\\.(\\S*)sensor_switch.v(\\S*)\\.click$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.v(\\S*)\\.double_click$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.v(\\S*)\\.long_click_press$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.aq2(\\S*)\\.click$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.aq2(\\S*)\\.double_click$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.aq2(\\S*)\\.long_click_press$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.aq3(\\S*)\\.click$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.aq3(\\S*)\\.double_click$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.aq3(\\S*)\\.long_click_press$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.aq3(\\S*)\\.long_click_release$");
        O00000Oo.add("^event\\.(\\S*)sensor_switch.aq3(\\S*)\\.shake$");
        O00000Oo.add("^event\\.(\\S+)\\.neutral_0_click$");
        O00000Oo.add("^event\\.(\\S+)\\.neutral_1_click$");
        O00000Oo.add("^event\\.(\\S*)sensor_86sw1(\\S*)\\.click_ch0$");
        O00000Oo.add("^event\\.(\\S*)sensor_86sw1(\\S*)\\.double_click_ch0$");
        O00000Oo.add("^event\\.(\\S*)sensor_86sw2(\\S*)\\.click_ch0$");
        O00000Oo.add("^event\\.(\\S*)sensor_86sw2(\\S*)\\.double_click_ch0$");
        O00000Oo.add("^event\\.(\\S*)sensor_86sw2(\\S*)\\.click_ch1$");
        O00000Oo.add("^event\\.(\\S*)sensor_86sw2(\\S*)\\.double_click_ch1$");
        O00000Oo.add("^event\\.(\\S*)sensor_86sw2(\\S*)\\.both_click$");
        O00000Oo.add("^event\\.(\\S+)\\.flip180$");
        O00000Oo.add("^event\\.(\\S+)\\.flip90$");
        O00000Oo.add("^event\\.(\\S+)\\.move$");
        O00000Oo.add("^event\\.(\\S+)\\.rotate$");
        O00000Oo.add("^event\\.(\\S+)\\.shake_air$");
        O00000Oo.add("^event\\.(\\S+)\\.tap_twice$");
    }

    public static hpp O000000o() {
        return O00000o0;
    }

    public final void O000000o(final SceneInfo sceneInfo, final Callback<SceneInfo> callback) {
        if (callback != null) {
            if (sceneInfo == null) {
                callback.onFailure(-1, "sceneInfo is null...");
            } else {
                O000000o(new Callback<Boolean>() {
                    /* class _m_j.hpp.AnonymousClass1 */

                    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f3  */
                    /* JADX WARNING: Removed duplicated region for block: B:96:0x01a8 A[SYNTHETIC, Splitter:B:96:0x01a8] */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        int i;
                        boolean z;
                        List<SceneInfo.SceneAction> list;
                        String str;
                        JSONObject[] jSONObjectArr;
                        String str2;
                        boolean z2;
                        JSONArray jSONArray;
                        boolean z3;
                        JSONObject[] jSONObjectArr2;
                        if (((Boolean) obj).booleanValue()) {
                            SceneInfo sceneInfo = sceneInfo;
                            Iterator<SceneInfo.SceneLaunch> it = sceneInfo.mLaunchList.iterator();
                            while (true) {
                                String str3 = null;
                                i = 0;
                                if (!it.hasNext()) {
                                    break;
                                }
                                SceneInfo.SceneLaunch next = it.next();
                                if (!(next == null || next.mEventString == null)) {
                                    for (String next2 : hpp.f477O000000o.keySet()) {
                                        if (next.mEventString.matches(next2)) {
                                            str3 = next2;
                                        }
                                    }
                                    if (!(str3 == null || (jSONObjectArr2 = hpp.f477O000000o.get(str3)) == null || jSONObjectArr2.length != 2)) {
                                        JSONObject jSONObject = jSONObjectArr2[0];
                                        JSONObject jSONObject2 = jSONObjectArr2[1];
                                        try {
                                            if (jSONObject.length() == 1) {
                                                hpl.O000000o().O000000o(next, jSONObject.getJSONObject(jSONObject.keys().next()).getJSONArray("active").toString(), str3);
                                            } else {
                                                String optString = jSONObject2.optString(next.mEventValue.toString());
                                                if (optString != null) {
                                                    hpl.O000000o().O000000o(next, jSONObject.getJSONObject(optString).getJSONArray("active").toString(), str3);
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                            List<SceneInfo.SceneLaunch> list2 = sceneInfo.mLaunchList;
                            if (list2 != null && list2.size() != 0) {
                                Iterator<SceneInfo.SceneLaunch> it2 = list2.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    SceneInfo.SceneLaunch next3 = it2.next();
                                    if (next3 != null) {
                                        String str4 = next3.mEventString;
                                        Iterator<String> it3 = hpp.O00000Oo.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                if (str4.matches(it3.next())) {
                                                    z3 = true;
                                                    break;
                                                }
                                            } else {
                                                z3 = false;
                                                break;
                                            }
                                        }
                                        if (z3) {
                                            break;
                                        }
                                    }
                                }
                                for (SceneInfo.SceneAction next4 : sceneInfo.mActions) {
                                    if (!(next4 == null || next4.mActionString == null)) {
                                        Iterator<String> it4 = hpp.f477O000000o.keySet().iterator();
                                        while (true) {
                                            if (!it4.hasNext()) {
                                                str = null;
                                                break;
                                            }
                                            str = it4.next();
                                            if (next4.mActionString.matches(str)) {
                                                break;
                                            }
                                        }
                                        if (!(str == null || (jSONObjectArr = hpp.f477O000000o.get(str)) == null || jSONObjectArr.length != 2)) {
                                            JSONObject jSONObject3 = jSONObjectArr[0];
                                            JSONObject jSONObject4 = jSONObjectArr[1];
                                            try {
                                                if (jSONObject3.length() == 1) {
                                                    str2 = jSONObject3.keys().next();
                                                } else {
                                                    str2 = jSONObject4.optString(hpp.O000000o(next4));
                                                }
                                                if (TextUtils.isEmpty(str2)) {
                                                    str2 = "default";
                                                }
                                                JSONObject jSONObject5 = jSONObject3.getJSONObject(str2);
                                                if (!z) {
                                                    Iterator<String> keys = jSONObject5.keys();
                                                    while (true) {
                                                        if (keys.hasNext()) {
                                                            if (keys.next().equalsIgnoreCase("nonActive")) {
                                                                z2 = true;
                                                                break;
                                                            }
                                                        } else {
                                                            z2 = false;
                                                            break;
                                                        }
                                                    }
                                                    if (z2) {
                                                        jSONArray = jSONObject5.getJSONArray("nonActive");
                                                    } else {
                                                        jSONArray = jSONObject5.getJSONArray("active");
                                                    }
                                                    hph.O000000o().O000000o(next4, sceneInfo, jSONArray.toString(), str);
                                                } else {
                                                    hph.O000000o().O000000o(next4, sceneInfo, jSONObject5.getJSONArray("active").toString(), str);
                                                }
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                list = sceneInfo.mActions;
                                if (list != null) {
                                    try {
                                        for (SceneInfo.SceneAction next5 : list) {
                                            if (!"delay.delay".equalsIgnoreCase(next5.mActionString)) {
                                                next5.mDelayTime = i;
                                            } else {
                                                i += next5.mDelayTime;
                                            }
                                        }
                                    } catch (NoSuchFieldError e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                callback.onSuccess(sceneInfo);
                                return;
                            }
                            z = true;
                            while (r1.hasNext()) {
                            }
                            list = sceneInfo.mActions;
                            if (list != null) {
                            }
                            callback.onSuccess(sceneInfo);
                            return;
                        }
                        callback.onFailure(-1, "getCloudExtra error");
                    }

                    public final void onFailure(int i, String str) {
                        callback.onFailure(i, str);
                    }
                });
            }
        }
    }

    private void O000000o(final Callback<Boolean> callback) {
        XmPluginHostApi.instance().getAppConfig(gfr.O0000oo0 ? "lumi_extra_map_info_preview" : "lumi_extra_map_info", "en", "4", new Callback<String>() {
            /* class _m_j.hpp.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    callback.onSuccess(Boolean.valueOf(hpp.O000000o(str)));
                    return;
                }
                callback.onSuccess(Boolean.FALSE);
            }

            public final void onFailure(int i, String str) {
                callback.onFailure(i, str);
            }
        });
    }

    public static boolean O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.opt(next) instanceof JSONArray) {
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() == 2 && (jSONArray.get(0) instanceof JSONObject) && (jSONArray.get(1) instanceof JSONObject)) {
                        f477O000000o.put(next, new JSONObject[]{(JSONObject) jSONArray.get(0), (JSONObject) jSONArray.get(1)});
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static String O000000o(SceneInfo.SceneAction sceneAction) {
        if (sceneAction.mDeviceModel.equals("lumi.airrtc.vrfegl01")) {
            try {
                JSONArray jSONArray = new JSONArray(sceneAction.mActionValue.toString());
                JSONArray jSONArray2 = new JSONArray();
                if (jSONArray.length() == 2) {
                    jSONArray2.put(jSONArray.get(0));
                    jSONArray2.put(String.valueOf(jSONArray.get(1)));
                    return jSONArray2.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sceneAction.mActionValue.toString();
    }
}
