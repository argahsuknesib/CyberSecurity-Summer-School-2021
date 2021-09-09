package _m_j;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class ro extends SQLiteOpenHelper {
    ro(Context context) {
        super(context, "OffStatistics.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        rl.O000000o(sQLiteDatabase);
        rn.O000000o(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
