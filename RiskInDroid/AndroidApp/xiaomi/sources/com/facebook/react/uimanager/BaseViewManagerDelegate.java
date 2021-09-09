package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: U
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
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = 0
            switch(r0) {
                case -1721943862: goto L_0x0126;
                case -1721943861: goto L_0x011b;
                case -1267206133: goto L_0x0110;
                case -1228066334: goto L_0x0105;
                case -908189618: goto L_0x00fa;
                case -908189617: goto L_0x00ef;
                case -877170387: goto L_0x00e4;
                case -731417480: goto L_0x00d9;
                case -101663499: goto L_0x00cf;
                case -101359900: goto L_0x00c4;
                case -80891667: goto L_0x00b8;
                case -40300674: goto L_0x00ac;
                case -4379043: goto L_0x00a0;
                case 36255470: goto L_0x0095;
                case 333432965: goto L_0x0089;
                case 581268560: goto L_0x007d;
                case 588239831: goto L_0x0071;
                case 746986311: goto L_0x0065;
                case 1052666732: goto L_0x0059;
                case 1146842694: goto L_0x004e;
                case 1153872867: goto L_0x0043;
                case 1287124693: goto L_0x0038;
                case 1349188574: goto L_0x002c;
                case 1410320624: goto L_0x0021;
                case 1505602511: goto L_0x0016;
                case 2045685618: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0131
        L_0x000a:
            java.lang.String r0 = "nativeID"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 15
            goto L_0x0132
        L_0x0016:
            java.lang.String r0 = "accessibilityActions"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 0
            goto L_0x0132
        L_0x0021:
            java.lang.String r0 = "accessibilityStates"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 6
            goto L_0x0132
        L_0x002c:
            java.lang.String r0 = "borderRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 8
            goto L_0x0132
        L_0x0038:
            java.lang.String r0 = "backgroundColor"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 7
            goto L_0x0132
        L_0x0043:
            java.lang.String r0 = "accessibilityState"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 5
            goto L_0x0132
        L_0x004e:
            java.lang.String r0 = "accessibilityLabel"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 2
            goto L_0x0132
        L_0x0059:
            java.lang.String r0 = "transform"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 22
            goto L_0x0132
        L_0x0065:
            java.lang.String r0 = "importantForAccessibility"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 14
            goto L_0x0132
        L_0x0071:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 10
            goto L_0x0132
        L_0x007d:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 9
            goto L_0x0132
        L_0x0089:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 12
            goto L_0x0132
        L_0x0095:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 3
            goto L_0x0132
        L_0x00a0:
            java.lang.String r0 = "elevation"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 13
            goto L_0x0132
        L_0x00ac:
            java.lang.String r0 = "rotation"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 18
            goto L_0x0132
        L_0x00b8:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 17
            goto L_0x0132
        L_0x00c4:
            java.lang.String r0 = "accessibilityRole"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 4
            goto L_0x0132
        L_0x00cf:
            java.lang.String r0 = "accessibilityHint"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 1
            goto L_0x0132
        L_0x00d9:
            java.lang.String r0 = "zIndex"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 25
            goto L_0x0132
        L_0x00e4:
            java.lang.String r0 = "testID"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 21
            goto L_0x0132
        L_0x00ef:
            java.lang.String r0 = "scaleY"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 20
            goto L_0x0132
        L_0x00fa:
            java.lang.String r0 = "scaleX"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 19
            goto L_0x0132
        L_0x0105:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 11
            goto L_0x0132
        L_0x0110:
            java.lang.String r0 = "opacity"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 16
            goto L_0x0132
        L_0x011b:
            java.lang.String r0 = "translateY"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 24
            goto L_0x0132
        L_0x0126:
            java.lang.String r0 = "translateX"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            r6 = 23
            goto L_0x0132
        L_0x0131:
            r6 = -1
        L_0x0132:
            r0 = 1065353216(0x3f800000, float:1.0)
            r2 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            switch(r6) {
                case 0: goto L_0x026e;
                case 1: goto L_0x0266;
                case 2: goto L_0x025e;
                case 3: goto L_0x0256;
                case 4: goto L_0x024e;
                case 5: goto L_0x0246;
                case 6: goto L_0x023e;
                case 7: goto L_0x022f;
                case 8: goto L_0x0220;
                case 9: goto L_0x0211;
                case 10: goto L_0x0202;
                case 11: goto L_0x01f3;
                case 12: goto L_0x01e4;
                case 13: goto L_0x01d5;
                case 14: goto L_0x01cd;
                case 15: goto L_0x01c5;
                case 16: goto L_0x01b6;
                case 17: goto L_0x01a7;
                case 18: goto L_0x0198;
                case 19: goto L_0x0189;
                case 20: goto L_0x017a;
                case 21: goto L_0x0172;
                case 22: goto L_0x016a;
                case 23: goto L_0x015b;
                case 24: goto L_0x014c;
                case 25: goto L_0x013c;
                default: goto L_0x013a;
            }
        L_0x013a:
            goto L_0x0275
        L_0x013c:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0141
            goto L_0x0147
        L_0x0141:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x0147:
            r6.setZIndex(r5, r2)
            goto L_0x0275
        L_0x014c:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0151
            goto L_0x0157
        L_0x0151:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x0157:
            r6.setTranslateY(r5, r2)
            return
        L_0x015b:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0160
            goto L_0x0166
        L_0x0160:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x0166:
            r6.setTranslateX(r5, r2)
            return
        L_0x016a:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransform(r5, r7)
            return
        L_0x0172:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setTestId(r5, r7)
            return
        L_0x017a:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x017f
            goto L_0x0185
        L_0x017f:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0185:
            r6.setScaleY(r5, r0)
            return
        L_0x0189:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x018e
            goto L_0x0194
        L_0x018e:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0194:
            r6.setScaleX(r5, r0)
            return
        L_0x0198:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x019d
            goto L_0x01a3
        L_0x019d:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x01a3:
            r6.setRotation(r5, r2)
            return
        L_0x01a7:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01ac
            goto L_0x01b2
        L_0x01ac:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x01b2:
            r6.setRenderToHardwareTexture(r5, r1)
            return
        L_0x01b6:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01bb
            goto L_0x01c1
        L_0x01bb:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x01c1:
            r6.setOpacity(r5, r0)
            return
        L_0x01c5:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setNativeId(r5, r7)
            return
        L_0x01cd:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setImportantForAccessibility(r5, r7)
            return
        L_0x01d5:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01da
            goto L_0x01e0
        L_0x01da:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x01e0:
            r6.setElevation(r5, r2)
            return
        L_0x01e4:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01e9
            goto L_0x01ef
        L_0x01e9:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01ef:
            r6.setBorderTopRightRadius(r5, r3)
            return
        L_0x01f3:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01f8
            goto L_0x01fe
        L_0x01f8:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01fe:
            r6.setBorderTopLeftRadius(r5, r3)
            return
        L_0x0202:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0207
            goto L_0x020d
        L_0x0207:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x020d:
            r6.setBorderBottomRightRadius(r5, r3)
            return
        L_0x0211:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0216
            goto L_0x021c
        L_0x0216:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x021c:
            r6.setBorderBottomLeftRadius(r5, r3)
            return
        L_0x0220:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0225
            goto L_0x022b
        L_0x0225:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x022b:
            r6.setBorderRadius(r5, r3)
            return
        L_0x022f:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0234
            goto L_0x023a
        L_0x0234:
            java.lang.Double r7 = (java.lang.Double) r7
            int r1 = r7.intValue()
        L_0x023a:
            r6.setBackgroundColor(r5, r1)
            return
        L_0x023e:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setViewStates(r5, r7)
            return
        L_0x0246:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setViewState(r5, r7)
            return
        L_0x024e:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityRole(r5, r7)
            return
        L_0x0256:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLiveRegion(r5, r7)
            return
        L_0x025e:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLabel(r5, r7)
            return
        L_0x0266:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityHint(r5, r7)
            return
        L_0x026e:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setAccessibilityActions(r5, r7)
        L_0x0275:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
