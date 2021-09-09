package _m_j;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public final class ezc extends RecyclerView.O000OOo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private SparseArray<View> f15971O000000o = new SparseArray<>();
    private View O00000Oo;

    private ezc(View view) {
        super(view);
        this.O00000Oo = view;
    }

    public static ezc O000000o(View view) {
        return new ezc(view);
    }

    public final <T extends View> T O000000o(int i) {
        T t = (View) this.f15971O000000o.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.O00000Oo.findViewById(i);
        this.f15971O000000o.put(i, findViewById);
        return findViewById;
    }

    public final ezc O000000o(int i, String str) {
        ((TextView) O000000o(i)).setText(str);
        return this;
    }
}
