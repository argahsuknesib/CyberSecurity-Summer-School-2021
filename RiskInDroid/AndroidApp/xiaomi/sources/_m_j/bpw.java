package _m_j;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class bpw {
    public static bpv O000000o(DbUtils dbUtils, Object obj) throws DbException {
        List<bqd> O00000o = O00000o(dbUtils, obj);
        if (O00000o.size() == 0) {
            return null;
        }
        bpv bpv = new bpv();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INSERT INTO ");
        stringBuffer.append(bqf.O000000o(obj.getClass()));
        stringBuffer.append(" (");
        for (bqd next : O00000o) {
            stringBuffer.append(next.f13193O000000o);
            stringBuffer.append(",");
            bpv.O000000o(next.O00000Oo);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES (");
        int size = O00000o.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        bpv.f13189O000000o = stringBuffer.toString();
        return bpv;
    }

    public static bpv O00000Oo(DbUtils dbUtils, Object obj) throws DbException {
        List<bqd> O00000o = O00000o(dbUtils, obj);
        if (O00000o.size() == 0) {
            return null;
        }
        bpv bpv = new bpv();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("REPLACE INTO ");
        stringBuffer.append(bqf.O000000o(obj.getClass()));
        stringBuffer.append(" (");
        for (bqd next : O00000o) {
            stringBuffer.append(next.f13193O000000o);
            stringBuffer.append(",");
            bpv.O000000o(next.O00000Oo);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES (");
        int size = O00000o.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        bpv.f13189O000000o = stringBuffer.toString();
        return bpv;
    }

    public static String O000000o(String str) {
        return "DELETE FROM ".concat(String.valueOf(str));
    }

    public static bpv O00000o0(DbUtils dbUtils, Object obj) throws DbException {
        bpv bpv = new bpv();
        bqe O000000o2 = bqe.O000000o(dbUtils, obj.getClass());
        bqc bqc = O000000o2.O00000o0;
        Object O000000o3 = bqc.O000000o(obj);
        if (O000000o3 != null) {
            bpv.f13189O000000o = O000000o(O000000o2.O00000Oo) + " WHERE " + bpx.O000000o(bqc.O000000o(), "=", O000000o3);
            return bpv;
        }
        throw new DbException("this entity[" + obj.getClass() + "]'s id value is null");
    }

    public static bpv O000000o(DbUtils dbUtils, Object obj, String... strArr) throws DbException {
        List<bqd> O00000o = O00000o(dbUtils, obj);
        HashSet hashSet = null;
        if (O00000o.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        bqe O000000o2 = bqe.O000000o(dbUtils, obj.getClass());
        bqc bqc = O000000o2.O00000o0;
        Object O000000o3 = bqc.O000000o(obj);
        if (O000000o3 != null) {
            bpv bpv = new bpv();
            StringBuffer stringBuffer = new StringBuffer("UPDATE ");
            stringBuffer.append(O000000o2.O00000Oo);
            stringBuffer.append(" SET ");
            for (bqd next : O00000o) {
                if (hashSet == null || hashSet.contains(next.f13193O000000o)) {
                    stringBuffer.append(next.f13193O000000o);
                    stringBuffer.append("=?,");
                    bpv.O000000o(next.O00000Oo);
                }
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            stringBuffer.append(" WHERE ");
            stringBuffer.append(bpx.O000000o(bqc.O000000o(), "=", O000000o3));
            bpv.f13189O000000o = stringBuffer.toString();
            return bpv;
        }
        throw new DbException("this entity[" + obj.getClass() + "]'s id value is null");
    }

    public static bpv O000000o(DbUtils dbUtils, Class<?> cls) throws DbException {
        bqe O000000o2 = bqe.O000000o(dbUtils, cls);
        bqc bqc = O000000o2.O00000o0;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append(O000000o2.O00000Oo);
        stringBuffer.append(" ( ");
        if (bqc.O00000oo()) {
            stringBuffer.append(jdn.f1779O000000o);
            stringBuffer.append(bqc.O000000o());
            stringBuffer.append("\"  INTEGER PRIMARY KEY AUTOINCREMENT,");
        } else {
            stringBuffer.append(jdn.f1779O000000o);
            stringBuffer.append(bqc.O000000o());
            stringBuffer.append("\"  ");
            stringBuffer.append(bqc.O00000oO());
            stringBuffer.append(" PRIMARY KEY,");
        }
        for (bpy next : O000000o2.O00000o.values()) {
            if (!(next instanceof bqa)) {
                stringBuffer.append(jdn.f1779O000000o);
                stringBuffer.append(next.O000000o());
                stringBuffer.append("\"  ");
                stringBuffer.append(next.O00000oO());
                if (bpz.O0000O0o(next.O00000o0())) {
                    stringBuffer.append(" UNIQUE");
                }
                if (bpz.O0000OOo(next.O00000o0())) {
                    stringBuffer.append(" NOT NULL");
                }
                String O0000Oo0 = bpz.O0000Oo0(next.O00000o0());
                if (O0000Oo0 != null) {
                    stringBuffer.append(" CHECK(");
                    stringBuffer.append(O0000Oo0);
                    stringBuffer.append(")");
                }
                stringBuffer.append(",");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" )");
        return new bpv(stringBuffer.toString());
    }

    private static bqd O000000o(Object obj, bpy bpy) {
        String O000000o2 = bpy.O000000o();
        if (O000000o2 == null) {
            return null;
        }
        Object O000000o3 = bpy.O000000o(obj);
        if (O000000o3 == null) {
            O000000o3 = bpy.O00000Oo();
        }
        return new bqd(O000000o2, O000000o3);
    }

    private static List<bqd> O00000o(DbUtils dbUtils, Object obj) {
        bqd O000000o2;
        ArrayList arrayList = new ArrayList();
        bqe O000000o3 = bqe.O000000o(dbUtils, obj.getClass());
        bqc bqc = O000000o3.O00000o0;
        if (!bqc.O00000oo()) {
            arrayList.add(new bqd(bqc.O000000o(), bqc.O000000o(obj)));
        }
        for (bpy next : O000000o3.O00000o.values()) {
            if (!(next instanceof bqa) && (O000000o2 = O000000o(obj, next)) != null) {
                arrayList.add(O000000o2);
            }
        }
        return arrayList;
    }
}
