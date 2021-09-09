package com.xiaomi.smarthome.scene.api;

import _m_j.fno;
import _m_j.ftn;
import _m_j.gsy;
import _m_j.hpq;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.bean.WeatherConditionType;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SceneApi {

    public static abstract class O000O0o {
        public abstract JSONObject O000000o() throws JSONException;
    }

    public static class O000O0o0 extends O000OO00 {
        public final JSONObject O000000o() throws JSONException {
            return null;
        }
    }

    public static abstract class O000OO00 {
        public String O00000o;
        public String O00000o0;
        public Object O00000oO;
        public int O00000oo = 0;
        public long O0000O0o;

        public abstract JSONObject O000000o() throws JSONException;
    }

    public static class O000OOOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11131O000000o;
        public String O00000Oo;
        public int O00000o = -1;
        @Deprecated
        public boolean O00000o0 = false;
        public String O00000oO;
        public List<Action> O00000oo = new ArrayList();
        public List<O000000o> O0000O0o = new ArrayList();
        @Deprecated
        public boolean O0000OOo;
        public boolean O0000Oo = false;
        public boolean O0000Oo0 = true;
        public boolean O0000OoO = false;
        public int O0000Ooo = 0;
        public int O0000o;
        public ArrayList<String> O0000o0 = new ArrayList<>();
        public int O0000o00 = -1;
        public int O0000o0O = -1;
        public int O0000o0o;
        public O0000o0 O0000oO;
        public boolean O0000oO0;
        public boolean O0000oOO = false;
        public List<String> O0000oOo = new ArrayList();
        public O000000o O0000oo0 = null;

        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ce, code lost:
            return false;
         */
        public final boolean O000000o(O000OOOo o000OOOo) {
            O000000o o000000o;
            O0000o0 o0000o0;
            int i;
            if (this.O0000Oo0 != o000OOOo.O0000Oo0 || this.O0000Ooo != o000OOOo.O0000Ooo || (!TextUtils.isEmpty(o000OOOo.O00000Oo) && !TextUtils.isEmpty(this.O00000Oo) && !TextUtils.equals(o000OOOo.O00000Oo, this.O00000Oo))) {
                return false;
            }
            if (o000OOOo.O0000oO0 && this.O0000oO0) {
                if (this.O0000o00 != o000OOOo.O0000o00) {
                    return false;
                }
                if (this.O0000o0 == null && o000OOOo.O0000o0 != null) {
                    return false;
                }
                if (this.O0000o0 != null && o000OOOo.O0000o0 == null) {
                    return false;
                }
                ArrayList<String> arrayList = this.O0000o0;
                if (arrayList != null && o000OOOo.O0000o0 != null && (arrayList.size() != o000OOOo.O0000o0.size() || !this.O0000o0.containsAll(o000OOOo.O0000o0) || !o000OOOo.O0000o0.containsAll(this.O0000o0))) {
                    return false;
                }
                int i2 = this.O0000o0O;
                if (!(i2 == -1 || (i = o000OOOo.O0000o0O) == -1 || i2 == i)) {
                    return false;
                }
            }
            hpq.O000000o();
            boolean O00000o02 = hpq.O00000o0(this.O0000O0o);
            hpq.O000000o();
            if (O00000o02 != hpq.O00000o0(o000OOOo.O0000O0o) || this.O0000O0o.size() != o000OOOo.O0000O0o.size()) {
                return false;
            }
            int i3 = 0;
            while (i3 < this.O0000O0o.size()) {
                try {
                    if ((this.O0000O0o.get(i3) == null && o000OOOo.O0000O0o.get(i3) != null) || ((this.O0000O0o.get(i3) != null && o000OOOo.O0000O0o.get(i3) == null) || !TextUtils.equals(this.O0000O0o.get(i3).O000000o().toString(), o000OOOo.O0000O0o.get(i3).O000000o().toString()))) {
                        return false;
                    }
                    i3++;
                } catch (JSONException e) {
                    e.getStackTrace();
                    return false;
                }
            }
            hpq.O000000o();
            if (!hpq.O00000o0(this.O0000O0o)) {
                O0000o0 o0000o02 = this.O0000oO;
                if (o0000o02 == null || (o0000o0 = o000OOOo.O0000oO) == null) {
                    if (!(this.O0000oO == null && o000OOOo.O0000oO == null)) {
                        return false;
                    }
                } else if (!o0000o02.O000000o(o0000o0)) {
                    return false;
                }
            }
            if (this.O00000oo.size() != o000OOOo.O00000oo.size()) {
                return false;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.O00000oo.size(); i5++) {
                if (!(this.O00000oo.get(i5).O0000O0o instanceof O000O0o0)) {
                    try {
                        this.O00000oo.get(i5).O0000O0o.O00000oo = i4;
                        o000OOOo.O00000oo.get(i5).O0000O0o.O00000oo = i4;
                        if (!this.O00000oo.get(i5).O000000o().toString().equalsIgnoreCase(o000OOOo.O00000oo.get(i5).O000000o().toString())) {
                            this.O00000oo.get(i5).O0000O0o.O00000oo = 0;
                            o000OOOo.O00000oo.get(i5).O0000O0o.O00000oo = 0;
                            return false;
                        }
                        this.O00000oo.get(i5).O0000O0o.O00000oo = 0;
                        o000OOOo.O00000oo.get(i5).O0000O0o.O00000oo = 0;
                    } catch (JSONException unused) {
                        return false;
                    }
                } else if (!(o000OOOo.O00000oo.get(i5).O0000O0o instanceof O000O0o0) || ((O000O0o0) this.O00000oo.get(i5).O0000O0o).O00000oo != ((O000O0o0) o000OOOo.O00000oo.get(i5).O0000O0o).O00000oo) {
                    return false;
                } else {
                    i4 += ((O000O0o0) this.O00000oo.get(i5).O0000O0o).O00000oo;
                }
            }
            O000000o o000000o2 = this.O0000oo0;
            if (o000000o2 != null && (o000000o = o000OOOo.O0000oo0) != null) {
                return o000000o2.O000000o(o000000o);
            }
            if (this.O0000oo0 == null && o000OOOo.O0000oo0 == null) {
                return true;
            }
            return false;
        }

        public static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public String f11132O000000o;
            public boolean O00000Oo = false;
            public int O00000o = 0;
            public String O00000o0;
            public List<O000000o> O00000oO = new ArrayList(5);
            public O000000o O00000oo = null;

            public static O000000o O000000o(JSONObject jSONObject) throws JSONException {
                JSONArray optJSONArray;
                JSONObject optJSONObject;
                O000000o O000000o2;
                if (jSONObject == null || jSONObject.isNull("attr") || (optJSONArray = jSONObject.optJSONArray("attr")) == null || optJSONArray.length() <= 0) {
                    return null;
                }
                O000000o o000000o = new O000000o();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    O000000o O000000o3 = O000000o.O000000o(optJSONArray.optJSONObject(i));
                    if (O000000o3 != null) {
                        o000000o.O00000oO.add(O000000o3);
                    }
                }
                o000000o.f11132O000000o = jSONObject.optString("name", null);
                o000000o.O00000o0 = jSONObject.optString("desc", null);
                o000000o.O00000Oo = jSONObject.optBoolean("enable", false);
                o000000o.O00000o = jSONObject.optInt("express", 0);
                if (!(!jSONObject.has("sub_launch") || (optJSONObject = jSONObject.optJSONObject("sub_launch")) == null || (O000000o2 = O000000o(optJSONObject)) == null)) {
                    o000000o.O00000oo = O000000o2;
                }
                return o000000o;
            }

            public final boolean O000000o(O000000o o000000o) {
                O000000o o000000o2;
                O000000o o000000o3 = this;
                while (o000000o != null && o000000o3.O00000Oo == o000000o.O00000Oo && o000000o3.O00000o == o000000o.O00000o && o000000o3.O00000oO.size() == o000000o.O00000oO.size()) {
                    int i = 0;
                    while (i < o000000o3.O00000oO.size()) {
                        try {
                            if (!o000000o3.O00000oO.get(i).O000000o().toString().equalsIgnoreCase(o000000o.O00000oO.get(i).O000000o().toString())) {
                                return false;
                            }
                            i++;
                        } catch (JSONException unused) {
                            return false;
                        }
                    }
                    O000000o o000000o4 = o000000o.O00000oo;
                    if (o000000o4 != null && (o000000o2 = o000000o3.O00000oo) != null) {
                        o000000o3 = o000000o4;
                        o000000o = o000000o2;
                    } else if (o000000o.O00000oo == null && o000000o3.O00000oo == null) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }

            public final JSONObject O000000o() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", this.f11132O000000o);
                jSONObject.put("desc", this.O00000o0);
                jSONObject.put("enable", this.O00000Oo);
                jSONObject.put("express", this.O00000o);
                JSONArray jSONArray = new JSONArray();
                for (O000000o O000000o2 : this.O00000oO) {
                    jSONArray.put(O000000o2.O000000o());
                }
                jSONObject.put("attr", jSONArray);
                O000000o o000000o = this.O00000oo;
                if (o000000o != null) {
                    jSONObject.put("sub_launch", o000000o.O000000o());
                }
                return jSONObject;
            }
        }

        public static O000OOOo O000000o(JSONObject jSONObject, boolean z) throws JSONException {
            JSONArray optJSONArray;
            JSONObject optJSONObject;
            O000000o O000000o2;
            if (jSONObject == null) {
                return null;
            }
            O000OOOo o000OOOo = new O000OOOo();
            o000OOOo.f11131O000000o = jSONObject.optString("us_id");
            o000OOOo.O00000Oo = jSONObject.optString("name");
            if (jSONObject.has("type")) {
                o000OOOo.O0000o = jSONObject.optInt("type");
            }
            if (jSONObject.has("status")) {
                o000OOOo.O0000o0o = jSONObject.optInt("status");
            }
            if (jSONObject.has("create_by_template")) {
                o000OOOo.O00000o0 = jSONObject.getBoolean("create_by_template");
            }
            if (jSONObject.has("local_dev")) {
                o000OOOo.O00000oO = jSONObject.optString("local_dev");
            }
            if (jSONObject.has("sr_id")) {
                o000OOOo.O00000o = jSONObject.getInt("sr_id");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("setting");
            if (optJSONObject2.has("enable_push")) {
                o000OOOo.O0000Oo = optJSONObject2.optInt("enable_push") == 1;
            }
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("launch");
            if (optJSONObject3 == null) {
                return null;
            }
            o000OOOo.O0000Ooo = optJSONObject3.optInt("express");
            JSONArray optJSONArray2 = optJSONObject3.optJSONArray("attr");
            if (optJSONObject3.has("voice_alias")) {
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("voice_alias");
                o000OOOo.O0000o00 = optJSONObject4.optInt("use_title", -1);
                JSONArray optJSONArray3 = optJSONObject4.optJSONArray("alias");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    for (int i = 0; i < optJSONArray3.length(); i++) {
                        o000OOOo.O0000o0.add(optJSONArray3.optString(i));
                    }
                }
            }
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    Object obj = optJSONArray2.get(i2);
                    if ((obj instanceof JSONObject) && (O000000o2 = O000000o.O000000o((JSONObject) obj)) != null) {
                        o000OOOo.O0000O0o.add(O000000o2);
                    }
                }
                if (optJSONObject3.has("sub_launch") && (optJSONObject = optJSONObject3.optJSONObject("sub_launch")) != null) {
                    o000OOOo.O0000oo0 = O000000o.O000000o(optJSONObject);
                }
                if (optJSONObject2.has("timespan")) {
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("timespan");
                    if (optJSONObject5 != null) {
                        o000OOOo.O0000oOO = true;
                        o000OOOo.O0000oO = O0000o0.O000000o(optJSONObject5);
                    }
                } else {
                    o000OOOo.O0000oOO = false;
                }
            }
            o000OOOo.O0000Oo0 = optJSONObject2.optString("enable").equals("1");
            JSONArray optJSONArray4 = optJSONObject2.optJSONArray("action_list");
            if (optJSONArray4 == null) {
                return null;
            }
            if (optJSONArray4.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray4.length(); i3++) {
                    Action O000000o3 = Action.O000000o(optJSONArray4.getJSONObject(i3));
                    if (O000000o3 != null) {
                        o000OOOo.O00000oo.add(O000000o3);
                    }
                }
            }
            if (o000OOOo.O00000oo.size() > 0) {
                O000000o(o000OOOo.O00000oo);
            }
            o000OOOo.O0000oO0 = z;
            if (jSONObject.has("authed") && (optJSONArray = jSONObject.optJSONArray("authed")) != null && optJSONArray.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    o000OOOo.O0000oOo.add(optJSONArray.optString(i4));
                }
            }
            return o000OOOo;
        }

        private static void O000000o(List<Action> list) {
            Collections.sort(list, new Comparator<Action>() {
                /* class com.xiaomi.smarthome.scene.api.SceneApi.O000OOOo.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    Action action = (Action) obj;
                    return action.O0000O0o.O00000oo - action.O0000O0o.O00000oo;
                }
            });
            int i = 0;
            int i2 = 0;
            while (i < list.size()) {
                if (!(list.get(i).O0000O0o == null || list.get(i).O0000O0o.O00000oo == 0)) {
                    if (i == 0 || !(list.get(i - 1) == null || list.get(i).O0000O0o.O00000oo == i2)) {
                        Action action = new Action();
                        action.O0000O0o = new O000O0o0();
                        action.O0000O0o.O00000oo = list.get(i).O0000O0o.O00000oo - i2;
                        action.O0000O0o.O00000o0 = "delay.delay";
                        i2 += action.O0000O0o.O00000oo;
                        list.add(i, action);
                        i++;
                    }
                    list.get(i).O0000O0o.O00000oo = 0;
                }
                i++;
            }
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.O00000Oo);
            if (!TextUtils.isEmpty(this.f11131O000000o)) {
                jSONObject.put("us_id", this.f11131O000000o);
            }
            if (this.O0000oO0) {
                jSONObject.put("st_id", 30);
            } else {
                jSONObject.put("st_id", 15);
            }
            int i = this.O00000o;
            if (i != -1) {
                jSONObject.put("sr_id", i);
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            HashSet<String> hashSet = new HashSet<>();
            jSONObject2.put("enable_push", this.O0000Oo ? 1 : 0);
            if (!this.O0000oO0) {
                JSONArray jSONArray = new JSONArray();
                for (O000000o next : this.O0000O0o) {
                    jSONArray.put(next.O000000o());
                    if (next.O00000o0 != null) {
                        hashSet.add(next.O00000o0.f11122O000000o);
                    }
                }
                O000000o o000000o = this.O0000oo0;
                if (o000000o != null) {
                    jSONObject3.put("sub_launch", o000000o.O000000o());
                }
                jSONObject3.put("attr", jSONArray);
                jSONObject3.put("express", this.O0000Ooo);
                if (this.O0000oO != null) {
                    LogType logType = LogType.SCENE;
                    gsy.O000000o(logType, "SceneApi", "mEffectiveTimeSpan" + this.O0000oO.toString());
                    jSONObject2.put("timespan", this.O0000oO.O000000o());
                } else {
                    gsy.O000000o(LogType.SCENE, "SceneApi", "mEffectiveTimeSpannull");
                }
            } else {
                if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                    JSONObject jSONObject4 = new JSONObject();
                    int i2 = this.O0000o00;
                    if (i2 >= 0) {
                        jSONObject4.put("use_title", i2);
                    }
                    ArrayList<String> arrayList = this.O0000o0;
                    if (arrayList != null && arrayList.size() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i3 = 0; i3 < this.O0000o0.size(); i3++) {
                            jSONArray2.put(this.O0000o0.get(i3));
                        }
                        jSONObject4.put("alias", jSONArray2);
                    }
                    if (jSONObject4.has("use_title") || jSONObject4.has("alias")) {
                        jSONObject3.put("voice_alias", jSONObject4);
                    }
                }
                List<O000000o> list = this.O0000O0o;
                if (list == null || list.size() <= 0) {
                    JSONArray jSONArray3 = new JSONArray();
                    O000000o o000000o2 = new O000000o();
                    o000000o2.f11121O000000o = LAUNCH_TYPE.CLICK;
                    o000000o2.O0000Ooo = 101;
                    jSONArray3.put(o000000o2.O000000o());
                    jSONObject3.put("attr", jSONArray3);
                } else {
                    JSONArray jSONArray4 = new JSONArray();
                    jSONArray4.put(this.O0000O0o.get(0).O000000o());
                    jSONObject3.put("attr", jSONArray4);
                }
            }
            jSONObject2.put("launch", jSONObject3);
            JSONArray jSONArray5 = new JSONArray();
            int i4 = 0;
            for (Action next2 : this.O00000oo) {
                if (next2.O0000O0o != null) {
                    if (next2.O0000O0o instanceof O000O0o0) {
                        i4 += ((O000O0o0) next2.O0000O0o).O00000oo;
                    } else {
                        next2.O0000O0o.O00000oo = i4;
                        jSONArray5.put(next2.O000000o());
                        next2.O0000O0o.O00000oo = 0;
                        if (!TextUtils.isEmpty(next2.O0000O0o.O00000o)) {
                            hashSet.add(next2.O0000O0o.O00000o);
                        }
                    }
                }
            }
            O000000o o000000o3 = this.O0000oo0;
            if (!(o000000o3 == null || o000000o3.O00000oO == null || this.O0000oo0.O00000oO.size() <= 0)) {
                for (O000000o next3 : this.O0000oo0.O00000oO) {
                    if (next3.O00000o0 != null) {
                        hashSet.add(next3.O00000o0.f11122O000000o);
                    }
                }
            }
            jSONObject2.put("action_list", jSONArray5);
            jSONObject2.put("enable", this.O0000Oo0 ? "1" : "0");
            jSONObject.put("setting", jSONObject2);
            JSONArray jSONArray6 = new JSONArray();
            for (String put : hashSet) {
                jSONArray6.put(put);
            }
            if (hashSet.size() > 0) {
                jSONObject.put("authed", jSONArray6);
            }
            return jSONObject;
        }

        public final String toString() {
            return "SmartHomeScene{id=" + this.f11131O000000o + ", name='" + this.O00000Oo + '\'' + ",isCOmmonUsed=" + this.O0000o0O + ", isCreateByTemplate=" + this.O00000o0 + ", recommId=" + this.O00000o + ", localDevDid='" + this.O00000oO + '\'' + ", actionList=" + this.O00000oo + ", conditionList=" + this.O0000O0o + ", isNew=" + this.O0000OOo + ", enable=" + this.O0000Oo0 + ", enablePush=" + this.O0000Oo + ", notify=" + this.O0000OoO + ", express=" + this.O0000Ooo + ", mStatus=" + this.O0000o0o + ", mType=" + this.O0000o + ", mIsLite=" + this.O0000oO0 + ", groupCondition=" + this.O0000oo0 + '}';
        }

        public final CommonUsedScene O00000Oo() {
            CommonUsedScene commonUsedScene = new CommonUsedScene();
            try {
                commonUsedScene.f11134O000000o = Long.parseLong(this.f11131O000000o);
                commonUsedScene.O00000Oo = this.O00000Oo;
                commonUsedScene.O00000o0 = 1;
                return commonUsedScene;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static void O000000o(O000OOOo o000OOOo) {
        int i = 0;
        for (int i2 = 0; i2 < o000OOOo.O00000oo.size(); i2++) {
            if (o000OOOo.O00000oo.get(i2).O0000O0o instanceof O000O0o0) {
                i += ((O000O0o0) o000OOOo.O00000oo.get(i2).O0000O0o).O00000oo;
            } else {
                o000OOOo.O00000oo.get(i2).O0000O0o.O00000oo = i;
            }
        }
    }

    public static class O00000o extends O00000Oo {
        public String O0000Ooo;
        public JSONObject O0000o0;
        public String O0000o00;

        public static O00000o O00000Oo(JSONObject jSONObject) {
            String optString = jSONObject.optString("key");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            try {
                O00000o o00000o = new O00000o();
                o00000o.O0000o00 = optString;
                o00000o.O00000Oo = jSONObject.optString("name");
                o00000o.O0000Ooo = jSONObject.optString("event");
                o00000o.O0000o0 = jSONObject.optJSONObject("info");
                return o00000o;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", this.O0000Ooo);
            jSONObject.put("key", this.O0000o00);
            jSONObject.put("name", this.O00000Oo);
            if (this.O0000o0 == null) {
                this.O0000o0 = new JSONObject();
                this.O0000o0.put("platform", "Android");
            }
            jSONObject.put("info", this.O0000o0);
            return jSONObject;
        }
    }

    public static class O0000O0o extends O00000Oo {
        public String O0000Ooo;
        public double O0000o;
        public long O0000o0;
        public String O0000o00;
        public String O0000o0O;
        public double O0000o0o;
        public float O0000oO0;

        public static O0000O0o O00000Oo(JSONObject jSONObject) {
            String optString = jSONObject.optString("key");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            O0000O0o o0000O0o = new O0000O0o();
            o0000O0o.O0000o0O = optString;
            o0000O0o.O0000o00 = jSONObject.optString("src");
            o0000O0o.O00000Oo = jSONObject.optString("name");
            o0000O0o.O0000Ooo = jSONObject.optString("subName");
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject != null) {
                o0000O0o.O0000o0o = optJSONObject.optDouble("latitude");
                o0000O0o.O0000o = optJSONObject.optDouble("longitude");
                if (Double.valueOf(o0000O0o.O0000o).equals(Double.valueOf(Double.NaN))) {
                    o0000O0o.O0000o = optJSONObject.optDouble("longtitude");
                }
                o0000O0o.O0000oO0 = (float) optJSONObject.optDouble("raduis");
                if (Float.valueOf(o0000O0o.O0000oO0).equals(Float.valueOf(Float.NaN)) || o0000O0o.O0000oO0 <= 0.0f) {
                    o0000O0o.O0000oO0 = (float) optJSONObject.optDouble("radius");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("value");
            if (optJSONObject2 != null) {
                o0000O0o.O0000o0 = optJSONObject2.optLong("po_id");
            }
            return o0000O0o;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", this.O0000o0O);
            jSONObject.put("name", this.O00000Oo);
            jSONObject.put("src", this.O0000o00);
            JSONObject jSONObject2 = new JSONObject();
            if (!Double.valueOf(this.O0000o0o).isNaN()) {
                jSONObject2.put("latitude", this.O0000o0o);
            }
            if (!Double.valueOf(this.O0000o).isNaN()) {
                jSONObject2.put("longitude", this.O0000o);
            }
            jSONObject2.put("raduis", (double) this.O0000oO0);
            jSONObject2.put("platform", "iOS");
            jSONObject.put("info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("po_id", this.O0000o0);
            jSONObject.put("value", jSONObject3);
            return jSONObject;
        }
    }

    public static class O0000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f11125O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int[] O00000oO;
        public String O00000oo;

        public O0000o0() {
            int i = 0;
            this.f11125O000000o = 0;
            this.O00000Oo = 0;
            this.O00000o0 = 0;
            this.O00000o = 0;
            this.f11125O000000o = 0;
            this.O00000Oo = 0;
            this.O00000o0 = 0;
            this.O00000o = 0;
            this.O00000oO = new int[7];
            while (true) {
                int[] iArr = this.O00000oO;
                if (i < iArr.length) {
                    iArr[i] = i;
                    i++;
                } else {
                    return;
                }
            }
        }

        public static O0000o0 O000000o(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            O0000o0 o0000o0 = new O0000o0();
            JSONObject optJSONObject = jSONObject.optJSONObject("from");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("to");
            JSONArray optJSONArray = jSONObject.optJSONArray("wday");
            if (optJSONObject != null) {
                o0000o0.f11125O000000o = optJSONObject.optInt("hour");
                o0000o0.O00000o0 = optJSONObject.optInt("min");
            }
            if (optJSONObject2 != null) {
                o0000o0.O00000Oo = optJSONObject2.optInt("hour");
                o0000o0.O00000o = optJSONObject2.optInt("min");
            }
            o0000o0.O00000oo = jSONObject.optString("filter");
            if (!TextUtils.isEmpty(o0000o0.O00000oo)) {
                o0000o0.O00000oO = new int[]{0, 1, 2, 3, 4, 5, 6};
            }
            if (optJSONArray != null) {
                o0000o0.O00000oO = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        o0000o0.O00000oO[i] = optJSONArray.getInt(i);
                    } catch (JSONException unused) {
                    }
                }
            }
            return o0000o0;
        }

        public final boolean O000000o(O0000o0 o0000o0) {
            int[] iArr;
            if (o0000o0 == null || !TextUtils.equals(this.O00000oo, o0000o0.O00000oo) || this.f11125O000000o != o0000o0.f11125O000000o || this.O00000Oo != o0000o0.O00000Oo || this.O00000o0 != o0000o0.O00000o0 || this.O00000o != o0000o0.O00000o) {
                return false;
            }
            int[] iArr2 = this.O00000oO;
            if (iArr2 == null || (iArr = o0000o0.O00000oO) == null) {
                if (this.O00000oO == null && o0000o0.O00000oO == null) {
                    return true;
                }
                return false;
            } else if (iArr2.length != iArr.length) {
                return false;
            } else {
                int i = 0;
                while (true) {
                    int[] iArr3 = this.O00000oO;
                    if (i >= iArr3.length) {
                        return true;
                    }
                    if (iArr3[i] != o0000o0.O00000oO[i]) {
                        return false;
                    }
                    i++;
                }
            }
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            int i = this.f11125O000000o;
            if (i != -1) {
                jSONObject2.put("hour", i);
                jSONObject2.put("min", this.O00000o0);
                jSONObject3.put("hour", this.O00000Oo);
                jSONObject3.put("min", this.O00000o);
                int i2 = 0;
                if (!TextUtils.isEmpty(this.O00000oo)) {
                    while (i2 < 7) {
                        jSONArray.put(i2);
                        i2++;
                    }
                } else {
                    int[] iArr = this.O00000oO;
                    if (iArr != null) {
                        int length = iArr.length;
                        while (i2 < length) {
                            jSONArray.put(iArr[i2]);
                            i2++;
                        }
                    }
                }
                jSONObject.put("from", jSONObject2);
                jSONObject.put("to", jSONObject3);
                jSONObject.put("wday", jSONArray);
                if (!TextUtils.isEmpty(this.O00000oo)) {
                    jSONObject.put("filter", this.O00000oo);
                }
            }
            return jSONObject;
        }

        public final String toString() {
            return "EffectiveTimeSpan{fromHour=" + this.f11125O000000o + ", toHour=" + this.O00000Oo + ", fromMin=" + this.O00000o0 + ", toMin=" + this.O00000o + ", wDay=" + Arrays.toString(this.O00000oO) + '}';
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public LAUNCH_TYPE f11121O000000o;
        public O0000o O00000Oo;
        public O00oOooO O00000o;
        public O00000Oo O00000o0;
        public O0000Oo0 O00000oO;
        public O0000OOo O00000oo;
        public O0000Oo O0000O0o;
        public O00oOooO O0000OOo;
        public O0000O0o O0000Oo;
        public O00000o O0000Oo0;
        public O0000o00 O0000OoO;
        public int O0000Ooo;
        public boolean O0000o00 = true;

        public static O000000o O000000o(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            O000000o o000000o = new O000000o();
            if (jSONObject.has("enable")) {
                o000000o.O0000o00 = jSONObject.optBoolean("enable", true);
            }
            if (jSONObject.has("tr_id")) {
                o000000o.O0000Ooo = jSONObject.optInt("tr_id");
            }
            String optString = jSONObject.optString("src");
            if (optString.equalsIgnoreCase("user")) {
                String optString2 = jSONObject.optString("key");
                if (TextUtils.isEmpty(optString2) || optString2.equalsIgnoreCase("click")) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.CLICK;
                    return o000000o;
                } else if (optString2.equalsIgnoreCase("come_home") || optString2.equalsIgnoreCase("leave_home") || optString2.equalsIgnoreCase("phone_call") || optString2.equalsIgnoreCase("phone_sms")) {
                    o000000o.O00000o = O00oOooO.O000000o(jSONObject);
                    if (o000000o.O00000o.f11133O000000o.equals("come_home")) {
                        o000000o.f11121O000000o = LAUNCH_TYPE.COME_HOME;
                    } else if (optString2.equalsIgnoreCase("leave_home")) {
                        o000000o.f11121O000000o = LAUNCH_TYPE.LEAVE_HOME;
                    } else if (optString2.equalsIgnoreCase("phone_call")) {
                        o000000o.f11121O000000o = LAUNCH_TYPE.PHONE_CALL;
                    } else if (optString2.equalsIgnoreCase("phone_sms")) {
                        o000000o.f11121O000000o = LAUNCH_TYPE.PHONE_SMS;
                    }
                } else if (optString2.startsWith("mikey")) {
                    o000000o.O00000oO = O0000Oo0.O00000Oo(jSONObject);
                    o000000o.f11121O000000o = LAUNCH_TYPE.MIKEY;
                } else if (optString2.startsWith("miband")) {
                    o000000o.O00000oo = O0000OOo.O00000Oo(jSONObject);
                    o000000o.f11121O000000o = LAUNCH_TYPE.MIBAND;
                } else if (optString2.equalsIgnoreCase("enter_fence")) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.ENTER_FENCE;
                    o000000o.O0000Oo = O0000O0o.O00000Oo(jSONObject);
                } else if (optString2.equalsIgnoreCase("leave_fence")) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.LEAVE_FENCE;
                    o000000o.O0000Oo = O0000O0o.O00000Oo(jSONObject);
                } else if (optString2.startsWith("enter_")) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.COME_LOC;
                    o000000o.O0000Oo0 = O00000o.O00000Oo(jSONObject);
                } else if (optString2.startsWith("leave_")) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.LEAVE_LOC;
                    o000000o.O0000Oo0 = O00000o.O00000Oo(jSONObject);
                } else if (optString2.equalsIgnoreCase("nfc")) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.NFC;
                    o000000o.O0000OOo = O00oOooO.O000000o(jSONObject);
                } else {
                    o000000o.f11121O000000o = LAUNCH_TYPE.USER;
                    o000000o.O0000O0o = O0000Oo.O000000o(jSONObject);
                }
            } else if (optString.equalsIgnoreCase("timer")) {
                o000000o.O00000Oo = O0000o.O000000o(jSONObject);
                o000000o.f11121O000000o = LAUNCH_TYPE.TIMER;
            } else if (optString.equalsIgnoreCase("cloud")) {
                String optString3 = jSONObject.optString("key");
                if (optString3.equalsIgnoreCase(WeatherConditionType.TYPE_SUNRISE.key)) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.SUN_RISE;
                    o000000o.O0000OoO = O0000o00.O000000o(jSONObject);
                } else if (optString3.equalsIgnoreCase(WeatherConditionType.TYPE_SUNSET.key)) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.SUN_SET;
                    o000000o.O0000OoO = O0000o00.O000000o(jSONObject);
                } else if (optString3.equalsIgnoreCase(WeatherConditionType.TYPE_ABOVE_HUMIDITY.key)) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.HUMIDITY;
                    o000000o.O0000OoO = O0000o00.O000000o(jSONObject);
                } else if (optString3.equalsIgnoreCase(WeatherConditionType.TYPE_ABOVE_TEMPERATURE.key)) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.TEMPERATURE;
                    o000000o.O0000OoO = O0000o00.O000000o(jSONObject);
                } else if (optString3.equalsIgnoreCase(WeatherConditionType.TYPE_ABOVE_AQI.key)) {
                    o000000o.f11121O000000o = LAUNCH_TYPE.AQI;
                    o000000o.O0000OoO = O0000o00.O000000o(jSONObject);
                }
            } else if (optString.equalsIgnoreCase("device")) {
                o000000o.O00000o0 = O00000Oo.O000000o(jSONObject);
                o000000o.f11121O000000o = LAUNCH_TYPE.DEVICE;
                if (o000000o.O00000o0 == null) {
                }
            }
            return o000000o;
        }

        public final JSONObject O000000o() throws JSONException {
            if (this.f11121O000000o == LAUNCH_TYPE.TIMER) {
                JSONObject O000000o2 = this.O00000Oo.O000000o();
                O000000o2.put("src", "timer");
                O000000o2.put("enable", this.O0000o00);
                O000000o2.put("tr_id", this.O0000Ooo);
                return O000000o2;
            } else if (this.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                JSONObject O000000o3 = this.O00000o0.O000000o();
                O000000o3.put("src", "device");
                O000000o3.put("enable", this.O0000o00);
                O000000o3.put("tr_id", this.O0000Ooo);
                return O000000o3;
            } else if (this.f11121O000000o == LAUNCH_TYPE.LEAVE_HOME || this.f11121O000000o == LAUNCH_TYPE.COME_HOME || this.f11121O000000o == LAUNCH_TYPE.PHONE_CALL || this.f11121O000000o == LAUNCH_TYPE.PHONE_SMS) {
                JSONObject O000000o4 = this.O00000o.O000000o();
                O000000o4.put("src", "user");
                O000000o4.put("enable", this.O0000o00);
                O000000o4.put("tr_id", this.O0000Ooo);
                return O000000o4;
            } else if (this.f11121O000000o == LAUNCH_TYPE.CLICK) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("src", "user");
                jSONObject.put("key", "");
                jSONObject.put("enable", this.O0000o00);
                jSONObject.put("tr_id", this.O0000Ooo);
                return jSONObject;
            } else if (this.f11121O000000o == LAUNCH_TYPE.COME_LOC || this.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC) {
                JSONObject O000000o5 = this.O0000Oo0.O000000o();
                O000000o5.put("src", "user");
                O000000o5.put("enable", this.O0000o00);
                O000000o5.put("tr_id", this.O0000Ooo);
                return O000000o5;
            } else if (this.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE || this.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
                JSONObject O000000o6 = this.O0000Oo.O000000o();
                O000000o6.put("src", "user");
                O000000o6.put("enable", this.O0000o00);
                O000000o6.put("tr_id", this.O0000Ooo);
                return O000000o6;
            } else if (this.f11121O000000o == LAUNCH_TYPE.MIKEY) {
                JSONObject O000000o7 = this.O00000oO.O000000o();
                O000000o7.put("src", "user");
                O000000o7.put("enable", this.O0000o00);
                O000000o7.put("tr_id", this.O0000Ooo);
                return O000000o7;
            } else if (this.f11121O000000o == LAUNCH_TYPE.MIBAND) {
                JSONObject O000000o8 = this.O00000oo.O000000o();
                O000000o8.put("src", "user");
                O000000o8.put("enable", this.O0000o00);
                O000000o8.put("tr_id", this.O0000Ooo);
                return O000000o8;
            } else if (this.f11121O000000o == LAUNCH_TYPE.USER) {
                JSONObject O000000o9 = this.O0000O0o.O000000o();
                O000000o9.put("src", "user");
                O000000o9.put("enable", this.O0000o00);
                O000000o9.put("tr_id", this.O0000Ooo);
                return O000000o9;
            } else if (this.f11121O000000o == LAUNCH_TYPE.NFC) {
                JSONObject O000000o10 = this.O0000OOo.O000000o();
                O000000o10.put("src", "user");
                O000000o10.put("enable", this.O0000o00);
                O000000o10.put("tr_id", this.O0000Ooo);
                return O000000o10;
            } else if (this.f11121O000000o != LAUNCH_TYPE.SUN_RISE && this.f11121O000000o != LAUNCH_TYPE.SUN_SET && this.f11121O000000o != LAUNCH_TYPE.AQI && this.f11121O000000o != LAUNCH_TYPE.HUMIDITY && this.f11121O000000o != LAUNCH_TYPE.TEMPERATURE) {
                return new JSONObject();
            } else {
                JSONObject O000000o11 = this.O0000OoO.O000000o();
                O000000o11.put("src", "cloud");
                O000000o11.put("enable", this.O0000o00);
                O000000o11.put("tr_id", this.O0000Ooo);
                return O000000o11;
            }
        }

        public final boolean O00000Oo() {
            return this.f11121O000000o == LAUNCH_TYPE.HUMIDITY || this.f11121O000000o == LAUNCH_TYPE.AQI || this.f11121O000000o == LAUNCH_TYPE.TEMPERATURE || this.f11121O000000o == LAUNCH_TYPE.SUN_RISE || this.f11121O000000o == LAUNCH_TYPE.SUN_SET;
        }
    }

    public static abstract class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11122O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public int O00000oO = -1;
        public int O00000oo = -1;
        public int O0000O0o = -1;
        public int O0000OOo = -1;
        public String O0000Oo;
        public int[] O0000Oo0;
        public int O0000OoO = -1;

        public abstract JSONObject O000000o() throws JSONException;

        public static O00000Oo O000000o(JSONObject jSONObject) {
            O00000o0 o00000o0 = new O00000o0();
            JSONObject optJSONObject = jSONObject.optJSONObject("timespan");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("from");
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("to");
                JSONArray optJSONArray = optJSONObject.optJSONArray("wday");
                if (optJSONObject2 != null) {
                    o00000o0.O00000oO = optJSONObject2.optInt("hour");
                    o00000o0.O0000O0o = optJSONObject2.optInt("min");
                }
                if (optJSONObject3 != null) {
                    o00000o0.O00000oo = optJSONObject3.optInt("hour");
                    o00000o0.O0000OOo = optJSONObject3.optInt("min");
                }
                if (optJSONArray != null) {
                    o00000o0.O0000Oo0 = new int[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        try {
                            o00000o0.O0000Oo0[i] = optJSONArray.getInt(i);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
            O00000o0 o00000o02 = o00000o0;
            o00000o02.O0000Ooo = jSONObject.opt("value");
            Device O000000o2 = SceneApi.O000000o(jSONObject);
            o00000o0.O00000o = jSONObject.optString("model");
            o00000o0.f11122O000000o = jSONObject.optString("did");
            o00000o0.O00000Oo = jSONObject.optString("name");
            o00000o0.O00000o0 = jSONObject.optString("device_name");
            if (O000000o2 != null) {
                if (!TextUtils.isEmpty(O000000o2.name)) {
                    o00000o0.O00000o0 = O000000o2.name;
                }
                if (!TextUtils.isEmpty(O000000o2.model)) {
                    o00000o0.O00000o = O000000o2.model;
                }
                if (!TextUtils.isEmpty(O000000o2.did)) {
                    o00000o0.f11122O000000o = O000000o2.did;
                }
            }
            if (jSONObject.has("tempId")) {
                o00000o0.O0000OoO = jSONObject.optInt("tempId");
            }
            if (jSONObject.has("key")) {
                o00000o0.O0000Oo = jSONObject.optString("key");
            }
            if (jSONObject.has("extra")) {
                o00000o02.O0000o00 = jSONObject.optString("extra");
            }
            return o00000o0;
        }
    }

    public static Device O000000o(JSONObject jSONObject) {
        Device O0000o0O;
        Device O00000o02;
        String optString = jSONObject.optString("did");
        if (!TextUtils.isEmpty(optString) && (O00000o02 = fno.O000000o().O00000o0(optString)) != null) {
            return O00000o02;
        }
        String optString2 = jSONObject.optString("model");
        if (!TextUtils.isEmpty(optString2) && (O0000o0O = DeviceFactory.O0000o0O(optString2)) != null) {
            return O0000o0O;
        }
        String[] split = jSONObject.optString("key").split("\\.");
        if (split.length < 3) {
            return null;
        }
        try {
            if (!split[0].equalsIgnoreCase("event")) {
                if (!split[0].equalsIgnoreCase("prop")) {
                    return DeviceFactory.O0000o0O(split[0] + "." + split[1] + "." + split[2]);
                }
            }
            return DeviceFactory.O0000o0O(split[1] + "." + split[2] + "." + split[3]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class O00000o0 extends O00000Oo {
        public Object O0000Ooo = new Object();
        public String O0000o00 = "";

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", this.O0000Oo);
            jSONObject.put("did", this.f11122O000000o);
            jSONObject.put("name", this.O00000Oo);
            jSONObject.put("value", this.O0000Ooo);
            jSONObject.put("device_name", this.O00000o0);
            jSONObject.put("tempId", this.O0000OoO);
            jSONObject.put("extra", this.O0000o00);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.O00000oO != -1) {
                jSONObject3.put("hour", this.O00000oO);
                jSONObject3.put("min", this.O0000O0o);
                jSONObject4.put("hour", this.O00000oo);
                jSONObject4.put("min", this.O0000OOo);
                if (this.O0000Oo0 != null) {
                    for (int put : this.O0000Oo0) {
                        jSONArray.put(put);
                    }
                }
                jSONObject2.put("from", jSONObject3);
                jSONObject2.put("to", jSONObject4);
                jSONObject2.put("wday", jSONArray);
                jSONObject.put("timespan", jSONObject2);
            }
            return jSONObject;
        }
    }

    public static class O0000Oo0 extends O00000Oo {
        public String O0000Ooo;

        public static O0000Oo0 O00000Oo(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            O0000Oo0 o0000Oo0 = new O0000Oo0();
            if (jSONObject.has("key")) {
                o0000Oo0.O0000Ooo = jSONObject.optString("key");
            }
            if (jSONObject.has("event")) {
                o0000Oo0.O0000Oo = jSONObject.getString("event");
            }
            if (!TextUtils.isEmpty(o0000Oo0.O0000Ooo)) {
                String[] split = o0000Oo0.O0000Ooo.split("@");
                if (split.length == 3 && split[0].equalsIgnoreCase("mikey")) {
                    o0000Oo0.f11122O000000o = split[1];
                    o0000Oo0.O0000Oo = split[2];
                }
            }
            return o0000Oo0;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", this.O0000Oo);
            if (TextUtils.isEmpty(this.O0000Ooo) && !TextUtils.isEmpty(this.f11122O000000o) && !TextUtils.isEmpty(this.O0000Oo)) {
                this.O0000Ooo = String.format("mikey@%s@%s", this.f11122O000000o, this.O0000Oo);
            }
            jSONObject.put("key", this.O0000Ooo);
            return jSONObject;
        }
    }

    public static class O0000OOo extends O00000Oo {
        public String O0000Ooo;

        public static O0000OOo O00000Oo(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            O0000OOo o0000OOo = new O0000OOo();
            if (jSONObject.has("key")) {
                o0000OOo.O0000Ooo = jSONObject.optString("key");
            }
            if (jSONObject.has("event")) {
                o0000OOo.O0000Oo = jSONObject.getString("event");
            }
            if (!TextUtils.isEmpty(o0000OOo.O0000Ooo)) {
                String[] split = o0000OOo.O0000Ooo.split("@");
                if (split.length == 3 && split[0].equalsIgnoreCase("miband")) {
                    o0000OOo.f11122O000000o = split[1];
                    o0000OOo.O0000Oo = split[2];
                }
            }
            o0000OOo.O00000o = "xiaomi.ble.v1";
            return o0000OOo;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", this.O0000Oo);
            if (TextUtils.isEmpty(this.O0000Ooo) && !TextUtils.isEmpty(this.f11122O000000o) && !TextUtils.isEmpty(this.O0000Oo)) {
                this.O0000Ooo = String.format("miband@%s@%s", this.f11122O000000o, this.O0000Oo);
            }
            jSONObject.put("key", this.O0000Ooo);
            return jSONObject;
        }
    }

    public static class O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11123O000000o;
        public String O00000Oo;

        public static O0000Oo O000000o(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            O0000Oo o0000Oo = new O0000Oo();
            o0000Oo.f11123O000000o = jSONObject.optString("key");
            o0000Oo.O00000Oo = jSONObject.optString("name");
            return o0000Oo;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", this.f11123O000000o);
            jSONObject.put("name", this.O00000Oo);
            return jSONObject;
        }
    }

    public static class O0000o00 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11126O000000o;
        public String O00000Oo;
        public int O00000o;
        public Object O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public int O0000OOo;

        public static O0000o00 O000000o(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            O0000o00 o0000o00 = new O0000o00();
            o0000o00.f11126O000000o = jSONObject.optString("key", "");
            o0000o00.O00000Oo = jSONObject.optString("name", "");
            o0000o00.O00000o0 = jSONObject.opt("value");
            o0000o00.O00000o = jSONObject.optInt("condition_id", 0);
            o0000o00.O00000oO = jSONObject.optString("city_id", "");
            o0000o00.O00000oo = jSONObject.optString("city_name", "");
            o0000o00.O0000O0o = jSONObject.optString("sub_name", "");
            o0000o00.O0000OOo = jSONObject.optInt("default_value", 0);
            return o0000o00;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", this.f11126O000000o);
            jSONObject.put("name", this.O00000Oo);
            jSONObject.put("value", this.O00000o0);
            jSONObject.put("condition_id", this.O00000o);
            jSONObject.put("city_id", this.O00000oO);
            jSONObject.put("city_name", this.O00000oo);
            jSONObject.put("sub_name", this.O0000O0o);
            jSONObject.put("default_value", this.O0000OOo);
            return jSONObject;
        }
    }

    public static class O00oOooO {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11133O000000o;

        public static O00oOooO O000000o(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            O00oOooO o00oOooO = new O00oOooO();
            o00oOooO.f11133O000000o = jSONObject.optString("key");
            return o00oOooO;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", this.f11133O000000o);
            return jSONObject;
        }
    }

    public static class O0000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public CorntabUtils.CorntabParam f11124O000000o;
        public String O00000Oo;

        public static O0000o O000000o(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("key");
            O0000o o0000o = new O0000o();
            try {
                o0000o.f11124O000000o = CorntabUtils.O00000Oo(optString);
            } catch (Exception unused) {
            }
            o0000o.O00000Oo = jSONObject.optString("filter");
            return o0000o;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", CorntabUtils.O00000Oo(this.f11124O000000o));
            jSONObject.put("filter", TextUtils.isEmpty(this.O00000Oo) ? "" : this.O00000Oo);
            return jSONObject;
        }
    }

    public static class Action {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f11120O000000o;
        public String O00000Oo;
        public int O00000o;
        public String O00000o0;
        public String O00000oO;
        public int O00000oo;
        public O000OO00 O0000O0o;
        public O000O0o O0000OOo;

        public enum ACTION_TYPE {
            TYPE_DEVICE(0),
            TYPE_PUSH(1),
            TYPE_LITE_SCENE(2),
            TYPE_AUTO_SCENE(3);
            
            public int value;

            private ACTION_TYPE(int i) {
                this.value = i;
            }
        }

        public static Action O000000o(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            Action action = new Action();
            action.f11120O000000o = jSONObject.optInt("type");
            action.O00000Oo = jSONObject.optString("name");
            action.O00000oO = jSONObject.optString("model");
            action.O00000oo = jSONObject.optInt("sa_id");
            if (jSONObject.has("tr_id")) {
                action.O00000o = jSONObject.optInt("tr_id");
            }
            action.O00000o0 = jSONObject.optString("keyName");
            JSONObject optJSONObject = jSONObject.optJSONObject("payload");
            int i = action.f11120O000000o;
            if (i == 1) {
                if (optJSONObject == null) {
                    action.O0000O0o = new O000OO();
                } else {
                    action.O0000O0o = O000OO.O000000o(optJSONObject);
                }
            } else if (i == 2) {
                action.O0000O0o = O000O00o.O000000o(optJSONObject);
            } else if (i == 3) {
                action.O0000O0o = O000O0OO.O000000o(optJSONObject);
            } else if (optJSONObject != null && i == 0) {
                action.O0000O0o = O000OO0o.O000000o(optJSONObject, action.O00000oo);
            }
            if (action.O0000O0o == null) {
                return null;
            }
            return action;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.O00000Oo);
            jSONObject.put("type", this.f11120O000000o);
            jSONObject.put("model", this.O00000oO);
            jSONObject.put("tr_id", this.O00000o);
            jSONObject.put("sa_id", this.O00000oo);
            if (!TextUtils.isEmpty(this.O00000o0)) {
                jSONObject.put("keyName", this.O00000o0);
            }
            O000OO00 o000oo00 = this.O0000O0o;
            if (o000oo00 != null) {
                jSONObject.put("payload", o000oo00.O000000o());
            }
            O000O0o o000O0o = this.O0000OOo;
            if (o000O0o != null) {
                jSONObject.put("extra", o000O0o.O000000o());
            }
            return jSONObject;
        }

        public final String toString() {
            return "Action{type=" + this.f11120O000000o + ", name='" + this.O00000Oo + '\'' + ", keyName='" + this.O00000o0 + '\'' + ", mCompatibleId=" + this.O00000o + ", deviceModel='" + this.O00000oO + '\'' + ", payload=" + this.O0000O0o + ", extra=" + this.O0000OOo + '}';
        }
    }

    public static class O000O00o extends O000OO00 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11127O000000o;

        public static O000O00o O000000o(JSONObject jSONObject) {
            O000O00o o000O00o = new O000O00o();
            o000O00o.f11127O000000o = jSONObject.optString("us_id");
            if (jSONObject.has("delay_time")) {
                o000O00o.O00000oo = jSONObject.optInt("delay_time");
            }
            return o000O00o;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("us_id", this.f11127O000000o);
            if (this.O00000oo != -1) {
                jSONObject.put("delay_time", this.O00000oo);
            }
            return jSONObject;
        }
    }

    public static class O000O0OO extends O000OO00 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11128O000000o;
        public int O00000Oo = -1;

        public static O000O0OO O000000o(JSONObject jSONObject) {
            O000O0OO o000o0oo = new O000O0OO();
            o000o0oo.f11128O000000o = jSONObject.optString("us_id");
            if (jSONObject.has("delay_time")) {
                o000o0oo.O00000oo = jSONObject.optInt("delay_time");
            }
            if (jSONObject.has("enable")) {
                o000o0oo.O00000Oo = jSONObject.optInt("enable");
            }
            return o000o0oo;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("us_id", this.f11128O000000o);
            if (this.O00000oo != -1) {
                jSONObject.put("delay_time", this.O00000oo);
            }
            int i = this.O00000Oo;
            if (i != -1) {
                jSONObject.put("enable", i);
            }
            return jSONObject;
        }
    }

    public static class O000OO extends O000OO00 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11129O000000o;
        public String O00000Oo;

        public static O000OO O000000o(JSONObject jSONObject) {
            O000OO o000oo = new O000OO();
            o000oo.f11129O000000o = jSONObject.optString("title");
            o000oo.O00000Oo = jSONObject.optString("desc");
            o000oo.O00000oo = jSONObject.optInt("delay_time");
            return o000oo;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", this.f11129O000000o);
            jSONObject.put("desc", this.O00000Oo);
            if (this.O00000oo != -1) {
                jSONObject.put("delay_time", this.O00000oo);
            }
            return jSONObject;
        }
    }

    public static class O000OO0o extends O000OO00 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11130O000000o;
        public JSONObject O00000Oo;
        public int O0000OOo = -1;
        public String O0000Oo0;

        public static O000OO0o O000000o(JSONObject jSONObject, int i) {
            if (jSONObject == null) {
                return null;
            }
            O000OO0o o000OO0o = new O000OO0o();
            o000OO0o.O00000o0 = jSONObject.optString("command");
            o000OO0o.O00000o = jSONObject.optString("did");
            o000OO0o.O00000oo = jSONObject.optInt("delay_time");
            if (i > 0) {
                o000OO0o.O0000OOo = i;
            } else if (jSONObject.has("tempId")) {
                o000OO0o.O0000OOo = jSONObject.optInt("tempId");
            }
            if (jSONObject.has("value")) {
                o000OO0o.O00000oO = jSONObject.opt("value");
            }
            if (jSONObject.has("extra")) {
                o000OO0o.f11130O000000o = jSONObject.optString("extra");
            }
            if (jSONObject.has("plug_id")) {
                o000OO0o.O0000Oo0 = jSONObject.optString("plug_id");
            }
            o000OO0o.O00000Oo = jSONObject;
            return o000OO0o;
        }

        public final JSONObject O000000o() throws JSONException {
            this.O00000Oo = new JSONObject();
            this.O00000Oo.put("command", this.O00000o0);
            this.O00000Oo.put("did", this.O00000o);
            if (this.O00000oo != -1) {
                this.O00000Oo.put("delay_time", this.O00000oo);
            }
            int i = this.O0000OOo;
            if (i != -1) {
                this.O00000Oo.put("tempId", i);
            }
            if (this.O00000oO != null) {
                this.O00000Oo.put("value", this.O00000oO);
            }
            String str = this.f11130O000000o;
            if (str != null) {
                this.O00000Oo.put("extra", str);
            }
            if (!TextUtils.isEmpty(this.O0000Oo0)) {
                this.O00000Oo.put("plug_id", this.O0000Oo0);
            }
            this.O00000Oo.put("total_length", this.O0000O0o);
            return this.O00000Oo;
        }
    }
}
