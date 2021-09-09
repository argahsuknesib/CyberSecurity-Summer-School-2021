package com.swmansion.rnscreens;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.UIManagerModule;

public final class Screen extends ViewGroup implements ReactPointerEventsView {

    /* renamed from: O000000o  reason: collision with root package name */
    public static View.OnAttachStateChangeListener f5782O000000o = new View.OnAttachStateChangeListener() {
        /* class com.swmansion.rnscreens.Screen.AnonymousClass1 */

        public final void onViewDetachedFromWindow(View view) {
        }

        public final void onViewAttachedToWindow(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
            view.removeOnAttachStateChangeListener(Screen.f5782O000000o);
        }
    };
    boolean O00000Oo;
    private ScreenContainer O00000o;
    private Fragment O00000o0;
    private boolean O00000oO;
    private StackPresentation O00000oo = StackPresentation.PUSH;
    private StackAnimation O0000O0o = StackAnimation.DEFAULT;

    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE
    }

    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL
    }

    public final void setLayerType(int i, Paint paint) {
    }

    public Screen(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            final int i5 = i3 - i;
            final int i6 = i4 - i2;
            ReactContext reactContext = (ReactContext) getContext();
            final ReactContext reactContext2 = reactContext;
            reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) {
                /* class com.swmansion.rnscreens.Screen.AnonymousClass2 */

                public final void runGuarded() {
                    ((UIManagerModule) reactContext2.getNativeModule(UIManagerModule.class)).updateNodeSize(Screen.this.getId(), i5, i6);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearDisappearingChildren();
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            while (focusedChild instanceof ViewGroup) {
                focusedChild = ((ViewGroup) focusedChild).getFocusedChild();
            }
            if (focusedChild instanceof TextView) {
                TextView textView = (TextView) focusedChild;
                if (textView.getShowSoftInputOnFocus()) {
                    textView.addOnAttachStateChangeListener(f5782O000000o);
                }
            }
        }
    }

    public final void setTransitioning(boolean z) {
        if (this.O00000oO != z) {
            this.O00000oO = z;
            super.setLayerType(z ? 2 : 0, null);
        }
    }

    public final void setStackPresentation(StackPresentation stackPresentation) {
        this.O00000oo = stackPresentation;
    }

    public final void setStackAnimation(StackAnimation stackAnimation) {
        this.O0000O0o = stackAnimation;
    }

    public final StackAnimation getStackAnimation() {
        return this.O0000O0o;
    }

    public final StackPresentation getStackPresentation() {
        return this.O00000oo;
    }

    public final PointerEvents getPointerEvents() {
        return this.O00000oO ? PointerEvents.NONE : PointerEvents.AUTO;
    }

    /* access modifiers changed from: protected */
    public final void setContainer(ScreenContainer screenContainer) {
        this.O00000o = screenContainer;
    }

    /* access modifiers changed from: protected */
    public final void setFragment(Fragment fragment) {
        this.O00000o0 = fragment;
    }

    /* access modifiers changed from: protected */
    public final Fragment getFragment() {
        return this.O00000o0;
    }

    /* access modifiers changed from: protected */
    public final ScreenContainer getContainer() {
        return this.O00000o;
    }

    public final void setActive(boolean z) {
        if (z != this.O00000Oo) {
            this.O00000Oo = z;
            ScreenContainer screenContainer = this.O00000o;
            if (screenContainer != null) {
                screenContainer.O000000o();
            }
        }
    }
}
