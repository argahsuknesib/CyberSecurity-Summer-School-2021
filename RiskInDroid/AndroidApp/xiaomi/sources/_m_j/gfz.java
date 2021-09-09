package _m_j;

import _m_j.ggb;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.homeroom.DeviceListAssemble$reorderCategory$1;
import com.xiaomi.smarthome.homeroom.DeviceListAssemble$reorderCategory$2;
import com.xiaomi.smarthome.homeroom.DeviceListAssemble$reorderCategory$3;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011H\u0002¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/DeviceListAssemble;", "", "()V", "getCategoryDeviceList", "", "Lcom/xiaomi/smarthome/device/Device;", "name", "", "getDeviceList", "pageBean", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "getRoomDeviceList", "roomId", "id", "reorderCategory", "categoryName", "dids", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class gfz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final gfz f17670O000000o = new gfz();

    private gfz() {
    }

    public final List<Device> O000000o(PageBean pageBean) {
        ixe.O00000o(pageBean, "pageBean");
        if (pageBean.O00000o0) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object next : O000000o(pageBean.f10340O000000o)) {
                if (hashSet.add(((Device) next).did)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : O000000o(pageBean.O00000Oo, pageBean.O00000Oo)) {
            if (hashSet2.add(((Device) next2).did)) {
                arrayList2.add(next2);
            }
        }
        return arrayList2;
    }

    private static List<Device> O000000o(String str, String str2) {
        List<Device> list;
        switch (str.hashCode()) {
            case -2077299665:
                if (str.equals("mijia.roomid.nearby")) {
                    List<Device> list2 = gge.O000000o().f17734O000000o;
                    ixe.O00000Oo(list2, "getInstance().nearbyDeviceList");
                    return list2;
                }
                break;
            case -358008972:
                if (str.equals("mijia.roomid.uncommon")) {
                    List<GridViewData> O0000o0O = ggb.O00000Oo().O0000o0O();
                    ixe.O00000Oo(O0000o0O, "getInstance().unCommonUseDevices");
                    Iterable<GridViewData> iterable = O0000o0O;
                    Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
                    for (GridViewData gridViewData : iterable) {
                        arrayList.add(gridViewData.O00000Oo);
                    }
                    return (List) arrayList;
                }
                break;
            case -252753263:
                if (str.equals("mijia.roomid.default")) {
                    List<Device> O0000O0o = ggb.O00000Oo().O0000O0o();
                    ixe.O00000Oo(O0000O0o, "getInstance().defaultRoomDeviceList");
                    return O0000O0o;
                }
                break;
            case 491886639:
                if (str.equals("mijia.roomid.share")) {
                    gge.O000000o();
                    List<Device> O00000oO = gge.O00000oO();
                    ixe.O00000Oo(O00000oO, "getInstance().shareDeviceList");
                    return O00000oO;
                }
                break;
            case 1189320177:
                if (str.equals("mijia.roomid.all")) {
                    List<GridViewData> O0000o0o = ggb.O00000Oo().O0000o0o();
                    ixe.O00000Oo(O0000o0o, "getInstance().allDevices");
                    Iterable<GridViewData> iterable2 = O0000o0o;
                    Collection arrayList2 = new ArrayList(iuo.O000000o(iterable2, 10));
                    for (GridViewData gridViewData2 : iterable2) {
                        arrayList2.add(gridViewData2.O00000Oo);
                    }
                    return (List) arrayList2;
                }
                break;
            case 1912335259:
                if (str.equals("mijia.roomid.common")) {
                    List<GridViewData> O0000o0 = ggb.O00000Oo().O0000o0();
                    ixe.O00000Oo(O0000o0, "getInstance().commonUseDevices");
                    Iterable<GridViewData> iterable3 = O0000o0;
                    Collection arrayList3 = new ArrayList(iuo.O000000o(iterable3, 10));
                    for (GridViewData gridViewData3 : iterable3) {
                        arrayList3.add(gridViewData3.O00000Oo);
                    }
                    return (List) arrayList3;
                }
                break;
        }
        Room O00000o0 = ggb.O00000Oo().O00000o0(str2);
        if (O00000o0 == null) {
            list = null;
        } else {
            list = ggb.O00000Oo().O00000Oo(O00000o0);
        }
        return list == null ? EmptyList.f15376O000000o : list;
    }

    private static List<Device> O000000o(String str) {
        Collection arrayList = new ArrayList();
        for (String O000000o2 : O000000o(str, fnn.O000000o().O00000Oo().O000000o(ggb.O00000Oo().O0000OOo(), str))) {
            Device O000000o3 = fno.O000000o().O000000o(O000000o2);
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        return (List) arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.util.List} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O00000Oo(java.lang.Iterable, java.util.Collection):C
     arg types: [java.util.Set<java.lang.String>, java.util.Collection]
     candidates:
      _m_j.iuy.O00000Oo(java.lang.Iterable, java.lang.Object):int
      _m_j.iuy.O00000Oo(java.util.Collection, java.lang.Iterable):java.util.List<T>
      _m_j.iuy.O00000Oo(java.lang.Iterable, java.util.Collection):C */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX WARNING: Multi-variable type inference failed */
    private static List<String> O000000o(String str, Set<String> set) {
        List<String> list;
        Collection collection = set;
        if (collection == null || collection.isEmpty()) {
            return EmptyList.f15376O000000o;
        }
        try {
            String str2 = fnn.O000000o().O00000Oo().O00000o(str).id;
            ggb O00000Oo = ggb.O00000Oo();
            list = new ArrayList<>();
            String str3 = null;
            if (TextUtils.isEmpty(null)) {
                str3 = O00000Oo.O0000OOo();
            }
            if (!TextUtils.isEmpty(str3)) {
                List list2 = ggb.O00000o0.O00000o0.get(str3);
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                if (fqv.f16910O000000o) {
                    str2 = str2 + "_";
                }
                int i = 0;
                while (true) {
                    if (i < list2.size()) {
                        Pair pair = (Pair) list2.get(i);
                        if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && TextUtils.equals((CharSequence) pair.first, str2)) {
                            list = pair.second;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                DeviceTagInterface<Device> O00000Oo2 = fnn.O000000o().O00000Oo();
                DeviceTagInterface.Category O0000OOo = O00000Oo2.O0000OOo(str2);
                if (O0000OOo != null) {
                    Set<String> O000000o2 = O00000Oo2.O000000o(str3, O0000OOo.name);
                    if (!O000000o2.isEmpty()) {
                        HashSet hashSet = new HashSet(O000000o2);
                        for (String remove : list) {
                            hashSet.remove(remove);
                        }
                        list.addAll(0, hashSet);
                    }
                }
            }
            ixe.O00000Oo(list, "{\n            val cateId = SmartHomeDeviceHelper.getInstance().deviceTagManager.getTopCategoryId(categoryName).id\n            val sorted = HomeManager.getInstance().getCategoryDids(null, cateId)\n            sorted\n        }");
        } catch (Exception unused) {
            list = EmptyList.f15376O000000o;
        }
        return ggv.O000000o(list, (List) iuo.O00000Oo((Iterable) set, new ArrayList()), DeviceListAssemble$reorderCategory$1.f8819O000000o, DeviceListAssemble$reorderCategory$2.f8820O000000o, DeviceListAssemble$reorderCategory$3.f8821O000000o, ixe.O000000o(str, (Object) " order"));
    }
}
