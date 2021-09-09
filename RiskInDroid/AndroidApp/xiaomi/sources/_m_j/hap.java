package _m_j;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.homeroom.AddFavoriteDeviceActivity;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J(\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/AddCommonDeviceCardAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/CardPathDrawableDefaultOffsetAdapter;", "()V", "getItemCount", "", "onAnyEditModeChanged", "", "current", "", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "payloads", "", "", "onConfigurationChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "ViewHolder", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hap extends haw {
    public final int getItemCount() {
        return 1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.device_list_empty_add_device_layout, viewGroup, false);
        ixe.O00000Oo(inflate, "item");
        return new O000000o(this, inflate);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "holder");
        ((EditMaskView) o000OOo0.itemView.findViewById(R.id.edit_mask)).setShouldMask(this.O00000oO || this.O00000o);
        o000OOo0.itemView.findViewById(R.id.add_device_button).setOnClickListener($$Lambda$hap$97Ow1yU__YR6PtzfyriPLqlBFPk.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), AddFavoriteDeviceActivity.class));
        hxi.O00000o.f952O000000o.O000000o("home_add_device", new Object[0]);
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/AddCommonDeviceCardAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/AddCommonDeviceCardAdapter;Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hap f18711O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(hap hap, View view) {
            super(view);
            ixe.O00000o(hap, "this$0");
            ixe.O00000o(view, "itemView");
            this.f18711O000000o = hap;
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(boolean z) {
        super.O00000Oo(z);
        notifyItemChanged(0);
    }

    public final void O000000o(RecyclerView recyclerView) {
        notifyItemChanged(0, "flex");
    }
}
