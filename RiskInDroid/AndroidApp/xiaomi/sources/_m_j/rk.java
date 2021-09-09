package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.amap.location.security.Core;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class rk {
    private static final String[] O00000o = {"id", "lat", "lng", "acc", "conf", "timestamp"};
    private static final String[] O00000oO = {"id", "originid", "frequency"};
    private static volatile rk O00000oo = null;

    /* renamed from: O000000o  reason: collision with root package name */
    rj f2428O000000o;
    public ro O00000Oo;
    ReadWriteLock O00000o0 = new ReentrantReadWriteLock();

    private rk(Context context) {
        this.f2428O000000o = new rj(context);
        this.O00000Oo = new ro(context);
    }

    private static int O000000o(SQLiteDatabase sQLiteDatabase, String str, long j) {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            String str2 = str;
            cursor = sQLiteDatabase2.query(str2, new String[]{"frequency"}, "id=?", new String[]{String.valueOf(j)}, null, null, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor == null) {
                    return -1;
                }
                try {
                    cursor.close();
                    return -1;
                } catch (Throwable unused) {
                    return -1;
                }
            } else {
                int i = cursor.getInt(0);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable unused2) {
                    }
                }
                return i;
            }
        } catch (Throwable unused3) {
        }
        throw th;
    }

    public static rk O000000o(Context context) {
        if (O00000oo == null) {
            synchronized (rk.class) {
                if (O00000oo == null) {
                    O00000oo = new rk(context);
                }
            }
        }
        return O00000oo;
    }

    public static ContentValues O000000o(ContentValues contentValues, long j, String str, long j2, int i) {
        contentValues.clear();
        contentValues.put("id", Long.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            contentValues.put("originid", str);
        } else {
            contentValues.put("originid", Long.valueOf(j2));
        }
        contentValues.put("frequency", Integer.valueOf(i));
        return contentValues;
    }

    private static ContentValues O000000o(ContentValues contentValues, rv rvVar) {
        contentValues.clear();
        contentValues.put("id", Long.valueOf(rvVar.O000000o()));
        contentValues.put("lat", Integer.valueOf(rvVar.O00000Oo()));
        contentValues.put("lng", Integer.valueOf(rvVar.O00000o0()));
        contentValues.put("acc", Short.valueOf(rvVar.O00000o()));
        contentValues.put("conf", Byte.valueOf(rvVar.O00000oO()));
        contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return contentValues;
    }

    private static HashSet<Long> O000000o(List<Long> list) {
        HashSet<Long> hashSet = new HashSet<>();
        if (list != null) {
            for (Long longValue : list) {
                hashSet.add(Long.valueOf(sa.O000000o(longValue.longValue())));
            }
        }
        return hashSet;
    }

    private static void O000000o(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        try {
            sQLiteDatabase.replace(str, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, boolean z) {
        sQLiteDatabase.insertWithOnConflict(str, null, contentValues, z ? 4 : 5);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    private static void O000000o(SQLiteDatabase sQLiteDatabase, String str, HashSet<Long> hashSet, ContentValues contentValues) {
        contentValues.clear();
        contentValues.put("lat", (Integer) 0);
        contentValues.put("lng", (Integer) 0);
        contentValues.put("acc", (Integer) 0);
        contentValues.put("conf", (Integer) -1);
        contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        Iterator<Long> it = hashSet.iterator();
        while (it.hasNext()) {
            contentValues.put("id", Long.valueOf(it.next().longValue()));
            O000000o(sQLiteDatabase, str, contentValues);
        }
    }

    private static void O000000o(SQLiteDatabase sQLiteDatabase, HashSet<Long> hashSet, HashSet<Long> hashSet2) {
        if (hashSet != null) {
            Iterator<Long> it = hashSet.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.delete("CL", "id=?", new String[]{String.valueOf(it.next().longValue())});
            }
        }
        if (hashSet2 != null) {
            Iterator<Long> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                sQLiteDatabase.delete("AP", "id=?", new String[]{String.valueOf(it2.next())});
            }
        }
    }

    static boolean O000000o(SQLiteDatabase sQLiteDatabase, String str, long j, ContentValues contentValues) {
        int O000000o2 = O000000o(sQLiteDatabase, str, j);
        if (O000000o2 < 0) {
            return false;
        }
        contentValues.clear();
        contentValues.put("frequency", Integer.valueOf(O000000o2 + 1));
        sQLiteDatabase.update(str, contentValues, "id=?", new String[]{String.valueOf(j)});
        return true;
    }

    private static HashSet<Long> O00000Oo(List<String> list) {
        HashSet<Long> hashSet = new HashSet<>();
        if (list != null) {
            for (String O000000o2 : list) {
                long O000000o3 = sa.O000000o(O000000o2);
                if (O000000o3 != -1) {
                    hashSet.add(Long.valueOf(O000000o3));
                }
            }
        }
        return hashSet;
    }

    private static void O00000Oo(SQLiteDatabase sQLiteDatabase, String str, long j, ContentValues contentValues) {
        try {
            contentValues.clear();
            contentValues.put("time", Long.valueOf(System.currentTimeMillis() / 1000));
            sQLiteDatabase.update(str, contentValues, "id=?", new String[]{String.valueOf(j)});
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: _m_j.re} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: _m_j.re} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: _m_j.re} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: _m_j.re} */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a9 A[SYNTHETIC, Splitter:B:35:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3 A[SYNTHETIC, Splitter:B:44:0x00c3] */
    public final re O000000o(String str, long j) {
        Cursor cursor;
        Cursor cursor2;
        re reVar;
        re reVar2;
        Cursor cursor3 = null;
        try {
            SQLiteDatabase readableDatabase = this.f2428O000000o.getReadableDatabase();
            cursor = readableDatabase.query("CL", O00000o, "id=?", new String[]{String.valueOf(j)}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        long j2 = cursor.getLong(5);
                        if (15552000 + j2 > System.currentTimeMillis() / 1000) {
                            reVar2 = new re(true, str, j, cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
                            if (j2 + 604800 < System.currentTimeMillis() / 1000) {
                                reVar2.O0000OOo = true;
                            }
                            cursor3 = reVar2;
                        } else {
                            readableDatabase.delete("CL", "id=?", new String[]{String.valueOf(j)});
                        }
                    }
                } catch (Throwable th) {
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = null;
            try {
                om.O00000Oo("@_18_4_@", "@_18_4_1_@" + Log.getStackTraceString(th));
                if (cursor3 != null) {
                    try {
                        cursor3.close();
                    } catch (Throwable unused2) {
                    }
                }
                cursor3 = cursor2;
                if (cursor3 == null) {
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = cursor3;
                if (cursor != null) {
                }
                throw th;
            }
        }
        return cursor3 == null ? new re(false, str, j, 0, 0, 0, -1) : cursor3;
        cursor3 = cursor;
        cursor2 = reVar;
        om.O00000Oo("@_18_4_@", "@_18_4_1_@" + Log.getStackTraceString(th));
        if (cursor3 != null) {
        }
        cursor3 = cursor2;
        if (cursor3 == null) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0078, code lost:
        if (r1 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0058, code lost:
        if (r1 != null) goto L_0x005a;
     */
    public final List<String> O000000o(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.O00000Oo.getReadableDatabase();
            String[] strArr = O00000oO;
            cursor = readableDatabase.query("CL", strArr, "frequency>=" + i + " AND time<" + ((System.currentTimeMillis() / 1000) - 86400), null, null, null, "frequency DESC", String.valueOf(i2));
            if (cursor != null && cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    arrayList.add(cursor.getString(1));
                    cursor.moveToNext();
                }
            }
        } catch (Throwable th) {
            try {
                om.O00000Oo("@_18_4_@", "@_18_4_3_@" + Log.getStackTraceString(th));
            } catch (Throwable unused) {
            }
        }
        throw th;
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ec A[SYNTHETIC, Splitter:B:50:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f1 A[Catch:{ Throwable -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fc A[SYNTHETIC, Splitter:B:59:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0101 A[Catch:{ Throwable -> 0x0107 }] */
    public final void O000000o() {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        try {
            sQLiteDatabase = this.f2428O000000o.getWritableDatabase();
        } catch (Throwable unused) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete("AP", "timestamp<?", new String[]{String.valueOf((System.currentTimeMillis() / 1000) - 7776000)});
                sQLiteDatabase.delete("CL", "timestamp<?", new String[]{String.valueOf((System.currentTimeMillis() / 1000) - 7776000)});
                cursor2 = sQLiteDatabase.query("AP", new String[]{"id"}, null, null, null, null, "timestamp DESC,frequency DESC LIMIT 200000,-1");
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst()) {
                            while (!cursor2.isAfterLast()) {
                                sQLiteDatabase.delete("AP", "id=?", new String[]{String.valueOf(cursor2.getLong(0))});
                                cursor2.moveToNext();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Throwable unused2) {
                                throw th;
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabase.endTransaction();
                        throw th;
                    }
                }
                String str = "id=?";
                Cursor query = sQLiteDatabase.query("CL", new String[]{"id"}, null, null, null, null, "timestamp DESC,frequency DESC LIMIT 200000,-1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            while (!query.isAfterLast()) {
                                sQLiteDatabase.delete("CL", str, new String[]{String.valueOf(query.getLong(0))});
                                query.moveToNext();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor2 != null) {
                        }
                        if (cursor != null) {
                        }
                        sQLiteDatabase.endTransaction();
                        throw th;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Throwable unused3) {
                        return;
                    }
                }
                if (query != null) {
                    query.close();
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable th3) {
                th = th3;
                cursor2 = null;
                cursor = null;
                if (cursor2 != null) {
                }
                if (cursor != null) {
                }
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, boolean):void
     arg types: [android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, int]
     candidates:
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, java.util.HashSet<java.lang.Long>, android.content.ContentValues):void
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, long, android.content.ContentValues):boolean
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, boolean):void */
    public final void O000000o(rg rgVar) {
        SQLiteDatabase sQLiteDatabase;
        if (rgVar.O00000Oo != null && rgVar.O00000Oo.size() > 0) {
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                sQLiteDatabase = this.f2428O000000o.getWritableDatabase();
                try {
                    sQLiteDatabase2 = this.O00000Oo.getWritableDatabase();
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                sQLiteDatabase = null;
            }
            if (sQLiteDatabase != null && sQLiteDatabase2 != null) {
                new StringBuilder();
                new StringBuilder();
                new StringBuilder();
                ContentValues contentValues = new ContentValues();
                this.O00000o0.readLock().lock();
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase2.beginTransaction();
                    for (Map.Entry<Long, rf> value : rgVar.O00000Oo.entrySet()) {
                        rf rfVar = (rf) value.getValue();
                        if (rfVar != null) {
                            if (rfVar.O00000o) {
                                if (rfVar.O0000O0o > 60) {
                                    O000000o(sQLiteDatabase, "AP", rfVar.f2424O000000o, contentValues);
                                }
                                if (rfVar.O0000OOo) {
                                    O000000o(contentValues, rfVar.f2424O000000o, null, rfVar.O00000Oo, 100000);
                                    O000000o(sQLiteDatabase2, "AP", contentValues, true);
                                }
                            } else {
                                O000000o(contentValues, rfVar.f2424O000000o, null, rfVar.O00000Oo, 0);
                                O000000o(sQLiteDatabase2, "AP", contentValues, true);
                                O000000o(sQLiteDatabase2, "AP", rfVar.f2424O000000o, contentValues);
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
                sQLiteDatabase2.endTransaction();
                this.O00000o0.readLock().unlock();
                return;
            }
            return;
        }
        return;
        this.O00000o0.readLock().unlock();
        throw th;
    }

    public final void O000000o(rx rxVar) {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f2428O000000o.getWritableDatabase();
        } catch (Throwable unused) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            ContentValues contentValues = new ContentValues();
            try {
                sQLiteDatabase.beginTransaction();
                for (int i = 0; i < rxVar.O00000Oo(); i++) {
                    rv O00000Oo2 = rxVar.O00000Oo(i);
                    if (O00000Oo2 != null) {
                        O000000o(contentValues, O00000Oo2);
                        O000000o(sQLiteDatabase, "AP", contentValues);
                    }
                }
                for (int i2 = 0; i2 < rxVar.O000000o(); i2++) {
                    rv O000000o2 = rxVar.O000000o(i2);
                    if (O000000o2 != null) {
                        O000000o(contentValues, O000000o2);
                        O000000o(sQLiteDatabase, "CL", contentValues);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            } catch (Throwable unused3) {
                return;
            }
        } else {
            return;
        }
        throw th;
    }

    public final void O000000o(rx rxVar, List<Long> list, List<String> list2) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = this.f2428O000000o.getWritableDatabase();
            try {
                sQLiteDatabase2 = this.O00000Oo.getWritableDatabase();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null && sQLiteDatabase2 != null) {
            ContentValues contentValues = new ContentValues();
            this.O00000o0.writeLock().lock();
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase2.beginTransaction();
                HashSet<Long> O000000o2 = O000000o(list);
                HashSet hashSet = (HashSet) O000000o2.clone();
                for (int i = 0; i < rxVar.O00000Oo(); i++) {
                    rv O00000Oo2 = rxVar.O00000Oo(i);
                    if (O00000Oo2 != null) {
                        O000000o2.remove(Long.valueOf(O00000Oo2.O000000o()));
                        O000000o(contentValues, O00000Oo2);
                        O000000o(sQLiteDatabase, "AP", contentValues);
                        if (O00000Oo2.O00000oO() <= 60) {
                            hashSet.remove(Long.valueOf(O00000Oo2.O000000o()));
                            O00000Oo(sQLiteDatabase2, "AP", O00000Oo2.O000000o(), contentValues);
                        }
                    }
                }
                O000000o(sQLiteDatabase, "AP", O000000o2, contentValues);
                HashSet<Long> O00000Oo3 = O00000Oo(list2);
                HashSet hashSet2 = (HashSet) O00000Oo3.clone();
                for (int i2 = 0; i2 < rxVar.O000000o(); i2++) {
                    rv O000000o3 = rxVar.O000000o(i2);
                    if (O000000o3 != null) {
                        O00000Oo3.remove(Long.valueOf(O000000o3.O000000o()));
                        O000000o(contentValues, O000000o3);
                        O000000o(sQLiteDatabase, "CL", contentValues);
                        if (O000000o3.O00000oO() <= 60) {
                            hashSet2.remove(Long.valueOf(O000000o3.O000000o()));
                            O00000Oo(sQLiteDatabase2, "CL", O000000o3.O000000o(), contentValues);
                        }
                    }
                }
                O000000o(sQLiteDatabase, "CL", O00000Oo3, contentValues);
                O000000o(sQLiteDatabase2, hashSet2, hashSet);
                O000000o();
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase2.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
            sQLiteDatabase2.endTransaction();
            this.O00000o0.writeLock().unlock();
            return;
        }
        return;
        this.O00000o0.writeLock().unlock();
        throw th;
    }

    public final void O000000o(String str, rg rgVar) {
        rg rgVar2 = rgVar;
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.f2428O000000o.getReadableDatabase();
            Cursor query = readableDatabase.query("AP", O00000o, "id IN (" + str + ")", null, null, null, null);
            if (query != null && query.moveToFirst()) {
                while (!query.isAfterLast()) {
                    long j = query.getLong(0);
                    long j2 = query.getLong(5);
                    if (7776000 + j2 < System.currentTimeMillis() / 1000) {
                        readableDatabase.delete("AP", "id=?", new String[]{String.valueOf(j)});
                    } else {
                        int i = query.getInt(1);
                        int i2 = query.getInt(2);
                        int i3 = query.getInt(3);
                        int i4 = query.getInt(4);
                        rf rfVar = rgVar2.O00000Oo.get(Long.valueOf(j));
                        if (rfVar != null) {
                            rfVar.O00000o = true;
                            rfVar.O0000O0o = i4;
                            rfVar.O00000oO = i;
                            rfVar.O00000oo = i2;
                            if (i4 > 60 && i3 > 0 && i3 < 2000) {
                                rgVar2.O00000o0++;
                                StringBuilder sb = rgVar2.O00000o;
                                sb.append(rfVar.O00000Oo);
                                sb.append(";");
                                StringBuilder sb2 = rgVar2.O00000oO;
                                sb2.append(i2);
                                sb2.append(",");
                                sb2.append(i);
                                sb2.append(",");
                                sb2.append(i3);
                                sb2.append(",");
                                sb2.append(rfVar.O00000o0);
                                sb2.append(";");
                            }
                            if (j2 + 604800 < System.currentTimeMillis() / 1000) {
                                rfVar.O0000OOo = true;
                            }
                        }
                    }
                    query.moveToNext();
                }
                if (rgVar2.O00000oO.length() > 0) {
                    rgVar2.O00000oO.deleteCharAt(rgVar2.O00000oO.length() - 1);
                }
            }
            if (query != null) {
                try {
                    query.close();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            } else {
                return;
            }
        } catch (Throwable unused2) {
            return;
        }
        throw th;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public void O000000o(String str, ContentValues contentValues, long j) {
        contentValues.clear();
        contentValues.put("conf", (Integer) 0);
        this.f2428O000000o.getWritableDatabase().update(str, contentValues, "id=?", new String[]{String.valueOf(j)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007c, code lost:
        if (r1 == null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005c, code lost:
        if (r1 != null) goto L_0x005e;
     */
    public final List<Long> O00000Oo(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.O00000Oo.getReadableDatabase();
            String[] strArr = O00000oO;
            cursor = readableDatabase.query("AP", strArr, "frequency>=" + i + " AND time<" + ((System.currentTimeMillis() / 1000) - 86400), null, null, null, "frequency DESC", String.valueOf(i2));
            if (cursor != null && cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    arrayList.add(Long.valueOf(cursor.getLong(1)));
                    cursor.moveToNext();
                }
            }
        } catch (Throwable th) {
            try {
                om.O00000Oo("@_18_4_@", "@_18_4_4_@" + Log.getStackTraceString(th));
            } catch (Throwable unused) {
            }
        }
        throw th;
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2 A[SYNTHETIC, Splitter:B:43:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b7 A[Catch:{ Throwable -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c3 A[SYNTHETIC, Splitter:B:52:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c8 A[Catch:{ Throwable -> 0x00ce }] */
    public final void O00000Oo() {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        try {
            sQLiteDatabase = this.O00000Oo.getWritableDatabase();
        } catch (Throwable unused) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                cursor = sQLiteDatabase.query("AP", new String[]{"id"}, null, null, null, null, "frequency DESC LIMIT 10000,-1");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            while (!cursor.isAfterLast()) {
                                sQLiteDatabase.delete("AP", "id=?", new String[]{String.valueOf(cursor.getLong(0))});
                                cursor.moveToNext();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        if (cursor3 != null) {
                        }
                        sQLiteDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor query = sQLiteDatabase.query("CL", new String[]{"id"}, null, null, null, null, "frequency DESC LIMIT 10000,-1");
                if (query != null && query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        sQLiteDatabase.delete("CL", "id=?", new String[]{String.valueOf(query.getLong(0))});
                        query.moveToNext();
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                if (query != null) {
                    query.close();
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable unused3) {
                        throw th;
                    }
                }
                if (cursor3 != null) {
                    cursor3.close();
                }
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, boolean):void
     arg types: [android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, int]
     candidates:
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, java.util.HashSet<java.lang.Long>, android.content.ContentValues):void
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, long, android.content.ContentValues):boolean
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, boolean):void */
    public final void O000000o(rg rgVar, op opVar) {
        SQLiteDatabase sQLiteDatabase;
        op opVar2 = opVar;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = this.f2428O000000o.getWritableDatabase();
            try {
                sQLiteDatabase2 = this.O00000Oo.getWritableDatabase();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null && sQLiteDatabase2 != null) {
            new StringBuilder();
            ContentValues contentValues = new ContentValues();
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase2.beginTransaction();
                for (Map.Entry<Long, rf> value : rgVar.O00000Oo.entrySet()) {
                    rf rfVar = (rf) value.getValue();
                    if (rfVar != null && rfVar.O00000o && rfVar.O0000O0o > 60) {
                        if (Core.gd(rfVar.O00000oO, rfVar.O00000oo, opVar2.O00000Oo, opVar2.f2369O000000o) > 100.0d) {
                            O000000o("AP", contentValues, rfVar.f2424O000000o);
                            O000000o(contentValues, rfVar.f2424O000000o, null, rfVar.O00000Oo, 100000);
                            O000000o(sQLiteDatabase2, "AP", contentValues, false);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase2.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                    sQLiteDatabase2.endTransaction();
                    return;
                } catch (Throwable unused3) {
                    return;
                }
            } catch (Throwable unused4) {
                return;
            }
        } else {
            return;
        }
        throw th;
    }
}
