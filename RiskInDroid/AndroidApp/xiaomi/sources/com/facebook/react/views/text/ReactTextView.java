package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
    private boolean mContainsImages;
    private int mDefaultGravityHorizontal = (getGravity() & 8388615);
    private int mDefaultGravityVertical = (getGravity() & 112);
    private TextUtils.TruncateAt mEllipsizeLocation = TextUtils.TruncateAt.END;
    private int mLinkifyMaskType = 0;
    private boolean mNotifyOnInlineViewLayout;
    private int mNumberOfLines = Integer.MAX_VALUE;
    private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
    private Spannable mSpanned;
    private int mTextAlign = 0;

    public boolean hasOverlappingRendering() {
        return false;
    }

    public ReactTextView(Context context) {
        super(context);
    }

    private WritableMap inlineViewJson(int i, int i2, int i3, int i4, int i5, int i6) {
        WritableMap createMap = Arguments.createMap();
        if (i == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt("index", i2);
        } else if (i == 0) {
            createMap.putString("visibility", "visible");
            createMap.putInt("index", i2);
            createMap.putDouble("left", (double) PixelUtil.toDIPFromPixel((float) i3));
            createMap.putDouble("top", (double) PixelUtil.toDIPFromPixel((float) i4));
            createMap.putDouble("right", (double) PixelUtil.toDIPFromPixel((float) i5));
            createMap.putDouble("bottom", (double) PixelUtil.toDIPFromPixel((float) i6));
        } else {
            createMap.putString("visibility", "unknown");
            createMap.putInt("index", i2);
        }
        return createMap;
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        return context instanceof TintContextWrapper ? (ReactContext) ((TintContextWrapper) context).getBaseContext() : (ReactContext) context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r11 != false) goto L_0x00d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0123  */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        float f;
        if ((getText() instanceof Spanned) && getReactContext().hasCatalystInstance()) {
            UIManagerModule uIManagerModule = (UIManagerModule) getReactContext().getNativeModule(UIManagerModule.class);
            Spanned spanned = (Spanned) getText();
            Layout layout = getLayout();
            TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) spanned.getSpans(0, spanned.length(), TextInlineViewPlaceholderSpan.class);
            ArrayList arrayList = this.mNotifyOnInlineViewLayout ? new ArrayList(textInlineViewPlaceholderSpanArr.length) : null;
            int i9 = i3 - i;
            int i10 = i4 - i2;
            int length = textInlineViewPlaceholderSpanArr.length;
            int i11 = 0;
            while (i11 < length) {
                TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = textInlineViewPlaceholderSpanArr[i11];
                View resolveView = uIManagerModule.resolveView(textInlineViewPlaceholderSpan.getReactTag());
                int spanStart = spanned.getSpanStart(textInlineViewPlaceholderSpan);
                int lineForOffset = layout.getLineForOffset(spanStart);
                boolean z2 = true;
                if ((!(layout.getEllipsisCount(lineForOffset) > 0) || spanStart < layout.getLineStart(lineForOffset) + layout.getEllipsisStart(lineForOffset)) && lineForOffset < this.mNumberOfLines && spanStart < layout.getLineEnd(lineForOffset)) {
                    int width = textInlineViewPlaceholderSpan.getWidth();
                    int height = textInlineViewPlaceholderSpan.getHeight();
                    boolean isRtlCharAt = layout.isRtlCharAt(spanStart);
                    int i12 = i11;
                    int i13 = length;
                    boolean z3 = layout.getParagraphDirection(lineForOffset) == -1;
                    if (spanStart != spanned.length() - 1) {
                        if (z3 == isRtlCharAt) {
                            f = layout.getPrimaryHorizontal(spanStart);
                        } else {
                            f = layout.getSecondaryHorizontal(spanStart);
                        }
                        int i14 = (int) f;
                        i7 = z3 ? i9 - (((int) layout.getLineRight(lineForOffset)) - i14) : i14;
                    } else if (z3) {
                        i7 = i9 - ((int) layout.getLineWidth(lineForOffset));
                        if (!isRtlCharAt) {
                            i8 = getTotalPaddingRight();
                        } else {
                            i8 = getTotalPaddingLeft();
                        }
                        int i15 = i7 + i8;
                        int i16 = i + i15;
                        int totalPaddingTop = (getTotalPaddingTop() + layout.getLineBaseline(lineForOffset)) - height;
                        int i17 = i2 + totalPaddingTop;
                        if (i9 > i15 && i10 > totalPaddingTop) {
                            z2 = false;
                        }
                        int i18 = !z2 ? 8 : 0;
                        int i19 = i16 + width;
                        int i20 = i17 + height;
                        resolveView.setVisibility(i18);
                        resolveView.layout(i16, i17, i19, i20);
                        if (!this.mNotifyOnInlineViewLayout) {
                            int i21 = i18;
                            int i22 = i17;
                            int i23 = i16;
                            int i24 = i20;
                            int i25 = i22;
                            i5 = i12;
                            int i26 = i19;
                            i6 = i13;
                            arrayList.add(inlineViewJson(i21, spanStart, i23, i25, i26, i24));
                        } else {
                            i6 = i13;
                            i5 = i12;
                        }
                    } else {
                        i7 = (int) layout.getLineRight(lineForOffset);
                    }
                    i7 -= width;
                    if (!isRtlCharAt) {
                    }
                    int i152 = i7 + i8;
                    int i162 = i + i152;
                    int totalPaddingTop2 = (getTotalPaddingTop() + layout.getLineBaseline(lineForOffset)) - height;
                    int i172 = i2 + totalPaddingTop2;
                    z2 = false;
                    if (!z2) {
                    }
                    int i192 = i162 + width;
                    int i202 = i172 + height;
                    resolveView.setVisibility(i18);
                    resolveView.layout(i162, i172, i192, i202);
                    if (!this.mNotifyOnInlineViewLayout) {
                    }
                } else {
                    i5 = i11;
                    i6 = length;
                    resolveView.setVisibility(8);
                    if (this.mNotifyOnInlineViewLayout) {
                        arrayList.add(inlineViewJson(8, spanStart, -1, -1, -1, -1));
                    }
                }
                i11 = i5 + 1;
                length = i6;
            }
            if (this.mNotifyOnInlineViewLayout) {
                Collections.sort(arrayList, new Comparator() {
                    /* class com.facebook.react.views.text.ReactTextView.AnonymousClass1 */

                    public int compare(Object obj, Object obj2) {
                        return ((WritableMap) obj).getInt("index") - ((WritableMap) obj2).getInt("index");
                    }
                });
                WritableArray createArray = Arguments.createArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    createArray.pushMap((WritableMap) it.next());
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putArray("inlineViews", createArray);
                ((RCTEventEmitter) getReactContext().getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topInlineViewLayout", createMap);
            }
        }
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        this.mContainsImages = reactTextUpdate.containsImages();
        if (getLayoutParams() == null) {
            setLayoutParams(EMPTY_LAYOUT_PARAMS);
        }
        Spannable text = reactTextUpdate.getText();
        int i = this.mLinkifyMaskType;
        if (i > 0) {
            Linkify.addLinks(text, i);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(text);
        setPadding((int) Math.floor((double) reactTextUpdate.getPaddingLeft()), (int) Math.floor((double) reactTextUpdate.getPaddingTop()), (int) Math.floor((double) reactTextUpdate.getPaddingRight()), (int) Math.floor((double) reactTextUpdate.getPaddingBottom()));
        int textAlign = reactTextUpdate.getTextAlign();
        if (this.mTextAlign != textAlign) {
            this.mTextAlign = textAlign;
        }
        setGravityHorizontal(this.mTextAlign);
        if (Build.VERSION.SDK_INT >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
            setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
        }
        if (Build.VERSION.SDK_INT >= 26 && getJustificationMode() != reactTextUpdate.getJustificationMode()) {
            setJustificationMode(reactTextUpdate.getJustificationMode());
        }
        requestLayout();
    }

    public int reactTagForTouch(float f, float f2) {
        int i;
        CharSequence text = getText();
        int id = getId();
        int i2 = (int) f;
        int i3 = (int) f2;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i3);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i2 >= lineLeft && i2 <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i2);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = text.length();
                    for (int i4 = 0; i4 < reactTagSpanArr.length; i4++) {
                        int spanStart = spanned.getSpanStart(reactTagSpanArr[i4]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i4]);
                        if (spanEnd > offsetForHorizontal && (i = spanEnd - spanStart) <= length) {
                            id = reactTagSpanArr[i4].getReactTag();
                            length = i;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                FLog.e("ReactNative", "Crash in HorizontalMeasurementProvider: " + e.getMessage());
            }
        }
        return id;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onDetachedFromWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onDetachedFromWindow.onDetachedFromWindow();
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onStartTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onStartTemporaryDetach.onStartTemporaryDetach();
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onAttachedToWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onAttachedToWindow.onAttachedToWindow();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onFinishTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onFinishTemporaryDetach.onFinishTemporaryDetach();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & -8 & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        boolean z = true;
        if (this.mNumberOfLines != 1) {
            z = false;
        }
        setSingleLine(z);
        setMaxLines(this.mNumberOfLines);
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.mNotifyOnInlineViewLayout = z;
    }

    public void updateView() {
        setEllipsize(this.mNumberOfLines == Integer.MAX_VALUE ? null : this.mEllipsizeLocation);
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    public void setLinkifyMask(int i) {
        this.mLinkifyMaskType = i;
    }
}
