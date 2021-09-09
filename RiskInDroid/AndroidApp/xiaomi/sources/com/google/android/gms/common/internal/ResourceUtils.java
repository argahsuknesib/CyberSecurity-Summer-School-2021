package com.google.android.gms.common.internal;

import android.net.Uri;

public final class ResourceUtils {
    private static final Uri zzuw = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();

    @Deprecated
    public interface SignInResources {
    }

    private ResourceUtils() {
    }

    public static Uri getDrawableUri(String str) {
        Preconditions.checkNotNull(str, "Resource name must not be null.");
        return zzuw.buildUpon().appendPath(str).build();
    }
}
