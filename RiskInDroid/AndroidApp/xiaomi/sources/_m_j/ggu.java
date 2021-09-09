package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ggu {
    private static volatile ggu O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<String> f17752O000000o = new ArrayList<>();
    public HashMap<String, ggo> O00000Oo = new HashMap<>();

    static ggu O000000o() {
        if (O00000o0 == null) {
            synchronized (ggu.class) {
                if (O00000o0 == null) {
                    O00000o0 = new ggu();
                }
            }
        }
        return O00000o0;
    }

    private ggu() {
        O00000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public static void O00000Oo() {
        gpy.O000000o(ServiceApplication.getAppContext(), "sp_upgrade_order_compat", "sp_key_is_old_cached_valid", false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public final boolean O00000o0() {
        if (!gpy.O00000o0(ServiceApplication.getAppContext(), "sp_upgrade_order_compat", "sp_key_is_old_cached_valid", true) || this.f17752O000000o.isEmpty() || this.O00000Oo.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList<_m_j.ggs>, java.util.HashSet<_m_j.ggj>, _m_j.ggm, _m_j.ggt):void
     arg types: [java.lang.String, int, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList<_m_j.ggs>, java.util.HashSet<_m_j.ggj>, _m_j.ggm, _m_j.ggt):void */
    private void O00000o() {
        if (O00000o0()) {
            Map<String, List<String>> O00000oO = O00000oO();
            Map<String, Home> O00000oo = O00000oo();
            for (Map.Entry next : O00000oO.entrySet()) {
                try {
                    Home home = O00000oo.get(next.getKey());
                    if (home != null) {
                        this.f17752O000000o.add(home.getId());
                        ggn ggn = new ggn(new ArrayList((Collection) next.getValue()));
                        ArrayList arrayList = new ArrayList();
                        List<Room> roomList = home.getRoomList();
                        if (roomList != null) {
                            for (Room next2 : roomList) {
                                arrayList.add(new ggs(next2.getId(), new ArrayList(next2.getDids())));
                            }
                        }
                        this.O00000Oo.put(home.getId(), new ggo(home.getId(), true, ggn, (ArrayList<ggs>) arrayList, (HashSet<ggj>) new HashSet(), new ggm(), (ggt) null));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Map<String, List<String>> O00000oO() {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            Context appContext = ServiceApplication.getAppContext();
            String O00000o02 = gpy.O00000o0(appContext, "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "common_used_device_sort_value", "");
            if (TextUtils.isEmpty(O00000o02)) {
                Context appContext2 = ServiceApplication.getAppContext();
                O00000o02 = gpy.O00000o0(appContext2, "home_room_manager_sp_" + CoreApi.O000000o().O0000o0(), "common_used_device_sort_value", "");
            }
            JSONObject jSONObject = new JSONObject(O00000o02);
            if (!jSONObject.isNull("value") && (optJSONArray = jSONObject.optJSONArray("value")) != null) {
                if (optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        String optString = optJSONObject.optString("home_id");
                        if (!TextUtils.isEmpty(optString)) {
                            ArrayList arrayList = new ArrayList();
                            concurrentHashMap.put(optString, arrayList);
                            if (!(optJSONObject.isNull("sort") || (optJSONArray2 = optJSONObject.optJSONArray("sort")) == null || optJSONArray2.length() == 0)) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                    if (optJSONObject2 != null && !optJSONObject2.isNull("did")) {
                                        String optString2 = optJSONObject2.optString("did");
                                        if (!TextUtils.isEmpty(optString2)) {
                                            arrayList.add(optString2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return concurrentHashMap;
                }
            }
            return concurrentHashMap;
        } catch (Exception e) {
            e.printStackTrace();
            concurrentHashMap.clear();
        }
    }

    private static Map<String, Home> O00000oo() {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(gpy.O00000o0(ServiceApplication.getAppContext(), "home_room_manager_sp_", "home_room_content", "{}"));
            if (!jSONObject.isNull("homelist")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("homelist");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    ggb.O00000Oo();
                    Home O000000o2 = ggb.O000000o(optJSONObject);
                    if (O000000o2.getShareflag() == 0 && !TextUtils.isEmpty(O000000o2.getId())) {
                        hashMap.put(O000000o2.getId(), O000000o2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
