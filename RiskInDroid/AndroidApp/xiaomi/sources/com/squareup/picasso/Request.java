package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Request {
    public final boolean centerCrop;
    public final boolean centerInside;
    public final Bitmap.Config config;
    public final boolean onlyScaleDown;
    public final Picasso.Priority priority;
    public final int resourceId;
    public final int targetHeight;
    public final int targetWidth;
    public final List<Transformation> transformations;
    public final Uri uri;

    private Request(Uri uri2, int i, List<Transformation> list, int i2, int i3, boolean z, boolean z2, boolean z3, Bitmap.Config config2, Picasso.Priority priority2) {
        this.uri = uri2;
        this.resourceId = i;
        if (list == null) {
            this.transformations = null;
        } else {
            this.transformations = Collections.unmodifiableList(list);
        }
        this.targetWidth = i2;
        this.targetHeight = i3;
        this.centerCrop = z;
        this.centerInside = z2;
        this.onlyScaleDown = z3;
        this.config = config2;
        this.priority = priority2;
    }

    public final boolean hasSize() {
        return (this.targetWidth == 0 && this.targetHeight == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final boolean needsTransformation() {
        return needsMatrixTransform() || hasCustomTransformations();
    }

    /* access modifiers changed from: package-private */
    public final boolean needsMatrixTransform() {
        return hasSize();
    }

    /* access modifiers changed from: package-private */
    public final boolean hasCustomTransformations() {
        return this.transformations != null;
    }

    public static final class Builder {
        private boolean centerCrop;
        private boolean centerInside;
        private Bitmap.Config config;
        private boolean onlyScaleDown;
        private Picasso.Priority priority;
        private int resourceId;
        private int targetHeight;
        private int targetWidth;
        private List<Transformation> transformations;
        private Uri uri;

        public Builder(Uri uri2) {
            setUri(uri2);
        }

        public Builder(int i) {
            setResourceId(i);
        }

        Builder(Uri uri2, int i, Bitmap.Config config2) {
            this.uri = uri2;
            this.resourceId = i;
            this.config = config2;
        }

        private Builder(Request request) {
            this.uri = request.uri;
            this.resourceId = request.resourceId;
            this.targetWidth = request.targetWidth;
            this.targetHeight = request.targetHeight;
            this.centerCrop = request.centerCrop;
            this.centerInside = request.centerInside;
            this.onlyScaleDown = request.onlyScaleDown;
            if (request.transformations != null) {
                this.transformations = new ArrayList(request.transformations);
            }
            this.config = request.config;
            this.priority = request.priority;
        }

        /* access modifiers changed from: package-private */
        public final boolean hasImage() {
            return (this.uri == null && this.resourceId == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public final boolean hasSize() {
            return (this.targetWidth == 0 && this.targetHeight == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public final boolean hasPriority() {
            return this.priority != null;
        }

        public final Builder setUri(Uri uri2) {
            if (uri2 != null) {
                this.uri = uri2;
                this.resourceId = 0;
                return this;
            }
            throw new IllegalArgumentException("Image URI may not be null.");
        }

        public final Builder setResourceId(int i) {
            if (i != 0) {
                this.resourceId = i;
                this.uri = null;
                return this;
            }
            throw new IllegalArgumentException("Image resource ID may not be 0.");
        }

        public final Builder resize(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.targetWidth = i;
                this.targetHeight = i2;
                return this;
            }
        }

        public final Builder clearResize() {
            this.targetWidth = 0;
            this.targetHeight = 0;
            this.centerCrop = false;
            this.centerInside = false;
            return this;
        }

        public final Builder centerCrop() {
            if (!this.centerInside) {
                this.centerCrop = true;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        public final Builder clearCenterCrop() {
            this.centerCrop = false;
            return this;
        }

        public final Builder centerInside() {
            if (!this.centerCrop) {
                this.centerInside = true;
                return this;
            }
            throw new IllegalStateException("Center inside can not be used after calling centerCrop");
        }

        public final Builder clearCenterInside() {
            this.centerInside = false;
            return this;
        }

        public final Builder onlyScaleDown() {
            if (this.targetHeight == 0 && this.targetWidth == 0) {
                throw new IllegalStateException("onlyScaleDown can not be applied without resize");
            }
            this.onlyScaleDown = true;
            return this;
        }

        public final Builder clearOnlyScaleDown() {
            this.onlyScaleDown = false;
            return this;
        }

        public final Builder config(Bitmap.Config config2) {
            if (config2 != null) {
                this.config = config2;
                return this;
            }
            throw new IllegalArgumentException("config == null");
        }

        public final Builder priority(Picasso.Priority priority2) {
            if (priority2 == null) {
                throw new IllegalArgumentException("Priority invalid.");
            } else if (this.priority == null) {
                this.priority = priority2;
                return this;
            } else {
                throw new IllegalStateException("Priority already set.");
            }
        }

        public final Builder transform(Transformation transformation) {
            if (transformation == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (transformation.key() != null) {
                if (this.transformations == null) {
                    this.transformations = new ArrayList(2);
                }
                this.transformations.add(transformation);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }

        public final Builder transform(List<? extends Transformation> list) {
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    transform((Transformation) list.get(i));
                }
                return this;
            }
            throw new IllegalArgumentException("Transformation list must not be null.");
        }

        public final Request build() {
            if (!this.centerInside || !this.centerCrop) {
                if (this.priority == null) {
                    this.priority = Picasso.Priority.NORMAL;
                }
                return new Request(this.uri, this.resourceId, this.transformations, this.targetWidth, this.targetHeight, this.centerCrop, this.centerInside, this.onlyScaleDown, this.config, this.priority);
            }
            throw new IllegalStateException("Center crop and center inside can not be used together.");
        }
    }
}
