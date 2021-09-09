package com.miui.tsmclient.database;

import android.content.Context;
import android.net.Uri;

public class ProviderAuthorities {
    public static String AUTHORITY = String.format("%s.platform.provider", "com.miui.tsmclient.common");
    public static Uri CONTENT_URI = Uri.parse(String.format("content://%s.platform.provider", "com.miui.tsmclient.common"));
    public static Uri PUBLIC_CONTENT_URI = Uri.parse(String.format("content://%s.platform.provider.public", "com.miui.tsmclient.common"));

    public static void init(Context context) {
        String packageName = context.getPackageName();
        AUTHORITY = String.format("%s.platform.provider", packageName);
        CONTENT_URI = Uri.parse(String.format("content://%s.platform.provider", packageName));
        PUBLIC_CONTENT_URI = Uri.parse(String.format("content://%s.platform.provider.public", packageName));
    }
}
