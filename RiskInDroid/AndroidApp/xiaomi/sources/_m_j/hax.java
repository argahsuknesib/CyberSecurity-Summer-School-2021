package _m_j;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J0\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0001H\u0016J \u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0016J*\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J \u0010*\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0016J(\u0010+\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0016J \u0010.\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0012\u0010/\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u00100\u001a\u00020\r2\u0006\u0010\u0017\u001a\u0002012\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J8\u00103\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u0001052\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u00106\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J8\u00107\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u0001052\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u00108\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\u001a\u0010;\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010<\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DelegateWrapperAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapterBridge;", "delegate", "(Lcom/xiaomi/smarthome/multi_item/IAdapter;)V", "attachDragHelper", "", "touchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "clearView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "getColumn", "getItemCount", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getMovementFlags", "isFirstVisibleOf", "", "child", "isLastVisibleOf", "onAttachedToRecyclerView", "onBindViewHolder", "vh", "pos", "onChildAdapterChanged", "adapter", "onChildAdapterItemRangeChanged", "start", "count", "payload", "", "onChildAdapterItemRangeInserted", "onChildAdapterItemRangeMoved", "from", "to", "onChildAdapterItemRangeRemoved", "onConfigurationChanged", "onCreateViewHolder", "Landroid/view/ViewGroup;", "onDetachedFromRecyclerView", "onDraw", "canvas", "Landroid/graphics/Canvas;", "childAt", "onDrawOver", "onItemMove", "end", "onReleaseDrag", "onStartDrag", "onSwiped", "direction", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class hax extends gzm implements gzn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final gzm f18717O000000o;

    public hax(gzm gzm) {
        ixe.O00000o(gzm, "delegate");
        this.f18717O000000o = gzm;
        this.f18717O000000o.O0000O0o = this;
    }

    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        RecyclerView.O000OOo0 onCreateViewHolder = this.f18717O000000o.onCreateViewHolder(viewGroup, i);
        ixe.O00000Oo(onCreateViewHolder, "delegate.onCreateViewHolder(parent, pos)");
        return onCreateViewHolder;
    }

    public int getItemCount() {
        return this.f18717O000000o.getItemCount();
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "vh");
        this.f18717O000000o.onBindViewHolder(o000OOo0, i);
    }

    public final void O000000o(Canvas canvas, RecyclerView recyclerView, View view, int i, RecyclerView.O000OO0o o000OO0o) {
        super.O000000o(canvas, recyclerView, view, i, o000OO0o);
        this.f18717O000000o.O000000o(canvas, recyclerView, view, i, o000OO0o);
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        ixe.O00000o(recyclerView, "parent");
        ixe.O00000o(o000OO0o, "state");
        super.O000000o(rect, view, i, recyclerView, o000OO0o);
        this.f18717O000000o.O000000o(rect, view, i, recyclerView, o000OO0o);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.f18717O000000o.onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.f18717O000000o.onDetachedFromRecyclerView(recyclerView);
    }

    public final int O000000o() {
        return this.f18717O000000o.O000000o();
    }

    public final boolean O000000o(int i, int i2) {
        return this.f18717O000000o.O000000o(i, i2);
    }

    public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
        return this.f18717O000000o.O000000o(recyclerView, o000OOo0);
    }

    public final void O000000o(gs gsVar) {
        ixe.O00000o(gsVar, "touchHelper");
        this.f18717O000000o.O000000o(gsVar);
    }

    public final void O0000OOo() {
        this.f18717O000000o.O0000OOo();
    }

    public final void O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, int i) {
        this.f18717O000000o.O000000o(recyclerView, o000OOo0, i);
    }

    public final boolean O00000oO(gzm gzm) {
        return j_();
    }

    public final void O000000o(gzm gzm, int i, int i2) {
        ixe.O00000o(gzm, "adapter");
        notifyItemRangeChanged(i, i2);
    }

    public final void O000000o(gzm gzm, int i, int i2, Object obj) {
        ixe.O00000o(gzm, "adapter");
        notifyItemRangeChanged(i, i2, obj);
    }

    public final void O00000Oo(gzm gzm, int i, int i2) {
        ixe.O00000o(gzm, "adapter");
        notifyItemRangeInserted(i, i2);
    }

    public final void O00000o0(gzm gzm, int i, int i2) {
        ixe.O00000o(gzm, "adapter");
        notifyItemRangeRemoved(i, i2);
    }

    public final void O00000o(gzm gzm, int i, int i2) {
        ixe.O00000o(gzm, "adapter");
        notifyItemMoved(i, i2);
    }

    public final void O00000o(gzm gzm) {
        ixe.O00000o(gzm, "adapter");
        notifyItemRangeChanged(0, this.f18717O000000o.getItemCount());
    }

    public final void O000000o(RecyclerView recyclerView) {
        this.f18717O000000o.O000000o(recyclerView);
    }
}
