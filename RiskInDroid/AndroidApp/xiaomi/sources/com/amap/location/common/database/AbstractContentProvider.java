package com.amap.location.common.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import java.util.HashMap;

public abstract class AbstractContentProvider extends ContentProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    protected UriMatcher f3553O000000o = new UriMatcher(-1);
    protected HashMap<Integer, SQLiteOpenHelper> O00000Oo = new HashMap<>();
    private final String O00000o = "AbstractContentProvider";
    protected HashMap<Integer, String> O00000o0 = new HashMap<>();
    private String O00000oO = "";

    private static <T> T O000000o(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public final int O000000o(Uri uri, ContentValues contentValues, String str) {
        O000000o(uri, "uri");
        try {
            int match = this.f3553O000000o.match(uri);
            SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
            if (sQLiteOpenHelper == null) {
                return 0;
            }
            SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
            String str2 = this.O00000o0.get(Integer.valueOf(match));
            if (writableDatabase != null) {
                if (str2 != null) {
                    return writableDatabase.update(str2, contentValues, str, null);
                }
            }
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public final int O000000o(Uri uri, String str, String[] strArr) {
        O000000o(uri, "uri");
        try {
            int match = this.f3553O000000o.match(uri);
            SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
            if (sQLiteOpenHelper == null) {
                return 0;
            }
            SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
            String str2 = this.O00000o0.get(Integer.valueOf(match));
            if (writableDatabase != null) {
                if (str2 != null) {
                    return writableDatabase.delete(str2, str, strArr);
                }
            }
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056 A[SYNTHETIC, Splitter:B:29:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005c A[SYNTHETIC, Splitter:B:35:0x005c] */
    public final int O000000o(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase sQLiteDatabase;
        O000000o(uri, "uri");
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            int match = this.f3553O000000o.match(uri);
            SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
            if (sQLiteOpenHelper == null) {
                return 0;
            }
            sQLiteDatabase = sQLiteOpenHelper.getWritableDatabase();
            try {
                String str = this.O00000o0.get(Integer.valueOf(match));
                if (sQLiteDatabase != null) {
                    if (str != null) {
                        sQLiteDatabase.beginTransaction();
                        for (ContentValues insert : contentValuesArr) {
                            sQLiteDatabase.insert(str, null, insert);
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Exception unused) {
                            }
                        }
                        return r0;
                    }
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception unused2) {
                    }
                }
                return 0;
            } catch (Exception unused3) {
                sQLiteDatabase2 = sQLiteDatabase;
                if (sQLiteDatabase2 != null) {
                }
                return r0;
            } catch (Throwable th) {
                th = th;
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public final long O000000o(Uri uri) {
        O000000o(uri, "uri");
        int match = this.f3553O000000o.match(uri);
        SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
        if (sQLiteOpenHelper == null) {
            return 0;
        }
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        String str = this.O00000o0.get(Integer.valueOf(match));
        if (writableDatabase == null || str == null) {
            return 0;
        }
        return DatabaseUtils.queryNumEntries(writableDatabase, str);
    }

    public final long O000000o(Uri uri, ContentValues contentValues) {
        O000000o(uri, "uri");
        try {
            int match = this.f3553O000000o.match(uri);
            SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
            if (sQLiteOpenHelper == null) {
                return 0;
            }
            SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
            String str = this.O00000o0.get(Integer.valueOf(match));
            if (writableDatabase != null) {
                if (str != null) {
                    return writableDatabase.insert(str, null, contentValues);
                }
            }
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public final Cursor O000000o(Uri uri, String[] strArr, String str, String str2) {
        return O00000Oo(uri, strArr, str, null, str2, null);
    }

    public final Cursor O000000o(Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        O000000o(uri, "uri");
        int match = this.f3553O000000o.match(uri);
        SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
        if (sQLiteOpenHelper == null) {
            return null;
        }
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        String str4 = this.O00000o0.get(Integer.valueOf(match));
        if (writableDatabase == null || str4 == null) {
            return null;
        }
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(str4);
        return sQLiteQueryBuilder.query(writableDatabase, strArr, str, strArr2, null, null, str2, str3);
    }

    public abstract String O000000o();

    public final void O000000o(Integer num, String str, SQLiteOpenHelper sQLiteOpenHelper) {
        this.O00000Oo.put(num, sQLiteOpenHelper);
        this.O00000o0.put(num, str);
        this.f3553O000000o.addURI(this.O00000oO, str, num.intValue());
    }

    public final Cursor O00000Oo(Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        O000000o(uri, "uri");
        try {
            int match = this.f3553O000000o.match(uri);
            SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
            if (sQLiteOpenHelper == null) {
                return null;
            }
            SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
            String str4 = this.O00000o0.get(Integer.valueOf(match));
            if (writableDatabase != null) {
                if (str4 != null) {
                    SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
                    sQLiteQueryBuilder.setTables(str4);
                    return sQLiteQueryBuilder.query(writableDatabase, strArr, str, strArr2, null, null, str2, str3);
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract void O00000Oo();

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        O000000o(uri, "uri");
        int match = this.f3553O000000o.match(uri);
        SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
        int i = 0;
        if (sQLiteOpenHelper == null) {
            return 0;
        }
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        String str = this.O00000o0.get(Integer.valueOf(match));
        if (writableDatabase == null || str == null) {
            return 0;
        }
        int length = contentValuesArr.length;
        writableDatabase.beginTransaction();
        while (i < length) {
            try {
                writableDatabase.insert(str, null, contentValuesArr[i]);
                i++;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        return length;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        O000000o(uri, "uri");
        int match = this.f3553O000000o.match(uri);
        SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
        if (sQLiteOpenHelper == null) {
            return 0;
        }
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        String str2 = this.O00000o0.get(Integer.valueOf(match));
        if (writableDatabase == null || str2 == null) {
            return 0;
        }
        return writableDatabase.delete(str2, str, strArr);
    }

    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/".concat(String.valueOf(this.O00000o0.get(Integer.valueOf(this.f3553O000000o.match(uri)))));
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        O000000o(uri, "uri");
        int match = this.f3553O000000o.match(uri);
        SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
        if (sQLiteOpenHelper == null) {
            return ContentUris.withAppendedId(uri, -1);
        }
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        String str = this.O00000o0.get(Integer.valueOf(match));
        return (writableDatabase == null || str == null) ? ContentUris.withAppendedId(uri, -1) : ContentUris.withAppendedId(uri, writableDatabase.insert(str, null, contentValues));
    }

    public boolean onCreate() {
        this.O00000oO = O000000o();
        O00000Oo();
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return O000000o(uri, strArr, str, strArr2, str2, null);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        O000000o(uri, "uri");
        int match = this.f3553O000000o.match(uri);
        SQLiteOpenHelper sQLiteOpenHelper = this.O00000Oo.get(Integer.valueOf(match));
        if (sQLiteOpenHelper == null) {
            return 0;
        }
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        String str2 = this.O00000o0.get(Integer.valueOf(match));
        if (writableDatabase == null || str2 == null) {
            return 0;
        }
        return writableDatabase.update(str2, contentValues, str, strArr);
    }
}
