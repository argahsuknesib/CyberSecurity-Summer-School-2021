package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class cbx extends RecyclerView.O0000Oo {
    private static final int[] O00000oO = {16843284};

    /* renamed from: O000000o  reason: collision with root package name */
    private Paint f13608O000000o;
    private Drawable O00000Oo;
    private int O00000o;
    private int O00000o0;

    private cbx(Context context, int i) {
        this.O00000o0 = 2;
        this.O00000o = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(O00000oO);
        this.O00000Oo = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public cbx(Context context, int i, int i2) {
        this(context, 0);
        this.O00000o0 = i;
        this.f13608O000000o = new Paint(1);
        this.f13608O000000o.setColor(i2);
        this.f13608O000000o.setStyle(Paint.Style.FILL);
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        super.getItemOffsets(rect, view, recyclerView, o000OO0o);
        rect.set(0, 0, 0, this.O00000o0);
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        super.onDraw(canvas, recyclerView, o000OO0o);
        int i = 0;
        if (this.O00000o == 1) {
            int paddingTop = recyclerView.getPaddingTop();
            int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
                int i2 = this.O00000o0 + right;
                Drawable drawable = this.O00000Oo;
                if (drawable != null) {
                    drawable.setBounds(right, paddingTop, i2, measuredHeight);
                    this.O00000Oo.draw(canvas);
                }
                Paint paint = this.f13608O000000o;
                if (paint != null) {
                    canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, paint);
                }
                i++;
            }
            return;
        }
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount2 = recyclerView.getChildCount();
        while (i < childCount2) {
            View childAt2 = recyclerView.getChildAt(i);
            int bottom = childAt2.getBottom() + ((RecyclerView.LayoutParams) childAt2.getLayoutParams()).bottomMargin;
            int i3 = this.O00000o0 + bottom;
            Drawable drawable2 = this.O00000Oo;
            if (drawable2 != null) {
                drawable2.setBounds(paddingLeft, bottom, measuredWidth, i3);
                this.O00000Oo.draw(canvas);
            }
            Paint paint2 = this.f13608O000000o;
            if (paint2 != null) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i3, paint2);
            }
            i++;
        }
    }
}
