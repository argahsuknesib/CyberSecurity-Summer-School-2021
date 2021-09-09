package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.ArrayList;

@TargetApi(23)
public class ReactTextShadowNode extends ReactBaseTextShadowNode {
    public static final TextPaint sTextPaintInstance = new TextPaint(1);
    public Spannable mPreparedSpannableText;
    public boolean mShouldNotifyOnTextLayout;
    private final YogaMeasureFunction mTextMeasureFunction = new YogaMeasureFunction() {
        /* class com.facebook.react.views.text.ReactTextShadowNode.AnonymousClass1 */

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r12v15, types: [android.text.BoringLayout] */
        /* JADX WARNING: Multi-variable type inference failed */
        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            StaticLayout staticLayout;
            TextPaint textPaint = ReactTextShadowNode.sTextPaintInstance;
            textPaint.setTextSize((float) ReactTextShadowNode.this.mTextAttributes.getEffectiveFontSize());
            Spanned spanned = (Spanned) Assertions.assertNotNull(ReactTextShadowNode.this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(spanned, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spanned, textPaint) : Float.NaN;
            boolean z = yogaMeasureMode == YogaMeasureMode.UNDEFINED || f < 0.0f;
            Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
            int textAlign = ReactTextShadowNode.this.getTextAlign();
            if (textAlign == 1) {
                alignment = Layout.Alignment.ALIGN_CENTER;
            } else if (textAlign == 3) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (textAlign == 5) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            Layout.Alignment alignment2 = alignment;
            if (isBoring == null && (z || (!YogaConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                int ceil = (int) Math.ceil((double) desiredWidth);
                if (Build.VERSION.SDK_INT < 23) {
                    staticLayout = new StaticLayout(spanned, textPaint, ceil, alignment2, 1.0f, 0.0f, ReactTextShadowNode.this.mIncludeFontPadding);
                } else {
                    StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spanned, 0, spanned.length(), textPaint, ceil).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(ReactTextShadowNode.this.mHyphenationFrequency);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency.setJustificationMode(ReactTextShadowNode.this.mJustificationMode);
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
                    }
                    staticLayout = hyphenationFrequency.build();
                }
            } else if (isBoring != null && (z || ((float) isBoring.width) <= f)) {
                staticLayout = BoringLayout.make(spanned, textPaint, isBoring.width, alignment2, 1.0f, 0.0f, isBoring, ReactTextShadowNode.this.mIncludeFontPadding);
            } else if (Build.VERSION.SDK_INT < 23) {
                staticLayout = new StaticLayout(spanned, textPaint, (int) f, alignment2, 1.0f, 0.0f, ReactTextShadowNode.this.mIncludeFontPadding);
            } else {
                StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spanned, 0, spanned.length(), textPaint, (int) f).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(ReactTextShadowNode.this.mHyphenationFrequency);
                if (Build.VERSION.SDK_INT >= 28) {
                    hyphenationFrequency2.setUseLineSpacingFromFallbacks(true);
                }
                staticLayout = hyphenationFrequency2.build();
            }
            if (ReactTextShadowNode.this.mShouldNotifyOnTextLayout) {
                WritableArray fontMetrics = FontMetricsUtil.getFontMetrics(spanned, staticLayout, ReactTextShadowNode.sTextPaintInstance, ReactTextShadowNode.this.getThemedContext());
                WritableMap createMap = Arguments.createMap();
                createMap.putArray("lines", fontMetrics);
                ((RCTEventEmitter) ReactTextShadowNode.this.getThemedContext().getJSModule(RCTEventEmitter.class)).receiveEvent(ReactTextShadowNode.this.getReactTag(), "topTextLayout", createMap);
            }
            if (ReactTextShadowNode.this.mNumberOfLines == -1 || ReactTextShadowNode.this.mNumberOfLines >= staticLayout.getLineCount()) {
                return YogaMeasureOutput.make(staticLayout.getWidth(), staticLayout.getHeight());
            }
            return YogaMeasureOutput.make(staticLayout.getWidth(), staticLayout.getLineBottom(ReactTextShadowNode.this.mNumberOfLines - 1));
        }
    };

    public boolean hoistNativeChildren() {
        return true;
    }

    public boolean isVirtualAnchor() {
        return false;
    }

    public ReactTextShadowNode() {
        initMeasureFunction();
    }

    private void initMeasureFunction() {
        if (!isVirtual()) {
            setMeasureFunction(this.mTextMeasureFunction);
        }
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

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        this.mPreparedSpannableText = spannedFromShadowNode(this, null, true, nativeViewHierarchyOptimizer);
        markUpdated();
    }

    public void markUpdated() {
        super.markUpdated();
        super.dirty();
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        Spannable spannable = this.mPreparedSpannableText;
        if (spannable != null) {
            uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), new ReactTextUpdate(spannable, -1, this.mContainsImages, getPadding(4), getPadding(1), getPadding(5), getPadding(3), getTextAlign(), this.mTextBreakStrategy, this.mJustificationMode));
        }
    }

    @ReactProp(name = "onTextLayout")
    public void setShouldNotifyOnTextLayout(boolean z) {
        this.mShouldNotifyOnTextLayout = z;
    }

    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        if (this.mInlineViews == null || this.mInlineViews.isEmpty()) {
            return null;
        }
        Spanned spanned = (Spanned) Assertions.assertNotNull(this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) spanned.getSpans(0, spanned.length(), TextInlineViewPlaceholderSpan.class);
        ArrayList arrayList = new ArrayList(textInlineViewPlaceholderSpanArr.length);
        for (TextInlineViewPlaceholderSpan reactTag : textInlineViewPlaceholderSpanArr) {
            ReactShadowNode reactShadowNode = (ReactShadowNode) this.mInlineViews.get(Integer.valueOf(reactTag.getReactTag()));
            reactShadowNode.calculateLayout();
            arrayList.add(reactShadowNode);
        }
        return arrayList;
    }
}
