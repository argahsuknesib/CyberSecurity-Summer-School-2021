package _m_j;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class fxd extends RecyclerView.O0000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f17363O000000o;

    public fxd(int i) {
        this.f17363O000000o = i;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        super.getItemOffsets(rect, view, recyclerView, o000OO0o);
        int i = this.f17363O000000o;
        rect.set(i, i, i, i);
    }
}
