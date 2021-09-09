package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class AbsoluteCornerSize implements CornerSize {
    private final float size;

    public AbsoluteCornerSize(float f) {
        this.size = f;
    }

    public final float getCornerSize(RectF rectF) {
        return this.size;
    }

    public final float getCornerSize() {
        return this.size;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbsoluteCornerSize) && this.size == ((AbsoluteCornerSize) obj).size;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.size)});
    }
}
