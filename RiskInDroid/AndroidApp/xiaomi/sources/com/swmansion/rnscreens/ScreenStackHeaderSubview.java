package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.view.ReactViewGroup;

public final class ScreenStackHeaderSubview extends ReactViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f5794O000000o;
    private int O00000Oo;
    private Type O00000o = Type.RIGHT;
    private final UIManagerModule O00000o0;

    public enum Type {
        LEFT,
        CENTER,
        TITLE,
        RIGHT
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5795O000000o;
        public int O00000Oo;

        public O000000o() {
        }
    }

    public final void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) {
            this.f5794O000000o = View.MeasureSpec.getSize(i);
            this.O00000Oo = View.MeasureSpec.getSize(i2);
            ViewParent parent = getParent();
            if (parent != null) {
                forceLayout();
                ((View) parent).requestLayout();
            }
        }
        setMeasuredDimension(this.f5794O000000o, this.O00000Oo);
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && (this.O00000o == Type.CENTER || this.O00000o == Type.TITLE)) {
            O000000o o000000o = new O000000o();
            o000000o.f5795O000000o = i3 - i;
            if (this.O00000o == Type.CENTER) {
                int width = ((View) getParent()).getWidth();
                o000000o.f5795O000000o = Math.max(0, width - (Math.max(width - i3, i) * 2));
            }
            o000000o.O00000Oo = i4 - i2;
            this.O00000o0.setViewLocalData(getId(), o000000o);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public ScreenStackHeaderSubview(ReactContext reactContext) {
        super(reactContext);
        this.O00000o0 = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
    }

    public final void setType(Type type) {
        this.O00000o = type;
    }

    public final Type getType() {
        return this.O00000o;
    }
}
