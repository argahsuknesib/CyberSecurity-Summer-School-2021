package _m_j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fbx {
    private static volatile fbx O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, List<String>> f16054O000000o = new HashMap();

    private fbx() {
    }

    public static fbx O000000o() {
        if (O00000Oo == null) {
            synchronized (fbx.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fbx();
                }
            }
        }
        return O00000Oo;
    }
}
