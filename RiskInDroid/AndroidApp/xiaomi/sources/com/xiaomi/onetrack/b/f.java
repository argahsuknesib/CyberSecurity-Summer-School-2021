package com.xiaomi.onetrack.b;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.h.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
    /* access modifiers changed from: private */
    public e b;
    private ConcurrentHashMap<String, j> c;
    private AtomicBoolean d;

    /* synthetic */ f(g gVar) {
        this();
    }

    private f() {
        this.c = new ConcurrentHashMap<>();
        this.d = new AtomicBoolean(false);
        this.b = new e(com.xiaomi.onetrack.f.a.a());
    }

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final f f6120a = new f(null);

        private a() {
        }
    }

    public static f a() {
        return a.f6120a;
    }

    public void a(ArrayList<j> arrayList) {
        com.xiaomi.onetrack.c.a.a(new g(this, arrayList));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e A[SYNTHETIC, Splitter:B:34:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4 A[SYNTHETIC, Splitter:B:37:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    public void b(ArrayList<j> arrayList) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = this.b.getWritableDatabase();
            try {
                sQLiteDatabase2.beginTransaction();
                Iterator<j> it = arrayList.iterator();
                while (it.hasNext()) {
                    j next = it.next();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", next.f6124a);
                    contentValues.put("timestamp", Long.valueOf(next.b));
                    if (next.d != null) {
                        contentValues.put("cloud_data", next.d.toString());
                    }
                    contentValues.put("data_hash", next.c);
                    if (DatabaseUtils.queryNumEntries(sQLiteDatabase2, "events_cloud", "app_id=?", new String[]{next.f6124a}) > 0) {
                        sQLiteDatabase2.update("events_cloud", contentValues, "app_id=?", new String[]{next.f6124a});
                    } else {
                        sQLiteDatabase2.insert("events_cloud", null, contentValues);
                    }
                    this.d.set(true);
                }
                sQLiteDatabase2.setTransactionSuccessful();
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e) {
                        q.b("ConfigDbManager", "Exception while endTransaction:".concat(String.valueOf(e)));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                sQLiteDatabase = sQLiteDatabase2;
                try {
                    q.b("ConfigDbManager", "updateToDb error: ", e);
                    if (sQLiteDatabase == null) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase2 = sQLiteDatabase;
                    Throwable th2 = th;
                    if (sQLiteDatabase2 != null) {
                        try {
                            sQLiteDatabase2.endTransaction();
                        } catch (Exception e3) {
                            q.b("ConfigDbManager", "Exception while endTransaction:".concat(String.valueOf(e3)));
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                Throwable th22 = th;
                if (sQLiteDatabase2 != null) {
                }
                throw th22;
            }
        } catch (Exception e4) {
            e = e4;
            q.b("ConfigDbManager", "updateToDb error: ", e);
            if (sQLiteDatabase == null) {
            }
        }
    }

    public void a(String str) {
        FutureTask futureTask = new FutureTask(new h(this, str), null);
        com.xiaomi.onetrack.c.a.a(futureTask);
        try {
            futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(String str) {
        FutureTask futureTask = new FutureTask(new i(this, str));
        com.xiaomi.onetrack.c.a.a(futureTask);
        try {
            j jVar = (j) futureTask.get();
            if (jVar != null) {
                this.c.put(str, jVar);
                this.d.set(false);
                if (q.f6178a) {
                    q.a("ConfigDbManager", "getConfig   appId :" + str + " config: " + jVar.toString());
                }
            }
        } catch (Exception e) {
            q.b("ConfigDbManager", "getConfig error: " + e.toString());
        }
    }

    public boolean a(String str, String str2, String str3, boolean z) {
        try {
            JSONObject b2 = b(str, str2);
            if (b2 != null) {
                return b2.getBoolean(str3);
            }
            q.a("ConfigDbManager", "config not available, use default value");
            return z;
        } catch (Exception e) {
            q.b("ConfigDbManager", "getBoolean: " + e.toString());
            return z;
        }
    }

    public String a(String str, String str2, String str3, String str4) {
        try {
            JSONObject b2 = b(str, str2);
            if (b2 != null) {
                return b2.getString(str3);
            }
            q.a("ConfigDbManager", "config not available, use default value");
            return str4;
        } catch (Exception e) {
            q.b("ConfigDbManager", "getString: " + e.toString());
            return str4;
        }
    }

    public int a(String str, String str2, String str3, int i) {
        try {
            JSONObject b2 = b(str, str2);
            if (b2 != null) {
                return b2.getInt(str3);
            }
            q.a("ConfigDbManager", "config not available, use default value");
            return i;
        } catch (Exception e) {
            q.b("ConfigDbManager", "getInt: " + e.toString());
            return i;
        }
    }

    public long a(String str, String str2, String str3, long j) {
        try {
            JSONObject b2 = b(str, str2);
            if (b2 != null) {
                return b2.getLong(str3);
            }
            q.a("ConfigDbManager", "config not available, use default value");
            return j;
        } catch (Exception e) {
            q.b("ConfigDbManager", "getLong: " + e.toString());
            return j;
        }
    }

    public double a(String str, String str2, String str3, double d2) {
        try {
            JSONObject b2 = b(str, str2);
            if (b2 != null) {
                return b2.getDouble(str3);
            }
            q.a("ConfigDbManager", "config not available, use default value");
            return d2;
        } catch (Exception e) {
            q.b("ConfigDbManager", "getDouble: " + e.toString());
            return d2;
        }
    }

    private JSONObject b(String str, String str2) {
        JSONArray optJSONArray;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (this.c.get(str) == null || this.d.get()) {
                    b(str);
                }
                j jVar = this.c.get(str);
                if (!(jVar == null || jVar.d == null || (optJSONArray = jVar.d.optJSONArray("events")) == null)) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        if (TextUtils.equals(str2, jSONObject.optString("event"))) {
                            if (q.f6178a) {
                                StringBuilder sb = new StringBuilder("getEventConfig:");
                                sb.append(jSONObject != null ? jSONObject.toString() : "");
                                q.a("ConfigDbManager", sb.toString());
                            }
                            return jSONObject;
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("ConfigDbManager", "getEventConfig error: " + e.toString());
            }
        }
        return null;
    }

    public String c(String str) {
        j d2 = d(str);
        return d2 != null ? d2.c : "";
    }

    public boolean a(String str, String str2) {
        try {
            j d2 = d(str);
            if (d2 == null || d2.d == null || !d2.d.has(str2)) {
                return false;
            }
            return d2.d.optBoolean(str2);
        } catch (Exception e) {
            q.b("ConfigDbManager", "getAppLevelBoolean" + e.toString());
            return false;
        }
    }

    public j d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.c.get(str) == null || this.d.get()) {
            b(str);
        }
        return this.c.get(str);
    }
}
