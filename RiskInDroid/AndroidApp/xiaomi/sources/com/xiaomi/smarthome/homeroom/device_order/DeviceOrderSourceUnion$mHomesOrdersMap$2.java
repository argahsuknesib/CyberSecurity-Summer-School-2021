package com.xiaomi.smarthome.homeroom.device_order;

import _m_j.gfr;
import _m_j.ggk;
import _m_j.ggl;
import _m_j.ggm;
import _m_j.ggn;
import _m_j.ggo;
import _m_j.iuo;
import _m_j.iwb;
import _m_j.ixe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/xiaomi/smarthome/homeroom/device_order/HomeOrder;", "Lkotlin/collections/HashMap;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DeviceOrderSourceUnion$mHomesOrdersMap$2 extends Lambda implements iwb<HashMap<String, ggo>> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceOrderSourceUnion$mHomesOrdersMap$2 f8968O000000o = new DeviceOrderSourceUnion$mHomesOrdersMap$2();

    DeviceOrderSourceUnion$mHomesOrdersMap$2() {
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggl.O000000o(org.json.JSONObject, boolean):_m_j.ggo
     arg types: [org.json.JSONObject, int]
     candidates:
      _m_j.ggl.O000000o(java.util.List<_m_j.ggr$O000000o>, boolean):io.reactivex.Observable<java.util.List<_m_j.ggo>>
      _m_j.ggl.O000000o(boolean, java.util.List):io.reactivex.ObservableSource
      _m_j.ggl.O000000o(java.lang.String, java.util.List):io.reactivex.Single
      _m_j.ggl.O000000o(_m_j.ggr$O000000o, java.lang.Throwable):java.util.ArrayList
      _m_j.ggl.O000000o(org.json.JSONObject, boolean):_m_j.ggo */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void
     arg types: [java.lang.String, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList<_m_j.ggs>, java.util.HashSet<_m_j.ggj>, _m_j.ggm, _m_j.ggt):void
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void */
    private static HashMap<String, ggo> O000000o() {
        ggo ggo;
        ggl ggl = ggl.f17743O000000o;
        Iterable<String> O000000o2 = ggl.O000000o();
        Collection arrayList = new ArrayList(iuo.O000000o(O000000o2, 10));
        boolean z = false;
        for (String str : O000000o2) {
            ggl ggl2 = ggl.f17743O000000o;
            String O000000o3 = ggl.O000000o(str);
            z |= !ixe.O000000o((Object) O000000o3, (Object) "{}");
            try {
                ggl ggl3 = ggl.f17743O000000o;
                ggo = ggl.O000000o(new JSONObject(O000000o3), true);
            } catch (Exception e) {
                e.printStackTrace();
                ggo = new ggo(str, true, (ggn) null, (ArrayList) null, (HashSet) null, (ggm) null, 124);
            }
            arrayList.add(ggo);
        }
        Map hashMap = new HashMap();
        for (Object next : (List) arrayList) {
            hashMap.put(((ggo) next).f17746O000000o, next);
        }
        HashMap<String, ggo> hashMap2 = (HashMap) hashMap;
        if (z && !hashMap2.isEmpty()) {
            return hashMap2;
        }
        ggk ggk = ggk.f17742O000000o;
        HashMap<String, ggo> O00000Oo = ggk.O00000Oo();
        if (gfr.O0000Ooo) {
            for (Map.Entry value : O00000Oo.entrySet()) {
                value.getValue();
            }
        }
        return O00000Oo;
    }
}
