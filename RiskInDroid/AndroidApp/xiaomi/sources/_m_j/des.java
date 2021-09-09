package _m_j;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public final class des {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ReactRootView f14557O000000o;
    public boolean O00000Oo = false;
    private final dee O00000o;
    private final ReactContext O00000o0;
    private final dec O00000oO;
    private boolean O00000oo = false;

    private static ReactRootView O000000o(ViewGroup viewGroup) {
        UiThreadUtil.assertOnUiThread();
        ViewParent viewParent = viewGroup;
        while (viewParent != null && !(viewParent instanceof ReactRootView)) {
            viewParent = viewParent.getParent();
        }
        if (viewParent != null) {
            return (ReactRootView) viewParent;
        }
        throw new IllegalStateException("View " + viewGroup + " has not been mounted under ReactRootView");
    }

    public des(ReactContext reactContext, ViewGroup viewGroup) {
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        if (id > 0) {
            RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) reactContext.getNativeModule(RNGestureHandlerModule.class);
            der registry = rNGestureHandlerModule.getRegistry();
            this.f14557O000000o = O000000o(viewGroup);
            Log.i("ReactNative", "[GESTURE HANDLER] Initialize gesture handler for root view " + this.f14557O000000o);
            this.O00000o0 = reactContext;
            this.O00000o = new dee(viewGroup, registry, new deu());
            this.O00000o.O00000oo = 0.1f;
            this.O00000oO = new O000000o(this, (byte) 0);
            dec dec = this.O00000oO;
            dec.O00000oO = -id;
            registry.O000000o(dec);
            registry.O000000o(this.O00000oO.O00000oO, id);
            rNGestureHandlerModule.registerRootHelper(this);
            return;
        }
        throw new IllegalStateException("Expect view tag to be set for ".concat(String.valueOf(viewGroup)));
    }

    public final void O000000o() {
        Log.i("ReactNative", "[GESTURE HANDLER] Tearing down gesture handler registered for root view " + this.f14557O000000o);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) this.O00000o0.getNativeModule(RNGestureHandlerModule.class);
        rNGestureHandlerModule.getRegistry().O00000Oo(this.O00000oO.O00000oO);
        rNGestureHandlerModule.unregisterRootHelper(this);
    }

    class O000000o extends dec {
        private O000000o() {
        }

        /* synthetic */ O000000o(des des, byte b) {
            this();
        }

        public final void O000000o() {
            des.this.O00000Oo = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            obtain.setAction(3);
            des.this.f14557O000000o.onChildStartedNativeGesture(obtain);
        }

        public final void O000000o(MotionEvent motionEvent) {
            if (this.O0000O0o == 0) {
                O00000oo();
                des.this.O00000Oo = false;
            }
            if (motionEvent.getActionMasked() == 1) {
                O0000O0o();
            }
        }
    }

    public final void O00000Oo() {
        if (this.O00000o != null && !this.O00000oo) {
            O00000o0();
        }
    }

    public final boolean O000000o(MotionEvent motionEvent) {
        this.O00000oo = true;
        this.O00000o.O000000o(motionEvent);
        this.O00000oo = false;
        if (this.O00000Oo) {
            return true;
        }
        return false;
    }

    public final void O00000o0() {
        dec dec = this.O00000oO;
        if (dec != null && dec.O0000O0o == 2) {
            this.O00000oO.O00000oO();
            this.O00000oO.O0000O0o();
        }
    }
}
