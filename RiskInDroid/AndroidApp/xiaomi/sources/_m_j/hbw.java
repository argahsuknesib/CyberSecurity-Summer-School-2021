package _m_j;

import _m_j.gsj;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hbw {
    private static volatile hbw O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<String, String> f18760O000000o = new HashMap<>();
    public final BehaviorSubject<List<O000000o>> O00000Oo = BehaviorSubject.create();
    public String O00000o;
    public Disposable O00000o0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18764O000000o;
        public String O00000Oo;
        public long O00000o;
        public long O00000o0;

        public O000000o(String str, String str2, long j, long j2) {
            this.f18764O000000o = str2;
            this.O00000Oo = str;
            this.O00000o0 = j;
            this.O00000o = j2;
        }
    }

    public static hbw O000000o() {
        if (O00000oO == null) {
            synchronized (hbw.class) {
                if (O00000oO == null) {
                    O00000oO = new hbw();
                }
            }
        }
        return O00000oO;
    }

    private hbw() {
        this.f18760O000000o.put("red_point_device_page", "MIHOME");
        this.f18760O000000o.put("red_point_shop_page", "YOUPIN");
        this.f18760O000000o.put("red_point_intelligent_page", "INTELLIGENT");
        this.f18760O000000o.put("red_point_setting_page", "MINE");
        this.f18760O000000o.put("red_point_content_page", "CONTENT");
    }

    public final void O000000o(String str, List<O000000o> list) {
        Context appContext = CommonApplication.getAppContext();
        if (appContext != null) {
            if (!TextUtils.equals(str, this.O00000o) || this.O00000o == null) {
                gsy.O00000o0(LogType.MAIN_PAGE, "BottomTabImgsApi", "updateCache infoString == ".concat(String.valueOf(str)));
                SharedPreferences sharedPreferences = appContext.getSharedPreferences("bottom_tab_icon_shaprefrence_string", 0);
                if (str == null || TextUtils.isEmpty(str)) {
                    sharedPreferences.edit().putString("content", "").apply();
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    O000000o(list.get(i));
                }
                sharedPreferences.edit().putString("content", str).apply();
                sharedPreferences.edit().putLong("cache_time", System.currentTimeMillis()).apply();
                return;
            }
            LogType logType = LogType.MAIN_PAGE;
            gsy.O00000o0(logType, "BottomTabImgsApi", "updateCache repeat mCacheInfoStr == " + this.O00000o);
        }
    }

    public final Observable<List<O000000o>> O00000Oo() {
        gsy.O00000o0(LogType.MAIN_PAGE, "BottomTabImgsApi", "getBottomTabImgInfoFormNet begin ");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new gsi("platform", "2"));
        grr.O000000o();
        arrayList.add(new gsi("appVersion", String.valueOf(grr.O00000o0(CommonApplication.getAppContext()))));
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "GET";
        gsj.O000000o O00000Oo2 = o000000o.O00000Oo(hka.O000000o() + "/cgi-op/api/v1/recommendation/mihome/bottom/tab");
        O00000Oo2.O00000oO = arrayList;
        gsj O000000o2 = O00000Oo2.O000000o();
        hjx.O00000Oo();
        return fsv.O000000o(O000000o2, new fss() {
            /* class _m_j.$$Lambda$hbw$q5aJOWmixrw99SFjHC9Gawxx1Q */

            public final Object parse(JSONObject jSONObject) {
                return hbw.this.O000000o(jSONObject);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List O000000o(JSONObject jSONObject) throws JSONException {
        if (!TextUtils.equals(jSONObject.optString("result"), "ok")) {
            return new ArrayList();
        }
        LogType logType = LogType.MAIN_PAGE;
        gsy.O00000o0(logType, "BottomTabImgsApi", "getBottomTabImgInfoFormNet begin2 " + jSONObject.toString());
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            return new ArrayList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("list");
        ArrayList<O000000o> O000000o2 = O000000o(optJSONObject.optJSONArray("list"));
        O000000o(optJSONArray != null ? optJSONArray.toString() : "", O000000o2);
        return O000000o2;
    }

    public static ArrayList<O000000o> O000000o(JSONArray jSONArray) {
        ArrayList<O000000o> arrayList = new ArrayList<>();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new O000000o(optJSONObject.optString("type"), optJSONObject.optString("imgUrl"), optJSONObject.optLong("beginTime", 0), optJSONObject.optLong("endTime", 0)));
            }
        }
        return arrayList;
    }

    public static void O000000o(O000000o o000000o) {
        if (O00000Oo(o000000o)) {
            String str = o000000o.f18764O000000o;
            if (!gph.O000000o().O000000o(str)) {
                gsy.O00000Oo("BottomTabImgsApi", "loadImages");
                gph.O000000o().O00000Oo(str);
            }
        }
    }

    public static boolean O00000Oo(O000000o o000000o) {
        if (o000000o != null && !TextUtils.isEmpty(o000000o.O00000Oo) && !TextUtils.isEmpty(o000000o.f18764O000000o) && o000000o.O00000o > System.currentTimeMillis() && o000000o.O00000o0 < System.currentTimeMillis() && o000000o.O00000o0 < o000000o.O00000o) {
            return true;
        }
        return false;
    }
}
