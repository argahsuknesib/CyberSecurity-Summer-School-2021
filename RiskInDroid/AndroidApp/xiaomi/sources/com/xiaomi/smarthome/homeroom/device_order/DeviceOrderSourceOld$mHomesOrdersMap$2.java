package com.xiaomi.smarthome.homeroom.device_order;

import _m_j.gfr;
import _m_j.ggk;
import _m_j.ggm;
import _m_j.ggn;
import _m_j.ggo;
import _m_j.ggu;
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
public final class DeviceOrderSourceOld$mHomesOrdersMap$2 extends Lambda implements iwb<HashMap<String, ggo>> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceOrderSourceOld$mHomesOrdersMap$2 f8954O000000o = new DeviceOrderSourceOld$mHomesOrdersMap$2();

    DeviceOrderSourceOld$mHomesOrdersMap$2() {
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
     method: _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void
     arg types: [java.lang.String, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList<_m_j.ggs>, java.util.HashSet<_m_j.ggj>, _m_j.ggm, _m_j.ggt):void
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void */
    private static HashMap<String, ggo> O000000o() {
        ggo ggo;
        ggk ggk = ggk.f17742O000000o;
        Iterable<String> O000000o2 = ggk.O000000o();
        Collection arrayList = new ArrayList(iuo.O000000o(O000000o2, 10));
        boolean z = false;
        for (String str : O000000o2) {
            ggk ggk2 = ggk.f17742O000000o;
            String O000000o3 = ggk.O000000o(str);
            z |= !ixe.O000000o((Object) O000000o3, (Object) "{}");
            try {
                ggk ggk3 = ggk.f17742O000000o;
                ggo = ggk.O000000o(new JSONObject(O000000o3));
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
        if (!z && ggk.O00000Oo.O00000o0()) {
            hashMap2 = ggk.O00000Oo.O00000Oo;
            if (gfr.O0000Ooo) {
                ixe.O00000Oo(hashMap2, "oldCachedHomeOrder");
                for (Map.Entry value : hashMap2.entrySet()) {
                    value.getValue();
                }
            }
            ggu ggu = ggk.O00000Oo;
            ggu.O00000Oo();
            ixe.O00000Oo(hashMap2, "oldCachedHomeOrder");
        }
        return hashMap2;
    }
}
