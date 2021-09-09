package _m_j;

import android.text.TextUtils;
import com.lidroid.xutils.DbUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class bqe {
    private static final HashMap<String, bqe> O0000O0o = new HashMap<>();

    /* renamed from: O000000o  reason: collision with root package name */
    public final DbUtils f13194O000000o;
    public final String O00000Oo;
    public final HashMap<String, bpy> O00000o;
    public final bqc O00000o0;
    public final HashMap<String, bqa> O00000oO = new HashMap<>();
    public boolean O00000oo;

    private bqe(DbUtils dbUtils, Class<?> cls) {
        this.f13194O000000o = dbUtils;
        this.O00000Oo = bqf.O000000o(cls);
        this.O00000o0 = bqf.O00000o(cls);
        this.O00000o = bqf.O00000o0(cls);
        for (bpy next : this.O00000o.values()) {
            next.f13191O000000o = this;
            if (next instanceof bqa) {
                this.O00000oO.put(next.O000000o(), (bqa) next);
            }
        }
    }

    public static synchronized bqe O000000o(DbUtils dbUtils, Class<?> cls) {
        bqe bqe;
        synchronized (bqe.class) {
            String str = String.valueOf(dbUtils.f4507O000000o.O00000Oo) + "#" + cls.getName();
            bqe = O0000O0o.get(str);
            if (bqe == null) {
                bqe = new bqe(dbUtils, cls);
                O0000O0o.put(str, bqe);
            }
        }
        return bqe;
    }

    public static synchronized void O00000Oo(DbUtils dbUtils, Class<?> cls) {
        synchronized (bqe.class) {
            O0000O0o.remove(String.valueOf(dbUtils.f4507O000000o.O00000Oo) + "#" + cls.getName());
        }
    }

    public static synchronized void O000000o(DbUtils dbUtils, String str) {
        synchronized (bqe.class) {
            if (O0000O0o.size() > 0) {
                String str2 = null;
                Iterator<Map.Entry<String, bqe>> it = O0000O0o.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry next = it.next();
                        bqe bqe = (bqe) next.getValue();
                        if (bqe != null && bqe.O00000Oo.equals(str)) {
                            str2 = (String) next.getKey();
                            if (str2.startsWith(String.valueOf(dbUtils.f4507O000000o.O00000Oo) + "#")) {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    O0000O0o.remove(str2);
                }
            }
        }
    }
}
