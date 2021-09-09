package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final class TtmlStyle {
    private int backgroundColor;
    private int bold = -1;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private int fontSizeUnit = -1;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private String id;
    private int italic = -1;
    private int linethrough = -1;
    private int rubyPosition = -1;
    private int rubyType = -1;
    private Layout.Alignment textAlign;
    private int textCombine = -1;
    private int underline = -1;
    private int verticalType = Integer.MIN_VALUE;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RubyType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public final int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        int i = 0;
        int i2 = this.bold == 1 ? 1 : 0;
        if (this.italic == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public final boolean isLinethrough() {
        return this.linethrough == 1;
    }

    public final TtmlStyle setLinethrough(boolean z) {
        this.linethrough = z ? 1 : 0;
        return this;
    }

    public final boolean isUnderline() {
        return this.underline == 1;
    }

    public final TtmlStyle setUnderline(boolean z) {
        this.underline = z ? 1 : 0;
        return this;
    }

    public final TtmlStyle setBold(boolean z) {
        this.bold = z ? 1 : 0;
        return this;
    }

    public final TtmlStyle setItalic(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final TtmlStyle setFontFamily(String str) {
        this.fontFamily = str;
        return this;
    }

    public final int getFontColor() {
        if (this.hasFontColor) {
            return this.fontColor;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final TtmlStyle setFontColor(int i) {
        this.fontColor = i;
        this.hasFontColor = true;
        return this;
    }

    public final boolean hasFontColor() {
        return this.hasFontColor;
    }

    public final int getBackgroundColor() {
        if (this.hasBackgroundColor) {
            return this.backgroundColor;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final TtmlStyle setBackgroundColor(int i) {
        this.backgroundColor = i;
        this.hasBackgroundColor = true;
        return this;
    }

    public final boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public final TtmlStyle chain(TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, true);
    }

    public final TtmlStyle inherit(TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, false);
    }

    private TtmlStyle inherit(TtmlStyle ttmlStyle, boolean z) {
        int i;
        int i2;
        Layout.Alignment alignment;
        String str;
        if (ttmlStyle != null) {
            if (!this.hasFontColor && ttmlStyle.hasFontColor) {
                setFontColor(ttmlStyle.fontColor);
            }
            if (this.bold == -1) {
                this.bold = ttmlStyle.bold;
            }
            if (this.italic == -1) {
                this.italic = ttmlStyle.italic;
            }
            if (this.fontFamily == null && (str = ttmlStyle.fontFamily) != null) {
                this.fontFamily = str;
            }
            if (this.linethrough == -1) {
                this.linethrough = ttmlStyle.linethrough;
            }
            if (this.underline == -1) {
                this.underline = ttmlStyle.underline;
            }
            if (this.rubyPosition == -1) {
                this.rubyPosition = ttmlStyle.rubyPosition;
            }
            if (this.textAlign == null && (alignment = ttmlStyle.textAlign) != null) {
                this.textAlign = alignment;
            }
            if (this.textCombine == -1) {
                this.textCombine = ttmlStyle.textCombine;
            }
            if (this.fontSizeUnit == -1) {
                this.fontSizeUnit = ttmlStyle.fontSizeUnit;
                this.fontSize = ttmlStyle.fontSize;
            }
            if (z && !this.hasBackgroundColor && ttmlStyle.hasBackgroundColor) {
                setBackgroundColor(ttmlStyle.backgroundColor);
            }
            if (z && this.rubyType == -1 && (i2 = ttmlStyle.rubyType) != -1) {
                this.rubyType = i2;
            }
            if (z && this.verticalType == Integer.MIN_VALUE && (i = ttmlStyle.verticalType) != Integer.MIN_VALUE) {
                setVerticalType(i);
            }
        }
        return this;
    }

    public final TtmlStyle setId(String str) {
        this.id = str;
        return this;
    }

    public final String getId() {
        return this.id;
    }

    public final TtmlStyle setRubyType(int i) {
        this.rubyType = i;
        return this;
    }

    public final int getRubyType() {
        return this.rubyType;
    }

    public final TtmlStyle setRubyPosition(int i) {
        this.rubyPosition = i;
        return this;
    }

    public final int getRubyPosition() {
        return this.rubyPosition;
    }

    public final Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public final TtmlStyle setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public final boolean getTextCombine() {
        return this.textCombine == 1;
    }

    public final TtmlStyle setTextCombine(boolean z) {
        this.textCombine = z ? 1 : 0;
        return this;
    }

    public final TtmlStyle setFontSize(float f) {
        this.fontSize = f;
        return this;
    }

    public final TtmlStyle setFontSizeUnit(int i) {
        this.fontSizeUnit = i;
        return this;
    }

    public final int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final TtmlStyle setVerticalType(int i) {
        this.verticalType = i;
        return this;
    }

    public final int getVerticalType() {
        return this.verticalType;
    }
}
