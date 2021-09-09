package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class gzg {
    private static volatile gzg O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<IPreModuleAware> f18614O000000o = new ArrayList();
    public Map<String, IPreModuleAware> O00000Oo = new HashMap();
    private Map<String, gze> O00000o = new ConcurrentHashMap();

    private gzg() {
    }

    public static gzg O000000o() {
        if (O00000o0 == null) {
            synchronized (gzg.class) {
                if (O00000o0 == null) {
                    O00000o0 = new gzg();
                }
            }
        }
        return O00000o0;
    }

    public final <T extends gze> T O000000o(String str) {
        IPreModuleAware iPreModuleAware = this.O00000Oo.get(str);
        if (iPreModuleAware == null) {
            return null;
        }
        T t = (gze) this.O00000o.get(str);
        if (t == null && (t = iPreModuleAware.getModuleClass()) != null) {
            this.O00000o.put(str, t);
        }
        return t;
    }
}
