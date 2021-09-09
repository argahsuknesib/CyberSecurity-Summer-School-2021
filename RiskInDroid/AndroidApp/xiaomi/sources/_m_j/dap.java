package _m_j;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.appbar.AppBarLayout;

public final class dap {
    public static void O000000o(ViewGroup viewGroup, final dah dah) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
                    /* class _m_j.dap.AnonymousClass1 */

                    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                        dah dah = dah;
                        boolean z = true;
                        boolean z2 = i >= 0;
                        if (appBarLayout.getTotalScrollRange() + i > 0) {
                            z = false;
                        }
                        dah.O000000o(z2, z);
                    }
                });
            }
        }
    }
}
