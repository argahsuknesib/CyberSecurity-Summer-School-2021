package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

final class SubtitlePainter {
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private int backgroundColor;
    private Rect bitmapRect;
    private float bottomPaddingFraction;
    private Bitmap cueBitmap;
    private float cueBitmapHeight;
    private float cueLine;
    private int cueLineAnchor;
    private int cueLineType;
    private float cuePosition;
    private int cuePositionAnchor;
    private float cueSize;
    private CharSequence cueText;
    private Layout.Alignment cueTextAlignment;
    private float cueTextSizePx;
    private float defaultTextSizePx;
    private int edgeColor;
    private StaticLayout edgeLayout;
    private int edgeType;
    private int foregroundColor;
    private final float outlineWidth;
    private final Paint paint;
    private int parentBottom;
    private int parentLeft;
    private int parentRight;
    private int parentTop;
    private final float shadowOffset;
    private final float shadowRadius;
    private final float spacingAdd;
    private final float spacingMult;
    private StaticLayout textLayout;
    private int textLeft;
    private int textPaddingX;
    private final TextPaint textPaint = new TextPaint();
    private int textTop;
    private int windowColor;

    public SubtitlePainter(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.spacingAdd = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.spacingMult = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.outlineWidth = round;
        this.shadowRadius = round;
        this.shadowOffset = round;
        this.textPaint.setAntiAlias(true);
        this.textPaint.setSubpixelText(true);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
    }

    public final void draw(Cue cue, boolean z, boolean z2, CaptionStyleCompat captionStyleCompat, float f, float f2, float f3, Canvas canvas, int i, int i2, int i3, int i4) {
        Cue cue2 = cue;
        boolean z3 = z;
        boolean z4 = z2;
        CaptionStyleCompat captionStyleCompat2 = captionStyleCompat;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        boolean z5 = cue2.bitmap == null;
        int i9 = -16777216;
        if (z5) {
            if (!TextUtils.isEmpty(cue2.text)) {
                i9 = (!cue2.windowColorSet || !z3) ? captionStyleCompat2.windowColor : cue2.windowColor;
            } else {
                return;
            }
        }
        if (areCharSequencesEqual(this.cueText, cue2.text) && Util.areEqual(this.cueTextAlignment, cue2.textAlignment) && this.cueBitmap == cue2.bitmap && this.cueLine == cue2.line && this.cueLineType == cue2.lineType && Util.areEqual(Integer.valueOf(this.cueLineAnchor), Integer.valueOf(cue2.lineAnchor)) && this.cuePosition == cue2.position && Util.areEqual(Integer.valueOf(this.cuePositionAnchor), Integer.valueOf(cue2.positionAnchor)) && this.cueSize == cue2.size && this.cueBitmapHeight == cue2.bitmapHeight && this.applyEmbeddedStyles == z3 && this.applyEmbeddedFontSizes == z4 && this.foregroundColor == captionStyleCompat2.foregroundColor && this.backgroundColor == captionStyleCompat2.backgroundColor && this.windowColor == i9 && this.edgeType == captionStyleCompat2.edgeType && this.edgeColor == captionStyleCompat2.edgeColor && Util.areEqual(this.textPaint.getTypeface(), captionStyleCompat2.typeface) && this.defaultTextSizePx == f4 && this.cueTextSizePx == f5 && this.bottomPaddingFraction == f6 && this.parentLeft == i5 && this.parentTop == i6 && this.parentRight == i7 && this.parentBottom == i8) {
            drawLayout(canvas, z5);
            return;
        }
        Canvas canvas2 = canvas;
        this.cueText = cue2.text;
        this.cueTextAlignment = cue2.textAlignment;
        this.cueBitmap = cue2.bitmap;
        this.cueLine = cue2.line;
        this.cueLineType = cue2.lineType;
        this.cueLineAnchor = cue2.lineAnchor;
        this.cuePosition = cue2.position;
        this.cuePositionAnchor = cue2.positionAnchor;
        this.cueSize = cue2.size;
        this.cueBitmapHeight = cue2.bitmapHeight;
        this.applyEmbeddedStyles = z3;
        this.applyEmbeddedFontSizes = z4;
        this.foregroundColor = captionStyleCompat2.foregroundColor;
        this.backgroundColor = captionStyleCompat2.backgroundColor;
        this.windowColor = i9;
        this.edgeType = captionStyleCompat2.edgeType;
        this.edgeColor = captionStyleCompat2.edgeColor;
        this.textPaint.setTypeface(captionStyleCompat2.typeface);
        this.defaultTextSizePx = f4;
        this.cueTextSizePx = f5;
        this.bottomPaddingFraction = f6;
        this.parentLeft = i5;
        this.parentTop = i6;
        this.parentRight = i7;
        this.parentBottom = i8;
        if (z5) {
            Assertions.checkNotNull(this.cueText);
            setupTextLayout();
        } else {
            Assertions.checkNotNull(this.cueBitmap);
            setupBitmapLayout();
        }
        drawLayout(canvas2, z5);
    }

