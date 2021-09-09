package _m_j;

import android.database.Cursor;
import com.lidroid.xutils.DbUtils;
import java.util.concurrent.ConcurrentHashMap;

public final class bpr {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bqe.O000000o(com.lidroid.xutils.DbUtils, java.lang.Class<?>):_m_j.bqe
     arg types: [com.lidroid.xutils.DbUtils, java.lang.Class<T>]
     candidates:
      _m_j.bqe.O000000o(com.lidroid.xutils.DbUtils, java.lang.String):void
      _m_j.bqe.O000000o(com.lidroid.xutils.DbUtils, java.lang.Class<?>):_m_j.bqe */
    public static <T> T O000000o(DbUtils dbUtils, Cursor cursor, Class<T> cls, long j) {
        if (cursor == null) {
            return null;
        }
        O000000o.O000000o(j);
        try {
            bqe O000000o2 = bqe.O000000o(dbUtils, (Class<?>) cls);
            bqc bqc = O000000o2.O00000o0;
            String O000000o3 = bqc.O000000o();
            int i = bqc.O00000Oo;
            if (i < 0) {
                i = cursor.getColumnIndex(O000000o3);
            }
            Object O000000o4 = bqc.O00000o().O000000o(cursor, i);
            T O000000o5 = O000000o.O000000o(cls, O000000o4);
            if (O000000o5 != null) {
                return O000000o5;
            }
            T newInstance = cls.newInstance();
            bqc.O000000o(newInstance, cursor, i);
            O000000o.O000000o(cls, O000000o4, newInstance);
            int columnCount = cursor.getColumnCount();
            for (int i2 = 0; i2 < columnCount; i2++) {
                bpy bpy = O000000o2.O00000o.get(cursor.getColumnName(i2));
                if (bpy != null) {
                    bpy.O000000o(newInstance, cursor, i2);
                }
            }
            for (bqa O000000o6 : O000000o2.O00000oO.values()) {
                O000000o6.O000000o(newInstance, null, 0);
            }
            return newInstance;
        } catch (Throwable th) {
            brm.O000000o(th.getMessage(), th);
            return null;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private static long f13184O000000o;
        private static final String O00000Oo = bpt.class.getName();
        private static final String O00000o0 = bps.class.getName();

        public static long O000000o() {
            String className = Thread.currentThread().getStackTrace()[4].getClassName();
            if (!className.equals(O00000Oo) && !className.equals(O00000o0)) {
                f13184O000000o++;
            }
            return f13184O000000o;
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final ConcurrentHashMap<String, Object> f13183O000000o = new ConcurrentHashMap<>();
        private static long O00000Oo = 0;

        public static <T> void O000000o(Class<T> cls, Object obj, Object obj2) {
            ConcurrentHashMap<String, Object> concurrentHashMap = f13183O000000o;
            concurrentHashMap.put(String.valueOf(cls.getName()) + "#" + obj, obj2);
        }

        public static <T> T O000000o(Class<T> cls, Object obj) {
            ConcurrentHashMap<String, Object> concurrentHashMap = f13183O000000o;
            return concurrentHashMap.get(String.valueOf(cls.getName()) + "#" + obj);
        }

        public static void O000000o(long j) {
            if (O00000Oo != j) {
                f13183O000000o.clear();
                O00000Oo = j;
            }
        }
    }
}
