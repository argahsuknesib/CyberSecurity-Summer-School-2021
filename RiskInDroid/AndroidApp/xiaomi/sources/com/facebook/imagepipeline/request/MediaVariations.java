package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Objects;
import com.facebook.imagepipeline.request.ImageRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MediaVariations {
    private final boolean mForceRequestForSpecifiedUri;
    private final String mMediaId;
    private final String mSource;
    private final List<Variant> mVariants;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    private MediaVariations(Builder builder) {
        this.mMediaId = builder.mMediaId;
        this.mVariants = builder.mVariants;
        this.mForceRequestForSpecifiedUri = builder.mForceRequestForSpecifiedUri;
        this.mSource = builder.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int getVariantsCount() {
        List<Variant> list = this.mVariants;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Variant getVariant(int i) {
        return this.mVariants.get(i);
    }

    public List<Variant> getSortedVariants(Comparator<Variant> comparator) {
        int variantsCount = getVariantsCount();
        if (variantsCount == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(variantsCount);
        for (int i = 0; i < variantsCount; i++) {
            arrayList.add(this.mVariants.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean shouldForceRequestForSpecifiedUri() {
        return this.mForceRequestForSpecifiedUri;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaVariations)) {
            return false;
        }
        MediaVariations mediaVariations = (MediaVariations) obj;
        if (!Objects.equal(this.mMediaId, mediaVariations.mMediaId) || this.mForceRequestForSpecifiedUri != mediaVariations.mForceRequestForSpecifiedUri || !Objects.equal(this.mVariants, mediaVariations.mVariants)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.mMediaId, Boolean.valueOf(this.mForceRequestForSpecifiedUri), this.mVariants, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.mForceRequestForSpecifiedUri), this.mVariants, this.mSource);
    }

    public static final class Variant {
        private final ImageRequest.CacheChoice mCacheChoice;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public Variant(Uri uri, int i, int i2) {
            this(uri, i, i2, null);
        }

        public Variant(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.mCacheChoice = cacheChoice;
        }

        public final Uri getUri() {
            return this.mUri;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final ImageRequest.CacheChoice getCacheChoice() {
            return this.mCacheChoice;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Variant)) {
                return false;
            }
            Variant variant = (Variant) obj;
            if (Objects.equal(this.mUri, variant.mUri) && this.mWidth == variant.mWidth && this.mHeight == variant.mHeight && this.mCacheChoice == variant.mCacheChoice) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public final String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.mCacheChoice);
        }
    }

    public static MediaVariations forMediaId(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return newBuilderForMediaId(str).build();
    }

    public static Builder newBuilderForMediaId(String str) {
        return new Builder(str);
    }

    public static class Builder {
        public boolean mForceRequestForSpecifiedUri;
        public final String mMediaId;
        public String mSource;
        public List<Variant> mVariants;

        private Builder(String str) {
            this.mForceRequestForSpecifiedUri = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public Builder addVariant(Uri uri, int i, int i2) {
            return addVariant(uri, i, i2, null);
        }

        public Builder addVariant(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.mVariants == null) {
                this.mVariants = new ArrayList();
            }
            this.mVariants.add(new Variant(uri, i, i2, cacheChoice));
            return this;
        }

        public Builder setForceRequestForSpecifiedUri(boolean z) {
            this.mForceRequestForSpecifiedUri = z;
            return this;
        }

        public Builder setSource(String str) {
            this.mSource = str;
            return this;
        }

        public MediaVariations build() {
            return new MediaVariations(this);
        }
    }
}
