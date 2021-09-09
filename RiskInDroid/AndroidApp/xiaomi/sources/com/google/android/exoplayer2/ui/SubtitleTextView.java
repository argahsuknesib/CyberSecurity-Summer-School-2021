package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class SubtitleTextView extends View implements SubtitleView.Output {
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List<Cue> cues;
    private final List<SubtitlePainter> painters;
    private CaptionStyleCompat style;
    private float textSize;
    private int textSizeType;

    public SubtitleTextView(Context context) {
        this(context, null);
    }

    public SubtitleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.painters = new ArrayList();
        this.cues = Collections.emptyList();
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        this.style = CaptionStyleCompat.DEFAULT;
        this.bottomPaddingFraction = 0.08f;
    }

    public final void onCues(List<Cue> list) {
        List<Cue> list2 = this.cues;
        if (list2 == list) {
            return;
        }
        if (!list2.isEmpty() || !list.isEmpty()) {
            this.cues = list;
            while (this.painters.size() < list.size()) {
                this.painters.add(new SubtitlePainter(getContext()));
            }
            invalidate();
        }
    }

    public final void setTextSize(int i, float f) {
        if (this.textSizeType != i || this.textSize != f) {
            this.textSizeType = i;
            this.textSize = f;
            invalidate();
        }
    }

    public final void setApplyEmbeddedStyles(boolean z) {
        if (this.applyEmbeddedStyles != z || this.applyEmbeddedFontSizes != z) {
            this.applyEmbeddedStyles = z;
            this.applyEmbeddedFontSizes = z;
            invalidate();
        }
    }

    public final void setApplyEmbeddedFontSizes(boolean z) {
        if (this.applyEmbeddedFontSizes != z) {
            this.applyEmbeddedFontSizes = z;
            invalidate();
        }
    }

    public final void setStyle(CaptionStyleCompat captionStyleCompat) {
        if (this.style != captionStyleCompat) {
            this.style = captionStyleCompat;
            invalidate();
        }
    }

    public final void setBottomPaddingFraction(float f) {
        if (this.bottomPaddingFraction != f) {
            this.bottomPaddingFraction = f;
            invalidate();
        }
    }

    public final void dispatchDraw(Canvas canvas) {
        List<Cue> list = this.cues;
        if (!list.isEmpty()) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int paddingBottom = height - getPaddingBottom();
            if (paddingBottom > paddingTop && width > paddingLeft) {
                int i = paddingBottom - paddingTop;
                float resolveTextSize = SubtitleViewUtils.resolveTextSize(this.textSizeType, this.textSize, height, i);
                if (resolveTextSize > 0.0f) {
                    int size = list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Cue cue = list.get(i2);
                        float resolveCueTextSize = SubtitleViewUtils.resolveCueTextSize(cue, height, i);
                        boolean z = this.applyEmbeddedStyles;
                        boolean z2 = this.applyEmbeddedFontSizes;
                        CaptionStyleCompat captionStyleCompat = this.style;
                        int i3 = i2;
                        float f = resolveCueTextSize;
                        int i4 = size;
                        float f2 = this.bottomPaddingFraction;
                        int i5 = paddingBottom;
                        int i6 = width;
                        this.painters.get(i2).draw(cue, z, z2, captionStyleCompat, resolveTextSize, f, f2, canvas, paddingLeft, paddingTop, i6, i5);
                        i2 = i3 + 1;
                        size = i4;
                        i = i;
                        paddingBottom = i5;
                        width = i6;
                        paddingTop = paddingTop;
                        paddingLeft = paddingLeft;
                    }
                }
            }
        }
    }
}
