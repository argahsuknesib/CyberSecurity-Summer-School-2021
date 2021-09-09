package _m_j;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"snapToTop", "", "Landroidx/recyclerview/widget/RecyclerView;", "threshold", "", "smarthome-mainpage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class hbe {
    public static final void O000000o(RecyclerView recyclerView, int i) {
        View childAt;
        ixe.O00000o(recyclerView, "<this>");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null && (childAt = linearLayoutManager.getChildAt(0)) != null && (-childAt.getTop()) <= i) {
            recyclerView.postDelayed(new Runnable() {
                /* class _m_j.$$Lambda$hbe$i19OIdjJiNmCrZCQCM9CbT8C4T8 */

                public final void run() {
                    hbe.O000000o(LinearLayoutManager.this);
                }
            }, 50);
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(LinearLayoutManager linearLayoutManager) {
        ixe.O00000o(linearLayoutManager, "$lm");
        linearLayoutManager.scrollToPositionWithOffset(0, 0);
    }
}
