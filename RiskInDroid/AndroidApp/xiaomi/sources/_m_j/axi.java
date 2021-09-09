package _m_j;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public final class axi {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f12680O000000o;
    public final int O00000Oo;
    public final int O00000o;
    public final long O00000o0;
    public final int O00000oO;
    public final int O00000oo;
    public final int O0000O0o;
    public final Rect O0000OOo = new Rect();
    public final int O0000Oo0;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006c, code lost:
        if ((r5 instanceof androidx.recyclerview.widget.RecyclerView.LayoutParams) != false) goto L_0x0070;
     */
    public axi(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        this.f12680O000000o = o000OOo0.itemView.getWidth();
        this.O00000Oo = o000OOo0.itemView.getHeight();
        this.O00000o0 = o000OOo0.getItemId();
        this.O00000o = o000OOo0.itemView.getLeft();
        this.O00000oO = o000OOo0.itemView.getTop();
        this.O00000oo = i - this.O00000o;
        this.O0000O0o = i2 - this.O00000oO;
        ayd.O000000o(o000OOo0.itemView, this.O0000OOo);
        View O00000o2 = ayd.O00000o(o000OOo0);
        int i3 = 1;
        if (O00000o2 != null) {
            ViewGroup.LayoutParams layoutParams = O00000o2.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).O00000Oo) {
                    i3 = ayd.O00000Oo((RecyclerView) O00000o2.getParent());
                }
            } else if (layoutParams instanceof GridLayoutManager.LayoutParams) {
                i3 = ((GridLayoutManager.LayoutParams) layoutParams).O00000Oo;
            }
            this.O0000Oo0 = i3;
        }
        i3 = -1;
        this.O0000Oo0 = i3;
    }
}
