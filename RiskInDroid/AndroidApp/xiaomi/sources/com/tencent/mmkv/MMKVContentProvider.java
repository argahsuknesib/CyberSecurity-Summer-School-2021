package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MMKVContentProvider extends ContentProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Uri f5863O000000o;

    public String getType(Uri uri) {
        return null;
    }

    protected static Uri O000000o(Context context) {
        String O00000Oo;
        Uri uri = f5863O000000o;
        if (uri != null) {
            return uri;
        }
        if (context == null || (O00000Oo = O00000Oo(context)) == null) {
            return null;
        }
        Uri parse = Uri.parse("content://".concat(String.valueOf(O00000Oo)));
        f5863O000000o = parse;
        return parse;
    }

    private static String O00000Oo(Context context) {
        ProviderInfo providerInfo;
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (providerInfo = packageManager.getProviderInfo(componentName, 0)) == null) {
                return null;
            }
            return providerInfo.authority;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean onCreate() {
        String O00000Oo;
        Context context = getContext();
        if (context == null || (O00000Oo = O00000Oo(context)) == null) {
            return false;
        }
        if (f5863O000000o != null) {
            return true;
        }
        f5863O000000o = Uri.parse("content://".concat(String.valueOf(O00000Oo)));
        return true;
    }

    protected static String O000000o(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
            if (next.pid == i) {
                return next.processName;
            }
        }
        return "";
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        MMKV O000000o2;
        if (!str.equals("mmkvFromAshmemID") || bundle == null || (O000000o2 = MMKV.O000000o(getContext(), str2, bundle.getInt("KEY_SIZE"), bundle.getInt("KEY_MODE"), bundle.getString("KEY_CRYPT"))) == null) {
            return null;
        }
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(O000000o2);
        Log.i("MMKV", str2 + " fd = " + O000000o2.ashmemFD() + ", meta fd = " + O000000o2.ashmemMetaFD());
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("KEY", parcelableMMKV);
        return bundle2;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
