package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class ry {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ry f2444O000000o;
    private O000000o O00000Oo;
    private Object O00000o0 = new Object();

    static class O000000o extends SQLiteOpenHelper {
        O000000o(Context context) {
            super(context, "OffEvent.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            rz.O000000o(sQLiteDatabase);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private ry() {
    }

    public static ry O000000o() {
        if (f2444O000000o == null) {
            synchronized (ry.class) {
                if (f2444O000000o == null) {
                    f2444O000000o = new ry();
                }
            }
        }
        return f2444O000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc A[SYNTHETIC, Splitter:B:54:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e9 A[SYNTHETIC, Splitter:B:62:0x00e9] */
    private String O000000o(int i) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2;
        String[] split;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        try {
            sQLiteDatabase = this.O00000Oo.getWritableDatabase();
        } catch (Exception unused) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            return sb.toString();
        }
        try {
            sQLiteDatabase.beginTransaction();
            cursor = sQLiteDatabase.query("ACL", new String[]{rz.f2445O000000o, rz.O00000Oo}, null, null, null, null, "frequency DESC", String.valueOf(i));
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        while (!cursor.isAfterLast()) {
                            String string = cursor.getString(0);
                            int i2 = cursor.getInt(1);
                            if (!(string == null || (split = string.split("_")) == null)) {
                                if (split.length == 3 || split.length == 4) {
                                    int i3 = split.length == 4 ? 0 : 1;
                                    if (sb.length() != 0) {
                                        sb.append("#");
                                    }
                                    sb.append(i3);
                                    sb.append("|");
                                    sb.append(string);
                                    sb.append("|");
                                    sb.append(i2);
                                    arrayList.add(string);
                                }
                            }
                            cursor.moveToNext();
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sQLiteDatabase.delete("ACL", "id=?", new String[]{(String) it.next()});
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    sQLiteDatabase.endTransaction();
                    throw th;
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable unused2) {
                }
            }
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
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
        return sb.toString();
    }

    private void O00000Oo(Context context) {
        if (this.O00000Oo == null) {
            this.O00000Oo = new O000000o(context);
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
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e A[Catch:{ Throwable -> 0x0048, all -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067 A[Catch:{ Throwable -> 0x0048, all -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083 A[SYNTHETIC, Splitter:B:25:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4 A[SYNTHETIC, Splitter:B:35:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa A[SYNTHETIC, Splitter:B:39:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    public final void O000000o(Context context, re reVar) {
        int i;
        synchronized (this.O00000o0) {
            O00000Oo(context);
        }
        if (!TextUtils.isEmpty(reVar.O00000oo)) {
            String replace = reVar.O00000oo.replace(":", "_");
            Cursor cursor = null;
            try {
                SQLiteDatabase writableDatabase = this.O00000Oo.getWritableDatabase();
                Cursor cursor2 = writableDatabase.query("ACL", new String[]{rz.O00000Oo}, "id=?", new String[]{replace}, null, null, null);
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst()) {
                            i = cursor2.getInt(0);
                            if (i != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("id", replace);
                                contentValues.put("frequency", (Integer) 1);
                                writableDatabase.insert("ACL", null, contentValues);
                            } else {
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("frequency", Integer.valueOf(i + 1));
                                writableDatabase.update("ACL", contentValues2, "id=?", new String[]{replace});
                            }
                            if (cursor2 == null) {
                                try {
                                    cursor2.close();
                                    return;
                                } catch (Throwable unused) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th;
                    }
                }
                i = 0;
                if (i != 0) {
                }
                if (cursor2 == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                om.O00000Oo("@_18_7_@", "@_18_7_4_@" + Log.getStackTraceString(th));
                if (cursor == null) {
                }
            }
        }
    }

    public final void O000000o(Context context) {
        String O000000o2;
        synchronized (this.O00000o0) {
            O00000Oo(context);
        }
        if (TextUtils.isEmpty(ol.O000000o())) {
            om.O00000Oo("@_18_7_@", "@_18_7_5_@");
            return;
        }
        boolean O000000o3 = sc.O000000o(context);
        int O00000Oo2 = sc.O00000Oo(context);
        om.O00000Oo("@_18_7_@", "@_18_7_1_@(" + O000000o3 + "," + O00000Oo2 + ")");
        if (O000000o3 && O00000Oo2 > 0 && (O000000o2 = O000000o(O00000Oo2)) != null && O000000o2.length() > 0) {
            su.O000000o(800002, O000000o2.getBytes());
            int i = 0;
            String[] split = O000000o2.split("#");
            if (split != null && split.length > 0) {
                i = split.length;
            }
            sc.O000000o(context, i);
            om.O00000Oo("@_18_7_@", "@_18_7_2_@".concat(String.valueOf(i)));
        }
    }
}
