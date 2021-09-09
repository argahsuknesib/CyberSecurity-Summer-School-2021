package com.swmansion.gesturehandler.react;

import _m_j.deb;
import _m_j.dec;
import _m_j.deh;
import _m_j.dei;
import _m_j.dej;
import _m_j.del;
import _m_j.dem;
import _m_j.deo;
import _m_j.dep;
import _m_j.deq;
import _m_j.der;
import _m_j.des;
import _m_j.det;
import android.content.Context;
import android.view.MotionEvent;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.gesturehandler.LongPressGestureHandler;
import com.swmansion.gesturehandler.PanGestureHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ReactModule(name = "RNGestureHandlerModule")
public class RNGestureHandlerModule extends ReactContextBaseJavaModule {
    public List<Integer> mEnqueuedRootViewInit = new ArrayList();
    private dei mEventListener = new dei() {
        /* class com.swmansion.gesturehandler.react.RNGestureHandlerModule.AnonymousClass1 */

        public final void O000000o(dec dec, MotionEvent motionEvent) {
            RNGestureHandlerModule.this.onTouchEvent(dec, motionEvent);
        }

        public final void O000000o(dec dec, int i, int i2) {
            RNGestureHandlerModule.this.onStateChange(dec, i, i2);
        }
    };
    private O00000Oo[] mHandlerFactories = {new O00000o((byte) 0), new O0000Oo((byte) 0), new O00000o0((byte) 0), new O0000O0o((byte) 0), new O0000OOo((byte) 0), new O0000Oo0((byte) 0), new O000000o((byte) 0)};
    private deq mInteractionManager = new deq();
    private final der mRegistry = new der();
    private List<des> mRoots = new ArrayList();

    public String getName() {
        return "RNGestureHandlerModule";
    }

    @ReactMethod
    public void handleClearJSResponder() {
    }

    static abstract class O00000Oo<T extends dec> implements dep<T> {
        public abstract T O000000o(Context context);

        public abstract Class<T> O000000o();

