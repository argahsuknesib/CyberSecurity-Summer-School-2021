package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.onetrack.b.l;
import com.xiaomi.onetrack.d.c;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    private static b h;
    private static BroadcastReceiver j = new c();
    /* access modifiers changed from: private */
    public a i = new a(com.xiaomi.onetrack.f.a.a());

    public static b a() {
        if (h == null) {
            a(com.xiaomi.onetrack.f.a.a());
        }
        return h;
    }

    public static void a(Context context) {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new b();
                }
            }
        }
        b(context);
        m.b();
    }

    private b() {
        b();
    }

    private static void b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(j, intentFilter);
    }

    public synchronized void a(com.xiaomi.onetrack.f.b bVar) {
        a.a(new d(this, bVar));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d1, code lost:
        return;
     */
    public void b(com.xiaomi.onetrack.f.b bVar) {
        synchronized (this.i) {
            if (!bVar.h()) {
                q.c("EventManager", "addEventToDatabase event is inValid, event:" + bVar.d());
                return;
            }
            SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("appid", bVar.b());
            contentValues.put("package", bVar.c());
            contentValues.put("event_name", bVar.d());
            contentValues.put("priority", Integer.valueOf(bVar.e()));
            contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            byte[] a2 = a(bVar.f().toString());
            if (a2.length > 204800) {
                q.b("EventManager", "Too large data, discard ***");
                return;
            }
            contentValues.put("data", a2);
            long insert = writableDatabase.insert("events", null, contentValues);
            q.a("EventManager", "DB-Thread: EventManager.addEventToDatabase , row=".concat(String.valueOf(insert)));
            if (insert != -1) {
                if (q.f6178a) {
                    q.a("EventManager", "添加后，DB 中事件个数为 " + c());
                }
                long currentTimeMillis = System.currentTimeMillis();
                if ("onetrack_active".equals(bVar.d())) {
                    z.a(currentTimeMillis);
                }
                l.a(false);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f6, code lost:
        if (r5 != null) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0107, code lost:
        if (r5 != null) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0109, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0117, code lost:
        if (r5 != null) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011a, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fb A[ExcHandler: SQLiteBlobTooBigException (e android.database.sqlite.SQLiteBlobTooBigException), Splitter:B:4:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011e  */
    public f a(int i2) {
        Cursor cursor;
        int columnIndex;
        JSONArray jSONArray;
        ArrayList arrayList;
        int i3;
        boolean z;
        boolean z2;
        int i4 = i2;
        try {
            cursor = this.i.getReadableDatabase().query("events", null, null, null, null, null, "priority ASC, _id ASC");
            try {
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("appid");
                cursor.getColumnIndex("package");
                cursor.getColumnIndex("event_name");
                columnIndex = cursor.getColumnIndex("priority");
                int columnIndex4 = cursor.getColumnIndex("data");
                int columnIndex5 = cursor.getColumnIndex("timestamp");
                jSONArray = new JSONArray();
                arrayList = new ArrayList();
                boolean z3 = true;
                i3 = 0;
                int i5 = 0;
                while (true) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    long j2 = cursor.getLong(columnIndex2);
                    cursor.getLong(columnIndex5);
                    cursor.getString(columnIndex3);
                    byte[] blob = cursor.getBlob(columnIndex4);
                    String a2 = blob != null ? a(blob) : null;
                    if (z3) {
                        int i6 = cursor.getInt(columnIndex);
                        if (i6 > i4) {
                            q.a("EventManager", "No records of priority[" + i4 + "], first record priority=" + i6);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                        z2 = false;
                    } else {
                        z2 = z3;
                    }
                    jSONArray.put(new JSONObject(a2));
                    arrayList.add(Long.valueOf(j2));
                    i3++;
                    int length = i5 + a2.length();
                    if (length >= 307200) {
                        q.a("EventManager", "reached max len: ".concat(String.valueOf(length)));
                        break;
                    }
                    i5 = length;
                    z3 = z2;
                }
            } catch (Exception e) {
                q.b("EventManager", "*** error ***", e);
            } catch (SQLiteBlobTooBigException e2) {
            }
            if (arrayList.size() > 0) {
                if (cursor.isAfterLast()) {
                    q.a("EventManager", "cursor isAfterLast");
                } else if (cursor.getInt(columnIndex) <= i4) {
                    z = false;
                    f fVar = new f(jSONArray, i3, arrayList, z);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return fVar;
                }
                z = true;
                f fVar2 = new f(jSONArray, i3, arrayList, z);
                if (cursor != null) {
                }
                return fVar2;
            }
        } catch (SQLiteBlobTooBigException e3) {
            e = e3;
            cursor = null;
            q.b("EventManager", "blob too big ***", e);
            d();
        } catch (Exception e4) {
            e = e4;
            cursor = null;
            try {
                q.a("EventManager", "", e);
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ad, code lost:
        return 0;
     */
    public int a(ArrayList<Long> arrayList) {
        synchronized (this.i) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    try {
                        SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
                        boolean z = true;
                        StringBuilder sb = new StringBuilder(((Long.toString(arrayList.get(0).longValue()).length() + 1) * arrayList.size()) + 16);
                        sb.append("_id in (");
                        sb.append(arrayList.get(0));
                        int size = arrayList.size();
                        for (int i2 = 1; i2 < size; i2++) {
                            sb.append(",");
                            sb.append(arrayList.get(i2));
                        }
                        sb.append(")");
                        int delete = writableDatabase.delete("events", sb.toString(), null);
                        q.a("EventManager", "deleted events count ".concat(String.valueOf(delete)));
                        long c = a().c();
                        if (c != 0) {
                            z = false;
                        }
                        l.a(z);
                        q.a("EventManager", "after delete DB record remains=".concat(String.valueOf(c)));
                        return delete;
                    } catch (Exception e) {
                        q.b("EventManager", "e=".concat(String.valueOf(e)));
                        return 0;
                    }
                }
            }
        }
    }

    public void b() {
        a.a(new e(this));
    }

    public long c() {
        return DatabaseUtils.queryNumEntries(this.i.getReadableDatabase(), "events");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String
     arg types: [byte[], int]
     candidates:
      com.xiaomi.onetrack.d.d.a(java.lang.String, java.lang.String):byte[]
      com.xiaomi.onetrack.d.d.a(byte[], char[]):char[]
      com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String */
    public static byte[] a(String str) {
        return com.xiaomi.onetrack.d.a.a(str.getBytes(), d.a(c.a(), true).getBytes());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String
     arg types: [byte[], int]
     candidates:
      com.xiaomi.onetrack.d.d.a(java.lang.String, java.lang.String):byte[]
      com.xiaomi.onetrack.d.d.a(byte[], char[]):char[]
      com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String */
    public static String a(byte[] bArr) {
        return new String(com.xiaomi.onetrack.d.a.b(bArr, d.a(c.a(), true).getBytes()));
    }

    private void d() {
        try {
            this.i.getWritableDatabase().delete("events", null, null);
            q.a("EventManager", "delete table events");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class a extends SQLiteOpenHelper {
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public a(Context context) {
            super(context, "onetrack", (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT,appid TEXT,package TEXT,event_name TEXT,priority INTEGER,data BLOB,timestamp INTEGER)");
        }
    }
}
