package com.facebook.cache.common;

import android.net.Uri;

public class DebuggingCacheKey extends SimpleCacheKey {
    private final Object mCallerContext;
    private final Uri mSourceUri;

    public DebuggingCacheKey(String str, Object obj, Uri uri) {
        super(str);
        this.mCallerContext = obj;
        this.mSourceUri = uri;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }
}
