package _m_j;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0005R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/RecyclerViewOffsetHelper;", "", "()V", "mRecyclerViewOffsetRecord", "", "", "Lkotlin/Pair;", "", "clear", "", "tag", "recoverOffset", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "saveOffset", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hai {

    /* renamed from: O000000o  reason: collision with root package name */
    final Map<String, Pair<Integer, Integer>> f18703O000000o = new LinkedHashMap();

    public final void O000000o(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            this.f18703O000000o.clear();
        } else {
            this.f18703O000000o.remove(str);
        }
    }
}
