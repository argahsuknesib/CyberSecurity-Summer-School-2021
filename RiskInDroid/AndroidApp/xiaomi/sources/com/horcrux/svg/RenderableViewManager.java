package com.horcrux.svg;

import _m_j.baj;
import _m_j.ban;
import _m_j.bap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.TransformHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.lang.reflect.Array;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

class RenderableViewManager extends ViewGroupManager<VirtualView> {
    private static final O000000o sMatrixDecompositionContext = new O000000o();
    private static final double[] sTransformDecompositionArray = new double[16];
    private final String mClassName;
    private final SVGClass svgClass;

    enum SVGClass {
        RNSVGGroup,
        RNSVGPath,
        RNSVGText,
        RNSVGTSpan,
        RNSVGTextPath,
        RNSVGImage,
        RNSVGCircle,
        RNSVGEllipse,
        RNSVGLine,
        RNSVGRect,
        RNSVGClipPath,
        RNSVGDefs,
        RNSVGUse,
        RNSVGSymbol,
        RNSVGLinearGradient,
        RNSVGRadialGradient,
        RNSVGPattern,
        RNSVGMask
    }

    class O00000Oo extends LayoutShadowNode {
        @ReactPropGroup(names = {"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "overflow", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd", "borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
        public void ignoreLayoutProps(int i, Dynamic dynamic) {
        }

        O00000Oo() {
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new O00000Oo();
    }

    public Class<O00000Oo> getShadowNodeClass() {
        return O00000Oo.class;
    }

    static class O000000o extends MatrixMathHelper.MatrixDecompositionContext {

        /* renamed from: O000000o  reason: collision with root package name */
        final double[] f4389O000000o = new double[4];
        final double[] O00000Oo = new double[3];
        final double[] O00000o = new double[3];
        final double[] O00000o0 = new double[3];
        final double[] O00000oO = new double[3];

        O000000o() {
        }
    }

    private static boolean isZero(double d) {
        return !Double.isNaN(d) && Math.abs(d) < 1.0E-5d;
    }

    private static void decomposeMatrix() {
        double[] dArr = sMatrixDecompositionContext.f4389O000000o;
        double[] dArr2 = sMatrixDecompositionContext.O00000Oo;
        double[] dArr3 = sMatrixDecompositionContext.O00000o0;
        double[] dArr4 = sMatrixDecompositionContext.O00000o;
        double[] dArr5 = sMatrixDecompositionContext.O00000oO;
        if (!isZero(sTransformDecompositionArray[15])) {
            double[][] dArr6 = (double[][]) Array.newInstance(double.class, 4, 4);
            double[] dArr7 = new double[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    double[] dArr8 = sTransformDecompositionArray;
                    int i3 = (i * 4) + i2;
                    double d = dArr8[i3] / dArr8[15];
                    dArr6[i][i2] = d;
                    if (i2 == 3) {
                        d = 0.0d;
                    }
                    dArr7[i3] = d;
                }
            }
            dArr7[15] = 1.0d;
            if (!isZero(MatrixMathHelper.determinant(dArr7))) {
                if (!isZero(dArr6[0][3]) || !isZero(dArr6[1][3]) || !isZero(dArr6[2][3])) {
                    MatrixMathHelper.multiplyVectorByMatrix(new double[]{dArr6[0][3], dArr6[1][3], dArr6[2][3], dArr6[3][3]}, MatrixMathHelper.transpose(MatrixMathHelper.inverse(dArr7)), dArr);
                } else {
                    dArr[2] = 0.0d;
                    dArr[1] = 0.0d;
                    dArr[0] = 0.0d;
                    dArr[3] = 1.0d;
                }
                System.arraycopy(dArr6[3], 0, dArr4, 0, 3);
                double[][] dArr9 = (double[][]) Array.newInstance(double.class, 3, 3);
                for (int i4 = 0; i4 < 3; i4++) {
                    dArr9[i4][0] = dArr6[i4][0];
                    dArr9[i4][1] = dArr6[i4][1];
                    dArr9[i4][2] = dArr6[i4][2];
                }
                dArr2[0] = MatrixMathHelper.v3Length(dArr9[0]);
                dArr9[0] = MatrixMathHelper.v3Normalize(dArr9[0], dArr2[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
                dArr2[1] = MatrixMathHelper.v3Length(dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Normalize(dArr9[1], dArr2[1]);
                dArr3[0] = dArr3[0] / dArr2[1];
                dArr3[1] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Combine(dArr9[2], dArr9[0], 1.0d, -dArr3[1]);
                dArr3[2] = MatrixMathHelper.v3Dot(dArr9[1], dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Combine(dArr9[2], dArr9[1], 1.0d, -dArr3[2]);
                dArr2[2] = MatrixMathHelper.v3Length(dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Normalize(dArr9[2], dArr2[2]);
                dArr3[1] = dArr3[1] / dArr2[2];
                dArr3[2] = dArr3[2] / dArr2[2];
                if (MatrixMathHelper.v3Dot(dArr9[0], MatrixMathHelper.v3Cross(dArr9[1], dArr9[2])) < 0.0d) {
                    for (int i5 = 0; i5 < 3; i5++) {
                        dArr2[i5] = dArr2[i5] * -1.0d;
                        double[] dArr10 = dArr9[i5];
                        dArr10[0] = dArr10[0] * -1.0d;
                        double[] dArr11 = dArr9[i5];
                        dArr11[1] = dArr11[1] * -1.0d;
                        double[] dArr12 = dArr9[i5];
                        dArr12[2] = dArr12[2] * -1.0d;
                    }
                }
                dArr5[0] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[2][1], dArr9[2][2])) * 57.29577951308232d);
                dArr5[1] = MatrixMathHelper.roundTo3Places((-Math.atan2(-dArr9[2][0], Math.sqrt((dArr9[2][1] * dArr9[2][1]) + (dArr9[2][2] * dArr9[2][2])))) * 57.29577951308232d);
                dArr5[2] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[1][0], dArr9[0][0])) * 57.29577951308232d);
            }
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        decomposeMatrix();
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.O00000o[0]));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.O00000o[1]));
        view.setRotation((float) sMatrixDecompositionContext.O00000oO[2]);
        view.setRotationX((float) sMatrixDecompositionContext.O00000oO[0]);
        view.setRotationY((float) sMatrixDecompositionContext.O00000oO[1]);
        view.setScaleX((float) sMatrixDecompositionContext.O00000Oo[0]);
        view.setScaleY((float) sMatrixDecompositionContext.O00000Oo[1]);
        double[] dArr = sMatrixDecompositionContext.f4389O000000o;
        if (dArr.length > 2) {
            float f = (float) dArr[2];
            if (f == 0.0f) {
                f = 7.8125E-4f;
            }
            float f2 = -1.0f / f;
            float f3 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
            view.setCameraDistance(f3 * f3 * f2 * 5.0f);
        }
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(PixelUtil.toPixelFromDIP(0.0f));
        view.setTranslationY(PixelUtil.toPixelFromDIP(0.0f));
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(0.0f);
    }

    static class GroupViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        GroupViewManager() {
            super(SVGClass.RNSVGGroup);
        }

        GroupViewManager(SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "font")
        public void setFont(GroupView groupView, ReadableMap readableMap) {
            groupView.setFont(readableMap);
        }

        @ReactProp(name = "fontSize")
        public void setFontSize(GroupView groupView, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i = AnonymousClass2.f4388O000000o[dynamic.getType().ordinal()];
            if (i == 1) {
                javaOnlyMap.putDouble("fontSize", dynamic.asDouble());
            } else if (i == 2) {
                javaOnlyMap.putString("fontSize", dynamic.asString());
            } else {
                return;
            }
            groupView.setFont(javaOnlyMap);
        }
    }

    static class PathViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        PathViewManager() {
            super(SVGClass.RNSVGPath);
        }

        @ReactProp(name = "d")
        public void setD(PathView pathView, String str) {
            pathView.setD(str);
        }
    }

    static class TextViewManager extends GroupViewManager {
        TextViewManager() {
            super(SVGClass.RNSVGText);
        }

        TextViewManager(SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "textLength")
        public void setTextLength(TextView textView, Dynamic dynamic) {
            textView.setTextLength(dynamic);
        }

        @ReactProp(name = "lengthAdjust")
        public void setLengthAdjust(TextView textView, String str) {
            textView.setLengthAdjust(str);
        }

        @ReactProp(name = "alignmentBaseline")
        public void setMethod(TextView textView, String str) {
            textView.setMethod(str);
        }

        @ReactProp(name = "baselineShift")
        public void setBaselineShift(TextView textView, Dynamic dynamic) {
            textView.setBaselineShift(dynamic);
        }

        @ReactProp(name = "verticalAlign")
        public void setVerticalAlign(TextView textView, String str) {
            textView.setVerticalAlign(str);
        }

        @ReactProp(name = "rotate")
        public void setRotate(TextView textView, Dynamic dynamic) {
            textView.setRotate(dynamic);
        }

        @ReactProp(name = "dx")
        public void setDeltaX(TextView textView, Dynamic dynamic) {
            textView.setDeltaX(dynamic);
        }

        @ReactProp(name = "dy")
        public void setDeltaY(TextView textView, Dynamic dynamic) {
            textView.setDeltaY(dynamic);
        }

        @ReactProp(name = "x")
        public void setX(TextView textView, Dynamic dynamic) {
            textView.setPositionX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(TextView textView, Dynamic dynamic) {
            textView.setPositionY(dynamic);
        }

        @ReactProp(name = "font")
        public void setFont(TextView textView, ReadableMap readableMap) {
            textView.setFont(readableMap);
        }
    }

    static class TSpanViewManager extends TextViewManager {
        TSpanViewManager() {
            super(SVGClass.RNSVGTSpan);
        }

        @ReactProp(name = "content")
        public void setContent(TSpanView tSpanView, String str) {
            tSpanView.setContent(str);
        }
    }

    static class TextPathViewManager extends TextViewManager {
        TextPathViewManager() {
            super(SVGClass.RNSVGTextPath);
        }

        @ReactProp(name = "href")
        public void setHref(TextPathView textPathView, String str) {
            textPathView.setHref(str);
        }

        @ReactProp(name = "startOffset")
        public void setStartOffset(TextPathView textPathView, Dynamic dynamic) {
            textPathView.setStartOffset(dynamic);
        }

        @ReactProp(name = "method")
        public void setMethod(TextPathView textPathView, String str) {
            textPathView.setMethod(str);
        }

        @ReactProp(name = "spacing")
        public void setSpacing(TextPathView textPathView, String str) {
            textPathView.setSpacing(str);
        }

        @ReactProp(name = "side")
        public void setSide(TextPathView textPathView, String str) {
            textPathView.setSide(str);
        }

        @ReactProp(name = "midLine")
        public void setSharp(TextPathView textPathView, String str) {
            textPathView.setSharp(str);
        }
    }

    static class ImageViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        ImageViewManager() {
            super(SVGClass.RNSVGImage);
        }

        @ReactProp(name = "x")
        public void setX(ImageView imageView, Dynamic dynamic) {
            imageView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(ImageView imageView, Dynamic dynamic) {
            imageView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(ImageView imageView, Dynamic dynamic) {
            imageView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(ImageView imageView, Dynamic dynamic) {
            imageView.setHeight(dynamic);
        }

        @ReactProp(name = "src")
        public void setSrc(ImageView imageView, ReadableMap readableMap) {
            imageView.setSrc(readableMap);
        }

        @ReactProp(name = "align")
        public void setAlign(ImageView imageView, String str) {
            imageView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(ImageView imageView, int i) {
            imageView.setMeetOrSlice(i);
        }
    }

    static class CircleViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        CircleViewManager() {
            super(SVGClass.RNSVGCircle);
        }

        @ReactProp(name = "cx")
        public void setCx(CircleView circleView, Dynamic dynamic) {
            circleView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(CircleView circleView, Dynamic dynamic) {
            circleView.setCy(dynamic);
        }

        @ReactProp(name = "r")
        public void setR(CircleView circleView, Dynamic dynamic) {
            circleView.setR(dynamic);
        }
    }

    static class EllipseViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        EllipseViewManager() {
            super(SVGClass.RNSVGEllipse);
        }

        @ReactProp(name = "cx")
        public void setCx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRy(dynamic);
        }
    }

    static class LineViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        LineViewManager() {
            super(SVGClass.RNSVGLine);
        }

        @ReactProp(name = "x1")
        public void setX1(LineView lineView, Dynamic dynamic) {
            lineView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LineView lineView, Dynamic dynamic) {
            lineView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LineView lineView, Dynamic dynamic) {
            lineView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LineView lineView, Dynamic dynamic) {
            lineView.setY2(dynamic);
        }
    }

    static class RectViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        RectViewManager() {
            super(SVGClass.RNSVGRect);
        }

        @ReactProp(name = "x")
        public void setX(RectView rectView, Dynamic dynamic) {
            rectView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(RectView rectView, Dynamic dynamic) {
            rectView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(RectView rectView, Dynamic dynamic) {
            rectView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(RectView rectView, Dynamic dynamic) {
            rectView.setHeight(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RectView rectView, Dynamic dynamic) {
            rectView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RectView rectView, Dynamic dynamic) {
            rectView.setRy(dynamic);
        }
    }

    static class ClipPathViewManager extends GroupViewManager {
        ClipPathViewManager() {
            super(SVGClass.RNSVGClipPath);
        }
    }

    static class DefsViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        DefsViewManager() {
            super(SVGClass.RNSVGDefs);
        }
    }

    static class UseViewManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        UseViewManager() {
            super(SVGClass.RNSVGUse);
        }

        @ReactProp(name = "href")
        public void setHref(UseView useView, String str) {
            useView.setHref(str);
        }

        @ReactProp(name = "x")
        public void setX(UseView useView, Dynamic dynamic) {
            useView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(UseView useView, Dynamic dynamic) {
            useView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(UseView useView, Dynamic dynamic) {
            useView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(UseView useView, Dynamic dynamic) {
            useView.setHeight(dynamic);
        }
    }

    static class SymbolManager extends GroupViewManager {
        SymbolManager() {
            super(SVGClass.RNSVGSymbol);
        }

        @ReactProp(name = "minX")
        public void setMinX(SymbolView symbolView, float f) {
            symbolView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(SymbolView symbolView, float f) {
            symbolView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(SymbolView symbolView, float f) {
            symbolView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(SymbolView symbolView, float f) {
            symbolView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(SymbolView symbolView, String str) {
            symbolView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(SymbolView symbolView, int i) {
            symbolView.setMeetOrSlice(i);
        }
    }

    static class PatternManager extends GroupViewManager {
        PatternManager() {
            super(SVGClass.RNSVGPattern);
        }

        @ReactProp(name = "x")
        public void setX(PatternView patternView, Dynamic dynamic) {
            patternView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(PatternView patternView, Dynamic dynamic) {
            patternView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(PatternView patternView, Dynamic dynamic) {
            patternView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(PatternView patternView, Dynamic dynamic) {
            patternView.setHeight(dynamic);
        }

        @ReactProp(name = "patternUnits")
        public void setPatternUnits(PatternView patternView, int i) {
            patternView.setPatternUnits(i);
        }

        @ReactProp(name = "patternContentUnits")
        public void setPatternContentUnits(PatternView patternView, int i) {
            patternView.setPatternContentUnits(i);
        }

        @ReactProp(name = "patternTransform")
        public void setPatternTransform(PatternView patternView, ReadableArray readableArray) {
            patternView.setPatternTransform(readableArray);
        }

        @ReactProp(name = "minX")
        public void setMinX(PatternView patternView, float f) {
            patternView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(PatternView patternView, float f) {
            patternView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(PatternView patternView, float f) {
            patternView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(PatternView patternView, float f) {
            patternView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(PatternView patternView, String str) {
            patternView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(PatternView patternView, int i) {
            patternView.setMeetOrSlice(i);
        }
    }

    static class MaskManager extends GroupViewManager {
        MaskManager() {
            super(SVGClass.RNSVGMask);
        }

        @ReactProp(name = "x")
        public void setX(MaskView maskView, Dynamic dynamic) {
            maskView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(MaskView maskView, Dynamic dynamic) {
            maskView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(MaskView maskView, Dynamic dynamic) {
            maskView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(MaskView maskView, Dynamic dynamic) {
            maskView.setHeight(dynamic);
        }

        @ReactProp(name = "maskUnits")
        public void setMaskUnits(MaskView maskView, int i) {
            maskView.setMaskUnits(i);
        }

        @ReactProp(name = "maskContentUnits")
        public void setMaskContentUnits(MaskView maskView, int i) {
            maskView.setMaskContentUnits(i);
        }

        @ReactProp(name = "maskTransform")
        public void setMaskTransform(MaskView maskView, ReadableArray readableArray) {
            maskView.setMaskTransform(readableArray);
        }
    }

    static class LinearGradientManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        LinearGradientManager() {
            super(SVGClass.RNSVGLinearGradient);
        }

        @ReactProp(name = "x1")
        public void setX1(ban ban, Dynamic dynamic) {
            ban.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(ban ban, Dynamic dynamic) {
            ban.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(ban ban, Dynamic dynamic) {
            ban.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(ban ban, Dynamic dynamic) {
            ban.setY2(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(ban ban, ReadableArray readableArray) {
            ban.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(ban ban, int i) {
            ban.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(ban ban, ReadableArray readableArray) {
            ban.setGradientTransform(readableArray);
        }
    }

    static class RadialGradientManager extends RenderableViewManager {
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        RadialGradientManager() {
            super(SVGClass.RNSVGRadialGradient);
        }

        @ReactProp(name = "fx")
        public void setFx(bap bap, Dynamic dynamic) {
            bap.setFx(dynamic);
        }

        @ReactProp(name = "fy")
        public void setFy(bap bap, Dynamic dynamic) {
            bap.setFy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(bap bap, Dynamic dynamic) {
            bap.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(bap bap, Dynamic dynamic) {
            bap.setRy(dynamic);
        }

        @ReactProp(name = "cx")
        public void setCx(bap bap, Dynamic dynamic) {
            bap.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(bap bap, Dynamic dynamic) {
            bap.setCy(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(bap bap, ReadableArray readableArray) {
            bap.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(bap bap, int i) {
            bap.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(bap bap, ReadableArray readableArray) {
            bap.setGradientTransform(readableArray);
        }
    }

    private RenderableViewManager(SVGClass sVGClass) {
        this.svgClass = sVGClass;
        this.mClassName = sVGClass.toString();
    }

    public String getName() {
        return this.mClassName;
    }

    @ReactProp(name = "mask")
    public void setMask(VirtualView virtualView, String str) {
        virtualView.setMask(str);
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(VirtualView virtualView, String str) {
        virtualView.setClipPath(str);
    }

    @ReactProp(name = "clipRule")
    public void setClipRule(VirtualView virtualView, int i) {
        virtualView.setClipRule(i);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(VirtualView virtualView, float f) {
        virtualView.setOpacity(f);
    }

    @ReactProp(name = "fill")
    public void setFill(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setFill(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(RenderableView renderableView, float f) {
        renderableView.setFillOpacity(f);
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(RenderableView renderableView, int i) {
        renderableView.setFillRule(i);
    }

    @ReactProp(name = "stroke")
    public void setStroke(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setStroke(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(RenderableView renderableView, float f) {
        renderableView.setStrokeOpacity(f);
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(RenderableView renderableView, ReadableArray readableArray) {
        renderableView.setStrokeDasharray(readableArray);
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(RenderableView renderableView, float f) {
        renderableView.setStrokeDashoffset(f);
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setStrokeWidth(dynamic);
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(RenderableView renderableView, float f) {
        renderableView.setStrokeMiterlimit(f);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(RenderableView renderableView, int i) {
        renderableView.setStrokeLinecap(i);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(RenderableView renderableView, int i) {
        renderableView.setStrokeLinejoin(i);
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(RenderableView renderableView, int i) {
        renderableView.setVectorEffect(i);
    }

    @ReactProp(name = "matrix")
    public void setMatrix(VirtualView virtualView, Dynamic dynamic) {
        virtualView.setMatrix(dynamic);
    }

    @ReactProp(name = "transform")
    public void setTransform(VirtualView virtualView, Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Array) {
            ReadableArray asArray = dynamic.asArray();
            if (asArray == null) {
                resetTransformProperty(virtualView);
            } else {
                setTransformProperty(virtualView, asArray);
            }
            Matrix matrix = virtualView.getMatrix();
            virtualView.mTransform = matrix;
            virtualView.mTransformInvertible = matrix.invert(virtualView.mInvTransform);
        }
    }

    @ReactProp(name = "propList")
    public void setPropList(RenderableView renderableView, ReadableArray readableArray) {
        renderableView.setPropList(readableArray);
    }

    @ReactProp(name = "responsible")
    public void setResponsible(VirtualView virtualView, boolean z) {
        virtualView.setResponsible(z);
    }

    @ReactProp(name = "name")
    public void setName(VirtualView virtualView, String str) {
        virtualView.setName(str);
    }

    public void invalidateSvgView(VirtualView virtualView) {
        SvgView svgView = virtualView.getSvgView();
        if (svgView != null) {
            svgView.invalidate();
        }
        if (virtualView instanceof TextView) {
            ((TextView) virtualView).getTextContainer().clearChildCache();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.ViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, android.view.View):void
     arg types: [com.facebook.react.uimanager.ThemedReactContext, com.horcrux.svg.VirtualView]
     candidates:
      com.horcrux.svg.RenderableViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, com.horcrux.svg.VirtualView):void
      com.facebook.react.uimanager.ViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, android.view.View):void */
    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, VirtualView virtualView) {
        super.addEventEmitters(themedReactContext, (View) virtualView);
        virtualView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            /* class com.horcrux.svg.RenderableViewManager.AnonymousClass1 */

            public final void onChildViewAdded(View view, View view2) {
                if (view instanceof VirtualView) {
                    RenderableViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }

            public final void onChildViewRemoved(View view, View view2) {
                if (view instanceof VirtualView) {
                    RenderableViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(VirtualView virtualView) {
        super.onAfterUpdateTransaction((View) virtualView);
        invalidateSvgView(virtualView);
    }

    /* renamed from: com.horcrux.svg.RenderableViewManager$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f4388O000000o = new int[ReadableType.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[SVGClass.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ed */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            try {
                O00000Oo[SVGClass.RNSVGGroup.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            O00000Oo[SVGClass.RNSVGPath.ordinal()] = 2;
            O00000Oo[SVGClass.RNSVGCircle.ordinal()] = 3;
            O00000Oo[SVGClass.RNSVGEllipse.ordinal()] = 4;
            O00000Oo[SVGClass.RNSVGLine.ordinal()] = 5;
            O00000Oo[SVGClass.RNSVGRect.ordinal()] = 6;
            O00000Oo[SVGClass.RNSVGText.ordinal()] = 7;
            O00000Oo[SVGClass.RNSVGTSpan.ordinal()] = 8;
            O00000Oo[SVGClass.RNSVGTextPath.ordinal()] = 9;
            O00000Oo[SVGClass.RNSVGImage.ordinal()] = 10;
            O00000Oo[SVGClass.RNSVGClipPath.ordinal()] = 11;
            O00000Oo[SVGClass.RNSVGDefs.ordinal()] = 12;
            O00000Oo[SVGClass.RNSVGUse.ordinal()] = 13;
            O00000Oo[SVGClass.RNSVGSymbol.ordinal()] = 14;
            O00000Oo[SVGClass.RNSVGLinearGradient.ordinal()] = 15;
            O00000Oo[SVGClass.RNSVGRadialGradient.ordinal()] = 16;
            O00000Oo[SVGClass.RNSVGPattern.ordinal()] = 17;
            try {
                O00000Oo[SVGClass.RNSVGMask.ordinal()] = 18;
            } catch (NoSuchFieldError unused2) {
            }
            f4388O000000o[ReadableType.Number.ordinal()] = 1;
            try {
                f4388O000000o[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public VirtualView createViewInstance(ThemedReactContext themedReactContext) {
        switch (AnonymousClass2.O00000Oo[this.svgClass.ordinal()]) {
            case 1:
                return new GroupView(themedReactContext);
            case 2:
                return new PathView(themedReactContext);
            case 3:
                return new CircleView(themedReactContext);
            case 4:
                return new EllipseView(themedReactContext);
            case 5:
                return new LineView(themedReactContext);
            case 6:
                return new RectView(themedReactContext);
            case 7:
                return new TextView(themedReactContext);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return new TSpanView(themedReactContext);
            case 9:
                return new TextPathView(themedReactContext);
            case 10:
                return new ImageView(themedReactContext);
            case 11:
                return new ClipPathView(themedReactContext);
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return new baj(themedReactContext);
            case 13:
                return new UseView(themedReactContext);
            case 14:
                return new SymbolView(themedReactContext);
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return new ban(themedReactContext);
            case 16:
                return new bap(themedReactContext);
            case 17:
                return new PatternView(themedReactContext);
            case 18:
                return new MaskView(themedReactContext);
            default:
                throw new IllegalStateException("Unexpected type " + this.svgClass.toString());
        }
    }
}
