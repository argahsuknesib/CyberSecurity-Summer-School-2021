package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.chr;
import _m_j.chy;
import _m_j.cki;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.lowpower.LinkageManager;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LongTimeAlarmManager {
    public static String LONG_TIME_SPEC_P = "chuangmi-clocks";
    public static String LONG_TIME_SPEC_S = "chuangmi-ai";
    public static String TAG = "LongTimeAlarmManager";

    public interface LongTimeAlarmListener {
        void onAlarmValueSetSuccess();

        void onAlarmValueUpdateFailed(int i, String str);

        void onAlarmValueUpdateSuccess(Map<Integer, String> map);

        void onUpdateFailed(int i, String str);

        void onUpdateSuccess();
    }

    public static void addDefaultTimer(String str, String str2, chy chy, Context context, LongTimeAlarmListener longTimeAlarmListener) {
        updateTimer(str, str2, chy, getDefaultList(context), longTimeAlarmListener);
    }

    public static List<LongTimeAlarm> getDefaultList(Context context) {
        ArrayList arrayList = new ArrayList();
        LongTimeAlarm longTimeAlarm = new LongTimeAlarm();
        longTimeAlarm.enable = false;
        longTimeAlarm.time_start = "07:00";
        longTimeAlarm.time_end = "09:00";
        longTimeAlarm.repeat = 127;
        longTimeAlarm.alarmValue = context.getString(R.string.detect_nobody_in_morning);
        arrayList.add(longTimeAlarm);
        LongTimeAlarm longTimeAlarm2 = new LongTimeAlarm();
        longTimeAlarm2.enable = false;
        longTimeAlarm2.time_start = "11:00";
        longTimeAlarm2.time_end = "13:00";
        longTimeAlarm2.repeat = 127;
        longTimeAlarm2.alarmValue = context.getString(R.string.nobody_have_lunch);
        arrayList.add(longTimeAlarm2);
        LongTimeAlarm longTimeAlarm3 = new LongTimeAlarm();
        longTimeAlarm3.enable = false;
        longTimeAlarm3.time_start = "06:00";
        longTimeAlarm3.time_end = "20:00";
        longTimeAlarm3.repeat = 127;
        longTimeAlarm3.alarmValue = context.getString(R.string.detect_nobody_in_day);
        arrayList.add(longTimeAlarm3);
        return arrayList;
    }

    public static void updateTimer(final String str, final String str2, chy chy, final List<LongTimeAlarm> list, final LongTimeAlarmListener longTimeAlarmListener) {
        SpecService O000000o2 = chy.O000000o(LONG_TIME_SPEC_S);
        SpecProperty O000000o3 = chy.O000000o(O000000o2, LONG_TIME_SPEC_P);
        if (O000000o2 == null || O000000o3 == null) {
            gsy.O00000Oo(TAG, "no specService and specProperty error");
            return;
        }
        faw.O000000o().setDeviceProp(str2, O000000o3, getLongTimeJsonData(list), new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.LongTimeAlarmManager.AnonymousClass1 */

            public final void onSuccess(JSONObject jSONObject) {
                longTimeAlarmListener.onUpdateSuccess();
                LongTimeAlarmManager.setAlarmKey(str, str2, list, longTimeAlarmListener);
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (LongTimeAlarm longTimeAlarm : list) {
                        if (longTimeAlarm.enable) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("starttime", longTimeAlarm.time_start);
                            jSONObject2.put("finishtime", longTimeAlarm.time_end);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    String str = LongTimeAlarmManager.TAG;
                    gsy.O00000Oo(str, "LongTimeAlarm size=" + jSONArray.length());
                    if (jSONArray.length() > 0) {
                        chr.O000000o(chr.O00Oo00, "value", jSONArray);
                    }
                } catch (Exception e) {
                    gsy.O00000Oo(LongTimeAlarmManager.TAG, e.toString());
                }
            }

            public final void onFailure(fso fso) {
                if (fso != null) {
                    longTimeAlarmListener.onUpdateFailed(fso.f17063O000000o, fso.O00000Oo);
                } else {
                    longTimeAlarmListener.onUpdateFailed(-1, null);
                }
            }
        });
    }

    public static void setAlarmKey(String str, String str2, List<LongTimeAlarm> list, final LongTimeAlarmListener longTimeAlarmListener) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).alarmValue);
        }
        LinkageManager.getInstance().setAlarmKey(str, str2, arrayList, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.LongTimeAlarmManager.AnonymousClass2 */

            public final void onSuccess(JSONObject jSONObject) {
                String str = LongTimeAlarmManager.TAG;
                gsy.O000000o(3, str, "LinkageManager.getInstance().setAlarmKey onSuccess: " + jSONObject.toString());
                longTimeAlarmListener.onAlarmValueSetSuccess();
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(3, LongTimeAlarmManager.TAG, "LinkageManager.getInstance().setAlarmKey onFailure: ".concat(String.valueOf(str)));
            }
        });
    }

    public static String getLongTimeJsonData(List<LongTimeAlarm> list) {
        int i = 0;
        while (i < list.size()) {
            i++;
            list.get(i).key = i;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            LongTimeAlarm longTimeAlarm = list.get(i2);
            if (longTimeAlarm != null) {
                jSONArray.put(longTimeAlarm.toJSON());
            }
        }
        try {
            jSONObject.put("values", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getRepeatStr(Context context, int i) {
        if (i == 0) {
            return context.getString(R.string.plug_timer_onetime);
        }
        if (127 == i) {
            return context.getString(R.string.smarthome_scene_timer_everyday);
        }
        String[] stringArray = context.getResources().getStringArray(R.array.weekday_long_time);
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        for (int i3 = 0; i3 < stringArray.length; i3++) {
            if ((i & i2) != 0) {
                if (!TextUtils.isEmpty(sb.toString())) {
                    sb.append(", ");
                }
                sb.append(stringArray[i3]);
            }
            i2 <<= 1;
        }
        return sb.toString();
    }

    public static boolean[] getWeekList(int i) {
        boolean[] zArr = new boolean[7];
        int i2 = 1;
        for (int i3 = 0; i3 < 7; i3++) {
            if ((i & i2) != 0) {
                zArr[i3] = true;
            } else {
                zArr[i3] = false;
            }
            i2 <<= 1;
        }
        return zArr;
    }

    public static int getRepeat(boolean[] zArr) {
        int i = 0;
        int i2 = 1;
        for (boolean z : zArr) {
            if (z) {
                i |= i2;
            }
            i2 <<= 1;
        }
        return i;
    }

    public static String formatTime(Context context, int i, String str, String str2, boolean z) {
        if (z) {
            return str == null ? context.getString(R.string.scene_exetime_no_set) : str;
        }
        if (str2 == null) {
            return context.getString(R.string.scene_exetime_no_set);
        }
        if (str == null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        if (str2.compareTo(str) < 0) {
            sb.append(context.getString(R.string.plug_timer_set_nextday));
            sb.append(" ");
        }
        sb.append(str2);
        return sb.toString();
    }

    public static boolean isLegalTimer(LongTimeAlarm longTimeAlarm) {
        return !longTimeAlarm.time_start.equals(longTimeAlarm.time_end);
    }

    public static List<LongTimeAlarm> parseTimerList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("values");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    LongTimeAlarm longTimeAlarm = new LongTimeAlarm();
                    longTimeAlarm.key = jSONObject.optInt("key");
                    longTimeAlarm.enable = jSONObject.getBoolean("enable");
                    longTimeAlarm.repeat = jSONObject.getInt("repeat");
                    longTimeAlarm.time_end = jSONObject.getString("time_end");
                    try {
                        int parseInt = Integer.parseInt(longTimeAlarm.time_end.split(":")[0]);
                        int parseInt2 = Integer.parseInt(longTimeAlarm.time_end.split(":")[1]);
                        StringBuilder sb = new StringBuilder();
                        sb.append(parseInt < 10 ? "0".concat(String.valueOf(parseInt)) : Integer.valueOf(parseInt));
                        sb.append(":");
                        sb.append(parseInt2 < 10 ? "0".concat(String.valueOf(parseInt2)) : Integer.valueOf(parseInt2));
                        longTimeAlarm.time_end = sb.toString();
                    } catch (Exception e) {
                        cki.O000000o(TAG, e.toString());
                    }
                    longTimeAlarm.time_start = jSONObject.getString("time_start");
                    try {
                        int parseInt3 = Integer.parseInt(longTimeAlarm.time_start.split(":")[0]);
                        int parseInt4 = Integer.parseInt(longTimeAlarm.time_start.split(":")[1]);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(parseInt3 < 10 ? "0".concat(String.valueOf(parseInt3)) : Integer.valueOf(parseInt3));
                        sb2.append(":");
                        sb2.append(parseInt4 < 10 ? "0".concat(String.valueOf(parseInt4)) : Integer.valueOf(parseInt4));
                        longTimeAlarm.time_start = sb2.toString();
                    } catch (Exception e2) {
                        cki.O000000o(TAG, e2.toString());
                    }
                    arrayList.add(longTimeAlarm);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return arrayList;
    }

    public static void getAlarmKey(Context context, final String str, final LongTimeAlarmListener longTimeAlarmListener) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", str);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 1; i < 11; i++) {
                jSONArray2.put(LinkageManager.LONG_TIME_KEY_PREFIX + i);
            }
            jSONObject.put("props", jSONArray2);
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        faw.O00000o().getDeviceProfileProp(context, jSONArray, new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.LongTimeAlarmManager.AnonymousClass3 */

            public final void onSuccess(String str) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject(str);
                    for (int i = 1; i < 11; i++) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(LinkageManager.LONG_TIME_KEY_PREFIX + i);
                        if (optJSONObject2 != null) {
                            hashMap.put(Integer.valueOf(i), optJSONObject2.getString("value"));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                longTimeAlarmListener.onAlarmValueUpdateSuccess(hashMap);
            }

            public final void onFailure(fso fso) {
                if (fso != null) {
                    longTimeAlarmListener.onAlarmValueUpdateFailed(fso.f17063O000000o, fso.O00000Oo);
                } else {
                    longTimeAlarmListener.onAlarmValueUpdateFailed(-1, null);
                }
            }
        }, null);
    }
}
