package com.xiaomi.onetrack.h;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.onetrack.f.a;
import java.util.UUID;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6177a = "p";
    private static volatile p f;
    private static String g;
    private static String i;
    private final Context h = a.a();
    private boolean j = false;

    public static p a() {
        if (f == null) {
            synchronized (p.class) {
                if (f == null) {
                    f = new p();
                }
            }
        }
        return f;
    }

    private p() {
        i = a.d();
    }

    public void a(Boolean bool) {
        this.j = bool.booleanValue();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            g = str;
            if (this.j) {
                b(g);
            }
            z.e(g);
        }
    }

    public String b() {
        String str;
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (this.j) {
            str = c();
            String d = d();
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(d)) {
                b(d);
                str = d;
            } else if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(d)) {
                z.e(str);
            }
        } else {
            str = d();
        }
        if (TextUtils.isEmpty(str)) {
            g = UUID.randomUUID().toString();
            if (this.j) {
                b(g);
            }
            z.e(g);
        } else {
            g = str;
        }
        return g;
    }

    private String c() {
        String str = null;
        try {
            Uri.Builder buildUpon = Uri.parse("content://com.miui.analytics.OneTrackProvider/insId").buildUpon();
            buildUpon.appendQueryParameter("pkg", i);
            buildUpon.appendQueryParameter("sign", com.xiaomi.onetrack.d.a.a("insId" + i));
            Cursor query = this.h.getContentResolver().query(buildUpon.build(), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    str = query.getString(0);
                }
                query.close();
            }
        } catch (Exception e) {
            q.b(f6177a, "getRemoteCacheInstanceId e", e);
        }
        return str;
    }

    private void b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse("content://com.miui.analytics.OneTrackProvider/insId");
                ContentValues contentValues = new ContentValues();
                contentValues.put(i, str);
                this.h.getContentResolver().insert(parse, contentValues);
            }
        } catch (Exception e) {
            z.e(str);
            q.b(f6177a, "setRemoteCacheInstanceId e", e);
        }
    }

    private String d() {
        String a2 = z.a(this.h);
        if (TextUtils.isEmpty(a2)) {
            return z.m();
        }
        z.e(a2);
        return a2;
    }
}
