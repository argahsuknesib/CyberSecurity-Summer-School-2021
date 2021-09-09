package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.FacebookSdk;
import java.util.Locale;

public class ImageRequest {
    private boolean allowCachedRedirects;
    private Callback callback;
    private Object callerTag;
    private Context context;
    private Uri imageUri;

    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    public static Uri getProfilePictureUri(String str, int i, int i2) {
        return getProfilePictureUri(str, i, i2, "");
    }

    public static Uri getProfilePictureUri(String str, int i, int i2, String str2) {
        Validate.notNullOrEmpty(str, "userId");
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (max == 0 && max2 == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        Uri.Builder path = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon().path(String.format(Locale.US, "%s/%s/picture", FacebookSdk.getGraphApiVersion(), str));
        if (max2 != 0) {
            path.appendQueryParameter("height", String.valueOf(max2));
        }
        if (max != 0) {
            path.appendQueryParameter("width", String.valueOf(max));
        }
        path.appendQueryParameter("migration_overrides", "{october_2012:true}");
        if (!Utility.isNullOrEmpty(str2)) {
            path.appendQueryParameter("access_token", str2);
        }
        return path.build();
    }

    private ImageRequest(Builder builder) {
        this.context = builder.context;
        this.imageUri = builder.imageUrl;
        this.callback = builder.callback;
        this.allowCachedRedirects = builder.allowCachedRedirects;
        this.callerTag = builder.callerTag == null ? new Object() : builder.callerTag;
    }

    public Context getContext() {
        return this.context;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    public Object getCallerTag() {
        return this.callerTag;
    }

    public static class Builder {
        public boolean allowCachedRedirects;
        public Callback callback;
        public Object callerTag;
        public Context context;
        public Uri imageUrl;

        public Builder(Context context2, Uri uri) {
            Validate.notNull(uri, "imageUri");
            this.context = context2;
            this.imageUrl = uri;
        }

        public Builder setCallback(Callback callback2) {
            this.callback = callback2;
            return this;
        }

        public Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }

        public Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        public ImageRequest build() {
            return new ImageRequest(this);
        }
    }
}
