package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.Util;

public final class SsUtil {
    public static Uri fixManifestUri(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || !Util.toLowerInvariant(lastPathSegment).matches("manifest(\\(.+\\))?")) {
            return Uri.withAppendedPath(uri, "Manifest");
        }
        return uri;
    }

    private SsUtil() {
    }
}
