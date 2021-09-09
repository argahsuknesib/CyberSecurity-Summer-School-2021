package com.google.android.material.resources;

import _m_j.bf;
import _m_j.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import com.xiaomi.smarthome.R;

public class TextAppearance {
    public Typeface font;
    public final String fontFamily;
    private final int fontFamilyResourceId;
    public boolean fontResolved = false;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    public final ColorStateList textColor;
    public final ColorStateList textColorHint;
    public final ColorStateList textColorLink;
    public float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{16842901, 16842902, 16842903, 16842904, 16842906, 16842907, 16843105, 16843106, 16843107, 16843108, 16843692, 16844165, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
        this.textSize = obtainStyledAttributes.getDimension(0, 0.0f);
        this.textColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, 3);
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, 4);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, 5);
        this.textStyle = obtainStyledAttributes.getInt(2, 0);
        this.typeface = obtainStyledAttributes.getInt(1, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, 12, 10);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(14, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, 6);
        this.shadowDx = obtainStyledAttributes.getFloat(7, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(8, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, new int[]{16843958, 16844159, R.attr.lineHeight});
            this.hasLetterSpacing = obtainStyledAttributes2.hasValue(0);
            this.letterSpacing = obtainStyledAttributes2.getFloat(0, 0.0f);
            obtainStyledAttributes2.recycle();
            return;
        }
        this.hasLetterSpacing = false;
        this.letterSpacing = 0.0f;
    }

    public Typeface getFont(Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                this.font = m.O000000o(context, this.fontFamilyResourceId);
                if (this.font != null) {
                    this.font = Typeface.create(this.font, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.fontFamily, e);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(Context context, final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            getFont(context);
        } else {
            createFallbackFont();
        }
        if (this.fontFamilyResourceId == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            int i = this.fontFamilyResourceId;
            AnonymousClass1 r6 = new m.O000000o() {
                /* class com.google.android.material.resources.TextAppearance.AnonymousClass1 */

                public void onFontRetrieved(Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                    TextAppearance textAppearance2 = TextAppearance.this;
                    textAppearance2.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrieved(textAppearance2.font, false);
                }

                public void onFontRetrievalFailed(int i) {
                    TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i);
                }
            };
            bf.O000000o(r6);
            if (context.isRestricted()) {
                r6.callbackFailAsync(-4, null);
                return;
            }
            m.O000000o(context, i, new TypedValue(), 0, r6, null, false);
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.fontFamily, e);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    public void getFontAsync(Context context, final TextPaint textPaint, final TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(textPaint, getFallbackFont());
        getFontAsync(context, new TextAppearanceFontCallback() {
            /* class com.google.android.material.resources.TextAppearance.AnonymousClass2 */

            public void onFontRetrieved(Typeface typeface, boolean z) {
                TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z);
            }

            public void onFontRetrievalFailed(int i) {
                textAppearanceFontCallback.onFontRetrievalFailed(i);
            }
        });
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    private void createFallbackFont() {
        String str;
        if (this.font == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, this.textStyle);
        }
        if (this.font == null) {
            int i = this.typeface;
            if (i == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.font = Typeface.SERIF;
            } else if (i != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            this.font = Typeface.create(this.font, this.textStyle);
        }
    }

    public void updateDrawState(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, this.textColor.getDefaultColor()) : -16777216);
        float f = this.shadowRadius;
        float f2 = this.shadowDx;
        float f3 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, this.shadowColor.getDefaultColor()) : 0);
    }

    public void updateMeasureState(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            updateTextPaintMeasureState(textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(TextPaint textPaint, Typeface typeface2) {
        textPaint.setTypeface(typeface2);
        int style = (typeface2.getStyle() ^ -1) & this.textStyle;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
        if (Build.VERSION.SDK_INT >= 21 && this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }

    private boolean shouldLoadFontSynchronously(Context context) {
        return TextAppearanceConfig.shouldLoadFontSynchronously();
    }
}
