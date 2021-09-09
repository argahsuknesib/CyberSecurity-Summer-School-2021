package _m_j;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;

public final class dbr {
    @SuppressLint({"NewApi"})
    private static String O00000o0(Context context, Uri uri) {
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    return uri.getLastPathSegment();
                }
                return O000000o(context, uri, null, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
            return O000000o(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return O000000o(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r8 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r8 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    private static String O000000o(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Exception e) {
                    e = e;
                    try {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
            e.printStackTrace();
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static String O000000o(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return "*/*";
        }
        String substring = name.substring(lastIndexOf, name.length());
        if (TextUtils.isEmpty(substring) && substring.length() < 2) {
            return "*/*";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1, substring.length()).toLowerCase());
    }

    public static boolean O000000o(Context context, Uri uri) {
        return O000000o(new File(O00000o0(context, uri))).startsWith("image/");
    }

    public static boolean O00000Oo(Context context, Uri uri) {
        return O000000o(new File(O00000o0(context, uri))).startsWith("video/");
    }
}
