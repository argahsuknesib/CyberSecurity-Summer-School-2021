package com.facebook.imagepipeline.common;

import com.facebook.common.util.HashCodeUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RotationOptions {
    private static final RotationOptions ROTATION_OPTIONS_AUTO_ROTATE = new RotationOptions(-1, false);
    private static final RotationOptions ROTATION_OPTIONS_DISABLE_ROTATION = new RotationOptions(-2, false);
    private static final RotationOptions ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = new RotationOptions(-1, true);
    private final boolean mDeferUntilRendered;
    private final int mRotation;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationAngle {
    }

    public static RotationOptions autoRotate() {
        return ROTATION_OPTIONS_AUTO_ROTATE;
    }

    public static RotationOptions disableRotation() {
        return ROTATION_OPTIONS_DISABLE_ROTATION;
    }

    public static RotationOptions autoRotateAtRenderTime() {
        return ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME;
    }

    public static RotationOptions forceRotation(int i) {
        return new RotationOptions(i, false);
    }

    private RotationOptions(int i, boolean z) {
        this.mRotation = i;
        this.mDeferUntilRendered = z;
    }

    public boolean useImageMetadata() {
        return this.mRotation == -1;
    }

    public boolean rotationEnabled() {
        return this.mRotation != -2;
    }

    public int getForcedAngle() {
        if (!useImageMetadata()) {
            return this.mRotation;
        }
        throw new IllegalStateException("Rotation is set to use EXIF");
    }

    public boolean canDeferUntilRendered() {
        return this.mDeferUntilRendered;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RotationOptions)) {
            return false;
        }
        RotationOptions rotationOptions = (RotationOptions) obj;
        return this.mRotation == rotationOptions.mRotation && this.mDeferUntilRendered == rotationOptions.mDeferUntilRendered;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered));
    }
}
