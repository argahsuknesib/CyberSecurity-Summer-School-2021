package com.miui.tsmclient.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.miui.tsmclient.util.IOUtils;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.ReflectUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private Context f3857a;
    private a b;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);

        void a(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    public b(Context context) {
        super(context, "tsmclient.db", (SQLiteDatabase.CursorFactory) null, 9);
        this.f3857a = context;
        Object newInstance = ReflectUtil.newInstance(context.getPackageName() + ".mitsmsdk.ExtraDataHelperImpl", new Class[]{Context.class}, this.f3857a);
        if (newInstance instanceof a) {
            this.b = (a) newInstance;
        }
        setWriteAheadLoggingEnabled(true);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
        e(sQLiteDatabase);
        f(sQLiteDatabase);
        d(sQLiteDatabase);
        g(sQLiteDatabase);
        h(sQLiteDatabase);
        i(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str + ";");
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        j(sQLiteDatabase);
        l(sQLiteDatabase);
        k(sQLiteDatabase);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,value TEXT);");
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bank_bin(_id INTEGER PRIMARY KEY AUTOINCREMENT,bin_code TEXT NOT NULL,bank_name TEXT NOT NULL,card_type INTEGER);");
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bank_info (_id INTEGER PRIMARY KEY AUTOINCREMENT,bank_code TEXT ,bank_id TEXT ,bank_name TEXT ,bank_logo TEXT );");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS BANK_ID_INDEX ON bank_info ( bank_id)");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trans_card_info (_id INTEGER PRIMARY KEY AUTOINCREMENT,card_code TEXT ,card_id TEXT ,card_name TEXT ,card_logo TEXT ,issuable INTEGER );");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS TRANS_CARD_ID_INDEX ON trans_card_info ( card_id)");
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS no_prompt_bulletin(_id INTEGER PRIMARY KEY AUTOINCREMENT,bulletin_id TEXT NOT NULL);");
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS data_stat(_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER ,data_value TEXT ,data_time TEXT);");
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS travel_info(_id INTEGER PRIMARY KEY AUTOINCREMENT,card_name TEXT,key INTEGER,value TEXT);");
    }

    private void j(SQLiteDatabase sQLiteDatabase) {
        BufferedReader bufferedReader = null;
        try {
            sQLiteDatabase.delete("bank_info", null, null);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.f3857a.getAssets().open("bank_info")));
            try {
                ContentValues contentValues = new ContentValues();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        contentValues.clear();
                        String[] split = readLine.split(",");
                        contentValues.put("bank_code", split[0]);
                        contentValues.put("bank_id", split[1]);
                        contentValues.put("bank_name", split[2]);
                        if (split.length > 3) {
                            contentValues.put("bank_logo", split[3]);
                        }
                        sQLiteDatabase.insert("bank_info", null, contentValues);
                    } else {
                        IOUtils.closeQuietly((Reader) bufferedReader2);
                        return;
                    }
                }
            } catch (IOException e) {
                e = e;
                bufferedReader = bufferedReader2;
                try {
                    LogUtils.e("initBankInfoTb failed", e);
                    IOUtils.closeQuietly((Reader) bufferedReader);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Reader) bufferedReader2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            LogUtils.e("initBankInfoTb failed", e);
            IOUtils.closeQuietly((Reader) bufferedReader);
        }
    }

    private void k(SQLiteDatabase sQLiteDatabase) {
        BufferedReader bufferedReader = null;
        try {
            sQLiteDatabase.delete("bank_bin", null, null);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.f3857a.getAssets().open("bank_bin")));
            try {
                ContentValues contentValues = new ContentValues();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        contentValues.clear();
                        String[] split = readLine.split(",");
                        int i = 0;
                        contentValues.put("bank_name", split[0]);
                        contentValues.put("bin_code", split[1]);
                        if (TextUtils.isDigitsOnly(split[2])) {
                            i = Integer.valueOf(split[2]).intValue();
                        }
                        contentValues.put("card_type", Integer.valueOf(i));
                        sQLiteDatabase.insert("bank_bin", null, contentValues);
                    } else {
                        IOUtils.closeQuietly((Reader) bufferedReader2);
                        return;
                    }
                }
            } catch (IOException e) {
                e = e;
                bufferedReader = bufferedReader2;
                try {
                    LogUtils.e("failed to init bank card info table", e);
                    IOUtils.closeQuietly((Reader) bufferedReader);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Reader) bufferedReader2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            LogUtils.e("failed to init bank card info table", e);
            IOUtils.closeQuietly((Reader) bufferedReader);
        }
    }

    private void l(SQLiteDatabase sQLiteDatabase) {
        BufferedReader bufferedReader = null;
        try {
            sQLiteDatabase.delete("trans_card_info", null, null);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.f3857a.getAssets().open("trans_card_info")));
            try {
                ContentValues contentValues = new ContentValues();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        contentValues.clear();
                        String[] split = readLine.split(",");
                        contentValues.put("card_code", split[0]);
                        contentValues.put("card_id", split[1]);
                        contentValues.put("card_name", split[2]);
                        contentValues.put("card_logo", split[3]);
                        contentValues.put("issuable", split[4]);
                        sQLiteDatabase.insert("trans_card_info", null, contentValues);
                    } else {
                        IOUtils.closeQuietly((Reader) bufferedReader2);
                        return;
                    }
                }
            } catch (IOException e) {
                e = e;
                bufferedReader = bufferedReader2;
                try {
                    Log.e("TSMDatabaseHelper", "Error when process file", e);
                    IOUtils.closeQuietly((Reader) bufferedReader);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Reader) bufferedReader2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            Log.e("TSMDatabaseHelper", "Error when process file", e);
            IOUtils.closeQuietly((Reader) bufferedReader);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        LogUtils.i("TSMDatabaseHelper onCreate");
        a(sQLiteDatabase);
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(sQLiteDatabase);
        }
        b(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        LogUtils.i("TSMDatabaseHelper upgrading db from " + i + " to " + i2);
        sQLiteDatabase.beginTransaction();
        if (i < 7) {
            try {
                a(sQLiteDatabase, "cache");
            } catch (Throwable th) {
                LogUtils.e("error occurred to upgrade db: " + th.getMessage());
            }
        }
        a(sQLiteDatabase);
        if (this.b != null) {
            this.b.a(sQLiteDatabase, i, i2);
        }
        b(sQLiteDatabase);
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }
}
