package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.net.Uri;
import com.google.android.gms.internal.stable.zze;

public final class zzg extends zze.zza {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.settings/partner");

    public static int getInt(ContentResolver contentResolver, String str, int i) {
        String string = getString(contentResolver, str);
        if (string == null) {
            return -1;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static String getString(ContentResolver contentResolver, String str) {
        return zza(contentResolver, CONTENT_URI, str);
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String string = getString(contentResolver, str);
        return string == null ? str2 : string;
    }
}
