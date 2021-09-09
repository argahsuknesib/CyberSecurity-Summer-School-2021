package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2757O000000o;
    private int O00000Oo;
    private LayoutInflater O00000o;
    private WeakReference<View> O00000o0;
    private O000000o O00000oO;

    public interface O000000o {
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas canvas) {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2757O000000o = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842960, 16842994, 16842995}, i, 0);
        this.O00000Oo = obtainStyledAttributes.getResourceId(2, -1);
        this.f2757O000000o = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final int getInflatedId() {
        return this.O00000Oo;
    }

    public final void setInflatedId(int i) {
        this.O00000Oo = i;
    }

    public final int getLayoutResource() {
        return this.f2757O000000o;
    }

    public final void setLayoutResource(int i) {
        this.f2757O000000o = i;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        this.O00000o = layoutInflater;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.O00000o;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final void setVisibility(int i) {
        WeakReference<View> weakReference = this.O00000o0;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            O000000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View O000000o() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2757O000000o != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.O00000o;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f2757O000000o, viewGroup, false);
            int i = this.O00000Oo;
            if (i != -1) {
                inflate.setId(i);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.O00000o0 = new WeakReference<>(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public final void setOnInflateListener(O000000o o000000o) {
        this.O00000oO = o000000o;
    }
}
