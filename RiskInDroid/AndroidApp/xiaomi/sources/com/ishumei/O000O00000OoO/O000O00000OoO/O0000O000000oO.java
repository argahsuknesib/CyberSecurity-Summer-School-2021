package com.ishumei.O000O00000OoO.O000O00000OoO;

import _m_j.bls;
import _m_j.blt;
import _m_j.bmz;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

public class O0000O000000oO extends SQLiteOpenHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    private SQLiteDatabase f4497O000000o;

    public O0000O000000oO(Context context) {
        super(context, "tracker.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public final synchronized int O000000o(String str, String str2, String[] strArr) {
        int i;
        i = -1;
        try {
            O000000o().beginTransaction();
            i = O000000o().delete(str, str2, strArr);
            O000000o().setTransactionSuccessful();
            try {
                O000000o().endTransaction();
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            try {
                bmz.O000000o(e2);
                try {
                    O000000o().endTransaction();
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                try {
                    O000000o().endTransaction();
                } catch (Exception e4) {
                    bmz.O000000o(e4);
                }
                throw th;
            }
        }
        return i;
        bmz.O000000o(e);
        return i;
    }

    public final long O000000o(String str) {
        try {
            return DatabaseUtils.queryNumEntries(O000000o(), str, null, null);
        } catch (Exception e) {
            bmz.O000000o(e);
            return -1;
        }
    }

    public final synchronized long O000000o(String str, ContentValues contentValues) {
        long j;
        j = -1;
        try {
            O000000o().beginTransaction();
            j = O000000o().insert(str, null, contentValues);
            O000000o().setTransactionSuccessful();
            try {
                O000000o().endTransaction();
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            try {
                bmz.O000000o(e2);
                try {
                    O000000o().endTransaction();
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                try {
                    O000000o().endTransaction();
                } catch (Exception e4) {
                    bmz.O000000o(e4);
                }
                throw th;
            }
        }
        return j;
        bmz.O000000o(e);
        return j;
    }

    public final Cursor O000000o(String str, String str2) {
        try {
            return O000000o().query(str, null, null, null, null, null, null, str2);
        } catch (Exception e) {
            bmz.O000000o(e);
            return null;
        }
    }

    public final SQLiteDatabase O000000o() {
        if (this.f4497O000000o == null) {
            synchronized (this) {
                if (this.f4497O000000o == null) {
                    this.f4497O000000o = getWritableDatabase();
                }
            }
        }
        return this.f4497O000000o;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        List<blt> list = bls.O000000o.f13076O000000o.O00000Oo;
        if (list != null && list.size() != 0) {
            for (blt O000000o2 : list) {
                O000000o2.O000000o(sQLiteDatabase);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<blt> list = bls.O000000o.f13076O000000o.O00000Oo;
        if (list != null && list.size() != 0) {
            for (blt O000000o2 : list) {
                O000000o2.O000000o(sQLiteDatabase, i);
            }
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<blt> list = bls.O000000o.f13076O000000o.O00000Oo;
        if (list != null && list.size() != 0) {
            Iterator<blt> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
