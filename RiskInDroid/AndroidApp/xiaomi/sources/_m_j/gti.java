package _m_j;

import _m_j.fui;
import _m_j.gti;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gti {
    private static gti O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f18243O000000o;
    public int O00000Oo = 0;
    public ArrayList<O000000o> O00000o = new ArrayList<>();
    public ArrayList<O000000o> O00000o0 = new ArrayList<>();
    ArrayList<O000000o> O00000oO = new ArrayList<>();
    public Handler O00000oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.gti.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 3) {
                gti.this.O00000o.clear();
                gti.this.O00000o.addAll((ArrayList) message.obj);
            }
        }
    };

    public static gti O000000o() {
        if (O0000O0o == null) {
            O0000O0o = new gti();
        }
        return O0000O0o;
    }

    private gti() {
        Context context = gkv.f17949O000000o;
        this.f18243O000000o = context.getSharedPreferences("camera_group_" + CoreApi.O000000o().O0000o0(), 0);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18248O000000o;
        public boolean O00000Oo = false;
        public boolean O00000o = false;
        public boolean O00000o0 = false;
        public List<C0109O000000o> O00000oO = new ArrayList();

        /* renamed from: _m_j.gti$O000000o$O000000o  reason: collision with other inner class name */
        public static class C0109O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public String f18249O000000o;
            public List<String> O00000Oo;
        }

        public static O000000o O000000o(JSONObject jSONObject) {
            O000000o o000000o = new O000000o();
            o000000o.f18248O000000o = jSONObject.optString("did");
            o000000o.O00000o = jSONObject.optBoolean("expanded");
            JSONArray optJSONArray = jSONObject.optJSONArray("group_items");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                C0109O000000o o000000o2 = new C0109O000000o();
                o000000o2.f18249O000000o = optJSONObject.optString("did");
                if (fno.O000000o().O00000o0(o000000o2.f18249O000000o) != null) {
                    o000000o2.O00000Oo = new ArrayList();
                    if (optJSONObject.has("show_op")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("show_op");
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            o000000o2.O00000Oo.add(optJSONArray2.optString(i2));
                        }
                    }
                    o000000o.O00000oO.add(o000000o2);
                }
            }
            return o000000o;
        }

        /* access modifiers changed from: package-private */
        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.f18248O000000o);
                jSONObject.put("expanded", this.O00000o);
                JSONArray jSONArray = new JSONArray();
                for (C0109O000000o next : this.O00000oO) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("did", next.f18249O000000o);
                    JSONArray jSONArray2 = new JSONArray();
                    if (next.O00000Oo != null) {
                        for (int i = 0; i < next.O00000Oo.size(); i++) {
                            jSONArray2.put(next.O00000Oo.get(i));
                        }
                        jSONObject2.put("show_op", jSONArray2);
                    }
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("group_items", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static String O00000Oo() {
        if (!CoreApi.O000000o().O0000Ooo()) {
            return "camera_list_prefs";
        }
        return CoreApi.O000000o().O0000o0() + "_camera_list_prefs";
    }

    public final List<O000000o> O00000o0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<O000000o> it = this.O00000o0.iterator();
        while (it.hasNext()) {
            O000000o next = it.next();
            linkedHashMap.put(next.f18248O000000o, next);
        }
        Iterator<O000000o> it2 = this.O00000o.iterator();
        while (it2.hasNext()) {
            if (!linkedHashMap.containsKey(it2.next().f18248O000000o)) {
                it2.remove();
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<O000000o> it3 = this.O00000o.iterator();
        while (it3.hasNext()) {
            O000000o next2 = it3.next();
            linkedHashMap2.put(next2.f18248O000000o, next2);
        }
        Iterator<O000000o> it4 = this.O00000o0.iterator();
        while (it4.hasNext()) {
            O000000o next3 = it4.next();
            if (!linkedHashMap2.containsKey(next3.f18248O000000o)) {
                this.O00000o.add(next3);
            }
        }
        gsy.O00000Oo("CameraGroupManager", "mCacheGroupInfoList size:" + this.O00000o.size() + " mGroupInfoList size:" + this.O00000o0.size());
        return this.O00000o;
    }

    public final int O00000o() {
        this.O00000Oo = this.f18243O000000o.getInt("all_camera_show_view_type", this.O00000Oo);
        return this.O00000Oo;
    }

    public final void O000000o(List<Device> list) {
        HashMap hashMap = new HashMap();
        hashMap.clear();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i).did, Integer.valueOf(i));
        }
        Collections.sort(this.O00000o0, new Comparator(hashMap) {
            /* class _m_j.$$Lambda$gti$kCfRbLnAVhr8vGEwikw8gGXl5Q */
            private final /* synthetic */ HashMap f$0;

            {
                this.f$0 = r1;
            }

            public final int compare(Object obj, Object obj2) {
                return gti.O00000Oo(this.f$0, (gti.O000000o) obj, (gti.O000000o) obj2);
            }
        });
        Collections.sort(this.O00000o, new Comparator(hashMap) {
            /* class _m_j.$$Lambda$gti$NqJ9PqH_0u1FUY_IGnrLGVeHXeE */
            private final /* synthetic */ HashMap f$0;

            {
                this.f$0 = r1;
            }

            public final int compare(Object obj, Object obj2) {
                return gti.O000000o(this.f$0, (gti.O000000o) obj, (gti.O000000o) obj2);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int O00000Oo(HashMap hashMap, O000000o o000000o, O000000o o000000o2) {
        if (!hashMap.containsKey(o000000o.f18248O000000o) || !hashMap.containsKey(o000000o2.f18248O000000o)) {
            return hashMap.containsKey(o000000o.f18248O000000o) ? 1 : -1;
        }
        return ((Integer) hashMap.get(o000000o.f18248O000000o)).intValue() - ((Integer) hashMap.get(o000000o2.f18248O000000o)).intValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int O000000o(HashMap hashMap, O000000o o000000o, O000000o o000000o2) {
        if (!hashMap.containsKey(o000000o.f18248O000000o) || !hashMap.containsKey(o000000o2.f18248O000000o)) {
            return hashMap.containsKey(o000000o.f18248O000000o) ? 1 : -1;
        }
        return ((Integer) hashMap.get(o000000o.f18248O000000o)).intValue() - ((Integer) hashMap.get(o000000o2.f18248O000000o)).intValue();
    }

    /* access modifiers changed from: package-private */
    public final List<O000000o> O000000o(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optLong("timestamp");
            this.O00000Oo = jSONObject.optInt("show_view_type");
            SharedPreferences.Editor edit = this.f18243O000000o.edit();
            edit.putInt("all_camera_show_view_type", this.O00000Oo);
            edit.commit();
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(O000000o.O000000o(optJSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O00000Oo(String str) {
        SharedPreferences.Editor edit = this.f18243O000000o.edit();
        edit.putString(O00000Oo(), str);
        edit.commit();
    }

    public final void O000000o(final fsm<Void, fso> fsm) {
        if (!gtj.O000000o().f18250O000000o && this.O00000o.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<O000000o> it = this.O00000o.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().O000000o());
            }
            try {
                jSONObject.put("data", jSONArray);
                jSONObject.put("show_view_type", O00000o());
                final String jSONObject2 = jSONObject.toString();
                fui fui = new fui();
                fui.f17181O000000o = 0;
                fui.O00000Oo = "20";
                fui.O00000o0 = new ArrayList<>();
                fui.O00000o0.add(new fui.O000000o(O00000Oo(), jSONObject2));
                fuj.O000000o().O000000o(gkv.f17949O000000o, fui, new fsm<Void, fso>() {
                    /* class _m_j.gti.AnonymousClass3 */

                    public final void onFailure(fso fso) {
                        fsm.onFailure(fso);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gti.this.O00000Oo(jSONObject2);
                        fsm.onSuccess(null);
                    }
                });
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "", "save data " + jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
