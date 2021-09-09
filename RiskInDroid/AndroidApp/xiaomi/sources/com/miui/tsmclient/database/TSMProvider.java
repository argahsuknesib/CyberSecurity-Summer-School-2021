package com.miui.tsmclient.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.miui.tsmclient.util.LogUtils;

public class TSMProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private UriMatcher f3856a;
    private b b;

    private int a(Uri uri, String str) {
        int match = a().match(uri);
        if (match >= 0) {
            LogUtils.v(str + ": uri=" + uri + ", match is " + match);
            return match;
        }
        throw new IllegalArgumentException("Unknown uri: ".concat(String.valueOf(uri)));
    }

    private synchronized UriMatcher a() {
        if (this.f3856a == null) {
            this.f3856a = new UriMatcher(-1);
            this.f3856a.addURI(DatabaseConstants.AUTHORITY, "cache", 0);
            this.f3856a.addURI(DatabaseConstants.AUTHORITY, "bank_bin", 2);
            this.f3856a.addURI(DatabaseConstants.AUTHORITY, "bank_info", 3);
            this.f3856a.addURI(DatabaseConstants.AUTHORITY, "trans_card_info", 4);
            this.f3856a.addURI(DatabaseConstants.AUTHORITY, "no_prompt_bulletin", 5);
            this.f3856a.addURI(DatabaseConstants.AUTHORITY, "data_stat", 6);
            this.f3856a.addURI(DatabaseConstants.AUTHORITY, "travel_info", 7);
        }
        return this.f3856a;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String str2;
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        int a2 = a(uri, "delete");
        if (a2 != 0) {
            if (a2 == 4) {
                str2 = "travel_info";
            } else if (a2 != 6) {
                return 0;
            } else {
                str2 = "data_stat";
            }
            return writableDatabase.delete(str2, str, strArr);
        }
        int delete = writableDatabase.delete("cache", str, strArr);
        if (delete > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return delete;
    }

    public String getType(Uri uri) {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b1  */
    public Uri insert(Uri uri, ContentValues contentValues) {
        Cursor cursor;
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        int a2 = a(uri, "insert");
        if (a2 == 0) {
            String str = "key='" + contentValues.getAsString("key") + "'";
            try {
                cursor = writableDatabase.query("cache", null, str, null, null, null, null);
                try {
                    if (cursor.getCount() > 0) {
                        int update = update(uri, contentValues, str, null);
                        if (update > 0) {
                            Uri withAppendedId = ContentUris.withAppendedId(uri, (long) update);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return withAppendedId;
                        }
                    } else {
                        long insert = writableDatabase.insert("cache", null, contentValues);
                        if (insert > 0) {
                            getContext().getContentResolver().notifyChange(uri, null);
                            Uri withAppendedId2 = ContentUris.withAppendedId(uri, insert);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return withAppendedId2;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else if (a2 != 5) {
            if (a2 == 6) {
                long insert2 = writableDatabase.insert("data_stat", null, contentValues);
                if (insert2 > 0) {
                    return ContentUris.withAppendedId(uri, insert2);
                }
            } else if (a2 == 7) {
                long insert3 = writableDatabase.insert("travel_info", null, contentValues);
                if (insert3 > 0) {
                    return ContentUris.withAppendedId(uri, insert3);
                }
            }
            return null;
        }
        long insert4 = writableDatabase.insert("no_prompt_bulletin", null, contentValues);
        if (insert4 > 0) {
            return ContentUris.withAppendedId(uri, insert4);
        }
        return null;
    }

    public boolean onCreate() {
        this.b = new b(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = this.b.getReadableDatabase();
        int a2 = a(uri, "query");
        if (a2 == 0) {
            return readableDatabase.query("cache", strArr, str, strArr2, null, null, str2);
        }
        switch (a2) {
            case 2:
                return readableDatabase.query("bank_bin", strArr, str, strArr2, null, null, str2);
            case 3:
                return readableDatabase.query("bank_bin,bank_info", strArr, "bank_bin.bank_name=bank_info.bank_name" + " AND " + str, strArr2, null, null, str2);
            case 4:
                return readableDatabase.query("trans_card_info", strArr, str, strArr2, null, null, str2);
            case 5:
                return readableDatabase.query("no_prompt_bulletin", strArr, str, strArr2, null, null, str2);
            case 6:
                return readableDatabase.query("data_stat", strArr, str, strArr2, null, null, str2);
            case 7:
                return readableDatabase.query("travel_info", strArr, str, strArr2, null, null, str2);
            default:
                return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        if (a(uri, "update") != 0) {
            return 0;
        }
        int update = writableDatabase.update("cache", contentValues, str, strArr);
        if (update > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return update;
    }
}
