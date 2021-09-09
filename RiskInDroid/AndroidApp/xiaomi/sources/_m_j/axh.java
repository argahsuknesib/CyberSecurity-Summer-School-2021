package _m_j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

final class axh extends axb {
    int O00000oO;
    int O00000oo;
    int O0000O0o;
    int O0000OOo;
    int O0000Oo;
    int O0000Oo0;
    NinePatchDrawable O0000OoO;
    final Rect O0000Ooo = new Rect();
    private boolean O0000o;
    private Bitmap O0000o0;
    axi O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private axj O0000oO;
    private boolean O0000oO0;
    private int O0000oOO;

    public axh(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, axj axj) {
        super(recyclerView, o000OOo0);
        this.O0000oO = axj;
    }

    private static int O000000o(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private static View O000000o(RecyclerView recyclerView, axj axj, int i, int i2) {
        int layoutPosition;
        if (i == -1 || i2 == -1) {
            return null;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            RecyclerView.O000OOo0 childViewHolder = recyclerView.getChildViewHolder(childAt);
            if (childViewHolder != null && (layoutPosition = childViewHolder.getLayoutPosition()) >= i && layoutPosition <= i2 && axj.O000000o(layoutPosition)) {
                return childAt;
            }
        }
        return null;
    }

    private static View O00000Oo(RecyclerView recyclerView, axj axj, int i, int i2) {
        int layoutPosition;
        if (i == -1 || i2 == -1) {
            return null;
        }
        for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = recyclerView.getChildAt(childCount);
            RecyclerView.O000OOo0 childViewHolder = recyclerView.getChildViewHolder(childAt);
            if (childViewHolder != null && (layoutPosition = childViewHolder.getLayoutPosition()) >= i && layoutPosition <= i2 && axj.O000000o(layoutPosition)) {
                return childAt;
            }
        }
        return null;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        if (this.O0000o0 != null) {
            canvas.drawBitmap(this.O0000o0, (float) (this.O00000oO - this.O0000Ooo.left), (float) (this.O00000oo - this.O0000Ooo.top), (Paint) null);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axh.O000000o(android.view.MotionEvent, boolean):boolean
     arg types: [android.view.MotionEvent, int]
     candidates:
      _m_j.axh.O000000o(float, int):void
      _m_j.axh.O000000o(android.view.MotionEvent, _m_j.axi):void
      _m_j.axb.O000000o(android.view.View, boolean):void
      _m_j.axh.O000000o(android.view.MotionEvent, boolean):boolean */
    public final void O000000o(MotionEvent motionEvent, axi axi) {
        if (!this.O0000o) {
            View view = this.O00000o.itemView;
            this.O0000o00 = axi;
            NinePatchDrawable ninePatchDrawable = this.O0000OoO;
            int width = view.getWidth() + this.O0000Ooo.left + this.O0000Ooo.right;
            int height = view.getHeight() + this.O0000Ooo.top + this.O0000Ooo.bottom;
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            if (ninePatchDrawable != null) {
                ninePatchDrawable.setBounds(0, 0, width, height);
                ninePatchDrawable.draw(canvas);
            }
            int save = canvas.save(3);
            canvas.clipRect(this.O0000Ooo.left, this.O0000Ooo.top, width - this.O0000Ooo.right, height - this.O0000Ooo.bottom);
            canvas.translate((float) this.O0000Ooo.left, (float) this.O0000Ooo.top);
            view.draw(canvas);
            canvas.restoreToCount(save);
            this.O0000o0 = createBitmap;
            this.O0000O0o = this.O00000o0.getPaddingLeft();
            this.O0000Oo0 = this.O00000o0.getPaddingTop();
            this.O0000oOO = ayd.O00000Oo(this.O00000o0.getLayoutManager());
            view.setVisibility(4);
            O000000o(motionEvent, true);
            this.O00000o0.addItemDecoration(this);
            this.O0000o = true;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axb.O000000o(android.view.View, boolean):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.axh.O000000o(float, int):void
      _m_j.axh.O000000o(android.view.MotionEvent, _m_j.axi):void
      _m_j.axh.O000000o(android.view.MotionEvent, boolean):boolean
      _m_j.axb.O000000o(android.view.View, boolean):void */
    public final void O000000o() {
        if (this.O0000o) {
            this.O00000o0.removeItemDecoration(this);
        }
        RecyclerView.O0000OOo itemAnimator = this.O00000o0.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.O00000o();
        }
        this.O00000o0.stopScroll();
        O000000o((float) this.O00000oO, this.O00000oo);
        if (this.O00000o != null) {
            O000000o(this.O00000o.itemView, true);
        }
        if (this.O00000o != null) {
            this.O00000o.itemView.setVisibility(0);
        }
        this.O00000o = null;
        Bitmap bitmap = this.O0000o0;
        if (bitmap != null) {
            bitmap.recycle();
            this.O0000o0 = null;
        }
        this.O0000oO = null;
        this.O00000oO = 0;
        this.O00000oo = 0;
        this.O0000O0o = 0;
        this.O0000OOo = 0;
        this.O0000Oo0 = 0;
        this.O0000Oo = 0;
        this.O0000o0O = 0;
        this.O0000o0o = 0;
        this.O0000o = false;
    }

    public final boolean O000000o(MotionEvent motionEvent, boolean z) {
        this.O0000o0O = (int) (motionEvent.getX() + 0.5f);
        this.O0000o0o = (int) (motionEvent.getY() + 0.5f);
        return O000000o(z);
    }

    public final boolean O000000o(boolean z) {
        int i = this.O00000oO;
        int i2 = this.O00000oo;
        O00000o0();
        boolean z2 = (i == this.O00000oO && i2 == this.O00000oo) ? false : true;
        if (z2 || z) {
            O000000o((float) this.O00000oO, this.O00000oo);
            cb.O00000oo(this.O00000o0);
        }
        return z2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ayd.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):int
     arg types: [androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      _m_j.ayd.O000000o(android.view.View, android.graphics.Rect):android.graphics.Rect
      _m_j.ayd.O000000o(androidx.recyclerview.widget.RecyclerView$LayoutManager, int):android.view.View
      _m_j.ayd.O000000o(androidx.recyclerview.widget.RecyclerView, boolean):int */
    private void O00000o0() {
        RecyclerView recyclerView = this.O00000o0;
        if (recyclerView.getChildCount() > 0) {
            this.O0000O0o = 0;
            this.O0000OOo = recyclerView.getWidth() - this.O0000o00.f12680O000000o;
            this.O0000Oo0 = 0;
            this.O0000Oo = recyclerView.getHeight() - this.O0000o00.O00000Oo;
            int i = this.O0000oOO;
            if (i == 0) {
                this.O0000Oo0 += recyclerView.getPaddingTop();
                this.O0000Oo -= recyclerView.getPaddingBottom();
            } else if (i == 1) {
                this.O0000O0o += recyclerView.getPaddingLeft();
                this.O0000OOo -= recyclerView.getPaddingRight();
            }
            this.O0000OOo = Math.max(this.O0000O0o, this.O0000OOo);
            this.O0000Oo = Math.max(this.O0000Oo0, this.O0000Oo);
            if (!this.O0000oO0) {
                int O000000o2 = ayd.O000000o(recyclerView, true);
                int O000000o3 = ayd.O000000o(recyclerView);
                View O000000o4 = O000000o(recyclerView, this.O0000oO, O000000o2, O000000o3);
                View O00000Oo = O00000Oo(recyclerView, this.O0000oO, O000000o2, O000000o3);
                int i2 = this.O0000oOO;
                if (i2 == 0) {
                    if (O000000o4 != null) {
                        this.O0000O0o = Math.min(this.O0000O0o, O000000o4.getLeft());
                    }
                    if (O00000Oo != null) {
                        this.O0000OOo = Math.min(this.O0000OOo, Math.max(0, O00000Oo.getRight() - this.O0000o00.f12680O000000o));
                    }
                } else if (i2 == 1) {
                    if (O000000o4 != null) {
                        this.O0000Oo0 = Math.min(this.O0000Oo, O000000o4.getTop());
                    }
                    if (O00000Oo != null) {
                        this.O0000Oo = Math.min(this.O0000Oo, Math.max(0, O00000Oo.getBottom() - this.O0000o00.O00000Oo));
                    }
                }
            }
        } else {
            int paddingLeft = recyclerView.getPaddingLeft();
            this.O0000O0o = paddingLeft;
            this.O0000OOo = paddingLeft;
            int paddingTop = recyclerView.getPaddingTop();
            this.O0000Oo0 = paddingTop;
            this.O0000Oo = paddingTop;
        }
        this.O00000oO = this.O0000o0O - this.O0000o00.O00000oo;
        this.O00000oo = this.O0000o0o - this.O0000o00.O0000O0o;
        this.O00000oO = O000000o(this.O00000oO, this.O0000O0o, this.O0000OOo);
        this.O00000oo = O000000o(this.O00000oo, this.O0000Oo0, this.O0000Oo);
    }

    private void O000000o(float f, int i) {
        if (this.O00000o != null) {
            O000000o(this.O00000o0, this.O00000o, f - ((float) this.O00000o.itemView.getLeft()), (float) (i - this.O00000o.itemView.getTop()));
        }
    }

    public final void O00000Oo(boolean z) {
        if (this.O0000oO0 != z) {
            this.O0000oO0 = z;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O000000o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O000000o(int, int):int
      _m_j.cb.O000000o(android.view.View, _m_j.ci):_m_j.ci
      _m_j.cb.O000000o(int, android.view.View):void
      _m_j.cb.O000000o(android.view.View, _m_j.bh):void
      _m_j.cb.O000000o(android.view.View, _m_j.bw):void
      _m_j.cb.O000000o(android.view.View, _m_j.by):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl$O000000o):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl):void
      _m_j.cb.O000000o(android.view.View, android.content.res.ColorStateList):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Paint):void
      _m_j.cb.O000000o(android.view.View, android.graphics.PorterDuff$Mode):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Rect):void
      _m_j.cb.O000000o(android.view.View, android.graphics.drawable.Drawable):void
      _m_j.cb.O000000o(android.view.View, java.lang.Runnable):void
      _m_j.cb.O000000o(android.view.View, java.lang.String):void
      _m_j.cb.O000000o(android.view.View, boolean):void
      _m_j.cb.O000000o(android.view.View, int):boolean
      _m_j.cb.O000000o(android.view.View, android.view.KeyEvent):boolean
      _m_j.cb.O000000o(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000Oo(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000Oo(android.view.View, _m_j.ci):_m_j.ci
      _m_j.cb.O00000Oo(android.view.View, boolean):void
      _m_j.cb.O00000Oo(android.view.View, int):boolean
      _m_j.cb.O00000Oo(android.view.View, android.view.KeyEvent):boolean
      _m_j.cb.O00000Oo(android.view.View, float):void */
    public final void O00000Oo() {
        if (this.O00000o != null) {
            cb.O000000o(this.O00000o.itemView, 0.0f);
            cb.O00000Oo(this.O00000o.itemView, 0.0f);
            this.O00000o.itemView.setVisibility(0);
        }
        this.O00000o = null;
    }

    public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        if (this.O00000o == null) {
            this.O00000o = o000OOo0;
            o000OOo0.itemView.setVisibility(4);
            return;
        }
        throw new IllegalStateException("A new view holder is attempt to be assigned before invalidating the older one");
    }
}
