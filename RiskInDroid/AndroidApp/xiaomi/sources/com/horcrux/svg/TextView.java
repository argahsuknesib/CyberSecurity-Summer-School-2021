package com.horcrux.svg;

import _m_j.bak;
import _m_j.bal;
import _m_j.baq;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.TextProperties;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class TextView extends GroupView {
    double cachedAdvance = Double.NaN;
    private TextProperties.AlignmentBaseline mAlignmentBaseline;
    private String mBaselineShift = null;
    private ArrayList<baq> mDeltaX;
    private ArrayList<baq> mDeltaY;
    TextProperties.TextLengthAdjust mLengthAdjust = TextProperties.TextLengthAdjust.spacing;
    private ArrayList<baq> mPositionX;
    private ArrayList<baq> mPositionY;
    private ArrayList<baq> mRotate;
    baq mTextLength = null;

    public TextView(ReactContext reactContext) {
        super(reactContext);
    }

    public void invalidate() {
        if (this.mPath != null) {
            super.invalidate();
            getTextContainer().clearChildCache();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.cachedAdvance = Double.NaN;
        super.clearCache();
    }

    @ReactProp(name = "textLength")
    public void setTextLength(Dynamic dynamic) {
        this.mTextLength = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "lengthAdjust")
    public void setLengthAdjust(String str) {
        this.mLengthAdjust = TextProperties.TextLengthAdjust.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "alignmentBaseline")
    public void setMethod(String str) {
        this.mAlignmentBaseline = TextProperties.AlignmentBaseline.getEnum(str);
        invalidate();
    }

    @ReactProp(name = "verticalAlign")
    public void setVerticalAlign(String str) {
        if (str != null) {
            String trim = str.trim();
            int lastIndexOf = trim.lastIndexOf(32);
            try {
                this.mAlignmentBaseline = TextProperties.AlignmentBaseline.getEnum(trim.substring(lastIndexOf));
            } catch (IllegalArgumentException unused) {
                this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
            }
            try {
                this.mBaselineShift = trim.substring(0, lastIndexOf);
            } catch (IndexOutOfBoundsException unused2) {
                this.mBaselineShift = null;
            }
        } else {
            this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
            this.mBaselineShift = null;
        }
        invalidate();
    }

    @ReactProp(name = "rotate")
    public void setRotate(Dynamic dynamic) {
        this.mRotate = baq.O00000Oo(dynamic);
        invalidate();
    }

    @ReactProp(name = "dx")
    public void setDeltaX(Dynamic dynamic) {
        this.mDeltaX = baq.O00000Oo(dynamic);
        invalidate();
    }

    @ReactProp(name = "dy")
    public void setDeltaY(Dynamic dynamic) {
        this.mDeltaY = baq.O00000Oo(dynamic);
        invalidate();
    }

    @ReactProp(name = "x")
    public void setPositionX(Dynamic dynamic) {
        this.mPositionX = baq.O00000Oo(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setPositionY(Dynamic dynamic) {
        this.mPositionY = baq.O00000Oo(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        if (f > 0.01f) {
            setupGlyphContext(canvas);
            clip(canvas, paint);
            getGroupPath(canvas, paint);
            drawGroup(canvas, paint, f);
        }
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        setupGlyphContext(canvas);
        return getGroupPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint, Region.Op op) {
        return getPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public TextProperties.AlignmentBaseline getAlignmentBaseline() {
        TextProperties.AlignmentBaseline alignmentBaseline;
        if (this.mAlignmentBaseline == null) {
            ViewParent parent = getParent();
            while (parent != null) {
                if (!(parent instanceof TextView) || (alignmentBaseline = ((TextView) parent).mAlignmentBaseline) == null) {
                    parent = parent.getParent();
                } else {
                    this.mAlignmentBaseline = alignmentBaseline;
                    return alignmentBaseline;
                }
            }
        }
        if (this.mAlignmentBaseline == null) {
            this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
        }
        return this.mAlignmentBaseline;
    }

    /* access modifiers changed from: package-private */
    public String getBaselineShift() {
        String str;
        if (this.mBaselineShift == null) {
            ViewParent parent = getParent();
            while (parent != null) {
                if (!(parent instanceof TextView) || (str = ((TextView) parent).mBaselineShift) == null) {
                    parent = parent.getParent();
                } else {
                    this.mBaselineShift = str;
                    return str;
                }
            }
        }
        return this.mBaselineShift;
    }

    /* access modifiers changed from: package-private */
    public Path getGroupPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        pushGlyphContext();
        this.mPath = super.getPath(canvas, paint);
        popGlyphContext();
        return this.mPath;
    }

    /* access modifiers changed from: package-private */
    public void pushGlyphContext() {
        boolean z = !(this instanceof TextPathView) && !(this instanceof TSpanView);
        bal textRootGlyphContext = getTextRootGlyphContext();
        ReadableMap readableMap = this.mFont;
        ArrayList<baq> arrayList = this.mPositionX;
        ArrayList<baq> arrayList2 = this.mPositionY;
        ArrayList<baq> arrayList3 = this.mDeltaX;
        ArrayList<baq> arrayList4 = this.mDeltaY;
        ArrayList<baq> arrayList5 = this.mRotate;
        if (z) {
            textRootGlyphContext.O000O0o0 = 0;
            textRootGlyphContext.O00oOoOo = 0;
            textRootGlyphContext.O000O0Oo = 0;
            textRootGlyphContext.O000O0OO = 0;
            textRootGlyphContext.O000O00o = 0;
            textRootGlyphContext.O000OO0o = -1;
            textRootGlyphContext.O000OO00 = -1;
            textRootGlyphContext.O000O0oo = -1;
            textRootGlyphContext.O000O0oO = -1;
            textRootGlyphContext.O000O0o = -1;
            textRootGlyphContext.O0000oo0 = 0.0d;
            textRootGlyphContext.O0000oOo = 0.0d;
            textRootGlyphContext.O0000oOO = 0.0d;
            textRootGlyphContext.O0000oO = 0.0d;
        }
        textRootGlyphContext.O000000o(this, readableMap);
        if (!(arrayList == null || arrayList.size() == 0)) {
            textRootGlyphContext.O000O00o++;
            textRootGlyphContext.O000O0o = -1;
            textRootGlyphContext.O0000O0o.add(Integer.valueOf(textRootGlyphContext.O000O0o));
            textRootGlyphContext.O0000oo = bal.O000000o(arrayList);
            textRootGlyphContext.O00000Oo.add(textRootGlyphContext.O0000oo);
        }
        if (!(arrayList2 == null || arrayList2.size() == 0)) {
            textRootGlyphContext.O000O0OO++;
            textRootGlyphContext.O000O0oO = -1;
            textRootGlyphContext.O0000OOo.add(Integer.valueOf(textRootGlyphContext.O000O0oO));
            textRootGlyphContext.O0000ooO = bal.O000000o(arrayList2);
            textRootGlyphContext.O00000o0.add(textRootGlyphContext.O0000ooO);
        }
        if (!(arrayList3 == null || arrayList3.size() == 0)) {
            textRootGlyphContext.O000O0Oo++;
            textRootGlyphContext.O000O0oo = -1;
            textRootGlyphContext.O0000Oo0.add(Integer.valueOf(textRootGlyphContext.O000O0oo));
            textRootGlyphContext.O0000ooo = bal.O000000o(arrayList3);
            textRootGlyphContext.O00000o.add(textRootGlyphContext.O0000ooo);
        }
        if (!(arrayList4 == null || arrayList4.size() == 0)) {
            textRootGlyphContext.O00oOoOo++;
            textRootGlyphContext.O000OO00 = -1;
            textRootGlyphContext.O0000Oo.add(Integer.valueOf(textRootGlyphContext.O000OO00));
            textRootGlyphContext.O00oOooO = bal.O000000o(arrayList4);
            textRootGlyphContext.O00000oO.add(textRootGlyphContext.O00oOooO);
        }
        if (!(arrayList5 == null || arrayList5.size() == 0)) {
            textRootGlyphContext.O000O0o0++;
            textRootGlyphContext.O000OO0o = -1;
            textRootGlyphContext.O0000OoO.add(Integer.valueOf(textRootGlyphContext.O000OO0o));
            int size = arrayList5.size();
            double[] dArr = new double[size];
            for (int i = 0; i < size; i++) {
                dArr[i] = arrayList5.get(i).f12752O000000o;
            }
            textRootGlyphContext.O00oOooo = dArr;
            textRootGlyphContext.O00000oo.add(textRootGlyphContext.O00oOooo);
        }
        textRootGlyphContext.O000000o();
    }

    /* access modifiers changed from: package-private */
    public TextView getTextAnchorRoot() {
        ArrayList<bak> arrayList = getTextRootGlyphContext().f12746O000000o;
        ViewParent parent = getParent();
        int size = arrayList.size() - 1;
        ViewParent viewParent = parent;
        TextView textView = this;
        while (size >= 0 && (viewParent instanceof TextView) && arrayList.get(size).O0000OOo != TextProperties.TextAnchor.start && textView.mPositionX == null) {
            textView = viewParent;
            viewParent = textView.getParent();
            size--;
        }
        return textView;
    }

    /* access modifiers changed from: package-private */
    public double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        double d = 0.0d;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TextView) {
                d += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
            }
        }
        this.cachedAdvance = d;
        return d;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* access modifiers changed from: package-private */
    public TextView getTextContainer() {
        TextView textView = this;
        ViewParent viewParent = getParent();
        while (viewParent instanceof TextView) {
            textView = (TextView) viewParent;
            viewParent = textView.getParent();
        }
        return textView;
    }

    @ReactProp(name = "baselineShift")
    public void setBaselineShift(Dynamic dynamic) {
        String str;
        int i = baq.AnonymousClass1.f12753O000000o[dynamic.getType().ordinal()];
        if (i == 1) {
            str = String.valueOf(dynamic.asDouble());
        } else if (i != 2) {
            str = null;
        } else {
            str = dynamic.asString();
        }
        this.mBaselineShift = str;
        invalidate();
    }
}
