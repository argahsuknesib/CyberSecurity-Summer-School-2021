package androidx.appcompat.app;

import _m_j.OO00O0o;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

public abstract class ActionBar {

    @Deprecated
    public static abstract class O000000o {
        public abstract Drawable O000000o();

        public abstract CharSequence O00000Oo();

        public abstract CharSequence O00000o();

        public abstract View O00000o0();
    }

    public OO00O0o O000000o(OO00O0o.O000000o o000000o) {
        return null;
    }

    public abstract void O000000o();

    public void O000000o(int i) {
    }

    public void O000000o(Configuration configuration) {
    }

    public abstract void O000000o(CharSequence charSequence);

    public abstract void O000000o(boolean z);

    public boolean O000000o(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean O000000o(KeyEvent keyEvent) {
        return false;
    }

    public abstract void O00000Oo();

    public void O00000Oo(CharSequence charSequence) {
    }

    public void O00000Oo(boolean z) {
    }

    public abstract int O00000o();

    public void O00000o(boolean z) {
    }

    public abstract int O00000o0();

    public void O00000o0(boolean z) {
    }

    public Context O00000oO() {
        return null;
    }

    public boolean O0000O0o() {
        return false;
    }

    public boolean O0000OOo() {
        return false;
    }

    public boolean O0000Oo() {
        return false;
    }

    public boolean O0000Oo0() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void O0000OoO() {
    }

    public void O00000oo() {
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void O000000o(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2633O000000o;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2633O000000o = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842931});
            this.f2633O000000o = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(-2, i2);
            this.f2633O000000o = 0;
            this.f2633O000000o = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f2633O000000o = 0;
            this.f2633O000000o = layoutParams.f2633O000000o;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2633O000000o = 0;
        }
    }
}
