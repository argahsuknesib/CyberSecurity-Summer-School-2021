package com.hzy.tvmao.model.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.hzy.tvmao.KookongSDK;
import com.hzy.tvmao.utils.LogUtil;

public class a {
    private static a c;

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f4426a;
    private C0036a b;

    private a(Context context) {
        SQLiteDatabase sQLiteDatabase = this.f4426a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            try {
                if (this.b == null) {
                    this.b = new C0036a(context);
                }
                this.f4426a = this.b.getWritableDatabase();
                LogUtil.d("mSqlLiteDb is getWritableDatabase");
            } catch (SQLiteException e) {
                e.printStackTrace();
                LogUtil.e("数据库创建失败", e);
            }
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a(KookongSDK.getContext());
            }
            aVar = c;
        }
        return aVar;
    }

    public SQLiteDatabase b() {
        return this.f4426a;
    }

    public void c() {
        this.f4426a.close();
        this.b.close();
    }

    public void a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        c();
        super.finalize();
    }

    /* renamed from: com.hzy.tvmao.model.db.a$a  reason: collision with other inner class name */
    static class C0036a extends SQLiteOpenHelper {
        C0036a(Context context) {
            super(context, "TvMaoDb", (SQLiteDatabase.CursorFactory) null, 3);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            LogUtil.d("SQLiteDatabase onCreate");
            b.a(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            b.a(sQLiteDatabase, i, i2);
        }
    }
}
