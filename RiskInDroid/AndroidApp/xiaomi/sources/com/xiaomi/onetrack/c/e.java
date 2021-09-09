package com.xiaomi.onetrack.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.onetrack.b.l;
import com.xiaomi.onetrack.h.q;
import java.util.Calendar;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f6127a;

    e(b bVar) {
        this.f6127a = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0095, code lost:
        if (r1 != null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ad, code lost:
        if (r1 == null) goto L_0x00b0;
     */
    public void run() {
        synchronized (this.f6127a.i) {
            Cursor cursor = null;
            try {
                SQLiteDatabase writableDatabase = this.f6127a.i.getWritableDatabase();
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(System.currentTimeMillis());
                instance.set(6, instance.get(6) - 7);
                boolean z = false;
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                String[] strArr = {Long.toString(instance.getTimeInMillis())};
                cursor = writableDatabase.query("events", new String[]{"timestamp"}, "timestamp < ? ", strArr, null, null, "timestamp ASC");
                if (cursor.getCount() != 0) {
                    q.a("EventManager", "*** deleted obsolete item count=".concat(String.valueOf(writableDatabase.delete("events", "timestamp < ? ", strArr))));
                }
                long c = b.a().c();
                if (c == 0) {
                    z = true;
                }
                l.a(z);
                q.a("EventManager", "after delete obsolete record remains=".concat(String.valueOf(c)));
            } catch (Exception e) {
                try {
                    q.d("EventManager", "remove obsolete events failed with ".concat(String.valueOf(e)));
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
    }
}
