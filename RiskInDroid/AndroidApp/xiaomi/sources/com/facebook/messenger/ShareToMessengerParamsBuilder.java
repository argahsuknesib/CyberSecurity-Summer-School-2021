package com.facebook.messenger;

import android.net.Uri;

public class ShareToMessengerParamsBuilder {
    private Uri mExternalUri;
    private String mMetaData;
    private final String mMimeType;
    private final Uri mUri;

    ShareToMessengerParamsBuilder(Uri uri, String str) {
        this.mUri = uri;
        this.mMimeType = str;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public ShareToMessengerParamsBuilder setMetaData(String str) {
        this.mMetaData = str;
        return this;
    }

    public String getMetaData() {
        return this.mMetaData;
    }

    public ShareToMessengerParamsBuilder setExternalUri(Uri uri) {
        this.mExternalUri = uri;
        return this;
    }

    public Uri getExternalUri() {
        return this.mExternalUri;
    }

    public ShareToMessengerParams build() {
        return new ShareToMessengerParams(this);
    }
}
