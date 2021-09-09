package _m_j;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class cby extends RecyclerView.O0000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f13609O000000o;
    private int O00000Oo;
    private int O00000o0;

    public cby(int i, int i2, int i3) {
        this.f13609O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            rect.left = this.O00000Oo;
        } else {
            rect.left = this.f13609O000000o;
        }
        if (childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1) {
            rect.right = this.O00000o0;
        }
    }
}
