package _m_j;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public final class blz implements blt {
    public final void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS net_error_t(t VARCHAR(20),ex VARCHAR(10000),net VARCHAR(100),url VARCHAR(1000),dns VARCHAR(200))");
        } catch (SQLException e) {
            bmz.O00000o("NetworkExceptionDBHelper", "fail to create table: %s: %s", "net_error_t", Log.getStackTraceString(e));
        }
    }

    public final void O000000o(SQLiteDatabase sQLiteDatabase, int i) {
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS net_error_t(t VARCHAR(20),ex VARCHAR(10000),net VARCHAR(100),url VARCHAR(1000),dns VARCHAR(200))");
            } catch (SQLException e) {
                bmz.O00000o("NetworkExceptionDBHelper", "fail to create table: %s: %s", "net_error_t", Log.getStackTraceString(e));
            }
        }
    }
}
