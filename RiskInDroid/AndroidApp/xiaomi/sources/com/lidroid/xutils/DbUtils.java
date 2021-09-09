package com.lidroid.xutils;

import _m_j.bpr;
import _m_j.bpu;
import _m_j.bpv;
import _m_j.bpw;
import _m_j.bpx;
import _m_j.bqc;
import _m_j.bqe;
import _m_j.bqf;
import _m_j.brl;
import _m_j.brm;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.lidroid.xutils.exception.DbException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DbUtils {
    private static HashMap<String, DbUtils> O00000o0 = new HashMap<>();

    /* renamed from: O000000o  reason: collision with root package name */
    public DaoConfig f4507O000000o;
    public boolean O00000Oo = false;
    private SQLiteDatabase O00000o;
    private boolean O00000oO = false;
    private Lock O00000oo = new ReentrantLock();
    private volatile boolean O0000O0o = false;
    private final O00000Oo O0000OOo = new O00000Oo(this, (byte) 0);

    public interface O000000o {
        void onUpgrade(DbUtils dbUtils, int i, int i2);
    }

    private DbUtils(DaoConfig daoConfig) {
        if (daoConfig != null) {
            String str = daoConfig.O00000oO;
            SQLiteDatabase sQLiteDatabase = null;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() || file.mkdirs()) {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(new File(str, daoConfig.O00000Oo), (SQLiteDatabase.CursorFactory) null);
                }
            } else {
                sQLiteDatabase = daoConfig.f4508O000000o.openOrCreateDatabase(daoConfig.O00000Oo, 0, null);
            }
            this.O00000o = sQLiteDatabase;
            this.f4507O000000o = daoConfig;
            return;
        }
        throw new IllegalArgumentException("daoConfig may not be null");
    }

    private static synchronized DbUtils O000000o(DaoConfig daoConfig) {
        DbUtils dbUtils;
        Cursor O00000Oo2;
        synchronized (DbUtils.class) {
            dbUtils = O00000o0.get(daoConfig.O00000Oo);
            if (dbUtils == null) {
                dbUtils = new DbUtils(daoConfig);
                O00000o0.put(daoConfig.O00000Oo, dbUtils);
            } else {
                dbUtils.f4507O000000o = daoConfig;
            }
            SQLiteDatabase sQLiteDatabase = dbUtils.O00000o;
            int version = sQLiteDatabase.getVersion();
            int i = daoConfig.O00000o0;
            if (version != i) {
                if (version != 0) {
                    O000000o o000000o = daoConfig.O00000o;
                    if (o000000o != null) {
                        o000000o.onUpgrade(dbUtils, version, i);
                    } else {
                        try {
                            O00000Oo2 = dbUtils.O00000Oo("SELECT name FROM sqlite_master WHERE type='table' AND name<>'sqlite_sequence'");
                            if (O00000Oo2 != null) {
                                while (O00000Oo2.moveToNext()) {
                                    try {
                                        String string = O00000Oo2.getString(0);
                                        dbUtils.O000000o("DROP TABLE ".concat(String.valueOf(string)));
                                        bqe.O000000o(dbUtils, string);
                                    } catch (Throwable th) {
                                        throw new DbException(th);
                                    }
                                }
                                brl.O000000o(O00000Oo2);
                            }
                        } catch (DbException e) {
                            brm.O000000o(e.getMessage(), e);
                        } catch (Throwable th2) {
                            brl.O000000o(O00000Oo2);
                            throw th2;
                        }
                    }
                }
                sQLiteDatabase.setVersion(i);
            }
        }
        return dbUtils;
    }

    public static DbUtils O000000o(Context context, String str, int i, O000000o o000000o) {
        DaoConfig daoConfig = new DaoConfig(context);
        daoConfig.O000000o(str);
        daoConfig.O00000o0 = i;
        daoConfig.O00000o = o000000o;
        return O000000o(daoConfig);
    }

    public static DbUtils O000000o(Context context, String str, String str2, int i, O000000o o000000o) {
        DaoConfig daoConfig = new DaoConfig(context);
        daoConfig.O00000oO = str;
        daoConfig.O000000o(str2);
        daoConfig.O00000o0 = i;
        daoConfig.O00000o = o000000o;
        return O000000o(daoConfig);
    }

    public final void O000000o(Object obj) throws DbException {
        try {
            O000000o();
            O00000o0(obj.getClass());
            O00000o(obj);
            O00000Oo();
        } finally {
            O00000o0();
        }
    }

    public final void O000000o(List<?> list) throws DbException {
        if (list != null && list.size() != 0) {
            try {
                O000000o();
                O00000o0(list.get(0).getClass());
                for (Object O00000o2 : list) {
                    O00000o(O00000o2);
                }
                O00000Oo();
            } finally {
                O00000o0();
            }
        }
    }

    public final void O00000Oo(Object obj) throws DbException {
        try {
            O000000o();
            O00000o0(obj.getClass());
            O000000o(bpw.O000000o(this, obj));
            O00000Oo();
        } finally {
            O00000o0();
        }
    }

    public final void O00000Oo(List<?> list) throws DbException {
        if (list != null && list.size() != 0) {
            try {
                O000000o();
                O00000o0(list.get(0).getClass());
                for (Object O000000o2 : list) {
                    O000000o(bpw.O000000o(this, O000000o2));
                }
                O00000Oo();
            } finally {
                O00000o0();
            }
        }
    }

    public final void O00000o0(Object obj) throws DbException {
        if (O00000Oo(obj.getClass())) {
            try {
                O000000o();
                O000000o(bpw.O00000o0(this, obj));
                O00000Oo();
            } finally {
                O00000o0();
            }
        }
    }

    public final void O000000o(Class<?> cls, bpx bpx) throws DbException {
        if (O00000Oo(cls)) {
            try {
                O000000o();
                StringBuilder sb = new StringBuilder(bpw.O000000o(bqe.O000000o(this, cls).O00000Oo));
                if (bpx != null && bpx.O000000o() > 0) {
                    sb.append(" WHERE ");
                    sb.append(bpx.toString());
                }
                O000000o(new bpv(sb.toString()));
                O00000Oo();
            } finally {
                O00000o0();
            }
        }
    }

    public final void O00000o0(List<?> list) throws DbException {
        if (list != null && list.size() != 0 && O00000Oo(list.get(0).getClass())) {
            try {
                O000000o();
                for (Object O00000o02 : list) {
                    O000000o(bpw.O00000o0(this, O00000o02));
                }
                O00000Oo();
            } finally {
                O00000o0();
            }
        }
    }

    public final void O000000o(Object obj, String... strArr) throws DbException {
        if (O00000Oo(obj.getClass())) {
            try {
                O000000o();
                O000000o(bpw.O000000o(this, obj, strArr));
                O00000Oo();
            } finally {
                O00000o0();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bqe.O000000o(com.lidroid.xutils.DbUtils, java.lang.Class<?>):_m_j.bqe
     arg types: [com.lidroid.xutils.DbUtils, java.lang.Class<T>]
     candidates:
      _m_j.bqe.O000000o(com.lidroid.xutils.DbUtils, java.lang.String):void
      _m_j.bqe.O000000o(com.lidroid.xutils.DbUtils, java.lang.Class<?>):_m_j.bqe */
    public final <T> T O000000o(Class<T> cls, Object obj) throws DbException {
        if (!O00000Oo((Class<?>) cls)) {
            return null;
        }
        String bpu = bpu.O000000o((Class<?>) cls).O000000o(bqe.O000000o(this, (Class<?>) cls).O00000o0.O000000o(), "=", obj).O000000o().toString();
        long O000000o2 = bpr.O00000Oo.O000000o();
        this.O0000OOo.O000000o(O000000o2);
        T O000000o3 = this.O0000OOo.O000000o(bpu);
        if (O000000o3 != null) {
            return O000000o3;
        }
        Cursor O00000Oo2 = O00000Oo(bpu);
        if (O00000Oo2 != null) {
            try {
                if (O00000Oo2.moveToNext()) {
                    T O000000o4 = bpr.O000000o(this, O00000Oo2, cls, O000000o2);
                    this.O0000OOo.O000000o(bpu, O000000o4);
                    brl.O000000o(O00000Oo2);
                    return O000000o4;
                }
                brl.O000000o(O00000Oo2);
            } catch (Throwable th) {
                brl.O000000o(O00000Oo2);
                throw th;
            }
        }
        return null;
    }

    public final <T> T O000000o(bpu bpu) throws DbException {
        if (!O00000Oo(bpu.O00000Oo())) {
            return null;
        }
        String bpu2 = bpu.O000000o().toString();
        long O000000o2 = bpr.O00000Oo.O000000o();
        this.O0000OOo.O000000o(O000000o2);
        T O000000o3 = this.O0000OOo.O000000o(bpu2);
        if (O000000o3 != null) {
            return O000000o3;
        }
        Cursor O00000Oo2 = O00000Oo(bpu2);
        if (O00000Oo2 != null) {
            try {
                if (O00000Oo2.moveToNext()) {
                    T O000000o4 = bpr.O000000o(this, O00000Oo2, bpu.O00000Oo(), O000000o2);
                    this.O0000OOo.O000000o(bpu2, O000000o4);
                    brl.O000000o(O00000Oo2);
                    return O000000o4;
                }
                brl.O000000o(O00000Oo2);
            } catch (Throwable th) {
                brl.O000000o(O00000Oo2);
                throw th;
            }
        }
        return null;
    }

    public final <T> List<T> O00000Oo(bpu bpu) throws DbException {
        if (!O00000Oo(bpu.O00000Oo())) {
            return null;
        }
        String bpu2 = bpu.toString();
        long O000000o2 = bpr.O00000Oo.O000000o();
        this.O0000OOo.O000000o(O000000o2);
        Object O000000o3 = this.O0000OOo.O000000o(bpu2);
        if (O000000o3 != null) {
            return (List) O000000o3;
        }
        ArrayList arrayList = new ArrayList();
        Cursor O00000Oo2 = O00000Oo(bpu2);
        if (O00000Oo2 != null) {
            while (O00000Oo2.moveToNext()) {
                try {
                    arrayList.add(bpr.O000000o(this, O00000Oo2, bpu.O00000Oo(), O000000o2));
                } catch (Throwable th) {
                    brl.O000000o(O00000Oo2);
                    throw th;
                }
            }
            this.O0000OOo.O000000o(bpu2, arrayList);
            brl.O000000o(O00000Oo2);
        }
        return arrayList;
    }

    public final <T> List<T> O000000o(Class<T> cls) throws DbException {
        return O00000Oo(bpu.O000000o((Class<?>) cls));
    }

    public static class DaoConfig {

        /* renamed from: O000000o  reason: collision with root package name */
        Context f4508O000000o;
        public String O00000Oo = "xUtils.db";
        O000000o O00000o;
        int O00000o0 = 1;
        String O00000oO;

        public DaoConfig(Context context) {
            this.f4508O000000o = context.getApplicationContext();
        }

        public final void O000000o(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.O00000Oo = str;
            }
        }
    }

    private void O00000o(Object obj) throws DbException {
        bqc bqc = bqe.O000000o(this, obj.getClass()).O00000o0;
        if (!bqc.O00000oo()) {
            O000000o(bpw.O00000Oo(this, obj));
        } else if (bqc.O000000o(obj) != null) {
            O000000o(bpw.O000000o(this, obj, new String[0]));
        } else {
            O00000oO(obj);
        }
    }

    private boolean O00000oO(Object obj) throws DbException {
        bqe O000000o2 = bqe.O000000o(this, obj.getClass());
        bqc bqc = O000000o2.O00000o0;
        if (bqc.O00000oo()) {
            O000000o(bpw.O000000o(this, obj));
            long O00000o02 = O00000o0(O000000o2.O00000Oo);
            if (O00000o02 == -1) {
                return false;
            }
            bqc.O000000o(obj, O00000o02);
            return true;
        }
        O000000o(bpw.O000000o(this, obj));
        return true;
    }

    private long O00000o0(String str) throws DbException {
        Cursor O00000Oo2 = O00000Oo("SELECT seq FROM sqlite_sequence WHERE name='" + str + "'");
        long j = -1;
        if (O00000Oo2 != null) {
            try {
                if (O00000Oo2.moveToNext()) {
                    j = O00000Oo2.getLong(0);
                }
                brl.O000000o(O00000Oo2);
            } catch (Throwable th) {
                brl.O000000o(O00000Oo2);
                throw th;
            }
        }
        return j;
    }

    private void O00000o0(Class<?> cls) throws DbException {
        if (!O00000Oo(cls)) {
            O000000o(bpw.O000000o(this, cls));
            String O00000Oo2 = bqf.O00000Oo(cls);
            if (!TextUtils.isEmpty(O00000Oo2)) {
                O000000o(O00000Oo2);
            }
        }
    }

    public final boolean O00000Oo(Class<?> cls) throws DbException {
        bqe O000000o2 = bqe.O000000o(this, cls);
        if (O000000o2.O00000oo) {
            return true;
        }
        Cursor O00000Oo2 = O00000Oo("SELECT COUNT(*) AS c FROM sqlite_master WHERE type='table' AND name='" + O000000o2.O00000Oo + "'");
        if (O00000Oo2 != null) {
            try {
                if (!O00000Oo2.moveToNext() || O00000Oo2.getInt(0) <= 0) {
                    brl.O000000o(O00000Oo2);
                } else {
                    O000000o2.O00000oo = true;
                    brl.O000000o(O00000Oo2);
                    return true;
                }
            } catch (Throwable th) {
                brl.O000000o(O00000Oo2);
                throw th;
            }
        }
        return false;
    }

    private void O00000o(String str) {
        if (this.O00000oO) {
            brm.O000000o(str);
        }
    }

    public final void O000000o() {
        if (this.O00000Oo) {
            this.O00000o.beginTransaction();
            return;
        }
        this.O00000oo.lock();
        this.O0000O0o = true;
    }

    public final void O00000Oo() {
        if (this.O00000Oo) {
            this.O00000o.setTransactionSuccessful();
        }
    }

    public final void O00000o0() {
        if (this.O00000Oo) {
            this.O00000o.endTransaction();
        }
        if (this.O0000O0o) {
            this.O00000oo.unlock();
            this.O0000O0o = false;
        }
    }

    public final void O000000o(String str) throws DbException {
        O00000o(str);
        try {
            this.O00000o.execSQL(str);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    public final Cursor O00000Oo(String str) throws DbException {
        O00000o(str);
        try {
            return this.O00000o.rawQuery(str, null);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    class O00000Oo {
        private final ConcurrentHashMap<String, Object> O00000Oo;
        private long O00000o0;

        private O00000Oo() {
            this.O00000Oo = new ConcurrentHashMap<>();
            this.O00000o0 = 0;
        }

        /* synthetic */ O00000Oo(DbUtils dbUtils, byte b) {
            this();
        }

        public final void O000000o(String str, Object obj) {
            if (str != null && obj != null) {
                this.O00000Oo.put(str, obj);
            }
        }

        public final Object O000000o(String str) {
            return this.O00000Oo.get(str);
        }

        public final void O000000o(long j) {
            if (this.O00000o0 != j) {
                this.O00000Oo.clear();
                this.O00000o0 = j;
            }
        }
    }

    public final void O000000o(bpv bpv) throws DbException {
        O00000o(bpv.f13189O000000o);
        try {
            if (bpv.O00000Oo != null) {
                this.O00000o.execSQL(bpv.f13189O000000o, bpv.O000000o());
            } else {
                this.O00000o.execSQL(bpv.f13189O000000o);
            }
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }
}
