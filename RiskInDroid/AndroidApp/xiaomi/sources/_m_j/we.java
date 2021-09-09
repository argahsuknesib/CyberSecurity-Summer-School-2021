package _m_j;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

public final class we extends RecyclerView.O000OOo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private SparseArray<View> f2571O000000o = new SparseArray<>();

    public we(View view) {
        super(view);
    }

    public final <T extends View> T O000000o(int i) {
        T t = (View) this.f2571O000000o.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.itemView.findViewById(i);
        this.f2571O000000o.put(i, findViewById);
        return findViewById;
    }

    public final we O000000o(int i, int i2) {
        ((ImageView) O000000o(i)).setImageResource(i2);
        return this;
    }
}
