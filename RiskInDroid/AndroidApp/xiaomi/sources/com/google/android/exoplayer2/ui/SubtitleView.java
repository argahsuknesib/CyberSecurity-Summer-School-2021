package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

public final class SubtitleView extends FrameLayout implements TextOutput {
    private View innerSubtitleView;
    private Output output;
    private int viewType;

    interface Output {
        void onCues(List<Cue> list);

        void setApplyEmbeddedFontSizes(boolean z);

        void setApplyEmbeddedStyles(boolean z);

        void setBottomPaddingFraction(float f);

        void setStyle(CaptionStyleCompat captionStyleCompat);

        void setTextSize(int i, float f);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType {
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SubtitleTextView subtitleTextView = new SubtitleTextView(context, attributeSet);
        this.output = subtitleTextView;
        this.innerSubtitleView = subtitleTextView;
        addView(this.innerSubtitleView);
        this.viewType = 1;
    }

    public final void onCues(List<Cue> list) {
        setCues(list);
    }

    public final void setCues(List<Cue> list) {
        Output output2 = this.output;
        if (list == null) {
            list = Collections.emptyList();
        }
        output2.onCues(list);
    }

    public final void setViewType(int i) {
        if (this.viewType != i) {
            if (i == 1) {
                setView(new SubtitleTextView(getContext()));
            } else if (i == 2) {
                setView(new SubtitleWebView(getContext()));
            } else {
                throw new IllegalArgumentException();
            }
            this.viewType = i;
        }
    }

    private <T extends View & Output> void setView(T t) {
        removeView(this.innerSubtitleView);
        this.innerSubtitleView = t;
        this.output = (Output) t;
        addView(t);
    }

    public final void setFixedTextSize(int i, float f) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setTextSize(2, TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    public final void setUserDefaultTextSize() {
        setFractionalTextSize(((Util.SDK_INT < 19 || isInEditMode()) ? 1.0f : getUserCaptionFontScaleV19()) * 0.0533f);
    }

    public final void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public final void setFractionalTextSize(float f, boolean z) {
        setTextSize(z ? 1 : 0, f);
    }

    private void setTextSize(int i, float f) {
        this.output.setTextSize(i, f);
    }

    public final void setApplyEmbeddedStyles(boolean z) {
        this.output.setApplyEmbeddedStyles(z);
    }

    public final void setApplyEmbeddedFontSizes(boolean z) {
        this.output.setApplyEmbeddedFontSizes(z);
    }

    public final void setUserDefaultStyle() {
        setStyle((Util.SDK_INT < 19 || !isCaptionManagerEnabled() || isInEditMode()) ? CaptionStyleCompat.DEFAULT : getUserCaptionStyleV19());
    }

    public final void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.output.setStyle(captionStyleCompat);
    }

    public final void setBottomPaddingFraction(float f) {
        this.output.setBottomPaddingFraction(f);
    }

    private boolean isCaptionManagerEnabled() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).isEnabled();
    }

    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyleV19() {
        return CaptionStyleCompat.createFromCaptionStyle(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }
}
