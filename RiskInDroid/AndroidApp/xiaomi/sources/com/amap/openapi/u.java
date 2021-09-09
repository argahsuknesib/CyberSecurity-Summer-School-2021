package com.amap.openapi;

import _m_j.om;
import _m_j.pd;
import _m_j.qg;
import _m_j.ub;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.util.Log;
import java.util.Locale;

public class u {
    private static final String[] O00000o = {"id", "type", "data", "size"};

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f3562O000000o;
    public long O00000Oo = O000000o(true);
    public long O00000o0 = O000000o(false);

    public static class O000000o extends SQLiteOpenHelper {
        O000000o(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS base (id INTEGER PRIMARY KEY AUTOINCREMENT , type SMALLINT, data BLOB, size INTEGER, time INTEGER);");
            } catch (Exception unused) {
            }
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS base");
                onCreate(sQLiteDatabase);
            } catch (Exception e) {
                om.O00000Oo("DbManager", "", e);
            }
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS base");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS byte_base");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS extend");
                onCreate(sQLiteDatabase);
            } catch (Exception e) {
                om.O00000Oo("DbManager", "", e);
            }
        }
    }

    public u(Context context) {
        this.f3562O000000o = new O000000o(context, "aloccoll.db");
    }

    private long O000000o(boolean z) {
        SystemClock.elapsedRealtime();
        long j = 0;
        Cursor cursor = null;
        try {
            cursor = this.f3562O000000o.getReadableDatabase().query("base", new String[]{"SUM(size)"}, z ? "type=?" : "type!=?", new String[]{"0"}, null, null, null);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            pd.O000000o((Cursor) null);
            throw th;
        }
        pd.O000000o(cursor);
        return j;
    }

    private long O000000o(boolean z, long j) throws Exception {
        String str = z ? "type=0" : "type!=0";
        long j2 = -2147483648L;
        long j3 = 0;
        while (true) {
            if (j3 >= j) {
                break;
            }
            Cursor cursor = null;
            try {
                cursor = this.f3562O000000o.getReadableDatabase().query("base", new String[]{"id", "type", "size"}, "id>? AND ".concat(str), new String[]{String.valueOf(j2)}, null, null, "id ASC", "100");
                boolean moveToNext = cursor.moveToNext();
                if (moveToNext) {
                    while (moveToNext) {
                        j2 = cursor.getLong(0);
                        j3 += (long) cursor.getInt(2);
                        if (j3 >= j) {
                            break;
                        }
                        moveToNext = cursor.moveToNext();
                    }
                } else {
                    pd.O000000o(cursor);
                    break;
                }
            } finally {
                pd.O000000o(cursor);
            }
        }
        if (j3 > 0) {
            if (this.f3562O000000o.getWritableDatabase().delete("base", "id<=? AND ".concat(str), new String[]{String.valueOf(j2)}) > 0) {
                if (z) {
                    this.O00000Oo -= j3;
                    if (this.O00000Oo < 0) {
                        this.O00000Oo = 0;
                    }
                } else {
                    this.O00000o0 -= j3;
                    if (this.O00000o0 < 0) {
                        this.O00000o0 = 0;
                    }
                }
            }
        }
        return j3;
    }

    public final qg O000000o(boolean z, int i, long j) {
        Cursor cursor;
        qg qgVar = new qg();
        qg qgVar2 = null;
        try {
            cursor = this.f3562O000000o.getReadableDatabase().query("base", O00000o, z ? "type=0" : "type!=0", null, null, null, "id ASC", "10000");
            int i2 = 0;
            while (cursor.moveToNext()) {
                try {
                    int i3 = cursor.getInt(3);
                    if (((long) qgVar.O00000o0) >= j || ((long) (qgVar.O00000o0 + i3)) > j || i2 >= 10000) {
                        break;
                    }
                    qgVar.f2395O000000o = cursor.getLong(0);
                    qgVar.O00000Oo.add(new ub(cursor.getInt(1), cursor.getBlob(2)));
                    qgVar.O00000o0 += i3;
                    i2++;
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    pd.O000000o(cursor);
                    throw th;
                }
            }
            om.O00000Oo("@_3_2_@", z ? String.format(Locale.getDefault(), "@_3_2_1_@%d，%d, %d", Long.valueOf(qgVar.f2395O000000o), Integer.valueOf(i2), Integer.valueOf(qgVar.O00000o0)) : String.format(Locale.getDefault(), "@_3_2_2_@%d，%d, %d", Long.valueOf(qgVar.f2395O000000o), Integer.valueOf(i2), Integer.valueOf(qgVar.O00000o0)));
            if (qgVar.O00000o0 != 0) {
                qgVar2 = qgVar;
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            pd.O000000o(cursor);
            throw th;
        }
        pd.O000000o(cursor);
        return qgVar2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final boolean O000000o(long j) {
        if (j < 4611686018427387903L && this.O00000Oo + this.O00000o0 + j < 10485760) {
            return true;
        }
        long max = Math.max(204800L, j);
        try {
            long O000000o2 = O000000o(false, max);
            if (O000000o2 < max) {
                O000000o(true, max - O000000o2);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean O000000o(qg qgVar) {
        String format;
        boolean z = true;
        if (!(qgVar == null || qgVar.O00000Oo.size() == 0)) {
            try {
                boolean z2 = qgVar.O00000Oo.get(0).f2524O000000o == 0;
                int delete = this.f3562O000000o.getWritableDatabase().delete("base", z2 ? "type=0 AND id<=?" : "type!=0 AND id<=?", new String[]{String.valueOf(qgVar.f2395O000000o)});
                if (delete > 0) {
                    if (z2) {
                        this.O00000Oo -= (long) qgVar.O00000o0;
                        if (this.O00000Oo < 0) {
                            this.O00000Oo = 0;
                        }
                    } else {
                        this.O00000o0 -= (long) qgVar.O00000o0;
                        if (this.O00000o0 < 0) {
                            this.O00000o0 = 0;
                        }
                    }
                }
                if (z2) {
                    try {
                        format = String.format(Locale.getDefault(), "@_3_2_6_@%d，%d，%d", Long.valueOf(qgVar.f2395O000000o), Integer.valueOf(delete), Integer.valueOf(qgVar.O00000o0));
                    } catch (Exception e) {
                        e = e;
                        om.O00000Oo("@_3_2_@", "@_3_2_8_@" + Log.getStackTraceString(e));
                        return z;
                    }
                } else {
                    format = String.format(Locale.getDefault(), "@_3_2_7_@%d，%d，%d", Long.valueOf(qgVar.f2395O000000o), Integer.valueOf(delete), Integer.valueOf(qgVar.O00000o0));
                }
                om.O00000Oo("@_3_2_@", format);
            } catch (Exception e2) {
                e = e2;
                z = false;
                om.O00000Oo("@_3_2_@", "@_3_2_8_@" + Log.getStackTraceString(e));
                return z;
            }
        }
        return z;
    }
}
