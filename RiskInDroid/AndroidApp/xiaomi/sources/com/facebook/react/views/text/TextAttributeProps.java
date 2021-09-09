package com.facebook.react.views.text;

import android.os.Build;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.yoga.YogaDirection;

public class TextAttributeProps {
    protected boolean mAllowFontScaling = true;
    protected int mBackgroundColor;
    protected int mColor;
    protected boolean mContainsImages;
    protected String mFontFamily;
    protected int mFontSize = -1;
    protected float mFontSizeInput = -1.0f;
    protected int mFontStyle;
    protected int mFontWeight;
    protected float mHeightOfTallestInlineImage;
    protected boolean mIncludeFontPadding;
    protected boolean mIsBackgroundColorSet = false;
    protected boolean mIsColorSet = false;
    protected boolean mIsLineThroughTextDecorationSet;
    protected boolean mIsUnderlineTextDecorationSet;
    protected int mJustificationMode;
    protected float mLetterSpacing = Float.NaN;
    protected float mLetterSpacingInput = Float.NaN;
    protected float mLineHeight = Float.NaN;
    protected float mLineHeightInput = -1.0f;
    protected int mNumberOfLines = -1;
    private final ReactStylesDiffMap mProps;
    protected int mTextAlign = 0;
    protected int mTextBreakStrategy;
    protected int mTextShadowColor;
    protected float mTextShadowOffsetDx;
    protected float mTextShadowOffsetDy;
    protected float mTextShadowRadius;
    protected TextTransform mTextTransform;

    public TextAttributeProps(ReactStylesDiffMap reactStylesDiffMap) {
        this.mTextBreakStrategy = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        int i = Build.VERSION.SDK_INT;
        this.mJustificationMode = 0;
        this.mTextTransform = TextTransform.UNSET;
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        this.mTextShadowRadius = 1.0f;
        this.mTextShadowColor = 1426063360;
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        this.mIncludeFontPadding = true;
        this.mFontStyle = -1;
        this.mFontWeight = -1;
        ReadableMap readableMap = null;
        this.mFontFamily = null;
        this.mContainsImages = false;
        this.mHeightOfTallestInlineImage = Float.NaN;
        this.mProps = reactStylesDiffMap;
        setNumberOfLines(getIntProp("numberOfLines", -1));
        setLineHeight(getFloatProp("lineHeight", -1.0f));
        setLetterSpacing(getFloatProp("letterSpacing", Float.NaN));
        setAllowFontScaling(getBooleanProp("allowFontScaling", true));
        setTextAlign(getStringProp("textAlign"));
        setFontSize(getFloatProp("fontSize", -1.0f));
        setColor(reactStylesDiffMap.hasKey("color") ? Integer.valueOf(reactStylesDiffMap.getInt("color", 0)) : null);
        setColor(reactStylesDiffMap.hasKey("foregroundColor") ? Integer.valueOf(reactStylesDiffMap.getInt("foregroundColor", 0)) : null);
        setBackgroundColor(reactStylesDiffMap.hasKey("backgroundColor") ? Integer.valueOf(reactStylesDiffMap.getInt("backgroundColor", 0)) : null);
        setFontFamily(getStringProp("fontFamily"));
        setFontWeight(getStringProp("fontWeight"));
        setFontStyle(getStringProp("fontStyle"));
        setIncludeFontPadding(getBooleanProp("includeFontPadding", true));
        setTextDecorationLine(getStringProp("textDecorationLine"));
        setTextBreakStrategy(getStringProp("textBreakStrategy"));
        setTextShadowOffset(reactStylesDiffMap.hasKey("textShadowOffset") ? reactStylesDiffMap.getMap("textShadowOffset") : readableMap);
        setTextShadowRadius((float) getIntProp("textShadowRadius", 1));
        setTextShadowColor(getIntProp("textShadowColor", 1426063360));
        setTextTransform(getStringProp("textTransform"));
    }

    private boolean getBooleanProp(String str, boolean z) {
        return this.mProps.hasKey(str) ? this.mProps.getBoolean(str, z) : z;
    }

    private String getStringProp(String str) {
        if (this.mProps.hasKey(str)) {
            return this.mProps.getString(str);
        }
        return null;
    }

    private int getIntProp(String str, int i) {
        return this.mProps.hasKey(str) ? this.mProps.getInt(str, i) : i;
    }

    private float getFloatProp(String str, float f) {
        return this.mProps.hasKey(str) ? this.mProps.getFloat(str, f) : f;
    }

    public float getEffectiveLineHeight() {
        return !Float.isNaN(this.mLineHeight) && !Float.isNaN(this.mHeightOfTallestInlineImage) && (this.mHeightOfTallestInlineImage > this.mLineHeight ? 1 : (this.mHeightOfTallestInlineImage == this.mLineHeight ? 0 : -1)) > 0 ? this.mHeightOfTallestInlineImage : this.mLineHeight;
    }

