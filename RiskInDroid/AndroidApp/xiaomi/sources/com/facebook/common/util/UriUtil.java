package com.facebook.common.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class UriUtil {
    private static final Uri LOCAL_CONTACT_IMAGE_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    public static URL uriToUrl(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isNetworkUri(Uri uri) {
        String schemeOrNull = getSchemeOrNull(uri);
        return "https".equals(schemeOrNull) || "http".equals(schemeOrNull);
    }

    public static boolean isLocalFileUri(Uri uri) {
        return "file".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContentUri(Uri uri) {
        return "content".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContactUri(Uri uri) {
        return isLocalContentUri(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(LOCAL_CONTACT_IMAGE_URI.getPath());
    }

    public static boolean isLocalCameraUri(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean isLocalAssetUri(Uri uri) {
        return "asset".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalResourceUri(Uri uri) {
        return "res".equals(getSchemeOrNull(uri));
    }

    public static boolean isQualifiedResourceUri(Uri uri) {
        return "android.resource".equals(getSchemeOrNull(uri));
    }

    public static boolean isDataUri(Uri uri) {
        return "data".equals(getSchemeOrNull(uri));
    }

    public static String getSchemeOrNull(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static Uri parseUriOrNull(String str) {
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    public static String getRealPathFromUri(ContentResolver contentResolver, Uri uri) {
        Cursor cursor;
        int columnIndex;
        String str = null;
        if (isLocalContentUri(uri)) {
            try {
                cursor = contentResolver.query(uri, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst() && (columnIndex = cursor.getColumnIndex("_data")) != -1) {
                            str = cursor.getString(columnIndex);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
                if (cursor == null) {
                    return str;
                }
                cursor.close();
                return str;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else if (isLocalFileUri(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static Uri getUriForFile(File file) {
        return Uri.fromFile(file);
    }

    public static Uri getUriForResourceId(int i) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }

    public static Uri getUriForQualifiedResource(String str, int i) {
        return new Uri.Builder().scheme("android.resource").authority(str).path(String.valueOf(i)).build();
    }
}
