package _m_j;

import android.text.TextUtils;
import android.text.format.Time;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hqb {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O00000Oo> f518O000000o = null;
    public boolean O00000Oo = false;

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f520O000000o;
        public boolean O00000Oo = false;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        public int O0000Oo = 0;
        public int O0000Oo0;
        public List<O000000o> O0000OoO = new ArrayList();
        public String O0000Ooo;
        public int O0000o00;

        private static O00000Oo O000000o(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.f520O000000o = jSONObject2.optLong("time");
            if (o00000Oo.f520O000000o == 0) {
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "SceneLogInfo", System.currentTimeMillis() + "====SceneLogInfo cFJson: time=0");
            }
            Time time = new Time();
            time.set(o00000Oo.f520O000000o * 1000);
            o00000Oo.O00000o0 = String.valueOf(time.monthDay);
            o00000Oo.O00000o = String.valueOf(time.month + 1);
            o00000Oo.O00000oO = String.valueOf(time.weekDay);
            o00000Oo.O00000oo = String.valueOf(time.year);
            o00000Oo.O0000O0o = jSONObject2.optString("name");
            o00000Oo.O0000Ooo = jSONObject2.optString("userSceneId");
            o00000Oo.O0000o00 = jSONObject2.optInt("sceneType");
            if (o00000Oo.f520O000000o != 0 && TextUtils.equals("1", o00000Oo.O00000o0) && TextUtils.equals("1", o00000Oo.O00000o) && TextUtils.equals("1970", o00000Oo.O00000oo)) {
                LogType logType2 = LogType.GENERAL;
                gsy.O000000o(logType2, "SceneLogInfo", System.currentTimeMillis() + "====SceneLogInfo new Time error");
            }
            o00000Oo.O0000Oo0 = R.drawable.scene_log_new_icon;
            StringBuilder sb = new StringBuilder();
            String str = "0";
            sb.append(time.hour < 10 ? str : "");
            sb.append(String.valueOf(time.hour));
            sb.append(":");
            if (time.minute >= 10) {
                str = "";
            }
            sb.append(str);
            sb.append(String.valueOf(time.minute));
            o00000Oo.O0000OOo = sb.toString();
            JSONArray optJSONArray = jSONObject2.optJSONArray("msg");
            o00000Oo.O0000Oo = 0;
            if (optJSONArray != null) {
                int i = 0;
                boolean z = true;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    O000000o o000000o = new O000000o();
                    o000000o.f519O000000o = optJSONObject.optInt("t");
                    if (o000000o.f519O000000o == 1) {
                        o000000o.O00000Oo = ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_push_action);
                        o000000o.O00000o0 = "";
                    } else {
                        o000000o.O00000Oo = optJSONObject.optString("targetDesc");
                        o000000o.O00000o0 = optJSONObject.optString("methodDesc");
                    }
                    z &= optJSONObject.optBoolean("dev_con_state", false);
                    o000000o.O00000oO = optJSONObject.optInt("error");
                    o000000o.O00000oo = optJSONObject.optString("us_id");
                    o000000o.O0000O0o = optJSONObject.optInt("sceneType");
                    if (o000000o.O00000oO != 0) {
                        i++;
                    }
                    if (!TextUtils.isEmpty(o000000o.O00000Oo)) {
                        o00000Oo.O0000OoO.add(o000000o);
                    }
                }
                if (i == optJSONArray.length()) {
                    o00000Oo.O0000Oo = -1;
                } else if (i == 0) {
                    o00000Oo.O0000Oo = 0;
                } else {
                    o00000Oo.O0000Oo = 1;
                }
                if (z) {
                    return null;
                }
            }
            if (o00000Oo.f520O000000o == 0 && o00000Oo.O0000Oo == 0 && TextUtils.isEmpty(o00000Oo.O0000O0o) && o00000Oo.O0000OoO.size() == 0) {
                LogType logType3 = LogType.GENERAL;
                gsy.O000000o(logType3, "SceneLogInfo", System.currentTimeMillis() + " ===all empty createFromJson:   " + jSONObject.toString());
                LogType logType4 = LogType.GENERAL;
                gsy.O000000o(logType4, "SceneLogInfo", System.currentTimeMillis() + " ===all empty mSceneLog: " + o00000Oo.toString());
                if (gfr.O0000Ooo) {
                    gsy.O00000o0(LogType.GENERAL, "", jSONObject.toString());
                }
                return null;
            }
            if (o00000Oo.f520O000000o == 0 || TextUtils.isEmpty(o00000Oo.O0000O0o)) {
                LogType logType5 = LogType.GENERAL;
                gsy.O000000o(logType5, "SceneLogInfo", "SceneLog createFromJson:   " + jSONObject.toString());
                LogType logType6 = LogType.GENERAL;
                gsy.O000000o(logType6, "SceneLogInfo", "SceneLog mSceneLog: " + o00000Oo.toString());
            }
            return o00000Oo;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
            if (r4 == false) goto L_0x00a3;
         */
        public static List<O00000Oo> O000000o(JSONArray jSONArray) {
            O00000Oo O000000o2;
            boolean z;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (O000000o2 = O000000o(optJSONObject)) == null)) {
                    if (!TextUtils.equals("1", O000000o2.O00000o0) || !TextUtils.equals("1", O000000o2.O00000o) || !TextUtils.equals("1970", O000000o2.O00000oo)) {
                        if (arrayList.size() != 0) {
                            O00000Oo o00000Oo = (O00000Oo) arrayList.get(arrayList.size() - 1);
                            if (!TextUtils.isEmpty(O000000o2.O00000o0) && !TextUtils.isEmpty(O000000o2.O00000o) && !TextUtils.isEmpty(O000000o2.O00000o) && (!TextUtils.equals(O000000o2.O00000o0, o00000Oo.O00000o0) || !TextUtils.equals(O000000o2.O00000o, o00000Oo.O00000o) || !TextUtils.equals(O000000o2.O00000oo, o00000Oo.O00000oo))) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                        O00000Oo o00000Oo2 = new O00000Oo();
                        o00000Oo2.O00000Oo = true;
                        o00000Oo2.O00000o0 = O000000o2.O00000o0;
                        o00000Oo2.O00000o = O000000o2.O00000o;
                        o00000Oo2.O00000oO = O000000o2.O00000oO;
                        o00000Oo2.O00000oo = O000000o2.O00000oo;
                        arrayList.add(o00000Oo2);
                        arrayList.add(O000000o2);
                    } else {
                        LogType logType = LogType.GENERAL;
                        gsy.O000000o(logType, "SceneLogInfo", System.currentTimeMillis() + "====SceneLogInfo convert time item error");
                    }
                }
            }
            LogType logType2 = LogType.GENERAL;
            gsy.O000000o(logType2, "SceneLogInfo", System.currentTimeMillis() + "====SceneLogInfo logList size is " + arrayList.size());
            return arrayList;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("bTimeTag: " + this.O00000Oo + "   day: " + this.O00000o0);
            sb.append("  month: " + this.O00000o + "  week: " + this.O00000oO);
            sb.append("  year: " + this.O00000oo + "  title: " + this.O0000O0o);
            sb.append("  time: " + this.O0000OOo + "  icon： " + this.O0000Oo0);
            sb.append("  result： " + this.O0000Oo + "  mSceneId: " + this.O0000Ooo);
            for (O000000o o000000o : this.O0000OoO) {
                sb.append("\n");
                sb.append(o000000o.toString());
                sb.append("   ");
            }
            return sb.toString();
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f519O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public int O00000oO;
        public String O00000oo;
        public int O0000O0o;

        public final String toString() {
            return "type: " + this.f519O000000o + "   name: " + this.O00000Oo + "   detail: " + this.O00000o0 + "   result: " + this.O00000o + "   usId: " + this.O00000oo;
        }
    }
}