        public abstract String O00000Oo();

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
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
        public void O000000o(T r3, com.facebook.react.bridge.ReadableMap r4) {
            /*
                r2 = this;
                java.lang.String r0 = "shouldCancelWhenOutside"
                boolean r1 = r4.hasKey(r0)
                if (r1 == 0) goto L_0x000e
                boolean r0 = r4.getBoolean(r0)
                r3.O0000Ooo = r0
            L_0x000e:
                java.lang.String r0 = "enabled"
                boolean r1 = r4.hasKey(r0)
                if (r1 == 0) goto L_0x001d
                boolean r0 = r4.getBoolean(r0)
                r3.O000000o(r0)
            L_0x001d:
                java.lang.String r0 = "hitSlop"
                boolean r0 = r4.hasKey(r0)
                if (r0 == 0) goto L_0x0028
                com.swmansion.gesturehandler.react.RNGestureHandlerModule.handleHitSlopProperty(r3, r4)
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void");
        }

        public void O000000o(T t, WritableMap writableMap) {
            writableMap.putDouble("numberOfPointers", (double) t.O0000o00);
        }
    }

    static class O00000o extends O00000Oo<deh> {
        public final String O00000Oo() {
            return "NativeViewGestureHandler";
        }

        private O00000o() {
            super((byte) 0);
        }

        /* synthetic */ O00000o(byte b) {
            this();
        }

        public final /* synthetic */ void O000000o(dec dec, ReadableMap readableMap) {
            deh deh = (deh) dec;
            super.O000000o(deh, readableMap);
            if (readableMap.hasKey("shouldActivateOnStart")) {
                deh.f14546O000000o = readableMap.getBoolean("shouldActivateOnStart");
            }
            if (readableMap.hasKey("disallowInterruption")) {
                deh.O00000Oo = readableMap.getBoolean("disallowInterruption");
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void
         arg types: [_m_j.deh, com.facebook.react.bridge.WritableMap]
         candidates:
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000o.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void */
        public final /* synthetic */ void O000000o(dec dec, WritableMap writableMap) {
            deh deh = (deh) dec;
            super.O000000o((dec) deh, writableMap);
            writableMap.putBoolean("pointerInside", deh.O0000OOo);
        }

        public final Class<deh> O000000o() {
            return deh.class;
        }

        public final /* synthetic */ dec O000000o(Context context) {
            return new deh();
        }
    }

    static class O0000Oo extends O00000Oo<dem> {
        public final String O00000Oo() {
            return "TapGestureHandler";
        }

        private O0000Oo() {
            super((byte) 0);
        }

        /* synthetic */ O0000Oo(byte b) {
            this();
        }

        public final /* synthetic */ void O000000o(dec dec, ReadableMap readableMap) {
            dem dem = (dem) dec;
            super.O000000o(dem, readableMap);
            if (readableMap.hasKey("numberOfTaps")) {
                dem.O0000oo = readableMap.getInt("numberOfTaps");
            }
            if (readableMap.hasKey("maxDurationMs")) {
                dem.O0000oOo = (long) readableMap.getInt("maxDurationMs");
            }
            if (readableMap.hasKey("maxDelayMs")) {
                dem.O0000oo0 = (long) readableMap.getInt("maxDelayMs");
            }
            if (readableMap.hasKey("maxDeltaX")) {
                dem.f14552O000000o = PixelUtil.toPixelFromDIP(readableMap.getDouble("maxDeltaX"));
            }
            if (readableMap.hasKey("maxDeltaY")) {
                dem.O00000Oo = PixelUtil.toPixelFromDIP(readableMap.getDouble("maxDeltaY"));
            }
            if (readableMap.hasKey("maxDist")) {
                float pixelFromDIP = PixelUtil.toPixelFromDIP(readableMap.getDouble("maxDist"));
                dem.O0000oOO = pixelFromDIP * pixelFromDIP;
            }
            if (readableMap.hasKey("minPointers")) {
                dem.O0000ooO = readableMap.getInt("minPointers");
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void
         arg types: [_m_j.dem, com.facebook.react.bridge.WritableMap]
         candidates:
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O0000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void */
        public final /* synthetic */ void O000000o(dec dec, WritableMap writableMap) {
            dem dem = (dem) dec;
            super.O000000o((dec) dem, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(dem.O0000Oo()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(dem.O0000OoO()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(dem.O0000Oo));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(dem.O0000OoO));
        }

        public final Class<dem> O000000o() {
            return dem.class;
        }

        public final /* synthetic */ dec O000000o(Context context) {
            return new dem();
        }
    }

    static class O00000o0 extends O00000Oo<LongPressGestureHandler> {
        public final String O00000Oo() {
            return "LongPressGestureHandler";
        }

        private O00000o0() {
            super((byte) 0);
        }

        /* synthetic */ O00000o0(byte b) {
            this();
        }

        public final /* synthetic */ void O000000o(dec dec, ReadableMap readableMap) {
            LongPressGestureHandler longPressGestureHandler = (LongPressGestureHandler) dec;
            super.O000000o(longPressGestureHandler, readableMap);
            if (readableMap.hasKey("minDurationMs")) {
                longPressGestureHandler.f5762O000000o = (long) readableMap.getInt("minDurationMs");
            }
            if (readableMap.hasKey("maxDist")) {
                float pixelFromDIP = PixelUtil.toPixelFromDIP(readableMap.getDouble("maxDist"));
                longPressGestureHandler.O00000Oo = pixelFromDIP * pixelFromDIP;
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void
         arg types: [com.swmansion.gesturehandler.LongPressGestureHandler, com.facebook.react.bridge.WritableMap]
         candidates:
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000o0.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void */
        public final /* synthetic */ void O000000o(dec dec, WritableMap writableMap) {
            LongPressGestureHandler longPressGestureHandler = (LongPressGestureHandler) dec;
            super.O000000o((dec) longPressGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.O0000Oo()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.O0000OoO()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.O0000Oo));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.O0000OoO));
        }

        public final Class<LongPressGestureHandler> O000000o() {
            return LongPressGestureHandler.class;
        }

        public final /* synthetic */ dec O000000o(Context context) {
            return new LongPressGestureHandler(context);
        }
    }

    static class O0000O0o extends O00000Oo<PanGestureHandler> {
        public final String O00000Oo() {
            return "PanGestureHandler";
        }

        private O0000O0o() {
            super((byte) 0);
        }

        /* synthetic */ O0000O0o(byte b) {
            this();
        }

        public final /* synthetic */ void O000000o(dec dec, ReadableMap readableMap) {
            boolean z;
            PanGestureHandler panGestureHandler = (PanGestureHandler) dec;
            super.O000000o(panGestureHandler, readableMap);
            if (readableMap.hasKey("activeOffsetXStart")) {
                panGestureHandler.f5764O000000o = PixelUtil.toPixelFromDIP(readableMap.getDouble("activeOffsetXStart"));
                z = true;
            } else {
                z = false;
            }
            if (readableMap.hasKey("activeOffsetXEnd")) {
                panGestureHandler.O00000Oo = PixelUtil.toPixelFromDIP(readableMap.getDouble("activeOffsetXEnd"));
                z = true;
            }
            if (readableMap.hasKey("failOffsetXStart")) {
                panGestureHandler.O0000oOO = PixelUtil.toPixelFromDIP(readableMap.getDouble("failOffsetXStart"));
                z = true;
            }
            if (readableMap.hasKey("failOffsetXEnd")) {
                panGestureHandler.O0000oOo = PixelUtil.toPixelFromDIP(readableMap.getDouble("failOffsetXEnd"));
                z = true;
            }
            if (readableMap.hasKey("activeOffsetYStart")) {
                panGestureHandler.O0000oo0 = PixelUtil.toPixelFromDIP(readableMap.getDouble("activeOffsetYStart"));
                z = true;
            }
            if (readableMap.hasKey("activeOffsetYEnd")) {
                panGestureHandler.O0000oo = PixelUtil.toPixelFromDIP(readableMap.getDouble("activeOffsetYEnd"));
                z = true;
            }
            if (readableMap.hasKey("failOffsetYStart")) {
                panGestureHandler.O0000ooO = PixelUtil.toPixelFromDIP(readableMap.getDouble("failOffsetYStart"));
                z = true;
            }
            if (readableMap.hasKey("failOffsetYEnd")) {
                panGestureHandler.O0000ooo = PixelUtil.toPixelFromDIP(readableMap.getDouble("failOffsetYEnd"));
                z = true;
            }
            if (readableMap.hasKey("minVelocity")) {
                float pixelFromDIP = PixelUtil.toPixelFromDIP(readableMap.getDouble("minVelocity"));
                panGestureHandler.O000O00o = pixelFromDIP * pixelFromDIP;
                z = true;
            }
            if (readableMap.hasKey("minVelocityX")) {
                panGestureHandler.O00oOooO = PixelUtil.toPixelFromDIP(readableMap.getDouble("minVelocityX"));
                z = true;
            }
            if (readableMap.hasKey("minVelocityY")) {
                panGestureHandler.O00oOooo = PixelUtil.toPixelFromDIP(readableMap.getDouble("minVelocityY"));
                z = true;
            }
            if (readableMap.hasKey("minDist")) {
                panGestureHandler.O000000o(PixelUtil.toPixelFromDIP(readableMap.getDouble("minDist")));
            } else if (z) {
                panGestureHandler.O000000o(Float.MAX_VALUE);
            }
            if (readableMap.hasKey("minPointers")) {
                panGestureHandler.O000O0OO = readableMap.getInt("minPointers");
            }
            if (readableMap.hasKey("maxPointers")) {
                panGestureHandler.O000O0Oo = readableMap.getInt("maxPointers");
            }
            if (readableMap.hasKey("avgTouches")) {
                panGestureHandler.O000OOOo = readableMap.getBoolean("avgTouches");
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void
         arg types: [com.swmansion.gesturehandler.PanGestureHandler, com.facebook.react.bridge.WritableMap]
         candidates:
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O0000O0o.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void */
        public final /* synthetic */ void O000000o(dec dec, WritableMap writableMap) {
            PanGestureHandler panGestureHandler = (PanGestureHandler) dec;
            super.O000000o((dec) panGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(panGestureHandler.O0000Oo()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(panGestureHandler.O0000OoO()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(panGestureHandler.O0000Oo));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(panGestureHandler.O0000OoO));
            writableMap.putDouble("translationX", (double) PixelUtil.toDIPFromPixel((panGestureHandler.O000O0oo - panGestureHandler.O00oOoOo) + panGestureHandler.O000O0o));
            writableMap.putDouble("translationY", (double) PixelUtil.toDIPFromPixel((panGestureHandler.O000OO00 - panGestureHandler.O000O0o0) + panGestureHandler.O000O0oO));
            writableMap.putDouble("velocityX", (double) PixelUtil.toDIPFromPixel(panGestureHandler.O000OO0o));
            writableMap.putDouble("velocityY", (double) PixelUtil.toDIPFromPixel(panGestureHandler.O000OO));
        }

        public final Class<PanGestureHandler> O000000o() {
            return PanGestureHandler.class;
        }

        public final /* synthetic */ dec O000000o(Context context) {
            return new PanGestureHandler(context);
        }
    }

    static class O0000OOo extends O00000Oo<dej> {
        public final String O00000Oo() {
            return "PinchGestureHandler";
        }

        private O0000OOo() {
            super((byte) 0);
        }

        /* synthetic */ O0000OOo(byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void
         arg types: [_m_j.dej, com.facebook.react.bridge.WritableMap]
         candidates:
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void */
        public final /* synthetic */ void O000000o(dec dec, WritableMap writableMap) {
            float f;
            dej dej = (dej) dec;
            super.O000000o((dec) dej, writableMap);
            writableMap.putDouble("scale", dej.O00000Oo);
            float f2 = Float.NaN;
            if (dej.f14547O000000o == null) {
                f = Float.NaN;
            } else {
                f = dej.f14547O000000o.getFocusX();
            }
            writableMap.putDouble("focalX", (double) PixelUtil.toDIPFromPixel(f));
            if (dej.f14547O000000o != null) {
                f2 = dej.f14547O000000o.getFocusY();
            }
            writableMap.putDouble("focalY", (double) PixelUtil.toDIPFromPixel(f2));
            writableMap.putDouble("velocity", dej.O0000oOO);
        }

        public final Class<dej> O000000o() {
            return dej.class;
        }

        public final /* synthetic */ dec O000000o(Context context) {
            return new dej();
        }
    }

    static class O000000o extends O00000Oo<deb> {
        public final String O00000Oo() {
            return "FlingGestureHandler";
        }

        private O000000o() {
            super((byte) 0);
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final /* synthetic */ void O000000o(dec dec, ReadableMap readableMap) {
            deb deb = (deb) dec;
            super.O000000o(deb, readableMap);
            if (readableMap.hasKey("numberOfPointers")) {
                deb.O00000Oo = readableMap.getInt("numberOfPointers");
            }
            if (readableMap.hasKey("direction")) {
                deb.f14542O000000o = readableMap.getInt("direction");
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void
         arg types: [_m_j.deb, com.facebook.react.bridge.WritableMap]
         candidates:
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O000000o.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void */
        public final /* synthetic */ void O000000o(dec dec, WritableMap writableMap) {
            deb deb = (deb) dec;
            super.O000000o((dec) deb, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(deb.O0000Oo()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(deb.O0000OoO()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(deb.O0000Oo));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(deb.O0000OoO));
        }

        public final Class<deb> O000000o() {
            return deb.class;
        }

        public final /* synthetic */ dec O000000o(Context context) {
            return new deb();
        }
    }

    static class O0000Oo0 extends O00000Oo<del> {
        public final String O00000Oo() {
            return "RotationGestureHandler";
        }

        private O0000Oo0() {
            super((byte) 0);
        }

        /* synthetic */ O0000Oo0(byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void
         arg types: [_m_j.del, com.facebook.react.bridge.WritableMap]
         candidates:
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.ReadableMap):void
          com.swmansion.gesturehandler.react.RNGestureHandlerModule.O00000Oo.O000000o(_m_j.dec, com.facebook.react.bridge.WritableMap):void */
        public final /* synthetic */ void O000000o(dec dec, WritableMap writableMap) {
            float f;
            del del = (del) dec;
            super.O000000o((dec) del, writableMap);
            writableMap.putDouble("rotation", del.O00000Oo);
            float f2 = Float.NaN;
            if (del.f14550O000000o == null) {
                f = Float.NaN;
            } else {
                f = del.f14550O000000o.O00000oO;
            }
            writableMap.putDouble("anchorX", (double) PixelUtil.toDIPFromPixel(f));
            if (del.f14550O000000o != null) {
                f2 = del.f14550O000000o.O00000oo;
            }
            writableMap.putDouble("anchorY", (double) PixelUtil.toDIPFromPixel(f2));
            writableMap.putDouble("velocity", del.O0000oOO);
        }

        public final Class<del> O000000o() {
            return del.class;
        }

        public final /* synthetic */ dec O000000o(Context context) {
            return new del();
        }
    }

    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void createGestureHandler(String str, int i, ReadableMap readableMap) {
        int i2 = 0;
        while (true) {
            O00000Oo[] o00000OoArr = this.mHandlerFactories;
            if (i2 < o00000OoArr.length) {
                O00000Oo o00000Oo = o00000OoArr[i2];
                if (o00000Oo.O00000Oo().equals(str)) {
                    dec O000000o2 = o00000Oo.O000000o(getReactApplicationContext());
                    O000000o2.O00000oO = i;
                    O000000o2.O0000o0O = this.mEventListener;
                    this.mRegistry.O000000o(O000000o2);
                    this.mInteractionManager.O000000o(O000000o2, readableMap);
                    o00000Oo.O000000o(O000000o2, readableMap);
                    return;
                }
                i2++;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid handler name ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactMethod
    public void attachGestureHandler(int i, int i2) {
        tryInitializeHandlerForReactRootView(i2);
        if (!this.mRegistry.O000000o(i, i2)) {
            throw new JSApplicationIllegalArgumentException("Handler with tag " + i + " does not exists");
        }
    }

    @ReactMethod
    public void updateGestureHandler(int i, ReadableMap readableMap) {
        O00000Oo findFactoryForHandler;
        dec O000000o2 = this.mRegistry.O000000o(i);
        if (O000000o2 != null && (findFactoryForHandler = findFactoryForHandler(O000000o2)) != null) {
            this.mInteractionManager.O000000o(i);
            this.mInteractionManager.O000000o(O000000o2, readableMap);
            findFactoryForHandler.O000000o(O000000o2, readableMap);
        }
    }

    @ReactMethod
    public void dropGestureHandler(int i) {
        this.mInteractionManager.O000000o(i);
        this.mRegistry.O00000Oo(i);
    }

    @ReactMethod
    public void handleSetJSResponder(int i, boolean z) {
        des findRootHelperForViewAncestor;
        if (this.mRegistry != null && (findRootHelperForViewAncestor = findRootHelperForViewAncestor(i)) != null && z) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class _m_j.des.AnonymousClass1 */

                public final void run() {
                    des.this.O00000o0();
                }
            });
        }
    }

    public Map getConstants() {
        return MapBuilder.of("State", MapBuilder.of("UNDETERMINED", 0, "BEGAN", 2, "ACTIVE", 4, "CANCELLED", 3, "FAILED", 1, "END", 5), "Direction", MapBuilder.of("RIGHT", 1, "LEFT", 2, "UP", 4, "DOWN", 8));
    }

    public der getRegistry() {
        return this.mRegistry;
    }

    public void onCatalystInstanceDestroy() {
        this.mRegistry.O000000o();
        deq deq = this.mInteractionManager;
        deq.f14555O000000o.clear();
        deq.O00000Oo.clear();
        synchronized (this.mRoots) {
            while (!this.mRoots.isEmpty()) {
                int size = this.mRoots.size();
                des des = this.mRoots.get(0);
                ReactRootView reactRootView = des.f14557O000000o;
                if (reactRootView instanceof RNGestureHandlerEnabledRootView) {
                    RNGestureHandlerEnabledRootView rNGestureHandlerEnabledRootView = (RNGestureHandlerEnabledRootView) reactRootView;
                    if (rNGestureHandlerEnabledRootView.O00000Oo != null) {
                        rNGestureHandlerEnabledRootView.O00000Oo.O000000o();
                        rNGestureHandlerEnabledRootView.O00000Oo = null;
                    }
                } else {
                    des.O000000o();
                }
                if (this.mRoots.size() >= size) {
                    throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                }
            }
        }
        super.onCatalystInstanceDestroy();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r5 = r4.mEnqueuedRootViewInit;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r4.mEnqueuedRootViewInit.contains(java.lang.Integer.valueOf(r1)) == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        r4.mEnqueuedRootViewInit.add(java.lang.Integer.valueOf(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r0.addUIBlock(new com.swmansion.gesturehandler.react.RNGestureHandlerModule.AnonymousClass2(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        return;
     */
    private void tryInitializeHandlerForReactRootView(int i) {
        UIManagerModule uIManagerModule = (UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class);
        final int resolveRootTagFromReactTag = uIManagerModule.resolveRootTagFromReactTag(i);
        if (resolveRootTagFromReactTag > 0) {
            synchronized (this.mRoots) {
                int i2 = 0;
                while (i2 < this.mRoots.size()) {
                    if (this.mRoots.get(i2).f14557O000000o.getRootViewTag() != resolveRootTagFromReactTag) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new JSApplicationIllegalArgumentException("Could find root view for a given ancestor with tag ".concat(String.valueOf(i)));
        }
    }

    public void registerRootHelper(des des) {
        synchronized (this.mRoots) {
            if (!this.mRoots.contains(des)) {
                this.mRoots.add(des);
            } else {
                throw new IllegalStateException("Root helper" + des + " already registered");
            }
        }
    }

    public void unregisterRootHelper(des des) {
        synchronized (this.mRoots) {
            this.mRoots.remove(des);
        }
    }

    private des findRootHelperForViewAncestor(int i) {
        int resolveRootTagFromReactTag = ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).resolveRootTagFromReactTag(i);
        if (resolveRootTagFromReactTag <= 0) {
            return null;
        }
        synchronized (this.mRoots) {
            for (int i2 = 0; i2 < this.mRoots.size(); i2++) {
                des des = this.mRoots.get(i2);
                if (des.f14557O000000o.getRootViewTag() == resolveRootTagFromReactTag) {
                    return des;
                }
            }
            return null;
        }
    }

    private O00000Oo findFactoryForHandler(dec dec) {
        int i = 0;
        while (true) {
            O00000Oo[] o00000OoArr = this.mHandlerFactories;
            if (i >= o00000OoArr.length) {
                return null;
            }
            O00000Oo o00000Oo = o00000OoArr[i];
            if (o00000Oo.O000000o().equals(dec.getClass())) {
                return o00000Oo;
            }
            i++;
        }
    }

    public static void handleHitSlopProperty(dec dec, ReadableMap readableMap) {
        float f;
        float f2;
        float f3;
        float f4;
        if (readableMap.getType("hitSlop") == ReadableType.Number) {
            float pixelFromDIP = PixelUtil.toPixelFromDIP(readableMap.getDouble("hitSlop"));
            dec.O000000o(pixelFromDIP, pixelFromDIP, pixelFromDIP, pixelFromDIP, Float.NaN, Float.NaN);
            return;
        }
        ReadableMap map = readableMap.getMap("hitSlop");
        if (map.hasKey("horizontal")) {
            f2 = PixelUtil.toPixelFromDIP(map.getDouble("horizontal"));
            f = f2;
        } else {
            f2 = Float.NaN;
            f = Float.NaN;
        }
        if (map.hasKey("vertical")) {
            f4 = PixelUtil.toPixelFromDIP(map.getDouble("vertical"));
            f3 = f4;
        } else {
            f4 = Float.NaN;
            f3 = Float.NaN;
        }
        if (map.hasKey("left")) {
            f2 = PixelUtil.toPixelFromDIP(map.getDouble("left"));
        }
        float f5 = f2;
        if (map.hasKey("top")) {
            f4 = PixelUtil.toPixelFromDIP(map.getDouble("top"));
        }
        float f6 = f4;
        if (map.hasKey("right")) {
            f = PixelUtil.toPixelFromDIP(map.getDouble("right"));
        }
        float f7 = f;
        if (map.hasKey("bottom")) {
            f3 = PixelUtil.toPixelFromDIP(map.getDouble("bottom"));
        }
        dec.O000000o(f5, f6, f7, f3, map.hasKey("width") ? PixelUtil.toPixelFromDIP(map.getDouble("width")) : Float.NaN, map.hasKey("height") ? PixelUtil.toPixelFromDIP(map.getDouble("height")) : Float.NaN);
    }

    public void onTouchEvent(dec dec, MotionEvent motionEvent) {
        if (dec.O00000oO >= 0 && dec.O0000O0o == 4) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(deo.O000000o(dec, findFactoryForHandler(dec)));
        }
    }

    public void onStateChange(dec dec, int i, int i2) {
        if (dec.O00000oO >= 0) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(det.O000000o(dec, i, i2, findFactoryForHandler(dec)));
        }
    }
}
