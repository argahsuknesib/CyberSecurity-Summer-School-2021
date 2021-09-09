package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Cue {
    public static final Cue EMPTY = new Cue("");
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final int windowColor;
    public final boolean windowColorSet;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalType {
    }

    @Deprecated
    public Cue(CharSequence charSequence) {
        this(charSequence, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.text.Cue.<init>(java.lang.CharSequence, android.text.Layout$Alignment, float, int, int, float, int, float, boolean, int):void
     arg types: [java.lang.CharSequence, android.text.Layout$Alignment, float, int, int, float, int, float, int, int]
     candidates:
      com.google.android.exoplayer2.text.Cue.<init>(java.lang.CharSequence, android.text.Layout$Alignment, float, int, int, float, int, float, int, float):void
      com.google.android.exoplayer2.text.Cue.<init>(java.lang.CharSequence, android.text.Layout$Alignment, float, int, int, float, int, float, boolean, int):void */
    @Deprecated
    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, -16777216);
    }

    @Deprecated
    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, i4, f4, f3, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE);
    }

    @Deprecated
    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z, i4, Integer.MIN_VALUE);
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap2, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6) {
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap3 = bitmap2;
        if (charSequence2 == null) {
            Assertions.checkNotNull(bitmap2);
        } else {
            Assertions.checkArgument(bitmap3 == null);
        }
        this.text = charSequence2;
        this.textAlignment = alignment;
        this.bitmap = bitmap3;
        this.line = f;
        this.lineType = i;
        this.lineAnchor = i2;
        this.position = f2;
        this.positionAnchor = i3;
        this.size = f4;
        this.bitmapHeight = f5;
        this.windowColorSet = z;
        this.windowColor = i5;
        this.textSizeType = i4;
        this.textSize = f3;
        this.verticalType = i6;
    }

    public static final class Builder {
        private Bitmap bitmap = null;
        private float bitmapHeight = -3.4028235E38f;
        private float line = -3.4028235E38f;
        private int lineAnchor = Integer.MIN_VALUE;
        private int lineType = Integer.MIN_VALUE;
        private float position = -3.4028235E38f;
        private int positionAnchor = Integer.MIN_VALUE;
        private float size = -3.4028235E38f;
        private CharSequence text = null;
        private Layout.Alignment textAlignment = null;
        private float textSize = -3.4028235E38f;
        private int textSizeType = Integer.MIN_VALUE;
        private int verticalType = Integer.MIN_VALUE;
        private int windowColor = -16777216;
        private boolean windowColorSet = false;

        public final Builder setText(CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final Builder setBitmap(Bitmap bitmap2) {
            this.bitmap = bitmap2;
            return this;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Builder setTextAlignment(Layout.Alignment alignment) {
            this.textAlignment = alignment;
            return this;
        }

        public final Layout.Alignment getTextAlignment() {
            return this.textAlignment;
        }

        public final Builder setLine(float f, int i) {
            this.line = f;
            this.lineType = i;
            return this;
        }

        public final float getLine() {
            return this.line;
        }

        public final int getLineType() {
            return this.lineType;
        }

        public final Builder setLineAnchor(int i) {
            this.lineAnchor = i;
            return this;
        }

        public final int getLineAnchor() {
            return this.lineAnchor;
        }

        public final Builder setPosition(float f) {
            this.position = f;
            return this;
        }

        public final float getPosition() {
            return this.position;
        }

        public final Builder setPositionAnchor(int i) {
            this.positionAnchor = i;
            return this;
        }

        public final int getPositionAnchor() {
            return this.positionAnchor;
        }

        public final Builder setTextSize(float f, int i) {
            this.textSize = f;
            this.textSizeType = i;
            return this;
        }

        public final int getTextSizeType() {
            return this.textSizeType;
        }

        public final float getTextSize() {
            return this.textSize;
        }

        public final Builder setSize(float f) {
            this.size = f;
            return this;
        }

        public final float getSize() {
            return this.size;
        }

        public final Builder setBitmapHeight(float f) {
            this.bitmapHeight = f;
            return this;
        }

        public final float getBitmapHeight() {
            return this.bitmapHeight;
        }

        public final Builder setWindowColor(int i) {
            this.windowColor = i;
            this.windowColorSet = true;
            return this;
        }

        public final boolean isWindowColorSet() {
            return this.windowColorSet;
        }

        public final int getWindowColor() {
            return this.windowColor;
        }

        public final Builder setVerticalType(int i) {
            this.verticalType = i;
            return this;
        }

        public final int getVerticalType() {
            return this.verticalType;
        }

        public final Cue build() {
            return new Cue(this.text, this.textAlignment, this.bitmap, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.textSizeType, this.textSize, this.size, this.bitmapHeight, this.windowColorSet, this.windowColor, this.verticalType);
        }
    }
}
