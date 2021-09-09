package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\b\u001a[\u0010\r\u001a\u0012\u0012\u0004\u0012\u0002H\u00050\u000ej\b\u0012\u0004\u0012\u0002H\u0005`\u000f\"\u0004\b\u0000\u0010\u0005*\u00020\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u0002H\u00050\u000ej\b\u0012\u0004\u0012\u0002H\u0005`\u000f2!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00050\b\u001a\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00050\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00140\b26\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u001d\u001a\u00020\u0001\u001a$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\b\u0012\u0004\u0012\u00020\u00010\u001f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020 0\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"IR_DEVICE_DID_FOR_COMMON_USE_ORDER", "", "TAG", "mapToJsonArray", "Lorg/json/JSONArray;", "T", "", "mapper", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "", "mapToList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dest", "el", "resort", "R", "K", "orderlessList", "", "orderDistinctBy", "predicate", "Lkotlin/Function2;", "r", "", "sortBySelector", "debugStr", "resortCommon", "Ljava/util/List;", "Lcom/xiaomi/smarthome/homeroom/model/GridViewData;", "smarthome-home_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ggv {
    public static final <T> ArrayList<T> O000000o(JSONArray jSONArray, ArrayList<T> arrayList, iwc<Object, ? extends T> iwc) {
        ixe.O00000o(jSONArray, "<this>");
        ixe.O00000o(arrayList, "dest");
        ixe.O00000o(iwc, "mapper");
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object obj = jSONArray.get(i);
                ixe.O00000Oo(obj, "get(index)");
                arrayList.add(iwc.invoke(obj));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    public static final <T> JSONArray O000000o(List list, iwc iwc) {
        ixe.O00000o(list, "<this>");
        ixe.O00000o(iwc, "mapper");
        JSONArray jSONArray = new JSONArray();
        for (Object invoke : list) {
            jSONArray.put(iwc.invoke(invoke));
        }
        return jSONArray;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
     arg types: [java.util.List, _m_j.ggv$O00000o0]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
     arg types: [java.util.List, _m_j.ggv$O00000Oo]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void */
    public static final List<GridViewData> O000000o(List<String> list, List<GridViewData> list2) {
        Object obj;
        ixe.O00000o(list, "<this>");
        ixe.O00000o(list2, "orderlessList");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : list) {
            if (hashSet.add((String) next)) {
                arrayList2.add(next);
            }
        }
        for (Object next2 : arrayList2) {
            ixe.O00000Oo(next2, "distinctOrderDids");
            String str = (String) next2;
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                GridViewData gridViewData = (GridViewData) obj;
                String str2 = gridViewData.O00000Oo.did;
                ixe.O00000Oo(str2, "r.device.did");
                if (gridViewData.f8988O000000o == GridViewData.GridType.TYPE_IR) {
                    str2 = "com.xiaomi.smarthome.common_use.ir_did";
                }
                if (TextUtils.equals(str, str2)) {
                    break;
                }
            }
            GridViewData gridViewData2 = (GridViewData) obj;
            if (gridViewData2 != null) {
                arrayList.add(gridViewData2);
            }
        }
        ArrayList arrayList3 = new ArrayList(list2);
        Collection collection = arrayList;
        arrayList3.removeAll(collection);
        Collection arrayList4 = new ArrayList();
        Iterator it2 = arrayList3.iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next3 = it2.next();
            GridViewData gridViewData3 = (GridViewData) next3;
            if (!TextUtils.isEmpty(gridViewData3.O00000Oo.orderTimeJString) && !TextUtils.equals(gridViewData3.O00000Oo.orderTimeJString, "0")) {
                z = false;
            }
            if (z) {
                arrayList4.add(next3);
            }
        }
        Collection O000000o2 = iuo.O000000o((Iterable) ((List) arrayList4), (Comparator) new O00000o0());
        arrayList3.removeAll(O000000o2);
        List list3 = arrayList3;
        if (list3.size() > 1) {
            iuo.O000000o(list3, (Comparator) new O00000Oo());
        }
        list2.clear();
        list2.addAll(collection);
        list2.addAll(O000000o2);
        list2.addAll(arrayList3);
        return list2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
     arg types: [java.util.List, _m_j.ggv$O000000o]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void */
    public static final <T, R, K> List<R> O000000o(List<? extends T> list, List<R> list2, iwc<? super T, ? extends K> iwc, iwn<? super T, ? super R, Boolean> iwn, iwc<? super R, String> iwc2, String str) {
        Object obj;
        ixe.O00000o(list, "<this>");
        ixe.O00000o(list2, "orderlessList");
        ixe.O00000o(iwc, "orderDistinctBy");
        ixe.O00000o(iwn, "predicate");
        ixe.O00000o(iwc2, "sortBySelector");
        ixe.O00000o(str, "debugStr");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : list) {
            if (hashSet.add(iwc.invoke(next))) {
                arrayList2.add(next);
            }
        }
        for (Object next2 : arrayList2) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (iwn.invoke(next2, obj).booleanValue()) {
                    break;
                }
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(list2);
        Collection collection = arrayList;
        arrayList3.removeAll(collection);
        List list3 = arrayList3;
        if (list3.size() > 1) {
            iuo.O000000o(list3, (Comparator) new O000000o(iwc2));
        }
        list2.clear();
        list2.addAll(collection);
        list2.addAll(arrayList3);
        return list2;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O00000Oo<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            GridViewData gridViewData = (GridViewData) t;
            String str = "";
            Comparable comparable = gridViewData == null ? str : gridViewData.O00000Oo.orderTimeJString;
            GridViewData gridViewData2 = (GridViewData) t2;
            if (gridViewData2 != null) {
                str = gridViewData2.O00000Oo.orderTimeJString;
            }
            return ivk.O000000o(comparable, str);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O00000o0<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((GridViewData) t).O00000Oo.did, ((GridViewData) t2).O00000Oo.did);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O000000o<T> implements Comparator<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ iwc f17753O000000o;

        public O000000o(iwc iwc) {
            this.f17753O000000o = iwc;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        public final int compare(T t, T t2) {
            String str = "";
            Comparable comparable = t == null ? str : (String) this.f17753O000000o.invoke(t);
            if (t2 != null) {
                str = this.f17753O000000o.invoke(t2);
            }
            return ivk.O000000o(comparable, str);
        }
    }
}
