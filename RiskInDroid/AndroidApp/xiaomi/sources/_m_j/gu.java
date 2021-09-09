package _m_j;

import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

final class gu implements gt {

    /* renamed from: O000000o  reason: collision with root package name */
    static final gt f18275O000000o = new gu();

    gu() {
    }

    public final void O000000o(RecyclerView recyclerView, View view, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Float valueOf = Float.valueOf(cb.O0000oOO(view));
            int childCount = recyclerView.getChildCount();
            float f3 = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float O0000oOO = cb.O0000oOO(childAt);
                    if (O0000oOO > f3) {
                        f3 = O0000oOO;
                    }
                }
            }
            cb.O0000Oo(view, 1.0f + f3);
            view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    public final void O000000o(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag instanceof Float) {
                cb.O0000Oo(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.item_touch_helper_previous_elevation, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }
}
