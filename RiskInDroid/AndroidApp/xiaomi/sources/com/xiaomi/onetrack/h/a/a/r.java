package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.xiaomi.onetrack.h.q;

public class r {
    public String a(Context context) {
        String str = "";
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query != null) {
                if (query.moveToNext()) {
                    str = query.getString(query.getColumnIndex("value"));
                }
                query.close();
            }
        } catch (Exception e) {
            q.a("VivoDeviceIDHelper", e.getMessage());
        }
        return str;
    }
}
