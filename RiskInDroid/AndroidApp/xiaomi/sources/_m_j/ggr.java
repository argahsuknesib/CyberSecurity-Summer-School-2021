package _m_j;

import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006J,\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00060\f2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010J,\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\u0014\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\u0015\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/device_order/OrderCompat;", "", "()V", "changeOrder", "", "orderList", "", "", "homeId", "getCachedHomeOrders", "Lcom/xiaomi/smarthome/homeroom/device_order/HomeOrder;", "getHomeOrders", "Lio/reactivex/Observable;", "homes", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "needCache", "", "saveCategoryDeviceOrders", "cateId", "parent_id", "saveFreqCameraOrder", "saveOrders", "rooms", "Lcom/xiaomi/smarthome/homeroom/model/Room;", "HomeParam", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ggr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ggr f17748O000000o = new ggr();

    private ggr() {
    }

    public static void O000000o(String str, List<? extends Room> list) {
        ixe.O00000o(list, "rooms");
        if (str != null) {
            ggl ggl = ggl.f17743O000000o;
            ggl.O00000Oo(str, list).subscribe();
        }
    }

    public static void O000000o(String str, String str2, String str3, List<String> list) {
        ixe.O00000o(str, "homeId");
        ixe.O00000o(str2, "cateId");
        ixe.O00000o(str3, "parent_id");
        ixe.O00000o(list, "orderList");
        ggl ggl = ggl.f17743O000000o;
        ggl.O000000o(str, str2, str3, list).subscribe();
    }

    public static void O000000o(List<String> list, String str) {
        ixe.O00000o(list, "orderList");
        if (str != null) {
            ggl ggl = ggl.f17743O000000o;
            ggl.O000000o(str, list).subscribe();
        }
    }

    public static void O00000Oo(String str, List<String> list) {
        ixe.O00000o(list, "orderList");
        if (str != null) {
            ggl ggl = ggl.f17743O000000o;
            ggl.O00000o0(str, list).subscribe();
        }
    }

    public static Observable<List<ggo>> O000000o(List<? extends Home> list, boolean z) {
        if (list != null) {
            Iterable iterable = list;
            if (!iuo.O000000o(iterable).isEmpty()) {
                Iterable O000000o2 = iuo.O000000o(iterable);
                Collection arrayList = new ArrayList();
                for (Object next : O000000o2) {
                    if (((Home) next).isOwner()) {
                        arrayList.add(next);
                    }
                }
                List list2 = (List) arrayList;
                Collection arrayList2 = new ArrayList();
                for (Object next2 : O000000o2) {
                    if (!((Home) next2).isOwner()) {
                        arrayList2.add(next2);
                    }
                }
                List<Home> list3 = (List) arrayList2;
                ArrayList arrayList3 = new ArrayList();
                if (!list2.isEmpty()) {
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    ixe.O00000Oo(O0000o0, "getInstance().miId");
                    Long O000000o3 = iyo.O000000o(O0000o0);
                    Iterable<Home> iterable2 = list2;
                    Collection arrayList4 = new ArrayList(iuo.O000000o(iterable2, 10));
                    for (Home id : iterable2) {
                        arrayList4.add(id.getId());
                    }
                    arrayList3.add(new O000000o(O000000o3, (List) arrayList4));
                }
                if (!list3.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    for (Home home : list3) {
                        Map map = hashMap;
                        Long valueOf = Long.valueOf(home.getOwnerUid());
                        Object obj = map.get(valueOf);
                        if (obj == null) {
                            obj = new ArrayList();
                            map.put(valueOf, obj);
                        }
                        ((ArrayList) obj).add(home);
                    }
                    Map map2 = hashMap;
                    Collection arrayList5 = new ArrayList(map2.size());
                    for (Map.Entry entry : map2.entrySet()) {
                        arrayList5.add(iuf.O000000o(entry.getKey(), entry.getValue()));
                    }
                    Iterable<Pair> iterable3 = (List) arrayList5;
                    Collection arrayList6 = new ArrayList(iuo.O000000o(iterable3, 10));
                    for (Pair pair : iterable3) {
                        Long l = (Long) pair.first;
                        Collection arrayList7 = new ArrayList();
                        for (Home id2 : (Iterable) pair.second) {
                            String id3 = id2.getId();
                            if (id3 != null) {
                                arrayList7.add(id3);
                            }
                        }
                        arrayList6.add(new O000000o(l, (List) arrayList7, false));
                    }
                    arrayList3.addAll((List) arrayList6);
                }
                ggl ggl = ggl.f17743O000000o;
                return ggl.O000000o(arrayList3, z);
            }
        }
        Observable<List<ggo>> just = Observable.just(EmptyList.f15376O000000o);
        ixe.O00000Oo(just, "just(emptyList())");
        return just;
    }

    public static List<ggo> O000000o() {
        ggl ggl = ggl.f17743O000000o;
        Collection<ggo> values = ggl.O00000Oo().values();
        ixe.O00000Oo(values, "mHomesOrdersMap.values");
        Iterable<ggo> O00000o0 = iuo.O00000o0(values);
        Collection arrayList = new ArrayList(iuo.O000000o(O00000o0, 10));
        for (ggo ggo : O00000o0) {
            ixe.O00000Oo(ggo, "it");
            arrayList.add(ggo.O000000o(ggo.f17746O000000o, ggo.O00000Oo, ggo.O00000o0, ggo.O00000o, ggo.O00000oO, ggo.O00000oo, ggo.O0000O0o));
        }
        return (List) arrayList;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J4\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\f\"\u0004\b\r\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/device_order/OrderCompat$HomeParam;", "", "ownId", "", "homeIds", "", "", "isOwner", "", "(Ljava/lang/Long;Ljava/util/List;Z)V", "getHomeIds", "()Ljava/util/List;", "()Z", "setOwner", "(Z)V", "getOwnId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/util/List;Z)Lcom/xiaomi/smarthome/homeroom/device_order/OrderCompat$HomeParam;", "equals", "other", "hashCode", "", "toString", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Long f17749O000000o;
        final List<String> O00000Oo;
        private boolean O00000o0;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            return ixe.O000000o(this.f17749O000000o, o000000o.f17749O000000o) && ixe.O000000o(this.O00000Oo, o000000o.O00000Oo) && this.O00000o0 == o000000o.O00000o0;
        }

        public final int hashCode() {
            Long l = this.f17749O000000o;
            int hashCode = (((l == null ? 0 : l.hashCode()) * 31) + this.O00000Oo.hashCode()) * 31;
            boolean z = this.O00000o0;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public final String toString() {
            return "HomeParam(ownId=" + this.f17749O000000o + ", homeIds=" + this.O00000Oo + ", isOwner=" + this.O00000o0 + ')';
        }

        public /* synthetic */ O000000o(Long l, List list) {
            this(l, list, true);
        }

        public O000000o(Long l, List<String> list, boolean z) {
            ixe.O00000o(list, "homeIds");
            this.f17749O000000o = l;
            this.O00000Oo = list;
            this.O00000o0 = z;
        }
    }
}
