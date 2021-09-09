package _m_j;

import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class hnv {
    public static List<SceneApi.O000OOOo> O000000o(Home home, List<SceneApi.O000OOOo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            if (home != null && !home.getId().equalsIgnoreCase("ALL_HOME")) {
                List<String> O000000o2 = ggb.O00000Oo().O000000o(home.getId(), true);
                HashSet hashSet = null;
                if (O000000o2 != null && !O000000o2.isEmpty()) {
                    hashSet = new HashSet(O000000o2);
                }
                for (int i = 0; i < list.size(); i++) {
                    List<String> list2 = list.get(i).O0000oOo;
                    list2.addAll(O000000o(list.get(i), 0));
                    if (list2 != null && !list2.isEmpty() && O000000o(list2)) {
                        int i2 = 0;
                        while (true) {
                            if (i2 < (list2 != null ? list2.size() : 0)) {
                                if (hashSet != null && hashSet.contains(list2.get(i2))) {
                                    arrayList.add(list.get(i));
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        arrayList.add(list.get(i));
                    }
                }
                return arrayList;
            } else if (list != null && !list.isEmpty()) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public static List<SceneApi.O000OOOo> O000000o(Home home, Room room, List<SceneApi.O000OOOo> list) {
        List<Device> list2;
        List<Device> O0000O0o;
        ArrayList arrayList = new ArrayList();
        if (!(home == null || list == null || list.isEmpty())) {
            if (room == null || room.getId().equalsIgnoreCase("ALL_ROOM")) {
                List<SceneApi.O000OOOo> O000000o2 = O000000o(home, list);
                if (!O000000o2.isEmpty()) {
                    arrayList.addAll(O000000o2);
                }
            } else if (room.getId().equalsIgnoreCase("DEFAULT_ROOM")) {
                if (home.getId().equalsIgnoreCase("ALL_HOME")) {
                    List<Home> list3 = ggb.O00000Oo().O0000OoO.O00000Oo;
                    list2 = null;
                    int i = 0;
                    while (true) {
                        if (i >= (list3 == null ? 0 : list3.size())) {
                            break;
                        }
                        if (list3.get(i).isOwner() && (O0000O0o = ggb.O00000Oo().O0000O0o(list3.get(i).getId())) != null && O0000O0o.size() > 0) {
                            if (list2 == null) {
                                list2 = new ArrayList<>();
                            }
                            list2.addAll(O0000O0o);
                        }
                        i++;
                    }
                } else {
                    list2 = ggb.O00000Oo().O0000O0o(home.getId());
                }
                if (list2 == null || list2.isEmpty()) {
                    return arrayList;
                }
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    hashSet.add(((Device) list2.get(i2)).did);
                }
                return O000000o(hashSet, list);
            } else {
                List<String> dids = room.getDids();
                if (dids == null || dids.isEmpty()) {
                    return arrayList;
                }
                return O000000o(new HashSet(dids), list);
            }
        }
        return arrayList;
    }

    public static List<SceneApi.O000OOOo> O000000o(Home home, DeviceTagInterface.Category category, List<SceneApi.O000OOOo> list) {
        Map<String, List<String>> map;
        List list2;
        ArrayList arrayList = new ArrayList();
        if (!(home == null || category == null || list == null || list.isEmpty())) {
            if (home.getId().equalsIgnoreCase("ALL_HOME")) {
                List<Home> list3 = ggb.O00000Oo().O0000OoO.O00000Oo;
                map = null;
                int i = 0;
                while (true) {
                    if (i >= (list3 == null ? 0 : list3.size())) {
                        break;
                    }
                    if (list3.get(i).isOwner()) {
                        Map<String, List<String>> O0000Oo = fnn.O000000o().O00000Oo().O0000Oo(list3.get(i).getId());
                        if (O0000Oo.size() > 0) {
                            if (map == null) {
                                map = new HashMap<>();
                                map.putAll(O0000Oo);
                            } else {
                                for (Map.Entry next : O0000Oo.entrySet()) {
                                    if (!(next.getValue() == null || ((List) next.getValue()).size() == 0 || !map.containsKey(next.getKey()))) {
                                        Object obj = map.get(next.getKey());
                                        if (obj == null) {
                                            obj = new ArrayList();
                                        }
                                        obj.addAll((Collection) next.getValue());
                                    }
                                }
                            }
                        }
                    }
                    i++;
                }
            } else {
                map = fnn.O000000o().O00000Oo().O0000Oo(home.getId());
            }
            if (map != null && !map.isEmpty() && (list2 = (List) map.get(category.name)) != null && !list2.isEmpty()) {
                return O000000o(new HashSet(list2), list);
            }
        }
        return arrayList;
    }

    private static List<SceneApi.O000OOOo> O000000o(Set<String> set, List<SceneApi.O000OOOo> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            List<String> list2 = list.get(i).O0000oOo;
            list2.addAll(O000000o(list.get(i), 0));
            int i2 = 0;
            while (true) {
                if (i2 >= (list2 != null ? list2.size() : 0)) {
                    break;
                } else if (set.contains(list2.get(i2))) {
                    arrayList.add(list.get(i));
                    break;
                } else {
                    i2++;
                }
            }
        }
        return arrayList;
    }

    private static boolean O000000o(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (fno.O000000o().O000000o(list.get(i)) != null) {
                return true;
            }
        }
        return false;
    }

    private static Set<String> O000000o(SceneApi.O000OOOo o000OOOo, int i) {
        HashSet hashSet = new HashSet();
        if (!(o000OOOo == null || o000OOOo.O00000oo == null || o000OOOo.O00000oo.size() <= 0)) {
            for (SceneApi.Action next : o000OOOo.O00000oo) {
                if (next.O0000O0o != null) {
                    SceneApi.O000OOOo o000OOOo2 = null;
                    if (next.O0000O0o instanceof SceneApi.O000O0OO) {
                        o000OOOo2 = hod.O0000OoO().O00000Oo(((SceneApi.O000O0OO) next.O0000O0o).f11128O000000o);
                    } else if (next.O0000O0o instanceof SceneApi.O000O00o) {
                        o000OOOo2 = hod.O0000OoO().O00000Oo(((SceneApi.O000O00o) next.O0000O0o).f11127O000000o);
                    }
                    if (!(o000OOOo2 == null || o000OOOo2.O0000oOo == null || o000OOOo2.O0000oOo.size() <= 0)) {
                        hashSet.addAll(o000OOOo2.O0000oOo);
                        if (i < 3) {
                            i++;
                            hashSet.addAll(O000000o(o000OOOo2, i));
                        }
                    }
                }
            }
        }
        return hashSet;
    }
}
