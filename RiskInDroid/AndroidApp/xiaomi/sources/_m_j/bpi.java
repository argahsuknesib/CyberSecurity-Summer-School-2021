package _m_j;

import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public final class bpi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ConcurrentHashMap<String, bph> f13182O000000o = new ConcurrentHashMap<>();

    public static bph O000000o(Class cls) {
        if (f13182O000000o.containsKey(cls.getName())) {
            return f13182O000000o.get(cls.getName());
        }
        if (!bph.class.isAssignableFrom(cls)) {
            return null;
        }
        try {
            bph bph = (bph) cls.newInstance();
            if (bph != null) {
                f13182O000000o.put(cls.getName(), bph);
            }
            return bph;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ColumnDbType O00000Oo(Class cls) {
        bph O000000o2 = O000000o(cls);
        if (O000000o2 != null) {
            return O000000o2.O000000o();
        }
        return ColumnDbType.TEXT;
    }

    public static boolean O00000o0(Class cls) {
        if (f13182O000000o.containsKey(cls.getName())) {
            return true;
        }
        if (bph.class.isAssignableFrom(cls)) {
            try {
                bph bph = (bph) cls.newInstance();
                if (bph != null) {
                    f13182O000000o.put(cls.getName(), bph);
                }
                if (bph == null) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    static {
        bpd bpd = new bpd();
        f13182O000000o.put(Boolean.TYPE.getName(), bpd);
        f13182O000000o.put(Boolean.class.getName(), bpd);
        f13182O000000o.put(byte[].class.getName(), new bpe());
        bpf bpf = new bpf();
        f13182O000000o.put(Byte.TYPE.getName(), bpf);
        f13182O000000o.put(Byte.class.getName(), bpf);
        bpg bpg = new bpg();
        f13182O000000o.put(Character.TYPE.getName(), bpg);
        f13182O000000o.put(Character.class.getName(), bpg);
        f13182O000000o.put(Date.class.getName(), new bpj());
        bpk bpk = new bpk();
        f13182O000000o.put(Double.TYPE.getName(), bpk);
        f13182O000000o.put(Double.class.getName(), bpk);
        bpl bpl = new bpl();
        f13182O000000o.put(Float.TYPE.getName(), bpl);
        f13182O000000o.put(Float.class.getName(), bpl);
        bpm bpm = new bpm();
        f13182O000000o.put(Integer.TYPE.getName(), bpm);
        f13182O000000o.put(Integer.class.getName(), bpm);
        bpn bpn = new bpn();
        f13182O000000o.put(Long.TYPE.getName(), bpn);
        f13182O000000o.put(Long.class.getName(), bpn);
        bpo bpo = new bpo();
        f13182O000000o.put(Short.TYPE.getName(), bpo);
        f13182O000000o.put(Short.class.getName(), bpo);
        f13182O000000o.put(java.sql.Date.class.getName(), new bpp());
        f13182O000000o.put(String.class.getName(), new bpq());
    }
}
