package _m_j;

import _m_j.hha;
import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.homeroom.AddFavoriteDeviceActivity;
import com.xiaomi.smarthome.newui.adapter.FavoriteDeviceAddButtonAdapter$onBindViewHolder$1$1;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J(\u0010\u0017\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteDeviceAddButtonAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "()V", "commonDeviceSize", "", "getCommonDeviceSize", "()I", "setCommonDeviceSize", "(I)V", "deviceColumns", "getColumn", "getItemCount", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "holder", "payloads", "", "", "onCardEditModeChanged", "current", "", "onConfigurationChanged", "recyclerView", "onCreateViewHolder", "conatiner", "Landroid/view/ViewGroup;", "p1", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbc extends haz {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18733O000000o;
    private int O00000Oo = hha.O000000o.O000000o().O00000Oo;

    public hbc() {
        hha.O000000o o000000o = hha.f18928O000000o;
    }

    public final int O000000o() {
        return this.O00000Oo;
    }

    public final int getItemCount() {
        return this.O00000oO ? 1 : 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "conatiner");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_device_card_add_fav_item, viewGroup, false);
        ixe.O00000Oo(inflate, "from(conatiner.context).inflate(R.layout.main_device_card_add_fav_item, conatiner, false)");
        return new O000000o(this, inflate);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "vh");
        hxi.O00000o.O000000o(1, 0);
        o000OOo0.itemView.setOnClickListener($$Lambda$hbc$pLCwj_0unrALTEcn2mcPfVzYbz4.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view) {
        ixe.O00000Oo(view, "it");
        hak.O000000o(view, FavoriteDeviceAddButtonAdapter$onBindViewHolder$1$1.f10170O000000o);
        view.getContext().startActivity(new Intent(view.getContext(), AddFavoriteDeviceActivity.class));
        hxi.O00000o.O000000o(0, 1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Object, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List<Object> list) {
        ixe.O00000o(o000OOo0, "holder");
        ixe.O00000o(list, "payloads");
        if (!(!list.isEmpty()) || !ixe.O000000o(list.get(0), (Object) "flex")) {
            super.onBindViewHolder(o000OOo0, i, list);
        } else {
            o000OOo0.itemView.requestLayout();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteDeviceAddButtonAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/FavoriteDeviceAddButtonAdapter;Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hbc f18734O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(hbc hbc, View view) {
            super(view);
            ixe.O00000o(hbc, "this$0");
            ixe.O00000o(view, "itemView");
            this.f18734O000000o = hbc;
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(boolean z) {
        super.O000000o(z);
        if (this.O00000oO) {
            notifyItemInserted(0);
        } else {
            notifyItemRemoved(0);
        }
    }

    public final void O000000o(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        hha.O000000o o000000o = hha.f18928O000000o;
        this.O00000Oo = hha.O000000o.O000000o().O00000Oo;
        notifyItemChanged(0, "flex");
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        ixe.O00000o(recyclerView, "parent");
        ixe.O00000o(o000OO0o, "state");
        int dimension = (int) view.getResources().getDimension(R.dimen.main_page_flex_padding);
        int i2 = this.f18733O000000o;
        int i3 = this.O00000Oo;
        int i4 = i2 % i3;
        if (i4 == 0) {
            rect.left = gpc.O00000o0(view.getContext(), 5.0f) + dimension;
        } else if (i4 == i3 - 1) {
            rect.right = gpc.O00000o0(view.getContext(), 5.0f) + dimension;
        }
    }
}
