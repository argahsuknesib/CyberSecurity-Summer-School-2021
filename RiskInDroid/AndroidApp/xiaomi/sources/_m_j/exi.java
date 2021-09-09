package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C;

public final class exi extends RecyclerView.O0000Oo {
    private static final int[] O00000oO = {16843284};

    /* renamed from: O000000o  reason: collision with root package name */
    private Paint f15919O000000o;
    private Drawable O00000Oo;
    private int O00000o;
    private int O00000o0;

    private exi(Context context, int i) {
        this.O00000o0 = 2;
        this.O00000o = C.MSG_CUSTOM_BASE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(O00000oO);
        this.O00000Oo = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public exi(Context context, int i, int i2) {
        this(context, C.MSG_CUSTOM_BASE);
        this.O00000o0 = i;
        this.f15919O000000o = new Paint(1);
        this.f15919O000000o.setColor(i2);
        this.f15919O000000o.setStyle(Paint.Style.FILL);
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        super.getItemOffsets(rect, view, recyclerView, o000OO0o);
        rect.set(0, 0, 0, this.O00000o0);
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        super.onDraw(canvas, recyclerView, o000OO0o);
        int i = this.O00000o;
        if (i == 10000) {
            O00000Oo(canvas, recyclerView);
            O000000o(canvas, recyclerView);
        } else if (i == 1) {
            O00000Oo(canvas, recyclerView);
        } else {
            O000000o(canvas, recyclerView);
        }
    }

    private void O000000o(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i2 = this.O00000o0 + bottom;
            Drawable drawable = this.O00000Oo;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                this.O00000Oo.draw(canvas);
            }
            Paint paint = this.f15919O000000o;
            if (paint != null) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i2, paint);
            }
        }
    }

    private void O00000Oo(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            int i2 = this.O00000o0 + right;
            Drawable drawable = this.O00000Oo;
            if (drawable != null) {
                drawable.setBounds(right, paddingTop, i2, measuredHeight);
                this.O00000Oo.draw(canvas);
            }
            Paint paint = this.f15919O000000o;
            if (paint != null) {
                canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, paint);
            }
        }
    }
}
