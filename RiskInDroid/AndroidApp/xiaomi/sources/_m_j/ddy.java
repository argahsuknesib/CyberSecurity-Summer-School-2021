package _m_j;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.smarthome.uwb.ui.widget.StaticMultiFilterMenu$getViewAndResult$1$1;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.widget.FlowLayoutCopy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0006\f\r\u000e\u000f\u0010\u0011B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu;", "", "menus", "", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FlexFilterMenu;", "(Ljava/util/List;)V", "getViewAndResult", "Lkotlin/Pair;", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$PendingResult;", "Landroid/view/View;", "context", "Landroid/content/Context;", "FilterResult", "FlexFilterMenu", "Item", "MenuAdapter", "PendingResult", "TitleAdapter", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ddy {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<O00000Oo> f14530O000000o;

    public ddy(List<O00000Oo> list) {
        ixe.O00000o(list, "menus");
        this.f14530O000000o = list;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$PendingResult;", "", "adapter", "Lcom/xiaomi/smarthome/multi_item/DelegateAdapter;", "(Lcom/xiaomi/smarthome/multi_item/DelegateAdapter;)V", "getFilters", "", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FilterResult;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final gzl f14536O000000o;

        public O0000O0o(gzl gzl) {
            ixe.O00000o(gzl, "adapter");
            this.f14536O000000o = gzl;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final Pair<O0000O0o, View> O000000o(Context context) {
        ixe.O00000o(context, "context");
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.filter_container, (ViewGroup) null, false);
        if (inflate != null) {
            RecyclerView recyclerView = (RecyclerView) inflate;
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(new StaticMultiFilterMenu$getViewAndResult$1$1(context));
            go goVar = new go();
            goVar.O0000o00 = false;
            iuh iuh = iuh.f1631O000000o;
            recyclerView.setItemAnimator(goVar);
            gzl gzl = new gzl();
            for (O00000Oo next : this.f14530O000000o) {
                gzl.O000000o(new O0000OOo(next.f14532O000000o));
                gzl.O000000o(new O00000o(next));
            }
            recyclerView.setAdapter(gzl);
            return new Pair<>(new O0000O0o(gzl), recyclerView);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$TitleAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "title", "", "(Ljava/lang/String;)V", "getItemCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "pos", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O0000OOo extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        private final String f14537O000000o;

        public final int getItemCount() {
            return 1;
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "vh");
        }

        public O0000OOo(String str) {
            ixe.O00000o(str, "title");
            this.f14537O000000o = str;
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            TextView textView = new TextView(viewGroup.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            textView.setText(this.f14537O000000o);
            textView.setTextColor(viewGroup.getResources().getColor(R.color.mj_color_black));
            textView.setTextSize(16.0f);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            return new O000000o(this, textView);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$TitleAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$TitleAdapter;Landroid/view/View;)V", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O0000OOo f14538O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O0000OOo o0000OOo, View view) {
                super(view);
                ixe.O00000o(o0000OOo, "this$0");
                ixe.O00000o(view, "itemView");
                this.f14538O000000o = o0000OOo;
            }
        }

        public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            ixe.O00000o(rect, "outRect");
            ixe.O00000o(view, "view");
            rect.left = gpc.O000000o(view.getContext(), 27.0f);
            rect.top = gpc.O000000o(view.getContext(), 17.0f);
            rect.bottom = gpc.O000000o(view.getContext(), 17.0f);
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J4\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$MenuAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "menu", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FlexFilterMenu;", "(Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FlexFilterMenu;)V", "chooses", "", "", "getFilterResult", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FilterResult;", "getItemCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "Landroid/view/ViewGroup;", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        public final O00000Oo f14533O000000o;
        public final Set<String> O00000Oo = new LinkedHashSet();

        public final int getItemCount() {
            return 1;
        }

        public O00000o(O00000Oo o00000Oo) {
            ixe.O00000o(o00000Oo, "menu");
            this.f14533O000000o = o00000Oo;
            this.O00000Oo.addAll(this.f14533O000000o.O00000o);
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            return new O000000o(this, new FlowLayoutCopy(viewGroup.getContext()));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "vh");
            ((O000000o) o000OOo0).O000000o();
        }

        public final O000000o f_() {
            String str = this.f14533O000000o.O00000Oo;
            Collection arrayList = new ArrayList();
            for (Object next : this.f14533O000000o.O00000o0) {
                if (this.O00000Oo.contains(((O00000o0) next).f14535O000000o)) {
                    arrayList.add(next);
                }
            }
            return new O000000o(str, (List) arrayList);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$MenuAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$MenuAdapter;Landroid/view/View;)V", "bind", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000o f14534O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000o o00000o, View view) {
                super(view);
                ixe.O00000o(o00000o, "this$0");
                ixe.O00000o(view, "itemView");
                this.f14534O000000o = o00000o;
                FlowLayoutCopy flowLayoutCopy = (FlowLayoutCopy) view;
                flowLayoutCopy.setSingleLine(false);
                flowLayoutCopy.setItemSpacing(gpc.O000000o(flowLayoutCopy.getContext(), 10.0f));
                flowLayoutCopy.setLineSpacing(gpc.O000000o(flowLayoutCopy.getContext(), 10.0f));
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final void O000000o() {
                ((FlowLayoutCopy) this.itemView).removeAllViews();
                for (O00000o0 next : this.f14534O000000o.f14533O000000o.O00000o0) {
                    View inflate = LayoutInflater.from(((FlowLayoutCopy) this.itemView).getContext()).inflate((int) R.layout.filter_item, (ViewGroup) this.itemView, false);
                    ((FlowLayoutCopy) this.itemView).addView(inflate);
                    if (inflate != null) {
                        TextView textView = (TextView) inflate;
                        textView.setText(next.O00000Oo);
                        textView.setSelected(this.f14534O000000o.O00000Oo.contains(next.f14535O000000o));
                        inflate.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005c: INVOKE  
                              (r2v4 'inflate' android.view.View)
                              (wrap: _m_j.-$$Lambda$ddy$O00000o$O000000o$YiAQPW-CVdMsUmwTg6HVq4KdwQE : 0x0059: CONSTRUCTOR  (r4v7 _m_j.-$$Lambda$ddy$O00000o$O000000o$YiAQPW-CVdMsUmwTg6HVq4KdwQE) = 
                              (wrap: _m_j.ddy$O00000o : 0x0055: IGET  (r3v5 _m_j.ddy$O00000o) = (r6v0 'this' _m_j.ddy$O00000o$O000000o A[THIS]) _m_j.ddy.O00000o.O000000o.O000000o _m_j.ddy$O00000o)
                              (r1v2 'next' _m_j.ddy$O00000o0)
                              (r2v4 'inflate' android.view.View)
                             call: _m_j.-$$Lambda$ddy$O00000o$O000000o$YiAQPW-CVdMsUmwTg6HVq4KdwQE.<init>(_m_j.ddy$O00000o, _m_j.ddy$O00000o0, android.view.View):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: _m_j.ddy.O00000o.O000000o.O000000o():void, dex: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:233)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
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
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0059: CONSTRUCTOR  (r4v7 _m_j.-$$Lambda$ddy$O00000o$O000000o$YiAQPW-CVdMsUmwTg6HVq4KdwQE) = 
                              (wrap: _m_j.ddy$O00000o : 0x0055: IGET  (r3v5 _m_j.ddy$O00000o) = (r6v0 'this' _m_j.ddy$O00000o$O000000o A[THIS]) _m_j.ddy.O00000o.O000000o.O000000o _m_j.ddy$O00000o)
                              (r1v2 'next' _m_j.ddy$O00000o0)
                              (r2v4 'inflate' android.view.View)
                             call: _m_j.-$$Lambda$ddy$O00000o$O000000o$YiAQPW-CVdMsUmwTg6HVq4KdwQE.<init>(_m_j.ddy$O00000o, _m_j.ddy$O00000o0, android.view.View):void type: CONSTRUCTOR in method: _m_j.ddy.O00000o.O000000o.O000000o():void, dex: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 73 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$ddy$O00000o$O000000o$YiAQPW-CVdMsUmwTg6HVq4KdwQE, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 79 more
                            */
                        /*
                            this = this;
                            android.view.View r0 = r6.itemView
                            com.xiaomi.smarthome.newui.widget.FlowLayoutCopy r0 = (com.xiaomi.smarthome.newui.widget.FlowLayoutCopy) r0
                            r0.removeAllViews()
                            _m_j.ddy$O00000o r0 = r6.f14534O000000o
                            _m_j.ddy$O00000Oo r0 = r0.f14533O000000o
                            java.util.List<_m_j.ddy$O00000o0> r0 = r0.O00000o0
                            java.util.Iterator r0 = r0.iterator()
                        L_0x0011:
                            boolean r1 = r0.hasNext()
                            if (r1 == 0) goto L_0x0068
                            java.lang.Object r1 = r0.next()
                            _m_j.ddy$O00000o0 r1 = (_m_j.ddy.O00000o0) r1
                            android.view.View r2 = r6.itemView
                            com.xiaomi.smarthome.newui.widget.FlowLayoutCopy r2 = (com.xiaomi.smarthome.newui.widget.FlowLayoutCopy) r2
                            android.content.Context r2 = r2.getContext()
                            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
                            r3 = 2132345638(0x7f190326, float:2.0338823E38)
                            android.view.View r4 = r6.itemView
                            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
                            r5 = 0
                            android.view.View r2 = r2.inflate(r3, r4, r5)
                            android.view.View r3 = r6.itemView
                            com.xiaomi.smarthome.newui.widget.FlowLayoutCopy r3 = (com.xiaomi.smarthome.newui.widget.FlowLayoutCopy) r3
                            r3.addView(r2)
                            if (r2 == 0) goto L_0x0060
                            r3 = r2
                            android.widget.TextView r3 = (android.widget.TextView) r3
                            java.lang.String r4 = r1.O00000Oo
                            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                            r3.setText(r4)
                            _m_j.ddy$O00000o r4 = r6.f14534O000000o
                            java.util.Set<java.lang.String> r4 = r4.O00000Oo
                            java.lang.String r5 = r1.f14535O000000o
                            boolean r4 = r4.contains(r5)
                            r3.setSelected(r4)
                            _m_j.ddy$O00000o r3 = r6.f14534O000000o
                            _m_j.-$$Lambda$ddy$O00000o$O000000o$YiAQPW-CVdMsUmwTg6HVq4KdwQE r4 = new _m_j.-$$Lambda$ddy$O00000o$O000000o$YiAQPW-CVdMsUmwTg6HVq4KdwQE
                            r4.<init>(r3, r1, r2)
                            r2.setOnClickListener(r4)
                            goto L_0x0011
                        L_0x0060:
                            java.lang.NullPointerException r0 = new java.lang.NullPointerException
                            java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
                            r0.<init>(r1)
                            throw r0
                        L_0x0068:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: _m_j.ddy.O00000o.O000000o.O000000o():void");
                    }

                    /* access modifiers changed from: private */
                    public static final void O000000o(O00000o o00000o, O00000o0 o00000o0, View view, View view2) {
                        ixe.O00000o(o00000o, "this$0");
                        ixe.O00000o(o00000o0, "$item");
                        if (o00000o.O00000Oo.contains(o00000o0.f14535O000000o)) {
                            o00000o.O00000Oo.remove(o00000o0.f14535O000000o);
                        } else {
                            o00000o.O00000Oo.add(o00000o0.f14535O000000o);
                        }
                        ((TextView) view).setSelected(o00000o.O00000Oo.contains(o00000o0.f14535O000000o));
                    }
                }

                public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
                    ixe.O00000o(rect, "outRect");
                    ixe.O00000o(view, "view");
                    rect.left = gpc.O000000o(view.getContext(), 27.0f);
                    rect.right = gpc.O000000o(view.getContext(), 27.0f);
                    rect.top = gpc.O000000o(view.getContext(), 17.0f);
                    rect.bottom = gpc.O000000o(view.getContext(), 17.0f);
                }
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FlexFilterMenu;", "", "title", "", "type", "multi", "", "items", "", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$Item;", "selected", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getMulti", "()Z", "getSelected", "getTitle", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class O00000Oo {

                /* renamed from: O000000o  reason: collision with root package name */
                final String f14532O000000o;
                final String O00000Oo;
                final List<String> O00000o;
                final List<O00000o0> O00000o0;
                private final boolean O00000oO;

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof O00000Oo)) {
                        return false;
                    }
                    O00000Oo o00000Oo = (O00000Oo) obj;
                    return ixe.O000000o(this.f14532O000000o, o00000Oo.f14532O000000o) && ixe.O000000o(this.O00000Oo, o00000Oo.O00000Oo) && this.O00000oO == o00000Oo.O00000oO && ixe.O000000o(this.O00000o0, o00000Oo.O00000o0) && ixe.O000000o(this.O00000o, o00000Oo.O00000o);
                }

                public final int hashCode() {
                    int hashCode = ((this.f14532O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31;
                    boolean z = this.O00000oO;
                    if (z) {
                        z = true;
                    }
                    return ((((hashCode + (z ? 1 : 0)) * 31) + this.O00000o0.hashCode()) * 31) + this.O00000o.hashCode();
                }

                public final String toString() {
                    return "FlexFilterMenu(title=" + this.f14532O000000o + ", type=" + this.O00000Oo + ", multi=" + this.O00000oO + ", items=" + this.O00000o0 + ", selected=" + this.O00000o + ')';
                }

                private O00000Oo(String str, String str2, boolean z, List<O00000o0> list, List<String> list2) {
                    ixe.O00000o(str, "title");
                    ixe.O00000o(str2, "type");
                    ixe.O00000o(list, "items");
                    ixe.O00000o(list2, "selected");
                    this.f14532O000000o = str;
                    this.O00000Oo = str2;
                    this.O00000oO = true;
                    this.O00000o0 = list;
                    this.O00000o = list2;
                }

                public /* synthetic */ O00000Oo(String str, List list, List list2) {
                    this(str, str, true, list, list2);
                }
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FilterResult;", "", "type", "", "choose", "", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$Item;", "(Ljava/lang/String;Ljava/util/List;)V", "getChoose", "()Ljava/util/List;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class O000000o {

                /* renamed from: O000000o  reason: collision with root package name */
                public final List<O00000o0> f14531O000000o;
                private final String O00000Oo;

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof O000000o)) {
                        return false;
                    }
                    O000000o o000000o = (O000000o) obj;
                    return ixe.O000000o(this.O00000Oo, o000000o.O00000Oo) && ixe.O000000o(this.f14531O000000o, o000000o.f14531O000000o);
                }

                public final int hashCode() {
                    return (this.O00000Oo.hashCode() * 31) + this.f14531O000000o.hashCode();
                }

                public final String toString() {
                    return "FilterResult(type=" + this.O00000Oo + ", choose=" + this.f14531O000000o + ')';
                }

                public O000000o(String str, List<O00000o0> list) {
                    ixe.O00000o(str, "type");
                    ixe.O00000o(list, "choose");
                    this.O00000Oo = str;
                    this.f14531O000000o = list;
                }
            }

            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$Item;", "", "id", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class O00000o0 {

                /* renamed from: O000000o  reason: collision with root package name */
                public final String f14535O000000o;
                final String O00000Oo;

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof O00000o0)) {
                        return false;
                    }
                    O00000o0 o00000o0 = (O00000o0) obj;
                    return ixe.O000000o(this.f14535O000000o, o00000o0.f14535O000000o) && ixe.O000000o(this.O00000Oo, o00000o0.O00000Oo);
                }

                public final int hashCode() {
                    return (this.f14535O000000o.hashCode() * 31) + this.O00000Oo.hashCode();
                }

                public final String toString() {
                    return "Item(id=" + this.f14535O000000o + ", title=" + this.O00000Oo + ')';
                }

                public O00000o0(String str, String str2) {
                    ixe.O00000o(str, "id");
                    ixe.O00000o(str2, "title");
                    this.f14535O000000o = str;
                    this.O00000Oo = str2;
                }
            }
        }
