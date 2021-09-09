package _m_j;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* renamed from: _m_j.do  reason: invalid class name and case insensitive filesystem */
final class C0119do {
    public static boolean O00000Oo(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{"document_id"}, null, null, null);
            if (cursor.getCount() > 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: ".concat(String.valueOf(e)));
            return false;
        } finally {
            O000000o(cursor);
        }
    }

    static String O000000o(Context context, Uri uri, String str) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst() || cursor.isNull(0)) {
                    O000000o(cursor);
                    return null;
                }
                String string = cursor.getString(0);
                O000000o(cursor);
                return string;
            } catch (Exception e) {
                e = e;
                try {
                    Log.w("DocumentFile", "Failed query: ".concat(String.valueOf(e)));
                    O000000o(cursor);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    O000000o(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
            Log.w("DocumentFile", "Failed query: ".concat(String.valueOf(e)));
            O000000o(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            O000000o(cursor);
            throw th;
        }
    }

    static long O00000Oo(Context context, Uri uri, String str) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getLong(0);
            }
            O000000o(cursor);
            return 0;
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: ".concat(String.valueOf(e)));
            return 0;
        } finally {
            O000000o(cursor);
        }
    }

    private static void O000000o(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static String O000000o(Context context, Uri uri) {
        String O000000o2 = O000000o(context, uri, "mime_type");
        if ("vnd.android.document/directory".equals(O000000o2)) {
            return null;
        }
        return O000000o2;
    }
}
