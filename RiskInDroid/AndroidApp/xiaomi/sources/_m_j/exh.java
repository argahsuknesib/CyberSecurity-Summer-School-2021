package _m_j;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class exh extends RecyclerView.O0000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15918O000000o = 2;
    private int O00000Oo;

    public exh(int i) {
        this.O00000Oo = i;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f15918O000000o;
        int i2 = childAdapterPosition % i;
        int i3 = this.O00000Oo;
        rect.left = (i2 * i3) / i;
        rect.right = i3 - (((i2 + 1) * i3) / i);
    }
}
