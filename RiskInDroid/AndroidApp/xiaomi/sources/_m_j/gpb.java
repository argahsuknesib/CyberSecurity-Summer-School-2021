package _m_j;

import com.xiaomi.smarthome.core.entity.device.MiTVDevice;
import com.xiaomi.smarthome.core.entity.device.RouterDevice;
import com.xiaomi.smarthome.core.entity.device.WatchBandDevice;
import java.util.HashMap;
import java.util.Map;

public final class gpb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Map<String, Class<?>> f18113O000000o;

    static {
        HashMap hashMap = new HashMap();
        f18113O000000o = hashMap;
        hashMap.put("xiaomi.tv.v1", MiTVDevice.class);
        f18113O000000o.put("xiaomi.tv.b1", MiTVDevice.class);
        f18113O000000o.put("xiaomi.tv.i1", MiTVDevice.class);
        f18113O000000o.put("xiaomi.tv.h1", MiTVDevice.class);
        f18113O000000o.put("xiaomi.tvbox.v1", MiTVDevice.class);
        f18113O000000o.put("xiaomi.tvbox.b1", MiTVDevice.class);
        f18113O000000o.put("xiaomi.tvbox.i1", MiTVDevice.class);
        f18113O000000o.put("xiaomi.split_tv.b1", MiTVDevice.class);
        f18113O000000o.put("xiaomi.split_tv.v1", MiTVDevice.class);
        f18113O000000o.put("fengmi.projector.fm15", MiTVDevice.class);
        f18113O000000o.put("inovel.projector.me2", MiTVDevice.class);
        f18113O000000o.put("zimi.projector.v1", MiTVDevice.class);
        f18113O000000o.put("fengmi.projector.fm154k", MiTVDevice.class);
        f18113O000000o.put("fengmi.projector.fm05", MiTVDevice.class);
        for (String put : fcl.f16083O000000o) {
            f18113O000000o.put(put, WatchBandDevice.class);
        }
    }

    public static Class<?> O000000o(String str) {
        Class<?> cls = f18113O000000o.get(str);
        return (cls != null || !str.startsWith("xiaomi.router")) ? cls : RouterDevice.class;
    }
}
