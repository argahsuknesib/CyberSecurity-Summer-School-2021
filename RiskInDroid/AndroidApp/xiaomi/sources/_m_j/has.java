package _m_j;

import _m_j.has;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.HomeDefaultRoomDeviceTransferGuide;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J(\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016¨\u0006 "}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/AssignButtonAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "()V", "getItemCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onAnyEditModeChanged", "current", "", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "payloads", "", "", "onConfigurationChanged", "recyclerView", "onCreateViewHolder", "Landroid/view/ViewGroup;", "p1", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class has extends haz {
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
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_page_assgin_button_layout, viewGroup, false);
        ixe.O00000Oo(inflate, "item");
        return new O000000o(this, inflate);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "vh");
        ((O000000o) o000OOo0).O000000o();
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/AssignButtonAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/AssignButtonAdapter;Landroid/view/View;)V", "button", "Landroid/widget/TextView;", "getButton", "()Landroid/widget/TextView;", "editMask", "Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "getEditMask", "()Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "bind", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ has f18712O000000o;
        private final EditMaskView O00000Oo;
        private final TextView O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(has has, View view) {
            super(view);
            ixe.O00000o(has, "this$0");
            ixe.O00000o(view, "itemView");
            this.f18712O000000o = has;
            View findViewById = view.findViewById(R.id.edit_mask);
            ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.edit_mask)");
            this.O00000Oo = (EditMaskView) findViewById;
            View findViewById2 = view.findViewById(R.id.button);
            ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.button)");
            this.O00000o0 = (TextView) findViewById2;
        }

        public final void O000000o() {
            this.O00000o0.setText((int) R.string.assign_room);
            this.O00000Oo.setShouldMask(this.f18712O000000o.O00000o || this.f18712O000000o.O00000oO);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.$$Lambda$has$O000000o$C5iqY8xbeAlQnebhhCeI4LI_WRw */

                public final void onClick(View view) {
                    has.O000000o.O000000o(has.O000000o.this, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O000000o o000000o, View view) {
            ixe.O00000o(o000000o, "this$0");
            o000000o.O00000o0.setTypeface(Typeface.defaultFromStyle(1));
            HomeDefaultRoomDeviceTransferGuide.start(o000000o.itemView.getContext());
            hxk hxk = hxi.O00000o;
            long currentTimeMillis = System.currentTimeMillis();
            String O0000o0 = CoreApi.O000000o().O0000o0();
            hxk.f952O000000o.O000000o("noroom.room.setting", "time", Long.valueOf(currentTimeMillis), "uid", O0000o0);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(boolean z) {
        notifyItemChanged(0);
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        ixe.O00000o(recyclerView, "parent");
        int dimension = (int) view.getResources().getDimension(R.dimen.main_page_flex_padding);
        rect.top = gpc.O000000o(view.getContext(), 3.0f);
        rect.bottom = gpc.O000000o(view.getContext(), 13.0f);
        rect.left = gpc.O000000o(view.getContext(), 10.0f) + dimension;
        rect.right = gpc.O000000o(view.getContext(), 10.0f) + dimension;
    }

    public final void O000000o(RecyclerView recyclerView) {
        notifyItemChanged(0, "flex");
    }
}
