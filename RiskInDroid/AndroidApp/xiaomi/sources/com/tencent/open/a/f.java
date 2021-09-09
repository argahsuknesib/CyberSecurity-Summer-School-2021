package com.tencent.open.a;

import _m_j.diz;
import _m_j.djk;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class f extends SQLiteOpenHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final String[] f5872O000000o = {"key"};
    protected static f O00000Oo;

    public static synchronized f O000000o() {
        f fVar;
        synchronized (f.class) {
            if (O00000Oo == null) {
                O00000Oo = new f(djk.O000000o());
            }
            fVar = O00000Oo;
        }
        return fVar;
    }

    public f(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:28|(0)|34|35|36|37) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:41|(0)|44|45|46|(0)|52|(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0087, code lost:
        if (r1 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0089, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x009d, code lost:
        if (r1 != null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00a1, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0063 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x006d */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A[SYNTHETIC, Splitter:B:32:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006a A[SYNTHETIC, Splitter:B:42:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0073 A[SYNTHETIC, Splitter:B:50:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0084 A[SYNTHETIC, Splitter:B:58:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00a4 A[SYNTHETIC, Splitter:B:75:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0082 A[SYNTHETIC] */
    public final synchronized List<Serializable> O000000o(String str) {
        Cursor cursor;
        Serializable serializable;
        ObjectInputStream objectInputStream;
        List<Serializable> synchronizedList = Collections.synchronizedList(new ArrayList());
        if (TextUtils.isEmpty(str)) {
            return synchronizedList;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return synchronizedList;
        }
        Cursor cursor2 = null;
        try {
            cursor = readableDatabase.query("via_cgi_report", null, "type = ?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        do {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("blob")));
                            try {
                                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                try {
                                    serializable = (Serializable) objectInputStream.readObject();
                                    objectInputStream.close();
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused) {
                                    }
                                } catch (Exception unused2) {
                                    if (objectInputStream != null) {
                                    }
                                    byteArrayInputStream.close();
                                    serializable = null;
                                    if (serializable != null) {
                                    }
                                    if (!cursor.moveToNext()) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (objectInputStream != null) {
                                    }
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            } catch (Exception unused3) {
                                objectInputStream = null;
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                                byteArrayInputStream.close();
                                serializable = null;
                                if (serializable != null) {
                                }
                                if (!cursor.moveToNext()) {
                                    if (cursor != null) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objectInputStream = null;
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                                byteArrayInputStream.close();
                                throw th;
                            }
                            if (serializable != null) {
                                synchronizedList.add(serializable);
                            }
                        } while (!cursor.moveToNext());
                    }
                } catch (Exception e) {
                    e = e;
                    cursor2 = cursor;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            e = e2;
            try {
                diz.O00000Oo("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
                if (cursor2 != null) {
                    cursor2.close();
                }
            } catch (Throwable th4) {
                th = th4;
                cursor = cursor2;
                if (cursor != null) {
                }
                if (readableDatabase != null) {
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:36|37|(0)|42|43|44|45) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:26|27|(6:28|29|30|31|32|33)|34|35|52|54|55|86) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x005b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x005e */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0058 A[SYNTHETIC, Splitter:B:40:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0062 A[SYNTHETIC, Splitter:B:50:0x0062] */
    public final synchronized void O000000o(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size != 0) {
            if (size > 20) {
                size = 20;
            }
            if (!TextUtils.isEmpty(str)) {
                O00000Oo(str);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.beginTransaction();
                    try {
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < size; i++) {
                            Serializable serializable = list.get(i);
                            if (serializable != null) {
                                contentValues.put("type", str);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                                ObjectOutputStream objectOutputStream2 = null;
                                try {
                                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                                    try {
                                        objectOutputStream.writeObject(serializable);
                                        objectOutputStream.close();
                                    } catch (IOException unused) {
                                        if (objectOutputStream != null) {
                                        }
                                        byteArrayOutputStream.close();
                                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                        writableDatabase.insert("via_cgi_report", null, contentValues);
                                        contentValues.clear();
                                    } catch (Throwable th) {
                                        th = th;
                                        objectOutputStream2 = objectOutputStream;
                                        if (objectOutputStream2 != null) {
                                        }
                                        byteArrayOutputStream.close();
                                        throw th;
                                    }
                                } catch (IOException unused2) {
                                    objectOutputStream = null;
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                    byteArrayOutputStream.close();
                                    contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                    writableDatabase.insert("via_cgi_report", null, contentValues);
                                    contentValues.clear();
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (objectOutputStream2 != null) {
                                        objectOutputStream2.close();
                                    }
                                    byteArrayOutputStream.close();
                                    throw th;
                                }
                                byteArrayOutputStream.close();
                                contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                writableDatabase.insert("via_cgi_report", null, contentValues);
                            }
                            contentValues.clear();
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                    } catch (Exception unused3) {
                        try {
                            diz.O00000oO("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
                        } finally {
                            writableDatabase.endTransaction();
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                        }
                    }
                }
            }
        }
    }

    public final synchronized void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                } catch (Exception e) {
                    try {
                        diz.O00000Oo("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e);
                    } finally {
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            }
        }
    }
}
