package _m_j;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class hc {
    public static int O000000o(RecyclerView.O000OO0o o000OO0o, gz gzVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        int i;
        if (layoutManager.getChildCount() == 0 || o000OO0o.O000000o() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z2) {
            i = Math.max(0, (o000OO0o.O000000o() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(gzVar.O00000Oo(view2) - gzVar.O000000o(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (gzVar.O00000Oo() - gzVar.O000000o(view))));
    }

    public static int O000000o(RecyclerView.O000OO0o o000OO0o, gz gzVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || o000OO0o.O000000o() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return Math.min(gzVar.O00000oO(), gzVar.O00000Oo(view2) - gzVar.O000000o(view));
    }

    public static int O00000Oo(RecyclerView.O000OO0o o000OO0o, gz gzVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || o000OO0o.O000000o() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return o000OO0o.O000000o();
        }
        return (int) ((((float) (gzVar.O00000Oo(view2) - gzVar.O000000o(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) o000OO0o.O000000o()));
    }
}
