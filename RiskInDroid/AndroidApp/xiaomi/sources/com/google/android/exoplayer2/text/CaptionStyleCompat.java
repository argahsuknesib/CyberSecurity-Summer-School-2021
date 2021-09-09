package com.google.android.exoplayer2.text;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CaptionStyleCompat {
    public static final CaptionStyleCompat DEFAULT = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
    public final int backgroundColor;
    public final int edgeColor;
    public final int edgeType;
    public final int foregroundColor;
    public final Typeface typeface;
    public final int windowColor;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface EdgeType {
    }

    public static CaptionStyleCompat createFromCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
        if (Util.SDK_INT >= 21) {
            return createFromCaptionStyleV21(captionStyle);
        }
        return createFromCaptionStyleV19(captionStyle);
    }

    public CaptionStyleCompat(int i, int i2, int i3, int i4, int i5, Typeface typeface2) {
        this.foregroundColor = i;
        this.backgroundColor = i2;
        this.windowColor = i3;
        this.edgeType = i4;
        this.edgeColor = i5;
        this.typeface = typeface2;
    }

    private static CaptionStyleCompat createFromCaptionStyleV19(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static CaptionStyleCompat createFromCaptionStyleV21(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : DEFAULT.foregroundColor, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : DEFAULT.backgroundColor, captionStyle.hasWindowColor() ? captionStyle.windowColor : DEFAULT.windowColor, captionStyle.hasEdgeType() ? captionStyle.edgeType : DEFAULT.edgeType, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : DEFAULT.edgeColor, captionStyle.getTypeface());
    }
}
