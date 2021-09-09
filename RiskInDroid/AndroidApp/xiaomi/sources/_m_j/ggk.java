package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceOld$mHomesListOrder$2;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceOld$mHomesOrdersMap$2;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceOld$parseHomeOrder$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceOld$parseHomeOrder$2;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceOld$parseHomeOrder$3;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR7\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010`\u00118FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/xiaomi/smarthome/homeroom/device_order/DeviceOrderSourceOld;", "", "()V", "HOME_ORDER_KEY_PREFIX", "", "PREFS_HOME_ORDER", "TAG", "mHomesListOrder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMHomesListOrder", "()Ljava/util/ArrayList;", "mHomesListOrder$delegate", "Lkotlin/Lazy;", "mHomesOrdersMap", "Ljava/util/HashMap;", "Lcom/xiaomi/smarthome/homeroom/device_order/HomeOrder;", "Lkotlin/collections/HashMap;", "getMHomesOrdersMap", "()Ljava/util/HashMap;", "mHomesOrdersMap$delegate", "mUpgradeOrderCompat", "Lcom/xiaomi/smarthome/homeroom/device_order/UpgradeOrderCompat;", "kotlin.jvm.PlatformType", "getCachedHomeListOrder", "getCachedHomeOrder", "homeId", "parseHomeOrder", "json", "Lorg/json/JSONObject;", "isCached", "", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ggk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ggk f17742O000000o = new ggk();
    public static final ggu O00000Oo = ggu.O000000o();
    private static final itz O00000o = iua.O000000o(f17742O000000o, DeviceOrderSourceOld$mHomesOrdersMap$2.f8954O000000o);
    private static final itz O00000o0 = iua.O000000o(f17742O000000o, DeviceOrderSourceOld$mHomesListOrder$2.f8952O000000o);

    private ggk() {
    }

    public static ArrayList<String> O000000o() {
        return (ArrayList) O00000o0.O000000o();
    }

    public static HashMap<String, ggo> O00000Oo() {
        return (HashMap) O00000o.O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static String O000000o(String str) {
        String O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_home_order", ixe.O000000o("home_order_key_prefix_", (Object) str), "{}");
        ixe.O00000Oo(O00000o02, "getSettingString(ServiceApplication.getAppContext(),\n                PREFS_HOME_ORDER, HOME_ORDER_KEY_PREFIX + homeId, \"{}\")");
        return O00000o02;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static String O00000o0() {
        String O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_home_order", ixe.O000000o("home_order_key_prefix_", (Object) gpp.O00000Oo(CoreApi.O000000o().O0000o0())), "[]");
        if (TextUtils.equals(O00000o02, "[]")) {
            O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_home_order", ixe.O000000o("home_order_key_prefix_", (Object) CoreApi.O000000o().O0000o0()), "[]");
        }
        ixe.O00000Oo(O00000o02, "cache");
        return O00000o02;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void
     arg types: [java.lang.String, int, _m_j.ggn, java.util.ArrayList, java.util.HashSet, ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList<_m_j.ggs>, java.util.HashSet<_m_j.ggj>, _m_j.ggm, _m_j.ggt):void
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void */
    public static ggo O000000o(JSONObject jSONObject) {
        ggn ggn = new ggn();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("front_order");
        if (optJSONArray != null) {
            ggv.O000000o(optJSONArray, ggn.f17745O000000o, DeviceOrderSourceOld$parseHomeOrder$1.f8955O000000o);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("room_order");
        if (optJSONArray2 != null) {
            ggv.O000000o(optJSONArray2, arrayList, DeviceOrderSourceOld$parseHomeOrder$2.f8956O000000o);
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("cate_order");
        if (optJSONArray3 != null) {
            ggv.O000000o(optJSONArray3, arrayList2, DeviceOrderSourceOld$parseHomeOrder$3.f8958O000000o);
        }
        String optString = jSONObject.optString("home_id");
        ixe.O00000Oo(optString, "json.optString(\"home_id\")");
        return new ggo(optString, true, ggn, arrayList, iuo.O00000Oo((Iterable) arrayList2), (ggm) null, 96);
    }
}
