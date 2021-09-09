package _m_j;

import _m_j.gzq;
import _m_j.hha;
import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity;
import com.xiaomi.smarthome.newui.adapter.FavoriteSceneAddButtonAdapter$onBindViewHolder$1$1;
import com.xiaomi.smarthome.newui.adapter.FavoriteSceneAddButtonAdapter$onBindViewHolder$1$2;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J(\u0010\u001c\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00042\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteSceneAddButtonAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "()V", "columnFlex", "", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "isSceneEditMode", "", "offsetVertical", "getOffsetVertical", "()I", "sceneCardSize", "getColumn", "getItemCount", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "holder", "payloads", "", "", "onConfigurationChanged", "onCreateViewHolder", "conatiner", "Landroid/view/ViewGroup;", "p1", "onDetachedFromRecyclerView", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbd extends gzm {

    /* renamed from: O000000o  reason: collision with root package name */
    private final CompositeDisposable f18735O000000o = new CompositeDisposable();
    private boolean O00000Oo;
    private int O00000o;
    private int O00000o0;

    public hbd() {
        hha.O000000o o000000o = hha.f18928O000000o;
        this.O00000o = hha.O000000o.O000000o().f18929O000000o;
    }

    public final int O000000o() {
        return this.O00000o;
    }

    public final int getItemCount() {
        return this.O00000Oo ? 1 : 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "conatiner");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_auto_scene_item_add, viewGroup, false);
        ixe.O00000Oo(inflate, "from(conatiner.context).inflate(R.layout.main_auto_scene_item_add, conatiner, false)");
        return new O000000o(this, inflate);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "vh");
        o000OOo0.itemView.setOnClickListener($$Lambda$hbd$pPtZ5CcpPwuSDcAWDTUb0pE_MU.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view) {
        ixe.O00000Oo(view, "it");
        hak.O000000o(view, FavoriteSceneAddButtonAdapter$onBindViewHolder$1$1.f10171O000000o);
        view.getContext().startActivity(new Intent(view.getContext(), AddFavoriteAutoSceneActivity.class));
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzw.O000000o(gzq.O00000oO, FavoriteSceneAddButtonAdapter$onBindViewHolder$1$2.f10172O000000o);
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

    public final void O000000o(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        hha.O000000o o000000o = hha.f18928O000000o;
        this.O00000o = hha.O000000o.O000000o().f18929O000000o;
        notifyItemChanged(0, "flex");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteSceneAddButtonAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/FavoriteSceneAddButtonAdapter;Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hbd f18736O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(hbd hbd, View view) {
            super(view);
            ixe.O00000o(hbd, "this$0");
            ixe.O00000o(view, "itemView");
            this.f18736O000000o = hbd;
        }
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        CompositeDisposable compositeDisposable = this.f18735O000000o;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        compositeDisposable.addAll(gzq.O00000oO.map($$Lambda$hbd$WXyi5w969gFUvDF1GJ0B9qt2qdM.INSTANCE).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$hbd$kcq4gSgXB_eu7O7ouN2IldXr_Kw */

            public final void accept(Object obj) {
                hbd.O000000o(hbd.this, (Pair) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public static final Pair O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return iuf.O000000o(Boolean.valueOf(intent.getBooleanExtra("main_extra_scene_edit_mode_is_edit_mode", false)), Integer.valueOf(intent.getIntExtra("main_extra_scene_edit_mode_scene_count", 0)));
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.f18735O000000o.clear();
    }

    private static int O00000Oo() {
        return gpc.O000000o(CommonApplication.getAppContext(), 26.0f);
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        ixe.O00000o(recyclerView, "parent");
        ixe.O00000o(o000OO0o, "state");
        boolean z = true;
        boolean z2 = this.O00000o0 % this.O00000o == 0;
        if (this.O00000o0 > 2) {
            z = false;
        }
        if (!z) {
            if (!z2) {
                rect.top = O00000Oo();
            }
            rect.bottom = O00000Oo();
            return;
        }
        rect.top = O00000Oo();
        rect.bottom = O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hbd hbd, Pair pair) {
        ixe.O00000o(hbd, "this$0");
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        hbd.O00000o0 = ((Number) pair.second).intValue();
        hbd.O00000Oo = booleanValue;
        if (hbd.O00000Oo) {
            hbd.notifyItemInserted(0);
        } else {
            hbd.notifyItemRemoved(0);
        }
    }
}
