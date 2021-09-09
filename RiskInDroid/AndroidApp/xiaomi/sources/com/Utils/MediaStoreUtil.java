package com.Utils;

import _m_j.gsc;
import _m_j.gsy;
import _m_j.gtb;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public final class MediaStoreUtil {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f3110O000000o = {"application/pdf", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "text/text", "text/html", "text/xml", "image/jpeg", "image/png", "image/bmp", "image/gif"};
    private static final String O00000Oo = Environment.DIRECTORY_DCIM;
    private static Set<String> O00000o0 = new HashSet(Arrays.asList(f3110O000000o));

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f3111O000000o;
        public String O00000Oo;
        public O00000Oo O00000o;
        public int O00000o0;
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f3112O000000o;
        public String O00000Oo;
        public int O00000o;
        public String O00000o0;
        public int O00000oO;
        public int O00000oo;
        public int O0000O0o;
        public int O0000OOo;
        public int O0000Oo;
        public String O0000Oo0;
        public String O0000OoO;
        public String O0000Ooo;
    }

    public static class AccessMediaError extends RuntimeException {
        private int mErrorCode;

        public AccessMediaError(int i) {
            this(i, "");
        }

        public AccessMediaError(int i, String str) {
            super(str);
            this.mErrorCode = i;
        }

        public AccessMediaError(int i, Throwable th) {
            super(th);
            this.mErrorCode = i;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }

    private static O00000Oo O00000o0(String str) throws AccessMediaError {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.O00000o = options.outWidth;
            o00000Oo.O00000oO = options.outHeight;
            o00000Oo.O00000o0 = options.outMimeType;
            return o00000Oo;
        } catch (Throwable th) {
            throw new AccessMediaError(-6, th);
        }
    }

    private static O00000Oo O00000o(String str) {
        try {
            O00000Oo o00000Oo = new O00000Oo();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            o00000Oo.O00000o = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            o00000Oo.O00000oO = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            o00000Oo.O00000o0 = mediaMetadataRetriever.extractMetadata(12);
            o00000Oo.O0000OOo = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            mediaMetadataRetriever.release();
            return o00000Oo;
        } catch (Throwable th) {
            throw new AccessMediaError(-7, th);
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
    public static void O000000o(Context context, String str, String str2, String str3) throws AccessMediaError {
        if (TextUtils.isEmpty(str)) {
            throw new AccessMediaError(-1);
        } else if (new File(str).exists()) {
            if (context == null) {
                context = CommonApplication.getAppContext();
            }
            O00000Oo O00000o02 = O00000o0(str);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            contentValues.put("width", Integer.valueOf(O00000o02.O00000o));
            contentValues.put("height", Integer.valueOf(O00000o02.O00000oO));
            contentValues.put("mime_type", O00000o02.O00000o0);
            contentValues.put("_display_name", str3);
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            if (Build.VERSION.SDK_INT >= 29) {
                if (!TextUtils.isEmpty(str2)) {
                    contentValues.put("relative_path", O00000Oo + File.separator + str2);
                }
                contentValues.put("is_pending", (Integer) 1);
                contentValues.put("date_expires", Long.valueOf((System.currentTimeMillis() + 86400000) / 1000));
            } else if (!TextUtils.isEmpty(str2)) {
                File file = new File(Environment.getExternalStoragePublicDirectory(O00000Oo), str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                contentValues.put("_data", new File(file, str3).getAbsolutePath());
            }
            try {
                Uri insert = contentResolver.insert(uri, contentValues);
                if (insert != null) {
                    try {
                        gsc.O000000o(new FileInputStream(str), contentResolver.openOutputStream(insert));
                        if (Build.VERSION.SDK_INT >= 29) {
                            contentValues.put("is_pending", (Integer) 0);
                            contentValues.putNull("date_expires");
                            contentResolver.update(insert, contentValues, null, null);
                        }
                    } catch (IOException e) {
                        contentResolver.delete(insert, null, null);
                        gsy.O000000o(6, "MediaStoreUtil", "insertImage error:" + Log.getStackTraceString(e));
                        throw new AccessMediaError(-2);
                    }
                } else {
                    gsy.O000000o(6, "MediaStoreUtil", "insertImage error,pendingUri=null");
                    throw new AccessMediaError(-3);
                }
            } catch (Exception e2) {
                gsy.O000000o(6, "MediaStoreUtil", "insertImage error,resolver.insert exception:" + e2.getMessage());
                throw new AccessMediaError(-3);
            }
        } else {
            throw new AccessMediaError(-1);
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
    public static void O00000Oo(Context context, String str, String str2, String str3) throws AccessMediaError {
        if (TextUtils.isEmpty(str)) {
            throw new AccessMediaError(-1);
        } else if (new File(str).exists()) {
            if (context == null) {
                context = CommonApplication.getAppContext();
            }
            O00000Oo O00000o = O00000o(str);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            contentValues.put("width", Integer.valueOf(O00000o.O00000o));
            contentValues.put("height", Integer.valueOf(O00000o.O00000oO));
            contentValues.put("mime_type", O00000o.O00000o0);
            contentValues.put("duration", Integer.valueOf(O00000o.O0000OOo));
            contentValues.put("_display_name", str3);
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            if (Build.VERSION.SDK_INT >= 29) {
                if (!TextUtils.isEmpty(str2)) {
                    contentValues.put("relative_path", O00000Oo + File.separator + str2);
                }
                contentValues.put("is_pending", (Integer) 1);
                contentValues.put("date_expires", Long.valueOf((System.currentTimeMillis() + 86400000) / 1000));
            } else if (!TextUtils.isEmpty(str2)) {
                File file = new File(Environment.getExternalStoragePublicDirectory(O00000Oo), str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                contentValues.put("_data", new File(file, str3).getAbsolutePath());
            }
            try {
                Uri insert = contentResolver.insert(uri, contentValues);
                if (insert != null) {
                    try {
                        gsc.O000000o(new FileInputStream(str), contentResolver.openOutputStream(insert));
                        if (Build.VERSION.SDK_INT >= 29) {
                            contentValues.put("is_pending", (Integer) 0);
                            contentValues.putNull("date_expires");
                            contentResolver.update(insert, contentValues, null, null);
                        }
                    } catch (IOException unused) {
                        contentResolver.delete(insert, null, null);
                        throw new AccessMediaError(-2);
                    }
                } else {
                    gsy.O000000o(6, "MediaStoreUtil", "insertVideo error,pendingUri=null");
                    throw new AccessMediaError(-3);
                }
            } catch (Exception e) {
                gsy.O000000o(6, "MediaStoreUtil", "insertVideo error,resolver.insert exception:" + e.getMessage());
                throw new AccessMediaError(-3);
            }
        } else {
            throw new AccessMediaError(-1);
        }
    }

    public static List<O00000Oo> O000000o(Context context, String str) throws AccessMediaError {
        String str2;
        String[] strArr;
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                context = CommonApplication.getAppContext();
            }
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String[] strArr2 = {"_id", "_data", "mime_type", "width", "height", "datetaken", "date_modified"};
            if (Build.VERSION.SDK_INT >= 29) {
                strArr = new String[]{O00000Oo + File.separator + str + "/%"};
                str2 = "relative_path like ?";
            } else {
                File file = new File(Environment.getExternalStoragePublicDirectory(O00000Oo), str);
                strArr = new String[]{file.getAbsolutePath() + "/%"};
                str2 = "_data LIKE ? ";
            }
            String[] strArr3 = strArr;
            Cursor query = contentResolver.query(uri, strArr2, str2, strArr3, "date_added DESC");
            if (query != null) {
                int columnIndex = query.getColumnIndex("_id");
                query.getColumnIndex("_data");
                int columnIndex2 = query.getColumnIndex("mime_type");
                int columnIndex3 = query.getColumnIndex("width");
                int columnIndex4 = query.getColumnIndex("height");
                int columnIndex5 = query.getColumnIndex("datetaken");
                int columnIndex6 = query.getColumnIndex("date_modified");
                ArrayList arrayList = new ArrayList();
                while (query.moveToNext()) {
                    O00000Oo o00000Oo = new O00000Oo();
                    o00000Oo.f3112O000000o = query.getInt(columnIndex);
                    int i = Build.VERSION.SDK_INT;
                    o00000Oo.O00000Oo = ContentUris.withAppendedId(uri, (long) o00000Oo.f3112O000000o).toString();
                    o00000Oo.O00000o0 = query.getString(columnIndex2);
                    o00000Oo.O00000o = query.getInt(columnIndex3);
                    o00000Oo.O00000oO = query.getInt(columnIndex4);
                    o00000Oo.O00000oo = O000000o(query, columnIndex5);
                    o00000Oo.O0000O0o = query.getInt(columnIndex6);
                    arrayList.add(o00000Oo);
                }
                query.close();
                return arrayList;
            }
            throw new AccessMediaError(-4);
        }
        throw new AccessMediaError(-5);
    }

    public static List<O00000Oo> O00000Oo(Context context, String str) throws AccessMediaError {
        String str2;
        String[] strArr;
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                context = CommonApplication.getAppContext();
            }
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            String[] strArr2 = {"_id", "_data", "mime_type", "width", "height", "datetaken", "date_modified", "duration"};
            if (Build.VERSION.SDK_INT >= 29) {
                strArr = new String[]{O00000Oo + File.separator + str + "/%"};
                str2 = "relative_path LIKE ? ";
            } else {
                File file = new File(Environment.getExternalStoragePublicDirectory(O00000Oo), str);
                strArr = new String[]{file.getAbsolutePath() + "/%"};
                str2 = "_data LIKE ? ";
            }
            String[] strArr3 = strArr;
            Cursor query = contentResolver.query(uri, strArr2, str2, strArr3, "date_added DESC");
            if (query != null) {
                int columnIndex = query.getColumnIndex("_id");
                query.getColumnIndex("_data");
                int columnIndex2 = query.getColumnIndex("mime_type");
                int columnIndex3 = query.getColumnIndex("width");
                int columnIndex4 = query.getColumnIndex("height");
                int columnIndex5 = query.getColumnIndex("datetaken");
                int columnIndex6 = query.getColumnIndex("date_modified");
                int columnIndex7 = query.getColumnIndex("duration");
                ArrayList arrayList = new ArrayList();
                while (query.moveToNext()) {
                    O00000Oo o00000Oo = new O00000Oo();
                    o00000Oo.f3112O000000o = query.getInt(columnIndex);
                    int i = Build.VERSION.SDK_INT;
                    o00000Oo.O00000Oo = ContentUris.withAppendedId(uri, (long) o00000Oo.f3112O000000o).toString();
                    o00000Oo.O00000o0 = query.getString(columnIndex2);
                    o00000Oo.O00000o = query.getInt(columnIndex3);
                    o00000Oo.O00000oO = query.getInt(columnIndex4);
                    o00000Oo.O00000oo = O000000o(query, columnIndex5);
                    o00000Oo.O0000O0o = query.getInt(columnIndex6);
                    o00000Oo.O0000OOo = query.getInt(columnIndex7);
                    arrayList.add(o00000Oo);
                }
                query.close();
                return arrayList;
            }
            throw new AccessMediaError(-4);
        }
        throw new AccessMediaError(-5);
    }

    public static List<O000000o> O000000o(Context context) throws AccessMediaError {
        int i;
        int i2;
        int i3;
        Cursor query = (context == null ? CommonApplication.getAppContext() : context).getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id", "_data", "_display_name", "date_modified", "mime_type", "width", "height", "_size", "duration", "datetaken", "bucket_id", "bucket_display_name"}, "(media_type=? OR media_type=?) AND _size>0", new String[]{"1", "3"}, "date_modified DESC");
        if (query != null) {
            int columnIndex = query.getColumnIndex("_id");
            int columnIndex2 = query.getColumnIndex("_data");
            int columnIndex3 = query.getColumnIndex("mime_type");
            int columnIndex4 = query.getColumnIndex("width");
            int columnIndex5 = query.getColumnIndex("height");
            int columnIndex6 = query.getColumnIndex("datetaken");
            int columnIndex7 = query.getColumnIndex("date_modified");
            int columnIndex8 = query.getColumnIndex("duration");
            int columnIndex9 = query.getColumnIndex("bucket_id");
            int columnIndex10 = query.getColumnIndex("bucket_display_name");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (query.moveToNext()) {
                String string = query.getString(columnIndex2);
                String string2 = query.getString(columnIndex3);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    File file = new File(string);
                    if (file.exists() && file.isFile()) {
                        String string3 = query.getString(columnIndex9);
                        if (!TextUtils.isEmpty(string3)) {
                            O000000o o000000o = (O000000o) linkedHashMap.get(string3);
                            if (o000000o == null) {
                                o000000o = new O000000o();
                                String string4 = query.getString(columnIndex10);
                                o000000o.f3111O000000o = string3;
                                o000000o.O00000Oo = string4;
                                linkedHashMap.put(string3, o000000o);
                            }
                            o000000o.O00000o0++;
                            O00000Oo o00000Oo = o000000o.O00000o;
                            int i4 = query.getInt(columnIndex7);
                            if (o00000Oo == null || i4 > o00000Oo.O0000O0o) {
                                O00000Oo o00000Oo2 = new O00000Oo();
                                o00000Oo2.f3112O000000o = query.getInt(columnIndex);
                                o00000Oo2.O00000o0 = query.getString(columnIndex3);
                                i = columnIndex;
                                i3 = columnIndex2;
                                i2 = columnIndex3;
                                o00000Oo2.O00000Oo = ContentUris.withAppendedId(o00000Oo2.O00000o0.contains("video") ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (long) o00000Oo2.f3112O000000o).toString();
                                o00000Oo2.O00000o = query.getInt(columnIndex4);
                                o00000Oo2.O00000oO = query.getInt(columnIndex5);
                                o00000Oo2.O00000oo = O000000o(query, columnIndex6);
                                o00000Oo2.O0000O0o = i4;
                                o00000Oo2.O0000OOo = query.getInt(columnIndex8);
                                o000000o.O00000o = o00000Oo2;
                            } else {
                                i = columnIndex;
                                i3 = columnIndex2;
                                i2 = columnIndex3;
                            }
                            columnIndex = i;
                            columnIndex2 = i3;
                            columnIndex3 = i2;
                        }
                    }
                }
            }
            query.close();
            return new ArrayList(linkedHashMap.values());
        }
        throw new AccessMediaError(-4);
    }

    public static List<O00000Oo> O00000o0(Context context, String str) throws AccessMediaError {
        if (!TextUtils.isEmpty(str)) {
            Cursor query = (context == null ? CommonApplication.getAppContext() : context).getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id", "_data", "_display_name", "date_modified", "mime_type", "width", "height", "_size", "duration", "datetaken"}, "(media_type=? OR media_type=?) AND _size>0 AND bucket_id=?", new String[]{"1", "3", str}, "date_modified DESC");
            if (query != null) {
                int columnIndex = query.getColumnIndex("_id");
                int columnIndex2 = query.getColumnIndex("_data");
                int columnIndex3 = query.getColumnIndex("mime_type");
                int columnIndex4 = query.getColumnIndex("width");
                int columnIndex5 = query.getColumnIndex("height");
                int columnIndex6 = query.getColumnIndex("datetaken");
                int columnIndex7 = query.getColumnIndex("date_modified");
                int columnIndex8 = query.getColumnIndex("duration");
                ArrayList arrayList = new ArrayList();
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex2);
                    String string2 = query.getString(columnIndex3);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        File file = new File(string);
                        if (file.exists() && file.isFile()) {
                            O00000Oo o00000Oo = new O00000Oo();
                            o00000Oo.f3112O000000o = query.getInt(columnIndex);
                            o00000Oo.O00000o0 = query.getString(columnIndex3);
                            o00000Oo.O00000Oo = ContentUris.withAppendedId(o00000Oo.O00000o0.contains("video") ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (long) o00000Oo.f3112O000000o).toString();
                            o00000Oo.O00000o = query.getInt(columnIndex4);
                            o00000Oo.O00000oO = query.getInt(columnIndex5);
                            o00000Oo.O00000oo = O000000o(query, columnIndex6);
                            o00000Oo.O0000O0o = query.getInt(columnIndex7);
                            o00000Oo.O0000OOo = query.getInt(columnIndex8);
                            arrayList.add(o00000Oo);
                        }
                    }
                }
                query.close();
                return arrayList;
            }
            throw new AccessMediaError(-4);
        }
        throw new AccessMediaError(-5);
    }

    private static int O000000o(Cursor cursor, int i) {
        if (cursor == null) {
            return ((int) new Date().getTime()) / 1000;
        }
        long j = cursor.getLong(i);
        int i2 = (int) j;
        if (j == ((long) i2)) {
            return i2;
        }
        return (int) (j / 1000);
    }

    public static int O00000o(Context context, String str) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                context = CommonApplication.getAppContext();
            }
            if ("content".equals(Uri.parse(str).getScheme())) {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    if (context == null) {
                        context = CommonApplication.getAppContext();
                    }
                    ContentResolver contentResolver = context.getContentResolver();
                    int delete = contentResolver.delete(parse, null, null);
                    contentResolver.notifyChange(parse, null);
                    return delete;
                }
                throw new AccessMediaError(-1);
            }
            ContentResolver contentResolver2 = context.getContentResolver();
            String[] strArr = {str};
            if (O00000oO(str)) {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if (O00000oo(str)) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                throw new AccessMediaError(-8);
            }
            int delete2 = contentResolver2.delete(uri, "_data= ? ", strArr);
            contentResolver2.notifyChange(uri, null);
            return delete2;
        }
        throw new AccessMediaError(-1);
    }

    public static void O000000o(Context context, Uri uri, int i) {
        context.getContentResolver().takePersistableUriPermission(uri, i);
    }

    private static boolean O00000oO(String str) {
        try {
            O00000Oo O00000o02 = O00000o0(str);
            if (TextUtils.isEmpty(O00000o02.O00000o0) || !O00000o02.O00000o0.startsWith("image/")) {
                return false;
            }
            return true;
        } catch (AccessMediaError e) {
            gsy.O000000o(5, "MediaStoreUtil", Log.getStackTraceString(e));
            return false;
        }
    }

    private static boolean O00000oo(String str) {
        try {
            O00000Oo O00000o = O00000o(str);
            if (TextUtils.isEmpty(O00000o.O00000o0) || !O00000o.O00000o0.startsWith("video/")) {
                return false;
            }
            return true;
        } catch (AccessMediaError e) {
            gsy.O000000o(5, "MediaStoreUtil", Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {Environment.DIRECTORY_MUSIC, Environment.DIRECTORY_PICTURES, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_DOWNLOADS, Environment.DIRECTORY_DCIM};
        for (int i = 0; i < 5; i++) {
            if (str.startsWith(Environment.getExternalStoragePublicDirectory(strArr[i]).getAbsolutePath())) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("content://")) {
            return true;
        }
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        File externalCacheDir = CommonApplication.getAppContext().getExternalCacheDir();
        if (externalCacheDir == null || TextUtils.isEmpty(externalCacheDir.getParent()) || !str.startsWith(externalCacheDir.getParent())) {
            return O000000o(str);
        }
        return true;
    }

    public static String[] O000000o(List<String> list) {
        boolean z;
        if (list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (TextUtils.isEmpty(next)) {
                z = false;
            } else {
                z = O00000o0.contains(next);
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static List<O00000Oo> O000000o(Context context, String[] strArr, int i, int i2) {
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        if (strArr == null || strArr.length == 0) {
            return new ArrayList();
        }
        if (context == null) {
            context = CommonApplication.getAppContext();
        }
        Uri contentUri = MediaStore.Files.getContentUri("external");
        if (Build.VERSION.SDK_INT >= 29) {
            String[] strArr4 = {"_id", "relative_path", "mime_type", "date_modified", "_size", "title", "_display_name"};
            StringBuilder sb = new StringBuilder();
            sb.append("mime_type IN ( ");
            for (int i3 = 0; i3 < strArr.length; i3++) {
                sb.append("?");
                if (i3 < strArr.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            strArr3 = strArr;
            strArr2 = strArr4;
            str = sb.toString();
        } else {
            String[] strArr5 = {"_id", "_data", "mime_type", "date_modified", "_size", "title", "_display_name"};
            String[] O000000o2 = O000000o(strArr);
            StringBuilder sb2 = new StringBuilder();
            strArr3 = new String[O000000o2.length];
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!TextUtils.isEmpty(O000000o2[i4])) {
                    sb2.append("_data LIKE ? ");
                    if (i4 < strArr.length - 1) {
                        sb2.append(" or ");
                    }
                    strArr3[i4] = "%." + O000000o2[i4];
                }
            }
            str = sb2.toString();
            strArr2 = strArr5;
        }
        if (i > 0) {
            str2 = "date_added DESC" + String.format(" LIMIT %d OFFSET %d", Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            str2 = "date_added DESC";
        }
        Cursor query = context.getContentResolver().query(contentUri, strArr2, str, strArr3, str2);
        int columnIndex = query.getColumnIndex("_id");
        int columnIndex2 = query.getColumnIndex("relative_path");
        if (columnIndex2 == -1) {
            columnIndex2 = query.getColumnIndex("_data");
        }
        int columnIndex3 = query.getColumnIndex("mime_type");
        int columnIndex4 = query.getColumnIndex("date_modified");
        int columnIndex5 = query.getColumnIndex("_size");
        int columnIndex6 = query.getColumnIndex("title");
        int columnIndex7 = query.getColumnIndex("_display_name");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.f3112O000000o = query.getInt(columnIndex);
            o00000Oo.O00000Oo = ContentUris.withAppendedId(contentUri, (long) o00000Oo.f3112O000000o).toString();
            o00000Oo.O0000Oo0 = query.getString(columnIndex2);
            o00000Oo.O00000o0 = query.getString(columnIndex3);
            o00000Oo.O0000O0o = query.getInt(columnIndex4);
            o00000Oo.O0000Oo = query.getInt(columnIndex5);
            o00000Oo.O0000OoO = query.getString(columnIndex6);
            o00000Oo.O0000Ooo = query.getString(columnIndex7);
            arrayList.add(o00000Oo);
        }
        query.close();
        return arrayList;
    }

    private static String[] O000000o(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = gtb.O00000Oo(strArr[i]);
        }
        return strArr2;
    }
}
