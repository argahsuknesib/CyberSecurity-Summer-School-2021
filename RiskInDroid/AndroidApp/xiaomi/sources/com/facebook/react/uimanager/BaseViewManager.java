package com.facebook.react.uimanager;

import _m_j.cb;
import android.view.View;
import android.view.ViewParent;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = ((float) Math.sqrt(5.0d));
    private static MatrixMathHelper.MatrixDecompositionContext sMatrixDecompositionContext = new MatrixMathHelper.MatrixDecompositionContext();
    public static final Map<String, Integer> sStateDescription;
    private static double[] sTransformDecompositionArray = new double[16];

    static {
        HashMap hashMap = new HashMap();
        sStateDescription = hashMap;
        hashMap.put("busy", Integer.valueOf((int) R.string.state_busy_description));
        sStateDescription.put("expanded", Integer.valueOf((int) R.string.state_expanded_description));
        sStateDescription.put("collapsed", Integer.valueOf((int) R.string.state_collapsed_description));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(T r1, int r2) {
        /*
            r0 = this;
            r1.setBackgroundColor(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setBackgroundColor(android.view.View, int):void");
    }

    @ReactProp(name = "transform")
    public void setTransform(T t, ReadableArray readableArray) {
        if (readableArray == null) {
            resetTransformProperty(t);
        } else {
            setTransformProperty(t, readableArray);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(T r4, float r5) {
        /*
            r3 = this;
            android.view.animation.Animation r0 = r4.getAnimation()
            boolean r0 = r0 instanceof com.facebook.react.uimanager.layoutanimation.OpacityAnimation
            if (r0 == 0) goto L_0x0038
            android.view.animation.Animation r0 = r4.getAnimation()
            com.facebook.react.uimanager.layoutanimation.OpacityAnimation r0 = (com.facebook.react.uimanager.layoutanimation.OpacityAnimation) r0
            float r1 = r0.getEndOpacity()
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0038
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "--BaseViewManager-- clearAnimation getEndOpacity = "
            r1.<init>(r2)
            float r0 = r0.getEndOpacity()
            r1.append(r0)
            java.lang.String r0 = " set opacity = "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "ReactNative"
            android.util.Log.e(r1, r0)
            r4.clearAnimation()
        L_0x0038:
            r4.setAlpha(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setOpacity(android.view.View, float):void");
    }

    @ReactProp(name = "elevation")
    public void setElevation(T t, float f) {
        cb.O0000Oo(t, PixelUtil.toPixelFromDIP(f));
    }

    @ReactProp(name = "zIndex")
    public void setZIndex(T t, float f) {
        ViewGroupManager.setViewZIndex(t, Math.round(f));
        ViewParent parent = t.getParent();
        if (parent instanceof ReactZIndexedViewGroup) {
            ((ReactZIndexedViewGroup) parent).updateDrawingOrder();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T r2, boolean r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0004
            r3 = 2
            goto L_0x0005
        L_0x0004:
            r3 = 0
        L_0x0005:
            r0 = 0
            r2.setLayerType(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setRenderToHardwareTexture(android.view.View, boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "testID")
    public void setTestId(T r2, java.lang.String r3) {
        /*
            r1 = this;
            r0 = 2132152332(0x7f16100c, float:1.9946752E38)
            r2.setTag(r0, r3)
            r2.setTag(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setTestId(android.view.View, java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "nativeID")
    public void setNativeId(T r2, java.lang.String r3) {
        /*
            r1 = this;
            r0 = 2132154399(0x7f16181f, float:1.9950944E38)
            r2.setTag(r0, r3)
            com.facebook.react.uimanager.util.ReactFindViewUtil.notifyViewRendered(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setNativeId(android.view.View, java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(T r2, java.lang.String r3) {
        /*
            r1 = this;
            r0 = 2132148318(0x7f16005e, float:1.993861E38)
            r2.setTag(r0, r3)
            r1.updateViewContentDescription(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setAccessibilityLabel(android.view.View, java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "accessibilityHint")
    public void setAccessibilityHint(T r2, java.lang.String r3) {
        /*
            r1 = this;
            r0 = 2132148317(0x7f16005d, float:1.9938609E38)
            r2.setTag(r0, r3)
            r1.updateViewContentDescription(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setAccessibilityHint(android.view.View, java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "accessibilityRole")
    public void setAccessibilityRole(T r2, java.lang.String r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 2132148319(0x7f16005f, float:1.9938613E38)
            com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r3 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.fromValue(r3)
            r2.setTag(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setAccessibilityRole(android.view.View, java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "accessibilityStates")
    public void setViewStates(T r7, com.facebook.react.bridge.ReadableArray r8) {
        /*
            r6 = this;
            r0 = 2132148321(0x7f160061, float:1.9938617E38)
            java.lang.Object r1 = r7.getTag(r0)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x000f
            if (r8 != 0) goto L_0x000f
            r1 = 1
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            r7.setTag(r0, r8)
            r7.setSelected(r2)
            r7.setEnabled(r3)
            if (r8 == 0) goto L_0x0049
            r0 = 0
        L_0x001c:
            int r4 = r8.size()
            if (r0 >= r4) goto L_0x0049
            java.lang.String r4 = r8.getString(r0)
            java.util.Map<java.lang.String, java.lang.Integer> r5 = com.facebook.react.uimanager.BaseViewManager.sStateDescription
            boolean r5 = r5.containsKey(r4)
            if (r5 == 0) goto L_0x002f
            r1 = 1
        L_0x002f:
            java.lang.String r5 = "selected"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x003b
            r7.setSelected(r3)
            goto L_0x0046
        L_0x003b:
            java.lang.String r5 = "disabled"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0046
            r7.setEnabled(r2)
        L_0x0046:
            int r0 = r0 + 1
            goto L_0x001c
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r6.updateViewContentDescription(r7)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setViewStates(android.view.View, com.facebook.react.bridge.ReadableArray):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "accessibilityState")
    public void setViewState(T r4, com.facebook.react.bridge.ReadableMap r5) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 2132148320(0x7f160060, float:1.9938615E38)
            r4.setTag(r0, r5)
            r0 = 0
            r4.setSelected(r0)
            r0 = 1
            r4.setEnabled(r0)
            com.facebook.react.bridge.ReadableMapKeySetIterator r0 = r5.keySetIterator()
        L_0x0015:
            boolean r1 = r0.hasNextKey()
            if (r1 == 0) goto L_0x0042
            java.lang.String r1 = r0.nextKey()
            java.lang.String r2 = "busy"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x003f
            java.lang.String r2 = "expanded"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x003f
            java.lang.String r2 = "checked"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0015
            com.facebook.react.bridge.ReadableType r1 = r5.getType(r2)
            com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.String
            if (r1 != r2) goto L_0x0015
        L_0x003f:
            r3.updateViewContentDescription(r4)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setViewState(android.view.View, com.facebook.react.bridge.ReadableMap):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    private void updateViewContentDescription(T r9) {
        /*
            r8 = this;
            r0 = 2132148318(0x7f16005e, float:1.993861E38)
            java.lang.Object r0 = r9.getTag(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 2132148321(0x7f160061, float:1.9938617E38)
            java.lang.Object r1 = r9.getTag(r1)
            com.facebook.react.bridge.ReadableArray r1 = (com.facebook.react.bridge.ReadableArray) r1
            r2 = 2132148320(0x7f160060, float:1.9938615E38)
            java.lang.Object r2 = r9.getTag(r2)
            com.facebook.react.bridge.ReadableMap r2 = (com.facebook.react.bridge.ReadableMap) r2
            r3 = 2132148317(0x7f16005d, float:1.9938609E38)
            java.lang.Object r3 = r9.getTag(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r0 == 0) goto L_0x002e
            r4.add(r0)
        L_0x002e:
            if (r1 == 0) goto L_0x005d
            r0 = 0
        L_0x0031:
            int r5 = r1.size()
            if (r0 >= r5) goto L_0x005d
            java.lang.String r5 = r1.getString(r0)
            java.util.Map<java.lang.String, java.lang.Integer> r6 = com.facebook.react.uimanager.BaseViewManager.sStateDescription
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x005a
            android.content.Context r6 = r9.getContext()
            java.util.Map<java.lang.String, java.lang.Integer> r7 = com.facebook.react.uimanager.BaseViewManager.sStateDescription
            java.lang.Object r5 = r7.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r5 = r6.getString(r5)
            r4.add(r5)
        L_0x005a:
            int r0 = r0 + 1
            goto L_0x0031
        L_0x005d:
            if (r2 == 0) goto L_0x00eb
            com.facebook.react.bridge.ReadableMapKeySetIterator r0 = r2.keySetIterator()
        L_0x0063:
            boolean r1 = r0.hasNextKey()
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = r0.nextKey()
            com.facebook.react.bridge.Dynamic r5 = r2.getDynamic(r1)
            java.lang.String r6 = "checked"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x009c
            com.facebook.react.bridge.ReadableType r6 = r5.getType()
            com.facebook.react.bridge.ReadableType r7 = com.facebook.react.bridge.ReadableType.String
            if (r6 != r7) goto L_0x009c
            java.lang.String r6 = r5.asString()
            java.lang.String r7 = "mixed"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x009c
            android.content.Context r1 = r9.getContext()
            r5 = 2132678272(0x7f1e1680, float:2.1013485E38)
            java.lang.String r1 = r1.getString(r5)
            r4.add(r1)
            goto L_0x0063
        L_0x009c:
            java.lang.String r6 = "busy"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x00c1
            com.facebook.react.bridge.ReadableType r6 = r5.getType()
            com.facebook.react.bridge.ReadableType r7 = com.facebook.react.bridge.ReadableType.Boolean
            if (r6 != r7) goto L_0x00c1
            boolean r6 = r5.asBoolean()
            if (r6 == 0) goto L_0x00c1
            android.content.Context r1 = r9.getContext()
            r5 = 2132678269(0x7f1e167d, float:2.1013479E38)
            java.lang.String r1 = r1.getString(r5)
            r4.add(r1)
            goto L_0x0063
        L_0x00c1:
            java.lang.String r6 = "expanded"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0063
            com.facebook.react.bridge.ReadableType r1 = r5.getType()
            com.facebook.react.bridge.ReadableType r6 = com.facebook.react.bridge.ReadableType.Boolean
            if (r1 != r6) goto L_0x0063
            android.content.Context r1 = r9.getContext()
            boolean r5 = r5.asBoolean()
            if (r5 == 0) goto L_0x00df
            r5 = 2132678271(0x7f1e167f, float:2.1013483E38)
            goto L_0x00e2
        L_0x00df:
            r5 = 2132678270(0x7f1e167e, float:2.101348E38)
        L_0x00e2:
            java.lang.String r1 = r1.getString(r5)
            r4.add(r1)
            goto L_0x0063
        L_0x00eb:
            if (r3 == 0) goto L_0x00f0
            r4.add(r3)
        L_0x00f0:
            int r0 = r4.size()
            if (r0 <= 0) goto L_0x00ff
            java.lang.String r0 = ", "
            java.lang.String r0 = android.text.TextUtils.join(r0, r4)
            r9.setContentDescription(r0)
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.updateViewContentDescription(android.view.View):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "accessibilityActions")
    public void setAccessibilityActions(T r2, com.facebook.react.bridge.ReadableArray r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 2132148284(0x7f16003c, float:1.9938542E38)
            r2.setTag(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setAccessibilityActions(android.view.View, com.facebook.react.bridge.ReadableArray):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [T, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    @ReactProp(name = "importantForAccessibility")
    public void setImportantForAccessibility(T t, String str) {
        if (str == null || str.equals("auto")) {
            cb.O00000oO((View) t, 0);
        } else if (str.equals("yes")) {
            cb.O00000oO((View) t, 1);
        } else if (str.equals("no")) {
            cb.O00000oO((View) t, 2);
        } else if (str.equals("no-hide-descendants")) {
            cb.O00000oO((View) t, 4);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "rotation")
    @java.lang.Deprecated
    public void setRotation(T r1, float r2) {
        /*
            r0 = this;
            r1.setRotation(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setRotation(android.view.View, float):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(defaultFloat = 1.0f, name = "scaleX")
    @java.lang.Deprecated
    public void setScaleX(T r1, float r2) {
        /*
            r0 = this;
            r1.setScaleX(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setScaleX(android.view.View, float):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(defaultFloat = 1.0f, name = "scaleY")
    @java.lang.Deprecated
    public void setScaleY(T r1, float r2) {
        /*
            r0 = this;
            r1.setScaleY(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setScaleY(android.view.View, float):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(defaultFloat = 0.0f, name = "translateX")
    @java.lang.Deprecated
    public void setTranslateX(T r1, float r2) {
        /*
            r0 = this;
            float r2 = com.facebook.react.uimanager.PixelUtil.toPixelFromDIP(r2)
            r1.setTranslationX(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setTranslateX(android.view.View, float):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.facebook.react.uimanager.annotations.ReactProp(defaultFloat = 0.0f, name = "translateY")
    @java.lang.Deprecated
    public void setTranslateY(T r1, float r2) {
        /*
            r0 = this;
            float r2 = com.facebook.react.uimanager.PixelUtil.toPixelFromDIP(r2)
            r1.setTranslationY(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setTranslateY(android.view.View, float):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000OOo(android.view.View, int):void
     arg types: [T, int]
     candidates:
      _m_j.cb.O0000OOo(android.view.View, float):void
      _m_j.cb.O0000OOo(android.view.View, int):void */
    @ReactProp(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(T t, String str) {
        if (str == null || str.equals("none")) {
            cb.O0000OOo((View) t, 0);
        } else if (str.equals("polite")) {
            cb.O0000OOo((View) t, 1);
        } else if (str.equals("assertive")) {
            cb.O0000OOo((View) t, 2);
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        MatrixMathHelper.decomposeMatrix(sTransformDecompositionArray, sMatrixDecompositionContext);
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[0]));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[1]));
        view.setRotation((float) sMatrixDecompositionContext.rotationDegrees[2]);
        view.setRotationX((float) sMatrixDecompositionContext.rotationDegrees[0]);
        view.setRotationY((float) sMatrixDecompositionContext.rotationDegrees[1]);
        view.setScaleX((float) sMatrixDecompositionContext.scale[0]);
        view.setScaleY((float) sMatrixDecompositionContext.scale[1]);
        double[] dArr = sMatrixDecompositionContext.perspective;
        if (dArr.length > 2) {
            float f = (float) dArr[2];
            if (f == 0.0f) {
                f = 7.8125E-4f;
            }
            float f2 = -1.0f / f;
            float f3 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
            view.setCameraDistance(f3 * f3 * f2 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
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

    private void updateViewAccessibility(T t) {
        ReactAccessibilityDelegate.setDelegate(t);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(View view) {
        super.onAfterUpdateTransaction(view);
        updateViewAccessibility(view);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("topAccessibilityAction", MapBuilder.of("registrationName", "onAccessibilityAction")).build();
    }

    /* access modifiers changed from: protected */
    public void setBorderRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderRadius");
    }

    /* access modifiers changed from: protected */
    public void setBorderBottomLeftRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderBottomLeftRadius");
    }

    /* access modifiers changed from: protected */
    public void setBorderBottomRightRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderBottomRightRadius");
    }

    /* access modifiers changed from: protected */
    public void setBorderTopLeftRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderTopLeftRadius");
    }

    /* access modifiers changed from: protected */
    public void setBorderTopRightRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderTopRightRadius");
    }

    private void logUnsupportedPropertyWarning(String str) {
        FLog.w("ReactNative", "%s doesn't support property '%s'", getName(), str);
    }
}
