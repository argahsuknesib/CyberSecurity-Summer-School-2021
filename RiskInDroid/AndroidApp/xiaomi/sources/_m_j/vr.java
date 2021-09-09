package _m_j;

import _m_j.vp;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class vr extends RecyclerView.O000OOo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public vp f2557O000000o;
    @Deprecated
    public View O00000Oo;
    private final HashSet<Integer> O00000o = new HashSet<>();
    private final SparseArray<View> O00000o0 = new SparseArray<>();
    private final LinkedHashSet<Integer> O00000oO = new LinkedHashSet<>();
    private final LinkedHashSet<Integer> O00000oo = new LinkedHashSet<>();

    public vr(View view) {
        super(view);
        this.O00000Oo = view;
    }

    public final vr O000000o(int i, CharSequence charSequence) {
        ((TextView) O00000Oo(i)).setText(charSequence);
        return this;
    }

    public final vr O000000o(int i, boolean z) {
        O00000Oo(i).setVisibility(z ? 0 : 8);
        return this;
    }

    public final vr O00000Oo(int i, boolean z) {
        O00000Oo(i).setVisibility(z ? 0 : 4);
        return this;
    }

    public final vr O000000o(int i) {
        this.O00000oO.add(Integer.valueOf(i));
        View O00000Oo2 = O00000Oo(i);
        if (O00000Oo2 != null) {
            if (!O00000Oo2.isClickable()) {
                O00000Oo2.setClickable(true);
            }
            O00000Oo2.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.vr.AnonymousClass1 */

                public final void onClick(View view) {
                    if (vr.this.f2557O000000o.O0000O0o != null) {
                        vp.O000000o o000000o = vr.this.f2557O000000o.O0000O0o;
                        vr vrVar = vr.this;
                        o000000o.O000000o(view, vrVar.getLayoutPosition() >= vrVar.f2557O000000o.O00000Oo() ? vrVar.getLayoutPosition() - vrVar.f2557O000000o.O00000Oo() : 0);
                    }
                }
            });
        }
        return this;
    }

    public final <T extends View> T O00000Oo(int i) {
        T t = (View) this.O00000o0.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.itemView.findViewById(i);
        this.O00000o0.put(i, findViewById);
        return findViewById;
    }
}
