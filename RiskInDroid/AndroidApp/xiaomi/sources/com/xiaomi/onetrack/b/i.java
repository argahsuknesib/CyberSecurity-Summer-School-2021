package com.xiaomi.onetrack.b;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class i implements Callable<j> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6123a;
    final /* synthetic */ f b;

    i(f fVar, String str) {
        this.b = fVar;
        this.f6123a = str;
    }

    /* renamed from: a */
    public j call() throws Exception {
        Cursor query = this.b.b.getWritableDatabase().query("events_cloud", null, "app_id=?", new String[]{this.f6123a}, null, null, null);
        int columnIndex = query.getColumnIndex("app_id");
        int columnIndex2 = query.getColumnIndex("cloud_data");
        int columnIndex3 = query.getColumnIndex("data_hash");
        int columnIndex4 = query.getColumnIndex("timestamp");
        if (!query.moveToNext()) {
            return null;
        }
        j jVar = new j();
        jVar.f6124a = query.getString(columnIndex);
        String string = query.getString(columnIndex2);
        if (!TextUtils.isEmpty(string)) {
            jVar.d = new JSONObject(string);
        }
        jVar.c = query.getString(columnIndex3);
        jVar.b = query.getLong(columnIndex4);
        return jVar;
    }
}
