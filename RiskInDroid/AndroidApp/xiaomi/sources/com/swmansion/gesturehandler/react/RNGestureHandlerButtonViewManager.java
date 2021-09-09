package com.swmansion.gesturehandler.react;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> {
    public String getName() {
        return "RNGestureHandlerButton";
    }

    static class ButtonViewGroup extends ViewGroup {

        /* renamed from: O000000o  reason: collision with root package name */
        static TypedValue f5765O000000o = new TypedValue();
        static ButtonViewGroup O00000Oo;
        Integer O00000o;
        int O00000o0 = 0;
        boolean O00000oO = false;
        boolean O00000oo = false;
        float O0000O0o = 0.0f;
        boolean O0000OOo = false;

        public void dispatchDrawableHotspotChanged(float f, float f2) {
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public ButtonViewGroup(Context context) {
            super(context);
            setClickable(true);
            setFocusable(true);
            this.O0000OOo = true;
        }

        public void setBackgroundColor(int i) {
            this.O00000o0 = i;
            this.O0000OOo = true;
        }

        /* access modifiers changed from: package-private */
        public final Drawable O000000o(Drawable drawable) {
            if (this.O00000o != null && drawable != null && Build.VERSION.SDK_INT >= 21 && (drawable instanceof RippleDrawable)) {
                ((RippleDrawable) drawable).setColor(new ColorStateList(new int[][]{new int[]{16842910}}, new int[]{this.O00000o.intValue()}));
            }
            return drawable;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            if (isPressed()) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final Drawable O000000o() {
            int i = Build.VERSION.SDK_INT;
            getContext().getTheme().resolveAttribute(getResources().getIdentifier((!this.O00000oo || i < 21) ? "selectableItemBackground" : "selectableItemBackgroundBorderless", "attr", "android"), f5765O000000o, true);
            if (i >= 21) {
                return getResources().getDrawable(f5765O000000o.resourceId, getContext().getTheme());
            }
            return getResources().getDrawable(f5765O000000o.resourceId);
        }

        public void drawableHotspotChanged(float f, float f2) {
            ButtonViewGroup buttonViewGroup = O00000Oo;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f, f2);
            }
        }

        public void setPressed(boolean z) {
            if (z && O00000Oo == null) {
                O00000Oo = this;
            }
            if (!z || O00000Oo == this) {
                super.setPressed(z);
            }
            if (!z && O00000Oo == this) {
                O00000Oo = null;
            }
        }
    }

    public ButtonViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ButtonViewGroup(themedReactContext);
    }

    @ReactProp(name = "enabled")
    public void setEnabled(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.setEnabled(z);
    }

    @ReactProp(name = "foreground")
    @TargetApi(23)
    public void setForeground(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.O00000oO = z;
        buttonViewGroup.O0000OOo = true;
    }

    @ReactProp(name = "borderless")
    public void setBorderless(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.O00000oo = z;
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(ButtonViewGroup buttonViewGroup, float f) {
        buttonViewGroup.O0000O0o = f * buttonViewGroup.getResources().getDisplayMetrics().density;
        buttonViewGroup.O0000OOo = true;
    }

    @ReactProp(name = "rippleColor")
    public void setRippleColor(ButtonViewGroup buttonViewGroup, Integer num) {
        buttonViewGroup.O00000o = num;
        buttonViewGroup.O0000OOo = true;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ButtonViewGroup buttonViewGroup) {
        if (buttonViewGroup.O0000OOo) {
            buttonViewGroup.O0000OOo = false;
            if (buttonViewGroup.O00000o0 == 0) {
                buttonViewGroup.setBackground(null);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                buttonViewGroup.setForeground(null);
            }
            if (buttonViewGroup.O00000oO && Build.VERSION.SDK_INT >= 23) {
                buttonViewGroup.setForeground(buttonViewGroup.O000000o(buttonViewGroup.O000000o()));
                if (buttonViewGroup.O00000o0 != 0) {
                    buttonViewGroup.setBackgroundColor(buttonViewGroup.O00000o0);
                }
            } else if (buttonViewGroup.O00000o0 == 0 && buttonViewGroup.O00000o == null) {
                buttonViewGroup.setBackground(buttonViewGroup.O000000o());
            } else {
                PaintDrawable paintDrawable = new PaintDrawable(buttonViewGroup.O00000o0);
                Drawable O000000o2 = buttonViewGroup.O000000o();
                if (buttonViewGroup.O0000O0o != 0.0f) {
                    paintDrawable.setCornerRadius(buttonViewGroup.O0000O0o);
                    if (Build.VERSION.SDK_INT >= 21 && (O000000o2 instanceof RippleDrawable)) {
                        PaintDrawable paintDrawable2 = new PaintDrawable(-1);
                        paintDrawable2.setCornerRadius(buttonViewGroup.O0000O0o);
                        ((RippleDrawable) O000000o2).setDrawableByLayerId(16908334, paintDrawable2);
                    }
                }
                buttonViewGroup.O000000o(O000000o2);
                buttonViewGroup.setBackground(new LayerDrawable(new Drawable[]{paintDrawable, O000000o2}));
            }
        }
    }
}
