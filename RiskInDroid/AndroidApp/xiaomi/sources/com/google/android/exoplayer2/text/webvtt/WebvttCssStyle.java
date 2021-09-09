package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class WebvttCssStyle {
    private int backgroundColor;
    private int bold;
    private boolean combineUpright;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private int fontSizeUnit;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private int italic;
    private int linethrough;
    private List<String> targetClasses;
    private String targetId;
    private String targetTag;
    private String targetVoice;
    private Layout.Alignment textAlign;
    private int underline;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public WebvttCssStyle() {
        reset();
    }

    public final void reset() {
        this.targetId = "";
        this.targetTag = "";
        this.targetClasses = Collections.emptyList();
        this.targetVoice = "";
        this.fontFamily = null;
        this.hasFontColor = false;
        this.hasBackgroundColor = false;
        this.linethrough = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.fontSizeUnit = -1;
        this.textAlign = null;
        this.combineUpright = false;
    }

    public final void setTargetId(String str) {
        this.targetId = str;
    }

    public final void setTargetTagName(String str) {
        this.targetTag = str;
    }

    public final void setTargetClasses(String[] strArr) {
        this.targetClasses = Arrays.asList(strArr);
    }

    public final void setTargetVoice(String str) {
        this.targetVoice = str;
    }

    public final int getSpecificityScore(String str, String str2, String[] strArr, String str3) {
        if (!this.targetId.isEmpty() || !this.targetTag.isEmpty() || !this.targetClasses.isEmpty() || !this.targetVoice.isEmpty()) {
            int updateScoreForMatch = updateScoreForMatch(updateScoreForMatch(updateScoreForMatch(0, this.targetId, str, 1073741824), this.targetTag, str2, 2), this.targetVoice, str3, 4);
            if (updateScoreForMatch == -1 || !Arrays.asList(strArr).containsAll(this.targetClasses)) {
                return 0;
            }
            return updateScoreForMatch + (this.targetClasses.size() * 4);
        } else if (TextUtils.isEmpty(str2)) {
            return 1;
        } else {
            return 0;
        }
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

    public final WebvttCssStyle setLinethrough(boolean z) {
        this.linethrough = z ? 1 : 0;
        return this;
    }

    public final boolean isUnderline() {
        return this.underline == 1;
    }

    public final WebvttCssStyle setUnderline(boolean z) {
        this.underline = z ? 1 : 0;
        return this;
    }

    public final WebvttCssStyle setBold(boolean z) {
        this.bold = z ? 1 : 0;
        return this;
    }

    public final WebvttCssStyle setItalic(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final WebvttCssStyle setFontFamily(String str) {
        this.fontFamily = Util.toLowerInvariant(str);
        return this;
    }

    public final int getFontColor() {
        if (this.hasFontColor) {
            return this.fontColor;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public final WebvttCssStyle setFontColor(int i) {
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
        throw new IllegalStateException("Background color not defined.");
    }

    public final WebvttCssStyle setBackgroundColor(int i) {
        this.backgroundColor = i;
        this.hasBackgroundColor = true;
        return this;
    }

    public final boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public final Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public final WebvttCssStyle setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public final WebvttCssStyle setFontSize(float f) {
        this.fontSize = f;
        return this;
    }

    public final WebvttCssStyle setFontSizeUnit(short s) {
        this.fontSizeUnit = s;
        return this;
    }

    public final int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final void setCombineUpright(boolean z) {
        this.combineUpright = z;
    }

    public final boolean getCombineUpright() {
        return this.combineUpright;
    }

    private static int updateScoreForMatch(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }
}
