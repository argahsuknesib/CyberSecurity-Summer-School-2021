package _m_j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
final class ic extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    ViewGroup f1170O000000o;
    boolean O00000Oo = true;

    ic(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f1170O000000o = viewGroup;
        this.f1170O000000o.setTag(R.id.ghost_view_holder, this);
        iy.O000000o(this.f1170O000000o).O000000o(this);
    }

    public final void onViewAdded(View view) {
        if (this.O00000Oo) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f1170O000000o.setTag(R.id.ghost_view_holder, null);
            iy.O000000o(this.f1170O000000o).O00000Oo(this);
            this.O00000Oo = false;
        }
    }

    static ic O000000o(ViewGroup viewGroup) {
        return (ic) viewGroup.getTag(R.id.ghost_view_holder);
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i = 0;
        while (i <= childCount) {
            int i2 = (i + childCount) / 2;
            O000000o(((ie) getChildAt(i2)).O00000o0, arrayList2);
            if (O000000o(arrayList, arrayList2)) {
                i = i2 + 1;
            } else {
                childCount = i2 - 1;
            }
            arrayList2.clear();
        }
        return i;
    }

    private static boolean O000000o(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i = 1; i < min; i++) {
            View view = arrayList.get(i);
            View view2 = arrayList2.get(i);
            if (view != view2) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int childCount = viewGroup.getChildCount();
                if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
                    return view.getZ() > view2.getZ();
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(iy.O000000o(viewGroup, i2));
                    if (childAt == view) {
                        return false;
                    }
                    if (childAt == view2) {
                        return true;
                    }
                }
                return true;
            }
        }
        return arrayList2.size() == min;
    }

    static void O000000o(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            O000000o((View) parent, arrayList);
        }
        arrayList.add(view);
    }
}
