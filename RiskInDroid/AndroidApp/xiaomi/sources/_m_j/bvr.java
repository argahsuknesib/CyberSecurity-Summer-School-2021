package _m_j;

import android.database.sqlite.SQLiteDatabase;

public class bvr implements bsj {
    public final String O000000o() {
        return "alsn20170807.db";
    }

    public final void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            bvz.O000000o(th, "SdCardDbCreator", "onCreate");
        }
    }
}
