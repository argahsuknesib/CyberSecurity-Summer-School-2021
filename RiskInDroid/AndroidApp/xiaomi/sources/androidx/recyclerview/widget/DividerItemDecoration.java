package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class DividerItemDecoration extends RecyclerView.O0000Oo {
    private static final int[] O00000Oo = {16843284};

    /* renamed from: O000000o  reason: collision with root package name */
    public Drawable f2930O000000o;
    private final Rect O00000o = new Rect();
    private int O00000o0;

    public DividerItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(O00000Oo);
        this.f2930O000000o = obtainStyledAttributes.getDrawable(0);
        if (this.f2930O000000o == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        this.O00000o0 = 1;
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        int i;
        int i2;
        int i3;
        int i4;
        if (recyclerView.getLayoutManager() != null && this.f2930O000000o != null) {
            int i5 = 0;
            if (this.O00000o0 == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i3 = recyclerView.getPaddingLeft();
                    i4 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i3, recyclerView.getPaddingTop(), i4, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i4 = recyclerView.getWidth();
                    i3 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (i5 < childCount) {
                    View childAt = recyclerView.getChildAt(i5);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, this.O00000o);
                    int round = this.O00000o.bottom + Math.round(childAt.getTranslationY());
                    this.f2930O000000o.setBounds(i3, round - this.f2930O000000o.getIntrinsicHeight(), i4, round);
                    this.f2930O000000o.draw(canvas);
                    i5++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i = recyclerView.getPaddingTop();
                i2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i, recyclerView.getWidth() - recyclerView.getPaddingRight(), i2);
            } else {
                i2 = recyclerView.getHeight();
                i = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (i5 < childCount2) {
                View childAt2 = recyclerView.getChildAt(i5);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, this.O00000o);
                int round2 = this.O00000o.right + Math.round(childAt2.getTranslationX());
                this.f2930O000000o.setBounds(round2 - this.f2930O000000o.getIntrinsicWidth(), i, round2, i2);
                this.f2930O000000o.draw(canvas);
                i5++;
            }
            canvas.restore();
        }
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        Drawable drawable = this.f2930O000000o;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.O00000o0 == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }
}
