package _m_j;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/CardPathDrawableDefaultOffsetAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class haw extends haz {
    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        ixe.O00000o(recyclerView, "parent");
        ixe.O00000o(o000OO0o, "state");
        int dimension = (int) view.getResources().getDimension(R.dimen.main_page_flex_padding);
        if ((i < O000000o()) && j_()) {
            rect.top = gpc.O00000o0(view.getContext(), 7.0f);
        }
        if (O000000o() == 1) {
            rect.left = gpc.O00000o0(view.getContext(), 5.0f) + dimension;
            rect.right = gpc.O00000o0(view.getContext(), 5.0f) + dimension;
            return;
        }
        int O000000o2 = i % O000000o();
        if (O000000o2 == 0) {
            rect.left = gpc.O00000o0(view.getContext(), 5.0f) + dimension;
        } else if (O000000o2 == O000000o() - 1) {
            rect.right = gpc.O00000o0(view.getContext(), 5.0f) + dimension;
        }
    }
}