    private void setupTextLayout() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int round;
        int i6;
        CharSequence charSequence = this.cueText;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(charSequence);
        int i7 = this.parentRight - this.parentLeft;
        int i8 = this.parentBottom - this.parentTop;
        this.textPaint.setTextSize(this.defaultTextSizePx);
        int i9 = (int) ((this.defaultTextSizePx * 0.125f) + 0.5f);
        int i10 = i9 * 2;
        int i11 = i7 - i10;
        float f = this.cueSize;
        if (f != -3.4028235E38f) {
            i11 = (int) (((float) i11) * f);
        }
        int i12 = i11;
        if (i12 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (!this.applyEmbeddedStyles) {
            for (Object removeSpan : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class)) {
                spannableStringBuilder.removeSpan(removeSpan);
            }
        } else if (!this.applyEmbeddedFontSizes) {
            for (AbsoluteSizeSpan removeSpan2 : (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AbsoluteSizeSpan.class)) {
                spannableStringBuilder.removeSpan(removeSpan2);
            }
            for (RelativeSizeSpan removeSpan3 : (RelativeSizeSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), RelativeSizeSpan.class)) {
                spannableStringBuilder.removeSpan(removeSpan3);
            }
        } else {
            float f2 = this.cueTextSizePx;
            if (f2 > 0.0f) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) f2), 0, spannableStringBuilder.length(), 16711680);
            }
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.edgeType == 1) {
            for (ForegroundColorSpan removeSpan4 : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(removeSpan4);
            }
        }
        if (Color.alpha(this.backgroundColor) > 0) {
            int i13 = this.edgeType;
            if (i13 == 0 || i13 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.backgroundColor), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.cueTextAlignment;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = r3;
        SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder2;
        int i14 = i9;
        String str = "SubtitlePainter";
        StaticLayout staticLayout2 = new StaticLayout(spannableStringBuilder, this.textPaint, i12, alignment2, this.spacingMult, this.spacingAdd, true);
        this.textLayout = staticLayout;
        int height = this.textLayout.getHeight();
        int lineCount = this.textLayout.getLineCount();
        int i15 = 0;
        for (int i16 = 0; i16 < lineCount; i16++) {
            i15 = Math.max((int) Math.ceil((double) this.textLayout.getLineWidth(i16)), i15);
        }
        if (this.cueSize == -3.4028235E38f || i15 >= i12) {
            i12 = i15;
        }
        int i17 = i12 + i10;
        float f3 = this.cuePosition;
        if (f3 != -3.4028235E38f) {
            int round2 = Math.round(((float) i7) * f3) + this.parentLeft;
            int i18 = this.cuePositionAnchor;
            i2 = 1;
            if (i18 != 1) {
                i = 2;
                if (i18 == 2) {
                    round2 -= i17;
                }
            } else {
                i = 2;
                round2 = ((round2 * 2) - i17) / 2;
            }
            i4 = Math.max(round2, this.parentLeft);
            i3 = Math.min(i17 + i4, this.parentRight);
        } else {
            i2 = 1;
            i = 2;
            i4 = ((i7 - i17) / 2) + this.parentLeft;
            i3 = i4 + i17;
        }
        int i19 = i3 - i4;
        if (i19 <= 0) {
            Log.w(str, "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f4 = this.cueLine;
        if (f4 != -3.4028235E38f) {
            if (this.cueLineType == 0) {
                round = Math.round(((float) i8) * f4);
                i6 = this.parentTop;
            } else {
                int lineBottom = this.textLayout.getLineBottom(0) - this.textLayout.getLineTop(0);
                float f5 = this.cueLine;
                if (f5 >= 0.0f) {
                    round = Math.round(f5 * ((float) lineBottom));
                    i6 = this.parentTop;
                } else {
                    round = Math.round((f5 + 1.0f) * ((float) lineBottom));
                    i6 = this.parentBottom;
                }
            }
            int i20 = round + i6;
            int i21 = this.cueLineAnchor;
            if (i21 == i) {
                i20 -= height;
            } else if (i21 == i2) {
                i20 = ((i20 * 2) - height) / i;
            }
            int i22 = i20 + height;
            int i23 = this.parentBottom;
            if (i22 > i23) {
                i5 = i23 - height;
            } else {
                int i24 = this.parentTop;
                i5 = i20 < i24 ? i24 : i20;
            }
        } else {
            i5 = (this.parentBottom - height) - ((int) (((float) i8) * this.bottomPaddingFraction));
        }
        this.textLayout = new StaticLayout(spannableStringBuilder, this.textPaint, i19, alignment2, this.spacingMult, this.spacingAdd, true);
        this.edgeLayout = new StaticLayout(spannableStringBuilder3, this.textPaint, i19, alignment2, this.spacingMult, this.spacingAdd, true);
        this.textLeft = i4;
        this.textTop = i5;
        this.textPaddingX = i14;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    private void setupBitmapLayout() {
        int i;
        int i2;
        float f;
        float f2;
        Bitmap bitmap = this.cueBitmap;
        int i3 = this.parentRight;
        int i4 = this.parentLeft;
        int i5 = this.parentBottom;
        int i6 = this.parentTop;
        float f3 = (float) (i3 - i4);
        float f4 = ((float) i4) + (this.cuePosition * f3);
        float f5 = (float) (i5 - i6);
        float f6 = ((float) i6) + (this.cueLine * f5);
        int round = Math.round(f3 * this.cueSize);
        float f7 = this.cueBitmapHeight;
        if (f7 != -3.4028235E38f) {
            i = Math.round(f5 * f7);
        } else {
            i = Math.round(((float) round) * (((float) bitmap.getHeight()) / ((float) bitmap.getWidth())));
        }
        int i7 = this.cuePositionAnchor;
        if (i7 == 2) {
            f2 = (float) round;
        } else {
            if (i7 == 1) {
                f2 = (float) (round / 2);
            }
            int round2 = Math.round(f4);
            i2 = this.cueLineAnchor;
            if (i2 != 2) {
                f = (float) i;
            } else {
                if (i2 == 1) {
                    f = (float) (i / 2);
                }
                int round3 = Math.round(f6);
                this.bitmapRect = new Rect(round2, round3, round + round2, i + round3);
            }
            f6 -= f;
            int round32 = Math.round(f6);
            this.bitmapRect = new Rect(round2, round32, round + round2, i + round32);
        }
        f4 -= f2;
        int round22 = Math.round(f4);
        i2 = this.cueLineAnchor;
        if (i2 != 2) {
        }
        f6 -= f;
        int round322 = Math.round(f6);
        this.bitmapRect = new Rect(round22, round322, round + round22, i + round322);
    }

    private void drawLayout(Canvas canvas, boolean z) {
        if (z) {
            drawTextLayout(canvas);
            return;
        }
        Assertions.checkNotNull(this.bitmapRect);
        Assertions.checkNotNull(this.cueBitmap);
        drawBitmapLayout(canvas);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
     arg types: [int, int, int, int]
     candidates:
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
    private void drawTextLayout(Canvas canvas) {
        int i;
        StaticLayout staticLayout = this.textLayout;
        StaticLayout staticLayout2 = this.edgeLayout;
        if (staticLayout != null && staticLayout2 != null) {
            int save = canvas.save();
            canvas.translate((float) this.textLeft, (float) this.textTop);
            if (Color.alpha(this.windowColor) > 0) {
                this.paint.setColor(this.windowColor);
                canvas.drawRect((float) (-this.textPaddingX), 0.0f, (float) (staticLayout.getWidth() + this.textPaddingX), (float) staticLayout.getHeight(), this.paint);
            }
            int i2 = this.edgeType;
            boolean z = true;
            if (i2 == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.outlineWidth);
                this.textPaint.setColor(this.edgeColor);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout2.draw(canvas);
            } else if (i2 == 2) {
                TextPaint textPaint2 = this.textPaint;
                float f = this.shadowRadius;
                float f2 = this.shadowOffset;
                textPaint2.setShadowLayer(f, f2, f2, this.edgeColor);
            } else if (i2 == 3 || i2 == 4) {
                if (this.edgeType != 3) {
                    z = false;
                }
                int i3 = -1;
                if (z) {
                    i = -1;
                } else {
                    i = this.edgeColor;
                }
                if (z) {
                    i3 = this.edgeColor;
                }
                float f3 = this.shadowRadius / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                float f4 = -f3;
                this.textPaint.setShadowLayer(this.shadowRadius, f4, f4, i);
                staticLayout2.draw(canvas);
                this.textPaint.setShadowLayer(this.shadowRadius, f3, f3, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void drawBitmapLayout(Canvas canvas) {
        canvas.drawBitmap(this.cueBitmap, (Rect) null, this.bitmapRect, (Paint) null);
    }

    private static boolean areCharSequencesEqual(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != charSequence2) {
            return charSequence != null && charSequence.equals(charSequence2);
        }
        return true;
    }
}
