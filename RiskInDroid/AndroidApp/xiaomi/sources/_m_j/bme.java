package _m_j;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public final class bme implements blt {
    public final void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS upload_checker(id INTEGER PRIMARY KEY AUTOINCREMENT,upload_data VARCHAR(100000),upload_url VARCHAR(1000))");
        } catch (SQLException e) {
            bmz.O00000o("UploadDBHelper", "fail to create table: %s: %s", "upload_checker", Log.getStackTraceString(e));
        }
    }

    public final void O000000o(SQLiteDatabase sQLiteDatabase, int i) {
    }
}
