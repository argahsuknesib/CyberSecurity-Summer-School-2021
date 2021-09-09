package _m_j;

import _m_j.hjm;
import _m_j.hlr;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.newui.adapter.DeviceMainAdAdapter$ViewHolder$1$1;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import com.xiaomi.smarthome.operation.OperationAdManager$Companion$getProviderForMain$1;
import com.xiaomi.smarthome.operation.view.OperationImageView;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0006H\u0014J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\rH\u0016J(\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\r2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!H\u0016J\u0012\u0010#\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020%2\u0006\u0010&\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0006\u0010(\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "()V", "flexSpanSize", "Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$SpanSize;", "isCacheValid", "", "operationProvider", "Lcom/xiaomi/smarthome/operation/provider/IOperationProvider;", "", "Lcom/xiaomi/smarthome/operation/beans/common/CommonAdOperation;", "calcSpanSize", "getItemCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onAnyEditModeChanged", "current", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "payloads", "", "", "onConfigurationChanged", "onCreateViewHolder", "Landroid/view/ViewGroup;", "p1", "onDetachedFromRecyclerView", "refresh", "SpanSize", "ViewHolder", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hay extends haz {

    /* renamed from: O000000o  reason: collision with root package name */
    public final hlr<List<hjr>> f18718O000000o;
    public O000000o O00000Oo;
    private boolean O0000Oo0;

    public hay() {
        hlr<List<hjr>> hlr;
        hjm.O000000o o000000o = hjm.f18999O000000o;
        if (!ftn.O00000oo(ServiceApplication.getAppContext())) {
            hlr = new hls<>();
        } else {
            hlr = new hlu("17,19", ivb.O000000o(iuf.O000000o("type", OperationAdManager$Companion$getProviderForMain$1.f10505O000000o)));
        }
        this.f18718O000000o = hlr;
        this.O0000Oo0 = this.f18718O000000o.O000000o() && this.f18718O000000o.O00000o0();
        this.O00000Oo = O00000Oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_ad_adapter_wrapper, viewGroup, false);
        ixe.O00000Oo(inflate, "item");
        return new O00000Oo(this, inflate);
    }

    public final int getItemCount() {
        return this.O0000Oo0 ? 1 : 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        Object obj;
        ixe.O00000o(o000OOo0, "holder");
        List O00000Oo2 = this.f18718O000000o.O00000Oo();
        if (O00000Oo2 != null) {
            Iterable iterable = O00000Oo2;
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (ixe.O000000o((Object) ((hjr) obj).f19001O000000o, (Object) "17")) {
                    break;
                }
            }
            hjr hjr = (hjr) obj;
            if (hjr != null) {
                Collection arrayList = new ArrayList();
                for (Object next : iterable) {
                    if (ixe.O000000o((Object) ((hjr) next).f19001O000000o, (Object) "19")) {
                        arrayList.add(next);
                    }
                }
                ((O00000Oo) o000OOo0).O000000o(hjr, (List) arrayList);
            }
        }
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
            return;
        }
        O00000Oo o00000Oo = (O00000Oo) o000OOo0;
        RecyclerView.O000000o adapter = o00000Oo.f18720O000000o.getAdapter();
        gzl gzl = adapter instanceof gzl ? (gzl) adapter : null;
        if (gzl != null) {
            gzl.O000000o(o00000Oo.f18720O000000o);
        }
    }

    public final void O000000o(RecyclerView recyclerView) {
        this.O00000Oo = O00000Oo();
        notifyItemChanged(0, "flex");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$SpanSize;", "", "big", "", "small", "offset", "(III)V", "getBig", "()I", "getOffset", "getSmall", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f18719O000000o;
        final int O00000Oo;
        final int O00000o0;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            return this.f18719O000000o == o000000o.f18719O000000o && this.O00000Oo == o000000o.O00000Oo && this.O00000o0 == o000000o.O00000o0;
        }

        public final int hashCode() {
            return (((Integer.valueOf(this.f18719O000000o).hashCode() * 31) + Integer.valueOf(this.O00000Oo).hashCode()) * 31) + Integer.valueOf(this.O00000o0).hashCode();
        }

        public final String toString() {
            return "SpanSize(big=" + this.f18719O000000o + ", small=" + this.O00000Oo + ", offset=" + this.O00000o0 + ')';
        }

        public O000000o(int i, int i2, int i3) {
            this.f18719O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
        }
    }

    private static O000000o O00000Oo() {
        Context appContext = CommonApplication.getAppContext();
        double O00000o0 = (double) ((10 / ((gpc.O000000o(appContext).x - gpc.O00000o0(appContext, 10.0f)) + ((int) appContext.getResources().getDimension(R.dimen.main_page_flex_padding)))) * 100);
        Double.isNaN(O00000o0);
        int O000000o2 = ixm.O000000o(O00000o0 + 0.5d);
        if (hyy.O000000o()) {
            int i = O000000o2 * 2;
            double d = (double) (100 - i);
            Double.isNaN(d);
            int O000000o3 = ixm.O000000o(((d / 4.87d) * 1.435d) + 0.5d);
            return new O000000o((100 - (O000000o3 * 2)) - i, O000000o3, O000000o2);
        }
        int i2 = (100 - O000000o2) / 2;
        return new O000000o(100, i2, 100 - (i2 * 2));
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        hlr.O000000o.O000000o(this.f18718O000000o, new Consumer() {
            /* class _m_j.$$Lambda$hay$QS2Aswg41zCjYVg1u7ArrQMsYxE */

            public final void accept(Object obj) {
                hay.O000000o(hay.this, (List) obj);
            }
        }, 2);
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.f18718O000000o.O00000oO();
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(boolean z) {
        super.O00000Oo(z);
        notifyItemChanged(0);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hay hay, List list) {
        ixe.O00000o(hay, "this$0");
        ixe.O00000Oo(list, "it");
        if (!list.isEmpty()) {
            hay.notifyItemChanged(0);
        }
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        ixe.O00000o(recyclerView, "parent");
        ixe.O00000o(o000OO0o, "state");
        if (j_()) {
            rect.top = gpc.O00000o0(view.getContext(), 10.0f);
        } else {
            rect.top = gpc.O00000o0(view.getContext(), 3.0f);
        }
        int dimension = (int) view.getResources().getDimension(R.dimen.main_page_flex_padding);
        rect.left = gpc.O00000o0(view.getContext(), 10.0f) + dimension;
        rect.right = gpc.O00000o0(view.getContext(), 10.0f) + dimension;
        rect.bottom = gpc.O00000o0(view.getContext(), 10.0f);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter;Landroid/view/View;)V", "editMaskView", "Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "kotlin.jvm.PlatformType", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onConfigurationChange", "", "update", "big", "Lcom/xiaomi/smarthome/operation/beans/common/CommonAdOperation;", "smalls", "", "EmptySpanAdapter", "LargeAdAdapter", "SmallAdAdapter", "TitleAdapter", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final RecyclerView f18720O000000o;
        final /* synthetic */ hay O00000Oo;
        private final EditMaskView O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000Oo(hay hay, View view) {
            super(view);
            ixe.O00000o(hay, "this$0");
            ixe.O00000o(view, "itemView");
            this.O00000Oo = hay;
            this.O00000o0 = (EditMaskView) view.findViewById(R.id.edit_mask);
            this.f18720O000000o = (RecyclerView) view.findViewById(R.id.recycler);
            RecyclerView recyclerView = this.f18720O000000o;
            recyclerView.setHasFixedSize(false);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new DeviceMainAdAdapter$ViewHolder$1$1(recyclerView.getContext()));
            go goVar = new go();
            goVar.O0000o00 = false;
            iuh iuh = iuh.f1631O000000o;
            recyclerView.setItemAnimator(goVar);
            O000000o o000000o = new O000000o();
            o000000o.O000000o(new O00000o0(this));
            o000000o.O000000o(new O0000O0o(this));
            o000000o.O000000o(new C0112O00000Oo(this, false));
            O00000o o00000o = new O00000o(this, true);
            o00000o.O0000OOo = "left";
            iuh iuh2 = iuh.f1631O000000o;
            o000000o.O000000o(o00000o);
            o000000o.O000000o(new C0112O00000Oo(this, true));
            O00000o o00000o2 = new O00000o(this, false);
            o00000o2.O0000OOo = "right";
            iuh iuh3 = iuh.f1631O000000o;
            o000000o.O000000o(o00000o2);
            recyclerView.setAdapter(o000000o);
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$1$delegateAdapter$1", "Lcom/xiaomi/smarthome/multi_item/DelegateAdapter;", "getSpanCount", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o extends gzl {
            public final int O000000o() {
                return 100;
            }

            O000000o() {
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.iuy.O000000o(java.util.List, int):T
         arg types: [java.util.List<? extends _m_j.hjr>, int]
         candidates:
          _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
          _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
          _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
          _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
          _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
          _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
          _m_j.iur.O000000o(java.lang.Iterable, int):int
          _m_j.iuy.O000000o(java.util.List, int):T */
        public final void O000000o(hjr hjr, List<? extends hjr> list) {
            ixe.O00000o(hjr, "big");
            ixe.O00000o(list, "smalls");
            this.O00000o0.setShouldMask(this.O00000Oo.O00000oO || this.O00000Oo.O00000o);
            RecyclerView.O000000o adapter = this.f18720O000000o.getAdapter();
            gzl gzl = adapter instanceof gzl ? (gzl) adapter : null;
            if (gzl != null) {
                O00000o0 o00000o0 = (O00000o0) gzl.O000000o(O00000o0.class);
                O00000o o00000o = (O00000o) gzl.O000000o("left");
                O00000o o00000o2 = (O00000o) gzl.O000000o("right");
                if (o00000o0 != null) {
                    ixe.O00000o(hjr, "data");
                    if (!ixe.O000000o(hjr, o00000o0.f18726O000000o)) {
                        o00000o0.f18726O000000o = hjr;
                        o00000o0.notifyDataSetChanged();
                    }
                }
                if (o00000o != null) {
                    o00000o.O000000o((hjr) iuo.O000000o((List) list, 0));
                }
                if (o00000o2 != null) {
                    o00000o2.O000000o((hjr) iuo.O000000o((List) list, 1));
                }
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$LargeAdAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder;)V", "isPad", "", "renderData", "Lcom/xiaomi/smarthome/operation/beans/common/CommonAdOperation;", "getItemCount", "", "getSpanSize", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onConfigurationChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "render", "data", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O00000o0 extends gzm {

            /* renamed from: O000000o  reason: collision with root package name */
            hjr f18726O000000o;
            final /* synthetic */ O00000Oo O00000Oo;
            private boolean O00000o0 = hyy.O000000o();

            public O00000o0(O00000Oo o00000Oo) {
                ixe.O00000o(o00000Oo, "this$0");
                this.O00000Oo = o00000Oo;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                ixe.O00000o(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_ad_adapter_big_item, viewGroup, false);
                ixe.O00000Oo(inflate, "item");
                return new O000000o(this, inflate);
            }

            public final int k_() {
                return this.O00000Oo.O00000Oo.O00000Oo.f18719O000000o;
            }

            public final int getItemCount() {
                return this.f18726O000000o == null ? 0 : 1;
            }

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ixe.O00000o(o000OOo0, "vh");
                O000000o o000000o = (O000000o) o000OOo0;
                hjr hjr = this.f18726O000000o;
                if (hjr != null) {
                    o000000o.O000000o(hjr);
                }
            }

            public final void O000000o(RecyclerView recyclerView) {
                this.O00000o0 = hyy.O000000o();
                notifyDataSetChanged();
            }

            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$LargeAdAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$LargeAdAdapter;Landroid/view/View;)V", "operationIv", "Lcom/xiaomi/smarthome/operation/view/OperationImageView;", "kotlin.jvm.PlatformType", "bind", "", "operation", "Lcom/xiaomi/smarthome/operation/beans/common/CommonAdOperation;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            final class O000000o extends RecyclerView.O000OOo0 {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000o0 f18727O000000o;
                private final OperationImageView O00000Oo;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public O000000o(O00000o0 o00000o0, View view) {
                    super(view);
                    ixe.O00000o(o00000o0, "this$0");
                    ixe.O00000o(view, "itemView");
                    this.f18727O000000o = o00000o0;
                    this.O00000Oo = (OperationImageView) view.findViewById(R.id.operation);
                }

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$LargeAdAdapter$VH$bind$1", "Lcom/xiaomi/smarthome/operation/view/OperationImageView$IOnVisible;", "onVisible", "", "view", "Landroid/view/View;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                /* renamed from: _m_j.hay$O00000Oo$O00000o0$O000000o$O000000o  reason: collision with other inner class name */
                public static final class C0114O000000o implements OperationImageView.O000000o {

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ hjr f18728O000000o;

                    C0114O000000o(hjr hjr) {
                        this.f18728O000000o = hjr;
                    }

                    public final void onVisible(View view) {
                        ixe.O00000o(view, "view");
                        hxi.O00000oO.O000000o(this.f18728O000000o.O00000o);
                        hxm hxm = hxi.O0000o00;
                        String str = this.f18728O000000o.O00000o;
                        String str2 = this.f18728O000000o.O0000o0O;
                        String str3 = this.f18728O000000o.O00000o0;
                        String str4 = this.f18728O000000o.O0000o0o;
                        hxm.f954O000000o.O000000o("home_nodevice_top_ad_expose", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4);
                    }
                }

                public final void O000000o(hjr hjr) {
                    ixe.O00000o(hjr, "operation");
                    hlr<List<hjr>> hlr = this.f18727O000000o.O00000Oo.O00000Oo.f18718O000000o;
                    String str = hjr.O00000Oo;
                    ixe.O00000Oo(str, "operation.imgUrl");
                    OperationImageView operationImageView = this.O00000Oo;
                    ixe.O00000Oo(operationImageView, "operationIv");
                    hlr.O000000o(str, operationImageView);
                    this.O00000Oo.registerOnVisibleToUser(new C0114O000000o(hjr));
                    this.O00000Oo.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: INVOKE  
                          (wrap: com.xiaomi.smarthome.operation.view.OperationImageView : 0x002c: IGET  (r0v6 com.xiaomi.smarthome.operation.view.OperationImageView) = (r4v0 'this' _m_j.hay$O00000Oo$O00000o0$O000000o A[THIS]) _m_j.hay.O00000Oo.O00000o0.O000000o.O00000Oo com.xiaomi.smarthome.operation.view.OperationImageView)
                          (wrap: _m_j.-$$Lambda$hay$O00000Oo$O00000o0$O000000o$istSBUNxJQdTxNZHcLPM8fZSUew : 0x0030: CONSTRUCTOR  (r1v3 _m_j.-$$Lambda$hay$O00000Oo$O00000o0$O000000o$istSBUNxJQdTxNZHcLPM8fZSUew) = (r5v0 'hjr' _m_j.hjr) call: _m_j.-$$Lambda$hay$O00000Oo$O00000o0$O000000o$istSBUNxJQdTxNZHcLPM8fZSUew.<init>(_m_j.hjr):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.xiaomi.smarthome.operation.view.OperationImageView.setOnClickListener(android.view.View$OnClickListener):void in method: _m_j.hay.O00000Oo.O00000o0.O000000o.O000000o(_m_j.hjr):void, dex: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0030: CONSTRUCTOR  (r1v3 _m_j.-$$Lambda$hay$O00000Oo$O00000o0$O000000o$istSBUNxJQdTxNZHcLPM8fZSUew) = (r5v0 'hjr' _m_j.hjr) call: _m_j.-$$Lambda$hay$O00000Oo$O00000o0$O000000o$istSBUNxJQdTxNZHcLPM8fZSUew.<init>(_m_j.hjr):void type: CONSTRUCTOR in method: _m_j.hay.O00000Oo.O00000o0.O000000o.O000000o(_m_j.hjr):void, dex: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 79 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$hay$O00000Oo$O00000o0$O000000o$istSBUNxJQdTxNZHcLPM8fZSUew, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 85 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "operation"
                        _m_j.ixe.O00000o(r5, r0)
                        _m_j.hay$O00000Oo$O00000o0 r0 = r4.f18727O000000o
                        _m_j.hay$O00000Oo r0 = r0.O00000Oo
                        _m_j.hay r0 = r0.O00000Oo
                        _m_j.hlr<java.util.List<_m_j.hjr>> r0 = r0.f18718O000000o
                        java.lang.String r1 = r5.O00000Oo
                        java.lang.String r2 = "operation.imgUrl"
                        _m_j.ixe.O00000Oo(r1, r2)
                        com.xiaomi.smarthome.operation.view.OperationImageView r2 = r4.O00000Oo
                        java.lang.String r3 = "operationIv"
                        _m_j.ixe.O00000Oo(r2, r3)
                        com.facebook.drawee.view.SimpleDraweeView r2 = (com.facebook.drawee.view.SimpleDraweeView) r2
                        r0.O000000o(r1, r2)
                        com.xiaomi.smarthome.operation.view.OperationImageView r0 = r4.O00000Oo
                        _m_j.hay$O00000Oo$O00000o0$O000000o$O000000o r1 = new _m_j.hay$O00000Oo$O00000o0$O000000o$O000000o
                        r1.<init>(r5)
                        com.xiaomi.smarthome.operation.view.OperationImageView$O000000o r1 = (com.xiaomi.smarthome.operation.view.OperationImageView.O000000o) r1
                        r0.registerOnVisibleToUser(r1)
                        com.xiaomi.smarthome.operation.view.OperationImageView r0 = r4.O00000Oo
                        _m_j.-$$Lambda$hay$O00000Oo$O00000o0$O000000o$istSBUNxJQdTxNZHcLPM8fZSUew r1 = new _m_j.-$$Lambda$hay$O00000Oo$O00000o0$O000000o$istSBUNxJQdTxNZHcLPM8fZSUew
                        r1.<init>(r5)
                        r0.setOnClickListener(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: _m_j.hay.O00000Oo.O00000o0.O000000o.O000000o(_m_j.hjr):void");
                }

                /* access modifiers changed from: private */
                public static final void O000000o(hjr hjr, View view) {
                    ixe.O00000o(hjr, "$operation");
                    hjo.O000000o(hjr);
                    hxi.O00000o.O00000oo(hjr.O00000o);
                    hxk hxk = hxi.O00000o;
                    String str = hjr.O00000o;
                    String str2 = hjr.O0000o0O;
                    String str3 = hjr.O00000o0;
                    String str4 = hjr.O0000o0o;
                    hxk.f952O000000o.O000000o("home_nodevice_top_ad_click", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4);
                }
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$TitleAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder;)V", "isPad", "", "getItemCount", "", "onBindViewHolder", "", "p0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p1", "onConfigurationChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O0000O0o extends gzm {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000Oo f18729O000000o;
            private boolean O00000Oo = hyy.O000000o();

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ixe.O00000o(o000OOo0, "p0");
            }

            public O0000O0o(O00000Oo o00000Oo) {
                ixe.O00000o(o00000Oo, "this$0");
                this.f18729O000000o = o00000Oo;
            }

            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                ixe.O00000o(viewGroup, "parent");
                TextView textView = new TextView(viewGroup.getContext());
                textView.setLayoutParams(new RecyclerView.LayoutParams(-1, gpc.O000000o(viewGroup.getContext(), 42.0f)));
                textView.setTextSize(13.0f);
                textView.setText((int) R.string.ad_banner_life_tips_title);
                textView.setPadding(gpc.O000000o(viewGroup.getContext(), 19.0f), 0, 0, 0);
                textView.setTextAlignment(5);
                textView.setGravity(8388627);
                textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.mj_color_black));
                return new O000000o(this, textView);
            }

            public final int getItemCount() {
                return this.O00000Oo ? 0 : 1;
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$TitleAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$TitleAdapter;Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            final class O000000o extends RecyclerView.O000OOo0 {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O0000O0o f18730O000000o;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public O000000o(O0000O0o o0000O0o, View view) {
                    super(view);
                    ixe.O00000o(o0000O0o, "this$0");
                    ixe.O00000o(view, "itemView");
                    this.f18730O000000o = o0000O0o;
                }
            }

            public final void O000000o(RecyclerView recyclerView) {
                this.O00000Oo = hyy.O000000o();
                notifyDataSetChanged();
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$EmptySpanAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "smallCenter", "", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder;Z)V", "isPad", "getSmallCenter", "()Z", "getItemCount", "", "getSpanSize", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onConfigurationChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: _m_j.hay$O00000Oo$O00000Oo  reason: collision with other inner class name */
        final class C0112O00000Oo extends gzm {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000Oo f18721O000000o;
            private final boolean O00000Oo;
            private boolean O00000o0 = hyy.O000000o();

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ixe.O00000o(o000OOo0, "vh");
            }

            public C0112O00000Oo(O00000Oo o00000Oo, boolean z) {
                ixe.O00000o(o00000Oo, "this$0");
                this.f18721O000000o = o00000Oo;
                this.O00000Oo = z;
            }

            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                ixe.O00000o(viewGroup, "parent");
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                return new O000000o(this, view);
            }

            public final int getItemCount() {
                if (!this.O00000Oo && !this.O00000o0) {
                    return 0;
                }
                return 1;
            }

            public final int k_() {
                return this.f18721O000000o.O00000Oo.O00000Oo.O00000o0;
            }

            public final void O000000o(RecyclerView recyclerView) {
                this.O00000o0 = hyy.O000000o();
                notifyDataSetChanged();
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$EmptySpanAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$EmptySpanAdapter;Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: _m_j.hay$O00000Oo$O00000Oo$O000000o */
            final class O000000o extends RecyclerView.O000OOo0 {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ C0112O00000Oo f18722O000000o;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public O000000o(C0112O00000Oo o00000Oo, View view) {
                    super(view);
                    ixe.O00000o(o00000Oo, "this$0");
                    ixe.O00000o(view, "itemView");
                    this.f18722O000000o = o00000Oo;
                }
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$SmallAdAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "isLeft", "", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder;Z)V", "()Z", "isPad", "renderData", "Lcom/xiaomi/smarthome/operation/beans/common/CommonAdOperation;", "getItemCount", "", "getSpanSize", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onConfigurationChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "render", "data", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O00000o extends gzm {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000Oo f18723O000000o;
            private final boolean O00000Oo;
            private boolean O00000o = hyy.O000000o();
            private hjr O00000o0;

            public O00000o(O00000Oo o00000Oo, boolean z) {
                ixe.O00000o(o00000Oo, "this$0");
                this.f18723O000000o = o00000Oo;
                this.O00000Oo = z;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                ixe.O00000o(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_ad_adapter_small_item, viewGroup, false);
                ixe.O00000Oo(inflate, "item");
                return new O000000o(this, inflate);
            }

            public final int getItemCount() {
                return this.O00000o0 == null ? 0 : 1;
            }

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ixe.O00000o(o000OOo0, "vh");
                O000000o o000000o = (O000000o) o000OOo0;
                hjr hjr = this.O00000o0;
                if (hjr != null) {
                    o000000o.O000000o(hjr, this.O00000Oo);
                }
            }

            public final int k_() {
                return this.f18723O000000o.O00000Oo.O00000Oo.O00000Oo;
            }

            public final void O000000o(RecyclerView recyclerView) {
                this.O00000o = hyy.O000000o();
                notifyDataSetChanged();
            }

            public final void O000000o(hjr hjr) {
                if (!ixe.O000000o(hjr, this.O00000o0)) {
                    this.O00000o0 = hjr;
                    notifyDataSetChanged();
                }
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$SmallAdAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$SmallAdAdapter;Landroid/view/View;)V", "operationIv", "Lcom/xiaomi/smarthome/operation/view/OperationImageView;", "kotlin.jvm.PlatformType", "bind", "", "operation", "Lcom/xiaomi/smarthome/operation/beans/common/CommonAdOperation;", "isLeft", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            final class O000000o extends RecyclerView.O000OOo0 {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000o f18724O000000o;
                private final OperationImageView O00000Oo;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public O000000o(O00000o o00000o, View view) {
                    super(view);
                    ixe.O00000o(o00000o, "this$0");
                    ixe.O00000o(view, "itemView");
                    this.f18724O000000o = o00000o;
                    this.O00000Oo = (OperationImageView) view.findViewById(R.id.operation);
                }

                public final void O000000o(hjr hjr, boolean z) {
                    ixe.O00000o(hjr, "operation");
                    hlr<List<hjr>> hlr = this.f18724O000000o.f18723O000000o.O00000Oo.f18718O000000o;
                    String str = hjr.O00000Oo;
                    ixe.O00000Oo(str, "operation.imgUrl");
                    OperationImageView operationImageView = this.O00000Oo;
                    ixe.O00000Oo(operationImageView, "operationIv");
                    hlr.O000000o(str, operationImageView);
                    this.O00000Oo.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: INVOKE  
                          (wrap: com.xiaomi.smarthome.operation.view.OperationImageView : 0x0020: IGET  (r0v5 com.xiaomi.smarthome.operation.view.OperationImageView) = (r4v0 'this' _m_j.hay$O00000Oo$O00000o$O000000o A[THIS]) _m_j.hay.O00000Oo.O00000o.O000000o.O00000Oo com.xiaomi.smarthome.operation.view.OperationImageView)
                          (wrap: _m_j.-$$Lambda$hay$O00000Oo$O00000o$O000000o$cpItXglWr9O03NsO3d9kedJRyXo : 0x0024: CONSTRUCTOR  (r1v1 _m_j.-$$Lambda$hay$O00000Oo$O00000o$O000000o$cpItXglWr9O03NsO3d9kedJRyXo) = (r5v0 'hjr' _m_j.hjr), (r6v0 'z' boolean) call: _m_j.-$$Lambda$hay$O00000Oo$O00000o$O000000o$cpItXglWr9O03NsO3d9kedJRyXo.<init>(_m_j.hjr, boolean):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.xiaomi.smarthome.operation.view.OperationImageView.setOnClickListener(android.view.View$OnClickListener):void in method: _m_j.hay.O00000Oo.O00000o.O000000o.O000000o(_m_j.hjr, boolean):void, dex: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: CONSTRUCTOR  (r1v1 _m_j.-$$Lambda$hay$O00000Oo$O00000o$O000000o$cpItXglWr9O03NsO3d9kedJRyXo) = (r5v0 'hjr' _m_j.hjr), (r6v0 'z' boolean) call: _m_j.-$$Lambda$hay$O00000Oo$O00000o$O000000o$cpItXglWr9O03NsO3d9kedJRyXo.<init>(_m_j.hjr, boolean):void type: CONSTRUCTOR in method: _m_j.hay.O00000Oo.O00000o.O000000o.O000000o(_m_j.hjr, boolean):void, dex: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 79 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$hay$O00000Oo$O00000o$O000000o$cpItXglWr9O03NsO3d9kedJRyXo, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 85 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "operation"
                        _m_j.ixe.O00000o(r5, r0)
                        _m_j.hay$O00000Oo$O00000o r0 = r4.f18724O000000o
                        _m_j.hay$O00000Oo r0 = r0.f18723O000000o
                        _m_j.hay r0 = r0.O00000Oo
                        _m_j.hlr<java.util.List<_m_j.hjr>> r0 = r0.f18718O000000o
                        java.lang.String r1 = r5.O00000Oo
                        java.lang.String r2 = "operation.imgUrl"
                        _m_j.ixe.O00000Oo(r1, r2)
                        com.xiaomi.smarthome.operation.view.OperationImageView r2 = r4.O00000Oo
                        java.lang.String r3 = "operationIv"
                        _m_j.ixe.O00000Oo(r2, r3)
                        com.facebook.drawee.view.SimpleDraweeView r2 = (com.facebook.drawee.view.SimpleDraweeView) r2
                        r0.O000000o(r1, r2)
                        com.xiaomi.smarthome.operation.view.OperationImageView r0 = r4.O00000Oo
                        _m_j.-$$Lambda$hay$O00000Oo$O00000o$O000000o$cpItXglWr9O03NsO3d9kedJRyXo r1 = new _m_j.-$$Lambda$hay$O00000Oo$O00000o$O000000o$cpItXglWr9O03NsO3d9kedJRyXo
                        r1.<init>(r5, r6)
                        r0.setOnClickListener(r1)
                        com.xiaomi.smarthome.operation.view.OperationImageView r0 = r4.O00000Oo
                        _m_j.hay$O00000Oo$O00000o$O000000o$O000000o r1 = new _m_j.hay$O00000Oo$O00000o$O000000o$O000000o
                        r1.<init>(r5, r6)
                        com.xiaomi.smarthome.operation.view.OperationImageView$O000000o r1 = (com.xiaomi.smarthome.operation.view.OperationImageView.O000000o) r1
                        r0.registerOnVisibleToUser(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: _m_j.hay.O00000Oo.O00000o.O000000o.O000000o(_m_j.hjr, boolean):void");
                }

                /* access modifiers changed from: private */
                public static final void O000000o(hjr hjr, boolean z, View view) {
                    hjr hjr2 = hjr;
                    ixe.O00000o(hjr2, "$operation");
                    hjo.O000000o(hjr);
                    hxi.O00000o.O00000oo(hjr2.O00000o);
                    if (z) {
                        hxk hxk = hxi.O00000o;
                        String str = hjr2.O00000o;
                        String str2 = hjr2.O0000o0O;
                        String str3 = hjr2.O00000o0;
                        String str4 = hjr2.O0000o0o;
                        hxk.f952O000000o.O000000o("home_nodevice_left_ad_click", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4);
                        return;
                    }
                    hxk hxk2 = hxi.O00000o;
                    String str5 = hjr2.O00000o;
                    String str6 = hjr2.O0000o0O;
                    String str7 = hjr2.O00000o0;
                    String str8 = hjr2.O0000o0o;
                    hxk2.f952O000000o.O000000o("home_nodevice_right_ad_click", "link", str5, "asset_id", str6, "asset_name", str7, "exp_id", str8);
                }

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/adapter/DeviceMainAdAdapter$ViewHolder$SmallAdAdapter$VH$bind$2", "Lcom/xiaomi/smarthome/operation/view/OperationImageView$IOnVisible;", "onVisible", "", "view", "Landroid/view/View;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                /* renamed from: _m_j.hay$O00000Oo$O00000o$O000000o$O000000o  reason: collision with other inner class name */
                public static final class C0113O000000o implements OperationImageView.O000000o {

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ hjr f18725O000000o;
                    final /* synthetic */ boolean O00000Oo;

                    C0113O000000o(hjr hjr, boolean z) {
                        this.f18725O000000o = hjr;
                        this.O00000Oo = z;
                    }

                    public final void onVisible(View view) {
                        ixe.O00000o(view, "view");
                        hxi.O00000oO.O000000o(this.f18725O000000o.O00000o);
                        if (this.O00000Oo) {
                            hxm hxm = hxi.O0000o00;
                            String str = this.f18725O000000o.O00000o;
                            String str2 = this.f18725O000000o.O0000o0O;
                            String str3 = this.f18725O000000o.O00000o0;
                            String str4 = this.f18725O000000o.O0000o0o;
                            hxm.f954O000000o.O000000o("home_nodevice_left_ad_expose", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4);
                            return;
                        }
                        hxm hxm2 = hxi.O0000o00;
                        String str5 = this.f18725O000000o.O00000o;
                        String str6 = this.f18725O000000o.O0000o0O;
                        String str7 = this.f18725O000000o.O00000o0;
                        String str8 = this.f18725O000000o.O0000o0o;
                        hxm2.f954O000000o.O000000o("home_nodevice_right_ad_expose", "link", str5, "asset_id", str6, "asset_name", str7, "exp_id", str8);
                    }
                }
            }
        }
    }
}
