package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fkk {

    /* renamed from: O000000o  reason: collision with root package name */
    public JSONObject f16518O000000o;
    private String O00000Oo;

    public fkk(File file) {
        if (file.isDirectory()) {
            this.O00000Oo = file + File.separator + "model_list.json";
            String O000000o2 = fkw.O000000o(this.O00000Oo);
            if (TextUtils.isEmpty(O000000o2)) {
                this.f16518O000000o = new JSONObject();
                return;
            }
            try {
                this.f16518O000000o = new JSONObject(O000000o2);
            } catch (JSONException unused) {
                this.f16518O000000o = new JSONObject();
                try {
                    this.f16518O000000o.put("model_list", new JSONArray(O000000o2));
                } catch (JSONException e) {
                    gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginJsonExtra", Log.getStackTraceString(e));
                }
            }
        } else {
            gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginJsonExtra", "is dir path:".concat(String.valueOf(file)));
        }
    }

    public final ArrayList<String> O000000o() {
        JSONArray optJSONArray;
        ArrayList<String> arrayList = new ArrayList<>();
        JSONObject jSONObject = this.f16518O000000o;
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("model_list")) == null)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return arrayList;
    }

    public final fkk O000000o(int i) {
        JSONObject jSONObject = this.f16518O000000o;
        if (jSONObject != null) {
            try {
                jSONObject.put("version", i);
            } catch (JSONException e) {
                LogType logType = LogType.PLUGIN;
                gsy.O00000o0(logType, "PluginManager", "PluginJsonExtra", "setVersion error:" + Log.getStackTraceString(e));
            }
        }
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061 A[LOOP:1: B:19:0x005b->B:21:0x0061, LOOP_END] */
    public final fkk O000000o(Collection<String> collection) {
        JSONObject jSONObject = this.f16518O000000o;
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("model_list");
            if (optJSONArray == null) {
                try {
                    JSONObject jSONObject2 = this.f16518O000000o;
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONObject2.put("model_list", jSONArray);
                        optJSONArray = jSONArray;
                    } catch (JSONException e) {
                        e = e;
                        optJSONArray = jSONArray;
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "PluginManager", "PluginJsonExtra", "setModelList error:" + Log.getStackTraceString(e));
                        while (r6.hasNext()) {
                        }
                        return this;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    LogType logType2 = LogType.PLUGIN;
                    gsy.O00000o0(logType2, "PluginManager", "PluginJsonExtra", "setModelList error:" + Log.getStackTraceString(e));
                    while (r6.hasNext()) {
                    }
                    return this;
                }
            } else {
                HashSet hashSet = new HashSet(collection);
                Iterator<String> it = O000000o().iterator();
                while (it.hasNext()) {
                    hashSet.remove(it.next());
                }
                collection = hashSet;
            }
            for (String put : collection) {
                optJSONArray.put(put);
            }
        }
        return this;
    }

    public final boolean O00000Oo() {
        JSONObject jSONObject;
        String str = this.O00000Oo;
        if (str == null || (jSONObject = this.f16518O000000o) == null) {
            return false;
        }
        return fkw.O000000o(str, jSONObject.toString());
    }
}
