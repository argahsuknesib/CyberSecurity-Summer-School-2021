package com.xiaomi.smarthome.download;

import _m_j.frm;
import _m_j.gsy;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DownloadProvider extends ContentProvider {
    private static final UriMatcher O00000Oo;
    private static final String[] O00000o = {"_id", "entity", "_data", "mimetype", "visibility", "destination", "control", "status", "lastmod", "notificationpackage", "notificationclass", "total_bytes", "current_bytes", "title", "description", "uri", "is_visible_in_downloads_ui", "hint", "deleted", "udn"};
    private static final Uri[] O00000o0 = {Downloads.CONTENT_URI, Downloads.ALL_DOWNLOADS_CONTENT_URI};
    private static HashSet<String> O00000oO = new HashSet<>();

    /* renamed from: O000000o  reason: collision with root package name */
    frm f7305O000000o;
    private SQLiteOpenHelper O00000oo = null;

    public final boolean onCreate() {
        return true;
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        O00000Oo = uriMatcher;
        uriMatcher.addURI("com.xiaomi.smarthome.downloads", "my_downloads", 1);
        O00000Oo.addURI("com.xiaomi.smarthome.downloads", "my_downloads/#", 2);
        O00000Oo.addURI("com.xiaomi.smarthome.downloads", "all_downloads", 3);
        O00000Oo.addURI("com.xiaomi.smarthome.downloads", "all_downloads/#", 4);
        O00000Oo.addURI("com.xiaomi.smarthome.downloads", "my_downloads/#/headers", 5);
        O00000Oo.addURI("com.xiaomi.smarthome.downloads", "all_downloads/#/headers", 5);
        int i = 0;
        while (true) {
            String[] strArr = O00000o;
            if (i < strArr.length) {
                O00000oO.add(strArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public StringBuilder f7308O000000o;
        public List<String> O00000Oo;

        private O00000o0() {
            this.f7308O000000o = new StringBuilder();
            this.O00000Oo = new ArrayList();
        }

        /* synthetic */ O00000o0(byte b) {
            this();
        }

        public final <T> void O000000o(String str, T... tArr) {
            if (str != null && str.length() != 0) {
                if (this.f7308O000000o.length() != 0) {
                    this.f7308O000000o.append(" AND ");
                }
                this.f7308O000000o.append("(");
                this.f7308O000000o.append(str);
                this.f7308O000000o.append(")");
                if (tArr != null) {
                    for (T obj : tArr) {
                        this.O00000Oo.add(obj.toString());
                    }
                }
            }
        }

        public final String[] O000000o() {
            return (String[]) this.O00000Oo.toArray(new String[this.O00000Oo.size()]);
        }
    }

    final class O000000o extends SQLiteOpenHelper {
        public O000000o(Context context) {
            super(context, "downloads.db", (SQLiteDatabase.CursorFactory) null, 107);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            gsy.O000000o(2, "DownloadManager", "populating new database");
            onUpgrade(sQLiteDatabase, 0, 107);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
         arg types: [java.lang.String, int]
         candidates:
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
          ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            int i3 = 99;
            if (i == 31) {
                i3 = 100;
            } else if (i < 100) {
                gsy.O000000o(4, "DownloadManager", "Upgrading downloads database from version " + i + " to version " + i2 + ", which will destroy all old data");
            } else if (i > i2) {
                gsy.O000000o(4, "DownloadManager", "Downgrading downloads database from version " + i + " (current version is " + i2 + "), destroying all old data");
            } else {
                i3 = i;
            }
            while (true) {
                i3++;
                if (i3 <= i2) {
                    switch (i3) {
                        case 100:
                            try {
                                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
                                sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, method INTEGER, entity TEXT, no_integrity BOOLEAN, hint TEXT, otaupdate BOOLEAN, _data TEXT, mimetype TEXT, destination INTEGER, no_system BOOLEAN, visibility INTEGER, control INTEGER, status INTEGER, numfailed INTEGER, lastmod BIGINT, notificationpackage TEXT, notificationclass TEXT, notificationextras TEXT, cookiedata TEXT, useragent TEXT, referer TEXT, total_bytes INTEGER, current_bytes INTEGER, etag TEXT, uid INTEGER, otheruid INTEGER, title TEXT, description TEXT); ");
                                break;
                            } catch (SQLException e) {
                                gsy.O000000o(6, "DownloadManager", "couldn't create table in downloads database");
                                throw e;
                            }
                        case 101:
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request_headers");
                            sQLiteDatabase.execSQL("CREATE TABLE request_headers(id INTEGER PRIMARY KEY AUTOINCREMENT,download_id INTEGER NOT NULL,header TEXT NOT NULL,value TEXT NOT NULL);");
                            break;
                        case 102:
                            O000000o(sQLiteDatabase, "downloads", "is_public_api", "INTEGER NOT NULL DEFAULT 0");
                            O000000o(sQLiteDatabase, "downloads", "allow_roaming", "INTEGER NOT NULL DEFAULT 0");
                            O000000o(sQLiteDatabase, "downloads", "allowed_network_types", "INTEGER NOT NULL DEFAULT 0");
                            break;
                        case 103:
                            O000000o(sQLiteDatabase, "downloads", "is_visible_in_downloads_ui", "INTEGER NOT NULL DEFAULT 1");
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_visible_in_downloads_ui", Boolean.FALSE);
                            sQLiteDatabase.update("downloads", contentValues, "destination != 0", null);
                            break;
                        case 104:
                            O000000o(sQLiteDatabase, "downloads", "bypass_recommended_size_limit", "INTEGER NOT NULL DEFAULT 0");
                            break;
                        case 105:
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("current_bytes", (Integer) 0);
                            O000000o(sQLiteDatabase, contentValues2);
                            contentValues2.put("total_bytes", (Integer) -1);
                            O000000o(sQLiteDatabase, contentValues2);
                            contentValues2.put("title", "");
                            O000000o(sQLiteDatabase, contentValues2);
                            contentValues2.put("description", "");
                            O000000o(sQLiteDatabase, contentValues2);
                            break;
                        case 106:
                            O000000o(sQLiteDatabase, "downloads", "deleted", "BOOLEAN NOT NULL DEFAULT 0");
                            break;
                        case 107:
                            O000000o(sQLiteDatabase, "downloads", "udn", "TEXT");
                            break;
                        default:
                            throw new IllegalStateException("Don't know how to upgrade to ".concat(String.valueOf(i3)));
                    }
                } else {
                    return;
                }
            }
        }

        private static void O000000o(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
            sQLiteDatabase.update("downloads", contentValues, ((String) contentValues.valueSet().iterator().next().getKey()) + " is null", null);
            contentValues.clear();
        }

        private static void O000000o(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
            sQLiteDatabase.execSQL("ALTER TABLE " + str + " ADD COLUMN " + str2 + " " + str3);
        }
    }

    private frm O000000o() {
        if (this.f7305O000000o == null) {
            this.f7305O000000o = new RealSystemFacade(getContext());
        }
        return this.f7305O000000o;
    }

    private SQLiteOpenHelper O00000Oo() {
        if (this.O00000oo == null) {
            this.O00000oo = new O000000o(getContext());
        }
        return this.O00000oo;
    }

    public final String getType(Uri uri) {
        int match = O00000Oo.match(uri);
        if (match == 1) {
            return "vnd.android.cursor.dir/download";
        }
        if (match == 2) {
            return "vnd.android.cursor.item/download";
        }
        throw new IllegalArgumentException("Unknown URI: ".concat(String.valueOf(uri)));
    }

    private static void O000000o(ContentValues contentValues, String str, Object... objArr) {
        Object obj = contentValues.get(str);
        contentValues.remove(str);
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj2 = objArr[i];
            if (obj != null || obj2 != null) {
                if (obj == null || !obj.equals(obj2)) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        throw new SecurityException("Invalid value for " + str + ": " + obj);
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Helpers.O000000o(str, O00000oO);
        SQLiteDatabase readableDatabase = O00000Oo().getReadableDatabase();
        int match = O00000Oo.match(uri);
        if (match == -1) {
            throw new IllegalArgumentException("Unknown URI: ".concat(String.valueOf(uri)));
        } else if (match != 5) {
            O00000o0 O000000o2 = O000000o(uri, str, strArr2, match);
            O000000o(strArr, str, strArr2, str2, readableDatabase);
            Cursor query = readableDatabase.query("downloads", strArr, O000000o2.f7308O000000o.toString(), O000000o2.O000000o(), null, null, str2);
            if (query != null) {
                query = new O00000Oo(query);
            }
            if (query != null) {
                query.setNotificationUri(getContext().getContentResolver(), uri);
                gsy.O000000o(2, "DownloadManager", "created cursor " + query + " on behalf of " + Binder.getCallingPid());
            }
            return query;
        } else if (strArr == null && str == null && str2 == null) {
            return new O00000Oo(readableDatabase.query("request_headers", new String[]{"header", "value"}, "download_id=" + O000000o(uri), null, null, null, null));
        } else {
            throw new UnsupportedOperationException("Request header queries do not support projections, selections or sorting");
        }
    }

    private static void O000000o(String[] strArr, String str, String[] strArr2, String str2, SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("starting query, database is ");
        if (sQLiteDatabase != null) {
            sb.append("not ");
        }
        sb.append("null; ");
        if (strArr == null) {
            sb.append("projection is null; ");
        } else if (strArr.length == 0) {
            sb.append("projection is empty; ");
        } else {
            for (int i = 0; i < strArr.length; i++) {
                sb.append("projection[");
                sb.append(i);
                sb.append("] is ");
                sb.append(strArr[i]);
                sb.append("; ");
            }
        }
        sb.append("selection is ");
        sb.append(str);
        sb.append("; ");
        if (strArr2 == null) {
            sb.append("selectionArgs is null; ");
        } else if (strArr2.length == 0) {
            sb.append("selectionArgs is empty; ");
        } else {
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                sb.append("selectionArgs[");
                sb.append(i2);
                sb.append("] is ");
                sb.append(strArr2[i2]);
                sb.append("; ");
            }
        }
        sb.append("sort is ");
        sb.append(str2);
        sb.append(".");
        gsy.O000000o(2, "DownloadManager", sb.toString());
    }

    private static String O000000o(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    private static void O000000o(SQLiteDatabase sQLiteDatabase, long j, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("download_id", Long.valueOf(j));
        for (Map.Entry next : contentValues.valueSet()) {
            if (((String) next.getKey()).startsWith("http_header_")) {
                String obj = next.getValue().toString();
                if (obj.contains(":")) {
                    String[] split = obj.split(":", 2);
                    contentValues2.put("header", split[0].trim());
                    contentValues2.put("value", split[1].trim());
                    sQLiteDatabase.insert("request_headers", null, contentValues2);
                } else {
                    throw new IllegalArgumentException("Invalid HTTP header line: ".concat(String.valueOf(obj)));
                }
            }
        }
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Uri uri2 = uri;
        ContentValues contentValues2 = contentValues;
        String str2 = str;
        Helpers.O000000o(str2, O00000oO);
        SQLiteDatabase writableDatabase = O00000Oo().getWritableDatabase();
        int i = 0;
        boolean z = contentValues2.containsKey("deleted") && contentValues2.getAsInteger("deleted").intValue() == 1;
        if (Binder.getCallingPid() != Process.myPid()) {
            ContentValues contentValues3 = new ContentValues();
            O00000o0("entity", contentValues2, contentValues3);
            O000000o("visibility", contentValues2, contentValues3);
            Integer asInteger = contentValues2.getAsInteger("control");
            if (asInteger != null) {
                contentValues3.put("control", asInteger);
                z = true;
            }
            O000000o("control", contentValues2, contentValues3);
            O00000o0("title", contentValues2, contentValues3);
            O00000o0("description", contentValues2, contentValues3);
            O000000o("deleted", contentValues2, contentValues3);
            contentValues2 = contentValues3;
        } else {
            String asString = contentValues2.getAsString("_data");
            if (asString != null) {
                Cursor query = query(uri, new String[]{"title"}, null, null, null);
                if (!query.moveToFirst() || query.getString(0).length() == 0) {
                    contentValues2.put("title", new File(asString).getName());
                }
                query.close();
            }
            Integer asInteger2 = contentValues2.getAsInteger("status");
            boolean z2 = asInteger2 != null && asInteger2.intValue() == 190;
            boolean containsKey = contentValues2.containsKey("bypass_recommended_size_limit");
            if (z2 || containsKey) {
                z = true;
            }
        }
        int match = O00000Oo.match(uri2);
        if (match == 1 || match == 2 || match == 3 || match == 4) {
            O00000o0 O000000o2 = O000000o(uri2, str2, strArr, match);
            if (contentValues2.size() > 0) {
                i = writableDatabase.update("downloads", contentValues2, O000000o2.f7308O000000o.toString(), O000000o2.O000000o());
            }
            O000000o(uri2, match);
            if (z) {
                Context context = getContext();
                context.startService(new Intent(context, DownloadService.class));
            }
            return i;
        }
        gsy.O000000o(3, "DownloadManager", "updating unknown/invalid URI: ".concat(String.valueOf(uri)));
        throw new UnsupportedOperationException("Cannot update URI: ".concat(String.valueOf(uri)));
    }

    private void O000000o(Uri uri, int i) {
        Long valueOf = (i == 2 || i == 4) ? Long.valueOf(Long.parseLong(O000000o(uri))) : null;
        for (Uri uri2 : O00000o0) {
            if (valueOf != null) {
                uri2 = ContentUris.withAppendedId(uri2, valueOf.longValue());
            }
            getContext().getContentResolver().notifyChange(uri2, null);
        }
    }

    private O00000o0 O000000o(Uri uri, String str, String[] strArr, int i) {
        O00000o0 o00000o0 = new O00000o0((byte) 0);
        o00000o0.O000000o(str, strArr);
        if (i == 2 || i == 4) {
            o00000o0.O000000o("_id = ?", O000000o(uri));
        }
        if ((i == 1 || i == 2) && getContext().checkCallingPermission("com.xiaomi.smarthome.permission.ACCESS_ALL_DOWNLOADS") != 0) {
            o00000o0.O000000o("uid= ? OR otheruid= ?", Integer.valueOf(Binder.getCallingUid()), Integer.valueOf(Binder.getCallingPid()));
        }
        return o00000o0;
    }

    /* JADX INFO: finally extract failed */
    public final int delete(Uri uri, String str, String[] strArr) {
        Helpers.O000000o(str, O00000oO);
        SQLiteDatabase writableDatabase = O00000Oo().getWritableDatabase();
        int match = O00000Oo.match(uri);
        if (match == 1 || match == 2 || match == 3 || match == 4) {
            O00000o0 O000000o2 = O000000o(uri, str, strArr, match);
            SQLiteDatabase sQLiteDatabase = writableDatabase;
            Cursor query = sQLiteDatabase.query("downloads", new String[]{"_id"}, O000000o2.f7308O000000o.toString(), O000000o2.O000000o(), null, null, null, null);
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    writableDatabase.delete("request_headers", "download_id=".concat(String.valueOf(query.getLong(0))), null);
                    query.moveToNext();
                }
                query.close();
                int delete = writableDatabase.delete("downloads", O000000o2.f7308O000000o.toString(), O000000o2.O000000o());
                O000000o(uri, match);
                return delete;
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        } else {
            gsy.O000000o(3, "DownloadManager", "deleting unknown/invalid URI: ".concat(String.valueOf(uri)));
            throw new UnsupportedOperationException("Cannot delete URI: ".concat(String.valueOf(uri)));
        }
    }

    private static final void O000000o(String str, ContentValues contentValues, ContentValues contentValues2) {
        Integer asInteger = contentValues.getAsInteger(str);
        if (asInteger != null) {
            contentValues2.put(str, asInteger);
        }
    }

    private static final void O00000Oo(String str, ContentValues contentValues, ContentValues contentValues2) {
        Boolean asBoolean = contentValues.getAsBoolean(str);
        if (asBoolean != null) {
            contentValues2.put(str, asBoolean);
        }
    }

    private static final void O00000o0(String str, ContentValues contentValues, ContentValues contentValues2) {
        String asString = contentValues.getAsString(str);
        if (asString != null) {
            contentValues2.put(str, asString);
        }
    }

    private static final void O000000o(String str, ContentValues contentValues, ContentValues contentValues2, String str2) {
        O00000o0(str, contentValues, contentValues2);
        if (!contentValues2.containsKey(str)) {
            contentValues2.put(str, str2);
        }
    }

    class O00000Oo extends CursorWrapper implements CrossProcessCursor {
        private CrossProcessCursor O00000Oo;

        public O00000Oo(Cursor cursor) {
            super(cursor);
            this.O00000Oo = (CrossProcessCursor) cursor;
        }

        public final void fillWindow(int i, CursorWindow cursorWindow) {
            this.O00000Oo.fillWindow(i, cursorWindow);
        }

        public final CursorWindow getWindow() {
            return this.O00000Oo.getWindow();
        }

        public final boolean onMove(int i, int i2) {
            return this.O00000Oo.onMove(i, i2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public final Uri insert(Uri uri, ContentValues contentValues) {
        String str;
        SQLiteDatabase sQLiteDatabase;
        int i;
        boolean z;
        int i2;
        Uri uri2 = uri;
        ContentValues contentValues2 = contentValues;
        if (getContext().checkCallingOrSelfPermission("com.xiaomi.smarthome.permission.ACCESS_DOWNLOAD_MANAGER") != 0) {
            getContext().enforceCallingOrSelfPermission("android.permission.INTERNET", "INTERNET permission is required to use the download manager");
            ContentValues contentValues3 = new ContentValues(contentValues2);
            O000000o(contentValues3, "is_public_api", Boolean.TRUE);
            O000000o(contentValues3, "destination", 4);
            if (getContext().checkCallingOrSelfPermission("com.xiaomi.smarthome.permission.DOWNLOAD_WITHOUT_NOTIFICATION") == 0) {
                O000000o(contentValues3, "visibility", 2, 0);
            } else {
                O000000o(contentValues3, "visibility", 0);
            }
            contentValues3.remove("uri");
            contentValues3.remove("title");
            contentValues3.remove("description");
            contentValues3.remove("mimetype");
            contentValues3.remove("hint");
            contentValues3.remove("notificationpackage");
            contentValues3.remove("allowed_network_types");
            contentValues3.remove("allow_roaming");
            contentValues3.remove("is_visible_in_downloads_ui");
            Iterator<Map.Entry<String, Object>> it = contentValues3.valueSet().iterator();
            while (it.hasNext()) {
                if (((String) it.next().getKey()).startsWith("http_header_")) {
                    it.remove();
                }
            }
            if (contentValues3.size() > 0) {
                StringBuilder sb = new StringBuilder("Invalid columns in request: ");
                for (Map.Entry<String, Object> key : contentValues3.valueSet()) {
                    sb.append((String) key.getKey());
                }
                throw new SecurityException(sb.toString());
            }
        }
        SQLiteDatabase writableDatabase = O00000Oo().getWritableDatabase();
        int match = O00000Oo.match(uri2);
        if (match == 1) {
            ContentValues contentValues4 = new ContentValues();
            O00000o0("uri", contentValues2, contentValues4);
            O00000o0("entity", contentValues2, contentValues4);
            O00000Oo("no_integrity", contentValues2, contentValues4);
            O00000o0("hint", contentValues2, contentValues4);
            O00000o0("mimetype", contentValues2, contentValues4);
            O00000Oo("is_public_api", contentValues2, contentValues4);
            boolean z2 = contentValues2.getAsBoolean("is_public_api") == Boolean.TRUE;
            Integer asInteger = contentValues2.getAsInteger("destination");
            if (asInteger != null) {
                if (getContext().checkCallingPermission("com.xiaomi.smarthome.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED") == 0 || asInteger.intValue() == 0) {
                    i2 = 4;
                } else {
                    i2 = 4;
                    if (asInteger.intValue() != 4) {
                        throw new SecurityException("unauthorized destination code");
                    }
                }
                if (asInteger.intValue() == i2) {
                    i = match;
                    sQLiteDatabase = writableDatabase;
                    str = "DownloadManager";
                    getContext().enforcePermission("android.permission.WRITE_EXTERNAL_STORAGE", Binder.getCallingPid(), Binder.getCallingUid(), "need WRITE_EXTERNAL_STORAGE permission to use DESTINATION_FILE_URI");
                    String asString = contentValues2.getAsString("hint");
                    if (asString != null) {
                        Uri parse = Uri.parse(asString);
                        String scheme = parse.getScheme();
                        if (scheme == null || !scheme.equals("file")) {
                            throw new IllegalArgumentException("Not a file URI: ".concat(String.valueOf(parse)));
                        }
                        String path = parse.getPath();
                        if (path == null) {
                            throw new IllegalArgumentException("Invalid file URI: ".concat(String.valueOf(parse)));
                        } else if (!path.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath())) {
                            throw new SecurityException("Destination must be on external storage: ".concat(String.valueOf(parse)));
                        }
                    } else {
                        throw new IllegalArgumentException("DESTINATION_FILE_URI must include a file URI under COLUMN_FILE_NAME_HINT");
                    }
                } else {
                    sQLiteDatabase = writableDatabase;
                    i = match;
                    str = "DownloadManager";
                }
                contentValues4.put("destination", asInteger);
            } else {
                sQLiteDatabase = writableDatabase;
                i = match;
                str = "DownloadManager";
            }
            Integer asInteger2 = contentValues2.getAsInteger("visibility");
            if (asInteger2 != null) {
                z = true;
                contentValues4.put("visibility", asInteger2);
            } else if (asInteger.intValue() == 0) {
                z = true;
                contentValues4.put("visibility", (Integer) 1);
            } else {
                z = true;
                contentValues4.put("visibility", (Integer) 2);
            }
            O000000o("control", contentValues2, contentValues4);
            contentValues4.put("status", (Integer) 190);
            contentValues4.put("lastmod", Long.valueOf(O000000o().O000000o()));
            String asString2 = contentValues2.getAsString("notificationpackage");
            String asString3 = contentValues2.getAsString("notificationclass");
            if (asString2 != null && (asString3 != null || z2)) {
                int callingUid = Binder.getCallingUid();
                if (callingUid != 0) {
                    try {
                        if (O000000o().O000000o(callingUid, asString2)) {
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                contentValues4.put("notificationpackage", asString2);
                if (asString3 != null) {
                    contentValues4.put("notificationclass", asString3);
                }
            }
            O00000o0("notificationextras", contentValues2, contentValues4);
            O00000o0("cookiedata", contentValues2, contentValues4);
            O00000o0("useragent", contentValues2, contentValues4);
            O00000o0("referer", contentValues2, contentValues4);
            if (getContext().checkCallingPermission("com.xiaomi.smarthome.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED") == 0) {
                O000000o("otheruid", contentValues2, contentValues4);
            }
            contentValues4.put("uid", Integer.valueOf(Binder.getCallingUid()));
            if (Binder.getCallingUid() == 0) {
                O000000o("uid", contentValues2, contentValues4);
            }
            O000000o("title", contentValues2, contentValues4, "");
            O000000o("description", contentValues2, contentValues4, "");
            contentValues4.put("total_bytes", (Integer) -1);
            contentValues4.put("current_bytes", (Integer) 0);
            if (contentValues2.containsKey("is_visible_in_downloads_ui")) {
                O00000Oo("is_visible_in_downloads_ui", contentValues2, contentValues4);
            } else {
                if (!(asInteger == null || asInteger.intValue() == 0)) {
                    z = false;
                }
                contentValues4.put("is_visible_in_downloads_ui", Boolean.valueOf(z));
            }
            if (z2) {
                O000000o("allowed_network_types", contentValues2, contentValues4);
                O00000Oo("allow_roaming", contentValues2, contentValues4);
            }
            O00000o0("udn", contentValues2, contentValues4);
            String str2 = str;
            gsy.O000000o(2, str2, "initiating download with UID " + contentValues4.getAsInteger("uid"));
            if (contentValues4.containsKey("otheruid")) {
                gsy.O000000o(2, str2, "other UID " + contentValues4.getAsInteger("otheruid"));
            }
            Context context = getContext();
            context.startService(new Intent(context, DownloadService.class));
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            long insert = sQLiteDatabase2.insert("downloads", null, contentValues4);
            if (insert == -1) {
                gsy.O000000o(3, str2, "couldn't insert into downloads database");
                return null;
            }
            O000000o(sQLiteDatabase2, insert, contentValues2);
            context.startService(new Intent(context, DownloadService.class));
            O000000o(uri, i);
            return ContentUris.withAppendedId(Downloads.CONTENT_URI, insert);
        }
        gsy.O000000o(3, "DownloadManager", "calling insert on an unknown/invalid URI: ".concat(String.valueOf(uri)));
        throw new IllegalArgumentException("Unknown/Invalid URI ".concat(String.valueOf(uri)));
    }

    public final ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int i;
        gsy.O000000o(2, "DownloadManager", "openFile uri: " + uri + ", mode: " + str + ", uid: " + Binder.getCallingUid());
        Cursor query = query(Downloads.CONTENT_URI, new String[]{"_id"}, null, null, "_id");
        if (query == null) {
            gsy.O000000o(2, "DownloadManager", "null cursor in openFile");
        } else {
            if (!query.moveToFirst()) {
                gsy.O000000o(2, "DownloadManager", "empty cursor in openFile");
            } else {
                do {
                    gsy.O000000o(2, "DownloadManager", "row " + query.getInt(0) + " available");
                } while (query.moveToNext());
            }
            query.close();
        }
        Cursor query2 = query(uri, new String[]{"_data"}, null, null, null);
        if (query2 == null) {
            gsy.O000000o(2, "DownloadManager", "null cursor in openFile");
        } else {
            if (!query2.moveToFirst()) {
                gsy.O000000o(2, "DownloadManager", "empty cursor in openFile");
            } else {
                String string = query2.getString(0);
                gsy.O000000o(2, "DownloadManager", "filename in openFile: ".concat(String.valueOf(string)));
                if (new File(string).isFile()) {
                    gsy.O000000o(2, "DownloadManager", "file exists in openFile");
                }
            }
            query2.close();
        }
        Cursor query3 = query(uri, new String[]{"_data"}, null, null, null);
        if (query3 != null) {
            try {
                i = query3.getCount();
            } catch (Throwable th) {
                if (query3 != null) {
                    query3.close();
                }
                throw th;
            }
        } else {
            i = 0;
        }
        if (i == 1) {
            query3.moveToFirst();
            String string2 = query3.getString(0);
            if (query3 != null) {
                query3.close();
            }
            if (string2 == null) {
                throw new FileNotFoundException("No filename found.");
            } else if (!Helpers.O00000Oo(string2)) {
                throw new FileNotFoundException("Invalid filename.");
            } else if ("r".equals(str)) {
                ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(string2), 268435456);
                if (open != null) {
                    return open;
                }
                throw new FileNotFoundException("couldn't open file");
            } else {
                throw new FileNotFoundException("Bad mode for " + uri + ": " + str);
            }
        } else if (i == 0) {
            throw new FileNotFoundException("No entry for ".concat(String.valueOf(uri)));
        } else {
            throw new FileNotFoundException("Multiple items at ".concat(String.valueOf(uri)));
        }
    }
}
