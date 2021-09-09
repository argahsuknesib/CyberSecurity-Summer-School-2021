package _m_j;

import _m_j.hha;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.adapter.FavoriteSceneWrapperAdapter$VH$1$1;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0006H\u0014J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0014\u0010\u001f\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0!R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteSceneWrapperAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/CardPathDrawableDefaultOffsetAdapter;", "()V", "columnFlex", "", "isNewInsert", "", "renderData", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "Lkotlin/collections/ArrayList;", "getItemCount", "isVisibleToUser", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p1", "holder", "position", "payloads", "", "", "onCardEditModeChanged", "current", "onConfigurationChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "render", "scenes", "", "Companion", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbf extends haw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18737O000000o = new O000000o((byte) 0);
    public final ArrayList<CommonUsedScene> O00000Oo = new ArrayList<>();
    private int O0000Oo;
    public boolean O0000Oo0 = true;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteSceneWrapperAdapter$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public hbf() {
        hha.O000000o o000000o = hha.f18928O000000o;
        this.O0000Oo = hha.O000000o.O000000o().f18929O000000o;
    }

    public final void O000000o(List<? extends CommonUsedScene> list) {
        ixe.O00000o(list, "scenes");
        if (this.O00000Oo.isEmpty()) {
            Collection collection = list;
            if (!collection.isEmpty()) {
                this.O00000Oo.clear();
                this.O00000Oo.addAll(collection);
                this.O0000Oo0 = true;
                notifyItemInserted(0);
                return;
            }
        }
        if ((!this.O00000Oo.isEmpty()) && list.isEmpty()) {
            this.O00000Oo.clear();
            this.O0000Oo0 = false;
            notifyItemRemoved(0);
        } else if (!ixe.O000000o(this.O00000Oo, list)) {
            this.O00000Oo.clear();
            this.O00000Oo.addAll(list);
            this.O0000Oo0 = false;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_auto_scene_item_recycler_wrapper, viewGroup, false);
        ixe.O00000Oo(inflate, "item");
        return new O00000Oo(this, inflate);
    }

    public final int getItemCount() {
        return this.O00000Oo.isEmpty() ^ true ? 1 : 0;
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "vh");
        ((O00000Oo) o000OOo0).O000000o();
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
        hha.O000000o o000000o = hha.f18928O000000o;
        int i2 = hha.O000000o.O000000o().f18929O000000o;
        if ((this.O0000Oo != i2) || ((!list.isEmpty()) && ixe.O000000o(list.get(0), (Object) "flex"))) {
            this.O0000Oo = i2;
            o000OOo0.itemView.requestLayout();
            RecyclerView recyclerView = ((O00000Oo) o000OOo0).f18738O000000o;
            RecyclerView.O000000o adapter = recyclerView.getAdapter();
            gzl gzl = adapter instanceof gzl ? (gzl) adapter : null;
            if (gzl != null) {
                gzl.O000000o(recyclerView);
                return;
            }
            return;
        }
        super.onBindViewHolder(o000OOo0, i, list);
    }

    public final void O000000o(RecyclerView recyclerView) {
        notifyItemChanged(0, "flex");
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteSceneWrapperAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/FavoriteSceneWrapperAdapter;Landroid/view/View;)V", "editMaskView", "Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "kotlin.jvm.PlatformType", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "bind", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final RecyclerView f18738O000000o = ((RecyclerView) this.itemView.findViewById(R.id.recycler));
        final /* synthetic */ hbf O00000Oo;
        private final EditMaskView O00000o0 = ((EditMaskView) this.itemView.findViewById(R.id.edit_mask));

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000Oo(hbf hbf, View view) {
            super(view);
            ixe.O00000o(hbf, "this$0");
            ixe.O00000o(view, "item");
            this.O00000Oo = hbf;
            RecyclerView recyclerView = this.f18738O000000o;
            recyclerView.setHasFixedSize(false);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new FavoriteSceneWrapperAdapter$VH$1$1(recyclerView.getContext()));
            go goVar = new go();
            goVar.O0000o00 = false;
            iuh iuh = iuh.f1631O000000o;
            recyclerView.setItemAnimator(goVar);
            gzl gzl = new gzl();
            gzl.O000000o(new hbm());
            gzl.O000000o(new hbd());
            recyclerView.setAdapter(gzl);
        }

        /* JADX WARN: Type inference failed for: r0v11, types: [_m_j.gzm] */
        /* JADX WARNING: Multi-variable type inference failed */
        public final void O000000o() {
            this.O00000o0.setShouldMask(this.O00000Oo.O00000oO || this.O00000Oo.O00000oo);
            RecyclerView.O000000o adapter = this.f18738O000000o.getAdapter();
            hbm hbm = null;
            gzl gzl = adapter instanceof gzl ? (gzl) adapter : null;
            if (gzl != null) {
                hbm = gzl.O000000o(hbm.class);
            }
            if (hbm != null) {
                hbm.O000000o(this.O00000Oo.O00000Oo);
            }
            if (this.O00000Oo.O0000Oo0) {
                RecyclerView recyclerView = this.f18738O000000o;
                ixe.O00000Oo(recyclerView, "recyclerView");
                hbe.O000000o(recyclerView, 20);
                this.O00000Oo.O0000Oo0 = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(boolean z) {
        super.O000000o(z);
        if (l_()) {
            notifyItemChanged(0);
        }
    }

    public final boolean l_() {
        return !this.O00000Oo.isEmpty();
    }
}
