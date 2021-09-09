package com.hzy.tvmao.model.db;

import android.database.sqlite.SQLiteDatabase;

public class b {
    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS lineup(_id INTEGER PRIMARY KEY AUTOINCREMENT, lineup_id INT,sequence INT, channel_id INT, device_id INT,country_id CHAR(2), pulse BOLB, hd TINYINT, hidden TINYINT, fee TINYINT, type TINYINT, enc_name BOLB, logo VARCHAR(128), llogo VARCHAR(128), enc_num BOLB);");
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            i++;
            if (i != 2 && i == 3) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE lineup ADD llogo VARCHAR(128);");
                    sQLiteDatabase.execSQL("ALTER TABLE lineup ADD enc_num BOLB;");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
