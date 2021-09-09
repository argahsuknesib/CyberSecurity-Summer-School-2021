package com.xiaomi.push.providers;

import _m_j.erf;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class TrafficProvider extends ContentProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Uri f6458O000000o = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");
    private static final UriMatcher O00000Oo;
    private SQLiteOpenHelper O00000o0;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        O00000Oo = uriMatcher;
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
        O00000Oo.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        if (O00000Oo.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI ".concat(String.valueOf(uri)));
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        this.O00000o0 = new a(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (a.f6459O000000o) {
            if (O00000Oo.match(uri) == 1) {
                query = this.O00000o0.getReadableDatabase().query("traffic", strArr, str, strArr2, null, null, str2);
            } else {
                throw new IllegalArgumentException("Unknown URI ".concat(String.valueOf(uri)));
            }
        }
        return query;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (O00000Oo.match(uri) != 2 || contentValues == null || !contentValues.containsKey("imsi")) {
            return 0;
        }
        erf.O000000o(contentValues.getAsString("imsi"));
        return 0;
    }
}
