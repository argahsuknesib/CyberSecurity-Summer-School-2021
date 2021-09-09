package com.google.android.gms.common.images.internal;

import _m_j.o0oOo0O0;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.Objects;

public final class PostProcessedResourceCache extends o0oOo0O0<PostProcessedResource, Drawable> {

    public static final class PostProcessedResource {
        public final int postProcessingFlags;
        public final int resId;

        public PostProcessedResource(int i, int i2) {
            this.resId = i;
            this.postProcessingFlags = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PostProcessedResource)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PostProcessedResource postProcessedResource = (PostProcessedResource) obj;
            return postProcessedResource.resId == this.resId && postProcessedResource.postProcessingFlags == this.postProcessingFlags;
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.resId), Integer.valueOf(this.postProcessingFlags));
        }
    }

    public PostProcessedResourceCache() {
        super(10);
    }
}
