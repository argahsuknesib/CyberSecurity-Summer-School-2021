package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class i {
    public String a(Context context) {
        String str = "";
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            str = a(query);
            query.close();
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private String a(Cursor cursor) {
        String str = null;
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex > 0) {
            str = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return str;
    }
}
