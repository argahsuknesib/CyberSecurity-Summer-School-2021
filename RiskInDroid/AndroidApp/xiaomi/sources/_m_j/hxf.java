package _m_j;

import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class hxf {
    private static hxf O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, List<String>> f947O000000o = new HashMap();

    private hxf() {
    }

    public static hxf O000000o() {
        if (O00000Oo == null) {
            synchronized (hxf.class) {
                if (O00000Oo == null) {
                    O00000Oo = new hxf();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o(String str, String str2) {
        synchronized (hxf.class) {
            if (this.f947O000000o.containsKey(str)) {
                List list = this.f947O000000o.get(str);
                if (list == null) {
                    new ArrayList().add(str2);
                } else if (!list.contains(str2)) {
                    list.add(str2);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str2);
                this.f947O000000o.put(str, arrayList);
            }
        }
    }

    public static int O000000o(List<Device> list) {
        int i = 0;
        for (Device next : list) {
            if (next != null && !next.isOnline) {
                i++;
            }
        }
        return i;
    }

    public static void O000000o(List<Device> list, List<Device> list2) {
        for (Device next : list2) {
            if (next != null) {
                boolean z = false;
                Iterator<Device> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Device next2 = it.next();
                        if (next2 != null && next2.did.equalsIgnoreCase(next.did)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    list.add(next);
                }
            }
        }
    }
}
