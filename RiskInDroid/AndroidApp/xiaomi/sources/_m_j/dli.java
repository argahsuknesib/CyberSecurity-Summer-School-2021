package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

final class dli extends SQLiteOpenHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f14766O000000o = "";
    private Context O00000Oo = null;

    public dli(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
        this.f14766O000000o = str;
        this.O00000Oo = context.getApplicationContext();
        if (dkd.O00000Oo()) {
            dlm O00000Oo2 = dkz.O00000o;
            O00000Oo2.O000000o("SQLiteOpenHelper " + this.f14766O000000o);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.database.Cursor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    private static void O000000o(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor cursor2 = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (cursor2.moveToNext()) {
                    String string = cursor2.getString(0);
                    cursor2.getInt(1);
                    cursor2.getString(2);
                    cursor2.getLong(3);
                    contentValues.put("uid", dmb.O00000Oo(string));
                    cursor = string;
                }
                if (cursor != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{cursor});
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dkz.O00000o.O00000Oo(th);
            if (cursor == null) {
            }
        }
    }

    private static void O00000Oo(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            ArrayList<dlj> arrayList = new ArrayList<>();
            while (query.moveToNext()) {
                arrayList.add(new dlj(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
            }
            ContentValues contentValues = new ContentValues();
            for (dlj dlj : arrayList) {
                contentValues.put("content", dmb.O00000Oo(dlj.O00000Oo));
                sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(dlj.f14767O000000o)});
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final synchronized void close() {
        super.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        dlm O00000Oo2 = dkz.O00000o;
        O00000Oo2.O00000oo("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            O000000o(sQLiteDatabase);
            O00000Oo(sQLiteDatabase);
        }
        if (i == 2) {
            O000000o(sQLiteDatabase);
            O00000Oo(sQLiteDatabase);
        }
    }
}
