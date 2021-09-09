package com.sina.weibo.sdk.network.base;

import android.net.Uri;
import android.os.Bundle;

public class UriUtils {
    public static Uri buildCompleteUri(Uri uri, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        for (String next : bundle.keySet()) {
            buildUpon.appendQueryParameter(next, String.valueOf(bundle.get(next)));
        }
        return buildUpon.build();
    }

    public static String buildCompleteUri(String str, Bundle bundle) {
        Uri buildCompleteUri = buildCompleteUri(Uri.parse(str), bundle);
        if (buildCompleteUri != null) {
            return buildCompleteUri.toString();
        }
        return null;
    }
}
