package _m_j;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class gz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final RecyclerView.LayoutManager f18606O000000o;
    public int O00000Oo;
    final Rect O00000o0;

    public abstract int O000000o(View view);

    public abstract void O000000o(int i);

    public abstract int O00000Oo();

    public abstract int O00000Oo(View view);

    public abstract int O00000o();

    public abstract int O00000o(View view);

    public abstract int O00000o0();

    public abstract int O00000o0(View view);

    public abstract int O00000oO();

    public abstract int O00000oO(View view);

    public abstract int O00000oo();

    public abstract int O00000oo(View view);

    public abstract int O0000O0o();

    public abstract int O0000OOo();

    /* synthetic */ gz(RecyclerView.LayoutManager layoutManager, byte b) {
        this(layoutManager);
    }

    private gz(RecyclerView.LayoutManager layoutManager) {
        this.O00000Oo = Integer.MIN_VALUE;
        this.O00000o0 = new Rect();
        this.f18606O000000o = layoutManager;
    }

    public final int O000000o() {
        if (Integer.MIN_VALUE == this.O00000Oo) {
            return 0;
        }
        return O00000oO() - this.O00000Oo;
    }

    public static gz O000000o(RecyclerView.LayoutManager layoutManager, int i) {
        if (i == 0) {
            return O000000o(layoutManager);
        }
        if (i == 1) {
            return O00000Oo(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static gz O000000o(RecyclerView.LayoutManager layoutManager) {
        return new gz(layoutManager) {
            /* class _m_j.gz.AnonymousClass1 */

            public final int O00000o0() {
                return this.f18606O000000o.getWidth() - this.f18606O000000o.getPaddingRight();
            }

            public final int O00000o() {
                return this.f18606O000000o.getWidth();
            }

            public final void O000000o(int i) {
                this.f18606O000000o.offsetChildrenHorizontal(i);
            }

            public final int O00000Oo() {
                return this.f18606O000000o.getPaddingLeft();
            }

            public final int O00000oO(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f18606O000000o.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public final int O00000oo(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f18606O000000o.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public final int O00000Oo(View view) {
                return this.f18606O000000o.getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public final int O000000o(View view) {
                return this.f18606O000000o.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int O00000o0(View view) {
                this.f18606O000000o.getTransformedBoundingBox(view, true, this.O00000o0);
                return this.O00000o0.right;
            }

            public final int O00000o(View view) {
                this.f18606O000000o.getTransformedBoundingBox(view, true, this.O00000o0);
                return this.O00000o0.left;
            }

            public final int O00000oO() {
                return (this.f18606O000000o.getWidth() - this.f18606O000000o.getPaddingLeft()) - this.f18606O000000o.getPaddingRight();
            }

            public final int O00000oo() {
                return this.f18606O000000o.getPaddingRight();
            }

            public final int O0000O0o() {
                return this.f18606O000000o.getWidthMode();
            }

            public final int O0000OOo() {
                return this.f18606O000000o.getHeightMode();
            }
        };
    }

    public static gz O00000Oo(RecyclerView.LayoutManager layoutManager) {
        return new gz(layoutManager) {
            /* class _m_j.gz.AnonymousClass2 */

            public final int O00000o0() {
                return this.f18606O000000o.getHeight() - this.f18606O000000o.getPaddingBottom();
            }

            public final int O00000o() {
                return this.f18606O000000o.getHeight();
            }

            public final void O000000o(int i) {
                this.f18606O000000o.offsetChildrenVertical(i);
            }

            public final int O00000Oo() {
                return this.f18606O000000o.getPaddingTop();
            }

            public final int O00000oO(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f18606O000000o.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public final int O00000oo(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f18606O000000o.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public final int O00000Oo(View view) {
                return this.f18606O000000o.getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public final int O000000o(View view) {
                return this.f18606O000000o.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int O00000o0(View view) {
                this.f18606O000000o.getTransformedBoundingBox(view, true, this.O00000o0);
                return this.O00000o0.bottom;
            }

            public final int O00000o(View view) {
                this.f18606O000000o.getTransformedBoundingBox(view, true, this.O00000o0);
                return this.O00000o0.top;
            }

            public final int O00000oO() {
                return (this.f18606O000000o.getHeight() - this.f18606O000000o.getPaddingTop()) - this.f18606O000000o.getPaddingBottom();
            }

            public final int O00000oo() {
                return this.f18606O000000o.getPaddingBottom();
            }

            public final int O0000O0o() {
                return this.f18606O000000o.getHeightMode();
            }

            public final int O0000OOo() {
                return this.f18606O000000o.getWidthMode();
            }
        };
    }
}
