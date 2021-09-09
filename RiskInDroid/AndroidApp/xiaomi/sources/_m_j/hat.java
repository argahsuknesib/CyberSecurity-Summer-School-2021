package _m_j;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0014H\u0014J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/AutoOffsetBottomOnEditModeAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "offset", "", "(I)V", "getOffset", "()I", "getItemCount", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "isVisibleToUser", "", "onAnyEditModeChanged", "current", "onBindViewHolder", "p0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hat extends haz {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f18713O000000o;

    public final boolean l_() {
        return false;
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "p0");
    }

    public /* synthetic */ hat() {
        this(gpc.O00000o0(CommonApplication.getAppContext(), 107.0f) - CommonApplication.getAppContext().getResources().getDimensionPixelOffset(R.dimen.bottom_bar_height));
    }

    public hat(int i) {
        this.f18713O000000o = i;
    }

    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        return new O000000o(this, new View(viewGroup.getContext()));
    }

    public final int getItemCount() {
        return (this.O00000oO || this.O00000o) ? 1 : 0;
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        if (this.O00000oO || this.O00000o) {
            rect.bottom = this.f18713O000000o;
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(boolean z) {
        if (z) {
            notifyItemInserted(0);
        } else {
            notifyItemRemoved(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/AutoOffsetBottomOnEditModeAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/AutoOffsetBottomOnEditModeAdapter;Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hat f18714O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(hat hat, View view) {
            super(view);
            ixe.O00000o(hat, "this$0");
            ixe.O00000o(view, "item");
            this.f18714O000000o = hat;
        }
    }
}
