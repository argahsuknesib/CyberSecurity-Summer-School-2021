package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;

public final class FacebookInitProvider extends ContentProvider {
    private static final String TAG = "FacebookInitProvider";

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public final boolean onCreate() {
        try {
            FacebookSdk.sdkInitialize(getContext());
            return false;
        } catch (Exception e) {
            Log.i(TAG, "Failed to auto initialize the Facebook SDK", e);
            return false;
        }
    }
}