    public int getTextAlign() {
        int i = this.mTextAlign;
        if (getLayoutDirection() != YogaDirection.RTL) {
            return i;
        }
        if (i == 5) {
            return 3;
        }
        if (i == 3) {
            return 5;
        }
        return i;
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = -1;
        }
        this.mNumberOfLines = i;
    }

    public void setLineHeight(float f) {
        float f2;
        this.mLineHeightInput = f;
        if (f == -1.0f) {
            f2 = Float.NaN;
        } else if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(f);
        } else {
            f2 = PixelUtil.toPixelFromDIP(f);
        }
        this.mLineHeight = f2;
    }

    public void setLetterSpacing(float f) {
        float f2;
        this.mLetterSpacingInput = f;
        if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(this.mLetterSpacingInput);
        } else {
            f2 = PixelUtil.toPixelFromDIP(this.mLetterSpacingInput);
        }
        this.mLetterSpacing = f2;
    }

    public void setAllowFontScaling(boolean z) {
        if (z != this.mAllowFontScaling) {
            this.mAllowFontScaling = z;
            setFontSize(this.mFontSizeInput);
            setLineHeight(this.mLineHeightInput);
            setLetterSpacing(this.mLetterSpacingInput);
        }
    }

    public void setTextAlign(String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJustificationMode = 1;
            }
            this.mTextAlign = 3;
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mJustificationMode = 0;
        }
        if (str == null || "auto".equals(str)) {
            this.mTextAlign = 0;
        } else if ("left".equals(str)) {
            this.mTextAlign = 3;
        } else if ("right".equals(str)) {
            this.mTextAlign = 5;
        } else if ("center".equals(str)) {
            this.mTextAlign = 1;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: ".concat(String.valueOf(str)));
        }
    }

    public void setFontSize(float f) {
        double d;
        this.mFontSizeInput = f;
        if (f != -1.0f) {
            if (this.mAllowFontScaling) {
                d = Math.ceil((double) PixelUtil.toPixelFromSP(f));
            } else {
                d = Math.ceil((double) PixelUtil.toPixelFromDIP(f));
            }
            f = (float) d;
        }
        this.mFontSize = (int) f;
    }

    public void setColor(Integer num) {
        this.mIsColorSet = num != null;
        if (this.mIsColorSet) {
            this.mColor = num.intValue();
        }
    }

    public void setBackgroundColor(Integer num) {
        this.mIsBackgroundColorSet = num != null;
        if (this.mIsBackgroundColorSet) {
            this.mBackgroundColor = num.intValue();
        }
    }

    public void setFontFamily(String str) {
        this.mFontFamily = str;
    }

    public void setFontWeight(String str) {
        int i = -1;
        int parseNumericFontWeight = str != null ? parseNumericFontWeight(str) : -1;
        if (parseNumericFontWeight >= 500 || "bold".equals(str)) {
            i = 1;
        } else if ("normal".equals(str) || (parseNumericFontWeight != -1 && parseNumericFontWeight < 500)) {
            i = 0;
        }
        if (i != this.mFontWeight) {
            this.mFontWeight = i;
        }
    }

    public void setFontStyle(String str) {
        int i;
        if ("italic".equals(str)) {
            i = 2;
        } else {
            i = "normal".equals(str) ? 0 : -1;
        }
        if (i != this.mFontStyle) {
            this.mFontStyle = i;
        }
    }

    public void setIncludeFontPadding(boolean z) {
        this.mIncludeFontPadding = z;
    }

    public void setTextDecorationLine(String str) {
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            for (String str2 : str.split("-")) {
                if ("underline".equals(str2)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("strikethrough".equals(str2)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
    }

    public void setTextBreakStrategy(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (str == null || "highQuality".equals(str)) {
                this.mTextBreakStrategy = 1;
            } else if ("simple".equals(str)) {
                this.mTextBreakStrategy = 0;
            } else if ("balanced".equals(str)) {
                this.mTextBreakStrategy = 2;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: ".concat(String.valueOf(str)));
            }
        }
    }

    public void setTextShadowOffset(ReadableMap readableMap) {
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.mTextShadowOffsetDx = PixelUtil.toPixelFromDIP(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height") && !readableMap.isNull("height")) {
                this.mTextShadowOffsetDy = PixelUtil.toPixelFromDIP(readableMap.getDouble("height"));
            }
        }
    }

    public void setTextShadowRadius(float f) {
        if (f != this.mTextShadowRadius) {
            this.mTextShadowRadius = f;
        }
    }

    public void setTextShadowColor(int i) {
        if (i != this.mTextShadowColor) {
            this.mTextShadowColor = i;
        }
    }

    public void setTextTransform(String str) {
        if (str == null || "none".equals(str)) {
            this.mTextTransform = TextTransform.NONE;
        } else if ("uppercase".equals(str)) {
            this.mTextTransform = TextTransform.UPPERCASE;
        } else if ("lowercase".equals(str)) {
            this.mTextTransform = TextTransform.LOWERCASE;
        } else if ("capitalize".equals(str)) {
            this.mTextTransform = TextTransform.CAPITALIZE;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textTransform: ".concat(String.valueOf(str)));
        }
    }

    private static int parseNumericFontWeight(String str) {
        if (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') {
            return -1;
        }
        return (str.charAt(0) - '0') * 100;
    }

    private YogaDirection getLayoutDirection() {
        return YogaDirection.LTR;
    }

    public float getBottomPadding() {
        return getPaddingProp("paddingBottom");
    }

    public float getLeftPadding() {
        return getPaddingProp("paddingLeft");
    }

    public float getStartPadding() {
        return getPaddingProp("paddingStart");
    }

    public float getEndPadding() {
        return getPaddingProp("paddingEnd");
    }

    public float getTopPadding() {
        return getPaddingProp("paddingTop");
    }

    public float getRightPadding() {
        return getPaddingProp("paddingRight");
    }

    private float getPaddingProp(String str) {
        if (this.mProps.hasKey("padding")) {
            return PixelUtil.toPixelFromDIP(getFloatProp("padding", 0.0f));
        }
        return PixelUtil.toPixelFromDIP(getFloatProp(str, 0.0f));
    }
}
