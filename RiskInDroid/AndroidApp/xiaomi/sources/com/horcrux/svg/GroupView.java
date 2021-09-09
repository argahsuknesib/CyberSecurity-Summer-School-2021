package com.horcrux.svg;

import _m_j.bal;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
public class GroupView extends RenderableView {
    ReadableMap mFont;
    private bal mGlyphContext;

    public GroupView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "font")
    public void setFont(ReadableMap readableMap) {
        this.mFont = readableMap;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setupGlyphContext(Canvas canvas) {
        RectF rectF = new RectF(canvas.getClipBounds());
        if (this.mMatrix != null) {
            this.mMatrix.mapRect(rectF);
        }
        if (this.mTransform != null) {
            this.mTransform.mapRect(rectF);
        }
        this.mGlyphContext = new bal(this.mScale, rectF.width(), rectF.height());
    }

    public bal getGlyphContext() {
        return this.mGlyphContext;
    }

    private static <T> T requireNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: package-private */
    public bal getTextRootGlyphContext() {
        return ((GroupView) requireNonNull(getTextRoot())).getGlyphContext();
    }

    /* access modifiers changed from: package-private */
    public void pushGlyphContext() {
        bal textRootGlyphContext = getTextRootGlyphContext();
        textRootGlyphContext.O000000o(this, this.mFont);
        textRootGlyphContext.O000000o();
    }

    /* access modifiers changed from: package-private */
    public void popGlyphContext() {
        bal textRootGlyphContext = getTextRootGlyphContext();
        textRootGlyphContext.f12746O000000o.remove(textRootGlyphContext.O000OO);
        textRootGlyphContext.O0000Ooo.remove(textRootGlyphContext.O000OO);
        textRootGlyphContext.O0000o00.remove(textRootGlyphContext.O000OO);
        textRootGlyphContext.O0000o0.remove(textRootGlyphContext.O000OO);
        textRootGlyphContext.O0000o0O.remove(textRootGlyphContext.O000OO);
        textRootGlyphContext.O0000o0o.remove(textRootGlyphContext.O000OO);
        textRootGlyphContext.O000OO--;
        int i = textRootGlyphContext.O000O00o;
        int i2 = textRootGlyphContext.O000O0OO;
        int i3 = textRootGlyphContext.O000O0Oo;
        int i4 = textRootGlyphContext.O00oOoOo;
        int i5 = textRootGlyphContext.O000O0o0;
        textRootGlyphContext.O0000oO0 = textRootGlyphContext.f12746O000000o.get(textRootGlyphContext.O000OO);
        textRootGlyphContext.O000O00o = textRootGlyphContext.O0000Ooo.get(textRootGlyphContext.O000OO).intValue();
        textRootGlyphContext.O000O0OO = textRootGlyphContext.O0000o00.get(textRootGlyphContext.O000OO).intValue();
        textRootGlyphContext.O000O0Oo = textRootGlyphContext.O0000o0.get(textRootGlyphContext.O000OO).intValue();
        textRootGlyphContext.O00oOoOo = textRootGlyphContext.O0000o0O.get(textRootGlyphContext.O000OO).intValue();
        textRootGlyphContext.O000O0o0 = textRootGlyphContext.O0000o0o.get(textRootGlyphContext.O000OO).intValue();
        if (i != textRootGlyphContext.O000O00o) {
            textRootGlyphContext.O00000Oo.remove(i);
            textRootGlyphContext.O0000oo = textRootGlyphContext.O00000Oo.get(textRootGlyphContext.O000O00o);
            textRootGlyphContext.O000O0o = textRootGlyphContext.O0000O0o.get(textRootGlyphContext.O000O00o).intValue();
        }
        if (i2 != textRootGlyphContext.O000O0OO) {
            textRootGlyphContext.O00000o0.remove(i2);
            textRootGlyphContext.O0000ooO = textRootGlyphContext.O00000o0.get(textRootGlyphContext.O000O0OO);
            textRootGlyphContext.O000O0oO = textRootGlyphContext.O0000OOo.get(textRootGlyphContext.O000O0OO).intValue();
        }
        if (i3 != textRootGlyphContext.O000O0Oo) {
            textRootGlyphContext.O00000o.remove(i3);
            textRootGlyphContext.O0000ooo = textRootGlyphContext.O00000o.get(textRootGlyphContext.O000O0Oo);
            textRootGlyphContext.O000O0oo = textRootGlyphContext.O0000Oo0.get(textRootGlyphContext.O000O0Oo).intValue();
        }
        if (i4 != textRootGlyphContext.O00oOoOo) {
            textRootGlyphContext.O00000oO.remove(i4);
            textRootGlyphContext.O00oOooO = textRootGlyphContext.O00000oO.get(textRootGlyphContext.O00oOoOo);
            textRootGlyphContext.O000OO00 = textRootGlyphContext.O0000Oo.get(textRootGlyphContext.O00oOoOo).intValue();
        }
        if (i5 != textRootGlyphContext.O000O0o0) {
            textRootGlyphContext.O00000oo.remove(i5);
            textRootGlyphContext.O00oOooo = textRootGlyphContext.O00000oo.get(textRootGlyphContext.O000O0o0);
            textRootGlyphContext.O000OO0o = textRootGlyphContext.O0000OoO.get(textRootGlyphContext.O000O0o0).intValue();
        }
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        setupGlyphContext(canvas);
        if (f > 0.01f) {
            clip(canvas, paint);
            drawGroup(canvas, paint, f);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawGroup(Canvas canvas, Paint paint, float f) {
        pushGlyphContext();
        SvgView svgView = getSvgView();
        RectF rectF = new RectF();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt instanceof MaskView)) {
                if (childAt instanceof VirtualView) {
                    VirtualView virtualView = (VirtualView) childAt;
                    boolean z = virtualView instanceof RenderableView;
                    if (z) {
                        ((RenderableView) virtualView).mergeProperties(this);
                    }
                    int saveAndSetupCanvas = virtualView.saveAndSetupCanvas(canvas);
                    virtualView.render(canvas, paint, this.mOpacity * f);
                    RectF clientRect = virtualView.getClientRect();
                    if (clientRect != null) {
                        rectF.union(clientRect);
                    }
                    virtualView.restoreCanvas(canvas, saveAndSetupCanvas);
                    if (z) {
                        ((RenderableView) virtualView).resetProperties();
                    }
                    if (virtualView.isResponsible()) {
                        svgView.enableTouchEvents();
                    }
                } else if (childAt instanceof SvgView) {
                    SvgView svgView2 = (SvgView) childAt;
                    svgView2.drawChildren(canvas);
                    if (svgView2.isResponsible()) {
                        svgView.enableTouchEvents();
                    }
                }
            }
        }
        setClientRect(rectF);
        popGlyphContext();
    }

    /* access modifiers changed from: package-private */
    public void drawPath(Canvas canvas, Paint paint, float f) {
        super.draw(canvas, paint, f);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        this.mPath = new Path();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt instanceof MaskView) && (childAt instanceof VirtualView)) {
                VirtualView virtualView = (VirtualView) childAt;
                this.mPath.addPath(virtualView.getPath(canvas, paint), virtualView.mMatrix);
            }
        }
        return this.mPath;
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint, Region.Op op) {
        Path path;
        Path path2;
        Path path3 = new Path();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 19) {
            Path.Op valueOf = Path.Op.valueOf(op.name());
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (!(childAt instanceof MaskView) && (childAt instanceof VirtualView)) {
                    VirtualView virtualView = (VirtualView) childAt;
                    Matrix matrix = virtualView.mMatrix;
                    if (virtualView instanceof GroupView) {
                        path2 = ((GroupView) virtualView).getPath(canvas, paint, op);
                    } else {
                        path2 = virtualView.getPath(canvas, paint);
                    }
                    path2.transform(matrix);
                    path3.op(path2, valueOf);
                }
                i++;
            }
        } else {
            Region region = new Region(canvas.getClipBounds());
            Region region2 = new Region();
            while (i < getChildCount()) {
                View childAt2 = getChildAt(i);
                if (!(childAt2 instanceof MaskView) && (childAt2 instanceof VirtualView)) {
                    VirtualView virtualView2 = (VirtualView) childAt2;
                    Matrix matrix2 = virtualView2.mMatrix;
                    if (virtualView2 instanceof GroupView) {
                        path = ((GroupView) virtualView2).getPath(canvas, paint, op);
                    } else {
                        path = virtualView2.getPath(canvas, paint);
                    }
                    if (matrix2 != null) {
                        path.transform(matrix2);
                    }
                    Region region3 = new Region();
                    region3.setPath(path, region);
                    region2.op(region3, op);
                }
                i++;
            }
            path3.addPath(region2.getBoundaryPath());
        }
        return path3;
    }

    /* access modifiers changed from: package-private */
    public int hitTest(float[] fArr) {
        int reactTagForTouch;
        VirtualView virtualView;
        int hitTest;
        if (this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            Path clipPath = getClipPath();
            if (clipPath != null) {
                if (this.mClipRegionPath != clipPath) {
                    this.mClipRegionPath = clipPath;
                    this.mClipRegion = getRegion(clipPath);
                }
                if (!this.mClipRegion.contains(round, round2)) {
                    return -1;
                }
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt instanceof VirtualView) {
                    if (!(childAt instanceof MaskView) && (hitTest = (virtualView = (VirtualView) childAt).hitTest(fArr2)) != -1) {
                        return (virtualView.isResponsible() || hitTest != childAt.getId()) ? hitTest : getId();
                    }
                } else if ((childAt instanceof SvgView) && (reactTagForTouch = ((SvgView) childAt).reactTagForTouch(fArr2[0], fArr2[1])) != childAt.getId()) {
                    return reactTagForTouch;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineTemplate(this, this.mName);
        }
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).saveDefinition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resetProperties() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof RenderableView) {
                ((RenderableView) childAt).resetProperties();
            }
        }
    }
}
