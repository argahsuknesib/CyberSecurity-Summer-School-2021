package _m_j;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class bsn extends SQLiteOpenHelper {
    private static boolean O00000Oo = true;
    private static boolean O00000o0 = false;

    /* renamed from: O000000o  reason: collision with root package name */
    private bsj f13241O000000o;

    public bsn(Context context, String str, bsj bsj) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f13241O000000o = bsj;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f13241O000000o.O000000o(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
