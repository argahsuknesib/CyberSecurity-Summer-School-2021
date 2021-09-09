package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;

public interface ContentMetadata {
    boolean contains(String str);

    long get(String str, long j);

    String get(String str, String str2);

    byte[] get(String str, byte[] bArr);

    /* renamed from: com.google.android.exoplayer2.upstream.cache.ContentMetadata$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long getContentLength(ContentMetadata contentMetadata) {
            return contentMetadata.get("exo_len", -1);
        }

        public static Uri getRedirectedUri(ContentMetadata contentMetadata) {
            String str = contentMetadata.get("exo_redir", (String) null);
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }
    }
}
