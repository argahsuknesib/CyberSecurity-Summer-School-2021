package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class dkz {
    /* access modifiers changed from: package-private */
    public static dlm O00000o = dlv.O00000o0();
    private static dkz O0000Oo = null;
    private static Context O0000Oo0 = null;

    /* renamed from: O000000o  reason: collision with root package name */
    dlp f14757O000000o = null;
    volatile int O00000Oo = 0;
    dln O00000o0 = null;
    private dli O00000oO = null;
    private dli O00000oo = null;
    private String O0000O0o = "";
    private String O0000OOo = "";
    private int O0000OoO = 0;
    private ConcurrentHashMap<dkk, String> O0000Ooo = null;
    private HashMap<String, String> O0000o0 = new HashMap<>();
    private boolean O0000o00 = false;

    private dkz(Context context) {
        try {
            this.f14757O000000o = new dlp();
            O0000Oo0 = context.getApplicationContext();
            this.O0000Ooo = new ConcurrentHashMap<>();
            this.O0000O0o = dlv.O0000o0o(context);
            this.O0000OOo = "pri_" + dlv.O0000o0o(context);
            this.O00000oO = new dli(O0000Oo0, this.O0000O0o);
            this.O00000oo = new dli(O0000Oo0, this.O0000OOo);
            O000000o(true);
            O000000o(false);
            O00000o0();
            O00000Oo(O0000Oo0);
            O0000O0o();
            O0000OOo();
        } catch (Throwable th) {
            O00000o.O00000Oo(th);
        }
    }

    public static dkz O000000o() {
        return O0000Oo;
    }

    public static dkz O000000o(Context context) {
        if (O0000Oo == null) {
            synchronized (dkz.class) {
                if (O0000Oo == null) {
                    O0000Oo = new dkz(context);
                }
            }
        }
        return O0000Oo;
    }

    private static String O000000o(List<dlj> list) {
        StringBuilder sb = new StringBuilder(list.size() * 3);
        sb.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (dlj dlj : list) {
            sb.append(dlj.f14767O000000o);
            if (i != size - 1) {
                sb.append(",");
            }
            i++;
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        return;
     */
    private synchronized void O000000o(int i, boolean z) {
        try {
            if (this.O00000Oo > 0 && i > 0) {
                if (!dke.O000000o()) {
                    if (dkd.O00000Oo()) {
                        dlm dlm = O00000o;
                        dlm.O000000o("Load " + this.O00000Oo + " unsent events");
                    }
                    ArrayList arrayList = new ArrayList(i);
                    O00000Oo(arrayList, i, z);
                    if (arrayList.size() > 0) {
                        if (dkd.O00000Oo()) {
                            dlm dlm2 = O00000o;
                            dlm2.O000000o("Peek " + arrayList.size() + " unsent events.");
                        }
                        O000000o(arrayList, 2, z);
                        dmi.O00000Oo(O0000Oo0).O000000o(arrayList, new dlg(this, arrayList, z));
                    }
                }
            }
        } catch (Throwable th) {
            O00000o.O00000Oo(th);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d6 A[SYNTHETIC, Splitter:B:45:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e7 A[SYNTHETIC, Splitter:B:57:0x00e7] */
    public synchronized void O000000o(List<dlj> list, boolean z) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (list.size() != 0) {
            if (dkd.O00000Oo()) {
                O00000o.O000000o("Delete " + list.size() + " events, important:" + z);
            }
            StringBuilder sb = new StringBuilder(list.size() * 3);
            sb.append("event_id in (");
            int i = 0;
            int size = list.size();
            for (dlj dlj : list) {
                sb.append(dlj.f14767O000000o);
                if (i != size - 1) {
                    sb.append(",");
                }
                i++;
            }
            sb.append(")");
            try {
                sQLiteDatabase = O00000Oo(z);
                try {
                    sQLiteDatabase.beginTransaction();
                    int delete = sQLiteDatabase.delete("events", sb.toString(), null);
                    if (dkd.O00000Oo()) {
                        O00000o.O000000o("delete " + size + " event " + sb.toString() + ", success delete:" + delete);
                    }
                    this.O00000Oo -= delete;
                    sQLiteDatabase.setTransactionSuccessful();
                    O00000o0();
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable th2) {
                            O00000o.O00000Oo(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        O00000o.O00000Oo(th);
                        if (sQLiteDatabase != null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                Throwable th6 = th5;
                sQLiteDatabase = null;
                th = th6;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th7) {
                        O00000o.O00000Oo(th7);
                    }
                }
                throw th;
            }
        }
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
    private void O000000o(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase O00000Oo2 = O00000Oo(z);
            O00000Oo2.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 1);
            int update = O00000Oo2.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (dkd.O00000Oo()) {
                dlm dlm = O00000o;
                dlm.O000000o("update " + update + " unsent events.");
            }
            O00000Oo2.setTransactionSuccessful();
            if (O00000Oo2 != null) {
                O00000Oo2.endTransaction();
                return;
            }
            return;
        } catch (Throwable th) {
            O00000o.O00000Oo(th);
            return;
        }
        throw th;
    }

    private SQLiteDatabase O00000Oo(boolean z) {
        return (!z ? this.O00000oO : this.O00000oo).getWritableDatabase();
    }

    private int O00000o() {
        return (int) DatabaseUtils.queryNumEntries(this.O00000oO.getReadableDatabase(), "events");
    }

    private void O00000o0() {
        this.O00000Oo = O00000o() + O00000oO();
    }

    private int O00000oO() {
        return (int) DatabaseUtils.queryNumEntries(this.O00000oo.getReadableDatabase(), "events");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00de A[SYNTHETIC, Splitter:B:41:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f2 A[Catch:{ Throwable -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123 A[SYNTHETIC, Splitter:B:52:0x0123] */
    public void O00000oo() {
        dlm dlm;
        if (!this.O0000o00) {
            synchronized (this.O0000Ooo) {
                if (this.O0000Ooo.size() != 0) {
                    this.O0000o00 = true;
                    if (dkd.O00000Oo()) {
                        dlm dlm2 = O00000o;
                        dlm2.O000000o("insert " + this.O0000Ooo.size() + " events ,numEventsCachedInMemory:" + dkd.O0000o0 + ",numStoredEvents:" + this.O00000Oo);
                    }
                    SQLiteDatabase sQLiteDatabase = null;
                    try {
                        SQLiteDatabase sQLiteDatabase2 = this.O00000oO.getWritableDatabase();
                        try {
                            sQLiteDatabase2.beginTransaction();
                            Iterator<Map.Entry<dkk, String>> it = this.O0000Ooo.entrySet().iterator();
                            while (it.hasNext()) {
                                dkk dkk = (dkk) it.next().getKey();
                                ContentValues contentValues = new ContentValues();
                                String O00000oo2 = dkk.O00000oo();
                                if (dkd.O00000Oo()) {
                                    O00000o.O000000o("insert content:".concat(String.valueOf(O00000oo2)));
                                }
                                contentValues.put("content", dmb.O00000Oo(O00000oo2));
                                contentValues.put("send_count", "0");
                                contentValues.put("status", Integer.toString(1));
                                contentValues.put("timestamp", Long.valueOf(dkk.O00000o0()));
                                sQLiteDatabase2.insert("events", null, contentValues);
                                it.remove();
                            }
                            sQLiteDatabase2.setTransactionSuccessful();
                            if (sQLiteDatabase2 != null) {
                                try {
                                    sQLiteDatabase2.endTransaction();
                                    O00000o0();
                                } catch (Throwable th) {
                                    th = th;
                                    dlm = O00000o;
                                    dlm.O00000Oo(th);
                                    this.O0000o00 = false;
                                    if (dkd.O00000Oo()) {
                                    }
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (sQLiteDatabase2 != null) {
                                try {
                                    sQLiteDatabase2.endTransaction();
                                    O00000o0();
                                } catch (Throwable th3) {
                                    O00000o.O00000Oo(th3);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        O00000o.O00000Oo(th);
                        if (sQLiteDatabase != null) {
                        }
                        this.O0000o00 = false;
                        if (dkd.O00000Oo()) {
                        }
                        return;
                    }
                    this.O0000o00 = false;
                    if (dkd.O00000Oo()) {
                        dlm dlm3 = O00000o;
                        dlm3.O000000o("after insert, cacheEventsInMemory.size():" + this.O0000Ooo.size() + ",numEventsCachedInMemory:" + dkd.O0000o0 + ",numStoredEvents:" + this.O00000Oo);
                    }
                }
            }
        }
    }

    private void O0000O0o() {
        Cursor cursor = null;
        try {
            Cursor query = this.O00000oO.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                int i = query.getInt(0);
                String string = query.getString(1);
                String string2 = query.getString(2);
                int i2 = query.getInt(3);
                dmf dmf = new dmf(i);
                dmf.f14783O000000o = i;
                dmf.O00000Oo = new JSONObject(string);
                dmf.O00000o0 = string2;
                dmf.O00000o = i2;
                dkd.O000000o(O0000Oo0, dmf);
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private void O0000OOo() {
        Cursor cursor = null;
        try {
            Cursor query = this.O00000oO.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                this.O0000o0.put(query.getString(0), query.getString(1));
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        this.f14757O000000o.O000000o(new dlh(this, i));
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(dkk dkk, dmh dmh, boolean z, boolean z2) {
        dlp dlp = this.f14757O000000o;
        if (dlp != null) {
            dlp.O000000o(new dld(this, dkk, dmh, z, z2));
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(dmf dmf) {
        if (dmf != null) {
            this.f14757O000000o.O000000o(new dle(this, dmf));
        }
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
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01fe A[SYNTHETIC, Splitter:B:103:0x01fe] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b8 A[Catch:{ Throwable -> 0x01d2, all -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0125 A[Catch:{ Throwable -> 0x01d2, all -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0138 A[Catch:{ Throwable -> 0x01d2, all -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e4 A[SYNTHETIC, Splitter:B:90:0x01e4] */
    public final synchronized dln O00000Oo(Context context) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        dlm dlm;
        String str;
        String str2;
        boolean z;
        String str3;
        if (this.O00000o0 != null) {
            return this.O00000o0;
        }
        try {
            this.O00000oO.getWritableDatabase().beginTransaction();
            if (dkd.O00000Oo()) {
                try {
                    O00000o.O000000o("try to load user info from db.");
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                    }
                    this.O00000oO.getWritableDatabase().endTransaction();
                    throw th;
                }
            }
            cursor = this.O00000oO.getReadableDatabase().query("user", null, null, null, null, null, null, null);
            try {
                boolean z2 = true;
                if (cursor.moveToNext()) {
                    String string = cursor.getString(0);
                    String O000000o2 = dmb.O000000o(string);
                    int i = cursor.getInt(1);
                    String string2 = cursor.getString(2);
                    long j = cursor.getLong(3);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    int i2 = (i == 1 || dlv.O000000o(j * 1000).equals(dlv.O000000o(currentTimeMillis * 1000))) ? i : 1;
                    if (!string2.equals(dlv.O0000o00(context))) {
                        i2 |= 2;
                    }
                    String[] split = O000000o2.split(",");
                    if (split == null || split.length <= 0) {
                        O000000o2 = dlv.O00000Oo(context);
                        str2 = O000000o2;
                    } else {
                        str2 = split[0];
                        if (str2 != null) {
                            if (str2.length() < 11) {
                            }
                            z = false;
                            if (split != null || split.length < 2) {
                                str3 = dlv.O00000o0(context);
                                if (str3 != null && str3.length() > 0) {
                                    O000000o2 = str2 + "," + str3;
                                    z = true;
                                }
                            } else {
                                str3 = split[1];
                                O000000o2 = str2 + "," + str3;
                            }
                            this.O00000o0 = new dln(str2, str3, i2);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("uid", dmb.O00000Oo(O000000o2));
                            contentValues.put("user_type", Integer.valueOf(i2));
                            contentValues.put("app_ver", dlv.O0000o00(context));
                            contentValues.put("ts", Long.valueOf(currentTimeMillis));
                            if (z) {
                                this.O00000oO.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{string});
                            }
                            if (i2 != i) {
                                this.O00000oO.getWritableDatabase().replace("user", null, contentValues);
                            }
                        }
                        String O000000o3 = dmb.O000000o(context);
                        if (O000000o3 != null && O000000o3.length() > 10) {
                            str2 = O000000o3;
                        }
                        z = false;
                        if (split != null) {
                        }
                        str3 = dlv.O00000o0(context);
                        O000000o2 = str2 + "," + str3;
                        z = true;
                        this.O00000o0 = new dln(str2, str3, i2);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", dmb.O00000Oo(O000000o2));
                        contentValues2.put("user_type", Integer.valueOf(i2));
                        contentValues2.put("app_ver", dlv.O0000o00(context));
                        contentValues2.put("ts", Long.valueOf(currentTimeMillis));
                        if (z) {
                        }
                        if (i2 != i) {
                        }
                    }
                    z = true;
                    if (split != null) {
                    }
                    str3 = dlv.O00000o0(context);
                    O000000o2 = str2 + "," + str3;
                    z = true;
                    this.O00000o0 = new dln(str2, str3, i2);
                    ContentValues contentValues22 = new ContentValues();
                    contentValues22.put("uid", dmb.O00000Oo(O000000o2));
                    contentValues22.put("user_type", Integer.valueOf(i2));
                    contentValues22.put("app_ver", dlv.O0000o00(context));
                    contentValues22.put("ts", Long.valueOf(currentTimeMillis));
                    if (z) {
                    }
                    if (i2 != i) {
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    String O00000Oo2 = dlv.O00000Oo(context);
                    String O00000o02 = dlv.O00000o0(context);
                    if (O00000o02 == null || O00000o02.length() <= 0) {
                        str = O00000Oo2;
                    } else {
                        str = O00000Oo2 + "," + O00000o02;
                    }
                    String O0000o002 = dlv.O0000o00(context);
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("uid", dmb.O00000Oo(str));
                    contentValues3.put("user_type", (Integer) 0);
                    contentValues3.put("app_ver", O0000o002);
                    contentValues3.put("ts", Long.valueOf(System.currentTimeMillis() / 1000));
                    this.O00000oO.getWritableDatabase().insert("user", null, contentValues3);
                    this.O00000o0 = new dln(O00000Oo2, O00000o02, 0);
                }
                this.O00000oO.getWritableDatabase().setTransactionSuccessful();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th3) {
                        th = th3;
                        dlm = O00000o;
                        dlm.O00000Oo(th);
                        return this.O00000o0;
                    }
                }
                this.O00000oO.getWritableDatabase().endTransaction();
            } catch (Throwable th4) {
                th = th4;
                th = th;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th5) {
                        O00000o.O00000Oo(th5);
                        throw th;
                    }
                }
                this.O00000oO.getWritableDatabase().endTransaction();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
            if (cursor != null) {
            }
            this.O00000oO.getWritableDatabase().endTransaction();
            throw th;
        }
        return this.O00000o0;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bb A[SYNTHETIC, Splitter:B:47:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cc A[SYNTHETIC, Splitter:B:59:0x00cc] */
    public synchronized void O000000o(List<dlj> list, int i, boolean z) {
        String str;
        if (list.size() != 0) {
            int O0000O0o2 = !z ? dkd.O0000O0o() : dkd.O00000oO();
            ? r1 = 0;
            try {
                SQLiteDatabase sQLiteDatabase = O00000Oo(z);
                if (i == 2) {
                    try {
                        str = "update events set status=" + i + ", send_count=send_count+1  where " + O000000o(list);
                    } catch (Throwable th) {
                        th = th;
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                } else {
                    str = "update events set status=" + i + " where " + O000000o(list);
                    if (this.O0000OoO % 3 == 0) {
                        r1 = "delete from events where send_count>".concat(String.valueOf(O0000O0o2));
                    }
                    this.O0000OoO++;
                    r1 = r1;
                }
                if (dkd.O00000Oo()) {
                    O00000o.O000000o("update sql:".concat(String.valueOf(str)));
                }
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL(str);
                if (r1 != 0) {
                    O00000o.O000000o("update for delete sql:".concat(String.valueOf(r1)));
                    sQLiteDatabase.execSQL(r1);
                    O00000o0();
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th2) {
                        O00000o.O00000Oo(th2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                O00000o.O00000Oo(th);
                if (r1 != 0) {
                }
            }
        }
    }

    private void O00000Oo(List<dlj> list, int i, boolean z) {
        dli dli;
        Cursor cursor = null;
        if (!z) {
            try {
                dli = this.O00000oO;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            dli = this.O00000oo;
        }
        Cursor query = dli.getReadableDatabase().query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
        while (query.moveToNext()) {
            long j = query.getLong(0);
            String string = query.getString(1);
            if (!dkd.O0000O0o) {
                string = dmb.O000000o(string);
            }
            String str = string;
            int i2 = query.getInt(2);
            int i3 = query.getInt(3);
            dlj dlj = new dlj(j, str, i2, i3);
            if (dkd.O00000Oo()) {
                dlm dlm = O00000o;
                dlm.O000000o("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + query.getLong(4));
            }
            list.add(dlj);
        }
        if (query != null) {
            query.close();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x017b, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011d A[SYNTHETIC, Splitter:B:52:0x011d] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012b A[Catch:{ Throwable -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0154 A[SYNTHETIC, Splitter:B:66:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016f A[SYNTHETIC, Splitter:B:71:0x016f] */
    public synchronized void O00000Oo(dkk dkk, dmh dmh, boolean z, boolean z2) {
        long j;
        dlm dlm;
        if (dkd.O0000Oo() > 0) {
            if (dkd.O0000o0 > 0 && !z) {
                if (!z2) {
                    if (dkd.O0000o0 > 0) {
                        if (dkd.O00000Oo()) {
                            O00000o.O000000o("cacheEventsInMemory.size():" + this.O0000Ooo.size() + ",numEventsCachedInMemory:" + dkd.O0000o0 + ",numStoredEvents:" + this.O00000Oo);
                            dlm dlm2 = O00000o;
                            StringBuilder sb = new StringBuilder("cache event:");
                            sb.append(dkk.O00000oo());
                            dlm2.O000000o(sb.toString());
                        }
                        this.O0000Ooo.put(dkk, "");
                        if (this.O0000Ooo.size() >= dkd.O0000o0) {
                            O00000oo();
                        }
                        if (dmh != null) {
                            if (this.O0000Ooo.size() > 0) {
                                O00000oo();
                            }
                            dmh.O000000o();
                        }
                    }
                }
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = O00000Oo(z);
                try {
                    sQLiteDatabase2.beginTransaction();
                    if (!z && this.O00000Oo > dkd.O0000Oo()) {
                        O00000o.O00000Oo("Too many events stored in db.");
                        this.O00000Oo -= this.O00000oO.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
                    }
                    ContentValues contentValues = new ContentValues();
                    String O00000oo2 = dkk.O00000oo();
                    if (dkd.O00000Oo()) {
                        O00000o.O000000o("insert 1 event, content:".concat(String.valueOf(O00000oo2)));
                    }
                    contentValues.put("content", dmb.O00000Oo(O00000oo2));
                    contentValues.put("send_count", "0");
                    contentValues.put("status", Integer.toString(1));
                    contentValues.put("timestamp", Long.valueOf(dkk.O00000o0()));
                    j = sQLiteDatabase2.insert("events", null, contentValues);
                    sQLiteDatabase2.setTransactionSuccessful();
                    if (sQLiteDatabase2 != null) {
                        try {
                            sQLiteDatabase2.endTransaction();
                        } catch (Throwable th) {
                            th = th;
                            dlm = O00000o;
                            dlm.O00000Oo(th);
                            if (j > 0) {
                            }
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteDatabase2 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j = -1;
                O00000o.O00000Oo(th);
                if (sQLiteDatabase != null) {
                }
                if (j > 0) {
                }
                return;
            }
            if (j > 0) {
                this.O00000Oo++;
                if (dkd.O00000Oo()) {
                    O00000o.O0000O0o("directStoreEvent insert event to db, event:" + dkk.O00000oo());
                }
                if (dmh != null) {
                    dmh.O000000o();
                }
            } else {
                O00000o.O00000o("Failed to store event:" + dkk.O00000oo());
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:33|34|(0)|51|52|54|55) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0100 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00df A[SYNTHETIC, Splitter:B:39:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f1 A[SYNTHETIC, Splitter:B:49:0x00f1] */
    public synchronized void O00000Oo(dmf dmf) {
        boolean z;
        long j;
        Cursor cursor = null;
        try {
            String jSONObject = dmf.O00000Oo.toString();
            String O000000o2 = dlv.O000000o(jSONObject);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", dmf.O00000Oo.toString());
            contentValues.put("md5sum", O000000o2);
            dmf.O00000o0 = O000000o2;
            contentValues.put("version", Integer.valueOf(dmf.O00000o));
            Cursor cursor2 = this.O00000oO.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (true) {
                try {
                    if (cursor2.moveToNext()) {
                        if (cursor2.getInt(0) == dmf.f14783O000000o) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    this.O00000oO.getWritableDatabase().endTransaction();
                    throw th;
                }
            }
            this.O00000oO.getWritableDatabase().beginTransaction();
            if (true == z) {
                j = (long) this.O00000oO.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(dmf.f14783O000000o)});
            } else {
                contentValues.put("type", Integer.valueOf(dmf.f14783O000000o));
                j = this.O00000oO.getWritableDatabase().insert("config", null, contentValues);
            }
            if (j == -1) {
                O00000o.O00000oO("Failed to store cfg:".concat(String.valueOf(jSONObject)));
            } else {
                O00000o.O0000O0o("Sucessed to store cfg:".concat(String.valueOf(jSONObject)));
            }
            this.O00000oO.getWritableDatabase().setTransactionSuccessful();
            if (cursor2 != null) {
                cursor2.close();
            }
            try {
                this.O00000oO.getWritableDatabase().endTransaction();
                return;
            } catch (Exception unused) {
                return;
            }
        } catch (Throwable th2) {
            th = th2;
            O00000o.O00000Oo(th);
            if (cursor != null) {
            }
            this.O00000oO.getWritableDatabase().endTransaction();
            return;
        }
    }

    static /* synthetic */ void O000000o(dkz dkz, int i, boolean z) {
        if (i == -1) {
            i = !z ? dkz.O00000o() : dkz.O00000oO();
        }
        if (i > 0) {
            int O0000Ooo2 = dkd.O0000Ooo() * 60 * dkd.O0000OOo();
            if (i > O0000Ooo2 && O0000Ooo2 > 0) {
                i = O0000Ooo2;
            }
            int O0000Oo02 = dkd.O0000Oo0();
            int i2 = i / O0000Oo02;
            int i3 = i % O0000Oo02;
            if (dkd.O00000Oo()) {
                dlm dlm = O00000o;
                dlm.O000000o("sentStoreEventsByDb sendNumbers=" + i + ",important=" + z + ",maxSendNumPerFor1Period=" + O0000Ooo2 + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                dkz.O000000o(O0000Oo02, z);
            }
            if (i3 > 0) {
                dkz.O000000o(i3, z);
            }
        }
    }
}
