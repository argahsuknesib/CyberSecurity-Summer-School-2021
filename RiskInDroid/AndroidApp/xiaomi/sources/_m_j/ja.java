package _m_j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ja implements jc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected O000000o f1690O000000o;

    ja(Context context, ViewGroup viewGroup, View view) {
        this.f1690O000000o = new O000000o(context, viewGroup, view, this);
    }

    private static ViewGroup O000000o(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    static ja O00000o0(View view) {
        ViewGroup O000000o2 = O000000o(view);
        if (O000000o2 == null) {
            return null;
        }
        int childCount = O000000o2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = O000000o2.getChildAt(i);
            if (childAt instanceof O000000o) {
                return ((O000000o) childAt).O00000oO;
            }
        }
        return new iv(O000000o2.getContext(), O000000o2, view);
    }

    public final void O000000o(Drawable drawable) {
        O000000o o000000o = this.f1690O000000o;
        o000000o.O000000o();
        if (o000000o.O00000o == null) {
            o000000o.O00000o = new ArrayList<>();
        }
        if (!o000000o.O00000o.contains(drawable)) {
            o000000o.O00000o.add(drawable);
            o000000o.invalidate(drawable.getBounds());
            drawable.setCallback(o000000o);
        }
    }

    public final void O00000Oo(Drawable drawable) {
        O000000o o000000o = this.f1690O000000o;
        if (o000000o.O00000o != null) {
            o000000o.O00000o.remove(drawable);
            o000000o.invalidate(drawable.getBounds());
            drawable.setCallback(null);
            o000000o.O00000Oo();
        }
    }

    static class O000000o extends ViewGroup {

        /* renamed from: O000000o  reason: collision with root package name */
        static Method f1691O000000o;
        ViewGroup O00000Oo;
        ArrayList<Drawable> O00000o = null;
        View O00000o0;
        ja O00000oO;
        private boolean O00000oo;

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f1691O000000o = cls.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        O000000o(Context context, ViewGroup viewGroup, View view, ja jaVar) {
            super(context);
            this.O00000Oo = viewGroup;
            this.O00000o0 = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.O00000oO = jaVar;
        }

        /* access modifiers changed from: protected */
        public final boolean verifyDrawable(Drawable drawable) {
            if (super.verifyDrawable(drawable)) {
                return true;
            }
            ArrayList<Drawable> arrayList = this.O00000o;
            return arrayList != null && arrayList.contains(drawable);
        }

        public final void O000000o(View view) {
            O000000o();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.O00000Oo || viewGroup.getParent() == null || !cb.O000OO0o(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.O00000Oo.getLocationOnScreen(iArr2);
                    cb.O0000Oo(view, iArr[0] - iArr2[0]);
                    cb.O0000Oo0(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public final void O00000Oo(View view) {
            super.removeView(view);
            O00000Oo();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            if (this.O00000oo) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.O00000o;
                if (arrayList == null || arrayList.size() == 0) {
                    this.O00000oo = true;
                    this.O00000Oo.removeView(this);
                }
            }
        }

        public final void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public final void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.O00000Oo.getLocationOnScreen(iArr);
            this.O00000o0.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.O00000o0.getWidth(), this.O00000o0.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.O00000o;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.O00000o.get(i).draw(canvas);
            }
        }

        public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.O00000Oo == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            ViewGroup viewGroup = this.O00000Oo;
            if (viewGroup instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                int[] iArr3 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                this.O00000o0.getLocationOnScreen(iArr3);
                int[] iArr4 = {iArr3[0] - iArr2[0], iArr3[1] - iArr2[1]};
                rect.offset(iArr4[0], iArr4[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }
    }
}
